package edu.wctc.servlet;

import edu.wctc.entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet2", urlPatterns = "/search2")
public class SearchServlet2 extends HttpServlet {
    private final String DATABASE_PATH = "../../db";
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String USERNAME = "nnguyen1";
    private final String PASSWORD = "nnguyen1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String searchTerm = request.getParameter("searchTerm");

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            String sql = "select * from KAYLA.MOVIE where movie_nm = ?";

            // create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            // create a statement to execute SQL
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, searchTerm);
            // execute a SELECT query and get a result set
            rset = pstmt.executeQuery();

            List<Movie> result = new ArrayList<Movie>();

            while(rset.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rset.getInt(1));
                movie.setName(rset.getString(2));
                movie.setOverview(rset.getString(3));
                movie.setYear(rset.getInt(4));
                result.add(movie);
            }

            request.setAttribute("movies", result);
            request.getRequestDispatcher("search2.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            closeAll(conn, pstmt, rset);
        }
    }

    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rset) {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

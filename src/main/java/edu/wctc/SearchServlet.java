package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private final String DATABASE_PATH = "../../db";
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String USERNAME = "nnguyen1";
    private final String PASSWORD = "nnguyen1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        String searchTerm = request.getParameter("searchTerm");

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            String sql = "select movie_nm, overview, \"YEAR\" from KAYLA.MOVIE where movie_nm = ?";

            // create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            // create a statement to execute SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, searchTerm);
            // execute a SELECT query and get a result set
            rset = stmt.executeQuery();

            StringBuilder output = new StringBuilder("<html><body><table>");
            output.append("<tr><th>Name</th><th>Overview</th><th>Year</th></tr>");

            while(rset.next()) {
                output.append("<tr>");

                String movieName = rset.getString("movie_nm");
                output.append("<td>" + movieName + "</td>");

                String overview = rset.getString("overview");
                output.append("<td>" + overview + "</td>");

                int year = rset.getInt("year");
                output.append("<td>" + year + "</td>");

                output.append("</tr>");
            }

            output.append("</table></body></html>");

            // send the html as the response
            response.setContentType("text/html");
            response.getWriter().print(output.toString());
        } catch (ClassNotFoundException | SQLException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            closeAll(conn, stmt, rset);
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rset) {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
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

package edu.wctc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    private final String DATABASE_PATH = "../../db";
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String USERNAME = "nnguyen1";
    private final String PASSWORD = "nnguyen1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + DATABASE_PATH;

            //StringBuilder sql = new StringBuilder("Select movie_nm from movie ");
            //sql.append("ORDER BY movie_nm");

            // create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
            // create a statement to execute SQL
            stmt = conn.createStatement();
            // execute a SELECT query and get a result set
            rset = stmt.executeQuery("Select movie_nm, \"YEAR\" from KAYLA.MOVIE order by movie_nm");

            StringBuilder output = new StringBuilder("<html><body><ul>");

            while(rset.next()) {
                output.append("<li>");
                String movieName = rset.getString("movie_nm");
                int year = rset.getInt("year");
                output.append(movieName + " - " + year);
                output.append("</li>");
            }

            output.append("</ul></body></html>");

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

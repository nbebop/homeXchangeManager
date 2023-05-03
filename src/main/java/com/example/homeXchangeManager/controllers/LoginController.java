package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

@Controller
    public class LoginController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/homexchangemanager";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin";

    public void handleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isValidUser(email, password)) {
            // Redirect to index.html if email and password are valid
            response.sendRedirect("index.html");
        } else {
            // Display an error message if email or password is incorrect
            request.setAttribute("errorMessage", "Incorrect email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean isValidUser(String email, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement to query user by email and password
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            // Execute query and check if result set is not empty
            rs = stmt.executeQuery();
            return rs.next();
        } finally {
            // Close resources
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}

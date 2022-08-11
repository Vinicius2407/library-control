package com.example.library.servlet;//package com.example.library.servlet;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//
//@WebServlet(name = "Servlet", value = "/servlet")
//public class Servlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.library.connectionDatabase.*;
public class Servlet {

    public static void main(String[] args) {

        //ConnectionFactory factory = new ConnectionFactory();
        Connection conn = (Connection) ConnectionFactory.getConnection();

        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM author");
            ResultSet author = stmt.executeQuery();

            while(author.next()) {
                Integer id = author.getInt("id");
                String name = author.getString("name");

                System.out.println(id + ": " + name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

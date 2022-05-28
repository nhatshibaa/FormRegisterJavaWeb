package com.example.javawebday1.controller;

import com.example.javawebday1.entity.Phone;
import com.example.javawebday1.model.IPhone;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class AddPhoneServlet extends HttpServlet {
    private IPhone iPhone;

//    public AddPhoneServlet(IPhone iPhone) {
//        this.iPhone = iPhone;
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("phone", new Phone());
        request.setAttribute("action", 1);
        request.getRequestDispatcher("/addphone.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        Phone phone = new Phone(id, name, brand, price, description);
        if (iPhone.save(phone) != null) {
            response.sendRedirect("/phone/list");
        } else {
            request.getRequestDispatcher("/addphone.jsp").forward(request, response);
        }
    }
}

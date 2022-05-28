package com.example.javawebday1.controller;

import com.example.javawebday1.entity.Phone;
import com.example.javawebday1.model.IPhone;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListPhoneServlet extends HttpServlet {
    private IPhone iPhone;

//    public ListPhoneServlet(IPhone iPhone) {
//        this.iPhone = iPhone;
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> phoneList = iPhone.findAll();
        request.setAttribute("listphone", phoneList);
        request.getRequestDispatcher("/listphone.jsp").forward(request, response);
    }
}

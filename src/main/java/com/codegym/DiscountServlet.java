package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DiscountServlet", urlPatterns = {"/display-discount"})
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Đọc dữ liệu từ form gửi lên
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discountPercent = Float.parseFloat(request.getParameter("discount_percent"));

        float discountAmount = price * discountPercent * 0.01f;
        float discountPrice = price - discountAmount;

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Product Discount Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Arial', sans-serif; display: flex; justify-content: center; margin-top: 80px; background-color: #f8fafc; }");
            out.println(".result-container { background: white; padding: 30px 40px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 380px; }");
            out.println("h2 { color: #1b2a7a; text-align: center; }");
            out.println("p { font-size: 16px; color: #333; margin: 12px 0; }");
            out.println("span { font-weight: bold; color: #27ae60; }");
            out.println("a { display: block; text-align: center; margin-top: 20px; text-decoration: none; padding: 10px; background-color: #1b2a7a; color: white; border-radius: 4px; font-weight: bold; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='result-container'>");
            out.println("<h2>Discount Result</h2>");
            out.println("<p>Product Description: <span>" + description + "</span></p>");
            out.println("<p>List Price: <span>$" + price + "</span></p>");
            out.println("<p>Discount Percent: <span>" + discountPercent + "%</span></p>");
            out.println("<p>Discount Amount: <span>$" + discountAmount + "</span></p>");
            out.println("<p>Discount Price: <span>$" + discountPrice + "</span></p>");
            out.println("<a href='index.jsp'>Back</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
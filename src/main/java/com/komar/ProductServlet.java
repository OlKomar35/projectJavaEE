package com.komar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ArrayList<Product> listProduct=new ArrayList<>();
    private int id = 0;

    @Override
    public void init() throws ServletException {
        listProduct.add(new Product(id++, "Bananas", 2));
        listProduct.add(new Product(id++, "Grape", 3));
        listProduct.add(new Product(id++, "Oranges", 2));
        listProduct.add(new Product(id++, "Lemons", 1));
        listProduct.add(new Product(id++, "Apples", 1));
        listProduct.add(new Product(id++, "Plums", 1));
        listProduct.add(new Product(id++, "Pineapples", 5));
        listProduct.add(new Product(id++, "Kiwis", 2));
        listProduct.add(new Product(id++, "Peaches", 3));
        listProduct.add(new Product(id++, "Tangerines", 6));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();

        pw.printf("<html>");
        pw.printf("<head><title>Product</title>");
        pw.printf("<style>TD{ border: 1px solid #000 } </style>");
        pw.printf("<body>");
        pw.printf("<h2 align=\"center\">Products list</h2>");
        pw.printf("<table style=\"border: 1px solid #000 \">"
                + "<tr>"
                + "<td>id</td>"
                + "<td>title</td>"
                + "<td>cost</td>"
                + "</tr>");
        for (int i = 0; i < listProduct.size(); i++) {
         pw.printf( "<tr>"
                    +"<td>"+listProduct.get(i).getId()+"</td>"
                    + "<td>"+listProduct.get(i).getTitle()+"</td>"
                    + "<td>"+listProduct.get(i).getCost()+"</td>"
                    + "</tr>"
                    + "<tr>");
        }
        pw.printf( "</table>");
        pw.printf("</body></html>");
        pw.close();
    }
}

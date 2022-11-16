package servlets;

import dao.ApprenantDao;
import dao.FormateurDao;
import entity.Apprenant;
import entity.Formateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ApprenantServlet", value = "/ApprenantServlet")
public class ApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
           ApprenantDao apprenantDao= new ApprenantDao();
            //PromoDao promoDo = new PromoDao();

            Apprenant selectedApprenant = apprenantDao.findbyId(Integer.parseInt(request.getParameter("id")));
            //List<Promos> nullPromos = promoDo.getAllNulls();

            request.setAttribute("selectedApprenant", selectedApprenant);
            //request.setAttribute("nullPromos", nullPromos);

            request.getRequestDispatcher("updateApprenant.jsp").forward(request, response);
        }
    }
}

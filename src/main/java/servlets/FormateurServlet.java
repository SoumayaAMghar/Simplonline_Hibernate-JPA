package servlets;

import dao.FormateurDao;
import dao.PromoDao;
import entity.Formateur;
import entity.Promos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FormateurServlet", value = "/FormateurServlet")
public class FormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
            FormateurDao formateurDao= new FormateurDao();
            //PromoDao promoDo = new PromoDao();

            Formateur selectedFormateur = formateurDao.findbyId(Integer.parseInt(request.getParameter("id")));
            //List<Promos> nullPromos = promoDo.getAllNulls();

            request.setAttribute("selectedFormateur", selectedFormateur);
            //request.setAttribute("nullPromos", nullPromos);

            request.getRequestDispatcher("updateFormateur.jsp").forward(request, response);
        }
    }
}

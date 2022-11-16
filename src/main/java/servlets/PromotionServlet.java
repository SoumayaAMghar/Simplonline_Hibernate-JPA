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

@WebServlet(name = "PromotionServlet", value = "/PromotionServlet")
public class PromotionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
            FormateurDao formateurDao = new FormateurDao();
            List<Formateur> formateurList = formateurDao.getAll();
            request.setAttribute("formateurList",formateurList);

            PromoDao promoDao= new PromoDao();
            Promos selectedPromo = promoDao.findbyId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("selectedPromo", selectedPromo);
            request.getRequestDispatcher("updatePromotion.jsp").forward(request, response);
        }
    }
}

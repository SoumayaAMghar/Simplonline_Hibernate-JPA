package services;

import dao.*;
import entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


public class AdminServices{

    public static void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ;

        if (email == null || password == null){
            response.sendRedirect(".././loginAdmin.jsp");
            return;
        }

        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.login(email, password);

        if(admin == null) {
//            System.out.println("Password incorrect");
            response.sendRedirect(".././loginAdmin.jsp");
            return;
        }

        session.setAttribute("auth", email);
        DisplayDashboardAdmin(request, response);
    }

    public static void DisplayFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FormateurDao formateurDao = new FormateurDao();
        List<Formateur> formateurList = formateurDao.getAll();
        request.setAttribute("formateurList",formateurList);

        request.getRequestDispatcher(".././formateur.jsp").forward(request, response);
    }
    public static void DisplayApprenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApprenantDao apprenantDao = new ApprenantDao();
        List<Apprenant> apprenantList = apprenantDao.getAll();
        request.setAttribute("apprenantList",apprenantList);

        PromostoapprenantDao promostoapprenantDao = new PromostoapprenantDao();
        List<Promostoapprenant> promostoapprenantList=promostoapprenantDao.getAll();
        request.setAttribute("promostoapprenantList",promostoapprenantList);

        request.getRequestDispatcher(".././apprenant.jsp").forward(request, response);
    }
    public static void DisplayPromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PromoDao promoDao = new PromoDao();
        List<Promos> promoList = promoDao.getAll();
        request.setAttribute("promoList", promoList);

        request.getRequestDispatcher(".././promotion.jsp").forward(request, response);
    }
    public static void DeleteFormateur(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    FormateurDao formateurDao = new FormateurDao();
    formateurDao.deleteByID(Integer.parseInt(request.getParameter("id")));
//        response.sendRedirect("/CrudFormateur/displayFormateur");
        DisplayFormateur(request, response);
    }
    public static void DeleteApprenant(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ApprenantDao apprenantDao = new ApprenantDao();
        apprenantDao.deleteByID(Integer.parseInt(request.getParameter("id")));
        DisplayApprenant(request, response);
    }
    public static void DeletePromotion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PromoDao promoDaoDao = new PromoDao();
        promoDaoDao.deleteByID(Integer.parseInt(request.getParameter("id")));
        DisplayPromotion(request, response);
    }
    public static void UpdateFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Formateur newFormateur = new Formateur();
        newFormateur.setFirstname(request.getParameter("firstname"));
        newFormateur.setLastname(request.getParameter("lastname"));
        newFormateur.setEmail(request.getParameter("email"));
        newFormateur.setPassword(request.getParameter("password"));
        newFormateur.setId(Integer.parseInt(request.getParameter("id")));

        FormateurDao formateurDao= new FormateurDao();
        formateurDao.update(newFormateur);

        DisplayFormateur(request, response);
    }
    public static void UpdateApprenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Apprenant newApprenant = new Apprenant();
        newApprenant.setFirstname(request.getParameter("firstname"));
        newApprenant.setLastname(request.getParameter("lastname"));
        newApprenant.setEmail(request.getParameter("email"));
        newApprenant.setPassword(request.getParameter("password"));
        newApprenant.setId(Integer.parseInt(request.getParameter("id")));

        ApprenantDao apprenantDao= new ApprenantDao();
        apprenantDao.update(newApprenant);

        DisplayApprenant(request, response);
    }
    public static void UpdatePromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Promos newPromo = new Promos();
        newPromo.setName(request.getParameter("name"));
        newPromo.setFormateurId(Integer.parseInt(request.getParameter("formateurId")));
        newPromo.setId(Integer.parseInt(request.getParameter("id")));

        PromoDao promoDao= new PromoDao();
        promoDao.update(newPromo);

        DisplayPromotion(request, response);
    }
    public static void AddFormateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Formateur newFormateur = new Formateur();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        newFormateur.setFirstname(firstname);
        newFormateur.setLastname(lastname);
        newFormateur.setEmail(email);
        newFormateur.setPassword(password);

        FormateurDao formateurDoa = new FormateurDao();
        formateurDoa.add(newFormateur);
        DisplayFormateur(request, response);
    }
    public static void AddAppre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PromoDao promoDao = new PromoDao();
        List<Promos> promosList = promoDao.getAll();
        request.setAttribute("promosList",promosList);
        request.getRequestDispatcher(".././addApprenant.jsp").forward(request, response);
    }
    public static void AddApprenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Apprenant newApprenant = new Apprenant();

        Promostoapprenant pa = new Promostoapprenant();

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int promotion = Integer.parseInt(request.getParameter("promotion"));

        newApprenant.setFirstname(firstname);

        newApprenant.setLastname(lastname);

        newApprenant.setEmail(email);

        newApprenant.setPassword(password);

        ApprenantDao apprenantDao = new ApprenantDao();



        if(apprenantDao.add(newApprenant)){

            newApprenant.setId(apprenantDao.findEmail(newApprenant.getEmail()));

            int idApprenant = newApprenant.getId();

            pa.setPromoId(promotion);

            pa.setApprenantId(idApprenant);

            System.out.println(pa.getApprenantId());

            PromostoapprenantDao promostoapprenantDao = new PromostoapprenantDao();

            promostoapprenantDao.add(pa);
        }
        DisplayApprenant(request, response);
    }
    public static void AddPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FormateurDao formateurDao = new FormateurDao();

        List<Formateur> formateurList = formateurDao.getAll();

        request.setAttribute("formateurList",formateurList);

        request.getRequestDispatcher(".././addPromotion.jsp").forward(request, response);
    }
    public static void AddPromotion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Promos newPromo = new Promos();
        newPromo.setName(request.getParameter("name"));

        if(Integer.parseInt(request.getParameter("formateurId")) != 0) {
            newPromo.setFormateurId(Integer.parseInt(request.getParameter("formateurId")));
        }
        PromoDao promoDao = new PromoDao();
        promoDao.add(newPromo);
        DisplayPromotion(request, response);
    }
    public static void DisplayDashboardAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        AdminDao adminDao = new AdminDao();
        long nbOfApprenant = adminDao.nbOfApprenant();
        request.setAttribute("nbOfApprenant", nbOfApprenant);
        long nbOfFormateur = adminDao.nbOfFormateur();
        request.setAttribute("nbOfFormateur",nbOfFormateur);
        long nbOfPromotion = adminDao.nbOfPromotion();
        request.setAttribute("nbOfPromotion", nbOfPromotion);
        request.getRequestDispatcher(".././dashboardAdmin.jsp").forward(request, response);
    }


}

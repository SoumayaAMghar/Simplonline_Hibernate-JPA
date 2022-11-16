package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AdminServices;
import java.io.IOException;

@WebServlet({"/CrudFormateur/displayFormateur", "/CrudFormateur/deleteFormateur", "/CrudFormateur/addFormateur", "/CrudFormateur/updateFormateur","/CrudApprenant/displayApprenant","/CrudApprenant/deleteApprenant","/CrudApprenant/addApprenant","/CrudApprenant/addAppre","/CrudApprenant/updateApprenant","/CrudPromotion/displayPromotion","/CrudPromotion/addPromotion","/CrudPromotion/addPromo","/CrudPromotion/updatePromotion","/CrudPromotion/deletePromotion","/Admin/DashboardAdmin","/Admin/Login","/Admin/logout"})
@MultipartConfig
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        HttpSession session = request.getSession();
        switch (path){
            case "/Admin/login"->
            {
                System.out.println("hello AdminLogin");
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DisplayDashboardAdmin(request,response);
                }else {
                    System.out.println("Password incorrect");
                    response.sendRedirect(".././loginAdmin.jsp");
                }
            }
            case "/Admin/DashboardAdmin"->{
                System.out.println("hello");
                if(session.getAttribute("auth") == null)
                {
                    AdminServices.Login(request,response);
                }else {
                    AdminServices.DisplayDashboardAdmin(request, response);
                }
            }
            case "/CrudFormateur/displayFormateur"->{
                System.out.println("/CrudFormateur/displayFormateur");
                System.out.println(session.getAttribute("auth"));
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DisplayFormateur(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudApprenant/displayApprenant"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DisplayApprenant(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudPromotion/displayPromotion"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DisplayPromotion(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudPromotion/addPromo"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.AddPromo(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudApprenant/addAppre"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.AddAppre(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        switch (path){
            case "/Admin/login"->
            {
                System.out.println("hello Login");
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DisplayDashboardAdmin(request,response);
                }else {
                    response.sendRedirect(".././loginAdmin.jsp");
                }
            }
            case "/Admin/DashboardAdmin"->{
//                System.out.println("hello Admin/DashboardAdmin");
//                System.out.println(session.getAttribute("auth"));
                if(session.getAttribute("auth") == null)
                {
                    AdminServices.Login(request,response);
                }else {
                    AdminServices.DisplayDashboardAdmin(request, response);
                }
            }
            case "/CrudFormateur/addFormateur"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.AddFormateur(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudApprenant/addApprenant"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.AddApprenant(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudPromotion/addPromotion"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.AddPromotion(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudFormateur/updateFormateur"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.UpdateFormateur(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudApprenant/updateApprenant"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.UpdateApprenant(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudPromotion/updatePromotion"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.UpdatePromotion(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudFormateur/deleteFormateur"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DeleteFormateur(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudApprenant/deleteApprenant"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DeleteApprenant(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/CrudPromotion/deletePromotion"->{
                if(session.getAttribute("auth") != null)
                {
                    AdminServices.DeletePromotion(request,response);
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
            case "/Admin/logout"->
            {
                if(session.getAttribute("auth") != null)
                {
                    System.out.println("test");
                    session.removeAttribute("auth");
                    session.invalidate();
                    response.sendRedirect(".././index.jsp");
                }else {
                    response.sendRedirect(".././index.jsp");
                }
            }
        }
    }
}

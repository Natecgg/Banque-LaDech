/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.servlet;

import fr.dev13.dao.AdministrateurDao;
import fr.dev13.dao.ClientDao;
import fr.dev13.dao.ConseillerDao;
import fr.dev13.model.Admin;
import fr.dev13.model.Client;
import fr.dev13.model.Conseiller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ESIC
 */
@WebServlet(name = "MenuAccueilServlet", urlPatterns = {"/connexion"})
public class MenuAccueilServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MenuAccueilServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MenuAccueilServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login =request.getParameter("login");
        String mdp =request.getParameter("mdp");
        
        Client cl = null;
        try {   // on esssaie de trouver un client ayant le même login
            cl = ClientDao.getByLoginPass(login, mdp);           
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
        }
        
        if (cl!=null){ 
            request.getSession(true).setAttribute("client", cl);
            response.sendRedirect("espace_client");
        }
        else{ // si on n'a pas trouvé de client on essaie de trouver un conseiller
            
            Conseiller c = null;
            try {
               c = ConseillerDao.getByLoginPass(login, mdp);           
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.println(e.getMessage());
            }
            
            if (c!=null){ // si on n'a pas trouvé de conseiller on essaie de trouver un admin
                request.getSession(true).setAttribute("conseiller", cl);
                response.sendRedirect("espace_conseiller");
            } else {
                Admin a = null;
                try {
                     a = AdministrateurDao.getByLoginPass(login, mdp);           
                } catch (Exception e) {
                    PrintWriter out = response.getWriter();
                    out.println(e.getMessage());
                }
                
                if (a!=null){
                    request.getSession(true).setAttribute("admin", cl);
                    response.sendRedirect("espace_administrateur");
                } else{
                    request.setAttribute("msg", "Identifiant ou mot de passe incorrect");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    String test =  request.getContextPath();
                    System.out.println("test juste bvouveu " + test);
                }
            }  
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

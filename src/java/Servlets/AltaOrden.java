/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.GestorBD;
import Modelo.Ordenes;
import Modelo.Productos;
import Modelo.Responsables;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AltaOrden", urlPatterns = {"/AltaOrden"})
public class AltaOrden extends HttpServlet {
    
    

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
            out.println("<title>Servlet AltaOrden</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaOrden at " + request.getContextPath() + "</h1>");
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
        
        GestorBD g = new GestorBD();

        ArrayList<Productos> lista = g.obtenerProductos();
        request.setAttribute("Productos", lista);

        ArrayList<Responsables> listaResp = g.obtenerResponsables();
        request.setAttribute("Responsables", listaResp);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaOrden.jsp");
        rd.forward(request, response);
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
//        Productos p = new Productos();
//        p.setId(Integer.parseInt(request.getParameter("cmbProducto")));

        GestorBD g = new GestorBD();
        
        String idProducto = request.getParameter("cmbProducto");
        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));        
        double costoTotal = Double.parseDouble(request.getParameter("txtCostoTotal"));
        String idresponsable = request.getParameter("cmbResponsable");
        
        Productos p = g.obtenerTipoProductos(Integer.parseInt(idProducto));
        Responsables r = g.obtenerTipoResponsables(Integer.parseInt(idresponsable));
        g.agregarOrden(new Ordenes(p, cantidad, costoTotal, r));
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmacion.jsp");
        rd.forward(request, response);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.dao.ComputadorDaoLocal;
import com.model.Computador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ComputadorServlet extends HttpServlet {

    @EJB
    private ComputadorDaoLocal computadorDao;

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
        String action = request.getParameter("action");

        String computadorIdStr = request.getParameter("computadorId");
        int computadorId = 0;
        if (computadorIdStr != null && !computadorIdStr.equals("")) {
            computadorId = Integer.parseInt(computadorIdStr);
        }

        String board = request.getParameter("board");
        String procesador = request.getParameter("procesador");
        String gpu = request.getParameter("gpu");
        String memoria = request.getParameter("memoria");
        String monitor = request.getParameter("monitor");

        Computador computador = new Computador(computadorId, board, procesador, gpu, memoria, monitor);

        if ("Add".equalsIgnoreCase(action)) {
            computadorDao.addComputador(computador);
        } else if ("Edit".equalsIgnoreCase(action)) {
            computadorDao.editComputador(computador);
        } else if ("Delete".equalsIgnoreCase(action)) {
            computadorDao.deleteComputador(computadorId);
        } else if ("Search".equalsIgnoreCase(action)) {
            computadorDao.getComputador(computadorId);
        }

        request.setAttribute("Computador", computador);
        request.setAttribute("allComputador", computadorDao.getAllComputadores());
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

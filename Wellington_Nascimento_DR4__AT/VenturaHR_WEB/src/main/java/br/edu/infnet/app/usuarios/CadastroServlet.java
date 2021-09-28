package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Candidato;
import br.edu.infnet.infra.usuarios.CandidatoService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/candidatos/cadastro"})
public class CadastroServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String email = request.getRemoteUser();
        CandidatoService us = new CandidatoService();
        Candidato candidato = us.obterPoremail(email);
        request.setAttribute("candidato", candidato);  // vai no microsserviço pegar o usuário
        String caixaEntrada = "";
               
        if(request.isUserInRole("empresa")){
            
            caixaEntrada = "/empresas/index.jsp";
            
        } else if (request.isUserInRole("candidato")){
            
            caixaEntrada = "/candidatos/index.jsp";
            
        } else {    
            
            caixaEntrada = "/admnistradores/index.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(caixaEntrada);
        rd.forward(request, response);
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


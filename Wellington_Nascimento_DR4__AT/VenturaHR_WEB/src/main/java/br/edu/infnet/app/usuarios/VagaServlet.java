
package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Criterio;
import br.edu.infnet.domain.usuarios.Vaga;
import br.edu.infnet.infra.usuarios.VagaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/vagas"})
public class VagaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession();        
        String op = request.getParameter("op");
        String caixaEntrada = "";
        
        if(op.equals("cadastrarVaga")){
            Vaga vaga = new Vaga();
            vaga.setCargo(request.getParameter("cargo"));
            vaga.setCidade(request.getParameter("cidade"));
            vaga.setFormaContratacao(request.getParameter("formaContratacao"));
            
            session.setAttribute("vaga", vaga);
            
            caixaEntrada= "/empresas/publicarVaga.jsp";
            
        }else if(op.equals("cadastrarCriterio")){            
            List<Criterio> criterios = (List<Criterio>) session.getAttribute("criterios");
            if(criterios == null){
                criterios = new ArrayList<>(); 
            }
            Criterio criterio = new Criterio();
            criterio.setDescricao(request.getParameter("descricao"));
            criterio.setPerfil(Integer.parseInt(request.getParameter("perfil")));
            criterio.setPeso(Integer.parseInt(request.getParameter("peso")));
            
            criterios.add(criterio);
            
            caixaEntrada= "/empresas/publicarVaga.jsp";
            
        } else if (op.equals("publicarVaga")){
            Vaga vaga = (Vaga) session.getAttribute("vaga");
            List<Criterio> criterios = (List<Criterio>) session.getAttribute("criterios");
            vaga.setCriterioList(criterios);
            
            VagaService vagaService = new VagaService();
            Vaga publicaVaga = vagaService.publicarVaga(vaga);
            request.setAttribute("vaga", publicaVaga);
            
            caixaEntrada= "/empresas/index.jsp";
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


package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.domain.usuarios.Vaga;
import br.edu.infnet.infra.usuarios.UsuarioService;
import br.edu.infnet.infra.usuarios.VagaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/usuarios"})
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        UsuarioService usuarioService = new UsuarioService();
        Usuario usuario = usuarioService.obterPorEmail(email);
        request.setAttribute("usuario", usuario);  // vai no microsserviço pegar o usuário
        String caixaEntrada = "";
        VagaService vagaService = new VagaService();
        
          if(usuario.getTipo() == Usuario.EMPRESA){
           
            List<Vaga> vagas = vagaService.listarPorIdUsuario(usuario.getId());
            request.setAttribute("vagas", vagas);
            caixaEntrada = "/empresas/index.jsp";
            
          } else if(usuario.getTipo() == Usuario.CANDIDATO){
            
              List<Vaga> vagas = vagaService.listarVagas();
              request.setAttribute("vagas", vagas);
              caixaEntrada = "/candidatos/index.jsp";
            
            }else if(usuario.getTipo() == Usuario.ADMINISTRADOR){    
                List<Usuario> usuarios = usuarioService.listarUsuarios();
                request.setAttribute("usuarios", usuarios);
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

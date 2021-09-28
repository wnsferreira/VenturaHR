package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Endereco;
import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioRepository;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
        
    @GetMapping(path = "/listarUsuarios")
    public ResponseEntity listarUsuarios(){
        
        List<Usuario> lista = (List<Usuario>) usuarioRepository.findAll();
        
        return ResponseEntity.ok().body(lista);
    }
//    
//    @GetMapping(value = "/usuario")
//    public String telaCadastro() {
//            return "cadastro";
//    }
    
      
    
    @GetMapping(path = {"/email/{email}"})
    public ResponseEntity obterUsuarioPorEmail (@PathVariable String email){
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try{
            Usuario usuario = this.usuarioRepository.findByEmail(email);
            if (usuario != null){
            
                retorno = ResponseEntity.ok().body(usuario);
            }
        } catch (Exception e){
            
        }
        return retorno;
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity obterPorId(@PathVariable int id){
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        Usuario usuario = null;
        
        try{
            usuario = usuarioRepository.findById(id).get();
            
            if(usuario != null){
            
            retorno = ResponseEntity.ok().body(usuario);
        }
        } catch (Exception e){
            
        } 
        
        return retorno;
    }
    
    
    @PostMapping
    public ResponseEntity inserirUsuario(@RequestBody Usuario usuario, Endereco endereco){
        
//        usuario.setEndereco(endereco);  
        
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(usuario != null && usuario.getId() == null){
            
            Usuario usuarioInserido = usuarioRepository.save(usuario);
            
            URI location = ServletUriComponentsBuilder
                   .fromCurrentRequest()
                   .buildAndExpand(usuarioInserido)
                   .toUri();
            
            retorno = ResponseEntity.created(location).body(usuarioInserido);
        }
        return retorno;
    }
    
    @PutMapping
    public ResponseEntity atualizarUsuario(@RequestBody Usuario usuario){
        
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(usuario != null && usuario.getId() == null){
            
            try{
                
            Usuario usuarioGravado = usuarioRepository.save(usuario);
            retorno = ResponseEntity.ok().body(usuarioGravado);
            }catch (Exception e){
            }
        }
        return retorno;
    }
    

}

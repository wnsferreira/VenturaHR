
//package br.edu.infnet.app.usuarios;
//
//import br.edu.infnet.infra.usuarios.EnderecoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//public class EnderecoController {
//    
//    @Autowired
//    private EnderecoService enderecoService;
//
//    @PostMapping(value = "/cep")
//    public String obterCep(Model model, @RequestParam String cep) {
//
//
//            model.addAttribute("meuEndereco", enderecoService.obterCep(cep));
//
//            return "cadastro";
//
//    }
//}

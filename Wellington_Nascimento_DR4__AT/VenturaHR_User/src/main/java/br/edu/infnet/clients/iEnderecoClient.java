
//package br.edu.infnet.clients;
//
//import br.edu.infnet.domain.usuarios.Endereco;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
//public interface iEnderecoClient {
//    
//    @GetMapping(value = "{cep}/json")
//    public Endereco obterCep(@PathVariable String cep);
//}

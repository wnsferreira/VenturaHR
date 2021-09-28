
package br.edu.infnet.infra.vagas;

import br.edu.infnet.domain.vagas.Vaga;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

public class VagaService {
    
    private final String REST_URI = "http://localhost:8082/vagas";
    private final Client client = ClientBuilder.newClient();
    
    public List<Vaga> listarPorIdUsuario(int idUsuario){
        
        return client
                .target(REST_URI)
                .path("usuario")
                .path(String.valueOf(idUsuario))
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);
    }
//    public List<Vaga> listarPorIdUsuario(int idUsuario){
//        
//        return client
//                .target(REST_URI)
//                .path("usuario")
//                .path(String.valueOf(idUsuario))
//                .request(MediaType.APPLICATION_JSON)
//                .get(List.class);
//    }
    
    public Vaga publicarVaga(Vaga vaga){
        
        return client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(vaga, MediaType.APPLICATION_JSON), Vaga.class);
    }
    
    public List<Vaga> listarVagas(){
        
        return client
                .target(REST_URI)
                .path("listarVagas")
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);
    }
    
    public Vaga criarVaga(Vaga vaga){
        
        return client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(vaga, MediaType.APPLICATION_JSON), Vaga.class);
    }
    
}

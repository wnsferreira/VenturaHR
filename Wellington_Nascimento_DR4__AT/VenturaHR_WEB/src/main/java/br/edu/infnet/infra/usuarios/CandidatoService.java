package br.edu.infnet.infra.usuarios;

import br.edu.infnet.domain.usuarios.Candidato;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;



public class CandidatoService {
    
    private final String REST_URI ="http://localhost:8081/candidato";
    private final Client client = ClientBuilder.newClient();  // jersey
    

    public Candidato obterPoremail(String email){
        return client
                .target(REST_URI)
                .path("email")
                .path(email)
                .request(MediaType.APPLICATION_JSON)
                .get(Candidato.class);
    }

    public Candidato criarConta(Candidato candidato){
        
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                
                // o Entity converte e envia e o Usuario class é a resposta              
                .post(Entity.entity(candidato, MediaType.APPLICATION_JSON), Candidato.class);
    }
}
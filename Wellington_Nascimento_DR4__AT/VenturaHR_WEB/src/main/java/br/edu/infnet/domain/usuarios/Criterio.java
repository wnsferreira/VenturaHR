
package br.edu.infnet.domain.usuarios;


public class Criterio {
    
    private Integer id;
    private String descricao;
    private int perfil;
    private int peso;
    
    public Criterio(){
        
    }
    
    public Criterio(Integer id){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}

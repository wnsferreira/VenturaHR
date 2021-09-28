package br.edu.infnet.domain.usuarios;

public class Empresa extends Usuario{
    private String cnpj;
    private String razaoSocial;

//    public Empresa(String nome, String email, String senha) {
//        super(nome, email, senha);
//    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    
}

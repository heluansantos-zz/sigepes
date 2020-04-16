package Model;


public class Empresa {
    private Long id;
    private String nome;
    private String cnpj;
    private String nicho;
    private String descri;

    public Empresa(String nome, String cnpj, String nicho, String descri) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.nicho = nicho;
        this.descri = descri;
    }

    public Empresa() {
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNicho() {
        return nicho;
    }

    public void setNicho(String nicho) {
        this.nicho = nicho;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public long getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void mostraEmpresa(){
        System.out.println("ID : "+ getId());
        System.out.println("Nome : "+ getNome());
        System.out.println("Cnpj : "+ getCnpj());
        System.out.println("Nicho : "+ getNicho());
        System.out.println("Descrição : "+ getDescri());
    }
    
    
}
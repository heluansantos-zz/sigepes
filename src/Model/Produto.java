package Model;


public class Produto {
    private Long id;
    private String nome;
    private String descri;
    private String status;
    private String nicho;
    private String ordem;
    private String preco;

    public Produto(String nome, String descri, String status, String nicho, String ordem, String preco) {
        this.nome = nome;
        this.descri = descri;
        this.status = status;
        this.nicho = nicho;
        this.ordem = ordem;
        this.preco = preco;
    }

    public Produto() {
        
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

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNicho() {
        return nicho;
    }

    public void setNicho(String nicho) {
        this.nicho = nicho;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    

    public long getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void mostraProduto(){
        System.out.println("ID : "+ getId());
        System.out.println("Nome : "+ getNome());
        System.out.println("Descrição : "+ getDescri());
        System.out.println("Status : "+ getStatus());
        System.out.println("Nicho : "+ getNicho());
        System.out.println("Ordem : "+ getOrdem());
        System.out.println("Preço : "+ getPreco());
    }

   

    
}

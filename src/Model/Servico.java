package Model;


public class Servico {
    private Long id;
    private String titulo;
    private String descri;
    private String ordem;
    private String status;

    public Servico(String titulo, String descri, String ordem, String status) {
        this.titulo = titulo;
        this.descri = descri;
        this.ordem = ordem;
        this.status = status;
    }

    public Servico() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    public long getID() {
        return 0;
    }

      public void mostraServico(){
        System.out.println("ID : "+ getId());
        System.out.println("Titulo : "+ getTitulo());
        System.out.println("Descrição : "+ getDescri());
        System.out.println("Ordem : "+ getOrdem());
        System.out.println("Status : "+ getStatus());
        
    }
    
}

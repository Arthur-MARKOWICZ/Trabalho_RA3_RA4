import java.util.Date;

public class Livro {
    private String titulo;
    private Date anoPublicacao;
    private int numeroDePagina;
    public Livro(String titulo,Date anoPublicacao,int numeroDePagina){
        this.titulo=titulo;
        this.anoPublicacao = anoPublicacao;
        this.numeroDePagina = numeroDePagina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroDePagina() {
        return numeroDePagina;
    }

    public void setNumeroDePagina(int numeroDePagina) {
        this.numeroDePagina = numeroDePagina;
    }
}

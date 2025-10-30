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
}

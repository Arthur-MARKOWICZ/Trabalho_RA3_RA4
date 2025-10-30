import java.util.LinkedList;

public class TabelaHash {

    private static final int TAMANHO = 10;

    private LinkedList<Livro>[] tabela;
    public TabelaHash() {
        tabela = new LinkedList[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(String titulo) {
        return Math.abs(titulo.hashCode()) % TAMANHO;
    }


    public void inserir(Livro livro) {
        int indice = hash(livro.getTitulo());
        LinkedList<Livro> lista = tabela[indice];
        for (Livro l : lista) {
            if (l.getTitulo().equals(livro.getTitulo())) {
                System.out.println("Livro já existente: " + livro.getTitulo());
                return;
            }
        }
        lista.add(livro);
        System.out.println("Livro inserido: " + livro.getTitulo());
    }


    public Livro buscar(String titulo) {
        int indice = hash(titulo);
        LinkedList<Livro> lista = tabela[indice];

        for (Livro l : lista) {
            if (l.getTitulo().equals(titulo)) {
                return l;
            }
        }
        return null;
    }


    public boolean remover(String titulo) {
        int indice = hash(titulo);
        LinkedList<Livro> lista = tabela[indice];

        for (Livro l : lista) {
            if (l.getTitulo().equals(titulo)) {
                lista.remove(l);
                System.out.println("Livro removido: " + titulo);
                return true;
            }
        }
        System.out.println("Livro não encontrado: " + titulo);
        return false;
    }

    public void exibirTabela() {
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print("Índice " + i + ": ");
            for (Livro l : tabela[i]) {
                System.out.print(l.getTitulo() + " -> ");
            }
            System.out.println("null");
        }
    }
}

package estrutura;

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
    //mudar o hash
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

    public Livro buscarTitulo(String titulo) {
        int indice = hash(titulo);
        LinkedList<Livro> lista = tabela[indice];
        for (Livro l : lista) {
            if (l.getTitulo().equals(titulo)) {
                return l;
            }
        }
        return null;
    }

    public Livro[] buscarAno(int ano) {
        LinkedList<Livro> encontrados = new LinkedList<>();
        for (LinkedList<Livro> lista : tabela) {
            for (Livro l : lista) {
                if (l.getAnoPublicacao() == ano) {
                    encontrados.add(l);
                }
            }
        }
        return encontrados.toArray(new Livro[0]);
    }

    public Livro[] buscarPaginas(int paginas) {
        LinkedList<Livro> encontrados = new LinkedList<>();
        for (LinkedList<Livro> lista : tabela) {
            for (Livro l : lista) {
                if (l.getNumeroDePagina() == paginas) {
                    encontrados.add(l);
                }
            }
        }
        return encontrados.toArray(new Livro[0]);
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

    public Livro[] exportarParaVetor() {
        int total = 0;
        for (LinkedList<Livro> lista : tabela) {
            total += lista.size();
        }
        Livro[] vetor = new Livro[total];
        int index = 0;
        for (LinkedList<Livro> lista : tabela) {
            for (Livro l : lista) {
                vetor[index++] = l;
            }
        }
        return vetor;
    }

    public void exibirVetor(Livro[] vetor) {
        if (vetor.length == 0) {
            System.out.println("Nenhum livro para exibir.");
            return;
        }

        for (Livro l : vetor) {
            if (l != null) {
                System.out.println("Título: " + l.getTitulo() +
                        " | Ano: " + l.getAnoPublicacao() +
                        " | Páginas: " + l.getNumeroDePagina());
            }
        }
    }
}
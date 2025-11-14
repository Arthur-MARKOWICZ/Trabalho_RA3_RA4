package estrutura;

import java.util.LinkedList;

public class TabelaHash {

    private static final int TAMANHO = 10;
    private int tamanho;           // tamanho atual da tabela
    private int quantidade;
    private static final double LIMITE_FATOR_CARGA = 0.75;
    private LinkedList<Livro>[] tabela;

    private int colisoes = 0; // 🔥 contador de colisões

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

        // Se já existe algo na lista, significa colisão (exceto se for a primeira entrada)
        if (!lista.isEmpty()) {
            colisoes++;   // 🔥 incrementa colisão
            System.out.println("⚠️ Colisão detectada no índice " + indice);
        }

        // Verifica duplicado
        for (Livro l : lista) {
            if (l.getTitulo().equals(livro.getTitulo())) {
                System.out.println("Livro já existente: " + livro.getTitulo());
                return;
            }
        }

        lista.add(livro);
        System.out.println("Livro inserido: " + livro.getTitulo());
        verificarFatorCarga();
    }

    private void verificarFatorCarga() {
        double fatorCarga = (double) quantidade / tamanho;

        if (fatorCarga > LIMITE_FATOR_CARGA) {
            System.out.println("\n🚨 FATOR DE CARGA ACIMA DE 0.75 (" + fatorCarga + ")");
            System.out.println("🔄 Redimensionando tabela hash...\n");
            redimensionarTabela();
        }
    }

    private void redimensionarTabela() {
        int novoTamanho = tamanho * 2;
        LinkedList<Livro>[] novaTabela = new LinkedList[novoTamanho];

        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }

        // rehash de todos elementos
        for (LinkedList<Livro> lista : tabela) {
            for (Livro l : lista) {
                int novoIndice = Math.abs(l.getTitulo().hashCode()) % novoTamanho;
                novaTabela[novoIndice].add(l);
            }
        }
    }

        public Livro buscarTitulo (String titulo){
            int indice = hash(titulo);
            LinkedList<Livro> lista = tabela[indice];
            for (Livro l : lista) {
                if (l.getTitulo().equals(titulo)) {
                    return l;
                }
            }
            return null;
        }

        public Livro[] buscarAno ( int ano){
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

        public Livro[] buscarPaginas ( int paginas){
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

        public boolean remover (String titulo){
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

        public void exibirTabela () {
            for (int i = 0; i < TAMANHO; i++) {
                System.out.print("Índice " + i + ": ");
                for (Livro l : tabela[i]) {
                    System.out.print(l.getTitulo() + " -> ");
                }
                System.out.println("null");
            }
        }

        public Livro[] exportarParaVetor () {
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

        public void exibirVetor (Livro[]vetor){
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

        // 🔥 Retorna o número de colisões
        public int getColisoes () {
            return colisoes;
        }
    }
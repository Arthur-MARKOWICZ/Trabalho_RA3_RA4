package sort;

import estrutura.Livro;

public class InsertionSort {

    public static void insertionSortPorTitulo(Livro[] vetor) {
        if (vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }

        for (int i = 0; i < vetor.length; i++) {
            //adicionar contadot para o numero de comparacao
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i].getTitulo().equalsIgnoreCase(vetor[j].getTitulo())) {
                    System.out.println("Título duplicado encontrado: \"" + vetor[i].getTitulo() + "\"");
                    System.out.println("Ordenação cancelada!");
                    return;
                }
            }
        }

        //long inicio = System.nanoTime();

        for (int i = 1; i < vetor.length; i++) {
            Livro chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getTitulo().compareToIgnoreCase(chave.getTitulo()) > 0) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }

        //long fim = System.nanoTime();

        //long tempoMs = (fim - inicio) / 2;
        //System.out.println("Tempo de ordenação: " + tempoMs + " ms");


        System.out.println("Livros ordenados por título com sucesso!");

    }


    public static void insertionSortPorAno(Livro[] vetor) {
        if (vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }

        for (int i = 1; i < vetor.length; i++) {
            Livro chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getAnoPublicacao() > chave.getAnoPublicacao()) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }

        System.out.println("Livros ordenados por ano com sucesso!");
    }

    public static void insertionSortPorPaginas(Livro[] vetor) {
        if (vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }

        for (int i = 1; i < vetor.length; i++) {
            Livro chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getNumeroDePagina() > chave.getNumeroDePagina()) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }

        System.out.println("Livros ordenados por número de páginas com sucesso!");
    }
}

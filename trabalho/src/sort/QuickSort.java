package sort;

import estrutura.Livro;

public class QuickSort {


    public static void quickSortPorTitulo(Livro[] vetor) {

        if (vetor == null || vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }


        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i].getTitulo().equalsIgnoreCase(vetor[j].getTitulo())) {
                    System.out.println("Título duplicado encontrado: \"" + vetor[i].getTitulo() + "\"");
                    System.out.println("Ordenação cancelada!");
                    return;
                }
            }
        }

        quickSortTitulo(vetor, 0, vetor.length - 1);
        System.out.println("Livros ordenados por título com sucesso!");
    }

    private static void quickSortTitulo(Livro[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionarTitulo(vetor, inicio, fim);
            quickSortTitulo(vetor, inicio, pivo - 1);
            quickSortTitulo(vetor, pivo + 1, fim);
        }
    }

    private static int particionarTitulo(Livro[] vetor, int inicio, int fim) {
        String pivo = vetor[fim].getTitulo();
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j].getTitulo().compareToIgnoreCase(pivo) <= 0) {
                i++;
                trocar(vetor, i, j);
            }
        }

        trocar(vetor, i + 1, fim);
        return i + 1;
    }



    public static void quickSortPorAno(Livro[] vetor) {

        if (vetor == null || vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }

        quickSortAno(vetor, 0, vetor.length - 1);
        System.out.println("Livros ordenados por ano com sucesso!");
    }

    private static void quickSortAno(Livro[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionarAno(vetor, inicio, fim);
            quickSortAno(vetor, inicio, pivo - 1);
            quickSortAno(vetor, pivo + 1, fim);
        }
    }

    private static int particionarAno(Livro[] vetor, int inicio, int fim) {
        int pivo = vetor[fim].getAnoPublicacao();
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j].getAnoPublicacao() <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }

        trocar(vetor, i + 1, fim);
        return i + 1;
    }




    public static void quickSortPorPaginas(Livro[] vetor) {

        if (vetor == null || vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }

        quickSortPaginas(vetor, 0, vetor.length - 1);
        System.out.println("Livros ordenados por número de páginas com sucesso!");
    }

    private static void quickSortPaginas(Livro[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionarPaginas(vetor, inicio, fim);
            quickSortPaginas(vetor, inicio, pivo - 1);
            quickSortPaginas(vetor, pivo + 1, fim);
        }
    }

    private static int particionarPaginas(Livro[] vetor, int inicio, int fim) {
        int pivo = vetor[fim].getNumeroDePagina();
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j].getNumeroDePagina() <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }

        trocar(vetor, i + 1, fim);
        return i + 1;
    }




    private static void trocar(Livro[] vetor, int i, int j) {
        Livro temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}

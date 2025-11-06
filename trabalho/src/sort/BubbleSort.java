package sort;

import estrutura.*;

public class BubbleSort {
    public static void bubbleSortPorTitulo(Livro[] vetor) {
        if (vetor.length <= 1) {
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
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j].getTitulo().compareToIgnoreCase(vetor[j + 1].getTitulo()) > 0) {
                    Livro temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        System.out.println("Livros ordenados por título com sucesso!");
    }
    public static void bubbleSortPorAno(Livro[] vetor) {
        if (vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j].getAnoPublicacao() > vetor[j + 1].getAnoPublicacao()) {
                    Livro temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        System.out.println("Livros ordenados por ano com sucesso!");
    }

    public static void bubbleSortPorPaginas(Livro[] vetor) {
        if (vetor.length <= 1) {
            System.out.println("Não há livros suficientes para ordenar.");
            return;
        }
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j].getNumeroDePagina() > vetor[j + 1].getNumeroDePagina()) {
                    Livro temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        System.out.println("Livros ordenados por número de páginas com sucesso!");
    }
}
package sort;

import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }

    public static void exibirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor: ");
        int n = scanner.nextInt();
        int[] vetor = new int[n];
        System.out.println("Digite os elementos do vetor:");
        for (int i = 0; i < n; i++) {
            vetor[i] = scanner.nextInt();
        }
        System.out.println("\nVetor antes da ordenação:");
        exibirVetor(vetor);
        insertionSort(vetor);
        System.out.println("\nVetor após a ordenação (Insertion Sort):");
        exibirVetor(vetor);
        scanner.close();
    }
}

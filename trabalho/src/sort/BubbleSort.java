package sort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tamanho do vetor: ");
        int numero = sc.nextInt();
        int[] vetor = new int[numero];
        System.out.println("Elementos do vetor: ");
        for (int i = 0; i < numero; i++) {
            vetor[i] = sc.nextInt();
        }
        imprimirVetor(vetor);
        bubbleSort(vetor);
        imprimirVetor(vetor);
        sc.close();
    }
    public static void imprimirVetor(int[] vetor) {
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}

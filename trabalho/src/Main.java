import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != -1){
            System.out.println("Digite 1: para criar e adicionar livro ");
            System.out.println("Digite 2: para remover livro pelo titulo");
            System.out.println("Digite 3: para fazer o bubble sort");
            System.out.println("Digite 4: para fazer o insertion sort");
            System.out.println("Digite 5: para fazer o quick sort");
            System.out.println("Digite -1 para sair");
        }
    }
}

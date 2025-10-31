import java.util.Date;
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
            opcao = scanner.nextInt();
            switch (opcao){
                case 1 :
                    System.out.println("digite o titulo do livro ");
                    String titulo =scanner.next();
                    System.out.println("digite o ano do livro");
                    int ano = scanner.nextInt();
                    System.out.println("digite o numero de pagina");
                    int paginaNumero =  scanner.nextInt();
                    Livro livro = new Livro(titulo,ano,paginaNumero);



            }
        }
    }
}

import estrutura.*;
import sort.BubbleSort;
import sort.QuickSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TabelaHash hash = new TabelaHash();
        int opcao = 0;

        while (opcao != 10){
            switch (opcao){
                case 0:
                    System.out.println("\n=====================");
                    System.out.println("1 - Criar e adicionar livro");
                    System.out.println("2 - Remover livro pelo título");
                    System.out.println("3 - BubbleSort");
                    System.out.println("4 - Insertion Sort");
                    System.out.println("5 - Quick Sort");
                    System.out.println("6 - Buscar livro por título");
                    System.out.println("7 - Buscar livro por ano");
                    System.out.println("8 - Buscar livro por número de páginas");
                    System.out.println("9 - Exibir Tabela Hash");
                    System.out.println("10 - Sair");
                    System.out.print("Escolha: ");
                    opcao = scanner.nextInt();
                    break;

                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.next();
                    System.out.print("Digite o ano do livro: ");
                    int ano = scanner.nextInt();
                    System.out.print("Digite o número de páginas: ");
                    int paginaNumero = scanner.nextInt();
                    Livro livro = new Livro(titulo, ano, paginaNumero);
                    hash.inserir(livro);
                    System.out.println("Livro inserido com sucesso!");
                    opcao = 0;
                    break;

                case 2:
                    System.out.print("Digite o título do livro que deseja remover: ");
                    String tituloRemover = scanner.next();
                    boolean removido = hash.remover(tituloRemover);
                    if(removido) {
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    opcao = 0;
                    break;

                case 3:
                    System.out.println("\n=====================");
                    System.out.println("1 - Ordenar por Título");
                    System.out.println("2 - Ordenar por Ano");
                    System.out.println("3 - Ordenar por Número de Páginas");
                    System.out.print("Escolha: ");
                    int escolhaBubble = scanner.nextInt();
                    Livro[] vetorOrdenadoBubble = hash.exportarParaVetor();
                    if (vetorOrdenadoBubble.length == 0) {
                        System.out.println("Não há livros cadastrados para ordenar.");
                    } else {
                        boolean opcaoValida = true;
                        switch (escolhaBubble) {
                            case 1:
                                System.out.println("\nOrdenando por título:");
                                BubbleSort.bubbleSortPorTitulo(vetorOrdenadoBubble);
                                break;
                            case 2:
                                System.out.println("\nOrdenando por ano:");
                                BubbleSort.bubbleSortPorAno(vetorOrdenadoBubble);
                                break;
                            case 3:
                                System.out.println("\nOrdenando por páginas:");
                                BubbleSort.bubbleSortPorPaginas(vetorOrdenadoBubble);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                opcaoValida = false;
                                break;
                        }
                        if (opcaoValida) {
                            hash.exibirVetor(vetorOrdenadoBubble);
                        }
                    }
                    opcao = 0;
                    break;

                case 4:
                    opcao = 0;
                    break;

                case 5:
                    System.out.println("\n=====================");
                    System.out.println("1 - Ordenar por Título");
                    System.out.println("2 - Ordenar por Ano");
                    System.out.println("3 - Ordenar por Número de Páginas");
                    System.out.print("Escolha: ");
                    int escolhaQuick = scanner.nextInt();

                    Livro[] vetorOrdenadoQuick = hash.exportarParaVetor();

                    if (vetorOrdenadoQuick.length == 0) {
                        System.out.println("Não há livros cadastrados para ordenar.");
                    } else {
                        boolean opcaoValida = true;

                        switch (escolhaQuick) {
                            case 1:
                                System.out.println("\nOrdenando por título:");
                                QuickSort.quickSortPorTitulo(vetorOrdenadoQuick);
                                break;
                            case 2:
                                System.out.println("\nOrdenando por ano:");
                                QuickSort.quickSortPorAno(vetorOrdenadoQuick);
                                break;
                            case 3:
                                System.out.println("\nOrdenando por páginas:");
                                QuickSort.quickSortPorPaginas(vetorOrdenadoQuick);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                opcaoValida = false;
                                break;
                        }

                        if (opcaoValida) {
                            hash.exibirVetor(vetorOrdenadoQuick);
                        }
                    }

                    opcao = 0;
                    break;

                case 6:
                    System.out.print("Digite o título do livro para buscar: ");
                    String tituloBusca = scanner.next();
                    Livro livroBuscado = hash.buscarTitulo(tituloBusca);
                    if (livroBuscado == null) {
                        System.out.println("Livro não encontrado.");
                    } else {
                        System.out.println("\nLivro encontrado:");
                        System.out.println("Título: " + livroBuscado.getTitulo());
                        System.out.println("Ano: " + livroBuscado.getAnoPublicacao());
                        System.out.println("Páginas: " + livroBuscado.getNumeroDePagina());
                    }
                    opcao = 0;
                    break;

                case 7:
                    System.out.print("Digite o ano do(s) livro(s) que deseja buscar: ");
                    int anoBusca = scanner.nextInt();
                    Livro[] livrosAno = hash.buscarAno(anoBusca);

                    if (livrosAno.length == 0) {
                        System.out.println("Nenhum livro encontrado para o ano informado.");
                    } else {
                        System.out.println("\nLivros encontrados:");
                        hash.exibirVetor(livrosAno);
                    }
                    opcao = 0;
                    break;

                case 8:
                    System.out.print("Digite o número de páginas do(s) livro(s) que deseja buscar: ");
                    int paginasBusca = scanner.nextInt();
                    Livro[] livrosPaginas = hash.buscarPaginas(paginasBusca);

                    if (livrosPaginas.length == 0) {
                        System.out.println("Nenhum livro encontrado com essa quantidade de páginas.");
                    } else {
                        System.out.println("\nLivros encontrados:");
                        hash.exibirVetor(livrosPaginas);
                    }
                    opcao = 0;
                    break;

                case 9:
                    System.out.println("\nConteúdo da Tabela Hash:");
                    hash.exibirTabela();
                    opcao = 0;
                    break;
            }
        }
        System.out.println("\nPrograma encerrado.");
    }
}
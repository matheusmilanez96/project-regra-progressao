package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Método main.
   */
  public static void main(String[] args) {
    coletarInformacoes();
  }

  /**
   * Método coletarInformacoes.
   */
  public static void coletarInformacoes() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar: ");
    String qtdEntrada = scanner.nextLine();
    int qtd = Integer.parseInt(qtdEntrada);
    for (int n = 1; n <= qtd; n += 1) {
      System.out.println("Digite o nome da atividade " + n + ": ");
      String nome = scanner.nextLine();
      System.out.println("Digite o peso da atividade " + n + ": ");
      String pesoEntrada = scanner.nextLine();
      int peso = Integer.parseInt(pesoEntrada);
      System.out.println("O nome é " + nome + " e o peso é " + peso + ".");
    }

    scanner.close();
  }
}

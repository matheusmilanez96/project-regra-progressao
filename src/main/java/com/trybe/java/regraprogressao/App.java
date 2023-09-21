package com.trybe.java.regraprogressao;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
   * Método calcularNota.
   */
  public static float calcularNota(int[] notas, int[] pesos, int qtd) {

    int[] multArr = { };
    for (int n = 0; n < qtd; n += 1) {
      int mult = notas[n] * pesos[n];
      multArr = Arrays.copyOf(multArr, multArr.length + 1);
      multArr[multArr.length - 1] = mult;
    }

    float somaMult = IntStream.of(multArr).sum();
    float somaPesos = IntStream.of(pesos).sum();

    return somaMult / somaPesos;
  }

  /**
   * Método coletarInformacoes.
   */
  public static void coletarInformacoes() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar: ");
    String qtdEntrada = scanner.nextLine();
    int qtd = Integer.parseInt(qtdEntrada);
    int[] pesoArr = { };
    int[] notaArr = { };
    for (int n = 1; n <= qtd; n += 1) {
      System.out.println("Digite o nome da atividade " + n + ": ");
      String nome = scanner.nextLine();
      System.out.println("Digite o peso da atividade " + n + ": ");
      String pesoEntrada = scanner.nextLine();
      System.out.println("Digite a nota obtida para " + nome + ": ");
      int peso = Integer.parseInt(pesoEntrada);
      pesoArr = Arrays.copyOf(pesoArr, pesoArr.length + 1);
      pesoArr[pesoArr.length - 1] = peso;
      String notaEntrada = scanner.nextLine();
      int nota = Integer.parseInt(notaEntrada);
      notaArr = Arrays.copyOf(notaArr, notaArr.length + 1);
      notaArr[notaArr.length - 1] = nota;
    }

    float notaFinal = calcularNota(notaArr, pesoArr, qtd);

    if (notaFinal >= 85) {
      System.out.println("Parabéns! Você alcançou " + notaFinal
          + "%! E temos o prazer de informar que você obteve aprovação!");
    } else {
      System.out.println(
          "Lamentamos informar que, com base na sua pontuação alcançada neste período, "
              + notaFinal
              + "%, você não atingiu a pontuação mínima necessária para sua aprovação.");
    }
    scanner.close();
  }
}

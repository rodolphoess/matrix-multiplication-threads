package br.matriz;

import br.matriz.concorrente.MultiplicacaoConcorrente;
import br.matriz.sequencial.MultiplicacaoSequencial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entrada;
        System.out.print("Informe a dimensão e se quer executar a matriz de forma sequencial (S) ou concorrente (C). " +
                "Por exemplo, 4 S. \n\nEntrada: ");
        entrada = sc.nextLine();

        validarEspacoEntreDimensaoELetra(entrada, entrada.length());
        validarEntrada(entrada);

        int tamanhoEntrada = entrada.length();

        String tamanhoMatrizString = entrada.substring(0, tamanhoEntrada - 2);
        String sequencialOuConcorrente = entrada.substring(tamanhoEntrada - 1);

        int tamanhoMatrizInteiro = Integer.parseInt(tamanhoMatrizString);

        int matrizA[][] = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];
        int matrizB[][] = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];

        if (sequencialOuConcorrente.equals("S")) {
            MultiplicacaoSequencial.multiplicarMatrizes(matrizA, matrizB);
        } else if (sequencialOuConcorrente.equals("C")) {
            MultiplicacaoConcorrente.multiplicarMatrizes(matrizA, matrizB);
        } else {
            System.err.print("Não foi possível realizar a multiplicação das matrizes. Por favor, informe se a multiplicação " +
                    "será sequencial (S) ou  concorrente (C).");

            System.exit(0);
        }
    }

    private static void validarEspacoEntreDimensaoELetra(String entrada, int tamanhoEntrada) {

        String espaco = entrada.substring(tamanhoEntrada - 2, tamanhoEntrada - 1);

        if (!espaco.equals(" ")) {
            System.err.println("Deve haver um espaço ( ) entre a dimensão e a letra que indica se é concorrente ou sequencial. " +
                    "Por exemplo, 4 S, 8 C, 16 C, 32 S, 256 C, 2048 S.");

            System.exit(0);
        }

    }

    private static void validarEntrada(String entrada) {
        if (entrada.length() < 3 || entrada.length() > 6) {
            System.err.print("\nSua entrada é inválida. Por favor, informe se a matriz possui dimensões 4, 8, 16, 32, 64, " +
                    "128, 256, 512, 1024, 2048 e se será S ou C. Por exemplo, 1024 C ou 2048 S.");

            System.exit(0);
        }
    }

}

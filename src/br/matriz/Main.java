package br.matriz;

import br.matriz.concorrente.MultiplicacaoConcorrente;
import br.matriz.sequencial.MultiplicacaoSequencial;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entrada;
        System.out.print("Informe a dimensão e se quer executar a matriz de forma sequencial (S) ou concorrente (C). " +
                "Por exemplo, 4 S. \n\nEntrada: ");
        entrada = sc.nextLine();

        validarEspacoEntreDimensaoMatrizELetra(entrada, entrada.length());
        validarEntrada(entrada);

        int tamanhoEntrada = entrada.length();

        String tamanhoMatrizString = entrada.substring(0, tamanhoEntrada - 2);
        String sequencialOuConcorrente = entrada.substring(tamanhoEntrada - 1);

        int tamanhoMatrizInteiro = Integer.parseInt(tamanhoMatrizString);

        int[][] matrizA = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];
        int[][] matrizB = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];

        String pathA = "../matrix-multiplication-threads/src/br/matriz/matrizes/A" + tamanhoMatrizString + "x" + tamanhoMatrizString + ".txt";
        leituraDeMatriz(matrizA, pathA, tamanhoMatrizInteiro);

        String pathB = "../matrix-multiplication-threads/src/br/matriz/matrizes/B" + tamanhoMatrizString + "x" + tamanhoMatrizString + ".txt";
        leituraDeMatriz(matrizB, pathB, tamanhoMatrizInteiro);

        if (sequencialOuConcorrente.equals("S")) {
            Long tempoExecucao = MultiplicacaoSequencial.multiplicarMatrizes(matrizA, matrizB, tamanhoMatrizInteiro);

            System.out.println("\nMultiplicação sequencial concluída e resultado salvo em arquivo .txt na pasta /resultados. O tempo de execução " +
                    "da multiplicação foi de " + tempoExecucao + " ms.");

        } else if (sequencialOuConcorrente.equals("C")) {
            Long tempoExecucao = MultiplicacaoConcorrente.multiplicarMatrizes(matrizA, matrizB, tamanhoMatrizInteiro);

            System.out.println("\nMultiplicação concorrente concluída e resultado salvo em arquivo .txt na pasta /resultados. O tempo de execução " +
                    "da multiplicação foi de " + tempoExecucao + " ms.");

        } else {
            System.err.print("\nNão foi possível realizar a multiplicação das matrizes. Por favor, informe se a multiplicação " +
                    "será sequencial (S) ou concorrente (C).");

            System.exit(0);
        }

    }

    private static void leituraDeMatriz(int[][] matrizA, String path, int tamanhoMatriz) {
        try {
            Scanner scn = new Scanner(new File(path));

            for (int i = 0; i < 2; i++) {
                scn.nextInt();
            }

            for(int i = 0; i < tamanhoMatriz; i++) {
                for (int j = 0; j < tamanhoMatriz; j++) {
                    matrizA[i][j] = scn.nextInt();
                }
            }

            scn.close();

        } catch (IOException e) {
            System.err.print("\nNão foi possível encontrar o arquivo com a matriz.");
        }

    }

    private static void validarEspacoEntreDimensaoMatrizELetra(String entrada, int tamanhoEntrada) {

        String espaco = entrada.substring(tamanhoEntrada - 2, tamanhoEntrada - 1);

        if (!espaco.equals(" ")) {
            System.err.println("\nDeve haver um espaço ( ) entre a dimensão da matriz e a letra que indica se é concorrente ou sequencial. " +
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

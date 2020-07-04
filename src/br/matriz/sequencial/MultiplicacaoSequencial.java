package br.matriz.sequencial;

public class MultiplicacaoSequencial {

    private MultiplicacaoSequencial() { }

    public static void multiplicarMatrizes(int[][] matrizA, int[][] matrizB, int tamanhoMatrizInteiro) {

        int[][] matrizC = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizC[i].length; j++) {
                for (int k = 0; k < matrizA[i].length; k++) {
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        System.out.print("");
    }

}

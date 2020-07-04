package br.matriz.concorrente;

import br.matriz.Main;

public class MultiplicacaoConcorrente {

    private MultiplicacaoConcorrente() { }

    public static Long multiplicarMatrizes(int[][] matrizA, int[][] matrizB, int tamanhoMatrizInteiro) {

        int[][] matrizC = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];

        Long tempoInicial = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizC[i].length; j++) {
                    for (int k = 0; k < matrizA[i].length; k++) {
                        matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }
        }).start();
        Long tempoFinal = System.currentTimeMillis();

        String path = "../matrix-multiplication-threads/src/br/matriz/resultados/C" + tamanhoMatrizInteiro + "x" + tamanhoMatrizInteiro + "C.txt";
        Main.gravarResultadoEmArquivo(matrizC, path);

        return tempoFinal - tempoInicial;
    }

}

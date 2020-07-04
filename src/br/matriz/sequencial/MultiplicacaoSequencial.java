package br.matriz.sequencial;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MultiplicacaoSequencial {

    private MultiplicacaoSequencial() { }

    public static Long multiplicarMatrizes(int[][] matrizA, int[][] matrizB, int tamanhoMatrizInteiro) {

        int[][] matrizC = new int[tamanhoMatrizInteiro][tamanhoMatrizInteiro];

        Long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizC[i].length; j++) {
                for (int k = 0; k < matrizA[i].length; k++) {
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        Long tempoFinal = System.currentTimeMillis();

        String path = "../matrix-multiplication-threads/src/br/matriz/resultados/C" + tamanhoMatrizInteiro + "x" + tamanhoMatrizInteiro + "S.txt";

        gravarResultadoEmArquivo(matrizC, path);

        return tempoFinal - tempoInicial;
    }

    private static void gravarResultadoEmArquivo(int[][] matrizC, String path) {

        try {
            File file = new File(path);

            if (!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter(file);

            for(int i= 0; i < matrizC.length; i++) {
                for (int j = 0; j < matrizC[i].length; j++) {
                    fw.append(Integer.toString(matrizC[i][j]));
                    fw.append(" ");
                }
                fw.append("\n");
            }

            fw.close();

        } catch (IOException e) {
            System.err.print("Não foi possível gravar o resultado da multiplicação.");
        }
    }

}

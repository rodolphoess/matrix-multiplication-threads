package br.matriz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entrada;
        System.out.print("Informe a dimensão e se quer executar a matriz de forma sequencial (S) ou concorrente (C). " +
                "Por exemplo, 4 S. \n\nEntrada: ");
        entrada = sc.nextLine();

        validarEntrada(entrada);

        int tamanhoEntrada = entrada.length();

        String tamanhoMatriz = entrada.substring(0, tamanhoEntrada - 2);
        String sequencialOuConcorrente = entrada.substring(tamanhoEntrada - 1);



        System.out.print(tamanhoMatriz + "\n" + sequencialOuConcorrente);
    }

    private static void validarEntrada(String entrada) {
        if (entrada.length() < 3 || entrada.length() > 6) {
            System.err.print("Sua entrada é inválida. Por favor, informe se a matriz possui dimensões 4, 8, 16, 32, 64, " +
                    "128, 256, 512, 1024, 2048 e se será S ou C. Por exemplo, 1024 C ou 2048 S.");
        }
    }

}

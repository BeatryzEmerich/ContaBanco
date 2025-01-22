package com.bia.project.contabanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ContaBancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContaBancoApplication.class, args);

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine().trim();

            System.out.print("Digite o número da agência: ");
            int numeroAgencia = obterInteiro(scanner);

            System.out.print("Digite o número da conta: ");
            int numeroConta = obterInteiro(scanner);

            System.out.print("Digite o saldo: ");
            double saldo = obterDouble(scanner);

            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco!%n", nomeCliente);
            System.out.printf("Sua agência é %d, conta %d e seu saldo R$ %.2f já está disponível para saque.%n",
                    numeroAgencia, numeroConta, saldo);
        }
    }

    private static int obterInteiro(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número inteiro válido: ");
            }
        }
    }

    private static double obterDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um valor decimal válido: ");
            }
        }
    }
}

package Jdbc.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Menu {

    public static int selectTable() {
        System.out.println("Selecione a planilha para interação!");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 - Ator\n" + " 2 - Categoria\n" + " 3 - Genero\n");
        try {
            int choice = sc.nextInt();
            if (choice > 3 || choice < 1) {
                throw new InputMismatchException();
            }
            return choice;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return 0;
    }

    public static int selectFunction() {
        System.out.println("Selecione a planilha para interação!");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 - Inserir\n" + " 2 - Ler um\n" + " 3 - Ler todos\n"
                + " 4 - Atualizar\n" + " 5 - Excluir\n");
        try {
            int choice = sc.nextInt();
            if (choice > 3 || choice < 1) {
                throw new InputMismatchException();
            }
            return choice;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return 0;
    }

}

/*
                System.out.println("Funções disponiveis: \n" + "1 - Criar\n" + "2 - Ler um item" + "3 - Ler todos"
                + "4 - Atualizar item" + "5 - Excluir item" + "6 - Sair");*/


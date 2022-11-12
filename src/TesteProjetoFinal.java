import dominio.Mesa;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteProjetoFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Mesa> mesa = new ArrayList<Mesa>();

        mostraMenu();


    }

        private static void mostraMenu(){
            System.out.println("Menu");
            System.out.println("1: Cadastrar Garçon ");
            System.out.println("2: Remover Garçon ");
            System.out.println("3: Alterar Garçon ");
            System.out.println("4: Cadastrar Mesa ");
            System.out.println("5: Remover Mesa ");
            System.out.println("6: Alterar Mesa ");
            System.out.println("7: Buscar Mesa pelo Número ");
            System.out.println("8: Buscar Mesa pela Capacidade ");
            System.out.println("9: Buscar Mesa pelo Garçom ");
            System.out.println("10:Relatório de Mesas livres ");
            System.out.println("11:Relatório de Mesas ocupadas ");
            System.out.println("12:Relatório de todas as Mesas atendidas pelo garçom ");
            System.out.println("13:Quantidade de Mesas está sendo atendidas pelo garçom");
            System.out.println("0: Sair do programa");



    }
}

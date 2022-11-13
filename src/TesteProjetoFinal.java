import dominio.Garcom;
import dominio.Mesa;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteProjetoFinal {
    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private static ArrayList<Garcom> garcons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 13) {

            mostraMenu();
            System.out.println("Entre com a opção desejada: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: cadastrarGarcom (sc, garcons);
                break;
                case 2: removeGarcom (sc, garcons);
                break;
                case 3: cadastrarMesa (sc, mesas);
                break;


            }
        }
    }

    private static void cadastrarMesa(Scanner sc, ArrayList<Mesa> mesas) {
        System.out.println("Entre com número da mesa: ");
        int numeroMesa = Integer.parseInt(sc.nextLine());

        System.out.println("Entre com a Situação da mesa: ");
        String situacaoMesa = sc.nextLine();

        System.out.println("Entre com a capacidade de clientes da mesa: ");
        int capacidadeMesa = Integer.parseInt(sc.nextLine());

        System.out.println("Entre com o garçom responsável: ");
        Garcom responsavelMesa = new Garcom();     //verificar

        for(int i=0; i < garcons.size(); i++) {
           Garcom garcomVetor = garcons.get(i);

            if (responsavelMesa.getNome() != garcomVetor.getNome()){
                System.out.println("Garçom não cadastrado, cadastre o Garçom primeiro");
                mostraMenu();

            }
            else {
                Mesa mesa = new Mesa(numeroMesa,situacaoMesa,capacidadeMesa,responsavelMesa);
            }
        }





    }


    private static void removeGarcom(Scanner sc, ArrayList<Garcom> garcons) {
        System.out.println("Digite o nome do Garçom para remover: ");
        String nome = sc.nextLine();
            for(int i=0; i < garcons.size(); i++) {
                Garcom garcomVetor = garcons.get(i);

                if (garcomVetor.getNome() == nome){
                    garcons.remove(i);
                }
                else {
                    System.out.println("Garçom não cadastrado");
                    mostraMenu();
                }
            }

    }

    private static void cadastrarGarcom (Scanner sc, ArrayList<Garcom> garcons) {
        System.out.println("Entre com Nome do Garçom: ");
        String nome = sc.nextLine();

        System.out.println("Entre com o CPF: ");
        String CPF = sc.nextLine();

        System.out.println("Entre com a Data de Nascimento dd/mm/aa: ");
        String dataNascimento = sc.nextLine();

        System.out.println("Entre com o e-mail: ");
        String email = sc.nextLine();

        System.out.println("Entre como  sexo (Masculino ou Feminino): ");
        String sexo =sc.nextLine();

        System.out.println("Entre com o salário: ");
        double salario = Double.parseDouble(sc.nextLine());

        Garcom garcom = new Garcom(nome,CPF,dataNascimento,email,sexo,salario);
        garcons.add (garcom);

    }

    private static void mostraMenu(){
        System.out.println("Menu");
        System.out.println("1: Cadastrar Garçon ");
        System.out.println("2: Remover Garçon ");
        System.out.println("3: Cadastrar Mesa ");
        System.out.println("4: Remover Mesa ");
        System.out.println("5: Atendimento ");
        // 7.1: Reservar mesa
        // 7.2: Atender mesa
        // 7.3: Fechar mesa
        System.out.println("6: Buscar Mesa pelo Número ");
        System.out.println("7: Buscar Mesa pela Capacidade ");
        System.out.println("8: Buscar Mesas pelo Garçom ");
        System.out.println("9:Relatórios ");
        //11.1 :Relatório de Mesas Livres
        //11.2: Relatório de Mesas Ocupadas
        //11.3: Relatório de todas Mesas atendidas pelo garçom
        System.out.println("10:Quantidade de Mesas está sendo atendidas pelo garçom");
        System.out.println("11: Sair do programa");
        // ler opcao do menu
        // exemplo: se for op == 1
        // chamar funcao para cadastrar garcom
        // 1. Cadastrar garcon vai criar um carcon
        // 1.1 Addicinar garcom na lista de garçom

        // Exemplo: se for cadastrar mesa
        // 1. Criar funcao de cadastrar mesa (CRUD)
        //
    }
}

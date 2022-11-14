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
                case 1:
                    cadastrarGarcom(sc);
                    break;
                case 2:
                    removeGarcom(sc);
                    break;
                case 3:
                    cadastrarMesa(sc);
                    break;
                case 4:
                    removeMesa(sc);
                    break;
                case 5:
                    realizaAtendimento(sc);
                    break;
                case 6:
                    buscarMesaNum(sc);
                    break;
                case 7:
                    buscarMesaCap (sc);
                    break;
                case 8:
                    buscarMesaGarcom (sc);
                    break;


            }
        }
    }

    private static void buscarMesaGarcom(Scanner sc) {
        System.out.println("Digite o Código do garçom  da mesa que  deseja localizar: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);
            if (mesaVetor.getGarcom() == codigoGarcom ) { //ver como vamos localizar pelo codigo
                System.out.println(mesas.get(i));  /// verificar o tostring
            }
            else {
                System.out.println("Não tem mesa compativel com a quantidade solicidada  ");
            }

        }

    }

    private static void buscarMesaCap(Scanner sc) {
        System.out.println("Digite a quantidade da capacidade da mesa que  deseja localizar: ");
        int capacidadeMesa = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);
            if (mesaVetor.getCapacidade() == capacidadeMesa && mesaVetor.getCapacidade() > capacidadeMesa) {
                System.out.println(mesas.get(i));  /// verificar o tostring
            }
            else {
                System.out.println("Não tem mesa compativel com a quantidade solicidada  ");
            }

        }

    }

    private static void buscarMesaNum(Scanner sc) {
        System.out.println("Digite o número da mesa deseja localizar: ");
        int numeroMesa = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);
            if (mesaVetor.getNumMesa() == numeroMesa) {
                System.out.println(mesaVetor.getNumMesa());  /// verificar o tostring
            }
            else {
                System.out.println("Mesa não cadastrada");
            }

        }
    }


    private static void realizaAtendimento(Scanner sc) {
        // 7.1: Reservar mesa
        // 7.2: Atender mesa
        // 7.3: Fechar mesa
        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Reservar Mesa ");
        System.out.println("2: Atender Mesa ");
        System.out.println("3: Fechar Mesa ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1: //reservar
                System.out.println("Digite o número da mesa para reservar: ");
                int numeroMesa = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            mesaVetor.setSituacao("Reservada");
                            System.out.println("Mesa reservada com sucesso!!");

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            System.out.println("Mesa está ocupada ");

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já tem reserva cadastrada");
                        } else {
                            System.out.println("Verificar Situação da mesa no cadastro: ");
                        }
                    }
                }
                break;
            case 2: //atender
                System.out.println("Digite o número da mesa para registrar Atendimento: ");
                int numeroMesa2 = Integer.parseInt(sc.nextLine());


                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa2) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            mesaVetor.setSituacao("Ocupada");
                            System.out.println("Mesa Ocupada com sucesso!!");

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já tem reserva cadastrada, deseja registrar atendimento? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Ocupada");
                                System.out.println("Mesa Ocupada com sucesso!!");
                            } else {
                                break;
                            }
                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            System.out.println("Mesa situação de ocupada, deseja registrar atendimento? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Ocupada");
                                System.out.println("Mesa Ocupada com sucesso!!");
                            } else {
                                break; // ou retarn
                            }
                        }
                    }
                }
                break;
            case 3: //fechar
                System.out.println("Digite o número da mesa para registrar fechamento: ");
                int numeroMesa3 = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa3) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            mesaVetor.setSituacao("Livre");
                            System.out.println("Mesa Fechada com sucesso, está livre para novos clientes!!");

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            System.out.println("Mesa não teve atendimento registrado! ");

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já tem reserva cadastrada, deseja cancelar a reserva? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Livre");
                                System.out.println("Cancelamento da Reserva com sucesso!!");
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;

        }
    }


    private static void removeMesa(Scanner sc) {
        System.out.println("Digite o número da mesa para remover: ");
        int numeroMesa = Integer.parseInt(sc.nextLine());
        boolean achou = false;

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);

            if (mesaVetor.getNumMesa() == numeroMesa) {
                mesas.remove(i);
                achou = true;
                break;
            }
        }

        if (!achou) {
            System.out.println("Mesa não cadastrada");
        }
    }


    private static void cadastrarMesa(Scanner sc) {

        if (garcons.size() == 0) {
            System.out.println("Cadastre pelo menos um garom");
            return;
        }

        System.out.println("Entre com número da mesa: ");
        int numeroMesa = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesavetor = mesas.get(i);

            if (numeroMesa == mesavetor.getNumMesa()) {
                System.out.println("Mesa já Cadastrada!! ");
                return;
            }
        }


        System.out.println("Entre com a Situação da mesa =  Livre, Ocupada ou Reservada :");
        String situacaoMesa = sc.nextLine();

        System.out.println("Entre com a capacidade de clientes da mesa: ");
        int capacidadeMesa = Integer.parseInt(sc.nextLine());

        System.out.println("Entre com o código do garçom responsável: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());
        boolean achouGarcom = false;
        for (int i = 0; i < garcons.size(); i++) {
            Garcom garcomVetor = garcons.get(i);

            if (codigoGarcom == garcomVetor.getCodigo()) {

                Mesa mesa = new Mesa(numeroMesa, situacaoMesa, capacidadeMesa, garcomVetor);
                mesas.add(mesa);
                achouGarcom = true;
                break;
            }
        }

        if (!achouGarcom) {
            System.out.println("Garçom não cadastrado, cadastre o Garçom primeiro");
        }
    }


    private static void removeGarcom(Scanner sc) {
        System.out.println("Digite o código do Garçom para remover: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());
        boolean achou = false;

        for (int i = 0; i < garcons.size(); i++) {
            Garcom garcomVetor = garcons.get(i);

            if (garcomVetor.getCodigo() == codigoGarcom) {
                garcons.remove(i);
                achou = true;
                break;
            }
        }

        if (!achou) {
            System.out.println("Garçom não cadastrado");
        }
    }

    private static void cadastrarGarcom(Scanner sc) {
        System.out.println("Entre com o Código do Garçom: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());

        System.out.println("Entre com Nome do Garçom: ");
        String nome = sc.nextLine();

        System.out.println("Entre com o CPF: ");
        String CPF = sc.nextLine();

        System.out.println("Entre com a Data de Nascimento dd/mm/aa: ");
        String dataNascimento = sc.nextLine();

        System.out.println("Entre com o e-mail: ");
        String email = sc.nextLine();

        System.out.println("Entre como  sexo (Masculino ou Feminino): ");
        String sexo = sc.nextLine();

        System.out.println("Entre com o salário: ");
        double salario = Double.parseDouble(sc.nextLine());

        Garcom garcom = new Garcom(codigoGarcom, nome, CPF, dataNascimento, email, sexo, salario);
        garcons.add(garcom);

    }

    private static void mostraMenu() {
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

import dominio.Garcom;
import dominio.Pessoa;
import dominio.Mesa;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteProjetoFinal {
    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private static ArrayList<Pessoa> garcons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 12) {

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
                    alterarGarcomMesa(sc);
                    break;
                case 6:
                    realizaAtendimento(sc);
                    break;
                case 7:
                    buscarMesa(sc);
                    break;
                case 8:
                    gerarRelatorios(sc);
                    break;
                case 9:
                    qtdMesaGarcom(sc);
                    break;
                case 10:
                default:
                    System.out.println("Encerrando o programa...");


            }
        }
    }

    private static void qtdMesaGarcom(Scanner sc) {
        System.out.println("Digite o código do Garçom:");
        int codigoGarcom = Integer.parseInt(sc.nextLine());
        int contagem = 0;
        boolean achou = false ;

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);
            if (mesaVetor.getGarcom().getCodigo() == codigoGarcom) {
                achou = true;
                if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                    contagem++;
                }
            }
        }
            System.out.println("O Garçom  tem " + contagem + " atendimento(s)");


        if (!achou) {
            System.out.println("Não existe atendimento para o Garçom solicitado... ");
        }
            return;

    }

    private static void gerarRelatorios(Scanner sc) {
        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Relatório de mesas livres: ");
        System.out.println("2: Relatório de mesas ocupadas:");
        System.out.println("3: Relatório de mesas reservadas: ");
        System.out.println("4: Relatório de todas as mesas em atendimento do Garçom");
        System.out.println("5: Relatório de mesas todas atendidas pelo Garçom: ");
        System.out.println("6: Relatório de dados do Garçom: ");
        System.out.println("7: Relatório de todos os Garçom cadastrados: ");
        System.out.println("8: Voltar para menu anterior! ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                boolean achou = false;
                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);

                    if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                        System.out.println("Número da mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n" +
                                "Nome do Garçom: " + mesaVetor.getGarcom().getNome() + "\n");
                        achou = true;
                    }
                }

                if (!achou) {
                    System.out.println("Não tem mesa Livre no momento...  ");
                    return;
                }
                break;
            case 2:
                boolean achou2 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);

                    if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                        System.out.println("Número da mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n" +
                                "Nome do Garçom: " + mesaVetor.getGarcom().getNome() + "\n");
                        achou2 = true;
                    }
                }
                if (!achou2) {
                    System.out.println("Não tem mesa Ocupada no momento... ");
                    return;
                }

                break;
            case 3:
                boolean achou3 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);

                    if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                        System.out.println("Número da mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n" +
                                "Nome do Garçom: " + mesaVetor.getGarcom().getNome() + "\n");

                        achou3 = true;
                    }
                }

                if (!achou3) {
                    System.out.println("Não tem mesa Reservada no momento... ");
                    return;
                }

                break;
            case 4:
                System.out.println("Digite o código do Garçom:");
                int codigoGarcom = Integer.parseInt(sc.nextLine());
                Boolean achou4 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getGarcom().getCodigo() == codigoGarcom && mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                        System.out.println("Número da mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n" +
                                "Nome do Garçom: " + mesaVetor.getGarcom().getNome() + "\n");
                        achou4 = true;
                    }
                }
                if (!achou4) {
                    System.out.println("Não exite mesa em atendimento  para o Garçom solicitado!");
                    return;
                }
                break;
            case 5:
                System.out.println("Digite o código do Garçom:");
                int codigoGarcom2 = Integer.parseInt(sc.nextLine());
                boolean achou5 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getGarcom().getCodigo() == codigoGarcom2) {
                        System.out.println("Número da mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Situação: " + mesaVetor.getSituacao() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n" +
                                "Nome do Garçom: " + mesaVetor.getGarcom().getNome() + "\n");
                        achou5 = true;
                    }
                }
                if (!achou5) {
                    System.out.println("Não tem mesa cadastrada para o Garçom solicitado  ");
                    return;
                }
                break;
            case 6:
                System.out.println("Digite o código do Garçom:");
                int codigoGarcom3 = Integer.parseInt(sc.nextLine());
                boolean achou6 = false;

                for (int i = 0; i < garcons.size(); i++) {
                    Pessoa garcomVetor = garcons.get(i);

                    if (garcomVetor.getCodigo() == codigoGarcom3) {
                        System.out.println("Código: " + garcomVetor.getCodigo() + "\n" +
                                "Nome: " + garcomVetor.getNome() + "\n" +
                                "Cpf: " + garcomVetor.getCPF() + "\n" +
                                "Data de Nascimneto: " + garcomVetor.getDataNascimento() + "\n" +
                                "E-mail: " + garcomVetor.getEmail() + "\n" +
                                "Sexo: " + garcomVetor.getSexo() + "\n" +
                                "Salário: " + garcomVetor.getSalario() + "\n");

                        achou6 = true;
                        break;
                    }
                }
                if (!achou6) {
                    System.out.println("Garçom não cadastrado.  ");
                    return;
                }
                break;


            case 7:
                boolean achou7 = false;
                for (int i = 0; i < garcons.size(); i++) {
                    Pessoa garcomVetor = garcons.get(i);
                    System.out.println("Código: " + garcomVetor.getCodigo() + "\n" +
                            "Nome: " + garcomVetor.getNome() + "\n" +
                            "Cpf: " + garcomVetor.getCPF() + "\n" +
                            "Data de Nascimneto: " + garcomVetor.getDataNascimento() + "\n" +
                            "E-mail: " + garcomVetor.getEmail() + "\n" +
                            "Sexo: " + garcomVetor.getSexo() + "\n" +
                            "Salário: " + garcomVetor.getSalario() + "\n");
                    achou7 = true;
                }
                if (!achou7) {
                    System.out.println("Não tem garçons cadastrados.  ");
                    return;
                }

            case 8:
            default:
                System.out.println();
        }
    }

    private static void buscarMesa(Scanner sc) {

        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Buscar mesa pelo código do garçom: ");
        System.out.println("2: Buscar mesa pela capacidade:");
        System.out.println("3: Buscar mesa pelo número da mesa: ");
        System.out.println("4: Para voltar ao menu anterior: ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                System.out.println("Digite o Código do garçom : ");
                int codigoGarcom = Integer.parseInt(sc.nextLine());
                boolean achou = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);

                    if (mesaVetor.getGarcom().getCodigo() == codigoGarcom) {
                        System.out.println("Número Mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Situação: " + mesaVetor.getSituacao() + "\n" +
                                "Capacidade: " + mesaVetor.getCapacidade() + "\n" +
                                "Nome Garçom: " + mesaVetor.getGarcom().getNome() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n");

                        achou = true;
                    }
                }
                if (!achou) {
                    System.out.println("Não tem mesa cadastrada para o Garçom solicitado  ");
                    return;
                }
                break;
            case 2:
                System.out.println("Digite a quantidade da capacidade da mesa que  deseja localizar: ");
                int capacidadeMesa = Integer.parseInt(sc.nextLine());
                boolean achou2 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getCapacidade() >= capacidadeMesa &&
                            mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                        System.out.println("Número Mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Capacidade: " + mesaVetor.getCapacidade() + "\n" +
                                "Situação: " + mesaVetor.getSituacao() + "\n" +
                                "Nome Garçom: " + mesaVetor.getGarcom().getNome() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n");
                        achou2 = true;

                    }
                }

                if (!achou2) {
                    System.out.println("Não tem mesa disponivel pela capacidade. ");
                    return;
                }
                break;
            case 3:
                System.out.println("Digite o número da mesa deseja localizar: ");
                int numeroMesa = Integer.parseInt(sc.nextLine());
                boolean achou3 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa) {
                        System.out.println("Número Mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Situação: " + mesaVetor.getSituacao() + "\n" +
                                "Capacidade: " + mesaVetor.getCapacidade() + "\n" +
                                "Nome Garçom: " + mesaVetor.getGarcom().getNome() + "\n" +
                                "Código Garçom: " + mesaVetor.getGarcom().getCodigo() + "\n");
                        achou3 = true;
                        break;
                    }
                }

                if (!achou3) {
                    System.out.println("Mesa não cadastrada");
                    return;
                }
                break;
            case 4:
            default:
                System.out.println();
        }
    }


    private static void realizaAtendimento(Scanner sc) {  //se colocar o cod errado da mesa não aparece a mensagem
        // 7.1: Reservar mesa
        // 7.2: Atender mesa
        // 7.3: Fechar mesa
        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Reservar Mesa ");
        System.out.println("2: Atender Mesa ");
        System.out.println("3: Fechar Mesa ");
        System.out.println("4: Voltar para menu anterior! ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1: //reservar
                System.out.println("Digite o número da mesa para reservar: ");
                int numeroMesa = Integer.parseInt(sc.nextLine());
                boolean achou = false ;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            mesaVetor.setSituacao("Reservada");
                            System.out.println("Mesa reservada com sucesso!!");
                            achou = true;
                            return;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            System.out.println("Mesa está ocupada ");

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já tem reserva cadastrada");
                        } else {
                            System.out.println("Verificar Situação da mesa no cadastro: ");
                        }
                    }
                }
                if (!achou) {
                    System.out.println("Mesa não cadastrada ");
                }
                break;
            case 2: //atender
                System.out.println("Digite o número da mesa para registrar Atendimento: ");
                int numeroMesa2 = Integer.parseInt(sc.nextLine());
                boolean achou2 = false ;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa2) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            mesaVetor.setSituacao("Ocupada");
                            System.out.println("Mesa Ocupada com sucesso!!");
                            achou2 = true ;
                            return;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já tem reserva cadastrada, deseja registrar atendimento? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Ocupada");
                                System.out.println("Mesa Ocupada com sucesso!!");
                                achou2 = true ;
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
                                achou2 = true ;
                                return;
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (!achou2) {
                    System.out.println("Mesa não cadastrada ");
                }
                break;
            case 3: //fechar
                System.out.println("Digite o número da mesa para registrar fechamento: ");
                int numeroMesa3 = Integer.parseInt(sc.nextLine());
                boolean achou3 = false;
                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa3) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            mesaVetor.setSituacao("Livre");
                            System.out.println("Mesa Fechada com sucesso, está livre para novos clientes!!");
                            achou3 = true ;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            System.out.println("Mesa não teve atendimento registrado! ");
                            achou3 = true ;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já tem reserva cadastrada, deseja cancelar a reserva? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Livre");
                                System.out.println("Cancelamento da Reserva com sucesso!!");
                                achou3 = true ;
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (!achou3) {
                    System.out.println("Mesa não cadastrada ");
                }
                break;
            case 4:
            default:
                System.out.println();

        }
    }

    private static void alterarGarcomMesa(Scanner sc) {
        System.out.println("Digite o número da mesa para alterar : ");
        int numeroMesa = Integer.parseInt(sc.nextLine());
        boolean achou = false;

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);
            if (mesaVetor.getNumMesa() == numeroMesa) {
                System.out.println("Entre com o código do novo garçom responsavel pela mesa ");
                int codigoGarcom2 = Integer.parseInt(sc.nextLine());

                achou = false;

                for (int j = 0; j < garcons.size(); j++) {
                    Pessoa garcomVetor2 = garcons.get(j);

                    if (codigoGarcom2 == garcomVetor2.getCodigo()) {
                        mesaVetor.setGarcom(garcomVetor2);


                        System.out.println("Alteração de Garçom realizada com sucesso!!");

                        achou = true;
                        break;
                    }
                }
                if (!achou) {
                    System.out.println("Garçom não cadastrado");
                }
            }
        }
        if (!achou) {
            System.out.println("Mesa não cadastrada");
        }
    }

    private static void removeMesa(Scanner sc) {
        System.out.println("Digite o número da mesa para remover: ");
        int numeroMesa = Integer.parseInt(sc.nextLine());
        boolean achou = false;

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);


            if (mesaVetor.getNumMesa() == numeroMesa &&
                    mesaVetor.getSituacao().equalsIgnoreCase("livre")) {
                mesas.remove(i);
                System.out.println("Mesa removida com sucesso!");
                achou = true;
                break;
            } else {
                System.out.println("Mesa está com status de Ocupada ou Reservada, fazer o fechamento antes de excluir");
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
        String situacaoMesa = "livre";

        System.out.println("Entre com a capacidade de clientes da mesa: ");
        int capacidadeMesa = Integer.parseInt(sc.nextLine());

        System.out.println("Entre com o código do garçom responsável: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());
        boolean achouGarcom = false;
        for (int i = 0; i < garcons.size(); i++) {
            Pessoa garcomVetor = garcons.get(i);

            if (codigoGarcom == garcomVetor.getCodigo()) {

                Mesa mesa = new Mesa(numeroMesa, situacaoMesa, capacidadeMesa, garcomVetor);
                mesas.add(mesa);
                System.out.println("Mesa cadastrada com sucesso!!");

                achouGarcom = true;
                break;
            }
        }

        if (!achouGarcom) {
            System.out.println("Garçom não cadastrado, cadastre o Garçom primeiro");
            System.out.println("Digite a opção:");
            System.out.println("1: Cadastrar Garçom: ");
            System.out.println("2: Voltar ao cadastro mesa: ");
            System.out.println("3: Voltar ao menu principal: ");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarGarcom(sc);
                    System.out.println("Realize o cadastro da mesa!!");
                    cadastrarMesa(sc);
                    break;
                case 2:
                    cadastrarMesa(sc);
                    break;
                case 3:
                default:
                    System.out.println();
            }
        }
    }


    private static void removeGarcom(Scanner sc) { // quando digita o codigo errado do garçom nao apresenta mensagem
        System.out.println("Digite o código do Garçom para remover: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());
        boolean achou = false;

        for (int i = 0; i < garcons.size(); i++) {
            Pessoa garcomdeletar = garcons.get(i);

            if (garcomdeletar.getCodigo() == codigoGarcom) { //verifica se o codigo do garçom está no bd de garçom
                System.out.println("Digite o código do novo garçom!");
                int codigoGarcom2 = Integer.parseInt(sc.nextLine());


                for (int j = 0; j < garcons.size(); j++) {
                    Pessoa garcomVetor2 = garcons.get(j);

                    if (codigoGarcom2 == garcomVetor2.getCodigo()) {  // verifica se o novo garçom esta cadastrado
                        garcons.remove(garcomdeletar);  // remove o garçom antigo do bd da lista de garçom

                        for (int n = 0; n < mesas.size(); n++) {
                            Mesa mesavetor = mesas.get(i);

                            if (mesavetor.getGarcom().getCodigo() == codigoGarcom) {  //verifica se o codi do antigo garçom para substituir para novo
                                mesavetor.setGarcom(garcomVetor2);

                                System.out.println("Alteração de Garçom realizada com sucesso!!");

                                achou = true;
                            }
                        }
                    }
                }
            }
        }

                if (!achou) {
                    System.out.println("Para fazer a alteração, cadastre o novo garçom primeiro");
                }

    }

    private static void cadastrarGarcom(Scanner sc) {
        System.out.println("Entre com o Código do Garçom: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < garcons.size(); i++) {
            Pessoa garcomVetor = garcons.get(i);

            if (garcomVetor.getCodigo() == codigoGarcom) {
                System.out.println("Código já cadastrado");
                ;
                return;
            }
        }

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

        Pessoa garcom = new Garcom(codigoGarcom, nome, CPF, dataNascimento, email, sexo, salario);
        garcons.add(garcom);
        System.out.println("Garçom cadastrado com sucesso!!");


    }

    private static void mostraMenu() {
        System.out.println("Menu");
        System.out.println("1: Cadastrar Garçon ");
        System.out.println("2: Remover Garçon ");
        System.out.println("3: Cadastrar Mesa ");
        System.out.println("4: Remover Mesa ");
        System.out.println("5: Alterar Garçom da Mesa ");
        System.out.println("6: Atendimento ");
        // 7.1: Reservar mesa ok
        // 7.2: Atender mesa ok
        // 7.3: Fechar mesa ok
        System.out.println("7: Buscar Mesa ");
        //8.1: Buscar Mesa pelo código do garçom
        //8.2: Buscar Mesa pela capacidade
        //8.3: Buscar Mesa pelo numero da mesa
        System.out.println("8:Relatórios ");
        //11.1 :Relatório de Mesas Livres ok
        //11.2: Relatório de Mesas Ocupadas ok
        //11.3: Relatório de Mesas Reservadas ok
        //11.4: Relatório de todas Mesas atendidas pelo garçom ok
        //11.5: Relatório de todas as mesas em atendimento do Garçom ok
        //11.6: Relatório de dados do Garçom
        //11.7: Relatório de todos os Garçom cadastrados
        System.out.println("9:Quantidade de Mesas está sendo atendidas pelo garçom");
        System.out.println("10: Sair do programa");

    }
}

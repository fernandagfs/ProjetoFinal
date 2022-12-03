import bancodados.Conexao;
import bancodados.GarcomBanco;
import bancodados.MesaBanco;
import dominio.Garcom;
import dominio.Mesa;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteProjetoFinal {
    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private static ArrayList<Garcom> garcons = new ArrayList<>();
    private static Connection conexao = Conexao.getInstance();
    private static GarcomBanco garcomBanco;
    private static MesaBanco mesaBanco;

    public static void main(String[] args) {
        instanciarBancos(conexao);


        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 10) {

            mostraMenu();
            System.out.println("Entre com a opção desejada: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    cadastrarMesa(sc);
                    break;
                case 2:
                    removeMesa(sc);
                    break;
                case 3:
                    buscarMesa(sc);
                    break;
                case 4:
                    alteraSituacaoMesa(sc);
                    break;
                case 5:
                    cadastrarGarcom(sc);
                    break;
                case 6:
                    removeGarcom(sc);
                    break;
                case 7:
                    alterarGarcomMesa(sc);
                    break;
                case 8:
                    buscarGarcom(sc);
                    break;
                case 9:
                    gerarRelatorios(sc);
                    break;
                case 10:
                default:
                    System.out.println("Encerrando o programa...");


            }
        }
    }

    private static void instanciarBancos(Connection conexao) {
        garcomBanco = new GarcomBanco(conexao);
        mesaBanco = new MesaBanco(conexao);
    }

    private static void buscarGarcom(Scanner sc) {

        System.out.println("Digite o e-mail do Garçom:");
        String emailGarcom = sc.nextLine();
        boolean achou6 = false;

        for (int i = 0; i < garcons.size(); i++) {
            Garcom garcomVetor = garcons.get(i);

            if (garcomVetor.getEmail() .equalsIgnoreCase(emailGarcom)) {
                System.out.println("Código: " + garcomVetor.getCodigo() + "\n" +
                        "Nome: " + garcomVetor.getNome() + "\n" +
                        "Cpf: " + garcomVetor.getCPF() + "\n" +
                        "Data de Nascimneto: " + garcomVetor.getDataNascimento() + "\n" +
                        "E-mail: " + garcomVetor.getEmail() + "\n" +
                        "Sexo: " + garcomVetor.getSexo() + "\n" +
                        "Salário: " + garcomVetor.getSalarioFixo() + "\n");

                achou6 = true;
                break;
            }
        }
        if (!achou6) {
            System.out.println("Garçom não cadastrado ou e-mail digitado incorreto!  ");
        }
    }

    private static void gerarRelatorios(Scanner sc) {
        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Relatório de mesas livres: ");
        System.out.println("2: Relatório de mesas ocupadas:");
        System.out.println("3: Relatório de todas as  mesas que o Garçom atende: ");
        System.out.println("4: Relatório de quantidade de mesas em atendimento: ");
        System.out.println("5: Voltar para menu anterior! ");

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
                    System.out.println("Não tem mesa  com situação Livre no momento...  ");
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
                    System.out.println("Não tem mesa com situação de Ocupada no momento... ");
                    return;
                }
                break;

            case 3:
                System.out.println("Digite o código do Garçom:");
                int codigoGarcom = Integer.parseInt(sc.nextLine());
                Boolean achou4 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getGarcom().getCodigo() == codigoGarcom ) {
                        System.out.println("Número da mesa: " + mesaVetor.getNumMesa() + "\n" +
                                "Situação da Mesa: " + mesaVetor.getSituacao() +"\n" +
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

            case 4:
                System.out.println("Digite o código do Garçom:");
                int codigoGarcom4 = Integer.parseInt(sc.nextLine());
                int contagem = 0;
                boolean achou7 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getGarcom().getCodigo() == codigoGarcom4) {
                        achou7 = true;
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            contagem++;
                        }
                    }
                }
                System.out.println("O Garçom  tem " + contagem + " mesas em atendimento");


                if (!achou7) {
                    System.out.println("Não existe atendimento para o Garçom solicitado... ");
                }
                return;

            case 5:
            default:
                System.out.println();
        }
    }

    private static void buscarMesa(Scanner sc) {

        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Buscar mesa pela capacidade:");
        System.out.println("2: Buscar mesa pelo número da mesa: ");
        System.out.println("3: Para voltar ao menu anterior: ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
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
            case 2:
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
            case 3:
            default:
                System.out.println();
        }
    }


    private static void alteraSituacaoMesa(Scanner sc) {  //se colocar o cod errado da mesa não aparece a mensagem
        // 4.1: Reservar mesa
        // 4.2: Ocupada mesa
        // 4.3: Livre mesa
        System.out.println("Digite a opção desejada: ");
        System.out.println("1: Alterar para Reservada ");
        System.out.println("2: Alterar para Ocupada ");
        System.out.println("3: Alterar para Livre ");
        System.out.println("4: Voltar para menu anterior! ");

        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1: //reservar
                System.out.println("Digite o número da mesa para alterar para Reservada: ");
                int numeroMesa = Integer.parseInt(sc.nextLine());
                boolean achou = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            mesaVetor.setSituacao("Reservada");
                            System.out.println("Mesa alterada com sucesso para Reservada!!");
                            achou = true;
                            return;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            System.out.println("Mesa está ocupada, deseja alterar para Reservada? ");
                            System.out.println("Sim ou Não");
                            String opcao1 = sc.nextLine();

                            if (opcao1.equalsIgnoreCase("sim")) {
                                mesaVetor.setSituacao("Reservada");
                                System.out.println("Mesa alterada com sucesso para Reservada!!");
                                achou = true;
                            } else {
                                return;
                            }
                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa já está com situação Reservada ");
                            achou = true;
                            break;
                        }
                    }
                }
                if (!achou) {
                    System.out.println("Mesa não cadastrada ");
                }
                break;
            case 2: //ocupada
                System.out.println("Digite o número da mesa para alterar para Ocupada: ");
                int numeroMesa2 = Integer.parseInt(sc.nextLine());
                boolean achou2 = false;

                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa2) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            mesaVetor.setSituacao("Ocupada");
                            System.out.println("Mesa alterada com sucesso para Ocupada!!");
                            achou2 = true;
                            return;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa com situação Reservada, deseja registrar alteração para Ocupada? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Ocupada");
                                System.out.println("Mesa alterada com sucesso para Ocupada!!");
                                achou2 = true;
                            } else {
                                return;
                            }
                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            System.out.println("Mesa situação já está com situação  de ocupada ");
                            achou2 = true;
                                break;
                            }
                        }
                    }
                if (!achou2) {
                    System.out.println("Mesa não cadastrada ");
                }
                break;
            case 3: //livre
                System.out.println("Digite o número da mesa para registrar alteração para Livre: ");
                int numeroMesa3 = Integer.parseInt(sc.nextLine());
                boolean achou3 = false;
                for (int i = 0; i < mesas.size(); i++) {
                    Mesa mesaVetor = mesas.get(i);
                    if (mesaVetor.getNumMesa() == numeroMesa3) {
                        if (mesaVetor.getSituacao().equalsIgnoreCase("Ocupada")) {
                            mesaVetor.setSituacao("Livre");
                            System.out.println("Mesa alterada com sucesso para Livre!");
                            achou3 = true;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Livre")) {
                            System.out.println("Mesa já está com situação Livre! ");
                            achou3 = true;

                        } else if (mesaVetor.getSituacao().equalsIgnoreCase("Reservada")) {
                            System.out.println("Mesa está com situação de  reservada, deseja alterar para Livre? ");
                            System.out.println("Sim ou Não");
                            String opcao2 = sc.nextLine();
                            achou3 = true;
                            if (opcao2.equalsIgnoreCase("Sim")) {
                                mesaVetor.setSituacao("Livre");
                                System.out.println("Mesa alterada com sucesso para  Livre!!");
                                achou3 = true;
                            } else {
                               return;
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
        boolean achouMesa = false;

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);
            if (mesaVetor.getNumMesa() == numeroMesa) {
                System.out.println("Entre com o código do novo garçom responsavel pela mesa ");
                int codigoGarcom2 = Integer.parseInt(sc.nextLine());

                achouMesa = true;
               boolean achouGarcom = false ;

                for (int j = 0; j < garcons.size(); j++) {
                    Garcom garcomVetor2 = garcons.get(j);

                    if (codigoGarcom2 == garcomVetor2.getCodigo()) {
                        mesaVetor.setGarcom(garcomVetor2);


                        System.out.println("Alteração de Garçom realizada com sucesso!!");

                        achouGarcom= true;
                        break;
                    }
                }
                if (!achouGarcom) {
                    System.out.println("Garçom não cadastrado");
                }
            }
        }
        if (!achouMesa) {
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

            }
        }
        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaVetor = mesas.get(i);

            if (mesaVetor.getNumMesa() == numeroMesa &&
                    mesaVetor.getSituacao().equalsIgnoreCase("ocupada") ||
                    mesaVetor.getNumMesa() == numeroMesa &&
                            mesaVetor.getSituacao().equalsIgnoreCase("reservada")) {
                System.out.println("Mesa com situação de Ocupada ou Reservada, fazer a alteração para livre da mesa      para excluir!");
                achou = true;
            }
        }

        if (!achou) {
            System.out.println("Mesa não cadastrada");
        }
    }
    private static void cadstrarMesaBanco (Mesa mesa) {
        mesaBanco.salvarMesa (mesa);
    }


    private static void cadastrarMesa(Scanner sc) {

        if (garcons.size() == 0) {
            System.out.println("Cadastre pelo menos um garçom");
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
            Garcom garcomVetor = garcons.get(i);

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


    private static void removeGarcom(Scanner sc) {
        System.out.println("Digite o código do Garçom para remover: ");
        int codigoGarcomRemover = Integer.parseInt(sc.nextLine());

        // Verifica se o garcom existe
        Garcom garcomEncontrado = garcomBanco.buscarPorCodigo(codigoGarcomRemover);
        if (garcomEncontrado == null) {
            System.out.println("Código do garcom não encontrado");
            return;
        }

        System.out.println("Digite o código do novo garçom!");
        int codigoGarcomNovo = Integer.parseInt(sc.nextLine());

        // Verifica se o garcom novo existe
        Garcom garcomNovoEncontrado = garcomBanco.buscarPorCodigo(codigoGarcomNovo);
        if (garcomNovoEncontrado == null) {
            System.out.println("Código do garcom não encontrado");
            return;
        }
       // Buscar a mesa por código do garcom antigo
       // Substituir o garcom antigo pelo novo nessa mesa
       // Salvar a mesa com o garcom novo
       // Excluir o garcom antigo
        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesaAtual = mesas.get(i);

            // Verificar onde ele estava para substituir nas mesas
            if (mesaAtual.getGarcom().getCodigo() == codigoGarcomRemover) {

                // substitui o garcom
                mesaAtual.setGarcom(garcomSubstituir);

            }
        }
        if (novoGarcomExiste = true) {
            for (int i = 0; i < garcons.size(); i++) {
                Garcom garcomDeletar = garcons.get(i);
                if (codigoGarcomRemover == garcomDeletar.getCodigo()) {
                    garcons.remove(i);
                    break;
                }
            }
        }


        System.out.println("Garcom alterado com sucesso");
    }

    private static void cadastrarGarcomBanco(Garcom garcom) {
        garcomBanco.salvar(garcom);
    }

    private static void cadastrarGarcom(Scanner sc) {
        System.out.println("Entre com o Código do Garçom: ");
        int codigoGarcom = Integer.parseInt(sc.nextLine());

        // primeira validacao por codigo duplicado
        Garcom garcomEncontrado = garcomBanco.buscarPorCodigo(codigoGarcom);
        if (garcomEncontrado != null) {
            System.out.println("Código do garcom já cadastrado");
            return;
        }

        System.out.println("Entre com o e-mail: ");
        String email = sc.nextLine();

        // Validar se já existe email
        Garcom garcomEmailEncontrado = garcomBanco.buscarPorEmail(email);
        if (garcomEmailEncontrado != null) {
            System.out.println("Email do garcom já cadastrado");
            return;
        }

        System.out.println("Entre com Nome do Garçom: ");
        String nome = sc.nextLine();

        System.out.println("Entre com o CPF: ");
        String CPF = sc.nextLine();

        System.out.println("Entre com a Data de Nascimento dd/mm/aa: ");
        String dataNascimento = sc.nextLine();

        System.out.println("Entre como  sexo (Masculino ou Feminino): ");
        String sexo = sc.nextLine();

        System.out.println("Entre com o salário: ");
        double salario = Double.parseDouble(sc.nextLine());

        System.out.println("Entre como o telefone: ");
        String telefone = sc.nextLine();

        Garcom garcom = new Garcom(codigoGarcom, nome, CPF, dataNascimento, email, sexo, salario, telefone);
        cadastrarGarcomBanco(garcom);
        System.out.println("Garçom cadastrado com sucesso!!");
    }

    private static void mostraMenu() {
        System.out.println("Menu");
        System.out.println("1: Cadastrar Mesa ");
        System.out.println("2: Remover Mesa ");
        System.out.println("3: Buscar Mesa ");
        //3.1: Buscar Mesa pela capacidade
        //3.2: Buscar Mesa pelo numero da mesa
        System.out.println("4: Alterar situação da Mesa ");
        // 4.1: Alterar para Reservada ok
        // 4.2: Alterar para  Ocupada ok
        // 4.3: Alterar para Livre ok
        System.out.println("5: Cadastrar Garçon ");
        System.out.println("6: Remover Garçon ");
        System.out.println("7: Alterar Garçom da Mesa ");
        System.out.println("8: Buscar Garçom ");
        System.out.println("9: Gerar Relatórios ");
        //9.1 :Relatório de Mesas Livres ok
        //9.2: Relatório de Mesas Ocupadas ok
        //9.3: Relatório de todas Mesas atendidas pelo garçom ok
        //9.4: Quantidade de mesas em atendimento do Garçom ok
        System.out.println("10: Sair do programa");

    }
}

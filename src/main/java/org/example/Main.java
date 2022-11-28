package org.example;

import org.example.model.Cartao;
import org.example.model.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var opcao = 0;
        do {
            printOpcoes();
            opcao = in.nextInt();
            menu(opcao);
        } while (opcao != 6);
    }

    private static void printOpcoes() {
        saudar();
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Cadastrar um cliente ");
        System.out.println("2 - Verificar dia da fatura ");
        System.out.println("3 - Verificar quantos dias falta para fatura ");
        System.out.println("4 - Pagar fatura ");
        System.out.println("5 - Adicionar dias a fatura");
        System.out.println("6 - Sair ");
    }

    private static void saudar() {
        var hora = LocalDateTime.now().getHour();
        if(hora >= 0 && hora <= 11) {
            System.out.println("Bom dia");
        } else if (hora < 18) {
            System.out.println("Boa tarde");
        } else {
            System.out.println("Boa noite");
        }

    }

    // TODO - Tratamentos de erros
    // TODO - Criar enum para opcoes
    private static void menu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                verficarSeDataDaFaturaHoje(clientes.get(0).getCartao().getDataDaFatura());
                break;
            case 3:
                verficarQuantosDiasFatura(clientes.get(0).getCartao().getDataDaFatura());
                break;
            case 4:
                pagarFatura();
                break;
            case 5:
                adicionarDiasAFatura();
                break;
            case 6:
                System.out.println("Obrigado");
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    // TODO Fazer verificacao para nao pular um mes
    private static void adicionarDiasAFatura() {
        Scanner in = new Scanner(System.in);
        System.out.println("Quantos dias vc quer adicionar ?");
        int quantidadeDeDias = in.nextInt();
        System.out.println("Fatura antiga: " + clientes.get(0).getCartao().getDataDaFatura());
        var novaDataFatura = clientes.get(0).getCartao().getDataDaFatura().plusDays(quantidadeDeDias);
        clientes.get(0).getCartao().setDataDaFatura(novaDataFatura);
        System.out.println("Nova Fatura: " + clientes.get(0).getCartao().getDataDaFatura());
    }


    private static void pagarFatura() {
        var dataHoraHoje = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        int hora = dataHoraHoje.getHour();
        if(hora < 8 || hora >= 22) {
            System.out.println("Horario nao permitido");
        } else {
            clientes.get(0).getCartao().setDataDePagamento(dataHoraHoje);
            System.out.println("Data e hora do pagamento " + dataHoraHoje.format(formatter));
        }

    }

    private static void verficarQuantosDiasFatura(LocalDate dataDaFatura) {
        var dataDeHoje = LocalDate.now();
        var quantidadeDeDias = ChronoUnit.DAYS.between(dataDeHoje, dataDaFatura);
        System.out.println("Falta " + quantidadeDeDias + " dias para fatura");
    }

    private static void cadastrarCliente() {
        var dataDaFatura = retornarDataDaFatura();
        var cliente =
                new Cliente("1", "Jesse", new Cartao("2", dataDaFatura));
        clientes.add(cliente);
        System.out.println("O cliente " + cliente.getNome() + " foi cadastrado");
        System.out.println("Data da fatura: " + cliente.getCartao()
                .getDataFormatadaByPattern("dd/MM/yyyy"));
    }


    // TODO criar tratamento de exececao se vier uma string no lugar de inteiro
    private static LocalDate retornarDataDaFatura() {
        Scanner in = new Scanner(System.in);
        System.out.println("Qual dia da fatura que voce deseja ? ");
        var dia = in.nextInt();
        return LocalDate.now().plusMonths(1).withDayOfMonth(dia);
    }

    private static void verficarSeDataDaFaturaHoje(LocalDate dataDaFatura) {
        var dataDeHoje = LocalDate.now();
        if(dataDeHoje.equals(dataDaFatura)) {
            System.out.println("E hoje");
        } else {
            System.out.println("Nao 'e hoje");
        }
    }
}
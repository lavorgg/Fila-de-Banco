import model.Cliente;
import service.SistemaAtendimento;

import java.util.Scanner;

// Gabriel Antunes de Lavor - RA: 0083/25-1
public class Main {
  public static void main(String[] args) {
    SistemaAtendimento sistema = new SistemaAtendimento();
    Scanner sc = new Scanner(System.in);
    String atendentePadrao = "Atendente1";

    while (true) {
      System.out.println("SIMULADOR DE FILA");
      System.out.println("1) Adicionar cliente");
      System.out.println("2) Chamar próximo");
      System.out.println("3) Desfazer último atendimento");
      System.out.println("4) Gerar relatório");
      System.out.println("0) Sair");
      System.out.print("Escolha: ");
      String opt = sc.nextLine().trim();
      if (opt.equals("0"))
        break;

      switch (opt) {
        case "1":
          System.out.print("Nome do cliente: ");
          String nome = sc.nextLine().trim();
          System.out.print("Tipo (Comum/Prioritario): ");
          String tipo = sc.nextLine().trim();
          int p = tipo.equalsIgnoreCase("Prioritario") ? 1 : 0;
          sistema.adicionarCliente(new Cliente(nome, tipo, p));
          System.out.println("Cliente adicionado.");
          break;
        case "2":
          Cliente c = sistema.chamarProximo(atendentePadrao);
          if (c == null)
            System.out.println("Nenhum cliente na fila.");
          else
            System.out.println("Chamando: " + c);
          break;
        case "3":
          boolean ok = sistema.desfazerUltimoAtendimento();
          System.out.println(ok ? "Desfeito" : "Nada para desfazer");
          break;
        case "4":
          System.out.println(sistema.gerarRelatorio());
          break;
        default:
          System.out.println("Opção inválida.");
      }
    }
    sc.close();
  }
}
package service;

import model.Cliente;
import structures.Fila;
import structures.Pilha;
import structures.FilaEncadeada;
import structures.PilhaEncadeada;

import java.util.ArrayList;
import java.util.List;

public class SistemaAtendimento {
  // AGORA usando NOSSAS estruturas encadeadas!
  private Fila<Cliente> filaComum = new FilaEncadeada<>();
  private Fila<Cliente> filaPrioritaria = new FilaEncadeada<>();
  private Pilha<String> historico = new PilhaEncadeada<>();
  private List<Cliente> atendidos = new ArrayList<>();

  public void adicionarCliente(Cliente c) {
    if (c.getPrioridade() > 0)
      filaPrioritaria.enqueue(c);
    else
      filaComum.enqueue(c);
  }

  public Cliente chamarProximo(String nomeAtendente) {
    Cliente proximo = null;
    if (!filaPrioritaria.isEmpty()) {
      proximo = filaPrioritaria.dequeue();
    } else if (!filaComum.isEmpty()) {
      proximo = filaComum.dequeue();
    }
    if (proximo != null) {
      proximo.setAtendente(nomeAtendente);
      atendidos.add(proximo);
      historico.push(String.format("%s atendido por %s", proximo.getNome(), nomeAtendente));
    }
    return proximo;
  }

  public boolean desfazerUltimoAtendimento() {
    if (historico.isEmpty() || atendidos.isEmpty()) {
      return false;
    }
    
    // Remove do histórico
    String ultimoAtendimento = historico.pop();
    
    // Remove o último cliente atendido e re-enfileira
    Cliente ultimoCliente = atendidos.remove(atendidos.size() - 1);
    
    if (ultimoCliente.getPrioridade() > 0) {
      filaPrioritaria.enqueue(ultimoCliente);
    } else {
      filaComum.enqueue(ultimoCliente);
    }
    
    return true;
  }

  public String gerarRelatorio() {
    StringBuilder sb = new StringBuilder();
    sb.append("RELATÓRIO DO SISTEMA\n");
    sb.append("Total atendidos: ").append(atendidos.size()).append("\n");
    sb.append("Fila prioritária: ").append(filaPrioritaria.size()).append(" clientes\n");
    sb.append("Fila comum: ").append(filaComum.size()).append(" clientes\n");
    sb.append("Histórico de atendimentos: ").append(historico.size()).append(" registros\n");
    return sb.toString();
  }
}

package model;

public class Cliente {
  private String nome;
  private String tipoAtendimento; // "Comum" or "Prioritario"
  private int prioridade; // 1 = prioritario, 0 = comum
  private long tempoChegada;
  private String atendente;

  public Cliente(String nome, String tipoAtendimento, int prioridade) {
    this.nome = nome;
    this.tipoAtendimento = tipoAtendimento;
    this.prioridade = prioridade;
    this.tempoChegada = System.currentTimeMillis();
    this.atendente = null;
  }

  public String getNome() {
    return nome;
  }

  public String getTipoAtendimento() {
    return tipoAtendimento;
  }

  public int getPrioridade() {
    return prioridade;
  }

  public long getTempoChegada() {
    return tempoChegada;
  }

  public String getAtendente() {
    return atendente;
  }

  public void setAtendente(String atendente) {
    this.atendente = atendente;
  }

  @Override
  public String toString() {
    return String.format("%s (tipo=%s, prioridade=%d)", nome, tipoAtendimento, prioridade);
  }
}
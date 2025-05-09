package com.server.vendas.server_vendas.usuario;

public enum Cargo {
  SDR("SDR"),
  CLOSER("CLOSER");

  private String cargo;

  private Cargo(String cargo) {
    this.cargo = cargo;
  }

  public String getCargo() {
    return cargo;
  }
}

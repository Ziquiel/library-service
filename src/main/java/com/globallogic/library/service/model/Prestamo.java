package com.globallogic.library.service.model;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class Prestamo {
  private Date fechaDePrestamo;
  private Date fechaDeDevolucion;
  private Usuario usuario;
  private Libro libro;

  //crear constructor de Prestamo con los atributos de la clase libro y usuario seteando la fecha de prestamo con la fecha actual
  public Prestamo(Usuario usuario, Libro libro) {
    this.usuario = usuario;
    this.libro = libro;
    this.fechaDePrestamo = Date.from(Instant.now());
  }

  public Prestamo(Usuario usuario, Libro libro, Date fechaDePrestamo) {
    this.usuario = usuario;
    this.libro = libro;
    this.fechaDePrestamo = fechaDePrestamo;
  }
}

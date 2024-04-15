package com.globallogic.library.service.model;

import com.globallogic.library.service.enums.EstadoLibro;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class Libro {
  private String isbn;
  private String título;
  private String autor;
  private String editorial = "Desconocida";
  private Date añoDePublicacion = Date.from(Instant.now());
  private String genero = "Desconocido";
  private Integer numeroDePaginas = 100;
  private EstadoLibro estado;

  public Libro(String isbn, String título, String autor) {
    this.isbn = isbn;
    this.título = título;
    this.autor = autor;
    this.estado = EstadoLibro.DISPONIBLE;
  }
}

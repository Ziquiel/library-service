package com.globallogic.library.service.model;

import com.globallogic.library.service.enums.TipoDeUsuario;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class Usuario {
  private String nombre;
  private String apellido;
  private Integer dni = 12345678;
  private String direccion = "Calle falsa 123";
  private Integer numeroDeTelefono = 123456789;
  private String correoElectronico = "correo@electronico.com";
  private Date fechaDeNacimiento = Date.from(Instant.now());
  private TipoDeUsuario tipoDeUsuario;

  public Usuario(String nombre, String apellido, TipoDeUsuario tipoDeUsuario) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.tipoDeUsuario = tipoDeUsuario;
  }

}

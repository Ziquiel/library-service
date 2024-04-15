package com.globallogic.library.service.model;

import com.globallogic.library.service.enums.TipoDeUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioPremium extends Usuario {
  private Date fechaDeCaducidad;

  public UsuarioPremium(String nombre, String apellido, TipoDeUsuario tipoDeUsuario) {
    super(nombre, apellido, tipoDeUsuario);
  }
}

package com.globallogic.library.service.interfaces;

import com.globallogic.library.service.model.Usuario;

import java.util.Map;

public interface RespositorioUsuario {
  void guardarUsuario(Usuario usuario, Map<Integer, Usuario> usuarios);

  void eliminarUsuario(Usuario usuario, Map<Integer, Usuario> usuarios);

  Usuario buscarUsuarioPorId(Integer dni, Map<Integer, Usuario> usuarios);

}

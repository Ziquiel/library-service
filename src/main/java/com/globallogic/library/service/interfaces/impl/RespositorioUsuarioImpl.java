package com.globallogic.library.service.interfaces.impl;

import com.globallogic.library.service.interfaces.RespositorioUsuario;
import com.globallogic.library.service.model.Usuario;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class RespositorioUsuarioImpl implements RespositorioUsuario {
  @Override public void guardarUsuario(Usuario usuario, Map<Integer, Usuario> usuarios) {
    System.out.println("Usuario guardado");
    usuarios.put(usuario.getDni(), usuario);
  }

  @Override public void eliminarUsuario(Usuario usuario, Map<Integer, Usuario> usuarios) {
    if (usuarios.containsKey(usuario.getDni())) {
      usuarios.remove(usuario.getDni());
      System.out.println("Usuario eliminado");
    } else {
      System.out.println("Usuario no encontrado");
    }
  }

  @Override public Usuario buscarUsuarioPorId(Integer dni, Map<Integer, Usuario> usuarios) {
    if (usuarios.isEmpty()) {
      System.out.println("No hay usuarios");
      return null;
    } else {
      if (usuarios.containsKey(dni)) {
        System.out.println("Usuario encontrado");
        return usuarios.get(dni);
      } else {
        System.out.println("Usuario no encontrado");
        return null;
      }
    }
  }
}

package com.globallogic.library.service.program;

import com.globallogic.library.service.enums.TipoDeUsuario;
import com.globallogic.library.service.model.Libro;
import com.globallogic.library.service.model.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Populadores {
  public static List<Libro> popularLibros() {
    List<Libro> libros = new ArrayList<>();
    libros.add(new Libro("1", "El señor de los anillos", "J.R.R. Tolkien"));
    libros.add(new Libro("2", "Harry Potter", "J.K. Rowling"));
    libros.add(new Libro("3", "Cien años de soledad", "Gabriel García Márquez"));
    libros.add(new Libro("4", "El principito", "Antoine de Saint-Exupéry"));
    libros.add(new Libro("5", "Don Quijote de la Mancha", "Miguel de Cervantes"));
    libros.add(new Libro("6", "Crimen y castigo", "Fyodor Dostoyevsky"));
    libros.add(new Libro("7", "La metamorfosis", "Franz Kafka"));
    libros.add(new Libro("8", "1984", "George Orwell"));
    return libros;
  }

  public static Map<Integer, Usuario> popularUsuarios() {
    Map<Integer, Usuario> usuarios = new HashMap<>();
    usuarios.put(1, new Usuario("Juan", "Perez", TipoDeUsuario.PROFESOR));
    usuarios.put(2, new Usuario("Maria", "Gonzalez", TipoDeUsuario.INVESTIGADOR));
    usuarios.put(3, new Usuario("Carlos", "Lopez", TipoDeUsuario.ALUMNO));
    return usuarios;
  }
}

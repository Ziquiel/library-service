package com.globallogic.library.service.interfaces;

import com.globallogic.library.service.enums.EstadoLibro;
import com.globallogic.library.service.model.Libro;

import java.util.List;

public class RespositorioLibroImpl implements RespositorioLibro {
  @Override public void guardarLibro(Libro libro, List<Libro> libros) {
    libros.add(libro);
  }

  @Override public void eliminarLibro(String isbn, List<Libro> libros) {
    Libro libro = buscarLibroPorIsbn(isbn, libros);
    if (libro != null && libros.remove(libro)) {
      System.out.println("Libro eliminado");
    } else {
      System.out.println("Error al eliminar el libro");
    }

  }

  @Override public Libro buscarLibroPorIsbn(String isbn, List<Libro> libros) {
    return libros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().orElse(null);
  }

  @Override public Libro buscarLibroPorTitulo(String titulo, List<Libro> libros) {
    return libros.stream().filter(libro -> libro.getTítulo().equals(titulo)).findFirst().orElse(null);
  }

  @Override public List<Libro> buscarLibroPorAutor(String autor, List<Libro> libros) {
    return libros.stream().filter(libro -> libro.getAutor().equals(autor)).toList();
  }

  @Override public void listarLibrosDisponiblesYPrestados(List<Libro> libros) {
    libros.stream().filter(libro ->
            !libro.getEstado().equals(EstadoLibro.RESERVADO))
        .forEach((libro -> System.out.println(
            "isbn: " + libro.getIsbn() + " " + libro.getTítulo() + " " + libro.getAutor() + " estado: " + libro.getEstado())));
  }

}

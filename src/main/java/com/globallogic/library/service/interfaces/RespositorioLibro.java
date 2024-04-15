package com.globallogic.library.service.interfaces;

import com.globallogic.library.service.model.Libro;

import java.util.List;

public interface RespositorioLibro {
  void guardarLibro(Libro libro, List<Libro> libros);

  void eliminarLibro(String isbn, List<Libro> libros);

  Libro buscarLibroPorIsbn(String isbn, List<Libro> libros);

  Libro buscarLibroPorTitulo(String titulo, List<Libro> libros);

  List<Libro> buscarLibroPorAutor(String autor, List<Libro> libros);

  void listarLibrosDisponiblesYPrestados(List<Libro> libros);

}

package com.globallogic.library.service.interfaces;

import com.globallogic.library.service.model.Libro;
import com.globallogic.library.service.model.Prestamo;
import com.globallogic.library.service.model.Usuario;

import java.util.List;
import java.util.Map;

public interface Prestable {
  void prestar(Usuario usuario, Libro libro, Map<Integer, Usuario> usuarios, List<Libro> libros,
      List<Prestamo> prestamosActivos);

  void devolver(Usuario dni, Libro isbn, Map<Integer, Usuario> usuarios, List<Libro> libros,
      List<Prestamo> prestamosActivos);

  void reservar(Usuario usuario, Libro libro, Map<Integer, Usuario> usuarios, List<Libro> libros,
      List<Prestamo> prestamosActivos);

  boolean chequearDisponibilidadLibro(Libro libro, List<Prestamo> prestamosActivos, Usuario usuario);

  void listarLibrosEnPosesion(Usuario usuario, List<Prestamo> prestamosActivos);

}

package com.globallogic.library.service.interfaces;

import com.globallogic.library.service.enums.EstadoLibro;
import com.globallogic.library.service.interfaces.impl.RespositorioUsuarioImpl;
import com.globallogic.library.service.model.Libro;
import com.globallogic.library.service.model.Prestamo;
import com.globallogic.library.service.model.Usuario;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class PrestableImpl implements Prestable {

  private final RespositorioUsuarioImpl respositorioUsuario;
  private final RespositorioLibroImpl respositorioLibro;

  @Override public void prestar(Usuario usuario, Libro libro, Map<Integer, Usuario> usuarios, List<Libro> libros,
      List<Prestamo> prestamosActivos) {
    Prestamo prestamo = new Prestamo(usuario, libro);
    prestamosActivos.add(prestamo);
    libro.setEstado(EstadoLibro.PRESTADO);
    System.out.println("Libro prestado");
  }

  public boolean chequearDisponibilidadLibro(Libro libro, List<Prestamo> prestamosActivos, Usuario usuario) {
    if (prestamosActivos.isEmpty()) {
      return true;
    }
    if (libro.getEstado() == EstadoLibro.RESERVADO) {
      System.out.println("El libro se encuentra reservado");
      return false;
    }
    if (libro.getEstado().equals(EstadoLibro.PRESTADO) && prestamosActivos.stream()
        .anyMatch(prestamo -> prestamo.getLibro().equals(libro) && prestamo.getUsuario().equals(usuario))) {
      System.out.println("El libro ya se encuentra en su posesion");
      return false;
    }
    if (prestamosActivos.stream()
        .noneMatch(
            prestamo -> prestamo.getLibro().getIsbn()
                .equals(libro.getIsbn()) && prestamo.getFechaDeDevolucion() == null)) {
      return false;
    } else {
      System.out.println("El libro se encuentra prestado");
      return true;
    }
  }

  @Override public void listarLibrosEnPosesion(Usuario usuario, List<Prestamo> prestamosActivos) {
    prestamosActivos.stream()
        .filter(prestamo -> prestamo.getUsuario().equals(usuario))
        .forEach(prestamo -> {
          Libro libro = prestamo.getLibro();
          System.out.println(
              "isbn: " + libro.getIsbn() + " " + libro.getTítulo() + " " + libro.getAutor() + " estado: " + libro.getEstado());
        });
  }

  @Override public void devolver(Usuario usuario, Libro libro, Map<Integer, Usuario> usuarios, List<Libro> libros,
      List<Prestamo> prestamosActivos) {
    Prestamo prestamo = prestamosActivos.stream()
        .filter(p -> p.getUsuario().equals(usuario) && p.getLibro().equals(libro))
        .findFirst()
        .orElse(null);
    if (prestamo != null) {
      if (libro.getEstado().equals(EstadoLibro.RESERVADO)) {
        libro.setEstado(EstadoLibro.PRESTADO);
        prestamosActivos.remove(prestamo);
        System.out.println("Se removio con exito su reserva");
      } else {

        prestamo.setFechaDeDevolucion(Date.from(new Date().toInstant()));
        libro.setEstado(EstadoLibro.DISPONIBLE);
        System.out.println("Libro devuelto");
      }
    }
  }

  @Override public void reservar(Usuario usuario, Libro libro, Map<Integer, Usuario> usuarios, List<Libro> libros,
      List<Prestamo> prestamosActivos) {
    libro.setEstado(EstadoLibro.RESERVADO);
    prestamosActivos.add(new Prestamo(usuario, libro, null));
    System.out.println("Se reserva su libro");

  }
}

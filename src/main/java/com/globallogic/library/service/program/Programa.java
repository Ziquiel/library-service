package com.globallogic.library.service.program;

import com.globallogic.library.service.interfaces.PrestableImpl;
import com.globallogic.library.service.interfaces.RespositorioLibroImpl;
import com.globallogic.library.service.interfaces.impl.RespositorioUsuarioImpl;
import com.globallogic.library.service.model.Libro;
import com.globallogic.library.service.model.Prestamo;
import com.globallogic.library.service.model.Usuario;
import com.globallogic.library.service.threads.HiloPrestamo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Programa {
  private final RespositorioUsuarioImpl respositorioUsuario;
  private final RespositorioLibroImpl respositorioLibro;
  private final PrestableImpl prestable;

  private final Scanner scanner;

  //realizar constructor sin parametros con todos los atributos
  public Programa() {
    respositorioLibro = new RespositorioLibroImpl();
    respositorioUsuario = new RespositorioUsuarioImpl();
    prestable = new PrestableImpl(respositorioUsuario, respositorioLibro);
    scanner = new Scanner(System.in);
  }

  public void iniciarPrograma(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos) {
    System.out.println("Bienvenido a la biblioteca");
    System.out.println("Ingrese su id");
    Integer id = scanner.nextInt();
    Usuario usuario = respositorioUsuario.buscarUsuarioPorId(id, usuarioPorDni);
    while (usuario == null) {
      System.out.println("Usuario no encontrado, ingrese su id nuevamente");
      id = scanner.nextInt();
      usuario = respositorioUsuario.buscarUsuarioPorId(id, usuarioPorDni);
    }
    System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getApellido());
    progresarPrograma(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos, usuario);
  }

  public void progresarPrograma(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos, Usuario usuario) {
    System.out.println("Libros disponibles: \n");
    respositorioLibro.listarLibrosDisponiblesYPrestados(librosDeLaBiblioteca);
    if (!prestamosActivos.isEmpty() && prestamosActivos.stream()
        .anyMatch(prestamo -> prestamo.getUsuario().equals(usuario))) {
      progresarProgramaConPrestamos(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos, usuario);
    } else {
      progresarProgramaSinPrestamos(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
    }
  }

  private void progresarProgramaConPrestamos(List<Libro> librosDeLaBiblioteca, Map<Integer, Usuario> usuarioPorDni,
      List<Prestamo> prestamosActivos, Usuario usuario) {
    System.out.println(
        "Ingrese: \n 1 Para pedir prestado o reservar un libro\n 2 Para devolver un libro \n 3 Para desloguear");
    int opcion = scanner.nextInt();
    HiloPrestamo hiloPrestamo = new HiloPrestamo();
    hiloPrestamo.start();
    while (opcion != 1 && opcion != 2 && opcion != 3) {
      System.out.println("Opción no válida, ingrese nuevamente");
      opcion = scanner.nextInt();
    }
    switch (opcion) {
    case 1:
      progresarProgramaIntentoPrestamoOReserva(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
      break;
    case 2:
      System.out.println("Libros en posesion: \n");
      prestable.listarLibrosEnPosesion(usuario, prestamosActivos);
      System.out.println("Ingrese el isbn del libro que desea devolver");
      String isbn = scanner.next();
      Libro libroElegido = respositorioLibro.buscarLibroPorIsbn(isbn, librosDeLaBiblioteca);
      prestable.devolver(usuario, libroElegido, usuarioPorDni, librosDeLaBiblioteca,
          prestamosActivos);
      flujoIntermedioOFinal(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
      break;
    case 3:
      desloguear(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos);
      break;
    }
  }

  private void progresarProgramaSinPrestamos(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos, Usuario usuario) {
    System.out.println("Ingrese: \n 1 Para pedir prestado o reservar un libro\n 2 Para desloguear");
    int opcion = scanner.nextInt();
    HiloPrestamo hiloPrestamo = new HiloPrestamo();
    hiloPrestamo.start();
    chequeoOpcionCorrecta(opcion);
    switch (opcion) {
    case 1:
      progresarProgramaIntentoPrestamoOReserva(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
      break;
    case 2:
      desloguear(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos);
      break;
    default:
      break;
    }
  }

  private void progresarProgramaIntentoPrestamoOReserva(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos, Usuario usuario) {
    System.out.println("Ingrese el isbn del libro que desea pedir prestado");
    String isbn = scanner.next();
    Libro libroElegido = respositorioLibro.buscarLibroPorIsbn(isbn, librosDeLaBiblioteca);
    if (prestable.chequearDisponibilidadLibro(libroElegido,
        prestamosActivos, usuario)) { //si el libro esta disponible o prestado
      progresarProgramaLibroDisponibleOReservable(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario, libroElegido);
    } else {
      progresarProgramaLibroNoDisponible(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
    }
  }

  private void progresarProgramaLibroNoDisponible(List<Libro> librosDeLaBiblioteca, Map<Integer, Usuario> usuarioPorDni,
      List<Prestamo> prestamosActivos, Usuario usuario) {
    System.out.println(
        "Desea elegir otro libro o desloguear? \nIngrese: \n 1 Elegir otro libro \n 2 Desloguear");
    int opcion = scanner.nextInt();
    chequeoOpcionCorrecta(opcion);
    switch (opcion) {
    case 1:
      progresarPrograma(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
      break;
    case 2:
      desloguear(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos);
      break;
    default:
      break;
    }
  }

  private void desloguear(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos) {
    System.out.println("Gracias por usar la biblioteca");
    iniciarPrograma(librosDeLaBiblioteca,
        usuarioPorDni, prestamosActivos);
  }

  private void progresarProgramaLibroDisponibleOReservable(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos, Usuario usuario, Libro libroElegido) {
    switch (libroElegido.getEstado()) {
    case PRESTADO:
      System.out.println("El libro está prestado, desea reservarlo igualmente? \nIngrese: \n 1 Si \n 2 No");
      int opcion = scanner.nextInt();
      chequeoOpcionCorrecta(opcion);
      switch (opcion) {
      case 1:
        prestable.reservar(usuario, libroElegido, usuarioPorDni, librosDeLaBiblioteca,
            prestamosActivos);
        flujoIntermedioOFinal(librosDeLaBiblioteca,
            usuarioPorDni, prestamosActivos, usuario);
        break;
      case 2:
        System.out.println("Gracias por usar la biblioteca");
        iniciarPrograma(librosDeLaBiblioteca,
            usuarioPorDni, prestamosActivos);
        break;
      default:
        break;
      }
      break;
    case DISPONIBLE:
      prestable.prestar(usuario, libroElegido, usuarioPorDni, librosDeLaBiblioteca,
          prestamosActivos);
      flujoIntermedioOFinal(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos, usuario);
      break;
    default:
      break;
    }
  }

  private void chequeoOpcionCorrecta(int opcion) {
    while (opcion != 1 && opcion != 2) {
      System.out.println("Opción no válida, ingrese nuevamente");
      opcion = scanner.nextInt();
    }
  }

  private void flujoIntermedioOFinal(List<Libro> librosDeLaBiblioteca,
      Map<Integer, Usuario> usuarioPorDni, List<Prestamo> prestamosActivos, Usuario usuario) {
    System.out.println("Desea realizar otro prestamo / reserva \nIngrese: \n 1 Si \n 2 Desloguear");
    int opcion = scanner.nextInt();
    chequeoOpcionCorrecta(opcion);
    switch (opcion) {
    case 1:
      progresarPrograma(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos, usuario);
      break;
    case 2:
      System.out.println("Gracias por usar la biblioteca");
      iniciarPrograma(librosDeLaBiblioteca,
          usuarioPorDni, prestamosActivos);
      break;
    default:
      break;
    }
  }

}

package com.globallogic.library.service;

import com.globallogic.library.service.model.Libro;
import com.globallogic.library.service.model.Prestamo;
import com.globallogic.library.service.model.Usuario;
import com.globallogic.library.service.program.Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.globallogic.library.service.program.Populadores.popularLibros;
import static com.globallogic.library.service.program.Populadores.popularUsuarios;

public class Application {

  public static void main(String[] args) {

    List<Libro> librosDeLaBiblioteca = popularLibros();
    Map<Integer, Usuario> usuarioPorDni = popularUsuarios();
    List<Prestamo> prestamosActivos = new ArrayList<Prestamo>();

    Programa programa = new Programa();
    programa.iniciarPrograma(librosDeLaBiblioteca, usuarioPorDni, prestamosActivos);

  }

}

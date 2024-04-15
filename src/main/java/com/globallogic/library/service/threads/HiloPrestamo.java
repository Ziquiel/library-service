package com.globallogic.library.service.threads;

public class HiloPrestamo extends Thread {
  @Override public void run() {
    System.out.println("Hilo de prestamo corriendo");
  }
}

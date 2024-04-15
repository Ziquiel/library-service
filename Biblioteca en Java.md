# **Biblioteca en Java**

## Objetivo: Implementar un sistema de gestión de una biblioteca con las siguientes funcionalidades:

### Clases:

- #### Libro:
  - Atributos: ISBN, título, autor, editorial, año de publicación, género, número de páginas, estado (disponible, prestado, reservado).
  - Métodos:
    - Constructor con todos los atributos.
    - Getters y setters.
    - toString().
-  #### Usuario:
  - Atributos: Nombre, apellido, DNI, dirección, número de teléfono, correo electrónico, fecha de nacimiento, tipo de usuario (alumno, profesor, investigador).
  - Métodos:
    - Constructor con todos los atributos.
    - Getters y setters.
    - toString().
-  #### Préstamo:
  - Atributos: Fecha de préstamo, fecha de devolución, usuario, libro.
  - Métodos:
    - Constructor con todos los atributos.
    - Getters y setters.
    - toString().

### Interfaces:

-  #### Prestable:
  - Métodos:
    - prestar(Usuario usuario).
    - devolver().
    - reservar(Usuario usuario).

### Enums:

-  #### EstadoLibro:
  -  #### Valores: DISPONIBLE, PRESTADO, RESERVADO.

### Collections:

-  #### List<Libro>: Almacena todos los libros de la biblioteca.
-  #### Map<Integer, Usuario>: Almacena los usuarios por su DNI.
-  #### List<Prestamo>: Almacena los préstamos activos.

### Threads:

- HiloPrestamo: Se encarga de gestionar los préstamos y devoluciones de libros.

### Herencia:

-  #### UsuarioPremium: Hereda de Usuario y tiene un atributo "fecha de caducidad de la suscripción".

### Genéricos:

- ### Clase Repositorio<T>:
  - #### Métodos:
    - guardar(T objeto).
    - buscarPorId(Integer id).
    - eliminar(Integer id).

### Programación funcional:

- Función para calcular la multa por retraso en la devolución de un libro.

### Estructuras de control:

- Sentencias condicionales: Se utilizan para determinar si un libro está disponible, prestado o reservado.
- Bucles: Se utilizan para recorrer las listas de libros, usuarios y préstamos.

### Implementación:

- Desarrollar las clases, interfaces, enums, colecciones, threads, herencia, genéricos, programación funcional y estructuras de control mencionadas.
- Implementar las funcionalidades del sistema de gestión de la biblioteca.
- Desarrollar una interfaz de usuario para interactuar con el sistema.

### Ejemplo de uso:

- Un usuario puede buscar un libro por ISBN, título o autor.
- Un usuario puede prestar un libro si está disponible.
- Un usuario puede reservar un libro si está prestado.
- Un usuario puede devolver un libro prestado.
- El sistema calcula la multa por retraso en la devolución de un libro.

Recursos adicionales:

- Java Tutorial: <https://docs.oracle.com/javase/tutorial/>
- Collections in Java: <https://docs.oracle.com/javase/tutorial/collections/>
- Interfaces in Java: <https://docs.oracle.com/javase/tutorial/java/IandI/index.html>
- Enums in Java: <https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html>
- Threads in Java: <https://docs.oracle.com/javase/tutorial/essential/concurrency/>
- Generics in Java: <https://docs.oracle.com/javase/tutorial/java/generics/>

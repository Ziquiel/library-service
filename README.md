# Sistema de Gestión de Biblioteca

Este es un Sistema de Gestión de Biblioteca desarrollado en Java utilizando Spring Boot y Maven.

## Características

- El usuario puede verificar la disponibilidad de un libro.
- El usuario puede tomar prestado un libro si está disponible.
- El usuario puede reservar un libro si actualmente está prestado por otra persona.
- El usuario puede devolver un libro que ha tomado prestado.
- El usuario puede ver la lista de libros que tiene actualmente.

## Estructura del Proyecto

El proyecto sigue una estructura de proyecto Maven estándar. Aquí están algunos de los archivos y directorios clave:

- `src/main/java/com/globallogic/library/service/program/Programa.java`: Esta es la clase principal que maneja el flujo
  del programa.
- `src/main/java/com/globallogic/library/service/interfaces/PrestableImpl.java`: Esta clase implementa la
  interfaz `Prestable` y proporciona la funcionalidad para verificar la disponibilidad de los libros, tomar prestados,
  reservar y devolver libros.

## Cómo Ejecutar

Para ejecutar este proyecto, necesitas tener Java y Maven instalados en tu máquina. Luego puedes clonar el repositorio y
ejecutar el siguiente comando en el directorio del proyecto:

```bash
mvn spring-boot:run

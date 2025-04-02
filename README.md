# Sistema de Gestión Universitario

Este proyecto es un sistema de gestión universitaria desarrollado en Java. Permite administrar información de estudiantes, cursos, profesores y otros elementos académicos. Además, cuenta con un sistema de roles que permite asignar distintos niveles de acceso a usuarios, garantizando así un control adecuado sobre la gestión académica y administrativa.

## Requisitos
- Java 11 o superior
- NetBeans (opcional, pero recomendado para facilitar la ejecución)
- Apache Ant para la compilación y ejecución del proyecto

## Funcionalidades

### Gestión de Usuarios y Roles
- Registro y administración de estudiantes, docentes y personal administrativo.
- Asignación de distintos niveles de permisos según el rol del usuario.
- Cálculo automático de la edad de cada persona en base a su fecha de nacimiento.

### Gestión de Cursos
- Creación y administración de cursos, incluyendo:
  - Docente encargado
  - Estudiantes matriculados
  - Materia impartida
  - Horarios establecidos
- Control de conflictos de horarios al asignar cursos a docentes o al matricular estudiantes.
- Control de cursos repetidos para diferentes jornadas, periodos o programas.

### Gestión de Laboratorios
- Préstamo de laboratorios a estudiantes si hay disponibilidad.
- Reservas de laboratorio con un tiempo máximo de una hora y sujeto a disponibilidad.
- Modificación de la capacidad de los laboratorios, afectando reservas futuras.
- Visualización en tiempo real de los puestos disponibles en los laboratorios mediante una matriz de 4 columnas.
- Programación de mantenimientos, bloqueando reservas y notificando a estudiantes afectados.

## Usuarios y Permisos

### Admin General
- Usuario predefinido con permisos completos.
- Gestiona usuarios administrativos.

### Administrativo
- Gestiona docentes, estudiantes y administradores de laboratorio.
- Asigna contraseñas temporales a nuevos usuarios.
- Administra cursos, controlando programas, jornadas y periodos.
- Matricula estudiantes en cursos verificando la compatibilidad de horarios.

### Docente
- Gestiona los cursos asignados en el periodo actual.
- Registra hasta tres notas por curso con porcentajes que sumen 100%.
- Asigna calificaciones de 0 a 5 con un decimal de aproximación.
- Visualiza su horario y el historial de cursos anteriores.

### Estudiante
- Consulta sus cursos y calificaciones.
- Realiza y cancela reservas de laboratorio con restricciones.
- Recibe notificaciones de eventos importantes.
- Visualiza su horario y su historial académico.

### Administrador de Laboratorio
- Programa mantenimientos de laboratorios.
- Gestiona reservas y préstamos de laboratorios.
- Administra la cola de espera para el uso de laboratorios llenos.
  

## Instalación y Ejecución

### Requisitos
- Tener instalado Java (JDK 11 o superior).
- NetBeans (opcional, pero recomendado para facilitar la ejecución).
- Apache Ant para la compilación y ejecución del proyecto.

### Pasos para ejecutar
1. Clonar o descargar el proyecto desde el repositorio.
2. Abrir el proyecto en NetBeans.
3. Asegurar que la biblioteca `jcalendar-1.4.jar` está correctamente referenciada en el proyecto.
4. Compilar y ejecutar desde NetBeans o utilizar Ant con los siguientes comandos:

## Estructuras de Datos Implementadas
Este sistema aprovecha estructuras de datos personalizadas para mejorar la eficiencia y organización:

- **Listas enlazadas**: Para gestionar el almacenamiento dinámico de cursos y estudiantes.
- **Pilas**: Para el control de acciones recientes y la implementación de la funcionalidad de deshacer.
- **Colas**: Para la administración de solicitudes de préstamo de laboratorios.

## Casos de Uso
- Un **administrador** puede agregar nuevos cursos y asignar docentes a cada materia.
- Un **estudiante** puede inscribirse en cursos y verificar su horario.
- Un **profesor** puede registrar calificaciones y gestionar las clases asignadas.
- El **personal administrativo** puede gestionar los préstamos de laboratorios y monitorear la disponibilidad de los mismos.

## Reglas y Validaciones
- Restricción de horarios para evitar solapamientos en cursos.
- Capacidad máxima de laboratorios y cancelación de reservas si la capacidad cambia.
- Solo una reserva activa por estudiante.
- Bloqueo de reservas y préstamos en laboratorios en mantenimiento.

## Notas Adicionales
- No se permite el uso de estructuras predefinidas de Java para almacenamiento de datos, sino estructuras de datos personalizadas.
- Proyecto de desarrollo individual.
- Evaluación basada en funcionalidad, buenas prácticas y claridad en la sustentación.

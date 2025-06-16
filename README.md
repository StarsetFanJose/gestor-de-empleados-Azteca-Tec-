# Gestor de Empleados - Azteca Tec

Este proyecto es un **gestor de empleados** desarrollado en Java usando NetBeans. Está pensado para la administración básica de empleados, clientes y reportes en una pequeña empresa o negocio.

## Características principales

- **Gestión de empleados:** Alta, baja, modificación y consulta de empleados.
- **Gestión de clientes:** Registro y consulta de clientes.
- **Gestión de usuarios:** Control de acceso mediante usuarios y contraseñas.
- **Reportes:** Generación y almacenamiento de reportes.
- **Interfaz gráfica:** Desarrollada con Swing para facilitar el uso.

## Funcionamiento de la base de datos

Este sistema **NO utiliza una base de datos relacional** (como MySQL o PostgreSQL). Toda la información se almacena en **archivos de texto plano (.txt)** dentro del proyecto. Los archivos principales son:

- `empleados.txt` — Almacena los datos de los empleados.
- `clientes.txt` — Almacena los datos de los clientes.
- `usuarios.txt` — Almacena los datos de acceso de los usuarios.
- `reportesGuardados.txt` — Guarda los reportes generados.
- Otros archivos de apoyo para actividades y reportes.

Cada vez que se realiza una operación (alta, baja, modificación), el programa lee y escribe en estos archivos.

## Estructura del proyecto

- `/src` — Código fuente Java.
- `/nbproject` — Archivos de configuración de NetBeans.
- `/librerias` — Librerías externas necesarias.
- `/reportes` y `/reportesGuardadosGestor2` — Carpeta para reportes generados.
- Archivos `.txt` — Base de datos del sistema.

## Requisitos

- **Java 8 o superior**
- **NetBeans IDE** (recomendado para compilar y ejecutar)

## ¿Cómo ejecutar el programa?

1. Clona o descarga este repositorio.
2. Abre el proyecto en NetBeans.
3. Compila y ejecuta el proyecto desde el IDE.
4. Los archivos `.txt` se generarán automáticamente si no existen.

## Notas importantes

- Si quieres empezar con datos limpios, puedes borrar los archivos `.txt` antes de ejecutar.
- No es necesario instalar una base de datos externa.
- El sistema está pensado para uso local y pruebas educativas.

## Autor
- José Ángel Luis Dávila

---

¿Dudas o sugerencias? ¡Contáctame! 

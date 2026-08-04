# Sistema de Gestión de Empleados

## Descripción

Sistema de Gestión de Empleados es una aplicación web Full Stack desarrollada para administrar la información de los empleados de una organización. 
La aplicación permite realizar operaciones CRUD (Crear, Consultar, Actualizar y Eliminar), así como gestionar la relación entre empleados y departamentos 
mediante una arquitectura basada en Spring Boot y Angular.

Este proyecto fue desarrollado con el objetivo de fortalecer conocimientos en el desarrollo de aplicaciones empresariales utilizando Java, Spring Boot, 
Hibernate, MySQL y Angular, aplicando buenas prácticas de programación, una arquitectura por capas y el uso de DTOs (Data Transfer Objects) 
para desacoplar la comunicación entre el backend y el frontend.

---

# Tecnologías utilizadas

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Jakarta Validation
* DTO (Data Transfer Object)
* API REST

## Frontend

* Angular 21
* TypeScript
* RxJS
* Angular HttpClient
* Bootstrap 5

## Herramientas

* IntelliJ IDEA
* Visual Studio Code
* Git
* GitHub
* Postman

---

# Funcionalidades

* Gestión de empleados (Crear, Consultar, Actualizar y Eliminar).
* Gestión de departamentos.
* Asociación de empleados con departamentos mediante relaciones JPA (@ManyToOne).
* Comunicación entre frontend y backend mediante DTOs.
* Consumo de una API REST desde Angular.
* Validación de datos en el backend utilizando Jakarta Validation.
* Interfaz responsiva desarrollada con Bootstrap.
* Persistencia de datos en MySQL.
* Arquitectura en capas (Controller, Service y Repository).

---

# Conceptos implementados en el Backend

* Desarrollo de APIs REST con Spring Boot.
* Inyección de dependencias.
* Persistencia de datos con Spring Data JPA.
* Mapeo objeto-relacional mediante Hibernate.
* Relaciones entre entidades con JPA (@ManyToOne y @OneToMany).
* Uso de DTOs (Data Transfer Objects) para separar el modelo de persistencia del modelo de comunicación con la API.
* Validación de datos mediante Jakarta Validation.
* Patrón Repository.
* Capa de Servicios (Service Layer).
* Arquitectura Controller – Service – Repository.
* Manejo de transacciones con Spring.
* Conversión entre Entidades y DTOs.

---

# Conceptos implementados en el Frontend

* Componentes de Angular.
* Servicios para consumo de APIs REST.
* HttpClient.
* Formularios Reactivos (Reactive Forms).
* Validación de formularios.
* Modelos TypeScript para Request y Response.
* Observables con RxJS.
* Comunicación con el backend mediante DTOs.
* Diseño responsivo utilizando Bootstrap.

---

# Base de datos

La aplicación utiliza MySQL como sistema gestor de base de datos relacional.

Las principales entidades del sistema son:

* Empleado
* Departamento

Ambas entidades se encuentran relacionadas mediante Hibernate y Spring Data JPA para mantener la integridad y consistencia de la información.

---

# Backend-AP

Proyecto final de "INTI" - BackEnd

Este repositorio corresponde al proyecto final desarrollado para rendir y acreditar el curso de INTI dentro del marco del perfil profesional como Full Stack Junior. El mismo se dedica al desarrollo de la API que contiene la lógica de negocio necesaria para el funcionamiento de la aplicación web asociada.

<p align="center">
  <img src="https://player.slideplayer.es/117/18132941/data/images/img0.jpg" alt="MiCarreraPerfecta">
</p>

## ⚙ Versionado de la aplicación ⚙

- **Java**: 1.8.
- **JDK**: Openjdk-8-jdk.
- **Spring Boot**: 2.7.9.

![Spring Boot](https://miro.medium.com/v2/resize:fit:1400/1*aXe6MaOyhdIP5WqdPHhSFw.png)

## ⚠️ Dependencias utilizadas ⚠️

Las dependencias incluidas en el proyecto son las siguientes:

- **spring-boot-starter-data-jpa**: API para crear versiones orientadas a objetos de entidades de base de datos relacionales.
- **spring-boot-starter-validation**: Marco de validación que se basa en JSR-303 e Hibernate Validator.
- **spring-boot-starter-web**: Conjunto de dependencias esenciales para desarrollar aplicaciones web en Spring Boot, incluyendo Spring MVC y un servidor web embebido.
- **spring-boot-devtools**: Herramienta de agilización de desarrollo automático.
- **mysql-connector-j**: Controlador nativo de Java que convierte las llamadas generadas por JDBC en el protocolo de red que utiliza la base de datos de MySQL.
- **lombok**: Librería que permite mostrar información en páginas html de forma sencilla.
- **spring-boot-starter-test**: Dependencia que facilita la escritura y ejecución de pruebas unitarias y de integración.
- **spring-boot-starter-security**: Marco de seguridad poderoso y altamente personalizable para aplicaciones Java.
- **jjwt**: Formato compacto y autónomo para la transmisión segura de información entre partes como un objeto JSON.

## ⚙ Base de datos - MER ⚙

<p align="center">
  <img src="https://github.com/LautiCabrera/Backend-AP/blob/main/MER.png?raw=true" alt="MER">
</p>

## ⌨️ Variables de entorno primordiales ⌨️

- **spring.datasource.hibernate.dialect**: Define el dialecto de Hibernate a utilizar, que determina cómo Hibernate interactúa con la base de datos subyacente.
- **spring.datasource.url**: Es la URL de conexión a la base de datos, especifica la ubicación de la base de datos a la que la aplicación debe conectarse.
- **spring.datasource.username**: Es el nombre de usuario utilizado para autenticarse en la base de datos.
- **spring.datasource.password**: Es la contraseña asociada al nombre de usuario utilizado para autenticarse en la base de datos.
- **spring.jpa.hibernate.ddl-auto**: Controla la estrategia de generación del esquema de la base de datos por parte de Hibernate, como crear, actualizar o validar el esquema.
- **spring.jpa.show-sql**: Determina si se deben mostrar las consultas SQL generadas por Hibernate en la consola de registro.
- **jwt.secret**: Clave secreta que se utiliza para firmar los tokens JWT.
- **jwt.expiration**: Determina el tiempo de vida (expiración) de los tokens JWT emitidos por la aplicación. 
- **server.port**: Configura el puerto en el que el servidor web integrado en Spring Boot escuchará las solicitudes entrantes.

## 🌐 Endpoints de la API 🌐

  URL general para crear los endpoints ➡️ https://backend-ap-aa0t.onrender.com

### ↪️ Educación

| Métodos | Rutas                         | Acciones                                            |
|---------|-------------------------------|-----------------------------------------------------|
| GET     | /educacion/lista              | Retorna una lista de todas las educaciones.         |
| GET     | /educacion/detalle/{id}       | Retorna una educación en base al id por parametro.  |
| DELETE  | /educacion/borrar/{id}        | Elimina una educación en base al id por parametro.  |
| POST    | /educacion/crear              | Crea una educación.                                 |
| PUT     | /educacion/actualizar/{id}    | Actualiza una educación en base al id por parametro.|

### ↪️ Experiencia

| Métodos | Rutas                         | Acciones                                              |
|---------|-------------------------------|-------------------------------------------------------|
| GET     | /experiencia/lista            | Retorna una lista de todas las experiencias.          |
| GET     | /experiencia/detalle/{id}     | Retorna una experiencia en base al id por parametro.  |
| DELETE  | /experiencia/borrar/{id}      | Elimina una experiencia en base al id por parametro.  |
| POST    | /experiencia/crear            | Crea una experiencia.                                 |
| PUT     | /experiencia/actualizar/{id}  | Actualiza una experiencia en base al id por parametro.|

### ↪️ Habilidades

| Métodos | Rutas                         | Acciones                                            |
|---------|-------------------------------|-----------------------------------------------------|
| GET     | /hadilidades/lista            | Retorna una lista de todas las hadilidades.         |
| GET     | /hadilidades/detalle/{id}     | Retorna una hadilidad en base al id por parametro.  |
| DELETE  | /hadilidades/borrar/{id}      | Elimina una hadilidad en base al id por parametro.  |
| POST    | /hadilidades/crear            | Crea una hadilidad.                                 |
| PUT     | /hadilidades/actualizar/{id}  | Actualiza una hadilidad en base al id por parametro.|

### ↪️ Proyectos

| Métodos | Rutas                         | Acciones                                          |
|---------|-------------------------------|---------------------------------------------------|
| GET     | /proyectos/lista              | Retorna una lista de todos los proyectos.         |
| GET     | /proyectos/detalle/{id}       | Retorna un proyecto en base al id por parametro.  |
| DELETE  | /proyectos/borrar/{id}        | Elimina un proyecto en base al id por parametro.  |
| POST    | /proyectos/crear              | Crea un proyecto.                                 |
| PUT     | /proyectos/actualizar/{id}    | Actualiza un proyecto en base al id por parametro.|

### ↪️ Personas

| Métodos | Rutas                        | Acciones                                          |
|---------|------------------------------|---------------------------------------------------|
| GET     | /personas/lista              | Retorna una lista de todas las personas.          |
| GET     | /personas/detalle/{id}       | Retorna una persona en base al id por parametro.  |
| PUT     | /personas/actualizar/{id}    | Actualiza una persona en base al id por parametro.|

### ↪️ Auth

| Métodos  | Rutas                    | Acciones                                          |
|----------|--------------------------|---------------------------------------------------|
| POST     | /auth/nuevo              | Crea una nuevo usuario.                           |
| POST     | /auth/login              | Retorna un token y la información del usuario.    |

#### 📬 Ejemplo y formato para las solicitudes GET y DELETE:

```text
https://backend-ap-aa0t.onrender.com/tabla/lista
https://backend-ap-aa0t.onrender.com/tabla/detalle/89
https://backend-ap-aa0t.onrender.com/tabla/delete/89
````

#### 📬 Ejemplo y formato para las solicitudes POST y PUT:

La solicitud debe ser un objeto JSON que puede contener según la tabla;

- **Educación**: nombre, descripcion, duracion, imagen, info.
- **Experiencia**: nombre, descripcion, duracion, imagen, info.
- **Habilidades**: nombre, progreso.
- **Proyectos**: nombre, descripcion, duracion, imagen, info.
- **Personas**: nombre, apellido, descripcion, imagen, titulo.
- **Auth**: nombre, nombreUsuario, email, password, roles.

```json
{
    "nombre":"Tecnico Superior en redes y telecomunicaciones",
    "descripcion":"Conocimientos especializados en el diseño, implementación, etc."
}
````
#### 📭 Códigos de estado HTTP:

- 200 OK: La solicitud se procesó correctamente.
- 400 Bad Request: La solicitud no pudo ser procesada debido a datos incorrectos o malformados.

## 💼 Repositorio del Front 💼

- <a href="https://github.com/LautiCabrera/Frontend-AP" target="_blank">Portfolio-FrontEnd</a>

## 📱 Demo V1.0 📲 

- <a href="https://frontend-ap-19794.web.app/" target="_blank">Portfolio-Demo</a>

## 👨‍💻 Autor 👨‍💻

- <a href="https://github.com/LautiCabrera" target="_blank">@LautiCabrera</a>

## ✨ Contribución ✨

Si deseas contribuir a este proyecto o informar sobre problemas, no dudes en abrir un problema o enviar una solicitud de extracción.

¡Disfruta del proyecto!

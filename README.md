# 🎃 Proyecto API de Monstruos de Halloween 👻

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

## Descripción 🧛‍♂️

Esta API permite la gestión de monstruos de Halloween, almacenando atributos como poderes, debilidades y nivel de peligro. Cuenta con autenticación basada en **token JWT** y está documentada con **Swagger** para facilitar su uso y pruebas.

## Características 🕸️
- **Registro y gestión de monstruos** con atributos personalizados.
- **Autenticación con tokens JWT** para proteger las rutas.
- **Paginación** en las listas de monstruos.
- **Consultas personalizadas** por atributos como nombre, tipo, habilidades especiales, etc.
- **Estadísticas** de los monstruos por poder, tipo y nivel de peligro.
- **Swagger UI** para la documentación interactiva de la API.
  
## Endpoints Principales 🕷️

### Monstruos 🧟
- **POST** `/monstruos`: Registrar un nuevo monstruo.
- **GET** `/monstruos`: Listar monstruos con paginación.
- **GET** `/monstruos/{id}`: Obtener los detalles de un monstruo por su ID.
- **PUT** `/monstruos/{id}`: Actualizar los datos de un monstruo.
- **DELETE** `/monstruos/{id}`: Eliminar un monstruo.

### Búsquedas y Comparaciones 🎯
- **GET** `/monstruos/buscarPorAtributos`: Filtrar monstruos por atributos como nombre, tipo, nivel de peligro, debilidad, poder, etc.
- **GET** `/monstruos/estadisticas`: Obtener estadísticas de monstruos por nivel de peligro y tipo.
- **GET** `/monstruos/estadisticas/poderes`: Estadísticas de monstruos por poder.
- **GET** `/monstruos/aleatorio`: Obtener un monstruo aleatorio.
- **GET** `/monstruos/top10MasTerrorificos`: Listar los 10 monstruos más peligrosos.
- **GET** `/monstruos/comparar`: Comparar dos monstruos por sus atributos.

## Autenticación 🔒

La API utiliza **JSON Web Tokens (JWT)** para asegurar las rutas. Los usuarios deben autenticarse proporcionando un token en el encabezado `Authorization` de cada petición.


## Documentación con Swagger 📜

La documentación de la API está disponible en el endpoint `/swagger-ui/`, donde puedes probar los diferentes endpoints y ver la estructura de los datos.

![Swagger](https://img.shields.io/badge/Swagger-API-green)

## Tecnologías Utilizadas 💻
- **Java 17**
- **Spring Boot**
- **Spring Security** para la autenticación.
- **JWT** para la gestión de tokens.
- **Swagger** para la documentación de la API.
- **JPA** para la persistencia de datos.

¡Gracias por usar la API de Monstruos de Halloween! 🎃👻

Desarrollado por **Julia Daniela Rodriguez**

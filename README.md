# Megamedia News App

Megamedia News es una aplicación Android nativa desarrollada en Kotlin que permite a los usuarios leer y visualizar artículos y noticias. Además, la aplicación está conectada a una API desarrollada en Java con Spring Boot, la cual gestiona los datos de las noticias almacenados en una base de datos MySQL.

## Tecnologías Utilizadas

### Springboot Intellij
- Lenguaje: Java
- Framework: Spring Boot
- Base de datos: MySQL (alojada en Google Cloud)
- Controlador (API REST): NewsController
  - Maneja las operaciones CRUD para las noticias.
- Modelo de Noticia: NewsModel
  - Define la estructura de una noticia con atributos como ID, título, descripción, URL de imagen y URL de video.
- Repositorio: INewsRepository
  - Extiende de CrudRepository para acceder y gestionar las noticias en la base de datos.

### Android Studio
- Lenguaje: Kotlin
- Librerías:
  - Retrofit2: Para interactuar con la API.
  - ExoPlayer: Reproduce videos dentro de la aplicación.

### Base de Datos
- MySQL
  - Almacena los datos de las noticias.
  - Contiene al menos 3 artículos de ejemplo.

## Scripts

### MySQL
- **springdb_news.sql**: Script para la creación de la base de datos y la inserción de datos de ejemplo.

## Funcionalidades

- **API REST**: La API expone endpoints para realizar operaciones CRUD en las noticias.
- **App Android**:
  - Lista las noticias obtenidas de la API usando Retrofit.
  - Permite reproducir videos asociados a cada noticia utilizando ExoPlayer cuando se selecciona una noticia.

## Instrucciones de Uso

1. **Clonar el Repositorio**: Clona este repositorio para acceder al código de la aplicación Android, la API Spring Boot y el script de la base de datos MySQL.
2. **Configuración de Springboot Intellij**:
   - Configura el entorno de desarrollo con IntelliJ para ejecutar el backend.
   - Configura la conexión con la base de datos MySQL.
3. **Configuración de Android Studio**:
   - Ejecuta la aplicación Android y asegúrate de que esté conectada correctamente a la API.
4. **Interactúa con la Aplicación**:
   - La aplicación Android lista las noticias y permite reproducir videos cuando se selecciona una noticia.

## Notas adicionales

Se probó la funcionalidad de la API utilizando Postman para asegurar su correcto funcionamiento antes de integrarla con la aplicación Android.

Este proyecto fue desarrollado para una prueba técnica y contiene datos de ejemplo para demostración.




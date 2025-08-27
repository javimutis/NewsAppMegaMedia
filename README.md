# 📰 Megamedia News App

Megamedia News es una aplicación Android nativa desarrollada en **Kotlin** que permite a los usuarios leer y visualizar artículos y noticias.  
Está conectada a una **API desarrollada en Java con Spring Boot**, que gestiona los datos de las noticias almacenados en una base de datos **MySQL**.

![Demo de la App](assets/demo.gif)

---

## 👩‍🏫 ¿Qué hace esta app?

✅ Lista noticias obtenidas desde la API.  
✅ Permite reproducir videos asociados a cada noticia utilizando **ExoPlayer**.  
✅ Funciona con datos reales de la API o con datos de prueba en caso de error.  
✅ Interfaz simple e intuitiva para explorar noticias y contenido multimedia.  
✅ Se probó la API con **Postman** antes de integrarla en la app.

---

## 🧠 Arquitectura y Componentes

La app está organizada para mantener el código **ordenado y escalable**:

### 🧱 Modelo (Model)
- `News.kt`: Modelo de dominio que representa una noticia con atributos como `id`, `title`, `description`, `imageUrl` y `videoUrl`.

### 🌐 Red (Network)
- `ApiService.kt`: Define los endpoints de la API REST para obtener las noticias.  
- `RetrofitClient.kt`: Configura Retrofit para interactuar con la API.

### 👁️ Vista (View)
- `MainActivity.kt`: Muestra la lista de noticias y maneja la interacción con ellas.  
- `VideoPlayerActivity.kt`: Reproduce videos asociados a cada noticia con **ExoPlayer**.  
- `NewsAdapter.kt`: Adapter de RecyclerView que muestra imágenes, títulos y descripciones, e incluye manejo de clics para reproducir videos.

### 🗄️ Backend
- **Spring Boot (Java)**: Gestiona los endpoints de la API.  
  - `NewsController`: Maneja operaciones CRUD para noticias.  
  - `INewsRepository`: Acceso a la base de datos MySQL.  
  - `NewsModel`: Define la estructura de la noticia.  
- **MySQL**: Base de datos alojada en **Google Cloud**, con al menos 3 artículos de ejemplo.  
- Scripts de ejemplo: `springdb_news.sql` para crear la base de datos e insertar datos iniciales.

---

## 🧰 Tecnologías utilizadas

- **Android Studio** (Kotlin)  
- **Retrofit2** para comunicación con API REST  
- **ExoPlayer** para reproducción de video  
- **Spring Boot** (Java) para backend  
- **MySQL** como base de datos  
- **Postman** para pruebas de la API

---

## ⚙️ Cómo correr este proyecto

1. Clona el repositorio.  
2. Configura la **API Spring Boot** en IntelliJ:  
   - Conecta la base de datos MySQL.  
   - Ejecuta la aplicación backend.  
3. Abre el proyecto **Android Studio** y ejecuta la app.  
4. La app listará noticias desde la API y reproducirá videos al seleccionarlas.  
5. Si la conexión falla, se cargan datos de prueba automáticamente.

---

✨ Este proyecto fue desarrollado como prueba técnica y está listo para demostración.  
Se puede expandir agregando navegación avanzada, filtros de noticias, categorías, favoritos, o mejoras en la reproducción de video.

# 📰 Megamedia News App

**Megamedia News** is a native Android application built with **Kotlin**, allowing users to browse news articles and play associated videos seamlessly.  
It connects to a **Java Spring Boot API** that manages news data stored in a **MySQL database**.

<p align="center">
  <img src="assets/demo.gif" alt="Demo de la App" width="250"/>
</p>

---

## 👩‍🏫 What Does This App Do?

- **Fetch and display news** from a real API.  
- **Play videos inside the app** using **ExoPlayer**.  
- **Fallback test data** when the API is unavailable.  
- **Simple, intuitive UI** designed for quick navigation and content consumption.  
- **Thoroughly tested with Postman** before Android integration.  

---

## 🧠 Architecture & Components

The project follows a **clean, scalable structure** for maintainability:

### 🧱 Model Layer
- `News.kt`: Domain model representing a news article (`id`, `title`, `description`, `imageUrl`, `videoUrl`).  

### 🌐 Network Layer
- `ApiService.kt`: Defines REST API endpoints.  
- `RetrofitClient.kt`: Configures Retrofit for network communication.  

### 👁️ View Layer
- `MainActivity.kt`: Displays the news list and handles user interactions.  
- `VideoPlayerActivity.kt`: Plays videos using **ExoPlayer**.  
- `NewsAdapter.kt`: RecyclerView adapter rendering images, titles, and descriptions with click handling for video playback.  

### 🗄️ Backend
- **Spring Boot (Java):** REST API management.  
  - `NewsController`: Handles CRUD operations for news articles.  
  - `INewsRepository`: Database access layer.  
  - `NewsModel`: Database entity definition.  
- **MySQL Database:** Hosted on **Google Cloud**, preloaded with example articles.  
- **Sample Scripts:** `springdb_news.sql` to create and populate the database.  

---

## 🧰 Tech Stack

- **Android Studio (Kotlin)**  
- **Retrofit2** – REST API communication  
- **ExoPlayer** – In-app video playback  
- **Spring Boot (Java)** – Backend service  
- **MySQL** – Cloud-hosted database  
- **Postman** – API testing  

---

## ⚙️ How to Run This Project

1. **Clone the repository.**  
2. **Set up the Spring Boot API in IntelliJ:**  
   - Connect it to your MySQL database.  
   - Run the backend application.  
3. **Open the Android project in Android Studio** and run the app.  
4. The app will fetch news from the API and play videos when selected.  
5. If the API is unavailable, **fallback test data is loaded automatically.**  

---

## ✨ Project Highlights

- Developed as a **technical test project** and fully functional for demo purposes.  
- Ready for **feature expansion**, such as:  
  - Advanced navigation and categories  
  - Search and filtering options  
  - Favorites and offline reading  
  - Enhanced video playback features  

---

**This project demonstrates end-to-end development, API integration, clean architecture principles, and scalable Android practices — making it a strong foundation for production-ready news or media apps.**

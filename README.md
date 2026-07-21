# Foodrix

Foodrix is a modern, fast, and feature-rich Android food-ordering application that combines a polished UI with an AI-powered assistant and maps-based delivery to make ordering quick and intelligent.

---

## 🌟 Key Features

- **🤖 AI Chat Integration**: Powered by Google Generative AI SDK, providing users with a smart chat assistant directly inside the application.
- **📍 Real-Location Pickers**: Integrated Google Maps (`play-services-maps`) support to capture physical coordinates/addresses for fast delivery routing.
- **🛒 Dynamic Cart Management**: Add-to-cart functionality with real-time total updates, fee calculations, and active quantity grouping.
- **🥗 Browsing & Categories**: Rapidly browse categories or search using autocomplete lists spanning Pizza, Burgers, Broast, Sushi, Drinks, and more.
- **📈 Tailored Filter Controls**: Drop-down filters allowing users to parse dishes by location, delivery duration, and pricing preferences.

---

## 📁 Repository Structure

- `app/src/main/java/com/example/foodrix/`: Java & Kotlin source files containing layout logic, adapter lists, domain object models, and activities.
- `app/src/main/res/`: Contains application layout resources, high-quality drawables, colors, themes, maps/lottie raw animations, and screen elements.

---

## 🧰 Tech Stack

- Java (primary)
- Kotlin
- Android SDK
- Android Studio (Koala/Ladybug or newer)
- Jetpack Compose & XML Views
- Google Play Services — Maps
- Google Generative AI SDK
- Lottie Animations
- Firebase (authentication / backend integrations)
- Gradle (build system)

---

## 🛠️ Built With

* **Android Studio & Java/Kotlin**: Core framework and lifecycle management.
* **Jetpack Compose / XML Views**: Hybrid views for flexible layout configuration.
* **Google Play Services Maps API**: Interactive delivery mapping.
* **Google Generative AI SDK**: Underpins the dynamic AI Dialog window.
* **Lottie Animations**: Engaging UX transition files.

---

## 🚀 Running the Project

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/AbdullahShafiqx/foodrix.git
   ```
2. Open the folder in **Android Studio (Koala/Ladybug or newer)**.
3. Sync Gradle and ensure dependencies (`firebase`, `play-services-maps`, and `generativeai`) are compiled.
4. Run the project on an Android virtual device (AVD) or direct physical debugging device.

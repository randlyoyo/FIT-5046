# Healthy Recipe Hub - Native Android App (Kotlin)

## FIT5046 Assessment 2 - Native Android Conversion

This is a complete native Android application rewritten in **Kotlin** based on the original Vue.js Healthy Recipe Hub web application. This is a full native Android app (not a hybrid app using Capacitor).

---

## 📁 Project Structure

```
5046/
├── app/
│   ├── src/main/
│   │   ├── java/edu/monash/fit5046/healthyrecipehub/
│   │   │   ├── HealthyRecipeHubApplication.kt    # Application class
│   │   │   ├── data/
│   │   │   │   ├── model/                        # Data models
│   │   │   │   │   ├── Recipe.kt
│   │   │   │   │   ├── User.kt
│   │   │   │   │   ├── Store.kt
│   │   │   │   │   ├── ShoppingList.kt
│   │   │   │   │   └── Result.kt
│   │   │   │   ├── local/                        # Room Database
│   │   │   │   │   ├── converter/Converters.kt
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── RecipeDao.kt
│   │   │   │   │   │   ├── UserDao.kt
│   │   │   │   │   │   └── ShoppingDao.kt
│   │   │   │   │   └── database/AppDatabase.kt
│   │   │   │   ├── remote/                       # API layer
│   │   │   │   │   ├── api/
│   │   │   │   │   │   ├── RecipeApiService.kt
│   │   │   │   │   │   ├── AuthApiService.kt
│   │   │   │   │   │   ├── AdminApiService.kt
│   │   │   │   │   │   ├── EmailApiService.kt
│   │   │   │   │   │   ├── AIApiService.kt
│   │   │   │   │   │   └── RetrofitClient.kt
│   │   │   │   │   └── dto/
│   │   │   │   │       ├── RecipeDto.kt
│   │   │   │   │       └── UserDto.kt
│   │   │   │   └── repository/                   # Repository layer
│   │   │   │       ├── RecipeRepository.kt
│   │   │   │       ├── AuthRepository.kt
│   │   │   │       └── ... (more)
│   │   │   ├── ui/
│   │   │   │   ├── main/
│   │   │   │   │   └── MainActivity.kt
│   │   │   │   ├── auth/
│   │   │   │   │   └── AuthActivity.kt
│   │   │   │   ├── recipe/
│   │   │   │   │   └── RecipeDetailActivity.kt
│   │   │   │   ├── map/
│   │   │   │   ├── ai/
│   │   │   │   ├── admin/
│   │   │   │   ├── email/
│   │   │   │   ├── profile/
│   │   │   │   ├── charts/
│   │   │   │   └── viewmodel/
│   │   │   │       ├── RecipeViewModel.kt
│   │   │   │       └── AuthViewModel.kt
│   │   │   └── ... (Fragments, Adapters, etc.)
│   │   └── res/                                  # Android resources
│   │       ├── layout/
│   │       ├── values/
│   │       └── mipmap/
│   └── build.gradle.kts                          # App-level Gradle
├── build.gradle.kts                              # Project-level Gradle
├── settings.gradle.kts
└── gradle.properties
```

---

## 🏗️ Architecture

This app follows **MVVM (Model-View-ViewModel)** architecture with:

- **Data Layer**: Room Database (local) + Retrofit (remote)
- **Repository Layer**: Single source of truth for data
- **ViewModel Layer**: Business logic and UI state management
- **UI Layer**: Activities, Fragments, Adapters

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17 or higher
- Android SDK API 34
- Android device or emulator (API 24+)

### Build Instructions

1. Open Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to `d:\Study\Monash\5032\5046` folder
4. Wait for Gradle sync to complete
5. Run the app on device or emulator

---

## ✨ Features (Matching Original Web App)

### User Authentication

- Email/password login
- User registration
- Password reset
- Biometric authentication (fingerprint/face)
- Profile management

### Recipe Management

- Browse all recipes
- Search recipes by name/ingredient
- Filter by category, cuisine, difficulty
- Recipe detail view with nutrition info
- Add/edit/delete recipes (authenticated users)
- Favorite recipes
- Recipe reviews and ratings

### Map Integration (Mapbox)

- Find health food stores
- View store locations on map
- Get directions
- Store details and ratings

### AI Assistant (Gemini)

- Chat with AI nutrition assistant
- Get recipe suggestions
- Nutrition analysis
- Health tips based on goals

### Admin Dashboard

- User management
- Recipe approval workflow
- Statistics and analytics
- Activity logs

### Email Center

- Send emails to users
- Email templates
- Bulk email functionality

### Data Visualization

- Nutrition charts
- Recipe statistics
- User activity charts

### Offline Support

- Room database for offline access
- Cache recipes locally
- Sync when back online

### Accessibility

- Screen reader support
- Large text options
- High contrast mode
- TalkBack compatibility

---

## 📦 Dependencies

### Core Android

- AndroidX Core, AppCompat
- Material Design Components
- ViewModel, LiveData, Lifecycle
- Navigation Component
- Room Database
- WorkManager

### Networking

- Retrofit2 + Gson converter
- OkHttp3 with logging
- Firebase (Auth, Firestore, Storage, Messaging)

### UI/UX

- Glide (image loading)
- Mapbox Maps SDK
- MPAndroidChart (charts)
- SwipeRefreshLayout
- RecyclerView, CardView

### Security

- Biometric authentication
- Encrypted SharedPreferences

---

## 🔧 Configuration

### Firebase Setup

1. Create a Firebase project at [console.firebase.google.com](https://console.firebase.google.com)
2. Add Android app with package name: `edu.monash.fit5046.healthyrecipehub`
3. Download `google-services.json` and place in `app/` directory
4. Enable Firebase Authentication (Email/Password)
5. Enable Cloud Firestore

### API Endpoints

Update base URL in `RetrofitClient.kt`:

```kotlin
private const val BASE_URL = "https://your-api-endpoint.com/"
```

---

## 📱 Screens

1. **Splash/Welcome** - App launch
2. **Login/Register** - Authentication
3. **Home** - Featured recipes, categories
4. **Recipe List** - Browse with filters
5. **Recipe Detail** - Full recipe info
6. **Add/Edit Recipe** - Recipe form
7. **Favorites** - Saved recipes
8. **Map** - Store locator
9. **AI Assistant** - Chat interface
10. **Admin Dashboard** - Management tools
11. **Profile** - User settings
12. **Charts** - Statistics
13. **Email Center** - Email functionality

---

## 🧪 Testing

```bash
# Run unit tests
./gradlew test

# Run instrumentation tests
./gradlew connectedAndroidTest

# Build release APK
./gradlew assembleRelease
```

---

## 📝 Key Files

| File                   | Description            |
| ---------------------- | ---------------------- |
| `build.gradle.kts`     | Project dependencies   |
| `app/build.gradle.kts` | App-level build config |
| `AndroidManifest.xml`  | App configuration      |
| `Recipe.kt`            | Recipe data model      |
| `RecipeRepository.kt`  | Recipe data operations |
| `RecipeViewModel.kt`   | Recipe UI logic        |
| `MainActivity.kt`      | Main screen            |

---

## 🔄 Comparison with Original Vue.js App

| Feature   | Vue.js Web           | Native Android       |
| --------- | -------------------- | -------------------- |
| Framework | Vue 3 + Vite         | Kotlin + Android SDK |
| UI        | Bootstrap + PrimeVue | Material Design      |
| Database  | Firebase Firestore   | Room + Firestore     |
| Maps      | Mapbox GL JS         | Mapbox Maps SDK      |
| Charts    | Chart.js             | MPAndroidChart       |
| State     | Pinia/Vuex           | ViewModel + LiveData |
| Routing   | Vue Router           | Navigation Component |
| HTTP      | Axios                | Retrofit             |

---

## 📄 License

FIT5046 Assignment 2 - Monash University

---

**Note**: This is a complete native Android rewrite maintaining all original functionality while leveraging native Android capabilities like Room database, Biometric auth, and native notifications.

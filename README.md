# 📱 Jetpack Compose Project - Development Guide

This document provides rules and guidelines for **Git source control**, **project setup**, **build process**, and **best practices** for this Jetpack Compose Android project.

---

# 🚀 1. Project Setup & Run

## ✅ Prerequisites

* Android Studio (latest stable)
* JDK 17+
* Gradle installed (or use wrapper)

## ▶️ Run Project

```bash
# Open project in Android Studio
# OR via terminal:

./gradlew clean
./gradlew build
./gradlew installDebug
```

Or simply click **Run ▶️** in Android Studio.

---

# 📦 2. Build APK

## 🔨 Debug APK

```bash
./gradlew assembleDebug
```

APK location:

```
app/build/outputs/apk/debug/app-debug.apk
```

## 🚀 Release APK

```bash
./gradlew assembleRelease
```

APK location:

```
app/build/outputs/apk/release/app-release.apk
```

> ⚠️ Make sure signing config is properly set in `build.gradle`

---

# 🧹 3. Clean Before Build

Always clean project when:

* Switching branches
* Facing build errors
* Updating dependencies

```bash
./gradlew clean
```

Optional deep clean:

```bash
rm -rf .gradle
rm -rf build
rm -rf app/build
```

---

# 🧠 4. Git Source Control Rules

## 🌿 Branch Naming Convention

| Type    | Format                    | Example               |
| ------- | ------------------------- | --------------------- |
| Feature | feature/short-description | feature/login-screen  |
| Bug Fix | bugfix/issue-name         | bugfix/crash-on-start |
| Hotfix  | hotfix/urgent-fix         | hotfix/api-timeout    |
| Release | release/version           | release/v1.0.0        |

---

## 💬 Commit Message Format

```bash
type: short description
```

### Types:

* `feat` → new feature
* `fix` → bug fix
* `refactor` → code improvement
* `style` → UI/formatting
* `chore` → maintenance

### Example:

```bash
feat: add login screen UI
fix: resolve crash on API response
```

---

## 🚫 What to NOT Commit

Make sure these are ignored in `.gitignore`:

```
/build/
/.gradle/
/local.properties
*.keystore
*.jks
*.log
.DS_Store
```

---

## 🧼 Before Commit Checklist

✅ Remove:

* Debug logs (`Log.d`, `println`)
* Unused imports
* Commented code (if not needed)
* Temporary test code

✅ Ensure:

* Code compiles
* No errors/warnings
* UI works correctly
* Proper naming conventions

---

# ⬆️ 5. Push Code to Git

## 🔁 Basic Flow

```bash
# 1. Check status
git status

# 2. Add files
git add .

# 3. Commit
git commit -m "feat: your message"

# 4. Pull latest changes (IMPORTANT)
git pull origin develop

# 5. Push code
git push origin your-branch-name
```

---

## ⚠️ Important Rules

* ❌ Do NOT push directly to `main` or `develop`
* ✅ Always use Pull Request (PR)
* ✅ Always pull before push (avoid conflict)
* ✅ Resolve conflicts locally before pushing

---

# 🔀 6. Pull Request (PR) Rules

Before creating PR:

* ✅ Code builds successfully
* ✅ No debug logs
* ✅ Tested on device/emulator
* ✅ Follows UI/UX standards

PR Title Example:

```
[Feature] Add Login Screen
[Fix] Resolve API Timeout Issue
```

---

# 📁 7. Project Structure (Recommended)

```
com.project.app/
│
├── ui/              # Compose UI
├── viewmodel/      # ViewModels
├── repository/     # Data layer
├── network/        # API services
├── model/          # Data models
└── utils/          # Helpers
```

---

# 🎨 8. UI/UX Best Practices (Jetpack Compose)

* Use **Material 3**
* Keep UI **stateless** when possible
* Use `ViewModel` for state management
* Follow **spacing & consistency**
* Support **dark mode**

---

# ⚡ 9. Performance Tips

* Avoid unnecessary recomposition
* Use `remember` and `derivedStateOf`
* Lazy components (`LazyColumn`, `LazyRow`)
* Optimize images and resources

---

# 🛠️ 10. Troubleshooting

## Gradle Issues

```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

## Invalidate Cache (Android Studio)

```
File > Invalidate Caches & Restart
```

---

# 👨‍💻 11. Developer Notes

* Keep code **clean and readable**
* Follow **MVVM architecture**
* Write reusable composables
* Maintain consistency across screens

---

# ✅ 12. Quick Commands Summary

```bash
# Clean
./gradlew clean

# Build Debug
./gradlew assembleDebug

# Build Release
./gradlew assembleRelease

# Install Debug
./gradlew installDebug

# Git Flow
git add .
git commit -m "feat: message"
git pull origin develop
git push origin branch-name
```

---

# 📌 Final Notes

* Always follow team conventions
* Keep commits small and meaningful
* Test before pushing
* Respect code review process

---

🔥 Happy Coding Bro!

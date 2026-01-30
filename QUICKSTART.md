# Quick Start Guide - Diet & Lifestyle Tracker

## 🚀 Quick Commands

### Start Backend
```bash
# From project root (dietandlifestyle/)
.\mvnw.cmd spring-boot:run
```
Backend runs on: `http://localhost:8080`

### Start Frontend
```bash
# From frontend directory (dietandlifestyle/frontend/)
npm install
npm run dev
```
Frontend runs on: `http://localhost:5173`

---

## 📂 Project Components

### Backend (Spring Boot)

#### 1. **Entity** - [DietRecord.java](src/main/java/com/example/dietandlifestyle/entity/DietRecord.java)
- Database model with JPA annotations
- Fields: id, foodName, calories, mealType, date
- Uses Lombok for getters/setters

#### 2. **Enum** - [MealType.java](src/main/java/com/example/dietandlifestyle/enums/MealType.java)
- Values: BREAKFAST, LUNCH, DINNER, SNACK

#### 3. **Repository** - [DietRecordRepository.java](src/main/java/com/example/dietandlifestyle/repository/DietRecordRepository.java)
- Extends JpaRepository
- Custom method: `findByDate(LocalDate date)`

#### 4. **Service** - [DietRecordService.java](src/main/java/com/example/dietandlifestyle/service/DietRecordService.java)
- Business logic layer
- Methods: getAllRecords, getRecordById, getRecordsByDate, createRecord, updateRecord, deleteRecord

#### 5. **Controller** - [DietController.java](src/main/java/com/example/dietandlifestyle/controller/DietController.java)
- REST API endpoints at `/api/diet`
- CORS enabled for React frontend

### Frontend (React + Vite)

#### 1. **API Service** - [dietService.js](frontend/src/services/dietService.js)
- Axios-based API calls
- Base URL: `http://localhost:8080/api/diet`
- Methods match backend endpoints

#### 2. **DietList Component** - [DietList.jsx](frontend/src/components/DietList.jsx)
- Displays all diet records in a table
- Features:
  - Color-coded meal type badges
  - Total calorie counter
  - Delete functionality
  - Empty state UI
  - Loading spinner

#### 3. **DietForm Component** - [DietForm.jsx](frontend/src/components/DietForm.jsx)
- Uses React Hook Form
- Handles both Create and Edit modes
- Features:
  - Form validation
  - Error messages with icons
  - Responsive design
  - Loading states

#### 4. **App Component** - [App.jsx](frontend/src/App.jsx)
- Main application container
- Manages state for form visibility and editing
- Coordinates between DietList and DietForm

---

## 🧪 Testing the Application

### Test Flow:
1. ✅ Start backend → Wait for "Started DietandlifestyleApplication"
2. ✅ Start frontend → Open http://localhost:5173
3. ✅ Click "Add New Record" button
4. ✅ Fill form and click "Create Record"
5. ✅ Verify record appears in table
6. ✅ Click "Edit" to modify a record
7. ✅ Click "Delete" to remove a record

### Test Data Examples:
```json
// Breakfast
{
  "foodName": "Oatmeal with Berries",
  "calories": 250,
  "mealType": "BREAKFAST",
  "date": "2026-01-24"
}

// Lunch
{
  "foodName": "Grilled Chicken Salad",
  "calories": 450,
  "mealType": "LUNCH",
  "date": "2026-01-24"
}

// Dinner
{
  "foodName": "Salmon with Vegetables",
  "calories": 600,
  "mealType": "DINNER",
  "date": "2026-01-24"
}

// Snack
{
  "foodName": "Apple and Almonds",
  "calories": 180,
  "mealType": "SNACK",
  "date": "2026-01-24"
}
```

---

## 🎨 UI Features

### Design Highlights:
- **Gradient backgrounds** for a modern look
- **Color-coded meal badges**:
  - 🟡 Breakfast (yellow)
  - 🟢 Lunch (green)
  - 🔵 Dinner (blue)
  - 🟣 Snack (purple)
- **Validation messages** with icons
- **Loading states** with spinners
- **Responsive tables** with hover effects
- **Card-based form layout**

### Tailwind CSS Classes Used:
- Gradients: `bg-gradient-to-r`
- Shadows: `shadow-md`, `shadow-lg`
- Transitions: `transition-all`, `transition-colors`
- Responsive: `sm:`, `md:`, `lg:`
- States: `hover:`, `focus:`

---

## 🔧 Common Tasks

### Add New Field to Entity:
1. Add field to `DietRecord.java`
2. Update `DietRecordService.java` update method
3. Add input to `DietForm.jsx`
4. Add column to `DietList.jsx` table

### Change API Port:
1. Backend: Edit `application.properties` → `server.port=9090`
2. Frontend: Edit `dietService.js` → Update `API_BASE_URL`
3. Backend: Update `@CrossOrigin` in DietController

### Add Validation:
1. Backend: Add `@NotNull`, `@Size`, etc. to entity fields
2. Frontend: Add validation rules to `register()` in DietForm

---

## 📦 Build for Production

### Backend:
```bash
.\mvnw.cmd clean package
java -jar target/dietandlifestyle-0.0.1-SNAPSHOT.jar
```

### Frontend:
```bash
npm run build
# Output in dist/ folder
```

---

## 🐛 Debug Tips

### Backend Debugging:
- Check console for Spring Boot startup logs
- H2 Console: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (leave empty)

### Frontend Debugging:
- Open Browser DevTools (F12)
- Check Network tab for API calls
- Check Console for errors
- Use React DevTools extension

---

## 📈 Next Steps / Enhancements

### Potential Features:
- 🔍 Search and filter functionality
- 📊 Charts and analytics (daily/weekly totals)
- 👤 User authentication
- 💾 Export data to CSV
- 📱 Progressive Web App (PWA)
- 🌙 Dark mode
- 📸 Food image uploads
- 🎯 Daily calorie goals
- 📅 Calendar view
- 🏷️ Tags and categories

---

**Happy Coding! 🚀**

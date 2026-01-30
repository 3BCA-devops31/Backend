# 🚀 START HERE - Diet & Lifestyle Tracker

## Quick 3-Step Setup

### Step 1: Install Frontend Dependencies
Open PowerShell/Command Prompt and run:
```bash
cd d:\pro\dietlifestyle\dietandlifestyle\frontend
npm install
```
⏱️ This will take 1-2 minutes...

---

### Step 2: Start the Backend (Spring Boot)
Open a **NEW** terminal window and run:
```bash
cd d:\pro\dietlifestyle\dietandlifestyle
.\mvnw.cmd spring-boot:run
```

✅ Wait until you see: **"Started DietandlifestyleApplication in X seconds"**

Backend is now running on: `http://localhost:8080`

---

### Step 3: Start the Frontend (React)
Open **ANOTHER NEW** terminal window and run:
```bash
cd d:\pro\dietlifestyle\dietandlifestyle\frontend
npm run dev
```

✅ You'll see: **"Local: http://localhost:5173/"**

Frontend is now running on: `http://localhost:5173`

---

## 🎉 Open Your Browser

Visit: **http://localhost:5173**

You should see the Diet & Lifestyle Tracker!

---

## ✨ Try It Out

1. Click **"Add New Record"** button
2. Fill in the form:
   - Food Name: `Grilled Chicken Salad`
   - Calories: `350`
   - Meal Type: `Lunch`
   - Date: (today's date)
3. Click **"Create Record"**
4. See your record in the table!
5. Try **Edit** and **Delete** buttons

---

## 🛑 To Stop the Application

**Backend Terminal:** Press `Ctrl + C`  
**Frontend Terminal:** Press `Ctrl + C`

---

## 📋 Troubleshooting

### "Port 8080 is already in use"
Someone is using port 8080. Kill that process:
```bash
netstat -ano | findstr :8080
taskkill /PID <number> /F
```

### "Command 'npm' not found"
Install Node.js from: https://nodejs.org/

### "Failed to fetch records"
- Make sure backend is running (Step 2)
- Check backend terminal for errors
- Backend should show: "Started DietandlifestyleApplication"

### Form won't submit
- Open browser DevTools (F12)
- Go to Console tab
- Check for error messages
- Make sure both backend and frontend are running

---

## 📂 Project Structure Quick Reference

```
dietandlifestyle/
│
├── Backend (Spring Boot)
│   ├── src/main/java/.../
│   │   ├── controller/DietController.java       ← REST API
│   │   ├── service/DietRecordService.java       ← Business Logic  
│   │   ├── repository/DietRecordRepository.java ← Database
│   │   ├── entity/DietRecord.java               ← Data Model
│   │   └── enums/MealType.java                  ← Meal Types
│   └── pom.xml                                  ← Dependencies
│
└── frontend/ (React)
    ├── src/
    │   ├── components/
    │   │   ├── DietList.jsx                     ← Display Records
    │   │   └── DietForm.jsx                     ← Create/Edit Form
    │   ├── services/
    │   │   └── dietService.js                   ← API Calls
    │   ├── App.jsx                              ← Main Component
    │   └── main.jsx                             ← Entry Point
    └── package.json                             ← Dependencies
```

---

## 🎯 What You Built

✅ **Backend (Java Spring Boot)**
- REST API with 6 endpoints
- JPA/Hibernate for database
- H2 in-memory database
- CORS enabled for frontend

✅ **Frontend (React)**
- Modern UI with Tailwind CSS
- Form validation
- CRUD operations
- Real-time updates

---

## 📚 Next Steps

1. ✅ Test all CRUD operations
2. 📖 Read [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md) for detailed documentation
3. 🔍 Read [QUICKSTART.md](QUICKSTART.md) for advanced features
4. 🎨 Customize the UI colors in Tailwind
5. 🚀 Add new features (see PROJECT_SUMMARY.md → Future Enhancements)

---

## 💡 Tips

- Keep both terminals open while developing
- Backend auto-reloads on Java file changes
- Frontend auto-reloads on React file changes
- Press F12 in browser for DevTools
- Check H2 Console: http://localhost:8080/h2-console

---

**Need more help? Check the documentation files:**
- [README.md](README.md) - Full documentation
- [QUICKSTART.md](QUICKSTART.md) - Detailed guide
- [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md) - Complete overview

**Happy Coding! 🎉**

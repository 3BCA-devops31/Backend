# Diet & Lifestyle Tracker

A full-stack application for tracking daily diet and lifestyle habits built with Spring Boot (backend) and React (frontend).

## 🚀 Features

- ✅ Create, Read, Update, and Delete diet records
- 📊 Track food name, calories, meal type, and date
- 🎨 Modern UI with Tailwind CSS
- 📱 Responsive design
- ✨ Form validation with React Hook Form
- 🔄 Real-time updates

## 📋 Prerequisites

- **Java 17** or higher
- **Node.js 18** or higher
- **Maven** (included via mvnw)

## 🛠️ Installation & Setup

### Backend (Spring Boot)

1. Navigate to the project root:
   ```bash
   cd dietandlifestyle
   ```

2. Run the Spring Boot application:
   ```bash
   # Windows
   .\mvnw.cmd spring-boot:run
   
   # Mac/Linux
   ./mvnw spring-boot:run
   ```

3. The backend will start on `http://localhost:8080`

### Frontend (React + Vite)

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm run dev
   ```

4. The frontend will start on `http://localhost:5173`

## 🌐 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/diet` | Get all diet records |
| GET | `/api/diet/{id}` | Get a specific record by ID |
| GET | `/api/diet/date/{date}` | Get records by date (YYYY-MM-DD) |
| POST | `/api/diet` | Create a new record |
| PUT | `/api/diet/{id}` | Update an existing record |
| DELETE | `/api/diet/{id}` | Delete a record |

## 📦 Project Structure

```
dietandlifestyle/
├── src/main/java/com/example/dietandlifestyle/
│   ├── controller/          # REST Controllers
│   ├── entity/              # JPA Entities
│   ├── enums/               # Enums (MealType)
│   ├── repository/          # JPA Repositories
│   └── service/             # Business Logic
├── frontend/
│   ├── src/
│   │   ├── components/      # React Components
│   │   ├── services/        # API Service Layer
│   │   ├── App.jsx          # Main App Component
│   │   └── main.jsx         # Entry Point
│   └── package.json
└── pom.xml
```

## 🎯 Usage

1. **Start the backend** (runs on port 8080)
2. **Start the frontend** (runs on port 5173)
3. Open your browser to `http://localhost:5173`
4. Click "Add New Record" to create your first diet entry
5. Fill in the form with food details
6. View, edit, or delete records from the table

## 🔧 Technologies Used

### Backend
- Spring Boot 4.0.2
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- Maven

### Frontend
- React 18
- Vite
- Tailwind CSS
- Axios
- React Hook Form

## 📝 Sample Data Format

```json
{
  "foodName": "Grilled Chicken Salad",
  "calories": 350,
  "mealType": "LUNCH",
  "date": "2026-01-24"
}
```

## 🐛 Troubleshooting

### Backend won't start
- Ensure Java 17+ is installed: `java -version`
- Check if port 8080 is already in use
- Run `.\mvnw.cmd clean install` to rebuild

### Frontend won't start
- Ensure Node.js is installed: `node -v`
- Delete `node_modules` and run `npm install` again
- Check if port 5173 is available

### CORS Errors
- Verify the backend is running on `http://localhost:8080`
- Check that `@CrossOrigin(origins = "http://localhost:5173")` is present in DietController

### Connection Refused
- Make sure the Spring Boot backend is running before starting the frontend
- Check that the API base URL in `dietService.js` is correct

## 📄 License

This project is created for educational purposes.

## 👨‍💻 Author

Developed with ❤️ using Spring Boot and React

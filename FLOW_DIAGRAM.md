# Application Flow Diagram

## 🔄 Complete Data Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                         USER ACTIONS                             │
└────────┬──────────────────────────────────────────┬──────────────┘
         │                                          │
         │ Click "Add New Record"                   │ Click "Delete"
         │                                          │
┌────────▼──────────────────────────────────────────▼──────────────┐
│                        REACT APP                                  │
│                    (localhost:5173)                               │
├───────────────────────────────────────────────────────────────────┤
│                                                                   │
│   ┌─────────────────────────────────────────────────────────┐   │
│   │                    App.jsx                               │   │
│   │  • Manages showForm state                               │   │
│   │  • Manages editRecord state                             │   │
│   │  • Manages refreshTrigger                               │   │
│   └──────────┬────────────────────────────┬─────────────────┘   │
│              │                            │                      │
│   ┌──────────▼──────────┐     ┌──────────▼──────────┐          │
│   │   DietForm.jsx      │     │   DietList.jsx      │          │
│   │                     │     │                     │          │
│   │  • React Hook Form  │     │  • Displays table   │          │
│   │  • Validation       │     │  • Edit button      │          │
│   │  • Create/Edit mode │     │  • Delete button    │          │
│   └──────────┬──────────┘     └──────────┬──────────┘          │
│              │                            │                      │
│              └────────────┬───────────────┘                      │
│                           │                                      │
│                  ┌────────▼────────┐                            │
│                  │ dietService.js  │                            │
│                  │  (Axios)        │                            │
│                  └────────┬────────┘                            │
│                           │                                      │
└───────────────────────────┼──────────────────────────────────────┘
                            │
                            │ HTTP Request
                            │ POST /api/diet
                            │ GET /api/diet
                            │ PUT /api/diet/{id}
                            │ DELETE /api/diet/{id}
                            │
┌───────────────────────────▼──────────────────────────────────────┐
│                   SPRING BOOT APP                                │
│                  (localhost:8080)                                │
├──────────────────────────────────────────────────────────────────┤
│                                                                  │
│   ┌──────────────────────────────────────────────────────────┐ │
│   │              DietController.java                         │ │
│   │  @RestController                                         │ │
│   │  @RequestMapping("/api/diet")                           │ │
│   │  @CrossOrigin(origins = "http://localhost:5173")        │ │
│   │                                                          │ │
│   │  • getAllRecords()    → GET /api/diet                   │ │
│   │  • getRecordById()    → GET /api/diet/{id}              │ │
│   │  • createRecord()     → POST /api/diet                  │ │
│   │  • updateRecord()     → PUT /api/diet/{id}              │ │
│   │  • deleteRecord()     → DELETE /api/diet/{id}           │ │
│   └──────────────────────┬───────────────────────────────────┘ │
│                          │                                      │
│   ┌──────────────────────▼───────────────────────────────────┐ │
│   │            DietRecordService.java                        │ │
│   │  @Service                                                │ │
│   │                                                          │ │
│   │  • Business logic layer                                 │ │
│   │  • Calls repository methods                             │ │
│   │  • Handles exceptions                                   │ │
│   └──────────────────────┬───────────────────────────────────┘ │
│                          │                                      │
│   ┌──────────────────────▼───────────────────────────────────┐ │
│   │         DietRecordRepository.java                        │ │
│   │  extends JpaRepository<DietRecord, Long>                │ │
│   │                                                          │ │
│   │  • findAll()                                            │ │
│   │  • findById()                                           │ │
│   │  • findByDate()  ← Custom method                        │ │
│   │  • save()                                               │ │
│   │  • delete()                                             │ │
│   └──────────────────────┬───────────────────────────────────┘ │
│                          │                                      │
│   ┌──────────────────────▼───────────────────────────────────┐ │
│   │               DietRecord.java                            │ │
│   │  @Entity @Table(name = "diet_records")                  │ │
│   │  @Data (Lombok)                                         │ │
│   │                                                          │ │
│   │  • Long id (PK, auto-increment)                         │ │
│   │  • String foodName                                      │ │
│   │  • Integer calories                                     │ │
│   │  • MealType mealType (ENUM)                             │ │
│   │  • LocalDate date                                       │ │
│   └──────────────────────┬───────────────────────────────────┘ │
│                          │                                      │
└──────────────────────────┼──────────────────────────────────────┘
                           │
                           │ JPA/Hibernate
                           │ SQL Operations
                           │
┌──────────────────────────▼──────────────────────────────────────┐
│                   H2 DATABASE (In-Memory)                        │
│                     jdbc:h2:mem:dietdb                           │
├──────────────────────────────────────────────────────────────────┤
│                                                                  │
│   Table: diet_records                                           │
│   ┌────┬─────────────┬──────────┬───────────┬────────────┐     │
│   │ ID │ FOOD_NAME   │ CALORIES │ MEAL_TYPE │    DATE    │     │
│   ├────┼─────────────┼──────────┼───────────┼────────────┤     │
│   │ 1  │ Oatmeal     │   250    │ BREAKFAST │ 2026-01-24 │     │
│   │ 2  │ Salad       │   350    │   LUNCH   │ 2026-01-24 │     │
│   │ 3  │ Salmon      │   600    │  DINNER   │ 2026-01-24 │     │
│   └────┴─────────────┴──────────┴───────────┴────────────┘     │
│                                                                  │
└──────────────────────────────────────────────────────────────────┘
```

---

## 📱 User Journey Examples

### 1. Creating a New Record

```
User clicks "Add New Record"
    ↓
App.jsx: setShowForm(true)
    ↓
DietForm displays (empty form)
    ↓
User fills form and clicks "Create Record"
    ↓
DietForm: handleSubmit() triggered
    ↓
dietService.createRecord(data)
    ↓
POST http://localhost:8080/api/diet
    Body: { foodName: "Pizza", calories: 450, mealType: "DINNER", date: "2026-01-24" }
    ↓
DietController: @PostMapping createRecord()
    ↓
DietRecordService: createRecord()
    ↓
DietRecordRepository: save()
    ↓
H2 Database: INSERT INTO diet_records...
    ↓
Response 201 CREATED with saved record
    ↓
dietService returns data
    ↓
DietForm: onSuccess() called
    ↓
App.jsx: setRefreshTrigger(prev => prev + 1)
    ↓
DietList: useEffect triggered (refreshTrigger changed)
    ↓
DietList: fetchRecords()
    ↓
dietService.getAllRecords()
    ↓
GET http://localhost:8080/api/diet
    ↓
DietController: @GetMapping getAllRecords()
    ↓
DietRecordService: getAllRecords()
    ↓
DietRecordRepository: findAll()
    ↓
H2 Database: SELECT * FROM diet_records
    ↓
Response 200 OK with list of records
    ↓
DietList: setRecords(data)
    ↓
Table re-renders with new record visible
    ↓
User sees their new record in the table! 🎉
```

---

### 2. Editing a Record

```
User clicks "Edit" button on a row
    ↓
DietList: onEdit(record) called
    ↓
App.jsx: setEditRecord(record), setShowForm(true)
    ↓
DietForm displays with pre-filled data
    ↓
User changes calories from 350 to 400
    ↓
User clicks "Update Record"
    ↓
DietForm: handleSubmit() triggered
    ↓
dietService.updateRecord(editRecord.id, data)
    ↓
PUT http://localhost:8080/api/diet/2
    Body: { foodName: "Salad", calories: 400, mealType: "LUNCH", date: "2026-01-24" }
    ↓
DietController: @PutMapping updateRecord()
    ↓
DietRecordService: updateRecord()
    ↓
DietRecordRepository: findById() then save()
    ↓
H2 Database: UPDATE diet_records SET calories = 400 WHERE id = 2
    ↓
Response 200 OK with updated record
    ↓
DietForm: onSuccess() called
    ↓
App.jsx: refreshTrigger incremented
    ↓
DietList refreshes with updated data
    ↓
User sees updated calories in table! ✨
```

---

### 3. Deleting a Record

```
User clicks "Delete" button on a row
    ↓
DietList: handleDelete(id) called
    ↓
Browser shows confirm dialog: "Are you sure?"
    ↓
User clicks "OK"
    ↓
dietService.deleteRecord(id)
    ↓
DELETE http://localhost:8080/api/diet/3
    ↓
DietController: @DeleteMapping deleteRecord()
    ↓
DietRecordService: deleteRecord()
    ↓
DietRecordRepository: findById() then delete()
    ↓
H2 Database: DELETE FROM diet_records WHERE id = 3
    ↓
Response 204 No Content
    ↓
DietList: fetchRecords() called
    ↓
GET /api/diet to refresh list
    ↓
Table re-renders without deleted record
    ↓
User sees record removed from table! 🗑️
```

---

## 🔐 CORS Flow

```
Browser (localhost:5173) makes request
    ↓
Browser sends OPTIONS request (preflight)
    ↓
Spring Boot DietController has @CrossOrigin(origins = "http://localhost:5173")
    ↓
Spring responds with CORS headers:
    Access-Control-Allow-Origin: http://localhost:5173
    Access-Control-Allow-Methods: GET, POST, PUT, DELETE
    ↓
Browser sees CORS is allowed
    ↓
Browser sends actual request (GET/POST/PUT/DELETE)
    ↓
Request succeeds! ✅
```

Without @CrossOrigin, browser would block the request with CORS error ❌

---

## 📊 State Management

```
App.jsx (Parent Component)
├── showForm: boolean          → Controls form visibility
├── editRecord: object|null    → Holds record being edited (null = create mode)
└── refreshTrigger: number     → Increments to trigger list refresh

     Passed down as props
            ↓
    ┌───────┴────────┐
    ↓                ↓
DietForm          DietList
• editRecord      • onEdit (callback)
• onSuccess       • refreshTrigger
• onCancel
```

---

## 🎨 Styling System

```
Tailwind CSS Classes Applied
    ↓
PostCSS processes CSS
    ↓
Generates utility classes
    ↓
index.css imported in main.jsx
    ↓
Styles applied to React components
    ↓
Beautiful UI! 🎨

Common patterns:
• bg-gradient-to-r from-blue-600 to-blue-700  → Gradient backgrounds
• px-6 py-4                                     → Padding
• rounded-lg shadow-md                          → Rounded corners + shadow
• hover:bg-gray-50 transition-colors           → Hover effects
• text-sm font-medium text-gray-700            → Typography
```

---

**Understanding these flows will help you:**
- 🐛 Debug issues more effectively
- 🔧 Add new features confidently
- 📚 Learn full-stack development patterns
- 🚀 Build similar applications


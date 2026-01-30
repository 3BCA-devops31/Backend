@echo off
echo ========================================
echo Diet and Lifestyle Tracker - Setup
echo ========================================
echo.

echo [1/2] Setting up Frontend...
cd frontend
echo Installing npm dependencies...
call npm install

if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Failed to install frontend dependencies
    pause
    exit /b 1
)

echo.
echo ========================================
echo Setup Complete!
echo ========================================
echo.
echo To start the application:
echo   1. Start Backend:  .\mvnw.cmd spring-boot:run
echo   2. Start Frontend: cd frontend ^&^& npm run dev
echo.
echo Then open http://localhost:5173 in your browser
echo.
pause

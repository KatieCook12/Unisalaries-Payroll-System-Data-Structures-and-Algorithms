# CT5057 – Algorithms and Data Structures  
## Unisalaries Payroll System

This project was developed as part of the **CT5057 – Algorithms and Data Structures** module at the University of Gloucestershire. The application is a JavaFX-based payroll system called **Unisalaries**, designed to manage employee data and automate salary calculations using efficient data structures and algorithms.

The project demonstrates how core computer science concepts such as sorting, searching, and data organisation can be applied to a real-world system. It highlights how structured data handling improves performance, scalability, and reliability in business applications such as payroll systems.

---

## 🎯 Project Aim

The primary aim of this project was to design and implement a payroll management system that efficiently stores, processes, and retrieves employee data using appropriate data structures and algorithms.

The system allows users to:
- Manage employee records  
- Calculate salaries automatically  
- Perform efficient search and sorting operations  
- Handle structured datasets uploaded via files  

---

## 🖥 Application Screenshots

### Login Screen
<img src="images/Login Page.png" width="420">
 
### Main Dashboard
<img src="images/Main Home Page.png" width="420">

### Add Employee
<img src="images/Main Home Page.png" width="420">

### Search Employee  
<img src="images/Search Employee.png" width="420">

### Update Employee
<img src="images/Update an Employee.png" width="420">
 
### Print Payslip
<img src="images/Print Employee.png" width="420">

### Delete Employee  
<img src="images/Delete Employee.png" width="420">

---

## 🛠 Tech Stack

- **Java (JDK 17+)** – Core application logic  
- **JavaFX & FXML** – Graphical User Interface  
- **Maven** – Build and dependency management  
- **TXT File Handling** – Data storage and input  
- **JUnit** – Testing  

---

## ✨ Key Features

- JavaFX desktop application with interactive UI  
- Employee management system (Add, Update, Delete)  
- Upload and save employee data via TXT files  
- Salary calculation and payslip generation  
- Filtering and searching employees  
- Data validation (e.g. duplicate registration numbers)  
- Sorting and searching using efficient algorithms  

---

## ⚙️ Core Concepts Implemented

### 📦 Data Structures

The application uses several key data structures:

- **ObservableList** – Used to bind data to the JavaFX UI dynamically  
- **ArrayList** – Stores employee data efficiently with fast access  
- **HashMap** – Stores employee attributes as key-value pairs  

These structures were selected to balance performance, flexibility, and UI integration.

---

### 🔍 Algorithms

The system implements multiple algorithms to optimise operations:

- **Insertion Sort**  
  - Used when adding new employees  
  - Efficient for small or nearly sorted datasets  

- **Merge Sort**  
  - Used when uploading employee data  
  - Ensures efficient sorting with O(n log n) complexity  

- **Binary Search**  
  - Used to locate employees quickly  
  - Adapted to detect duplicate registration numbers  

These algorithms improve performance and ensure scalability of the system.

---

## ⚙️ What I Learned From This Project

### 📦 Data Structures & Algorithms
I gained practical experience in selecting appropriate data structures and algorithms based on problem requirements. This included understanding trade-offs between time complexity, memory usage, and scalability.

---

### 🧠 Problem Solving
I learned how to apply algorithms such as sorting and searching to real-world problems like payroll management and employee record handling.

---

### 🖥 GUI Development
Using JavaFX helped me understand how front-end interfaces interact with backend data structures, particularly through ObservableLists.

---

### 🧪 Testing
I implemented both:
- Unit testing (JUnit)  
- Functional testing  

This improved my ability to identify and fix issues systematically.

---

## 🧩 Areas for Improvement

- Replace TXT file storage with a relational database  
- Improve UI design and responsiveness  
- Add user authentication and role-based access  
- Optimise handling for larger datasets  
- Implement more advanced data structures (e.g. trees)  

---

## 🛠 Setup Instructions

### Prerequisites
- Java JDK 17 or newer  
- Maven  
- IntelliJ IDEA (recommended)

---

### Clone the repository
```bash
git clone https://github.com/KatieCook12/Unisalaries-Payroll-System-Data-Structures-and-Algorithms.git
cd Unisalaries-Payroll-System-Data-Structures-and-Algorithms

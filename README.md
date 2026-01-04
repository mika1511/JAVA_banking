
# Java Bank Management System (Swing + MySQL)

A desktop-based **Bank Management System** developed using **Java Swing** for the user interface and **MySQL** for database management.  
This application allows bank staff to manage user logins, create new accounts, perform transactions, and view account details.

---

## 🚀 Features

- Secure **Login Authentication**
- **Create New Bank Accounts**
- **Deposit & Withdrawal Transactions**
- **Account Balance Tracking**
- **User Control Panel** (Create/Delete Users)
- **Account Details Display**
- **Logout Functionality**
- MySQL Database Integration

---

## 🛠️ Technologies Used

- **Java (JDK 8+)**
- **Java Swing (GUI)**
- **MySQL**
- **JDBC (MySQL Connector)**

---

## 🗄️ Database Setup

1. Install **MySQL Server**
2. Create a database named:

```sql
CREATE DATABASE bankdb;
````

3. Import the database schema:

```bash
mysql -u root -p bankdb < bank_mysql.sql
```

4. Tables used:

   * `usertbl`
   * `accounttbl`
   * `transactiontbl`

---

## ▶️ How to Compile & Run

### Compile

```bash
javac -cp ".;mysql.jar" bank_mysql.java
```

### Run

```bash
java -cp ".;mysql.jar" bank_mysql
```


## 📸 Application Screenshots

### 🏠 Home Screen
![Home Screen](https://github.com/user-attachments/assets/b5d1958d-2624-4aa0-a57e-995766c78d0b)

---

### 🔐 Login Screen
![Login Screen](https://github.com/user-attachments/assets/3a5866b2-597f-401e-96ed-5fa1620d4621)

---

### 💰 Account Transaction
![Account Transaction](https://github.com/user-attachments/assets/9e545d1f-af5e-4f76-9b09-fe20ad1725e3)

---

### 📊 Account Details (Output)
![Account Details Output](https://github.com/user-attachments/assets/ed813190-3a67-4ec8-b456-484b7b746a93)

---

### 🛠️ Control Panel
(Create/Delete User Logins)

![Control Panel](https://github.com/user-attachments/assets/2ab1a9cd-620b-4afc-b25b-088da343890e)

---

### 📊 Account Details
(View transaction history and balance)

![Account Details](https://github.com/user-attachments/assets/35c2772e-2816-45d1-bd78-39eb8564ee49)



## 🔮 Future Enhancements

* Password hashing
* Date picker for DOB
* Improved UI layout
* Admin role management
* Report generation (PDF/Excel)

---

## 👨‍💻 Author

**Bhumika Deshmukh**
Java Developer | Swing | MySQL

---

## 📜 License

This project is for **educational purposes**.


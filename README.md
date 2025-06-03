# 🛒 Shopping Cart Management System (Spring Boot)

A backend RESTful API built using **Spring Boot** for managing a shopping cart system. It includes modules for **Product management**, **User management**, and **Cart operations**.

---

## 🚀 Tech Stack

- **Java 8**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL / H2**
- **Lombok**
- **ModelMapper / MapStruct**
- **Maven**

---

## 📦 Features

### ✅ Product Module
- Create, Read, Update, Delete products
- Validations on product fields (price, quantity, name, etc.)

### ✅ User Module
- Register new users
- Retrieve user details
- Each user has their own cart

### ✅ Cart Module (In Progress)
- Add product to cart
- Increase or update quantity
- View cart with total price

---

## 📡 Sample API Endpoints

| Method | Endpoint              | Description               |
|--------|-----------------------|---------------------------|
| `POST` | `/api/products`       | Create a new product      |
| `GET`  | `/api/products`       | Get all products          |
| `PUT`  | `/api/products/{id}`  | Update product by ID      |
| `DELETE`| `/api/products/{id}` | Delete product by ID      |
| `POST` | `/api/users`          | Register new user         |
| `POST` | `/api/cart/add`       | Add product to cart       |

---

## 🧪 Sample Add to Cart Request


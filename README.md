🚀 Inventra - Inventory Management System

A scalable RESTful Inventory Management System built using Java, Spring Boot, Spring Data JPA, Hibernate, and Oracle Database. Inventra is designed to simplify inventory operations by managing products, categories, suppliers, and sales.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📌 Overview

Inventra is an enterprise-style backend application developed following a layered architecture. It provides secure and scalable REST APIs with validation, centralized exception handling, pagination, and automatic invoice generation for sales transactions.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✨ Features

📂 Category Management

- Create Category
- Update Category
- Delete Category
- Get Category by ID
- Get All Categories
- Find Category by Name
- Check Category Availability
- Get Total Category Count

📦 Product Management

- Create Product
- Update Product
- Delete Product
- Get Product by ID
- Get All Products
- Search Products
- Get Products by Category
- Get Products by Supplier
- Get Products by Price Range
- View Low Stock Products
- View Out of Stock Products
- Pagination Support

🏢 Supplier Management

- Create Supplier
- Update Supplier
- Delete Supplier
- Get Supplier by ID
- Get All Suppliers
- Find Supplier by Email
- Search Suppliers
- Get Total Supplier Count

💰 Sales Management

- Create Sale
- Update Sale
- Delete Sale
- Get Sale by ID
- Get All Sales
- Get Sale by Invoice Number
- Get Today's Sales
- Get Monthly Sales
- Get Total Sales Amount
- Get Total Sales Count

📊 Inventory Management

- Increase Stock
- Decrease Stock
- View Low Stock Products
- View Out of Stock Products

📈 Dashboard

- Total Products
- Total Categories
- Total Suppliers
- Total Sales
- Today's Sales
- Monthly Sales
- Low Stock Products
- Out Of Stock Products
- Recent Sales

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🛠 Tech Stack

🟢 Java 21

🟢 Spring Boot

🟢 Spring Data JPA

🟢 Spring MVC

🟢 Hibernate

🟢 Oracle Database

🟢 Maven

🟢 Jakarta Validation

🟢 REST API

🟢 Postman

🟢 Git & GitHub

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🏗 Architecture

The application follows a layered architecture to ensure maintainability, scalability, and separation of concerns.

**Architecture Diagram:**

```
                              User

                               │

                            REST API
                               
                               │

                      Spring Boot Server

                        │     │      │
         ┌──────────────────────────────────────────────┐
         │         │      │        │        │           │
      Product  Category Supplier Sales Inventory  Dashboard
         │         │      │        │        │           │
         └─────────┴──────┴────────┴────────┴───────────┘
                               │

                            Service

                 ┌───────────────────────────┐
                 │             │             │
                 Validation Exception Invoice
                        │      │      │
                        └──────┼──────┘
                               │
                              JPA

                               │

                        Oracle Database

                               │

                        JSON Response

                              │   
                              ▼
                             User
```


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✅ Validation

Implemented using Jakarta Bean Validation.

Examples

- Product name cannot be blank
- Price must be greater than zero
- Quantity cannot be negative
- Category is mandatory
- Supplier is mandatory

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

⚠ Exception Handling

Centralized exception handling using:

- Controller Advice
- Custom Exceptions
- Validation Error Handling

Example Response

```json
{
  "success": false,
  "message": "Category not found."
}
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📄 Pagination

Implemented using Spring Data JPA.

Example

```
GET /products/page?page=0&size=10
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🧾 Automatic Invoice Generation

Each sale automatically generates a unique invoice number.

Example

```
INV-20260719-4821
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🌐 REST APIs

Currently includes 35+ REST APIs across:

- Category Management
- Product Management
- Supplier Management
- Sales Management
- Inventory Management
- Dashboard Analytics

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🧪 API Testing

All endpoints have been tested using Postman.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🚀 Upcoming Features

- DTO Mapping
- Swagger / OpenAPI Documentation
- Sorting
- Filtering
- Unit Testing (JUnit & Mockito)
- Product Image Upload
- Excel Import & Export
- PDF Invoice Generation
- Email Notifications
- Spring Security & JWT
- Cloud Deployment

🚀 Ongoing Development

This project is actively being enhanced. The following resources will be added in upcoming updates:

- API testing screenshots (Postman / Swagger)
- Application screenshots
- Deployment guide
- Architecture diagrams
- Additional documentation
- Future feature updates

Stay tuned for upcoming improvements.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

👨‍💻 Developer - Nikhil Khatke  ( Java Developer )

🔗 GitHub: https://github.com/Nikhil-khatke11

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

⭐ If you like this project, don't forget to give it a Star.

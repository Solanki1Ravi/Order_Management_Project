
# 🛠️ Tech Stack

---

1. Spring Boot
2. Spring Web
3. Spring Data JPA
4. H2 / MySQL / PostgreSql
5. RestTemplate or WebClient
6. Maven


---

## Online Order Management System

---

## 🧩 Microservices Breakdown

---
#  ️1. User Service

 - **Responsibility**: Manage users/customers

```json
{
  "id": 1,
  "name": "Ravi",
  "email": "ravi@gmail.com"
}

```

# 2️⃣ Product Service

- **Responsibility:** Manage products
```json

{
  "id": 101,
  "name": "Laptop",
  "price": 55000
}

```


#  3️⃣ Order Service ⭐ (Main Service)

- **Responsibility:** Create and view orders
- 👉 This service communicates with both **User Service** and **Product Service**.
```
POST /orders

```
### Flow

---

1. Order Service receives userId and productId

2. Calls User Service → verify user exists

3. Calls Product Service → get product details

4. Saves order

5. Returns combined response


## 🔄 Communication Example (REST Call)

---

1. Order Service → User Service
```java
ResponseEntity<UserDTO> user =
    restTemplate.getForEntity(
        "http://localhost:8081/users/" + userId,
        UserDTO.class
    );


```

2. Order Service → Product Service
```java
ResponseEntity<ProductDTO> product =
    restTemplate.getForEntity(
        "http://localhost:8082/products/" + productId,
        ProductDTO.class
    );

```
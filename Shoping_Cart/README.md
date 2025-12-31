# Shopping Cart — Spring Boot E-commerce Application

A professional, production-oriented e-commerce shopping cart web application built with Spring Boot and Thymeleaf. It includes user and admin features, secure authentication, product/catalog management, cart and order processing.

## Table of Contents
- Project Overview
- Features
- Tech Stack
- Requirements
- Quick Start (build & run)
- Configuration
- Database Setup
- Project Structure
- Development & Testing
- Deployment
- Contributing
- License

## Project Overview
This project implements a typical online shopping flow with separate admin and user interfaces. It demonstrates integration of Spring Boot, Spring Security, Spring Data JPA, Thymeleaf templates, and a relational database.

## Features

- User
	- Registration, login/logout, profile management
	- Browse and search products by category
	- Add/remove items from cart
	- Place orders and view order history

- Admin
	- Secure admin area
	- Category and product management (create, edit, enable/disable)
	- View users and orders

- Security
	- Role-based access control (ADMIN / USER)
	- Custom authentication handlers
	- Account lockout after repeated failed login attempts

## Tech Stack

- Java 17+ (project built/tested with Java 17; Java 21 recommended)
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- Thymeleaf
- MySQL
- Maven

## Requirements

- Java 17 or higher
- Maven 3.6+
- MySQL 8+

## Quick Start (Build & Run)

From the project root (where `pom.xml` is located):

Linux/macOS:

```bash
./mvnw clean package
```

Windows (PowerShell / CMD):

```powershell
mvnw.cmd clean package
```

Run the packaged application:

```bash
java -jar target/Shoping_Cart-0.0.1-SNAPSHOT.jar
```

By default the application listens on http://localhost:8080. See `src/main/resources/application.properties` to change the port or datasource.

## Configuration

Update `src/main/resources/application.properties` with your database credentials and any environment-specific settings. Typical properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false

# server.port=8080
```

For sensitive values consider using environment variables or an external configuration mechanism.

## Database Setup

Create a database for the application (example for MySQL):

```sql
CREATE DATABASE ecommerce_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

The application uses JPA/Hibernate. With `spring.jpa.hibernate.ddl-auto=update` the schema will be created/updated automatically during development. For production use a controlled migration tool (Flyway/Liquibase) is recommended.

## Project Structure

```
Shoping_Cart/
├─ src/main/java/com/ecom/shoppingcart
│  ├─ config        # Security & configuration
│  ├─ controller    # Web controllers (admin, user, home)
│  ├─ model         # JPA entities
│  ├─ repository    # Spring Data repositories
│  ├─ service       # Service interfaces
│  ├─ service/impl  # Service implementations
│  └─ util         # Utilities & constants
├─ src/main/resources
│  ├─ static        # css, js, images
│  ├─ templates     # Thymeleaf templates (admin/, user/)
│  └─ application.properties
├─ pom.xml
└─ README.md
```

## Development & Testing

- Run the application from your IDE by launching the main Spring Boot application class (e.g., `ShopingCartApplication`).
- Use the Maven wrapper (`./mvnw` / `mvnw.cmd`) for consistent builds.
- Tests (if present) can be run with:

```bash
./mvnw test
```

## Deployment

- Build the JAR as shown above and run it on a server or container.
- For production: use an externalized configuration, connection pooling, HTTPS, and a managed database. Consider Dockerizing the app and using a process manager (systemd, Kubernetes).

## Important URLs (default)

- Home: http://localhost:8080/
- Login: http://localhost:8080/signin
- Admin Dashboard: http://localhost:8080/admin/

## Contributing

Contributions are welcome. Please:

1. Fork the repository
2. Create a feature branch
3. Submit a pull request with a clear description and tests

## Security & Privacy

- Do not commit credentials or secrets. Use environment variables or a secrets manager.
- For production readiness, enable HTTPS and review security settings in `SecurityConfig`.

## License

Specify your license here (e.g., MIT, Apache-2.0) or remove this section if proprietary.

---

If you'd like, I can also:
- Create a concise `CONTRIBUTING.md` and `LICENSE` file
- Prepare a `docker-compose.yml` for a quick local MySQL + app setup
- Help you push this repository to GitHub




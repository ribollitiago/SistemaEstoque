# SistemaEstoque

A Java desktop inventory management system featuring a Swing graphical interface, DAO pattern for data access, and Maven-based build — covering client registration, product management, stock control, and quote generation.

---

## Highlights

- Client and employee registration with full CRUD via DAO layer
- Product catalogue and real-time stock control
- Quote (orçamento) generation workflow
- Swing UI with custom image assets
- Clean separation: Entity → DAO → UI
- Maven project structure for dependency and build management

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17+ |
| UI | Java Swing |
| Data Access | DAO Pattern (JDBC) |
| Build | Apache Maven |
| IDE | Eclipse / IntelliJ |

---

## Project Structure

```
src/main/java/
├── entities/          # Domain models (Client, Product, Employee, …)
├── dao/
│   ├── ClientsDAO.java
│   └── EmployeeDAO.java
└── ui/                # Swing frames and panels
src/main/resources/    # Images and UI assets
pom.xml
```

---

## Getting Started

### Prerequisites

- Java 17+
- Apache Maven 3.6+

### Build & Run

```bash
mvn clean package
java -jar target/SistemaEstoque-*.jar
```

Or run directly from your IDE by executing the main application class.

---

## Author

**Tiago Ribolli Blasquez**  
[linkedin.com/in/tiagoribolli](https://linkedin.com/in/tiago-ribolli-blasquez-060810244) · [github.com/ribollitiago](https://github.com/ribollitiago)

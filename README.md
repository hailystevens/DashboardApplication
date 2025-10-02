# Dashboard Management System

## Description
A dashboard management system for data analysis and visualization. This Spring Boot application allows users to create custom dashboards with data from CSV files, databases, or manual entry.

## Features
- Create custom dashboards with multiple chart types (line charts, pie charts)
- Support for multiple data sources:
  - CSV file upload
  - Database connections
  - Manual data entry
- H2 in-memory database for development
- MySQL support for production
- Web-based dashboard visualization using Plotly.js
- Dark/Light theme support

## Technical Stack
- **Backend**: Spring Boot 3.3.0, Java 17
- **Frontend**: HTML, CSS, JavaScript, Bootstrap 4
- **Database**: H2 (development), MySQL (production)
- **Security**: Spring Security
- **Template Engine**: Thymeleaf
- **Data Visualization**: Plotly.js

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL (optional, for production use)

## Quick Start

### 1. Clone the repository
```bash
git clone https://github.com/hailystevens/DashboardApplication.git
cd DashboardApplication
```

### 2. Run the application
The application is configured to use H2 in-memory database by default for easy development:

```bash
./mvnw spring-boot:run
```

Or on Windows:
```cmd
mvnw.cmd spring-boot:run
```

### 3. Access the application
Open your browser and navigate to:
- **Homepage**: http://localhost:8080/
- **Create Dashboard**: http://localhost:8080/create_dashboard
- **H2 Console** (for database inspection): http://localhost:8080/h2-console

For H2 console access, use these credentials:
- JDBC URL: `jdbc:h2:mem:dashboarddb`
- Username: `sa`
- Password: (leave empty)

## Configuration

### Using MySQL (Production)
To use MySQL instead of H2, update `src/main/resources/application.properties`:

1. Comment out the H2 configuration
2. Uncomment the MySQL configuration
3. Update the database connection details:

```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Building for Production

### Create a JAR file
```bash
./mvnw clean package
```

### Run the JAR
```bash
java -jar target/dashboard-0.0.1-SNAPSHOT.jar
```

## Usage

1. **Navigate to the homepage** at http://localhost:8080/
2. **Click "Create Dashboard"** to start building a new dashboard
3. **Choose your data source**:
   - Upload a CSV file
   - Connect to a database
   - Enter data manually
4. **Select a theme** (Dark or Light)
5. **Submit** to create your dashboard
6. **View and analyze** your data with interactive charts

## Development

### Running Tests
```bash
./mvnw test
```

### Project Structure
```
DashboardApplication/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hailybelle/dashboard/
│   │   │       ├── config/         # Configuration classes
│   │   │       ├── controllers/    # REST controllers
│   │   │       ├── models/         # Entity models
│   │   │       ├── repositories/   # Data repositories
│   │   │       └── services/       # Business logic
│   │   └── resources/
│   │       ├── templates/          # Thymeleaf templates
│   │       └── application.properties
│   └── test/
│       └── resources/
│           └── application.properties  # Test configuration
└── pom.xml
```

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License
This project is available for personal and educational use.

## GitHub Repository
[GitHub Repository](https://github.com/hailystevens/DashboardApplication)

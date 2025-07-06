# 🏏 CricBuzz - Cricket Management System

A comprehensive Spring Boot application for managing cricket teams, players, matches, and statistics. This RESTful API provides complete functionality for cricket team management with features like player registration, match scheduling, statistics tracking, and email notifications.

## 🚀 Features

### Core Functionality
- **Player Management**: Register and manage cricket players with detailed profiles
- **Team Management**: Create and manage cricket teams with rankings and ICC points
- **Match Management**: Schedule and track cricket matches between teams
- **Statistics Tracking**: Maintain detailed player statistics (batting, bowling averages)
- **Email Notifications**: Automatic email notifications for player registrations

### Technical Features
- **RESTful API**: Complete REST API with proper HTTP status codes
- **Database Integration**: MySQL database with JPA/Hibernate ORM
- **Email Service**: SMTP email integration for notifications
- **Exception Handling**: Custom exception handling with proper error responses
- **API Documentation**: Swagger/OpenAPI documentation
- **Data Validation**: Request/Response DTOs with proper validation

## 🛠️ Technology Stack

- **Framework**: Spring Boot 3.3.5
- **Language**: Java 21
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Documentation**: SpringDoc OpenAPI 2.6.0
- **Email**: Spring Boot Mail Starter
- **Utilities**: Lombok for boilerplate reduction

## 📋 Prerequisites

Before running this application, ensure you have:

- **Java 21** or higher
- **MySQL 8.0** or higher
- **Maven 3.6** or higher
- **Git** (for cloning the repository)

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd CricBuzz
```

### 2. Database Setup
1. Create a MySQL database named `cricbuzzDB`
2. Update database credentials in `src/main/resources/application.properties` if needed:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=admin
   ```

### 3. Run the Application

#### Option 1: Using Maven
```bash
mvn spring-boot:run
```

#### Option 2: Using Maven Wrapper
```bash
./mvnw spring-boot:run
```

#### Option 3: Build and Run JAR
```bash
mvn clean package
java -jar target/CricBuzz-0.0.1-SNAPSHOT.jar
```

### 4. Access the Application
- **Application**: http://localhost:8080
- **API Documentation**: http://localhost:8080/swagger-ui.html

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api/v1
```

### 1. Player Management

#### Add a New Player
```http
POST /player
Content-Type: application/json

{
  "name": "Virat Kohli",
  "age": 34,
  "gender": "MALE",
  "speciality": "BATTER",
  "email": "virat.kohli@example.com"
}
```

#### Get Player by ID
```http
GET /player?player-id=1
```

#### Get Players by Gender
```http
GET /player/gender/MALE
```

#### Get Players by Gender and Speciality
```http
GET /player/gender/MALE/speciality/BATTER
```

### 2. Team Management

#### Add a New Team
```http
POST /team
Content-Type: application/json

{
  "teamName": "India",
  "ranking": 1,
  "iccPoints": 120
}
```

### 3. Match Management

#### Register a Match
```http
POST /match?teamA-id=1&teamB-id=2
Content-Type: application/json

{
  "title": "India vs Australia",
  "matchType": "ODI",
  "overs": 50,
  "place": "Melbourne Cricket Ground"
}
```

### 4. Statistics Management

#### Add Player Statistics
```http
POST /stats?player-id=1
Content-Type: application/json

{
  "runsScored": 12000,
  "wicketsTaken": 0,
  "battingAverage": 59.07,
  "bowlingAverage": 0.0
}
```

## 🗄️ Database Schema

### Players Table
- `id` (Primary Key)
- `name` (String)
- `age` (Integer)
- `gender` (Enum: MALE, FEMALE)
- `speciality` (Enum: BATTER, BOWLER, ALL_ROUNDER)
- `email` (String)
- `team_id` (Foreign Key)

### Teams Table
- `id` (Primary Key)
- `team_name` (String)
- `ranking` (Integer)
- `icc_points` (Integer)

### Matches Table
- `id` (Primary Key)
- `title` (String)
- `match_type` (Enum: ODI, T20, TEST)
- `overs` (Integer)
- `place` (String)
- `started_at` (Timestamp)

### Stats Table
- `id` (Primary Key)
- `runs_scored` (Integer)
- `wickets_taken` (Integer)
- `batting_average` (Double)
- `bowling_average` (Double)
- `player_id` (Foreign Key)

## 🔧 Configuration

### Application Properties
The application uses the following key configurations:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/cricbuzzDB
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=acciojobspring@gmail.com
spring.mail.password=imrprnqgfrgfarvi
```

## 📁 Project Structure

```
src/main/java/com/acciojob/CricBuzz/
├── controller/          # REST API Controllers
│   ├── PlayerController.java
│   ├── TeamController.java
│   ├── MatchController.java
│   └── StatsController.java
├── service/            # Business Logic Layer
│   ├── PlayerService.java
│   ├── TeamService.java
│   ├── MatchService.java
│   └── StatsService.java
├── repository/         # Data Access Layer
│   ├── PlayerRepository.java
│   └── TeamRepository.java
├── model/             # Entity Classes
│   ├── Player.java
│   ├── Team.java
│   ├── CricketMatch.java
│   ├── Stats.java
│   └── Enum/
│       ├── Gender.java
│       ├── Speciality.java
│       └── MatchType.java
├── dto/               # Data Transfer Objects
│   ├── request/
│   └── response/
├── converter/         # Entity-DTO Converters
├── exception/         # Custom Exceptions
└── CricBuzzApplication.java
```

## 🧪 Testing

Run the test suite using Maven:

```bash
mvn test
```

## 📝 API Response Examples

### Successful Player Creation
```json
{
  "id": 1,
  "name": "Virat Kohli",
  "age": 34,
  "gender": "MALE",
  "speciality": "BATTER",
  "email": "virat.kohli@example.com"
}
```

### Successful Match Registration
```json
{
  "title": "India vs Australia",
  "matchType": "ODI",
  "overs": 50,
  "place": "Melbourne Cricket Ground",
  "startedAt": "2024-01-15T10:00:00.000+00:00",
  "teams": [
    {
      "teamName": "India",
      "ranking": 1
    },
    {
      "teamName": "Australia",
      "ranking": 2
    }
  ]
}
```

## 🔍 Error Handling

The application includes comprehensive error handling:

- **PlayerNotFoundException**: When player ID is invalid
- **TeamNotFoundException**: When team ID is invalid
- **HTTP 400**: Bad Request for invalid data
- **HTTP 201**: Created for successful resource creation

## 📧 Email Notifications

The application automatically sends email notifications when:
- A new player is registered successfully

Email configuration uses Gmail SMTP with the following settings:
- Host: smtp.gmail.com
- Port: 587
- Authentication: Required
- TLS: Enabled

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- MySQL team for the database
- Lombok team for reducing boilerplate code

---

**Note**: This is a Spring Boot application for cricket team management. Make sure to have MySQL running and properly configured before starting the application. 

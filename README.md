# RMI Distributed Calculator — Java RMI Client/Server

A client-server distributed calculator application using Java Remote Method Invocation (RMI). The client provides a graphical desktop interface (Swing) to perform arithmetic operations executed remotely on the server.

## Features
- Remote arithmetic (add, subtract, multiply, divide)
- Dedicated RMI registry on port 1091
- Swing GUI with input validation
- Error handling (division by zero, connection failures, non-numeric input)

## Architecture
The application uses a client-server model:
- Server creates an RMI registry and binds `CalcImpl`.
- Client looks up the remote object and invokes methods through the `CalcIntf` interface.

## Tech Stack
- Java 21
- Maven
- Java RMI
- Java Swing/AWT

## Project Structure
```
.
├── Client/
│   ├── pom.xml
│   └── src/main/java/rmi/
│       ├── CalcIntf.java
│       └── Client.java
└── Server/
    ├── pom.xml
    └── src/main/java/rmi/
        ├── CalcImpl.java
        ├── CalcIntf.java
        └── Server.java
```

## Getting Started

### Prerequisites
- JDK 21+
- Maven

### Build
Compile the server and client:
```bash
cd Server && mvn compile
cd ../Client && mvn compile
```

### Run
Note: Start the server before the client.

**Run Server:**
```bash
cd Server && mvn exec:java
```

**Run Client:**
```bash
cd Client && mvn exec:java
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the [MIT License](LICENSE).

## Author

[Tayeb Bekkouche](https://github.com/tayebg)

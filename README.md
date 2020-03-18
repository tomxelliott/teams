# Teams App
## Build the App
A prerequisite to following this setup process is that you must have both Java 8 and Maven installed on your system.

This application uses Maven as its package manager and using Maven we can easily build the application with the following command:
```
mvn clean package
```

## Run the Application
Once the previous step has completed and the build was successful the app can be run using the following command: 
```
java -jar target/teams-1.0-SNAPSHOT.jar
```
This will print out the required teams information to the command line.
## Tests
The unit tests included in this project can be run with the following command:
```
mvn test
```
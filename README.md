# spring-boot-rest-security-hibernate
Project to practice spring boot and hibernate

## Pre-requisite: 
1. Maven should be installed on machine
2. Java 11 or higher should be installed on machine


## Clone and run project
1. git clone https://github.com/kishan917/spring-boot-rest-security-hibernate.git
2. cd spring-boot-rest-security-hibernate
3. mvn package
4. cd target
5. java -jar spring-boot-rest-security-hibernate-1.0.jar


## Access application
1. Hit http://localhost:9094/ in any browser to access application
2. Note: http://localhost:9094/admin/** endpoint is only accessible to admin user


## Run aplication from IDE
1. Open project in Eclipse or any other IDE
2. Open file spring-boot-rest-security-hibernate/src/main/java/com/kishan/springboot/testapis/StartApplication.java
3. Run file (In Eclipse: Right Click -> Run As -> Java Application)


## Access embedded H2 database 
1. Hit http://localhost:9094/h2 in any browser to access H2 database
2. Enter following DB details:
3. Setting Name: Generic H2 (Embedded)
4. Driver Class: org.h2.Driver
5. JDBC URL: jdbc:h2:file:./H2DB_Storage
6. User Name: sa
7. Password:
8. Click connect

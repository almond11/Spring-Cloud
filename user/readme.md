*Create a Remote MySQL Instance on AWS
1.	Login to the Amazon AWS console and select RDS .

2.	Launch to add a new RDS instance, with engine type ,use case Dev/Test – MySQL,  DB instance class db.t2.micro.

3.	Set up and remember own master username and password. Enable Public accessibility . Configure security group to allow access from EC2.

4.	Write down RDS Endpoint and Port Number 3306

 


*Create a User Database in MySQL Instance on AWS
1.	Install, Configure, and Start MySQL Workbench, Connected to RDS with master name and password.
2.	Create database in Wrokbench:

CREATE DATABASE credit_card_db;
USE credit_card_db;

CREATE TABLE IF NOT EXISTS user_info (
user_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
addr VARCHAR(255),
email VARCHAR(50),
);

*Develop/ Integrate Spring Boot with MySQL
1.	Install Maven, Spring Tool Suite (STS)
 
2.	Use template files.
3.	Modify application.properties under Spring Project’s src/main/resources

spring.datasource.url=jdbc:mysql:// RDS Endpoint :3306/ credit_card_db spring.datasource.username=master name
spring.datasource.password=master password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

4.	Open the pom.xml and add the following dependency element to the existing dependencies
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<scope>runtime</scope>
</dependency>
5.	This project is using JDBC. Thus needs to develop JDBC controller, JDBC repository, JDBC application, user bean for following 4 REST API:
Show all users (GET)
Show user by ID (GET)
Create new user (POST)
Delete user by Id ( DELETE)

6.	Test locally at localhost:8080
7.	Build jar with Maven.
 


*Deploy Spring Boot Web Application to AWS (EC2)

1.	Create Amazon Linux 2 AMI (HVM), SSD Volume Type with instance size of t2.micro, 8GB volume, Security Group accepting internet traffic. 
 

2.	SSH into EC2 instance with key file.

3.	Install all update and java 11
	$ sudo yum update
$sudo amazon-linux-extras install java-openjdk11
$sudo yum remove java-1.7.0-openjdk

4.	Upload local Spring Jar file to EC2 instance
5.	SSH back into EC2 instance and run the following command to start up spring application:

Java -jar Spring_FILE.jar

This should start up application and run it in the background. The application should now be running at instances public DNS on port 8080. 

6.	When you wish to stop your application you can bring it to the foreground and kill it with the following commands.
Jobs Fg %JOB_NAME
Control-c


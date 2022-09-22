# Read Me First
Customer Rewards API with H2 DB

## Prerequisites
1. JDK 1.8
2. STS/Eclipse/IntelliJ IDE

## Getting Started
1. Run this rewards-api as SpringBoot Application.
2. Open Swagger UI with

	http://localhost:8080/swagger-ui/index.html#/
	
 Couple of sample URL's

	http://localhost:8080/customer/1/rewards 
		200 status code with all the rewards
		
	http://localhost:8080/customer/1/rewards?fromDate=2022-07-15
		200 status code with all the rewards for the orders placed on or after July 15, 2022
		
	http://localhost:8080/customer/2/rewards?toDate=2022-09-22
		200 status code with all the rewards for the orders placed on or before Sept 22, 2022
		
	http://localhost:8080/customer/2/rewards?fromDate=2022-07-15&toDate=2022-09-22
		200 status code with all the rewards for the orders placed between after July 15, 2022 and Sept 22, 2022
		
	http://localhost:8080/customer/3/rewards
		404 status code
	
	




## Database
1. This application is using H2 DB in memory database.
2. Schema and Test data are available in src/main/resources/schema.sql and src/main/resources/data.sql files.
3. These files will be loaded into in memory H2 DB on server start up and after server stopping the loaded data will be vanished.
4. Table "REWARDS_CONFIGURATION" contain the rewards percentage for purchase amount.
5. Table "ORDERS" contains the customer orders.
6. Upon server startup, we can access the H2 DB console using following URL.
 
	http://localhost:8080/h2-console/
	
	JDBC URL: jdbc:h2:mem:orders
	UserName: sa
	password: sa

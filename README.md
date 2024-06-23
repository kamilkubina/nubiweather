# nubiweather
Application to show current and forecast weather in cities.

# How to run application
1) Download nubiweather-0.0.1-SNAPSHOT.jar
2) Create "nubiweather" database in PostgreSQL
3) Create user with "username" username and "password" password 
4) Open terminal in directory which contains .jar file and run java -jar nubiweather-0.0.1-SNAPSHOT.jar

# Implemented features
1) /realtime-weather returns current weather in city entered in query parameter (for example: /realtime-weather?city=Gliwice)
2) /forecast-weather returns forecast weather in city and days entered in query parameters (for example: /forecast-weather?city=Gliwice&days=2)
3) Added global exceptions handler for 2 exceptions: when parameter is missing and when parameter type is wrong
4) Created database in PostgreSQL and currentWeather entity 
5) Added REST API functions for managing entity in the database
6) Added test functions for /realtime-weather and /forecast-weather endpoints
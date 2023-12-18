# Getting Started

1. Download project: 

  git clone https://github.com/geoPinkman/country_traveller.git

2. Install project using maven:

  mvn clean install 

3. Start project:

  mvn spring-boot:run 


# In your browser

  http://localhost:8080/routing/ - shows all available countries;

  http://localhost:8080/routing/{CCA} - shows the country by cca3 code and its neighbors;

  http://localhost:8080/routing/{ORIGIN}/{DESTINATION} - shows the shortest route between countries by cca3 code;

   

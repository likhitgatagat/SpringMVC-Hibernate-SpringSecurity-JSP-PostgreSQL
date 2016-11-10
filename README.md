# SpringMVC-Hibernate-SpringSecurity-JSP-PostgreSQL
This is a sample project for integration of Spring MVC, Hibernate, Spring Security with front end as JSP and database as PostgreSQL. I have also managed to handle role based access mechanism that is widely needed in any enterprise application. 

Steps to use this project for learning and understanding purpose: 
Before you start with below step I would advise to go to PgAdmin, and restore the database using the script that you will find with name blma.backup in the repository here
1. Use eclipse IDE (my preference: Mars or Neon). 
2. Import this project into your work space as an existing maven project. 
3. Right click on project and go to properties.
	a. set Java build path so that you have JDK instead of JRE in your class path (Preferably select JDK 1.8, if you plan to use JDK 6 or 7, then you need to set it accordinly in POM file also, in my POM file search for 1.8 and replace it with 1.6 if you are using JDK 6 otherwise 1.7 is you are using JDK 7)
	b. Java Comipler: This should be set and matched to the version of JDK you have set in java build path (e.g: if in build path you have set JSK ver 8 then here comiler must be set to 1.8)
	c. Project facets: Dynamic Web Module: set it to 3.1 and Java set it to 1.8
	d. Target Run Time: Select the server (my preference Apache 8, it is stable), if server is not there add one using new button.
	2. click on apply and then ok button.
4. Right click on project and Select Maven: Update Project option to update your project with the dependencies mentioned in POM file
5. Right click on project and Select Run As: Maven Clean
6. Right click on project and Select Run As: On Server

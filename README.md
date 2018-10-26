# Example EJB3, WSDL, XSD, JPA and gradle project.

This project is a simple example to build and deploy a web service with soap, EJB3 and Jpa technologies built using Gradle. This is intended to be deployed in Jboss 7.1 with a MySQL 5.5 database


1. Create the database and tables using the script provided in database/scripts directory.

2. Copy the standalone.xml in the database/ directory to the JBOSS_HOME/standalone/configuration directory or update the datasources section accordingly.

3. Install mysql-connector into jboss as a module
	* create the folder structure JBOSS_HOME\modules\com\mysql\main and copy the mysql connector jar to that location
	* copy the module.xml file in the database directory to the same location. NOTE: match the module name in the module.xml file to the standalone.xml


4. Checkout the project and navigate to the project folder

6. Run the command ```gradle init```

7. Build the projcet using ```gradle clean assemble``` command

8. Copy the GradleSoapXSDTopDownJpa.jar file to the JBOSS_HOME/standalone/deployments directory

9. Start Jboss

19. Access the web service using http://localhost:8080/shyali/GradleSoapTopDownXSD/HelloService link

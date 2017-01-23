Customer Manager
-------------------
Demonstrates the basic capabilities of customer management system.

In this showcase you'll see the following in action:

1. Add customer details
2. Edit individual customer details
3. List all customers
4. Delete customers (individual record deletion is sufficient)

Technologies used
------------------
 * Java 8
 * Spring 4.2
 * Hibernate 4.3
 * MySQL

Deployment Environment
----------------------
 wildfly-10.0.0.Final

To get the code
-------------------
Clone the repository:

    $ git clone https://github.com/senurayasas/CustomerManager.git

To run the cms
-----------------------

1. Create the cms database by executing,
    CREATE DATABASE cms;

2. Modify db properties of the file src/main/resources/db-config.properties by providing username and the password.

3. Build the maven project
    mvn clean install

4. Copy the cms.war file to wildfly-10.0.0.Final/standalone/deployments folder

5. Start the server,
   Root url :  http://localhost:8080/cms/customers
   
Note
------------------------
The customer management system (cms) is implemented based on the spring mvc.
JSP is used as the view provider.
All the database table will be auto generated.

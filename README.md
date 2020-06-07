# Microservice exercise

# installation and running 

requires: Java 8, Maven, MySQL

- assumes MySQL is installed, available and running on the host machine 
	* NB. If it isn't available, probably the quickest option would be to go the docker route (make sure to publish the port correctly)
		>> docker pull mysql/mysql-server:latest
		>> docker run --name=faceit-user-db -d mysql/mysql-server:latest 
		(...)

- Create database and user (the application is a prototype, thus for the simplicity sake it's bound to a specific user/schema)
	* Through the mysql console, create db and user to be used. 
	mysql>> create database faceit_user;
	mysql>> create user faceitapp identified by 'pwd';
	mysql>> grant all on faceit_user.* to 'faceitapp';

- Install and run the application
	* from the main folder (will contain .pom file)
	>> mvn install 
	>> mvn spring-boot:run
		* (the sql migrations should run on the first initialisation of the app)

- Test the endpoints 
	>>  curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"firstName":"name","lastName":"surname","nickname":"nick","password":"pwd","email":"em@il.com","country":"country"}' http://localhost:3003/create

	>> curl http://localhost:3003/



# Notes

As should be obvious from the code provided my experience with microservices architecture is limited to "toy-projects".
I've limited the amount of time for this test project to 5 hours, which was reaasonable amount of time to implement core features. 

Assumptions: 

- Delete action requires full user object to proceed with the deletion. Actual implementation uses name, surname, nick and email to do so, there is no unique user identifier therefore this set of data was used. 
- Password are already be hashed.


Decissions: 
- Aspect Oriented Approach was taken to tackle parts of logging, and to be used later for notification passing. Opinions are divided with this approach, but I believe it provides a clear decoupling of logging/messaging from functional parts of the codes, and can be easily mixed with custom annotations (that were created as well) to provide additional data. With good code structure (single responsibiliy, good abstraction segregation etc) it is a clean solution. Downside is, with such approach it might be necessary to use object reflection (which isn't a nicest thing to do).
- Jackson package used to parse json, as it provides reliable out-of-the-box solution. 
- flyway for db migrations, as provides decent db versioning mechanism and simple migations. 
- spring-boot with actuator to provide servide metrics and health status, this can be easily extended and tailored to provide more information. 
- Where possible dependencies are provided through spring's inversion of control container. 


With the additional time following would be improved:

- Fully implement all endpoints (add, delete, and fetch all were implemented; the rest of endpoints are just repetition of the same pattern).
- Extend unit tests and add an integration test.
- Implement Event Notification. Structurally it would make more sense to have a separate service to be responsible for notifications receiving and dispatching - as to not to pollute the "single responsibility" service. One element then missing from the user app is the notification class, which would describe the event happening - this was partially tackled with the aspect-oriented approach. The LoggerAspect acts as a "watcher" and from there the application could be extended without change of the core features. 
- Improve overall code structure.  



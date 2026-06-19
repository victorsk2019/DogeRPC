# DogeRPC
Spring Boot Doge RPC REST controller and service layer implemented as Maven project. 
This project was created using IntelliJ IDEA IDE but needs an external JAR dependency for
RPC API calls. This dependency was created using NetBeans IDE and so JAR can be generated with Apache Ant tool.

## Getting Started
Clone or download this project.  In order to have RPC API RQ/RS functionality, it is necessary to download and build
`doge-rpclib.jar` from https://github.com/victorsk2019/doge-rpclib.git, and run 'ant' to generate the JAR file.

The `doge-rpclib.jar` dependency specified in project's `pom.xml` assumes it is registered in maven's local `.m2` 
cache directory.  To register the dependency to make use of RPCClient and RPCProperties classes and to satisfy doge-rpclib 
dependency entries in `pom.xml`, the following commands were used:

`mvn install:install-file -Dfile=<jar location>/doge-rpclib.jar -DgroupId=com.rpclib.client -DartifactId=RPCClient -Dversion=1.0.1 -Dpackaging=jar`

and

`mvn install:install-file -Dfile=<jar location>/doge-rpclib.jar -DgroupId=com.rpclib.util -DartifactId=RPCProperties -Dversion=1.0.1 -Dpackaging=jar`

Alternatively, the dependency library can be added to the project by placing it in a custom `lib` directory and specifying `<system-path>` for its location.

## Project Details
DogeRPC comprises a Controller and Service layer.  The Controller layer calls on a Service layer instance (`DogeRPCCOnnect` class) to
send and receive RPC API data as JSON string while the Service layer, implemented by`DogeRPCConnect` class,
uses connection values defined in `application.properties` to call the JAR library directly to return raw JSON string. 

With Maven, the project can be built using: 

`mvn clean package` 

and launched as a standalone JAR from anywhere using:

`java -jar DogeRPC-<current version>.jar` command.

## TODO
Add testing module.

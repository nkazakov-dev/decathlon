# Decathlon calculating application 
#####  Java 11 project using Maven and JUnit 5.x

1. Get adoptopenjdk-11: https://adoptopenjdk.net/
2. Get maven 3.6.x: https://maven.apache.org/
3. Add above to your path if neccessary.
4. `git clone https://github.com/nkazakov-dev/decathlon.git`
5. `mvn clean install`
6. `java -jar target/decathlon.jar`

## How to use application

By default, input files must be located in the **input** directory next to the jar file, result files will be created in the **output** directory next to the jar file.

In order to change default directory locations, it must be added **config.properties** with following properties to next to the jar:

```
input.directory.path=
output.directory.path=
```

Note that, value of properties is preferred to be **absolute path**.

That is all.

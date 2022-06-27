# spring-shell-tutorial

In this repository we will give a quick introduction to the Spring Shell project, which can be found at [https://github.com/spring-projects/spring-shell](https://github.com/spring-projects/spring-shell).

According to the documentation [https://spring.io/projects/spring-shell](https://spring.io/projects/spring-shell) we have that 

> Users of the Spring Shell project can easily build a full featured shell (aka command line) application by depending on the Spring Shell jars and adding their own commands (which come as methods on spring beans). Creating a command line application can be useful e.g. to interact with your project’s REST API, or to work with local file content.

That is, the Spring Shell project allows you to build a command line application, leveraging many of its features including tab completion, colorization and more.

## Usage

Build the JAR file using

```shell
./gradlew build
```

and then run the JAR using

```shell
java -jar build/libs/spring-shell-0.0.1-SNAPSHOT.jar
```

As soon as the program boots up, use the `help` command to navigate your way through the cli.

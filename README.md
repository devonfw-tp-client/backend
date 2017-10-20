## Getting started

### Install prerequisites

#### Git
Check if you have a Git client already installed:

```
git --version
```

If your OS can not recognize this command, install Git. For details please refer to [this page](http://git-scm.com).
When installing under Windows, please make sure you check the following option:

* Use git from Windows command prompt

#### Java (JDK 8)
Check if you have Java already installed:

```sh
java -version
```

If your OS either can not recognize this command or your current Java version is not 8, install JDK8.
For details please refer to [this page](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

Make sure your `JAVA_HOME` environment variable is set to the directory you have just installed the JDK8 and its `bin`
directory is among `PATHS` (typically `%JAVA_HOME%\bin`).

### Clone, install dependencies and run

Clone this repository:
```
https://github.com/devonfw-tp-client/backend.git
```

Install dependencies using [Maven Wrapper](https://github.com/takari/maven-wrapper):
```
cd backend
mvnw clean package
```
This may take a while...

Start the application running the executable jar:
```
java -jar target\demo-backend-0.0.1-SNAPSHOT.jar
```

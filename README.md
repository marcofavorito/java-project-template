# Java project template

## Preliminaries

- Install Java 19. E.g. on Ubuntu:
```
sudo apt install -y openjdk-19-jdk
```

- Install [Gradle](https://gradle.org/). 
  Follow [the official guide](https://gradle.org/install/) to install it
  on your system. E.g. to install Gradle 7.6 on Linux:

```
wget https://services.gradle.org/distributions/gradle-7.6-bin.zip
mkdir /opt/gradle
unzip -d /opt/gradle gradle-7.6-bin.zip
rm gradle-7.6-bin.zip
```

and then configure your path to include the installation directory:
```
export PATH=$PATH:/opt/gradle/gradle-7.6/bin
```

## Build & Test

To build the project:
```
./gradlew build
```

To run the tests of all the subprojects:
```
./gradlew check
```

## Linting

To run `spotless`:

```
./gradlew spotlessApply
```

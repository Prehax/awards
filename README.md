#How to run

before that, make sure you have already installed git, java and maven

open terminal, run

    git clone https://github.com/Prehax/awards.git

then, you will find there is one more folder named awards appears, now run

    mvn install

now we installed necessary dependencies, next run
    
    mvn package

next we can run, the command is

    java -jar ./target/award-0.0.1-SNAPSHOT.jar

then open browser, open 

    http://localhost:8080

you will find the api I finished. This is only backend, the API is for front end to use.

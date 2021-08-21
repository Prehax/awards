# How to run

before that, make sure you have already installed git, java and maven

go to URL:
    
    https://github.com/Prehax/awards

to get the project git url, and use terminal, run

    git clone https://github.com/{yourname}/awards.git

then, you will find there is one more folder named awards appears, now run
    
    cd awards
    
now we are in the project folder, then run

    mvnw sprint-boot:run

then open browser, there are several apis running here:
    
get all transactions:

    http://localhost:8080/transaction/all
    
search transactions by month:

    http://localhost:8080/transaction/getByMonth/{month}

get all customers:
    
    http://localhost:8080/customer/all

get customer by id:

    http://localhost:8080/customer/getById/{id}

Some other API need to be tested by Postman, like delete and add

delete transaction:

    http://localhost:8080/transaction/deleteById/{id}

add transaction and also provide a transaction object:

    http://localhost:8080/transaction/add

update transaction:

    http://localhost:8080/transaction/update

And I also have some JUnit test case, need to be run by Intellij

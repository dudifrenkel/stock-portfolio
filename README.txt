Stock portfolio
===============

download MongoDB:
http://docs.mongodb.org/manual/installation/

MongoDB requires a data directory to store all data. 
MongoDB�s default data directory path is the absolute path \data\db on the drive from which you start MongoDB. 

create \data\db or
change to alternative folder by using the command:
"C:\Program Files\MongoDB\Server\3.6\bin\mongod.exe" --dbpath %path\data

run mongod

Request options:

register a new client - 
PUT http://localhost:8080/users 
{
    "stocks": {
        "{FIRST_STOCK_NAME}": {FIRST_STOCK_QUANTITY},
        "{SECOND_STOCK_NAME}": {SECOND_STOCK_QUANTITY},
        ...
    }
}

update an existing client - 
POST http://localhost:8080/users 
{
        "id": "{USER_ID}",
        "stocks": {
            "{FIRST_STOCK_NAME}": {FIRST_STOCK_QUANTITY},
			"{SECOND_STOCK_NAME}": {SECOND_STOCK_QUANTITY},
			...
        }
    }

update an existing client with values change -
POST http://localhost:8080/users/update-values/{id}
{
            "{FIRST_STOCK_NAME}": {FIRST_STOCK_CHANGE},
			"{SECOND_STOCK_NAME}": {SECOND_STOCK_CHANGE},
			...
        }

Check current portfolio value -
GET http://localhost:8080/users/portfolio-value/{id}
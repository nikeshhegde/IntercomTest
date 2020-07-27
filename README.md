# IntercomTest

Technical problem

We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

You must use the first formula from this Wikipedia article to calculate distance. Don't forget, you'll need to convert degrees to radians.

The GPS coordinates for our Dublin office are 53.339428, -6.257664.

You can find the Customer list here.

We're looking for you to produce working code, with enough room to demonstrate how to structure components in a small program. Good submissions are well composed. Calculating distances and reading from a file are separate concerns. Classes or functions have clearly defined responsibilities.  Poor submissions will be in the form of one big function. It’s impossible to test anything smaller than the entire operation of the program, including reading from the input file.


# How to run this project
## Step 1)
The project requires Java and Maven installed in order to run
Java SE Development Kit 8 (1.8.0) or latest

Run this command in your terminal to see what version you have setup
```bash
java -version
```

Maven 3.0 or latest

Run this command in your terminal to see what version you have setup
```bash
mvn -version
```

## Step 2)
Download the project using git commands or as .zip and extract the project

## Step 3)

Once you have the project, using your terminal navigate to its root folder (containing "README.md","pom.xml" file)
Now run this command: 
```bash
mvn clean install
```
This will use Maven to download the required dependencies, and build an executable jar file in the newly created "target" folder

## Step 4)

You can now execute the project by navigating inside the target folder and running this command

```bash
java -jar target/
```
You can see the following output in the output.txt generated
```bash
 User Id: 4 Full Name : Ian Kehoe
 User Id: 5 Full Name : Nora Dempsey
 User Id: 6 Full Name : Theresa Enright
 User Id: 8 Full Name : Eoin Ahearn
 User Id: 11 Full Name : Richard Finnegan
 User Id: 12 Full Name : Christina McArdle
 User Id: 13 Full Name : Olive Ahearn
 User Id: 15 Full Name : Michael Ahearn
 User Id: 17 Full Name : Patricia Cahill
 User Id: 23 Full Name : Eoin Gallagher
 User Id: 24 Full Name : Rose Enright
 User Id: 26 Full Name : Stephen McArdle
 User Id: 29 Full Name : Oliver Ahearn
 User Id: 30 Full Name : Nick Enright
 User Id: 31 Full Name : Alan Behan
 User Id: 39 Full Name : Lisa Ahearn
```

## Author
Nikesh Hegde


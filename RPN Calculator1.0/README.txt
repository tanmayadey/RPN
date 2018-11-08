Project Title
RPN Calculator 1.0

Getting Started
This Application will give you "command line RPN calculator"
Application will start from Executor Class, after Import this project on eclipse , run Executor class as java class. 
It will ask you for the input, enter the input such as "3 4 +" and press the "enter" you will get the output.
Or you can run the provided jar file
To Run the jar file use below command
java -jar "RPNCalculator.jar"

Prerequisites
Need one Java IDE such as eclips
JDK 8


Installing
Download the folder from github
open your eclipse
go to file 
then click on import
select as java project
then give the path where you keep your folder(that you have downloaded from git)
click finish

Running the tests
Run the test class , by giving your desire output


Built With
Eclipse - Java8
Maven - Dependency Management (Yet to use)

Version control
Yet to plan

Feature  
The calculator has a stack that can contain real numbers.
The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
Available operators are +, -, *, /, sqrt, undo, clear
Operators pop their parameters off the stack, and push their results back onto the stack.
The 'clear' operator removes all items from the stack.
The 'undo' operator undoes the previous operation. "undo undo" will undo the previous two operations.
sqrt performs a square root on the top item from the stack
The '+', '-', '*', '/' operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
After processing an input string, the calculator displays the current contents of the stack as a space-separated list.

Future Task 
Complete all validation
add more methodology

Authors
Tanmaya Dey
# Java-Sorting-Algorithms-Benchmarking-Application
This Java programme benchmarks various sorting algorithms, ranking them against eachother in order of Big-O Time complexity.

Includes Bubble Sort, Merge Sort, Count Sort, Gnome Sort and Stooge Sort algorithms.

This project violates the single responsibility principle by containing only one class*. This was a design choice due to the short amount of code but should be improved on for sake of good OOP practise.

We created 5 methods which contain the code for each sorting algorithm,  an array of elements to be sorted (randomArray), and a method to benchmark the speed of each sorting algorithm (benchmark). The main method calls each sorting algorithm against various sample sizes and calls the benchmark method against each one. 


//////////////

HOW TO RUN

//////////////

Via the command prompt on your OS (cmd on Windows), navigate to the bin directory of the Programme and run the following command:

java -cp ./Benchmark.jar ie.gmit.hdip.New

//////////////

TO DO

//////////////

*Needs more abstraction of functionality - encapsulate a single class for each piece of functionality and delegate responsibility from the main method to those single classes. 

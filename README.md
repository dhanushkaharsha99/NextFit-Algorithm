Next Fit Memory Allocation Simulator

Project Description

This project is a Next Fit Memory Allocation Simulator implemented in Java. It demonstrates how memory allocation works using the Next Fit algorithm, where processes are allocated to memory blocks starting from the last allocated position. It includes a graphical user interface (GUI) for interactive simulations and visualizes the state of memory dynamically.

Key Features

Dynamic Memory Allocation: Simulates memory allocation and deallocation using the Next Fit algorithm.
Interactive GUI: Users can input block sizes, request allocations, and see the changes in real time.
Graphical Visualization: Memory blocks are visually represented in color (allocated/free states).
Input Validation: Ensures all inputs are valid and handled properly.
Technologies Used
Programming Language: Java
Frameworks: Java Swing for GUI

Tools

IntelliJ IDEA / Eclipse (IDE for development)
Git for version control
Data Structures: ArrayList for managing memory blocks
System Requirements
Java Development Kit (JDK): Version 8 or higher
Any Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans)
A computer with at least 2GB of RAM for smooth execution
Setup and Installation
Follow these steps to set up and run the project on your local machine:

Clone the Repository
Open a terminal or command prompt and run:

bash
Copy code
git clone https://github.com/yourusername/NextFit-Memory-Allocator.git
cd NextFit-Memory-Allocator
Compile the Code
Use the javac command to compile all Java files:

bash
Copy code
javac src/*.java
Run the Application
Run the main program to launch the GUI:

bash
Copy code
java src/MemoryAllocatorUI
Enjoy the Simulator

Input the memory block sizes.
Allocate processes by entering their sizes.
Observe the memory state dynamically.

Usage Instructions
Step-by-Step Simulation
Enter Memory Blocks: Input sizes of available memory blocks (e.g., 100, 500, 200).
Allocate Memory: Enter the size of the process you want to allocate.
Deallocate Memory: Remove allocated memory by specifying the block index.
Visualize Memory: The GUI displays the memory blocks in allocated (red) and free (green) states.

Algorithm Explanation
The Next Fit Algorithm works as follows:

Start searching for a suitable memory block from the last allocated position.
If a block is free and large enough, allocate the process and move the pointer to the next block.
If no block is found, the search wraps around to the beginning of the list.
If no block fits, an allocation error is returned.

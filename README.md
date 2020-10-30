# Quiz 4 - CS 3310
# Peaks and Valleys & Build Order
10/21/2020

Jordan Bui (BroncoID: 011821368)

CPP Fall 2020

CS 3310 Design and Analysis of Algorithms

Quiz 4 Code Implementation
-
Implementations for Peaks and Valleys and Build Order


Peaks and Valleys
-

 This program sorts an array by peaks and valleys by checking every two array
 indexes. 
 - Starts at array index 1, second element, and checks in the previous
 element is smaller than the current. If it is smaller, swap the current
 element with the previous element, which becomes the new current element.
 - Then check if the current element is smaller than the element to the
 right. If it is larger than the element on the right, swap the elements.
 - Prints initial array and size then sorts and prints sorted array and sorting time
 in nanoseconds
 
  Time Complexity:
  
   T(n) = O(n)
   
   Since the sort algorithm contains one for loop that searches all elements in the 
   array, the time complexity is O(n).
   As the size of the array increases, the program will have more array elements to sort 
   through, increasing runtime.

Build Order
-

This program creates an order based on the dependencies.
- Places the projects in a hash map. Uses a queue to traverseand check for dependencies

Time Complexity:

T(n) = O(V + E)
- v = number of vertices
- e = number of edges.

Each vertex is popped from the queue and its adjacent edges are iterated over.

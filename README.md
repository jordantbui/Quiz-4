# Quiz-4
Quiz 4 

CS 3310

Jordan Bui

011821368

10/21/2020


Quiz 4

Implementations for Peaks and Valleys and Build Order

Peaks and Valleys

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

 This

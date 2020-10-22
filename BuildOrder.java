/*
Jordan Bui
011821368
Fall 2020
CS 3310
Quiz 4
Build Order

This program creates an order based on the dependencies.
Places the projects in a hash map.


Time Complexity:
T(n) = O(V + E)
v = number of vertices
e = number of edges.
Each vertex is popped from the queue and its adjacent edges are iterated over.

Sample Test run:

CS 3310 Quiz 4 Build Order
Jordan Bui
-----------------------------------

Build Order:
e f a b d c 

Time elapsed: 985278ns
*/

import java.util.*;

public class BuildOrder
{
	// Print Array Function
	private static void printArray(String arr[])
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (i % 10 == 0 && i > 0)
				System.out.println();
			System.out.print(arr[i] + " ");
		}
		System.out.println('\n');
	}
	
	
	public static class Node
	{
		boolean placed = false;
        Set<String> parents;
        Set<String> children;
        
        public Node()
        {
        	parents = new HashSet<String>();
			children = new HashSet<String>();
        }
	}
	
	
	// Build Order Sort
	public static String[] sortBuildOrder(String[] proj, String[][] dep)
	{
		HashMap<String, Node> table = new HashMap<String,Node>();
		
		for (String curProject : proj)
		{
			Node curNode = new Node();
			table.put(curProject, curNode);
		}
		
		for (String[] curDep : dep)
		{
			String first = curDep[0];
			String second = curDep[1];
			Node curNode = table.get(second);
			curNode.parents.add(first);
			curNode = table.get(first);
			curNode.children.add(second);
		}
		
		Queue<String> available = new LinkedList<String>();
		for (String curProject : proj)
		{
			Node curNode = table.get(curProject);
			if (curNode.parents.size() == 0)
				available.add(curProject);
		}
		
		String[] sol = new String[proj.length];
		int pos = 0;
		
		while (available.size() > 0)
		{
			String curProject = available.poll();
			sol[pos] = curProject;
			pos++;
			Node curNode = table.get(curProject);
			for (String curChild : curNode.children)
			{
				Node childNode = table.get(curChild);
				childNode.parents.remove(curProject);
				if (childNode.parents.size() == 0)
					available.add(curChild);
			}
		}
		
		if (pos < proj.length)
			throw new ArithmeticException("No solution");	
			
		return sol;
	}

	
// Test Program
	public static void main(String[] args)
	{
		System.out.println("CS 3310 Quiz 4 Build Order");
		System.out.println("Jordan Bui");
		System.out.println("-----------------------------------\n");
			
		// Tests example array
		String vals[] = new String[] {"a", "b", "c", "d", "e", "f"};
		String deps[][] = new String[][] {
			{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
			
		long start = System.nanoTime();
		String sol[] = sortBuildOrder(vals, deps);
		long end = System.nanoTime();
		long time = end - start;
		
		System.out.println("Build Order:");
		printArray(sol);
		System.out.println("Time elapsed: " + time + "ns");

	}
}

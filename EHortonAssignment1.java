// Programmer Name: Elizabeth Nocon
// Class and Section: CS 1450.001
// Assignment Number: 1
// Due Date: 8/29/2018
// Description: 
// The following program creates an array of 25 randomly generated numbers. Sum, average, median, and mode are calculated
// for the set of randomly generated numbers. The array is sorted, then exported to a text file. The text file displays
// the randomly generated numbers in order. The text file is then read and the values of the file displayed on the console.

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class EHortonAssignment1 
{
	//Main method. 
	public static void main (String [] args) throws IOException
	{
		//Create array numbers with a value of 25.
		int[] numbers = new int[25];
		
		//Print "Random values stored in array" before printing array values.
		System.out.println("Random values stored in array");
		
		//Use a for loop to generate 25 numbers between 0 and 99. Assign these numbers to the array numbers, then print.
		for (int i = 0; i < numbers.length; i++) 
		{
			numbers[i] = (int)(Math.random()*100);
			System.out.println(numbers[i]);
		}
		
		//Create variable sum. Calculate sum using a for loop and display sum. 
		double sum = 0;
		for (int i = 0; i < numbers.length; i ++) 
		{
			sum += numbers[i];
		}
		System.out.println("Sum = " + sum);
		
		//Create variable average. Calculate average and display. Sum is already calculated. Sum/25 will result in average.
		double average = sum/25;
		System.out.println("Average = " + average);
		
		//Sort the array before finding the median. (Because the median will be at index 12).
		//Use a for loop to repeat the sort through all 25 numbers. 
		for (int i = 0; i < numbers.length-1; i ++) 
		{
			//Identify the smallest value in the array. Initially set index i as smallest value index.
			int currentSmallestValue = numbers[i];
			int currentSmallestValueIndex = i; 
			//Use a for loop to compare the values in the array in order to find the smallest.
			for (int j = i + 1; j < numbers.length; j++) 
			{
				if (currentSmallestValue > numbers[j]) //If next number in array is larger, than reassign currentSmallestValue and index.
					{
					currentSmallestValue = numbers[j];
					currentSmallestValueIndex = j;
					}
					
			}
		
			//Replace numbers[i] with numbers[currentSmallestValueIndex], when needed. 
			if (currentSmallestValueIndex != i) 
			{
				numbers[currentSmallestValueIndex] = numbers[i];
				numbers[i] = currentSmallestValue;
			
			}
		}
		
		//Create variable median. Calculate and display the median. 
		int median = numbers[12];
		System.out.println("Median = " + median);
		
		//Calculate the mode and display.
		//Create variables for the mode, modeFrequency to hold the value of the mode and number of occurrences. 
		//Create testingMode and testingModeFrequency to test each number in the array index.
		int mode = 0;
		int modeFrequency = 0; //Number of times the mode appears.
		int testingMode = 0;
		int testingModeFrequency = 0;
		for(int i = 0; i < numbers.length; i++) 
		{
			testingMode = numbers[i]; //To be able to test each number to verify the mode.
			testingModeFrequency = 1;
			for(int j = i + 1; j < numbers.length-1; j++) 
		{
				if(numbers[i] == numbers[j]) //If two index values match, increase the number of occurrences.
				{
					testingModeFrequency++;
				}
		}
			if(testingModeFrequency > modeFrequency) //If the testing number occurs more than the mode, replace the mode.
			{
				modeFrequency = testingModeFrequency;
				mode = testingMode;
			}
		}
		System.out.println("Mode value = " + mode + " which occurred " + modeFrequency + " times");
		
		//Create text file using printWriter so you can write inside the text file.
		File assignment1 = new File("assignment1.txt");
		PrintWriter output = new PrintWriter(assignment1);  
		for (int i = 0; i < numbers.length; i ++) 
		{
			output.println(numbers[i]);
		}
		output.close();
		
		//Read the values from assignment1.txt and display.
		Scanner input = new Scanner(assignment1);
		System.out.println("Random values stored in file in increasing order ");
		for (int i = 0; i < numbers.length; i ++) 
		{
			System.out.println(numbers[i]);
		}
		input.close();
	}
}

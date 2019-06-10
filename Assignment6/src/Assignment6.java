import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Assignment6 {
	public static void main(String[] args) throws IOException {
		
		Stack<Character> num = new Stack<Character>();
		
		num = readNumericFromFile(""); 								//Full File Path Name to put in ""
		
	//	for(int i = 0; i < num.size(); i++) {						//Test for Function #4
	//		System.out.println(num.get(i));
	//	}
		
	//	Stack<Character> reversed = reverseStack(num);				//Test for Function #2
	//	for(int i = 0; i < reversed.size(); i++) {
	//		System.out.println(reversed.get(i));
	//	}
		
	//	Stack<Character> reversed = new Stack<Character>();			//Test for Function #1
	//	reversed = reverseStack(num);
	//	Queue<Character> queue = toQueue(reversed);
	//	for(Character ch : queue) {
	//		System.out.println(ch);
	//	}
		
	//	Stack<Integer> intStack = new Stack<Integer>();				//Test for Function #3
	//	intStack.push(2);
	//	intStack.push(3);
	//	intStack.push(4);
	//	intStack.push(5);
	//	for(Integer i : intStack) {
	//		System.out.println(i);
	//	}
	//	int sum = sumBetween(intStack, 0,3);
	//	System.out.println(sum);
	}

    /*
     * Converts from a stack to a Queue. The queue will be represented as a LinkedList
     */
    public static Queue<Character> toQueue(Stack<Character> stackOriginal) {
    	
    	Queue<Character> newQueue = new LinkedList<Character>();
    	stackOriginal.forEach(ch -> newQueue.add(ch));
    	return newQueue;
    }

    /*
     * Returns a stack with items reversed from the original stack
     */
    public static Stack<Character> reverseStack(Stack<Character> stackOriginal) {	
    	if(stackOriginal.isEmpty()) {
    		return stackOriginal;
    	}
    	
    	Stack <Character> tempStack = new Stack<Character>();
    	Collections.reverse(stackOriginal);
    	stackOriginal.forEach(charStack -> tempStack.push(charStack));
    	return tempStack;
    }
    /*
     * Returns the sum of integers between the start and end positions
     */
    public static int sumBetween(Stack<Integer> stack, int startPosition, int endPosition) {

    	if(stack.isEmpty()) {
    		int x = 0;
    		return x;
    	}
    	else if(startPosition < 0 && endPosition > stack.size()) {
    		return -1;
    	}
    	else {
        	int start = startPosition;
        	int end = endPosition;
        	
    		return IntStream.range(stack.get(startPosition),stack.get(endPosition)).sum();
    	}
    }

    /*
     * Reads from an input file and returns the characters that are integers from the file.
     * The function will read the lines from the file, extract the characters, filter non-numeric characters (i.e. not 0,1,...9),
     * and place these character numbers on a stack
     */
    public static Stack<Character> readNumericFromFile(final String filePath) throws IOException {
    	
    	Stack<Character> numeric = new Stack<Character>();
    	
    	BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
  	
		br.lines()
    	  .forEach(i -> i.chars()
    			  .mapToObj(j -> (char) j)
    			  .filter(d -> d.toString()
    					  .matches("^[\\d]"))
    			  		  .forEach(c -> numeric.push(c)));
        return numeric;
    }
}
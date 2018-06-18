package languageidentifier;

import java.io.*;
import java.util.*; // Program prompts for the input file name

/**
 * This program uses stacks to evaluate if a given string is in a Language L
 * LanguageIdentifierDriver is the driver class that executes the entire code
 * 
 * @version 3.0 2017-06-28
 * @author Addison Sears-Collins
 */
public class LanguageIdentifierDriver {
	
	/**
     *  Main entry point for the program.
     */
	public static void main(String[] args) {
		
		BufferedReader input = null;
		BufferedWriter output = null;
		String inputFileName = null;
		String outputFileName = null;
		String sCurrentLine = null;
		String results = null;
		int numOfStrings = 0;
		int L2EmptyStrings = 0;
		int L3EmptyStrings = 0;
		int L4EmptyStrings = 0;
		int L1Total, L2Total, L3Total, L4Total, L5Total;
		int L6Total, L7Total, L8Total, L9Total, L10Total;
		long startTime, endTime, duration;
		
		//  Prompt for the file input and output name
		Scanner in = new Scanner(System.in);
		
		System.out.println("This program evaluates if a word is valid " + 
			"in various languages.");
		System.out.println("");
		System.out.println("Please enter your file input " +
			"name to begin (e.g. input.txt" +
			" or C:\\Users\\Desktop\\input.txt):");
		inputFileName = in.nextLine();
		System.out.println("Now enter your file output " +
			"name (e.g. output.txt or" +
			" C:\\Users\\Desktop\\output.txt):");
		outputFileName = in.nextLine();		
		
		in.close();
	
		
		//  Open the files that will be used for input and output
        try {
            input = new BufferedReader(new FileReader(inputFileName));
            output = new BufferedWriter(new FileWriter(outputFileName));
        } catch (Exception ioe) {
        	System.out.println("");
        	System.out.println("Oops! The file cannot be found. Please " +
        			"try again.");
            System.err.println(ioe.toString());
            return;            
        }        

        //  Read, evaluate each string, write the results to the output file
        try {        	
        	
        	startTime = System.nanoTime();
        	
        	while ((sCurrentLine = input.readLine()) != null) {        		
        		
        		++numOfStrings;
        		
        		/* We must account for the empty string.  In this case, that 
        		 * would mean a string with 0 occurrences of the 
        		 * character A and 0 occurrences of the character B. This is
        		 * is the empty string. 
        		 * 
        		 * Empty string is valid when n = 0 in languages L2 and L3. 
        		 * Empty string is also valid in language L4 when
        		 * m, n, and p are equal to 0.
        		 * 
        		 * Note that we cannot have any other characters other than 
        		 * A and B.
        		 */
        		if(sCurrentLine.trim().isEmpty()) {
        			output.write("Empty string is valid in L2  L3  L4");
        			L2EmptyStrings++;
        			L3EmptyStrings++;
        			L4EmptyStrings++;
        			output.newLine();
        			continue;
        		}        		
      		
        		/* Separator for the required input and supplemental input */
        		if(sCurrentLine.trim() == "EndOfRequiredInput") {
        			output.write("End of Required Input");
           			output.newLine();
        			continue;
        		}
        		     		
        		/* Instantiate an object of the LanguageIdentifier class */
        		LanguageIdentifier word;
        		word = new LanguageIdentifier(sCurrentLine);
        		
        		/* Evaluate the object to see if it is in the languages*/
        		results = word.evaluate();
        		
        		/* Output the results to the file */        		
        		output.write(sCurrentLine.trim() + results);
        		
        		/* Move output to the next line*/
        		output.newLine();             	
        	} 
        	
        	// Calculate the execution time of the code
        	endTime = System.nanoTime();     	
        	duration = (endTime - startTime) / 1000000; // in milliseconds
        	
        	// Calculate the descriptive statistics
        	L1Total = LanguageIdentifier.getL1();
        	L2Total = L2EmptyStrings + LanguageIdentifier.getL2();
        	L3Total = L3EmptyStrings  + LanguageIdentifier.getL3();
			L4Total = L4EmptyStrings + LanguageIdentifier.getL4();
        	L5Total = LanguageIdentifier.getL5();
        	L6Total = LanguageIdentifier.getL6();
        	L7Total = LanguageIdentifier.getL7();
        	L8Total = LanguageIdentifier.getL8();
        	L9Total = LanguageIdentifier.getL9();
        	L10Total = LanguageIdentifier.getL10(); 
        	
        	// Print the frequency counts of each language
        	output.newLine();
        	output.write("----------------------------------------");
        	output.newLine();
        	output.write("DESCRIPTIVE STATISTICS ABOUT THE RESULTS");
        	output.newLine();
        	output.write("----------------------------------------");
        	output.newLine();
        	output.write("Number of Languages Tested: 10");
        	output.newLine();
        	output.write("Number of Strings Tested: " + numOfStrings);
        	output.newLine();
        	output.write("Number of Valid L1 Strings: " + L1Total);
        	output.newLine();
        	output.write("Number of Valid L2 Strings: " + L2Total);
        	output.newLine();
        	output.write("Number of Valid L3 Strings: " + L3Total);
        	output.newLine();
        	output.write("Number of Valid L4 Strings: " + L4Total);
        	output.newLine();
        	output.write("Number of Valid L5 Strings: " + L5Total);
        	output.newLine();
        	output.write("Number of Valid L6 Strings: " + L6Total);
        	output.newLine();
        	output.write("Number of Valid L7 Strings: " + L7Total);
        	output.newLine();
        	output.write("Number of Valid L8 Strings: " + L8Total);
        	output.newLine();
        	output.write("Number of Valid L9 Strings: " + L9Total);
        	output.newLine();
        	output.write("Number of Valid L10 Strings: " + L10Total);
        	output.newLine();
        	
        	// Print the execution time for the code
        	output.newLine();
        	output.write("----------------------------------------");
        	output.newLine();
        	output.write("OBSERVED EXECUTION TIME");
        	output.newLine();
        	output.write("----------------------------------------");
        	output.newLine();
        	output.write("Execution Time: " + duration + " milliseconds");
        	output.newLine();
        	output.write("Author: Addison Sears-Collins");
        	
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        //  Clean up and return to the operating system.
        try {
            input.close();
            output.close();
        } catch (Exception x) {
            System.err.println(x.toString());
        }
        return;			
	}
}


/**
 *  This class establishes the blueprint for the Stack object.
 *  Uses similar stack format to what is outlined in Data Structures 
 *  Using Java by Yedidyah Langsam et al. 
 */
class Stack {
	
	private final int STACKSIZE = 100;
	private int top;
	private char[] items;	
	
	/**
     *  Constructor for the stack
     */
	public Stack() {
		 items = new char[STACKSIZE];
		 top = -1;
	}
	
	/**
     *  Tests whether the stack is empty
     */
	public boolean empty() {
		if (top == -1)
			return true;
		else
			return false;
	}
	
	/**
     *  Pop implementation for the stack
     *  @return Returns and removes the top item from the stack
     */
	public char pop() {
		if (empty()) {
			System.out.println("Stack underflow");
			System.exit(1);
		}
		return items[top--];
	}
	
	/**
     *  Push implementation for the stack
     *  @param x The character to push on to the stack
     */
	public void push(char x) {
		if (top == STACKSIZE - 1) {
			// Cannot push onto a full stack
			System.out.println("Stack Overflow");
			System.exit(1);
		}
			items[++top] = x;
	}
	
	/**
     *  Peek implementation for the stack
     *  @return Returns the top element of the stack
     */
	public char peek() {
		if (empty()) {
			// Cannot pop from an empty stack
			System.out.println("Stack underflow");
			System.exit(1);
		}
		return items[top];
	}
	
	/**
     *  Size implementation for the stack
     *  @return Returns the number of items in the stack
     */
	public int size() {
		return (top + 1);
	}
	
}


/**
 *  This class establishes the blueprint for the LanguageIdentifier object
 */
class LanguageIdentifier {
	
	private char[] givenCharArray;
	Stack stack;
	Stack stackA;
	Stack stackB;
	Stack stackH;
	Stack stackJ;
	Stack stackU;
	Stack stackV;
	private static int L1 = 0;
	private static int L2 = 0;
	private static int L3 = 0;
	private static int L4 = 0;
	private static int L5 = 0;
	private static int L6 = 0;
	private static int L7 = 0;
	private static int L8 = 0;
	private static int L9 = 0;
	private static int L10 = 0;
	
	/**
     *  Constructor for the LanguageIdentifier
     *  @param x The current string that we are evaluating
     */
	public LanguageIdentifier(String x) {
		String str = x.trim();
		this.givenCharArray = str.toCharArray();
	}
	
	/**
     *  Check if language meets the rules of L1
     *  A string is in Language L1 if it contains equal numbers of As and 
     *  Bs (in any order) and no other characters
     *  @return Returns true if language is in L1
     */
	private boolean isL1() {
        stack = new Stack();
        
        for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* If the stack is empty or the stack top is equal to the
        	 * letter, push the letter to the stack. 
        	 */
        	if (stack.empty() || stack.peek() == letter) {
                stack.push(letter);
            } else {
                stack.pop();
            }        	
        }
        
        // An empty stack after the evaluation means the word is 
        // in the language.
        if (stack.empty()) {
            return true;
        }         
        else {
            return false;
        }
	}
	
	/**
     *  Check if language meets the rules of L2
     *  A string is in Language L2 if it is of the form (A^n)(B^n)
     *  for some n >= 0
     *  @return Returns true if language is in L2
     */	
	private boolean isL2() {
		stack = new Stack();
		boolean pushAs = true;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* Push As to the stack as long as you are still in
        	 * push mode. Once you hit the first B, pop the As 
        	 */
        	if (letter == 'A') {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			stack.push(letter);
        		}
        	}
        	else {
        		if (stack.empty()) {
        			return false;
        		}
        		if (stack.peek() == 'A') {
        			stack.pop();
        			pushAs = false;
        		}
        		
        	}
        	   	
        }
        
        // An empty stack after the evaluation means the word is 
        // in the language.
        if (stack.empty()) {
            return true;
        }         
        else {
            return false;
        }		
		
	}
	
	/**
     *  Check if language meets the rules of L3
     *  A string is in Language L3 if it is of the form (A^n)(B^(2n))
     *  for some n >= 0
     *  @return Returns true if language is in L3
     */
	private boolean isL3() {
		stackA = new Stack();
		stackB = new Stack();
		boolean pushAs = true;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* Push As to the stack as long as you are still in 
        	 * push mode. Once you hit the first B, prepare to pop As
        	 * You need two Bs in order to pop one A.  
        	 */
        	if (letter == 'A') {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			stackA.push(letter);
        		}
        	}
        	else {
        		
        		/* A must come before B */
        		if (stackA.empty()) {
        			return false;
        		}
        		
        		/* Once we hit the first B, we prepare to pop As. 
        		 * We need two Bs in order to pop one A, so we keep track 
        		 * of the Bs. Every time we hit two Bs in a row, we pop an A.
        		 */
        		if (stackA.peek() == 'A') {
        			if (stackB.size() == 0) {
        				pushAs = false;
        				stackB.push(letter);
        			}
        			else {
        				stackA.pop();
        				stackB.pop();
        			}
        		}       		    		
        		
        	}
		}		
		
		// If stacks A and B are empty after evaluation, return true
        if (stackA.empty() && stackB.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}
	
	/**
	 *  Check if language meets the rules of L4
	 *  A string is in Language L4 if it is of the form ((A^n)(B^m))^p
	 *  for some m, n, p >= 0. We have no restrictions on the value of
     *  m, n, or p. When n = 0, there are no occurrences of A.
     *  When m = 0, there are no occurrences of B.
     *  @return Returns true if language is in L4
     */
	private boolean isL4() {
		stackA = new Stack();
		stackB = new Stack();
		boolean repetition = false;
		boolean allAString = true;
		boolean allBString = true;
		boolean pushAs = false;
		boolean firstRep = false;
		int n = 0; // Number of As in one repetition
		int m = 0; // Number of Bs in one repetition
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	} 
        	
        	/* Test if we have an all A or all B string. */
        	if (letter == 'A') {
        		allBString = false;
        	}
        	else {
        		allAString = false;
        	}

        	
        	/* Test for a repeating string (e.g. AABAABAAB and
        	 * AABBBBAABBBB). Repeating string cannot begin with
        	 * B.
        	 */
        	if (repetition) {
        		
        		// Push As on to the stack until you reach n.
        		// Once you reach n, get ready to push Bs.
        		if (letter == 'A') {
        			if (pushAs) {
        				stackA.push(letter);
        			}
        			else {
        				return false;
        			}
        			
        			// Ready to start pushing Bs.
        			if (stackA.size() == n) {
        				pushAs = false;
        			}
        		}        		
        		else {
        			
        			// Special treatment for the first repetition
        			// If we try to push a B on the first repetition
        			// before we have enough As, return false.
        			if (firstRep) {
        				if (stackA.size() != n) {
            				return false;
            			}
        				else {
        					pushAs = false;
            				stackB.push(letter);
            				firstRep = false; 
        				}       				
        			}
        			else {
        				if (!pushAs) {        			
        					stackB.push(letter);
        				}
        				else {
        					return false;
        				}
        			}
        		
        			
        			// Reset the stacks after we have another repetition.
        			if (stackB.size() == m) {
        				
        				while (!stackA.empty()) {
        					stackA.pop();
        				}
        				
        				while (!stackB.empty()) {
        					stackB.pop();
        				}
        				pushAs = true;
        			}
        			
        		}

        	}      	
        	      	
        	/* Test for a valid non-repeating string (e.g. AAAB and ABB.) */
        	
        	if (!repetition) {
        		if (letter == 'B') {
        			stackB.push(letter);
        		}
        		else  {
        			// If both stacks are empty, push the A
        			if (stackA.empty() && stackB.empty()) {
        				stackA.push(letter);
        			}        		
        			// As cannot come after Bs in a non-repeating string
        			else if (stackA.empty() && !stackB.empty()) {
        				return false;
        			}
        			else if (!stackA.empty() && stackB.empty()) {
        				stackA.push(letter); 
        			}
        			// If both stackA and stackB have size >= 1 and the input
        			// is an A, we know we have begun a potential repeating
        			// string. Record the number of As and Bs in one
        			// repetition. Then remove all elements from both stacks.
        			else {
        				repetition = true;
        				n = stackA.size();
        				m = stackB.size();
        				
        				while (!stackA.empty()) {
        					stackA.pop();
        				}
        				
        				while (!stackB.empty()) {
        					stackB.pop();
        				}
        				
        				stackA.push(letter);
        				pushAs = true;
        				firstRep = true; // Prepare to begin 1st repetition
        			}        				
        		}
        	}    			
		}
		
		/* Return true if the string is only As. This occurs when m = 0 and
		 * p = 1. Examples include AAA and AAAA.
		 */
		if(allAString) {
			return true;
		}
		
		/* Return true if the string is only Bs. This occurs when n = 0 and 
		 * p = 1. Examples include BBB and BBBB.
		 */
		if(allBString) {
			return true;
		}

		/* Return true if the string is repeating and both stacks are empty
		 */
		if(repetition) {
			if (stackA.empty() && stackB.empty()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		/* If the string survives to this point, we return true. It has met
		 * all the conditions for being valid in L4.
		 */
		return true;
	}
	
	/**
     *  Check if language meets the rules of L5
     *  A string is in Language L5 if it is of the form (A^n)(B^(5n))
     *  for some n > 0
     *  @return Returns true if language is in L5
     */
	private boolean isL5() {
		stackA = new Stack();
		stackB = new Stack();
		boolean pushAs = true;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* Push As to the stack as long as you are still in 
        	 * push mode. Once you hit the first B, prepare to pop  
        	 */
        	if (letter == 'A') {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			stackA.push(letter);
        		}
        	}
        	else {
        		if (stackA.empty()) {
        			return false;
        		}
        		
        		/* Once we hit the first B, we get ready to pop As. 
        		 * We need five Bs in order to pop one A. Every time 
        		 * we hit five Bs in a row, pop an A and pop 4 Bs.
        		 */
        		if (stackA.peek() == 'A') {
        			if (stackB.size() < 4) {
        				pushAs = false;
        				stackB.push(letter);
        			}
        			else {
        				stackA.pop();
        				for (int i = 0; i < 4; i++) {
        					stackB.pop();
        				}
        			}        				
        		}        		
        	}
        }		
		
		// If stacks A and B are empty after evaluation, return true
        if (stackA.empty() && stackB.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}	
	
	/**
     *  Check if language meets the rules of L6
     *  A string is in Language L6 if it is of the form (A^(3n))(B^n)
     *  for some n > 0
     *  @return Returns true if language is in L6
     */
	private boolean isL6() {
		stack = new Stack();
		boolean pushAs = true;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* Push As to the stack as long as you are still in 
        	 * push mode. Once you hit the first B, start popping.
        	 * You need one B in order to pop three As.  
        	 */
        	if (letter == 'A') {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			stack.push(letter);
        		}
        	}
        	else {
        		
        		/* Need at least 3 As before pushing Bs */
        		if (stack.size() < 3) {
        			return false;
        		}        		
      		
        		/* Once we hit the first B, we start popping As. 
        		 * We need one B in order to pop three As.
        		 */
        		if (stack.size() % 3 == 0) {
        				pushAs = false;
        				stack.pop();
        				stack.pop();
        				stack.pop();
        		}
        		else {
        			return false;
        		}
        	}       		    		
        		
        }
		
		// If the stack is empty after the evaluation, return true
        if (stack.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}
	
	/**
     *  Check if language meets the rules of L7
     *  A string is in Language L7 if it is of the form (AB)^p
     *  for some p > 0. Valid strings include AB, ABABAB, etc.
     *  @return Returns true if language is in L7
     */
	private boolean isL7() {
		stack = new Stack();
		boolean pushAs = true;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* Push As to the stack as long as you are still in 
        	 * push mode. Once you hit the first B, start popping.
        	 * You need one B in order to pop three As.  
        	 */
        	if (letter == 'A') {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			stack.push(letter);
        			pushAs = false;
        		}
        	}
        	else {
        		
        		if (pushAs) {
        			return false;
        		}
        		
        		/* Stack size can only be 1 when we pop with a B */
        		if (stack.size() != 1) {
        			return false;
        		}
        		/* One B pops one A. */
        		else {
        			stack.pop();
        			pushAs = true; 			
      		    }

        	}       		    		
        		
        }
		
		// If the stack is empty after the evaluation, return true
        if (stack.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}
	
	/**
     *  Check if language meets the rules of L8
     *  A string is in Language L8 if it is of the form (JAVA)^p
     *  for some p > 0. Valid strings include JAVA, JAVAJAVA, etc.
     *  Every word is made up of one or more substrings of the word JAVA.
     *  @return Returns true if language is in L8
     */
	private boolean isL8() {
		stackJ = new Stack();
		stackA = new Stack();
		stackV = new Stack();
		boolean pushJs = true;
		boolean pushAs = false;
		boolean pushVs = false;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither J nor A nor V, return false */
        	if (!(letter == 'J' || letter == 'A'|| letter == 'V')) {
        		return false;
        	}
        	
        	/* Need one J, one A, one V, and another A (in that order)
        	 * to reset the stacks to empty.  
        	 */
        	if (letter == 'J') {
        		if (!pushJs) {
        			return false;
        		}
        		else {
        			stackJ.push(letter);
        			pushJs = false;
        			pushAs = true;
        		}
        	}
        	else if (letter == 'V') {        		
        		if (!pushVs) {
        			return false;
        		}        		
        		else {
        			stackV.push(letter);
        			pushVs = false;
        			pushAs = true;
        		}

        	}  
        	else {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			if (stackA.empty()) {
        				stackA.push(letter);
        				pushAs = false;
        				pushVs = true;        				
        			}
        			if (stackA.size() == 1) {
        				
        				while (!stackJ.empty()) {
        					stackJ.pop();
        				}
        				
        				while (!stackA.empty()) {
        					stackA.pop();
        				}
        				
        				while (!stackV.empty()) {
        					stackV.pop();
        				}        				
        				
        				pushAs = false;
        				pushJs = true;
        			}
        		}
        	}
        		
        }
		
		// If all stacks are empty after the evaluation, return true
        if (stackJ.empty() && stackA.empty() && stackV.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}	
	
	/**
     *  Check if language meets the rules of L9
     *  A string is in Language L9 if it is of the form (JHU)^p
     *  for some p > 0. Valid strings include JHU, JHUJHU, etc.
     *  Every word is made up of one or more substrings of the word JHU.
     *  @return Returns true if language is in L9
     */
	private boolean isL9() {
		stackJ = new Stack();
		stackH = new Stack();
		boolean pushJs = true;
		boolean pushHs = false;
		boolean pushUs = false;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither J nor H nor U, return false */
        	if (!(letter == 'J' || letter == 'H'|| letter == 'U')) {
        		return false;
        	}
        	
        	/* Need one J, one H, and one U (in that order)
        	 * to reset the stacks to empty.  
        	 */
        	if (letter == 'J') {
        		if (!pushJs) {
        			return false;
        		}
        		else {
        			stackJ.push(letter);
        			pushJs = false;
        			pushHs = true;
        		}
        	}
        	else if (letter == 'H') {        		
        		if (!pushHs) {
        			return false;
        		}        		
        		else {
        			stackH.push(letter);
        			pushHs = false;
        			pushUs = true;
        		}

        	}  
        	else {
        		if (!pushUs) {
        			return false;
        		}
        		else {
        			if (stackJ.size() == 1 && stackH.size() == 1) {
        				while (!stackJ.empty()) {
        					stackJ.pop();
        				}
        				
        				while (!stackH.empty()) {
        					stackH.pop();
        				}
        				
        				pushUs = false;
        				pushJs = true;        				
        			}
        			else {
        				return false;
        			}
        		}
        	}        		
        }
		
		// If all stacks are empty after the evaluation, return true
        if (stackJ.empty() && stackH.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}	
	
	/**
     *  Check if language meets the rules of L10
     *  A string is in Language L10 if it is of the form (A^(10n))(B^n)
     *  for some n > 0
     *  @return Returns true if language is in L10
     */
	private boolean isL10() {
		stack = new Stack();
		boolean pushAs = true;
		
		for (char letter : givenCharArray) {
        	
        	/* If the letter is neither A nor B, return false */
        	if (!(letter == 'A' || letter == 'B')) {
        		return false;
        	}
        	
        	/* Push As to the stack as long as you are still in 
        	 * push mode. Once you hit the first B, start popping.
        	 * You need one B in order to pop ten As.  
        	 */
        	if (letter == 'A') {
        		if (!pushAs) {
        			return false;
        		}
        		else {
        			stack.push(letter);
        		}
        	}
        	else {
        		
        		/* Need at least 10 As before pushing Bs */
        		if (stack.size() < 10) {
        			return false;
        		}        		
      		
        		/* Once we hit the first B, we start popping As. 
        		 * We need one B in order to pop ten As. 
        		 */
        		if (stack.size() % 10 == 0) {
        				pushAs = false;
        				for (int i = 0; i < 10; i++) {
        					stack.pop();
        				}
        		}
        		else {
        			return false;
        		}
        	}       		    		
        		
        }
		
		// If the stack is empty after the evaluation, return true
        if (stack.empty()) {
            return true;
        } 
        else {
            return false;
        }		
	}	
	
	/**
     * Check to see if the current string is valid in each language
     * Counts the number of instances of each language.
     * @return sb Returns the results of the evaluation
     */	
	public String evaluate() {
		StringBuilder sb = new StringBuilder(" is a valid word in ");
		int counter = 0;
		
		if (isL1()) {
			sb.append("L1  ");
			counter++;
			L1++;
        }

		if (isL2()) {
			sb.append("L2  ");
			counter++;
			L2++;
        }

		if (isL3()) {
			sb.append("L3  ");
			counter++;
			L3++;
        }

		if (isL4()) {
			sb.append("L4  ");
			counter++;
			L4++;
		}
		
		if (isL5()) {
			sb.append("L5  ");
			counter++;
			L5++;
		}
		
		if (isL6()) {
			sb.append("L6  ");
			counter++;
			L6++;
		}
		
		if (isL7()) {
			sb.append("L7  ");
			counter++;
			L7++;
		}
		
		if (isL8()) {
			sb.append("L8  ");
			counter++;
			L8++;
		}
		
		if (isL9()) {
			sb.append("L9  ");
			counter++;
			L9++;
		}
		
		if (isL10()) {
			sb.append("L10  ");
			counter++;
			L10++;
		}
		
		if (counter == 0) {
			sb.append("none of the languages.");
		}
        
        return sb.toString();		
	}
	
	/**
     * Gets the number of valid L1 strings
     * @return L1 Returns the number of valid L1 strings
     */	
	public static int getL1() {
		return L1;
	}
	
	/**
     * Gets the number of valid L2 strings
     * @return L2 Returns the number of valid L2 strings
     */	
	public static int getL2() {
		return L2;
	}
	
	/**
     * Gets the number of valid L3 strings
     * @return L3 Returns the number of valid L3 strings
     */	
	public static int getL3() {
		return L3;
	}
	
	/**
     * Gets the number of valid L4 strings
     * @return L4 Returns the number of valid L4 strings
     */	
	public static int getL4() {
		return L4;
	}
	
	/**
     * Gets the number of valid L5 strings
     * @return L5 Returns the number of valid L5 strings
     */	
	public static int getL5() {
		return L5;
	}
	
	/**
     * Gets the number of valid L6 strings
     * @return L6 Returns the number of valid L6 strings
     */	
	public static int getL6() {
		return L6;
	}
	
	/**
     * Gets the number of valid L7 strings
     * @return L7 Returns the number of valid L7 strings
     */	
	public static int getL7() {
		return L7;
	}
	
	/**
     * Gets the number of valid L8 strings
     * @return L8 Returns the number of valid L8 strings
     */	
	public static int getL8() {
		return L8;
	}
	
	/**
     * Gets the number of valid L9 strings
     * @return L9 Returns the number of valid L9 strings
     */	
	public static int getL9() {
		return L9;
	}
	
	/**
     * Gets the number of valid L1 strings
     * @return L10 Returns the number of valid L10 strings
     */	
	public static int getL10() {
		return L10;
	}
	
}
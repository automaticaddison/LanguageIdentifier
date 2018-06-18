Author: Addison Sears-Collins

Used Java Eclipse IDE (Java 8: JavaSE 1.8)

LanguageIdentifierDriver.java contains the main method and is the driver class for the application.

If running program from the command line on Windows 7, navigate to where the compiled classes are 
located (usually the bin directory) in the file and use the command
     java -cp . languageidentifier.LanguageIdentifierDriver 
in order to run the program. Alternatively, you can delete the package statement on the first line
of the program and run using the command 'javac LanguageIdentifierDriver.java' + 'java LanguageIdentifierDriver' 
in the command prompt

The program will prompt for the file input name (e.g. input.txt or C:\Users\Addison\Desktop\input.txt) 
and file output name (e.g. output.txt or C:\Users\Addison\Desktop\output.txt).

The input file needs to exist in order for the program to run. The output file does not have to exist.

The main input file that contains the required and supplemental input is named 'input.txt'.

The files with '[number].txt' are files that were used to test the time performance of the algorithm.


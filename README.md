# translator

#Overview
This Java application translates text from Spanish to English using a dictionary file. It reads two input files: a dictionary of word pairs and a text file to translate. Each Spanish word in the text file is replaced with its English equivalent if found.

#File Structure
translator.java — Main class:

- Reads two file names from command-line arguments.
- Loads Spanish-English word pairs into a map.
- Translates each line of the input file and prints the result.

#Prerequisites
-Java Development Kit (JDK) 8 or higher
-Terminal or command prompt

#Input File Format
Dictionary File (First Argument)
-First line: an integer indicating the number of word pairs.
-Next lines: each contains a Spanish word followed by its English translation.

Example:

3
hola hello
mundo world
gracias thanks

#Text File to Translate (Second Argument)
- Each line contains a sentence using Spanish words.

Example:

hola mundo
gracias mundo

#Compilation

javac translator.java

#Running the Application

java translator dictionary.txt input.txt
Expected Output:

hello world
thanks world

#Error Handling
-If arguments are missing or incorrect:
Invalid inputs.
-If a file cannot be opened:
Invalid file

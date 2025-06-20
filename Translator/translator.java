import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;


class translator{
	
	public static void main(String[] args){
		if(args.length == 0 || args.length != 2) {
			System.out.print("Invalid inputs.");
			return;
		}
		Map<String, String> words = putInMap(args[0]);
		translate(words, args[1]);
	}
	/*Takes in the file name that the user tries to translate, 
	if the file is invalid it prints that it is invalid
	Loops through all the lines of the file and puts 
	the two words on each line in to "words" a hashmap */
	/*pre: fileName represents an existing file with an integer on the first line 
	that represents the number of proceeding lines with relevant information*/
	/*post: returns a hashmap filled with spanish words (key set) and english words
	(values) that correspond with each other*/
	public static Map<String, String> putInMap(String fileName){
		Map<String, String> words = new HashMap<>();
		try {
			Scanner fileScanner = new Scanner(new FileReader(fileName));
			int lines = Integer.parseInt(fileScanner.nextLine());
			for(int i = 0; i < lines; i++) {
				//split method found here: https://www.w3schools.com/java/ref_string_split.asp
				String [] word = fileScanner.nextLine().split(" ");
				words.put(word[0], word[1]);
			}
			fileScanner.close();
		} catch(Exception e) {
				System.out.print("Invalid file");
		}
		return words;
	}

	/*takes in the name of the file to translate and the Map filled with keys values
	to translate the file to print all translated lines into the command line*/
	/*pre: words is a Map filled with spanish words (key set) and english words 
	(values) that correspond to each other and fileName represents an existing file*/
	/*post: for each line in the file, prints an array of translated words 
	that represents the sentence on that line*/
	public static void translate(Map<String, String> words, String fileName) {
		try {
			Scanner fileScanner = new Scanner(new FileReader(fileName));
			while(fileScanner.hasNextLine()) {
				String[] sentence = fileScanner.nextLine().split(" ");
				for(int i = 0; i < sentence.length; i++) {
					for(String j: words.keySet()) {
						if(sentence[i].equals(j)) {
							sentence[i] = words.get(j);
						}
					}
				}
				for(String i: sentence) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		} catch(Exception e) {
			System.out.println("Invalid File");
		}
	}
}




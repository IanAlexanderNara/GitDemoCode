import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * 
 * @author Ian Nara
 * @author Andrew Taylor
 *
 */
public class ScoreTrakker {
	//stores students
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

	//constructor
	public ScoreTrakker() {
		super();
		students = new ArrayList<Student>();
	}

	//takes a filename and loads data, storing as student objects
	private void loadDataFromFile(String filename) throws FileNotFoundException{
		FileReader reader = new FileReader(filename); //Open file for reading
		Scanner in = new Scanner(reader); //Open scanner
		while(in.hasNextLine()) { //While next line exists
			String name = in.nextLine(); //Store name
			String tempScore = in.nextLine(); //Store score as string
			try {			
				int score = Integer.parseInt(tempScore); //attempt to change score as a string to score as an int
				Student student = new Student(name,score); //save name and score as new
				students.add(student); //add student to the list

			}catch(NumberFormatException e) { //If attempt to change score to int fails, output exception
				System.out.println("Incorrect format for " + name + " not a valid score: " + tempScore);
				System.out.println("");
			}
		}
		in.close();
	}



	//sorts and prints in alphabetical order by name
	private void printInOrder() {
		System.out.println("Student Score List");
		Collections.sort(students);
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	//reads each file and then prints the students
	public void processFiles() {
		for(String filename : files) {
			//empty arraylist before each file
			students.clear();
			try {
				loadDataFromFile(filename); // If file exists, continue to printing
				printInOrder();
			} catch(FileNotFoundException e) { //If file not found, display error message
				System.out.println("Can't open file: " + filename);
				System.out.println("");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}

}

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
	
	//constructor
	public ScoreTrakker() {
		super();
		students = new ArrayList<Student>();
	}
	
	//takes a filename and loads data, storing as student objects
	private void loadDataFromFile(String filename){
		try {
			FileReader reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			while(in.hasNextLine()) {
				String name = in.nextLine();
				int score = Integer.valueOf(in.nextLine());
				Student student = new Student(name,score);
				students.add(student);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//sorts and prints in alphabetical order by name
	private void printInOrder() {
		System.out.println("Student Score List");
		Collections.sort(students);
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		//get filename from user
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file name");
		String filename = in.nextLine();
		//load data and print
		loadDataFromFile(filename);
		printInOrder();
	}
	
	public static void main(String[] args) {
		ScoreTrakker tracker = new ScoreTrakker();
		tracker.processFiles();
	}

}

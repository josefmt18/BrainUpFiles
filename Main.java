
public class Main {
	public static void main(String[] args) {
		Professor prof = new Professor("Dr. Jones");
		prof.createCourse("Systems", "CS1234");
		prof.updateSyllabus("Systems", 10,  20 , 30, 30, 10);
		
		Student billy = new Student("billy", "lol123");
		
		billy.enroll(prof.getCourse("Systems"));
		
		prof.createAssignment("Systems", 'E', "Exam 1", 100);
		
		prof.createAssignment("Systems", 'Q', "Quiz 1", 100);
		prof.createAssignment("Systems", 'Q', "Quiz 2", 100);
		prof.createAssignment("Systems", 'L', "Lab 1", 100);
		
		
		prof.gradeAssignment("Systems", "Exam 1", "lol123", 55);
		
		prof.gradeAssignment("Systems", "Quiz 1", "billy", 22);
		prof.gradeAssignment("Systems", "Quiz 2", "billy", 87);
		prof.gradeAssignment("Systems", "Lab 1", "billy", 4);
		
		System.out.println(prof.coursesToString());
	}

}

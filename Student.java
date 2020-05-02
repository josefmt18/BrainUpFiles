import java.util.*;
public class Student extends User{
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private double GPA;
	private String studentName;
	
	//constructors
	Student() {
	}
	
	Student(String name, String username){
		this.studentName = name;
		this.setUsername(username);
	}
	
	//setters and getters
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**************************************************/
	
	//returns arraylist of assignments for this class
	public ArrayList<Assignment> getMyGradesForClass(String courseName){
		return getCourse(courseName).getStudentAssignments(this.studentName);
	}
	
	//returns arraylist of all assignments in all classes
	public ArrayList<Assignment> getMyGrades(){
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		for(int i = 0; i < this.courseList.size(); i++){
			ArrayList<Assignment> currAssignments = getMyGradesForClass(this.courseList.get(i).getCourseName());
			for(int j = 1; j < currAssignments.size(); j++){
				assignments.add(currAssignments.get(i));
			}
		}
		return assignments;
	}
	
	//returns string of every course and its assignments
	public String coursesToString(){
		String ret = "";
		
		for(int i =  0; i < this.courseList.size(); i++){
			ret = ret + this.courseList.get(i).getCourseName() + 
					"\n*****************************\n" + 
					this.courseList.get(i).studentAssignmentsToString(this.studentName);			
		}
		
		return ret;
	}
	
	//returns specific course
	public Course getCourse(String courseName){
		for(int i = 0; i < this.courseList.size(); i++){
			if(this.courseList.get(i).getCourseName().equals(courseName)){
				return this.courseList.get(i);
			}
		}
		return null;
	}
	
	//enrolls student in course
	public void enroll(Course newCourse){
		newCourse.enrollStudent(this.getUsername());
		this.courseList.add(newCourse);
	}
	
	//goes through every course and calculates GPA
	public void updateGPA(){
		double sum = 0;
		for(int i = 0; i < this.courseList.size(); i++){
			sum += this.courseList.get(i).getStudentGrade(this.studentName);
		}
		
		this.GPA = sum / this.courseList.size();
	}
}

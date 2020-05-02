import java.util.*;
public class Professor extends User{
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private String profName;
	
	//constructors
	Professor() {
	}
	
	Professor(String profName){
		this.profName = profName;
	}

	//setters and getters
	public ArrayList<Course> getCourses() {
		return courseList;
	}

	public void setCourses(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}
	/*****************************************************/
	
	public Course getCourse(String courseName){
		for(int i = 0; i < this.courseList.size(); i++){
			if(this.courseList.get(i).getCourseName().equals(courseName)){
				return this.courseList.get(i);
			}
		}
		return null;
	}
	
	//returns arraylist of all assignments in class
	public ArrayList<ArrayList<Assignment>> getAllAssignmentsForCourse(String courseName){
		
		return getCourse(courseName).getAssignmentList();
	}
	
	//returns arraylist of all assignments of all courses
	public ArrayList<Assignment> getAssignment(String assignmentName, String courseName){
		ArrayList<ArrayList<Assignment>> allAssignments = getAllAssignmentsForCourse(courseName);
		for(int i = 0; i < allAssignments.size(); i++){
			if(allAssignments.get(i).get(0).getAssignmentName().equals(assignmentName)){
				return allAssignments.get(i);
			}
		}
		return null;
	}
	
	//returns string info of all courses
	public String coursesToString(){
		String ret = "";
		for(int i = 0; i < this.courseList.size(); i++){
			ret = ret + this.courseList.get(i).toString();
		}
		return ret;
	}
	
	//returns string of a student's grades in a specific course
	public String studentToString(String courseName, String studentName){
		return getCourse(courseName).studentAssignmentsToString(studentName);
	}
	
	//creates new course
	public void createCourse(String courseName, String courseNum){
		this.courseList.add(new Course(courseName, courseNum, this));
	}
	
	//updates syllabus or class
	public void updateSyllabus(String courseName, double examW, double quizW, double HWW, double labW, double otherW){
		getCourse(courseName).setClassSyllabus(new Syllabus(examW, quizW, HWW, labW, otherW));
	}
	
	//grades one assignment in class
	public void gradeAssignment(String courseName, String assignmentName, String studentName, int grade){
		getCourse(courseName).gradeAssignment(studentName, assignmentName, grade);
	}
	
	//creates new assignment in course
	public void createAssignment(String courseName, char type, String assignmentName, int maxGrade){
		getCourse(courseName).createNewAssignment(assignmentName, type, maxGrade);
	}
}

import java.util.*;
public class Course {
	private String courseName;
	private String courseNum;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<ArrayList<Assignment>> assignmentList = new ArrayList<ArrayList<Assignment>>();
	private Professor prof;
	private Syllabus classSyllabus;
	
	//constructors
	Course(){
	}
	
	Course(String courseName, String courseNum, Professor prof){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.prof = prof;
		this.classSyllabus = new Syllabus(0,0,0,0,0);
	}

	//getters and setters
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<ArrayList<Assignment>> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(ArrayList<ArrayList<Assignment>> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	public Syllabus getClassSyllabus() {
		return classSyllabus;
	}

	public void setClassSyllabus(Syllabus classSyllabus) {
		this.classSyllabus = classSyllabus;
	}
	/*************************************************************************************/
	
	//adds new student to student list
	public void enrollStudent(String studentName){
		for(int i = 0; i < this.studentList.size(); i++){
			if(this.studentList.get(i).getUsername().equals(studentName)){
				System.out.println(studentName + " is already enrolled in " + this.courseName);
				return;
			}
		}
		this.studentList.add(new Student("", studentName));
		//System.out.println("student enrolled: " + studentName);
	}
	
	//removes student from student list
	public void dropStudent(String studentName){
		for(int i = 0; i < this.studentList.size(); i++){
			if(this.studentList.get(i).getUsername().equals(studentName)){
				this.studentList.remove(this.studentList.get(i));
				return;
			}
		}
		System.out.println(studentName + " is not in " + this.courseName);
	}
	
	//returns all assignments belonging to a specific student
	public ArrayList<Assignment> getStudentAssignments(String studentName){
		ArrayList<Assignment> studentGrades = new ArrayList<Assignment>();
				
		for(int i = 0; i < this.assignmentList.size(); i++){
			
			for(int j = 0; j < this.assignmentList.get(i).size(); j++){
				
				if(this.assignmentList.get(i).get(j).getStudentName().equals(studentName)){
					studentGrades.add(this.assignmentList.get(i).get(j));
				}
			}
			
		}
		
		return studentGrades;
	}
	
	//gets all assignments for specific assignment
	public ArrayList<Assignment> getAssignment(String assignmentName){
		for(int i = 0; i < this.assignmentList.size(); i++){
			if(this.assignmentList.get(i).get(0).getAssignmentName().equals(assignmentName)){
				return this.assignmentList.get(i);
			}
		}
		return null;
	}
	
	//updates the received grade for a specific student on a specific assignment
	public void gradeAssignment(String studentName, String assignmentName, int grade){
		ArrayList<Assignment> assignments = getAssignment(assignmentName);
		Assignment newAssignment = new Assignment(studentName, assignmentName, assignments.get(0).getAssignmentType(), assignments.get(0).getMaxGrade());
		newAssignment.setReceivedGrade(grade);
		assignments.add(newAssignment);
	}
	
	//changes grade for specific student
	public void changeAssignmentGrade(String studentName, String assignmentName, int grade){
		ArrayList<Assignment> assignments = getAssignment(assignmentName);
		for(int i = 0; i < assignments.size(); i++){
			if(assignments.get(0).getStudentName().equals(studentName)){
				assignments.get(0).setReceivedGrade(grade);
			}
		}
	}
	
	//adds new assignment node to asignment list
	public void createNewAssignment(String assignmentName, char assignmentType, int maxGrade){
		ArrayList<Assignment> newAssignment = new ArrayList<Assignment>();
		newAssignment.add(new Assignment("", assignmentName, assignmentType, maxGrade));
		
		this.assignmentList.add(newAssignment);
	}
	
	//returns the grade of a student for all assignments
	public double getClassAvg(){
		double finalGrade = 0, exams = 0, quizzes = 0, HW = 0, labs = 0, other = 0;
		int numExams = 0, numQuizzes = 0, numHW = 0, numLabs = 0, numOther = 0;
		
		for(int i = 0; i < this.assignmentList.size(); i++){
			ArrayList<Assignment>  currAssignment = this.assignmentList.get(i);
			
			switch(this.assignmentList.get(i).get(0).getAssignmentType()){
			case 'F':
				finalGrade += getAssignmentAvg(currAssignment.get(0).getAssignmentName()) / currAssignment.get(0).getMaxGrade();
				break;
			case 'E':
				exams += getAssignmentAvg(currAssignment.get(0).getAssignmentName()) / currAssignment.get(0).getMaxGrade();
				numExams++;
				break;
			case 'Q':
				quizzes += getAssignmentAvg(currAssignment.get(0).getAssignmentName()) / currAssignment.get(0).getMaxGrade();
				numQuizzes++;
				break;
			case 'L':
				HW += getAssignmentAvg(currAssignment.get(0).getAssignmentName()) / currAssignment.get(0).getMaxGrade();
				numHW++;
				break;
			case 'H':
				labs += getAssignmentAvg(currAssignment.get(0).getAssignmentName()) / currAssignment.get(0).getMaxGrade();
				numLabs++;
				break;
			case 'O':
				other += getAssignmentAvg(currAssignment.get(0).getAssignmentName()) / currAssignment.get(0).getMaxGrade();
				numOther++;
				break;
			}
		}
		
		
		if(numExams != 0){
			exams = (exams * classSyllabus.getExamWeight()) / numExams;
		}
		if(numQuizzes != 0){
			quizzes = (quizzes * classSyllabus.getQuizWeight()) / numQuizzes;
		}
		if(numHW != 0){
			HW = (HW * classSyllabus.getHWWeight()) / numHW;
		}
		if(numLabs != 0){
			labs = (labs * classSyllabus.getLabWeight()) / numLabs;
		}
		if(numOther != 0){
			other = (other * classSyllabus.getOtherWeight()) / numOther;
		}
		finalGrade = finalGrade * classSyllabus.getFinalWeight();
		
		double grade = exams + quizzes + HW + labs + other + finalGrade;
		
		return grade;
	}
	
	//geets average grade for single assignment
	public double getAssignmentAvg(String assignmentName){
		ArrayList<Assignment> assignment = getAssignment(assignmentName);
		double sum = 0;
		
		if(assignment.size() == 1){
			return 0;
		}
		
		for(int i = 1; i < assignment.size(); i++){
			sum = sum + assignment.get(i).getReceivedGrade();
		}
		return sum / (assignment.size() - 1);
	}
	
	//gets grade avg for every assignment and puts them together
	public double getStudentGrade(String studentName){
		double finalGrade = 0, exams = 0, quizzes = 0, HW = 0, labs = 0, other = 0;
		int numExams = 0, numQuizzes = 0, numHW = 0, numLabs = 0, numOther = 0;
		
		ArrayList<Assignment> currStudAssignments = getStudentAssignments(studentName);
		
		for(int i = 0; i < currStudAssignments.size(); i++){
			switch(currStudAssignments.get(i).getAssignmentType()){
			case 'F':
				finalGrade += currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade();
				break;
			case 'E':
				exams += currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade();
				numExams++;
				break;
			case 'Q':
				quizzes += currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade();
				numQuizzes++;
				break;
			case 'L':
				HW += currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade();
				numHW++;
				break;
			case 'H':
				labs += currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade();
				numLabs++;
				break;
			case 'O':
				other += currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade();
				numOther++;
				break;
			}
		}
		
		//System.out.println(exams + " " + quizzes + " " + HW + " " + labs + " " + other + " " + finalGrade);
		
		
		if(numExams != 0){
			exams = (exams * classSyllabus.getExamWeight()) / numExams;
		}
		if(numQuizzes != 0){
			quizzes = (quizzes * classSyllabus.getQuizWeight()) / numQuizzes;
		}
		if(numHW != 0){
			HW = (HW * classSyllabus.getHWWeight()) / numHW;
		}
		if(numLabs != 0){
			labs = (labs * classSyllabus.getLabWeight()) / numLabs;
		}
		if(numOther != 0){
			other = (other * classSyllabus.getOtherWeight()) / numOther;
		}
		finalGrade = finalGrade * classSyllabus.getFinalWeight();
		
		
		double grade = exams + quizzes + HW + labs + other + finalGrade;
		
		return grade;
	}
	
	//returns the to string for all of a student's assignments
	public String studentAssignmentsToString(String studentName){
		String ret = "";
		ArrayList<Assignment> assignments = getStudentAssignments(studentName);
		
		for(int i = 0; i < assignments.size(); i++){
			ret = assignments.get(i).toString() + "\n";
		}
		
		return ret;
	}
	
	//returns string of all items in one assignment
	public String assignmentToString(String assignmentName){
		String ret = "";
		ArrayList<Assignment> assignment = getAssignment(assignmentName);
		
		for(int i = 1; i < assignment.size(); i++){
			ret = ret + assignment.get(i).toString() + "\n";
		}
		
		return  ret;
	}
	
	//returns string of all assignments in this course
	public String allAssignmentsToString(){
		String ret = "";
		
		for(int i = 0; i < this.assignmentList.size(); i++){
			ret = ret + assignmentToString(this.assignmentList.get(i).get(0).getAssignmentName());
		}
		
		return ret;
	}
	
	//returns all information for this course and its assignments
	public String toString(){
		return this.courseNum + "-" + this.prof.getProfName() + "\n" + 
				this.courseName + "\n\n" + allAssignmentsToString() + "Class Avg:  " + getClassAvg() + "\n";			
	}
	
	//lists all students
	public String studentListToString(){
		String ret = "";
		for(int i = 0; i < this.studentList.size(); i++){
			ret = ret + this.studentList.get(i).getUsername() + "\n";
		}
		return ret;
	}
}

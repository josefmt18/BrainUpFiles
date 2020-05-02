
public class Assignment {
	private int receivedGrade;
	private int maxGrade;
	private String assignmentName;
	private char assignmentType;
	private String studentName;
	
	//constructors
	Assignment(){
	}
	
	Assignment(String studentName, String assignmentName, char assignmentType, int maxGrade){
		this.studentName = studentName;
		this.assignmentName = assignmentName;
		this.assignmentType = assignmentType;
		this.maxGrade = maxGrade;
	}

	//setters and getters
	public int getReceivedGrade() {
		return receivedGrade;
	}

	public void setReceivedGrade(int receivedGrade) {
		this.receivedGrade = receivedGrade;
	}

	public int getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(int maxGrade) {
		this.maxGrade = maxGrade;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public char getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(char assignmentType) {
		this.assignmentType = assignmentType;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	//toString
	public String toString(){
		return this.assignmentName + "(" + this.assignmentType + "):\n" + 
				this.studentName + "\n" +
				this.receivedGrade + "/" + this.maxGrade + "\n";
	}
}

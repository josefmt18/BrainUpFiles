
public class Syllabus {
	private double finalWeight;
	private double examWeight;
	private double quizWeight;
	private double HWWeight;
	private double labWeight;
	private double otherWeight;

	Syllabus() {
	}
	
	Syllabus(double examW, double quizW, double HWW, double labW, double otherW){
		this.examWeight = examW;
		this.quizWeight = quizW;
		this.HWWeight = HWW;
		this.labWeight = labW;
		this.otherWeight = otherW;
	}
	
	public double getFinalWeight() {
		return finalWeight;
	}

	public void setFinalWeight(double finalWeight) {
		this.finalWeight = finalWeight;
	}

	public double getExamWeight() {
		return examWeight;
	}

	public void setExamWeight(double examWeight) {
		this.examWeight = examWeight;
	}

	public double getQuizWeight() {
		return quizWeight;
	}

	public void setQuizWeight(double quizWeight) {
		this.quizWeight = quizWeight;
	}

	public double getHWWeight() {
		return HWWeight;
	}

	public void setHWWeight(double hWWeight) {
		HWWeight = hWWeight;
	}

	public double getLabWeight() {
		return labWeight;
	}

	public void setLabWeight(double labWeight) {
		this.labWeight = labWeight;
	}

	public double getOtherWeight() {
		return otherWeight;
	}

	public void setOtherWeight(double otherWeight) {
		this.otherWeight = otherWeight;
	}

	public double getWeight(char type){
		switch(type){
			case 'F':
				return this.finalWeight;	
			case 'E':
				return this.examWeight;
			case 'Q':
				return this.quizWeight;
			case 'H':
				return this.HWWeight;
			case 'L':
				return this.labWeight;
			case 'O':
				return this.otherWeight;
			default:
				return 0;
		}
	}

}

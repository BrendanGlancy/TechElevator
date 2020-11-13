package com.techelevator;

public class HomeworkAssignment {
	/*
	 * - `letterGrade` is a derived attribute that's calculated using 
	 * `earnedMarks` and `possibleMarks`:
     * For 90% or greater, it returns "A"
     * For 80-89%, it returns "B"
     * For 70-79%, it returns "C"
     * For 60-69%, it returns "D"
     * Otherwise, it returns "F"
     * _hint_: `possibleMarks` and `earnedMarks` are `int`s. 
     * What happens when a smaller integer is divided by a larger integer?
	*/
	
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	public HomeworkAssignment(int possibleMark, String submitterName) {
		this.possibleMarks = possibleMark;
		this.submitterName = submitterName;
	}

	public int getEarnedMarks() {
		return earnedMarks;
	}

	public void setEarnedMarks(int earnedMark) {
		this.earnedMarks = earnedMark;
	}

	public int getPossibleMarks() {
		return possibleMarks;
	}


	public String getSubmitterName() {
		return submitterName;
	}

	public String getLetterGrade() {
		
		double percent = getEarnedMarks()* 100 / getPossibleMarks();
		
		if (percent >= 90) {
			letterGrade = "A";
		} else if (percent >= 80) {
			letterGrade = "B";
		} else if (percent >= 70) {
			letterGrade = "C";
		} else if (percent >= 60) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
		return letterGrade;
	}

	
	
	
	
}

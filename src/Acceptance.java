import java.util.Scanner;

import java.io.*;

public class Acceptance {
	
	private static	int		NoOfFaculties;
	private static	Faculty	faculties[];
	public  static	List	studentsApplied;
	public  static	List	studentsRejected;
	private static  float   tawjihiRate;
	private static  float   schoolRate;
	private static  float   placementRate;
	
	Acceptance(){	
	}
	
	public static void setNoOfFaculties(int n){
		NoOfFaculties = n;
	}
	
	public static int getNoOfFaculties(){
		return NoOfFaculties;
	}
	
	public static Faculty getFaculties(int i){
		return faculties[i];
	}
	
	//----------| readStudents |--------------------------------------------
	public static void readStudents(File studentsFile){
		Scanner input     = null;
		String  str       = null;
		String  name      = null;
		float     tawjihi   = 0;
		float   school    = 0;
		float   placement = 0;
		try{
			input = new Scanner(studentsFile);
			studentsApplied = new List();
			Main.textArea.setText("");
			int i = 0;	// input line counter
			while(input.hasNextLine()){
				str = input.nextLine();
				System.out.println(str);
				Main.textArea.appendText(str+"\n");
				if (i >= 3){
					if(str.isEmpty())		// if the reading reaches an empty line, it will end reading.
						break;
					name      = str.substring(0, str.indexOf("  "));
					tawjihi   = Float.valueOf((str.substring(33,40).trim()));
					school    = Float.valueOf((str.substring(44,54).trim()));
					placement = Float.valueOf((str.substring(58).trim()));
					studentsApplied.addFirst(name, tawjihi, school, placement);
				}
			i++;
			}
			Main.textArea.appendText("\n"+"> Students' file has been read.\n"
    				+ "> Choose the file containing the faculties data");
		} catch(FileNotFoundException e){
			System.out.println("The file chosen cannot be read");
			Main.textArea.appendText("\n\n>> The file chosen cannot be read");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("Some error has occurred, please choose a proper file..");
			Main.textArea.appendText("\n\n>> Some ERROR has occurred, please choose a proper file..");
			e.getMessage();
		} finally {
			input.close();
		}
	}
	
	//----------| readCriteria |--------------------------------------------
	public static void readCriteria(File CriteriaFile){
		Scanner input = null;
		String str = null;
		int iDash = 0;
		try{
			input = new Scanner(CriteriaFile);
			System.out.println("The univeristy's admission rules:");
			Main.textArea.setText("");
			int i = 0;	// input line counter
			while(input.hasNextLine()){
				str = input.nextLine();
				Main.textArea.appendText(str+"\n");
				System.out.println(str);
				if(i == 4){
					tawjihiRate = Float.valueOf(str.substring(0,20).trim())/100;
					schoolRate = Float.valueOf(str.substring(25,43).trim())/100;
					placementRate = Float.valueOf(str.substring(45).trim())/100;
				}
				if(i == 9){
					// change this to remove the tab
					setNoOfFaculties(Integer.valueOf(str.substring(str.indexOf('\t')+1)));
					 faculties = new Faculty [NoOfFaculties];
				}
				if(i>13){
					if(i - 14 <= faculties.length -1){
						iDash = str.indexOf("-");
						faculties[i-14] = new Faculty(str.substring(0, str.indexOf("  ")), 
													Integer.valueOf(str.substring(iDash-2, iDash)), 
													Integer.valueOf(str.substring(iDash+1, iDash+3)));
					}
				}
				i++;
			}	// end of while
			Main.textArea.appendText("\n\n\n"+"> Faculties' file has been read.\n"
    				+ "> Now click on Acceptance");
		} catch(FileNotFoundException e){
			System.out.println("The file chosen cannot be read");
			Main.textArea.appendText("\n\n>> The file chosen cannot be read");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("Some error has occurred, please choose a proper file..");
			Main.textArea.appendText("\n\n>> Some ERROR has occurred, please choose a proper file..");
			e.getMessage();
		} 
		finally {
			input.close();
		}
	}
	
		
	//----------| acceptStudents |------------------------------------------
	public static void acceptStudents (){
		if (NoOfFaculties == 0 || studentsApplied.getSize()==0){
			System.out.println("Invalid input, check the number of faculties and/or number of students,"+ "\n"
								+ "read the file again then request the accept process.");
			Main.textArea.setText("\n\n\nInvalid input, check the number of faculties and/or number of students,"+ "\n"
								+ "read the file again then request the accept process.");
			return;
		}
		studentsRejected = new List();
		float currentFrom, currentTo;
		Student current;
		for (int i=0 ; i<studentsApplied.getSize() ; i++){
			current = studentsApplied.first;
			current.setMark(Math.round(current.getTawjihi()*tawjihiRate +
										current.getHighSchool()*schoolRate +
										current.getPlacement()*placementRate));
			for(int j=0 ; j<NoOfFaculties ; j++){
				currentFrom = (float)faculties[j].getForm();
				currentTo   = (float)faculties[j].getTo();
				if(current.getMark()>=currentFrom  &&  current.getMark()<=currentTo){
					moveStudentToFaculty(current,j);
					break;
				}
				// if counter of faculties reached the last count without accepting ==> reject:
				if(j == NoOfFaculties-1)
					studentNotAccepted(current);
			}
			current = current.next;
		}
		System.out.println("Accepting students complete\n\n\n");
		Main.textArea.setText("\n\n\n\n\n> Acceptance complete\n"
				+ "> Please print the accepted/rejected students data");
	}
	
	//----------| moveStudentToFaculty |------------------------------------
	private static void moveStudentToFaculty(Student current, int j){
		studentsApplied.first = current.next;
		current.next = null;
		faculties[j].students.addFirst(current);
	}
	
	//----------| studentNotAccepted |--------------------------------------
	private static void studentNotAccepted(Student current){
		studentsApplied.first = current.next;
		current.next = null;
		studentsRejected.addFirst(current);
	}
	
}


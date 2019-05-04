
public class Print {

	//----------| printAccepted |-------------------------------------------
	public static void printAccepted(){
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\n"
						+  "|      Student                 |  Tawjihi  |  School  | Placement | Final\n"
						+  "|       Name                   |   mark    |   mark   |  mark     | mark\n");
		Main.textArea.setText("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\n"
						+  "|      Student                 |  Tawjihi  |  School  | Placement | Final\n"
						+  "|       Name                   |   mark    |   mark   |  mark     | mark\n\n");
		for (int i=0 ; i<Acceptance.getNoOfFaculties() ; i++){
			System.out.println("|************************************************************************\n|  "+
					Acceptance.getFaculties(i).getName()+
							"\n|  "+Acceptance.getFaculties(i).students.getSize()+
							"  accepted"+
							"\n|------------------------------------------------------------------------");
			Main.textArea.appendText("|************************************************************************\n|  "+
					Acceptance.getFaculties(i).getName()+
					"\n|  "+Acceptance.getFaculties(i).students.getSize()+
							"  accepted"+
							"\n|------------------------------------------------------------------------\n");
			Acceptance.getFaculties(i).students.print();
		}
	}
	
	//----------| printRejected |-------------------------------------------
	public static void printRejected(){
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\n"
				+  "|      Student                 |  Tawjihi  |  School  | Placement | Final\n"
				+  "|       Name                   |   mark    |   mark   |  mark     | mark\n");
		Main.textArea.setText("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\n"
				+  "|      Student                 |  Tawjihi  |  School  | Placement | Final\n"
				+  "|       Name                   |   mark    |   mark   |  mark     | mark\n\n");
		System.out.println("|************************************************************************\n|  "+
				"Students rejected"+
				"\n|  "+Acceptance.studentsRejected.getSize()+
				"  rejected"+
				"\n|------------------------------------------------------------------------");
		Main.textArea.appendText("|************************************************************************\n|  "+
				"Students rejected"+
				"\n|  "+Acceptance.studentsRejected.getSize()+
				"  rejected"+
				"\n|------------------------------------------------------------------------\n");
		Acceptance.studentsRejected.print();
	}
}

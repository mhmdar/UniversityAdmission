import java.io.*;

public class FileWrite {
	
	//----------| saveAccepted |--------------------------------------------
	public static void accepted(File studentsAcceptedFile){
		BufferedWriter buff = null;
		try{
			buff = new BufferedWriter(new FileWriter(studentsAcceptedFile));
			buff.write("|         Student              |  Tawjihi  |  School  | Placement | Final");
			buff.newLine();
			buff.write("|          Name                |   mark    |   mark   |  mark     | mark");
			buff.newLine();
			for (int i=0 ; i<Acceptance.getNoOfFaculties() ; i++){
				buff.newLine();
				buff.write("|************************************************************************");
				buff.newLine();
				buff.write("|  "+Acceptance.getFaculties(i).getName());
				buff.newLine();
				buff.write("|  "+Acceptance.getFaculties(i).students.getSize()+"  accepted");
				buff.newLine();
				buff.write("|------------------------------------------------------------------------");
				buff.newLine();
				if(Acceptance.getNoOfFaculties() != 0){
					Student current = Acceptance.getFaculties(i).students.first;
					while (current != null){
						buff.write(String.format("%-34s",current.getName())+current.getTawjihi()+
									"        "+current.getHighSchool()+"        "+
									current.getPlacement()+"        "+current.getMark());
						buff.newLine();
						current = current.next;
					}
				}
				buff.newLine();
				buff.newLine();
			}
			buff.flush();
		} catch(IOException e){
			System.out.println("Cannot write on the file");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("Some error has occurred");
			e.getMessage();
		}
		finally {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//----------| saveRejected |--------------------------------------------
		public static void rejected(File studentsRejectedFile){
			BufferedWriter buff = null;
			try{
				buff = new BufferedWriter(new FileWriter(studentsRejectedFile));
				buff.write("|         Student              |  Tawjihi  |  School  | Placement | Final");
				buff.newLine();
				buff.write("|          Name                |   mark    |   mark   |  mark     | mark");
				buff.newLine();
				buff.newLine();
				buff.write("|************************************************************************");
				buff.newLine();
				buff.write("|  STUDENTS REJECTED");
				buff.newLine();
				buff.write("|  "+Acceptance.studentsRejected.getSize()+"  rejected");
				buff.newLine();
				buff.write("|------------------------------------------------------------------------");
				buff.newLine();
				if(Acceptance.getNoOfFaculties() != 0){
					Student current = Acceptance.studentsRejected.first;
					while (current != null){
						buff.write(String.format("%-34s",current.getName())+current.getTawjihi()+
									"        "+current.getHighSchool()+"        "+
									current.getPlacement()+"        "+current.getMark());
						buff.newLine();
						current = current.next;
					}
				}
				buff.flush();
			} catch(IOException e){
				System.out.println("Cannot write on the file");
				e.printStackTrace();
			} catch(Exception e){
				System.out.println("Some error has occurred");
				e.getMessage();
			}
			finally {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
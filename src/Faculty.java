
public class Faculty {

	private	String	name;
	private	int		form;
	private	int		to;
	public  List    students;
	
	public Faculty(String name, int form, int to) {
		this.name	= name;
		this.form	= form;
		this.to		= to;
		this.students = new List();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getForm() {
		return form;
	}
	public void setForm(int form) {
		this.form = form;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
//	public int getStudentCount() {
//		return studentCount;
//	}
//	public void setStudentCount(int studentCount) {
//		this.studentCount = studentCount;
//	}
	
//	@Override
//	public String toString() {
//		return "Faculty [name=" + name + ", form=" + form + ", to=" + to + "]";
//	}
	
	
}

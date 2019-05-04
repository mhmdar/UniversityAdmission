
public class Student {
	private String  name;
	private float   tawjihi;
	private float   highSchool;
	private float   placement;
	private float   mark;
	public  Student next;
		
	public Student(String name, float tawjihi, float highSchool, float placement){
		this.name       = name;
		this.tawjihi    = tawjihi;
		this.highSchool = highSchool;
		this.placement  = placement;
		this.next       = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTawjihi() {
		return tawjihi;
	}
	public void setTawjihi(float tawjihi) {
		this.tawjihi = tawjihi;
	}
	public float getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(float highSchool) {
		this.highSchool = highSchool;
	}
	public float getPlacement() {
		return placement;
	}
	public void setPlacement(float mark) {
		this.mark = mark;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
}


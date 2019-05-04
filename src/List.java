
public class List {
	public  Student first , last;
	private int     size;
	
	public List(){	// Default constructor
	}
	//-----| Print |------------------------------------
	public void print(){
		if (size != 0){
			Student current = first;
			while (current != null){
				System.out.printf("%-34s%2.1f%8s%2.1f%7s%2.1f%8s%2.1f%1s", current.getName(),
									current.getTawjihi(),"", current.getHighSchool(),
									"", current.getPlacement(),"",current.getMark(),"\n");
				Main.textArea.appendText(String.format("%-34s%2.1f%8s%2.1f%7s%2.1f%8s%2.1f%1s", current.getName(),
									current.getTawjihi(),"", current.getHighSchool(),
									"", current.getPlacement(),"",current.getMark(),"\n"));
				current = current.next;
			}
			System.out.println("\n");
			Main.textArea.appendText("\n");
		} else System.out.println("<None>");
	}
		
	//-----| getSize |---------------------------------
	public int getSize() {
		return size;
	}
		
	//-----| getFirst |--------------------------------- 
	public Object getFirst(){
		if (size == 0) return null;
		return first.getName()+"    "+first.getTawjihi()+"    "+first.getHighSchool()+"    "+first.getPlacement();
	}
	/*
	//-----| getLast |-----------------------------------
	public Object getLast(){
		if (size == 0) return null;
		else return last.data;
	}
	
	//-----| getStudent |---------------------------------- 
	public Student getStudent(int index){
		if (size == 0)
			return null;
		else if (index >= size)
			return null;
		else {
			Student current = first;
			for (int i=0 ; i<index ; i++)
				current = current.next;
			return current;
		}
	}
	
	//-----| getValue |----------------------------------
	public Object getData(int index){
		if (size == 0) return null;
		else if (size > 0){
			Student current = first;
			for (int i=0 ; i<size ; i++){
				if (i == index)			// when we compare an object we use .equals
					return current.data;
				current = current.next;
			}
		}
		return -1;
	}
	*/
	//-----| addFirst |---------------------------------
	public void addFirst(String name, float tawjihi, float school, float placement){
		Student temp;
		temp = new Student(name, tawjihi, school, placement);
		if (size == 0)
			first = last = temp;
		else {
			temp.next = first;
			first = temp;
		}
		size++;
	}
	
	public void addFirst(Student x){
		if (size == 0)
			first = last = x;
		else {
			x.next = first;
			first = x;
		}
		size++;
	}
	/*
	//-----| addLast |-----------------------------------
	
	public void addLast (Object s) {
		if (size == 0)
			first = last = new Student(s);
		else {
			last.next = new Student(s);
			last = last.next;
		}
		size++;
	}
	
	//-----| add |--------------------------------------
	public void add (Object s , int index) {
		if (index == 0)
			addFirst(s);
		else if (index >= size)
			addLast(s);
		else {
			Student temp = new Student(s);
			Student current = first;
			for (int i=0 ; i<index-1 ; i++)
				current = current.next;
			temp.next = current.next;
			current.next = temp;
			size++;
		}
	}
	
	//-----| setData |----------------------------------
		public void setData (Object s , int index) {
			if (index >= size)
				addLast(s);
			else {
				Student current = first;
				for (int i=0 ; i<index ; i++)
					current = current.next;
				current.data = s;
			}
		}
	
	//-----| removeFirst |------------------------------
	public boolean removeFirst() {
		if (size == 0) return false;
		else {
			if (size == 1)
				first = last = null;
			else
				first = first.next;
			size--;
			return true;
		}
	}
	
	//-----| removeLast |-------------------------------
	public boolean removeLast() {
		if (size == 0) return false;
		else if (size == 1)
			first = last = null;
		else {
			Student current = first;
			for (int i=0 ; i<size-2 ; i++)
				current = current.next;
			current.next = null;
			last = current;
		}
		size--;
		return true;
	}
	
	//-----| remove |-----------------------------------
	public boolean remove(int index) {
		if (index == 0)
			return removeFirst();
		else if (index == size)
			return removeLast();
		else if ((index>0)&&(index<size)) {
			Student current = first;
			for (int i=0 ; i<index -1; i++)
				current = current.next;
			current.next = current.next.next;
			size--;
			return true;
		}
		else return false;
	}
	
	//-----| search |-----------------------------------
	public int search (Object x) {
		if (size > 0){
			Student current = first;
			for (int i=0 ; i<size ; i++){
				if (x.equals(current.data))			// when we compare an object we use .equals
					return i;
				current = current.next;
			}
		}
		return -1;
	}
	*/
}	// end of class

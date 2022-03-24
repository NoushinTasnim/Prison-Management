
public class Staff extends Core implements ID {

	int salary;
	String contact;
	public Staff(int num, String nam, int ag, String bGroup, String genr, int salar, String cont) {
		super(num,nam,ag,bGroup,genr);
		salary = salar;
		contact = cont;
	}
	
	void print()
	{
		System.out.println(super.name);
		System.out.println(super.age);
		System.out.println(super.number);
		System.out.println(super.gender);
		System.out.println(super.bloodGroup);
		System.out.println(salary);
		System.out.println(contact);
	}

}

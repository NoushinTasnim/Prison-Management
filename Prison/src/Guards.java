
public class Guards extends Staff{
	
	String shift;
	String area;

	public Guards(int num, String nam, int ag, String bGroup, String gener, int salar, String cont,String shif, String are) {
		super(num,nam,ag,bGroup,gener,salar,cont);
		shift = shif;
		area = are;
	}
	
	void print()
	{
		System.out.println(super.name);
		System.out.println(super.age);
		System.out.println(super.number);
		System.out.println(super.gender);
		System.out.println(super.bloodGroup);
		System.out.println(super.salary);
		System.out.println(super.contact);
		System.out.println(shift);
		System.out.println(area);
	}

}

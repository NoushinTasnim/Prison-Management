
public class Core {
	
	int number;
	String name;
	int age;
	String bloodGroup;
	String gender;
	public Core(int num, String nam, int ag, String bGroup, String gen) {
		number = num;
		name = nam;
		age = ag;
		bloodGroup = bGroup;
		gender = gen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guards guard = new Guards(10290,"Mr. A",35,"O+(ve)","Male",15000,"01919223344","Day","A wing");
		
		guard.print();
	}

}


public class Runner {

	public static void main(String[] args) {
		System.out.println("Avail loptops = " + Laptop.availableLaptops());
		{
		Laptop acer = Laptop.getLaptop();
		System.out.println(acer.getId());
		System.out.println("Avail loptops = " + Laptop.availableLaptops());
		}
		
		

	}

}
class Laptop implements Loanable{
	//------------------ Static
	public static final int TOTAL_LAPTOPS = 3;
	private static int available = Laptop.TOTAL_LAPTOPS;
	
	static private Laptop [] computers = {new Laptop(1), new Laptop(2),new Laptop(3)};
	
	public static Laptop getLaptop() { 
		for(Laptop c : computers) {
			if (!c.onLoan()) {
				c.toggleLoanStaus();
				Laptop.available--;
				return c;
			}
		}
		return null;
	}
	public static void returnLaptop(Laptop c) { 
		Laptop.available++;
		c.toggleLoanStaus();
	}
	public static int availableLaptops() {
			return Laptop.available;
	}
	
	//------------------ Instance Stuff
	
	private Laptop() {};
	
	private int id;
	private boolean onLoan;

	private Laptop(int id) {
		this.id = id;
		this.onLoan = false;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public boolean onLoan() {
		return this.onLoan;
	}

	@Override
	public boolean toggleLoanStaus() {
		this.onLoan = !this.onLoan;
		return this.onLoan;
	}
}

interface Loanable {
	public boolean onLoan();
	public boolean toggleLoanStaus();
}
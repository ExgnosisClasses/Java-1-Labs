
public class Runner {
    // Solution for lab 4-1 using a for loop
	public static void main(String[] args) {
		
		int sum = 0;

		for (int i =1 ; i <= 20; i++ ) {
			if (0 != i % 2) continue;
			sum += (i * i);
			if (sum > 30) break;		 
		}
		
		System.out.println("Sum = "+ sum);
	}

}

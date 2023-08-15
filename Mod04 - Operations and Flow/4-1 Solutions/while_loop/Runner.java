
public class Runner {
    // Solution for lab 4-1 using a while loop
	public static void main(String[] args) {
		
		int sum = 0;
		int i = 0;
		while (sum < 30) {
		  i++;
		  if (0 != i % 2) continue;
		  sum += (i * i);		 
		}
		
		System.out.println("Sum = "+ sum);
	}

}

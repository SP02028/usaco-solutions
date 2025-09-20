package floor;

public class floor {

	public static void main(String[] args) {
		double a = 0;
		for(int i = 1; i <= 1012; i++) {
			a += Math.floor(Math.pow(2024, i*2));
			System.out.println(i*2 + " = " + a);
		}
	}
}

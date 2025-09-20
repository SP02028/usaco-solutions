package hellow;

public class hello {

	public static void main(String[] args) {
		int count = 0;
for(int a = 1; a<10;a++) {
	for(int b = 1; b <10; b++)
{
		for(int c = 1; c<10;c++) {
			if((a+b+c==10)&&(a*b*c + 9 == a*b+b*c+c*a) == true) {
				System.out.println(a + " " + b + " " + c);
				count++;
				}
			else {
				continue;
			}
		} 
}
}
System.out.println(count);
	}

}

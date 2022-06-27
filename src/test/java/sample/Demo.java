package sample;

public class Demo {
	public static void main(String[] args) {
		Demo d=new Demo();
		int sum = d.findSum(5);
		System.out.println(sum);
	}
	
	public int findSum(int n) {
		return n*(n+1)/2;
	}

}

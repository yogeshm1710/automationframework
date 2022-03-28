package practice;

import java.util.Random;

public class GetRandomData {
  public static void main(String[] args) {
	Random random = new Random();
	int ranNum= random.nextInt(1000);
	System.out.println(ranNum);
}
}

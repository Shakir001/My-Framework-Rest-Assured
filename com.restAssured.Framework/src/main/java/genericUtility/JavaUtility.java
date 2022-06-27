package genericUtility;

import java.util.Random;

/**
 * This class contains generic methods related to java
 * like generating random numbers, getting date
 * @author Shakir
 *
 */
public class JavaUtility {

	public int getRandomNumber()
	{
		Random r=new Random();
		int ranNum = r.nextInt(1000);
		return ranNum;
	}
}

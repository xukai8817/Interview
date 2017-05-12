package concurrent.combat.reentrant.cache;

import java.math.BigInteger;

/**
 * @moudle: ExpensiveFunction 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月11日 下午4:05:39
 *
 */ 
public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		return new BigInteger(arg);
	}

}

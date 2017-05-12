package concurrent.combat.reentrant.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @moudle: Memoizer1 
 * @version:v1.0
 * @Description: 缺点：每次只有一个线程可以访问compute方法
 * @author: xukai
 * @date: 2017年5月11日 下午4:22:33
 *
 * @param <A>
 * @param <V>
 */ 
public class Memoizer1<A, V> implements Computable<A, V> {

	private final Computable<A, V> c;

	private final Map<A, V> cache = new HashMap<A, V>();

	public Memoizer1(Computable<A, V> c) {
		this.c = c;
	}

	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}

}

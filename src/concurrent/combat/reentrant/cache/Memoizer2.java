package concurrent.combat.reentrant.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @moudle: Memoizer2 
 * @version:v1.0
 * @Description: 当两个线程同时调用compute时，可能会导致计算得到相同的值<br>
 * 				如果某个线程启动了开销很大的计算，其他线程不知道，可能会重复这个计算
 * @author: xukai
 * @date: 2017年5月11日 下午4:22:58
 *
 * @param <A>
 * @param <V>
 */ 
public class Memoizer2<A, V> implements Computable<A, V> {

	private final Computable<A, V> c;

	private final Map<A, V> cache = new ConcurrentHashMap<A, V>();

	public Memoizer2(Computable<A, V> c) {
		this.c = c;
	}

	public V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}

}

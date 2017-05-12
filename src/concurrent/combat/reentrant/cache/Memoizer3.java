package concurrent.combat.reentrant.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @moudle: Memoizer3
 * @version:v1.0
 * @Description: 首先检查某个相应的计算是否已经开始<br>漏洞：两个线程计算相同值
 * @author: xukai
 * @date: 2017年5月11日 下午4:25:57
 *
 * @param <A>
 * @param <V>
 */
public class Memoizer3<A, V> implements Computable<A, V> {

	private final Computable<A, V> c;

	private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

	public Memoizer3(Computable<A, V> c) {
		this.c = c;
	}

	public V compute(final A arg) throws InterruptedException {
		Future<V> f = cache.get(arg);
		if (f == null) {
			Callable<V> eval = new Callable<V>() {

				@Override
				public V call() throws Exception {
					return c.compute(arg);
				}

			};
			FutureTask<V> ft = new FutureTask<>(eval);
			f = ft;
			cache.put(arg, ft);
			ft.run();
		}
		try {
			return f.get();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}

package concurrent.combat.reentrant.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @moudle: Memoizer 
 * @version:v1.0
 * @Description: 最终实现
 * @author: xukai
 * @date: 2017年5月11日 下午4:40:05
 *
 * @param <A>
 * @param <V>
 */ 
public class Memoizer<A, V> implements Computable<A, V> {

	private final Computable<A, V> c;

	private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	public V compute(final A arg) throws InterruptedException {
		while (true) {
			Future<V> f = cache.get(arg);
			if (f == null) {
				Callable<V> eval = new Callable<V>() {

					@Override
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				FutureTask<V> ft = new FutureTask<>(eval);
				f = cache.putIfAbsent(arg, ft);
				if (f == null) {
					f = ft;
					ft.run();
				}
				
			}
			try {
				return f.get();
			} catch (CancellationException e) {
				cache.remove(arg, f);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}

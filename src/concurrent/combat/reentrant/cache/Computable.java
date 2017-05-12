package concurrent.combat.reentrant.cache;

/**
 * @moudle: Computable
 * @version:v1.0
 * @Description: 计算接口
 * @author: xukai
 * @date: 2017年5月11日 下午4:03:24
 *
 * @param <A>
 * @param <V>
 */
public interface Computable<A, V> {

	V compute(A arg) throws InterruptedException;
}

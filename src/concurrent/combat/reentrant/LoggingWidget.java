package concurrent.combat.reentrant;

/**
 * @moudle: LogginWidget 
 * @version:v1.0
 * @Description: 子类，调用父类同步方法<br>
 * synchronized对实例方法加锁，锁的是当前的实例，调用父类的方法的对象也是当前的实例。所以产生了“重入”
 * @author: xukai
 * @date: 2017年5月2日 上午11:07:05
 *
 */ 
public class LoggingWidget extends Widget {

	public LoggingWidget() {
		super();
	}
		
	@Override
	public synchronized void doSomething() {
		System.out.println(this.toString() + ": doSomething");
		super.doSomething();
	}
	
}

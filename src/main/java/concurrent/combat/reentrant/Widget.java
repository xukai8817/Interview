package concurrent.combat.reentrant;

/**
 * @moudle: Widget 
 * @version:v1.0
 * @Description: 父类，方法加锁
 * @author: xukai
 * @date: 2017年5月2日 上午11:05:50
 *
 */ 
public class Widget {
	
	public Widget() {
	}

	public synchronized void doSomething() {
		System.out.println(this.toString() + ": doSomething");
	}
	
}


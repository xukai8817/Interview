package concurrent.combat.reentrant;

/**
 * @moudle: TestReetrant 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月2日 下午4:42:18
 *
 */ 
public class TestReetrant {
	
	LoggingWidget logWidget = new LoggingWidget();

	public TestReetrant() {
		new Thread(new Task()).start();
	}
	
	class Task implements Runnable {
		@Override
		public void run() {
			while(true) {
				try {
					logWidget.doSomething();
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new TestReetrant();
	}
	
}

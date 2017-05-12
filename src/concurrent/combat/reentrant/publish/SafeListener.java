package concurrent.combat.reentrant.publish;

public class SafeListener {

	private final EventListener listener;
	
	private SafeListener() {
		listener = new EventListener() {
			@Override
			public void onEvent(Event e) {
				System.out.println("doSomething");
			}
		};
	}
	
	public static SafeListener newInstance(EventSource source) {
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);	// 保证在构造函数完成构造，this引用逸出
		return safe;
	}
	
}

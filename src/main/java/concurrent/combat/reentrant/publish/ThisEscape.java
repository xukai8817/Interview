package concurrent.combat.reentrant.publish;

/**
 * @moudle: ThisEscape 
 * @version:v1.0
 * @Description: 隐式地使用this引用逸出
 * @author: xukai
 * @date: 2017年5月3日 上午12:50:49
 *
 */ 
public class ThisEscape {

	public ThisEscape(EventSource source) {
		source.registerListener(new EventListener() {
			@Override
			public void onEvent(Event e) {
			}
		});
	}
	
}

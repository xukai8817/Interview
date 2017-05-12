package concurrent.combat.reentrant.base.desktop;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @moudle: Indexer 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月10日 下午9:09:12
 *
 */ 
public class Indexer implements Runnable {

	private final BlockingQueue<File> queue;
	
	public Indexer(BlockingQueue<File> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while (true) {
			try {
				indexFile(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void indexFile(File take) {
		System.out.println(take.getName());
	}

}

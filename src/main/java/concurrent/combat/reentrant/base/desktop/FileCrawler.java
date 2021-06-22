package concurrent.combat.reentrant.base.desktop;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * @moudle: FileCrawler 
 * @version:v1.0
 * @Description: 桌面应用程序中的生产者和消费者任务
 * @author: xukai
 * @date: 2017年5月10日 下午9:05:15
 *
 */ 
public class FileCrawler implements Runnable{

	private final BlockingQueue<File> fileQueue;
	
	private final FileFilter fileFilter;
	
	private final File root;
	
	public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
		this.fileQueue = fileQueue;
		this.fileFilter = fileFilter;
		this.root = root;
	}
	
	@Override
	public void run() {
		try {
			crawl(root);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void crawl(File root) throws InterruptedException {
		File[] entries = root.listFiles(fileFilter);
		if (entries != null) {
			for (File entry : entries) {
				if (entry.isDirectory()) {
					crawl(entry);
				} else if (!alreadyIndexed(entry)) {
					fileQueue.put(entry);
				}
			}
		}
	}

	private boolean alreadyIndexed(File entry) {
		return fileQueue.contains(entry);
	}

}

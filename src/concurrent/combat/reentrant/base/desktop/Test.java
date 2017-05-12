package concurrent.combat.reentrant.base.desktop;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @moudle: Test
 * @version:v1.0
 * @Description: 启动桌面搜索
 * @author: xukai
 * @date: 2017年5月10日 下午9:20:56
 *
 */
public class Test {

	public static void main(String[] args) {
		File[] roots = {new File("C:/Users/hcc/Desktop")};
		startIndexing(roots);
	}

	public static void startIndexing(File[] roots) {
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return true;
			}
		};
		for (File root : roots) {
			new Thread(new FileCrawler(queue, fileFilter, root)).start();;
		}
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Indexer(queue)).start();;
		}
	}

}

synchronized使用情况：
实例方法：给调用该方法的对象加锁
静态方法：给这个类加锁
调用一个对象的同步实例方法要求给该对象加锁。
调用一个类的同步静态方法要求改类加锁。
-----------------------------------------
任何同步的实例方法都可以转换为同步语句
			synchronized(account) {
				account.deposit(1);
			}
-----------------------------------------			
死锁：
在两个或更多个线程获取多个对象上的锁定
并且每个对象在一个对象上具有锁定并且正在等待另一个对象上的锁定的情况下发生死锁。 
资源排序技术可以用来避免死锁。
Thread1:
synchronized(Object1){
	synchronized(Object2) {
	}
}

Thread2:
synchronized(Object2){
	synchronized(Object1) {
	}
}
解决办法：Thread2获取Object1的锁之后，再去获取Object2的锁。
-----------------------------------------
同步集合使用迭代器需要手工同步（fail-fast)
synchronized (Collection) {
	Iterator iterator = Collection.iterator();
	while (iterator.hasNext()) {
		iterator.next();
	}
}
-----------------------------------------
阻塞队列
ArrayBlockingQueue:必须制定一个容量或者可选的公平性来构造
LinkedBlockingQueue:可以创建不受限或者受限
PriorityBlockingQueue:可以创建不受限或者受限优先队列
*对于不受限的队列而言，put方法永远不会阻塞
-----------------------------------------
锁Lock和信号量Semaphore区别：
锁和信号都可以用来限制对共享资源的访问。
 在资源上使用锁确保只有一个线程可以访问它。 在资源上使用信号量允许一个或多个指定数量的线程访问资源。
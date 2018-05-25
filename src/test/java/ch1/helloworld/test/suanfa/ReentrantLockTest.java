package ch1.helloworld.test.suanfa;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ReentrantLockTest {
	@Test
	public void test01(){
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
	}
}

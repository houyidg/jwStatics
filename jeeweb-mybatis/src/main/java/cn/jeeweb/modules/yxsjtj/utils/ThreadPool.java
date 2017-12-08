package cn.jeeweb.modules.yxsjtj.utils;

import java.util.concurrent.ThreadFactory;

public class ThreadPool {
	private static ThreadFactory threadPool;
	
	public static ThreadFactory geThreadFactory() {
		if(threadPool==null) {
			synchronized (ThreadPool.class) {
				if(threadPool==null) {
//					threadPool = new Fa
				}
			}
		}
		
		return threadPool;
	}
}

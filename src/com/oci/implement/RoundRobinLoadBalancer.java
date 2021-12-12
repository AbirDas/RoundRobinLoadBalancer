package com.oci.implement;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import com.oci.helper.LoadBalancer;

public class RoundRobinLoadBalancer extends LoadBalancer{
	
	private int counter =0;
	private final ReentrantLock lock;

	public RoundRobinLoadBalancer(List<String> ipList) {
		super(ipList);
		lock = new ReentrantLock();
	}
	
	@Override
	public String getIP() {
		lock.lock();
		try {
			String ip = ipList.get(counter);
			counter += 1;
			if(counter == ipList.size()) {
				counter = 0;
			}
			return ip;
		} finally {
			lock.unlock();
		} 
	}

}

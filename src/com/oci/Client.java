package com.oci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.oci.helper.LoadBalancer;
import com.oci.implement.RoundRobinLoadBalancer;

public class Client {

	public static void main(String[] args) {
		int NUM_OF_REQUESTS = 10;
		Client client = new Client();

		List<String> ipPool = new ArrayList<String>();
		ipPool.add("192.168.0.0");
		ipPool.add("192.168.0.1");
		ipPool.add("192.168.0.2");
		ipPool.add("192.168.0.3");
		ipPool.add("192.168.0.4");
		ipPool.add("192.168.0.5");
		ipPool.add("192.168.0.6");
		ipPool.add("192.168.0.7");
		ipPool.add("192.168.0.8");
		ipPool.add("192.168.0.9");

		System.out.println("---");
		System.out.println("Clients starts to send requests to Round-Robin Load Balancer");
		System.out.println("---");
		// Below code need to be in while loop to keep it running
		//while(true) {
		LoadBalancer roundRobbin = new RoundRobinLoadBalancer(ipPool);
		client.simulateConcurrentClientRequest(roundRobbin, NUM_OF_REQUESTS);
		//}
	}

	private void simulateConcurrentClientRequest(LoadBalancer loadBalancer, int numOfCalls) {

		IntStream.range(0, numOfCalls).parallel().forEach(i -> 
		System.out.println(
				"IP: " + loadBalancer.getIP()
				+ " --- Request from Client: " + i 
				+ " --- [Thread: " + Thread.currentThread().getName() + "]"));
	}

}

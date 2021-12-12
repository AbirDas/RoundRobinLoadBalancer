package com.oci.helper;

import java.util.Collections;
import java.util.List;

public abstract class LoadBalancer {
	final public List<String> ipList;
	
	public LoadBalancer(List<String> ipList) {
		this.ipList = Collections.unmodifiableList(ipList);
	}
	
	public abstract String getIP();
}

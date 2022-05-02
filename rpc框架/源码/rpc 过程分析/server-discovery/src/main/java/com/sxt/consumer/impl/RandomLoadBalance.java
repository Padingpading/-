package com.sxt.consumer.impl;

import java.util.List;
import java.util.Random;

import com.sxt.consumer.LoadBalance;

public class RandomLoadBalance implements LoadBalance{

	private static Random RDM = new Random(); 
	
	@Override
	public String loadBalance(List<String> uris) {
		// uris 3   0 1 2
		return uris.get(RDM.nextInt(uris.size()));
	}

}

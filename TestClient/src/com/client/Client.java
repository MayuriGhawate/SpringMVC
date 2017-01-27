package com.client;

import com.mayuri.Compute;
import com.mayuri.ComputeService;

public class Client {
	
	public static void main(String[] args)
	{
		ComputeService cs1 = new ComputeService();
		Compute port= cs1.getCompute();
		System.out.println(port.add(12, 13));
	}

}

package org.dhananjay.siprotrack.impl;

import org.dhananjay.siprotrack.ProcessContext;

public class ProcessDAOImpl implements ProcessDAO {

	public void saveProcess(ProcessContext context) {
		System.out.println("Current Context "+context);
	}

	public void updateProcess(ProcessContext context) {
		System.out.println("Current Context "+context);
	}

}

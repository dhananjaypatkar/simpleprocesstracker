package org.dhananjay.siprotrack.impl;

import org.dhananjay.siprotrack.ProcessContext;

/**
 * @author dhananjayp
 *
 */
public interface ProcessDAO {

	/**
	 * @param context
	 */
	void saveProcess(ProcessContext context);
	
	/**
	 * @param context
	 */
	void updateProcess(ProcessContext context);
	
}

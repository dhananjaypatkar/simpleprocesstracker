package org.dhananjay.siprotrack;

import java.util.Map;

/**
 * @author dhananjayp
 *
 */
public interface ProcessTracker {

	/**
	 * 
	 */
	void startProcess(String processName);
	
	/**
	 * @param processState
	 */
	void saveProcess(String stageName,Map<String, String> processState);
	
	/**
	 * 
	 */
	void endProcess();
	
}

package org.dhananjay.siprotrack.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.dhananjay.siprotrack.ProcessContext;
import org.dhananjay.siprotrack.ProcessTracker;

/**
 * @author dhananjayp
 *
 */
public class SimpleProcessTracker implements ProcessTracker {
	
	private ThreadLocal<ProcessContext> context = new ThreadLocal<ProcessContext>();
	
	private ProcessDAO processDAO;
	
	public void setProcessDAO(ProcessDAO processDAO) {
			this.processDAO = processDAO;
	}

	/**
	 * 
	 */
	private void initProcessContext(String processName){
		ProcessContext pContext = new ProcessContext();
		pContext.setProcessName(processName);
		pContext.setProcessState(new HashMap<String, String>());
		pContext.setInstanceId(UUID.randomUUID().toString());
		context.set(pContext);
	}

	
	public void startProcess(String processName) {
		initProcessContext(processName);
		//setProcessDAO(null);
		this.processDAO.saveProcess(context.get());
	}
	

	public void saveProcess(String stageName,Map<String, String> processState) {
		Map<String, String>  state = reconcileContext(processState);
		ProcessContext processContext = context.get();
		processContext.setProcessState(state);
		processContext.setCurrentStage(stageName);
		context.set(processContext);
		this.processDAO.updateProcess(processContext);
	}
	
	private Map<String, String>  reconcileContext(Map<String, String> processState){
		Map<String, String> existingState = context.get().getProcessState();
		for (Map.Entry<String, String> currentState : processState.entrySet()) {
			//if(existingState.containsKey(currentState.getKey())){
				existingState.put(currentState.getKey(), currentState.getValue());
			//}
		}
		return existingState;
	}

	public void endProcess() {
		this.processDAO.updateProcess(context.get());
		context.remove();
	}

}

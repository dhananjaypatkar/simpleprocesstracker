package org.dhananjay.siprotrack;

import java.io.Serializable;
import java.util.Map;

public class ProcessContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1194114854615489570L;
	
	private enum Status {
		START,
		INPROGRESS,
		FINSHED
	}

	private String instanceId;

	private String processName;
	
	private Status status;
	
	private String currentStage;

	private Map<String,String> processState;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Process Name " + this.getProcessName());
		builder.append("Current Stage "+this.getCurrentStage());
		builder.append("Instance Id "+this.getInstanceId());
		builder.append("Process State "+this.getProcessState());
		return builder.toString();
	}
	
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Map<String, String> getProcessState() {
		return processState;
	}

	public void setProcessState(Map<String, String> processState) {
		this.processState = processState;
	}
	
	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}
}
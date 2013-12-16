package org.dhananjay.siprotrack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class ProcessTrackerTest extends TestCase {

	private ApplicationContext applicationContext;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.applicationContext = new ClassPathXmlApplicationContext("config/processtracker-context.xml");
	}
	
	public void testProcess(){
		SimpleProcess process = (SimpleProcess)applicationContext.getBean("simpleProcess");
		process.initProcess();
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/processtracker-context.xml");
		SimpleProcess process = (SimpleProcess)applicationContext.getBean("simpleProcess");
		process.initProcess();
	}
}

package simulator;

import java.lang.System;
import java.io.*;

import core.SimulatorAttribute;


public class GetUserAttributesSetting {

	SimulatorAttribute simulatorAttribute = new SimulatorAttribute();
	
	public	GetUserAttributesSetting(){
		
		//test
		//simulatorAttribute = new SimulatorAttribute(40,40,40,40,200,10,1);
			
		try {
			InputStreamReader stdin = new InputStreamReader(System.in);
			BufferedReader bufferin = new BufferedReader(stdin);
			
			System.out.print("plz input width:");
			simulatorAttribute.setWidth(Integer.parseInt(bufferin.readLine()));
			
			System.out.print("plz input heigth:");
			simulatorAttribute.setHeigth(Integer.parseInt(bufferin.readLine()));
			
			System.out.print("plz input soliderTermiteNumber:");
			simulatorAttribute.setSoliderTermiteNumber(Integer.parseInt(bufferin.readLine()));
			
			System.out.print("plz input workerTermiteNumber:");
			simulatorAttribute.setWorkerTermiteNumber(Integer.parseInt(bufferin.readLine()));
			
			System.out.print("plz input chipNumber:");
			simulatorAttribute.setChipNumber(Integer.parseInt(bufferin.readLine()));
			
			System.out.print("plz input loopNumber:");
			simulatorAttribute.setLoopNumber(Integer.parseInt(bufferin.readLine()));
			
			System.out.print("plz input outputInfomationMode(briefInfo->1;richInfo->2):");
			simulatorAttribute.setOutputMode(Integer.parseInt(bufferin.readLine()));
			//simulatorAttribute.setOutputMode(1);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public SimulatorAttribute GetSimulatorAttribute(){
		return this.simulatorAttribute;
	}
	
	public void testAttributes(){
		simulatorAttribute.PrintAttributes();		
	}
}

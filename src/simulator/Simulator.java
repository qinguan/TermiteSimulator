package simulator;

import core.TermiteSimulator;
import gui.GraphDisplay;

import java.io.*;

public class Simulator {
	
	public static void main(String[] args){
	
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader bufferin = new BufferedReader(stdin);
		String string ;
		
		try {
			System.out.print("select outmode(1-graph;other-text):");
			string = bufferin.readLine();
			if(Integer.parseInt(string) == 1){
				GraphDisplay testSwing = new GraphDisplay();
				testSwing.RunGui();
			}
			else{
				GetUserAttributesSetting test = new GetUserAttributesSetting();
				test.testAttributes();
				
				TermiteSimulator termiteSimulator = new TermiteSimulator(test.GetSimulatorAttribute());
				termiteSimulator.StartTermiteSimulator();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*
		GetUserAttributesSetting test = new GetUserAttributesSetting();
		test.testAttributes();
		
		TermiteSimulator termiteSimulator = new TermiteSimulator(test.GetSimulatorAttribute());
		termiteSimulator.StartTermiteSimulator();*/

	}
	
}

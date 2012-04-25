package core;


public class SimulatorAttribute {

	private int width;
	private int heigth; 
	private int soliderTermiteNumber;
	private int workerTermiteNumber;
	private int chipNumber;
	private int loopNumber;
	private int outputMode;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getSoliderTermiteNumber() {
		return soliderTermiteNumber;
	}

	public void setSoliderTermiteNumber(int soliderTermiteNumber) {
		this.soliderTermiteNumber = soliderTermiteNumber;
	}

	public int getWorkerTermiteNumber() {
		return workerTermiteNumber;
	}

	public void setWorkerTermiteNumber(int workerTermiteNumber) {
		this.workerTermiteNumber = workerTermiteNumber;
	}

	public int getChipNumber() {
		return chipNumber;
	}

	public void setChipNumber(int chipNumber) {
		this.chipNumber = chipNumber;
	}

	public int getLoopNumber() {
		return loopNumber;
	}

	public void setLoopNumber(int loopNumber) {
		this.loopNumber = loopNumber;
	}

	public int getOutputMode() {
		return outputMode;
	}

	public void setOutputMode(int outputMode) {
		this.outputMode = outputMode;
	}

	public SimulatorAttribute(){
		
	}
	
	public SimulatorAttribute(
			int width,
			int heigth,
			int soliderTermiteNumber,
			int workerTermiteNumber,
			int chipNumber,
			int loopNumber,
			int outputMode){
		this.width = width;
		this.heigth = heigth;
		this.soliderTermiteNumber = soliderTermiteNumber;
		this.workerTermiteNumber = workerTermiteNumber;
		this.chipNumber = chipNumber;
		this.loopNumber = loopNumber;
		this.outputMode = outputMode;
	}
	
	/*public void SetSimulatorAttribute(
			int width,
			int heigth,
			int soliderTermiteNumber,
			int workerTermiteNumber,
			int chipNumber,
			int loopNumber,
			int outputMode){
		setWidth(width);
		setHeigth(heigth);
		setSoliderTermiteNumber(soliderTermiteNumber);
		setWorkerTermiteNumber(workerTermiteNumber);
		setChipNumber(chipNumber);
		setLoopNumber(loopNumber);
		setOutputMode(outputMode);
	}*/
	
	public void PrintAttributes(){
		System.out.println("\nThe parameters you input as follows:");
		System.out.println("width:"+width);
		System.out.println("Height:"+heigth);
		System.out.println("soliderTermiteNumber:"+soliderTermiteNumber);
		System.out.println("workerTermiteNumber:"+workerTermiteNumber);
		System.out.println("chipNumber:"+chipNumber);
		System.out.println("loopNumber:"+loopNumber);
		System.out.println("outputMode:"+outputMode);
	}
}

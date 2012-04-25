package core;

import java.util.ArrayList;

public class Patch {
	
	private int chipNumber;
	private int soldierTermiteNumber;
	private int workerTermiteNumber;
	private ArrayList<WorkerTermite> workerTermiteList = new ArrayList<WorkerTermite>(); 
	
	
	public ArrayList<WorkerTermite> getWorkerTermiteList() {
		return workerTermiteList;
	}
	public void setWorkerTermiteList(ArrayList<WorkerTermite> workerTermiteList) {
		this.workerTermiteList = workerTermiteList;
	}
	
	public void IncrementWorkerTermiteList(WorkerTermite workerTermite){
		this.workerTermiteList.add(workerTermite);
	}
	
	public void DecrementWorkerTermiteList(WorkerTermite workerTermite){
		this.workerTermiteList.remove(workerTermite);
	}
	
	public int getChipNumber() {
		return chipNumber;
	}
	public void setChipNumber(int chipNumber) {
		this.chipNumber = chipNumber;
	}
	public int getSoldierTermiteNumber() {
		return soldierTermiteNumber;
	}
	public void setSoldierTermiteNumber(int soldierTermiteNumber) {
		this.soldierTermiteNumber = soldierTermiteNumber;
	}
	public int getWorkerTermiteNumber() {
		return workerTermiteNumber;
	}
	public void setWorkerTermiteNumber(int workerTermiteNumber) {
		this.workerTermiteNumber = workerTermiteNumber;
	}
	
	public void IncrementChipNumber(){
		this.chipNumber++;
	}
	public void DeCrementChipNumber(){
			this.chipNumber--;
	}
	public void IncrementSoldierTermiteNumber(){
		this.soldierTermiteNumber++;
	}
	public void DecrementSoldierTermiteNumber(){
			this.soldierTermiteNumber--;
	}
	public void IncrementWorkerTermiteNumber(){
		this.workerTermiteNumber++;
	}
	public void DecrementWorkerTermiteNumber(){
			this.workerTermiteNumber--;
	}
	
	public Patch(){
		this.chipNumber = 0;
		this.soldierTermiteNumber = 0;
		this.workerTermiteNumber = 0;
	}
	
	public Patch(int chipNumber,int soldierTermiteNumber,int workerTermiteNumber){
		this.chipNumber = chipNumber;
		this.soldierTermiteNumber = soldierTermiteNumber;
		this.workerTermiteNumber = workerTermiteNumber;
	}
	
}

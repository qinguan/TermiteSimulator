package core;

public class TermiteSimulator {
	public World world;
	private SimulatorAttribute simulatorAttribute;
	
	public TermiteSimulator(){
		simulatorAttribute = new SimulatorAttribute();
	}
	
	public TermiteSimulator(SimulatorAttribute simulatorAttribute){
		this.simulatorAttribute = simulatorAttribute;
	}
	
	public void StartTermiteSimulator(){
		IntialSimulator();
		Run();
	}
	
	public void IntialSimulator(){
		int width = simulatorAttribute.getWidth();
		int heigth = simulatorAttribute.getHeigth();
		int[] location;
		Patch[][] tempPitchs;
		world = new World(width,heigth);
		
		for(int i = 0;i < simulatorAttribute.getWorkerTermiteNumber();i++){
			location = Helper.GenerateRandomLocation(width, heigth); 
			WorkerTermite workerTermite = new WorkerTermite(location,world);
			world.AddEntity(workerTermite);//添加实体
			//修改二维数组，相应位置上添加termite计数
			tempPitchs = world.getPitchs();
			tempPitchs[location[0]][location[1]].IncrementWorkerTermiteNumber();
			tempPitchs[location[0]][location[1]].getWorkerTermiteList().add(workerTermite);
			world.setPitchs(tempPitchs);
		}
		for(int i = 0 ; i < simulatorAttribute.getSoliderTermiteNumber();i++){
			location = Helper.GenerateRandomLocation(width, heigth); 
			SoldierTermite soldierTermite = new SoldierTermite(location,world);
			world.AddEntity(soldierTermite);
			tempPitchs = world.getPitchs();
			tempPitchs[location[0]][location[1]].IncrementSoldierTermiteNumber();
			world.setPitchs(tempPitchs);
		}
		for(int i = 0 ; i < simulatorAttribute.getChipNumber(); i++){
			location = Helper.GenerateRandomLocation(width, heigth);
			Chip chip = new Chip(location,world);
			world.AddEntity(chip);
			tempPitchs = world.getPitchs();
			tempPitchs[location[0]][location[1]].IncrementChipNumber();
			world.setPitchs(tempPitchs);
		}
	}
	
	public void Run(){
		
		for(int i=0; i < simulatorAttribute.getLoopNumber(); i++){
			for(BaseEntity baseEntity : world.getEntities()){
				baseEntity.DoAction();
			}
			/*System.out.println();
			System.out.print("*******************loopIndex:");
			System.out.print(i);
			System.out.println("*************************");
			world.PrintWorldBrief();
			//world.PrintWorldRich();
			System.out.print("*******************loopIndex:");
			System.out.print(i);
			System.out.println("--END********************");*/
			
			if (simulatorAttribute.getLoopNumber() > 50
					&& i > simulatorAttribute.getLoopNumber() - 50) {
				PrintResult(i);
			} else if (simulatorAttribute.getLoopNumber() < 50) {
				PrintResult(i);
			}
			
			//工蚁数目小于木片数目
			if(simulatorAttribute.getChipNumber() > simulatorAttribute.getWorkerTermiteNumber()){
				if(world.isOnlyOnePatchOwnChip()){
					PrintResult(i);
					i = simulatorAttribute.getLoopNumber();
				}
			}
			//工蚁数目大于木片数目
			else if(simulatorAttribute.getChipNumber() < simulatorAttribute.getWorkerTermiteNumber()){
				if(world.isNoPatchOwnChip()){
					PrintResult(i);
					i = simulatorAttribute.getLoopNumber();
				}	
			}
		}
	}
	
	private void PrintResult(int loopnum){
		System.out.println();
		System.out.print("*******************loopIndex:");
		System.out.print(loopnum);
		System.out.println("*************************");
		if(simulatorAttribute.getOutputMode() == 1){
			world.PrintWorldBrief();
		}
		else {
			world.PrintWorldRich();	
		}
		
		System.out.print("*******************loopIndex:");
		System.out.print(loopnum);
		System.out.println("--END********************");
	}
	
	
	public void StopTermiteSimulator(){
				
	}
}

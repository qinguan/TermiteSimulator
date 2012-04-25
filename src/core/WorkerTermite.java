package core;

public class WorkerTermite implements BaseEntity{
	
	public int entityId;
	public int[] location = new int[2];
	public World world;
	
	private boolean isCarryChip = false;

	public boolean isCarryChip() {
		return isCarryChip;
	}

	public void setCarryChip(boolean isCarryChip) {
		this.isCarryChip = isCarryChip;
	}

	public WorkerTermite(){
		this.entityId = Helper.GenerateSelfIncrement();
	}
	
	public WorkerTermite(int[] location,World world){
		this.entityId = Helper.GenerateSelfIncrement();
		this.location = location;
		this.world = world;
	}
	
	public void DoAction(){

		if(isExistChip() && isCarryChip()){
			DropChip();
		}
		else if(isExistChip() && !isCarryChip()){
			PickChip();
		}
		Move();
	}
	
/*	public void AddToWorld(World world,int[] location){
		world.AddEntity(this);
		Pitch[][] tempPitchs = world.getPitchs();
		tempPitchs[location[0]][location[1]].IncrementChipNumber();
		world.setPitchs(tempPitchs);
	}*/
			
	public void Move(){
		int[] direction = new int[2];
		
		Patch[][] tempPitchs = world.getPitchs();
		tempPitchs[location[0]][location[1]].DecrementWorkerTermiteNumber();
		tempPitchs[location[0]][location[1]].DecrementWorkerTermiteList(this);
		
		direction = Helper.GenerateRandomDirection();

		int[] temp = new int[2];
		temp[0] = location[0];
		temp[1] = location[1];
		while(IsOutOfBounds(temp, direction)){
			temp[0] = location[0];
			temp[1] = location[1];
			direction = Helper.GenerateRandomDirection();
		}
		
		location[0] =location[0] + direction[0];
		location[1] =location[1] + direction[1];	
		
		tempPitchs[location[0]][location[1]].IncrementWorkerTermiteNumber();
		tempPitchs[location[0]][location[1]].IncrementWorkerTermiteList(this);
		world.setPitchs(tempPitchs);
	}
	
	private boolean IsOutOfBounds(int[] oldLocation,int[] randomDirection){
		oldLocation[0] += randomDirection[0];
		oldLocation[1] += randomDirection[1];
		
		if(oldLocation[0] >= world.getWidth())
			return true;
		if(oldLocation[0] < 0)
			return true;
		if(oldLocation[1] >= world.getHeigth())
			return true;
		if(oldLocation[1] < 0)
			return true;
		return false;
	}
		
	private boolean isExistChip(){
		Patch[][] tempPitch = world.getPitchs();
		
		if(tempPitch[location[0]][location[1]].getChipNumber() != 0){
			return true;
		}
		
		return false;
	}
	
	private void PickChip(){
		setCarryChip(true);
		
		Patch[][] tempPitchs = world.getPitchs();
		tempPitchs[location[0]][location[1]].DeCrementChipNumber();
		
		world.setPitchs(tempPitchs);
	}
	
	private void DropChip(){
		setCarryChip(false);
		
		Patch[][] tempPitchs = world.getPitchs();
		tempPitchs[location[0]][location[1]].IncrementChipNumber();
			
		world.setPitchs(tempPitchs);
	}

	

}

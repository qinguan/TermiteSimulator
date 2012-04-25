package core;

public class SoldierTermite implements BaseEntity{
	
	public int entityId;
	public int[] location = new int[2];
	public World world;
	
	public SoldierTermite(){
		this.entityId = Helper.GenerateSelfIncrement();
	}
	
	public SoldierTermite(int[] location,World world){
		this.entityId = Helper.GenerateSelfIncrement();
		this.location = location;
		this.world = world;
	}
	
	public void DoAction(){
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
		tempPitchs[location[0]][location[1]].DecrementSoldierTermiteNumber();
		
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
				
		tempPitchs[location[0]][location[1]].IncrementSoldierTermiteNumber();
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
}

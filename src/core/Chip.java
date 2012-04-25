package core;

public class Chip implements BaseEntity{
	
	public int entityId;
	public int[] location = new int[2];
	public World world;
		
	public Chip() {
		this.entityId = Helper.GenerateSelfIncrement();
	}
	
	public Chip(int[] location,World world){
		this.entityId = Helper.GenerateSelfIncrement();
		this.location = location;
		this.world = world;
	}
	
	public void DoAction(){
		
	}
	
/*	public void AddToWorld(World world,int[] location){
		world.AddEntity(this);
		Pitch[][] tempPitchs = world.getPitchs();
		tempPitchs[location[0]][location[1]].IncrementChipNumber();
		world.setPitchs(tempPitchs);
	}*/
	
}

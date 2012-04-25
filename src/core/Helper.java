package core;
import java.util.Random;


public class Helper {

	private static int selfIncrement = 0;
	
	public static int GenerateSelfIncrement() {
		return selfIncrement++;
	}	
	
	public static int[] GenerateRandomLocation(int width,int heigth){
		int[] location = new int[2];
		Random random = new Random();
		
		//x coordinate
		location[0] = random.nextInt(width); 
		//y coordinate
		location[1] = random.nextInt(heigth);
		
		return location;
	} 
	
	/*
	 * choose direction random in eight directions
	 * northwest(-1,1)	north(0,1) 	northeast(1,1)
	 * west(-1,0)					east(1,0)  
	 * southwest(-1,-1)	south(0,-1)	southeast(1,-1)
	 */
	public static int[] GenerateRandomDirection(){
		int[] randomDirection = new int[2];
		int random = (new Random()).nextInt(8);
		switch (random) {
		case 0://north
			randomDirection[0]=-1;
			randomDirection[1]=1;
			break;
		case 1://northeast
			randomDirection[0]=1;
			randomDirection[1]=1;
			break;
		case 2://east
			randomDirection[0]=1;
			randomDirection[1]=0;
			break;
		case 3://southeast
			randomDirection[0]=1;
			randomDirection[1]=-1;
			break;
		case 4://south
			randomDirection[0]=0;
			randomDirection[1]=-1;
			break;
		case 5://southwest
			randomDirection[0]=-1;
			randomDirection[1]=-1;
			break;
		case 6://west
			randomDirection[0]=-1;
			randomDirection[1]=0;
			break;
		case 7://northwest
			randomDirection[0]=-1;
			randomDirection[1]=1;
			break;
		default:
			randomDirection[0]=0;
			randomDirection[1]=0;
			break;
		}
		return randomDirection;
	}
	
}

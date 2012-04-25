package core;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class World {

	private int width;
	private int heigth; 
	private Patch[][] patchs;
	private ArrayList<BaseEntity> entities = new ArrayList<BaseEntity>(); 
	
	
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

	public Patch[][] getPitchs() {
		return patchs;
	}

	public void setPitchs(Patch[][] pitchs) {
		this.patchs = pitchs;
	}
	
	public List<BaseEntity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<BaseEntity> entities) {
		this.entities = entities;
	}

	public boolean isOnlyOnePatchOwnChip(){
		int patchOwnChipNumber = 0;
		for(int i =0 ; i < width; i++){
			for(int j = 0 ; j < heigth ; j++){
				if(patchs[i][j].getChipNumber()>0){
					patchOwnChipNumber++;
				}
			}
		}
		if(patchOwnChipNumber == 1)
			return true;
		else {
			return false;
		}	
	}
	
	public boolean isNoPatchOwnChip(){
		int patchOwnChipNumber = 0;
		for(int i =0 ; i < width; i++){
			for(int j = 0 ; j < heigth ; j++){
				if(patchs[i][j].getChipNumber()>0){
					patchOwnChipNumber++;
				}
			}
		}
		if(patchOwnChipNumber == 0)
			return true;
		else {
			return false;
		}
	}
	
	public World(){
		
	}
	
	public World(int width,int heigth){
		this.width = width;
		this.heigth = heigth;
		patchs = new Patch[width][heigth];
		
		for(int i =0 ; i < width; i++){
			for(int j = 0 ; j < heigth ; j++){
				patchs[i][j] = new Patch();
			}
		}
	}
	
	public void AddEntity(BaseEntity baseEntity){
		entities.add(baseEntity);
	}
	
	//在面板网格中画各种Termite&Chip
	public void PrintWorldGraphic(
			Graphics g,
			int x_remainder,
			int y_remainder,
			int section_width,
			int section_height){
		//根据网格数目设置字体大小
		if(width>60 || heigth > 60)
			g.setFont(new Font("Times New Roman", 0, 10));
		else {
			g.setFont(new Font("Times New Roman", 0, 14));
		}
		for(int i=0;i<width;i++){
			for(int j=0;j<heigth;j++){
				int workerTermiteCarringChipNum=0;
				int Flag_O = 0;
				if(patchs[i][j].getWorkerTermiteNumber()>0){
					for (WorkerTermite workerTermite : patchs[i][j].getWorkerTermiteList()) {
						if(workerTermite.isCarryChip()){
							workerTermiteCarringChipNum++;
						}
					}
					if(workerTermiteCarringChipNum>0){
						g.drawString("X", 
								x_remainder + i*section_width,
								y_remainder+(j+3/2)*section_height);
					}
					else{
						Flag_O = 1;
						g.drawString("O",
								x_remainder+i*section_width,
								y_remainder+(j+3/2)*section_height);
					}
				}
				else if(patchs[i][j].getSoldierTermiteNumber()>0){
					if(Flag_O == 0){
						g.drawString("O", 
								x_remainder+i*section_width,
								y_remainder+(j+3/2)*section_height);	
					}
					
				}
				else if(patchs[i][j].getChipNumber()>0){
					if(Flag_O==0){
						g.drawString(Integer.toString(patchs[i][j].getChipNumber()),
								x_remainder+i*section_width,
								y_remainder+(j+3/2)*section_height);	
					}
				}
			}
		}
	}
	//在文本域打印world的简要信息
	public void PrintWorldBriefGraph(javax.swing.JTextArea area) {
		//循环里置换i、j位置为了打印一致
		for(int j=0;j<width;j++){
			for(int i=0;i<heigth;i++){
				int workerTermiteCarringChipNum=0;
				if(patchs[i][j].getWorkerTermiteNumber()>0){
					for (WorkerTermite workerTermite : patchs[i][j].getWorkerTermiteList()) {
						if(workerTermite.isCarryChip()){
							workerTermiteCarringChipNum++;
						}
					}
					if(workerTermiteCarringChipNum>0){
						area.append(String.format("%4s","X"));
					}
					else{
						area.append(String.format("%4s","O"));
					}
				}
				else if(patchs[i][j].getSoldierTermiteNumber() > 0){
					area.append(String.format("%4s","O"));
				}
				else if(patchs[i][j].getChipNumber()>0){
					area.append(String.format("%6s",String.valueOf(patchs[i][j].getChipNumber())));//+"    ");
				}
				else{
					area.append(String.format("%6s","."));
				}							
			}
			area.append("\n");
		}
		area.append("************************************************************\n");
	}
	//在文本域打印world的所有信息
	public void PrintWorldRichGraph(javax.swing.JTextArea area){
		int worker = 0;
		int soldier = 0;
		int chip = 0;
		//循环里置换i、j位置为了打印一致
		for(int j=0;j<width;j++){
			for(int i=0;i<heigth;i++){
				area.append(String.valueOf(patchs[i][j].getChipNumber()));
				chip +=patchs[i][j].getChipNumber();
				area.append(":");
				area.append(String.valueOf(patchs[i][j].getSoldierTermiteNumber()));
				soldier += patchs[i][j].getSoldierTermiteNumber();
				area.append(":");
				area.append(String.valueOf(patchs[i][j].getWorkerTermiteNumber()));
				worker += patchs[i][j].getWorkerTermiteNumber();
				int workerTermiteCarringChipNum=0;
				if(patchs[i][j].getWorkerTermiteNumber()>0){
					for (WorkerTermite workerTermite : patchs[i][j].getWorkerTermiteList()) {
						if(workerTermite.isCarryChip()){
							workerTermiteCarringChipNum++;
						}
					}
				}
				if(workerTermiteCarringChipNum>0){
					area.append("/");
					area.append(String.valueOf(workerTermiteCarringChipNum));
				}
				area.append("\t");
			}
			area.append("\n");
		}
		
		area.append("result@");
		area.append("chips:");
		area.append(String.valueOf(chip));
		area.append("|soldierTermites:");
		area.append(String.valueOf(soldier));
		area.append("|workerTermites:");
		area.append(String.valueOf(worker)+"\n\n");
	}
	
	//test
	public void PrintWorldBrief(){
		for(int i=0;i<width;i++){
			for(int j=0;j<heigth;j++){
				int workerTermiteCarringChipNum=0;
				if(patchs[i][j].getWorkerTermiteNumber()>0){
					for (WorkerTermite workerTermite : patchs[i][j].getWorkerTermiteList()) {
						if(workerTermite.isCarryChip()){
							workerTermiteCarringChipNum++;
						}
					}
					if(workerTermiteCarringChipNum>0){
						System.out.print("X");
					}
					else{
						System.out.print("O");
					}
				}
				else if(patchs[i][j].getSoldierTermiteNumber() > 0){
					System.out.print("O");
				}
				else if(patchs[i][j].getChipNumber()>0){
					System.out.print(patchs[i][j].getChipNumber());
				}
				else{
					System.out.print(".");
				}							
			}
			System.out.println();
		}
	}
	
	//test
	public void PrintWorldRich(){
		int worker = 0;
		int soldier = 0;
		int chip = 0;
		for(int i=0;i<width;i++){
			for(int j=0;j<heigth;j++){
				System.out.print(patchs[i][j].getChipNumber());
				chip +=patchs[i][j].getChipNumber();
				System.out.print(":");
				System.out.print(patchs[i][j].getSoldierTermiteNumber());
				soldier += patchs[i][j].getSoldierTermiteNumber();
				System.out.print(":");
				System.out.print(patchs[i][j].getWorkerTermiteNumber());
				worker += patchs[i][j].getWorkerTermiteNumber();
				int workerTermiteCarringChipNum=0;
				if(patchs[i][j].getWorkerTermiteNumber()>0){
					for (WorkerTermite workerTermite : patchs[i][j].getWorkerTermiteList()) {
						if(workerTermite.isCarryChip()){
							workerTermiteCarringChipNum++;
						}
					}
				}
				if(workerTermiteCarringChipNum>0){
					System.out.print("/");
					System.out.print(workerTermiteCarringChipNum);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.print("result@");		
		System.out.print("chips:");
		System.out.print(chip);				
		System.out.print("|soldierTermites:");
		System.out.print(soldier);		
		System.out.print("|workerTermites:");
		System.out.println(worker);
		
	}
	
	
	
	
}

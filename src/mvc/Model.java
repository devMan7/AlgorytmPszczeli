package mvc;

import java.util.ArrayList;

import bees.Bee;
import bees.BeeRole;
import bees.Point;

public class Model {
	
	private ArrayList<String> result = new ArrayList<String>();
	private Point globalMinimum = new Point(-10,100);
	public ArrayList<String> getResult() {
		return result;
	}
	private ArrayList<Bee> beesPopulation = new ArrayList<Bee>();
	
	public ArrayList<Bee> getBeesPopulation() {
		return beesPopulation;
	}

	public Point getGlobalMinimum() {
		return globalMinimum;
	}

	public void setGlobalMinimum(Point globalMinimum) {
		this.globalMinimum = globalMinimum;
	}

	public ArrayList<String> getResult(String fromX, String toX){
		setPopulation(10, 30);
		for(int i=0; i<100; i++){
			setPopulation(10, 30);
			for(int j=0; j<beesPopulation.size();j++){
				if(beesPopulation.get(j).getRole()==BeeRole.inactive)continue;
				else if(beesPopulation.get(j).getRole()==BeeRole.scout)beesPopulation.get(j).processScoutBee();
				else beesPopulation.get(j).processActiveBee();
			}
		}
	
		return result;
	}
	private void setPopulation(int scautQuantity, int recrutQuantity){
		beesPopulation=new ArrayList<Bee>();
		for(int i=0; i<scautQuantity; i++){
			beesPopulation.add(new Bee(BeeRole.scout, this, globalMinimum));
		}
		for(int i=0; i<recrutQuantity; i++){
			beesPopulation.add(new Bee(BeeRole.inactive, this, globalMinimum));
		}
	}
}

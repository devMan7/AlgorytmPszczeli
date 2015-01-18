package mvc;

import java.util.ArrayList;
import java.util.Random;

import functions.Function;

import bees.Bee;
import bees.BeeRole;
import bees.Point;

public class Model {
	
	private ArrayList<Point> result = new ArrayList<Point>();
	private Point globalMinimum;
	private void randomGlobalMinimum(double minX, double maxX, String function) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		int a = new Random().nextInt((int)Math.floor(maxX));
		double b = new Random().nextDouble();
		Function f = (Function) Class.forName("functions."+function+"Function2D").newInstance();
		if(a*b<minX) globalMinimum = new Point(minX,f.getResult(minX));
		else globalMinimum = new Point(a*b,f.getResult(a*b));
	}
	public ArrayList<Point> getResult() {
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

	public ArrayList<Point> getResult(double fromX, double toX, String function){
		result = new ArrayList<Point>();
		try {
			randomGlobalMinimum(fromX, toX, function);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPopulation(10, 30);

		for(int i=0; i<100; i++){
			setPopulation(10, 30);
			for(int j=0; j<beesPopulation.size();j++){
				if(beesPopulation.get(j).getRole()==BeeRole.inactive)continue;
				else if(beesPopulation.get(j).getRole()==BeeRole.scout)beesPopulation.get(j).processScoutBee(fromX, toX, function);
				else beesPopulation.get(j).processActiveBee(function);
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

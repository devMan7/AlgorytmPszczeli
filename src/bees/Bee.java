package bees;

import java.util.ArrayList;
import java.util.Random;

import mvc.Model;

import functions.Function;
import functions.LinearFunction;
import functions.RastriginFunction;
import functions.RastriginFunction2D;

public class Bee {
	
	private Point bestPlace;
	private BeeRole role;
	private Model model;
	
	public Bee(BeeRole role, Model model, Point bestPlace){
		this.role = role;
		this.model = model;
		this.bestPlace=bestPlace;
	}
	public BeeRole getRole() {
		return role;
	}
	public void processScoutBee(double fromX, double toX, String function){
		try {
			findBetterPlace(generateNewPlace(fromX,toX,function));
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
	}
	public void processActiveBee(String function){
		try {
			findBetterPlace(generateNeighbourhood(bestPlace, function));
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
	}
	

	private void findBetterPlace(Point newPlace){
		if(newPlace.getY()<bestPlace.getY()){
			bestPlace = newPlace;
			model.setGlobalMinimum(bestPlace);
			model.getResult().add(bestPlace);
		}
		}
	private Point generateNewPlace(double fromX, double toX, String function) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		double tempX = bestPlace.getX()+((2*new Random().nextDouble())-1.5);
		while(tempX < fromX || tempX > toX) tempX = bestPlace.getX()+((2*new Random().nextDouble())-1.5);
		return new Point(tempX, ((Function)Class.forName("functions."+function+"Function2D").newInstance()).getResult(tempX));
	}
	private Point generateNeighbourhood(Point oldPoint, String function) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return new Point(oldPoint.getX()+1, ((Function)Class.forName("functions."+function+"Function2D").newInstance()).getResult(oldPoint.getX()));
	}
	private void doWaggleDance(){
		for(Bee b : model.getBeesPopulation()){
			if(b.role==BeeRole.inactive){
				b.findBetterPlace(this.bestPlace);
				b.role=BeeRole.active;
			}
		}
	}
	}



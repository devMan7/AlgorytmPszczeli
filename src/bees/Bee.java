package bees;

import java.util.ArrayList;
import java.util.Random;

import mvc.Model;

import functions.LinearFunction;

public class Bee {
	
	private Point bestPlace=new Point(10, 100);
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
	public void processScoutBee(){
		findBetterPlace(generateNewPlace());
	}
	public void processActiveBee(){
		findBetterPlace(generateNeighbourhood(bestPlace));
	}
	

	private void findBetterPlace(Point newPlace){
		if(newPlace.getY()<bestPlace.getY()){
			bestPlace = newPlace;
			model.setGlobalMinimum(bestPlace);
			model.getResult().add(String.valueOf(bestPlace.getX()));
		}
		}
	private Point generateNewPlace(){
		double tempX = bestPlace.getX()+((2*new Random().nextDouble())-1.5);
		return new Point(tempX,LinearFunction.getResult(tempX));
	}
	private Point generateNeighbourhood(Point oldPoint){
		return new Point(oldPoint.getX()+1,LinearFunction.getResult(oldPoint.getX()));
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



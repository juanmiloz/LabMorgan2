package model;
import java.util.*;

public class Travel{
	
	private int totalWeigth;
	private int totalBox;
	private ArrayList<Load> load;
	
	
	/*
	name: Travel
	Its the constructor of the Travel
	**/
	public Travel(int totalWeigth, int totalBox){
		this.totalWeigth = totalWeigth;
		this.totalBox = totalBox; 
		load = new ArrayList<Load>();
	}
	
	/*
	name: getTotalWeigth
	show the total weight
	<b>pre:</b>the total weight must be entered
	<b>post:</b>show the total weigth saved in variable "totalWeigth"
	**/
	public int getTotalWeigth(){
		return totalWeigth;
	}
	
	/*
	name: setTotalWeigth
	allows entering a totalWeigth
	<b>post:</b>the total weigth will be saved
	@param: totalWeigth
	**/
	public void setTotalWeigth(int totalWeigth){
		this.totalWeigth = totalWeigth;
	}
	
	public int getTotalBox(){
		return totalBox;
	}
	
	public void setTotalBox(int totalBox){
		this.totalBox = totalBox;
	}
	
	public ArrayList<Load> getLoad(){
		return load;
	}
	
	public void setLoad(ArrayList<Load> load){
		this.load  = load;
	}
	
	public void addLoadTrip(int numberOfBox, double weigth, int typeBox){
		Load newLoad = new Load (numberOfBox, weigth, typeBox);
		load.add(newLoad);
	}
}	
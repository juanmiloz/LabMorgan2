package model;
import java.util.*;

public class Load{
	

	
	private int numberOfBox = 0, typeBox = 0;
	private double weigth = 0; 
	
	
	/*
	name: Load
	Its the constructor of the Load
	**/
	public Load(int numberOfBox, double weigth, int typeBox){
		this.numberOfBox = numberOfBox;
		this.weigth = weigth;
		this.typeBox = typeBox;
	}	public final static double KG_LOAD_DANGEROUS = 390000;
	public final static double KG_LOAD_PERISHABLE = 250000;
	public final static double KG_LOAD_NOT_PERISHABLE = 80000;
	public final static int DANGEROUS = 1;
	public final static int PERISHABLE = 2;
	public final static int NOT_PERISHABLE = 3;
	
	/*
	name: getNumberOfBox
	show the number of box
	<b>pre:</b>the number of box must be entered
	<b>post:</b>show the number of box saved in variable "numberOfBox"
	**/
	public int getNumeberOfBox(){
		return numberOfBox;
	}
	
	/*
	name: setNumberOfBox
	allows entering a number of box
	<b>post:</b>the number of the box will be saved
	@param: numberOfBox
	**/
	public void setNumeberOfBox(int numberOfBox){
		this.numberOfBox = numberOfBox;
	}
	
	/*
	name: getWeigth
	show the weigth of the box
	<b>pre:</b>the weigth of box must be entered
	<b>post:</b>show the weigth of box saved in variable "weigth"
	**/
	public double getWeigth(){
		return weigth;
	}
	
	/*
	name: setWeigth
	allows entering the weigth of the box
	<b>post:</b>the weigth of the box will be saved
	@param: weigth
	**/
	public void setWeigth(double weigth){
		this.weigth = weigth;
	}
	
	/*
	name: getTypeBox
	show the type of the box
	<b>pre:</b>the type of box must be entered
	<b>post:</b>show the type of box saved in variable "typeBox"
	**/
	public int getTypeBox(){
		return typeBox;
	}
	
	/*
	name: setTypeBox
	allows entering type of the box
	<b>post:</b>the type of the box will be saved
	@param: typeBox
	**/
	public void setTypeBox(int typeBox){
		this.typeBox = typeBox;
	}
	
}
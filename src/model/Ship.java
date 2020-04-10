package model;
import java.util.*;

public class Ship{
	
	public final static int MAX_WEIGTH = 28000;
	private String nameShip, captain ; 
	private Client client[]; 
	private ArrayList<Travel> travel;
	private int trip = 0;
	
	
	/*
	name: Ship
	Its the constructor of the Ship
	**/
	public Ship(String nameShip, String captain){
		this.nameShip = nameShip;
		this.captain = captain;
		client = new Client [5];
		travel = new ArrayList<Travel>();
	}
	
	/*
	name: getNameShip
	show the name of the ship
	<b>pre:</b>the name of the ship must be entered
	<b>post:</b>show the name of the ship saved in variable "nameShip"
	**/
	public String getNameShip(){
		return nameShip;
	}
	
	/*
	name: setNameShip
	allows entering a new name for the ship
	<b>post:</b>the new name will be saved
	@param: nameShip
	**/
	public void setNameShip(String nameShip){
		this.nameShip = nameShip;
	}
	
	/*
	name: getCaptain
	show the name of the captain
	<b>pre:</b>the name of the captain must be entered
	<b>post:</b>show the name of the captain saved in variable "captain"
	**/
	public String getCaptain(){
		return captain;
	}
	
	/*
	name: setCaptain
	allows entering a new name for the captain
	<b>post:</b>the new captain will be saved
	@param: captain
	**/
	public void setCaptain(String captain){
		this.captain = captain;
	}	
	
	/*
	name: getCLient
	show the client in the posicion of the array 
	<b>pre:</b>the Client must be entered
	<b>post:</b>show the client in the posicion of the array
	**/
	public Client[] getClient(){
		return client;
	}
	
	/*
	name: setClient
	allows entering a new cliente in the array
	<b>post:</b>the new client will be saved
	@param: client
	**/
	public void setClient(Client[] client){ 
		this.client = client;  
	}
	
	/*
	name: addClient
	add a new Client in the array
	<b>post:</b>the client is saved
	@param: nameClient
	@param: commercialRegister
	@param: date
	@param: type
	@param: numberKilos
	@param: totalValue
	**/
	public void addClient(String nameClient, int commercialRegister, String date, String type, double numberKilos, int totalValue){
		Client newClient = new Client (nameClient, commercialRegister, date, type, numberKilos, totalValue);
		for(int i = 0; i < client.length; i++){
			if(client[i] == null){
				client[i]= newClient; 
				i = 6;
			}
		}
	}
	
	/*
	name: getTravel
	show the travel in the position in the arrayList
	<b>pre:</b>the travel must be entered
	<b>post:</b>show the travel in the posicion of the arrayList
	**/
	public ArrayList<Travel> getTravel(){
		return travel;
	}
	
	/*
	name: setTravel
	allows entering a new travel in the arrayList
	<b>post:</b>the new travel will be saved
	@param: travel
	**/
	public void setLoad(ArrayList<Travel> travel){
		this.travel  = travel;
	}
	
	
	/*
	name: addTravel
	add a new travel in the array list
	<b>post:</b>the new travel is inicialized
	@param: totalWeigth
	@param: totalBox
	**/
	public void addTravel(int totalWeigth, int totalBox){
		Travel newTravel = new Travel (totalWeigth,totalBox);
		travel.add(newTravel);
	}
	
	/*
	name: getTrip
	take the trip variable
	**/
	public int getTrip(){
		return trip;
	}
	
	/*
	name: setTip
	increases the trip by one
	**/
	public void setTrip(){
		this.trip += 1; 
	}
}
package model;
import java.util.*;

public class Client{
	
	private String nameClient, date, type ; 
	private int commercialRegister = 0; 
	private double numberKilos = 0, totalValue = 0;
	
	
	/*
	name: Client
	Its the constructor of the Client
	**/
	public Client(String nameClient, int commercialRegister, String date, String type, double numberKilos, int totalValue){
		this.nameClient = nameClient;
		this.commercialRegister = commercialRegister;
		this.date = date;
		this.type = type;
		this.numberKilos = numberKilos;
		this.totalValue = totalValue;
	}
	
	/*
	name: getNameClient
	show the name of the client
	<b>pre:</b>the name of the client must be entered
	<b>post:</b>show the name of the client saved in variable "nameClient"
	**/
	public String getNameClient(){
		return nameClient;
	}
	
	/*
	name: setNameClient
	allows entering a new name for the client
	<b>post:</b>the new name to the client will be saved
	@param: nameClient
	**/
	public void setNameClient(String nameClient){
		this.nameClient = nameClient;
	}
	
	/*
	name: getCommercialRegister
	show the commercial register of the client
	<b>pre:</b>the commercial register of the client must be entered
	<b>post:</b>show the commercial register of the client saved in variable "commercialRegister"
	**/
	public int getCommercialRegister(){
		return commercialRegister;
	}
	
	/*
	name: setCommercialRegister
	allows entering a new commercial register of the client
	<b>post:</b>the new commercial Register of the client will be saved
	@param: commercialRegister
	**/
	public void setComemercialRegister(int commercialRegister){
		this.commercialRegister = commercialRegister;
	}
	
	/*
	name: getDate
	show the date of expedition of the register
	<b>pre:</b>the date of the expedition  must be entered
	<b>post:</b>show the date of expedition of the commercial register saved in variable "date"
	**/
	public String getDate(){
		return date;
	}
	
	/*
	name: setDate
	allows entering a date of the expedition of the register
	<b>post:</b>the new date of expedition of the register will be saved
	@param: date
	**/
	public void setDate(String date){
		this.date = date;
	}
	
	/*
	name: getType
	show the type of the client 
	<b>pre:</b>the type of the client  must be entered
	<b>post:</b>show the type of the client saved in variable "type"
	**/
	public String getType(){
		return type;
	}
	
	/*
	name: setType
	allows entering a type of the client
	<b>post:</b>the new type of the client will be saved
	@param: type
	**/
	public void setType(String type){
		this.type = type;
	}
	
	/*
	name: getNumberKilos
	show the number of kilos 
	<b>pre:</b>the number of kilos must be entered
	<b>post:</b>show the number of kilos saved in variable "numberKilos"
	**/
	public double getNumberKilos(){
		return numberKilos;
	}
	
	/*
	name: setNumberKilos
	allows entering a number of kilos of the box
	<b>post:</b>the new number of kilos of the box will be saved
	@param: numberKilos
	**/
	public void setNumberKilos(double numberKilos){
		this.numberKilos = numberKilos;
	}
	
	/*
	name: getNumberKilos
	show the total value of the loads 
	<b>pre:</b> 
	<b>post:</b>show the total value of the all box
	**/
	public double getTotalValue(){
		return totalValue;
	}
	
	/*
	name: setTotalValue
	allows entering a total value of the load
	<b>post:</b>the new total value of the box will be saved
	@param: totalValue
	**/
	public void setTotalValue(double totalValue){
		this.totalValue = totalValue;
	}
}
package ui;
import model.*;
import java.util.*;

public class Menu{

	private static Scanner in = new Scanner(System.in);
	private final static int AGREGAR_CARGA = 1;
	private final static int DESCARGAR_BARCO = 2;
	private final static int PESO_TOTAL_DE_CARGA = 3;
	private final static int MODIFICAR_CLIENTE = 4;
	private final static int EXIT = 5;
	
	
	private int menu = 0, volver = 1;
	
	private String nameBoat, nameCaptain;
	private int totalWeigth, totalBox;
	private Ship ship = new Ship (nameBoat, nameCaptain);
	
	/*
	name: informatioPrincipal
	allows entering the main and necessary information of the program
	**/
	public void informationPrincipal(){
		
		System.out.println("Ingrese el nombre del barco");
		nameBoat = in.nextLine();
		System.out.println("Ingrese el nombre del capitan");
		nameCaptain = in.nextLine();

		/* Prueba funcionalidad
		System.out.println("");
		String barco = "El nombre del barco es " + ship.getNameShip() + " y su capitan es " + ship.getCaptain();
		System.out.println(barco);
		**/

		System.out.println("\nIngrese los datos de los 5 clientes que tiene la embarcacion " + ship.getNameShip());
		for (int i = 0; i < 5 ; i++){
			String nameClient, date, typeClient;
			int commercialRegister, totalValue;
			double numberKilos;

			System.out.println("\nIngrese el nombre del cliente numero " + (i+1));
			nameClient = in.nextLine();
			System.out.println("\nIngrese el registro mercantil del cliente numero "+ (i+1));
			commercialRegister = in.nextInt();
			System.out.println("\nIngrese la fecha de expedicion del cliente numero "+ (i+1));
			in.nextLine();
			date = in.nextLine();

			do{
			System.out.println("\nIngrese el tipo de cliente del cliente numero " + (i+1) + "(Plantinum, oro, plata, normal)");
			typeClient = in.nextLine();
			if(!typeClient.equalsIgnoreCase("normal") && !typeClient.equalsIgnoreCase("plata") && !typeClient.equalsIgnoreCase("oro") && !typeClient.equalsIgnoreCase("platinum")){
				System.out.println("ingrese un tipo valido");
			}

			}while(!typeClient.equalsIgnoreCase("normal") && !typeClient.equalsIgnoreCase("plata") && !typeClient.equalsIgnoreCase("oro") && !typeClient.equalsIgnoreCase("platinum"));

			numberKilos = 0;
			totalValue = 0;

			System.out.println("");
			ship.addClient(nameClient, commercialRegister, date, typeClient, numberKilos, totalValue);
		}
		
		/*
		for(int i = 0; i < 5; i++){
			result += "nombre " + ship.getClient()[i].getNameClient() + "\n";
			result += "registro" + ship.getClient()[i].getCommercialRegister() + "\n";
		}
		System.out.println(result);
		**/
	}
	
	/*
	name: menu
	show the menu
	**/
	public void menu(){
		System.out.println("\nQue opcion desea realizar?");
		System.out.println("1<--- AGREGAR CARGA");
		System.out.println("2<--- DESCARGAR BARCO");
		System.out.println("3<--- MOSTRAR EL PESO TOTAL DE  LA CARGA");
		System.out.println("4<--- MODIFICAR CLIENTE");
		System.out.println("5<--- SALIR");
		menu = in.nextInt();
		
		switch(menu){
			
			case AGREGAR_CARGA:
				addNewLoad();
			break;	
			
			case DESCARGAR_BARCO:
				unloadBoat();
			break;
			
			case PESO_TOTAL_DE_CARGA:
				totalWeightOfLoads();
			break;
			
			case MODIFICAR_CLIENTE:
				modifyClient();
			break;
			
			case EXIT:
				exit();
			break;
		}
	}
	
	/*
	name: addNewLoad
	allows to add a new load
	**/
	public void addNewLoad(){
		int whatClient, numberOfBox, typeBox;
		double totalValue,weigth; 
		
		System.out.println("\nQue cliente desea agregar la carga? (Ingrese el numero)");
		for(int i = 0; i < 5; i++){
			System.out.println("Cliente numero " + (i+1) + " " + ship.getClient()[i].getNameClient());
		}
		whatClient = in.nextInt();
		System.out.println("\nCuantas cajas desea enviar?");
		numberOfBox = in.nextInt();
		System.out.println("\nCual es el peso de una caja en gr (teniendo en cuenta que todas las cajas deben tener el mismo peso)");
		weigth = in.nextDouble()/1000;
		
		if(numberOfBox  >= 2 || weigth >= 12000){
			if( totalWeigth + (weigth * numberOfBox) <= Ship.MAX_WEIGTH){
			System.out.println("Ingrese el tipo de cargas que desea transportar \n (1) carga Dangerous \n (2) carga Perishable \n (3) carga Not Perishable");
			typeBox = in.nextInt();
			if(typeBox == Load.DANGEROUS){
				if(ship.getClient()[whatClient-1].getType().equalsIgnoreCase("platinum")){
					totalValue = ((weigth * numberOfBox) * Load.KG_LOAD_DANGEROUS)-(((weigth * numberOfBox) * Load.KG_LOAD_DANGEROUS)*0.05);
					System.out.println("Obtuvo un descuento del 5% por ser cliente platinum");
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos() + (weigth*numberOfBox)); 
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);

				}else{
					totalValue = (weigth * numberOfBox) * Load.KG_LOAD_DANGEROUS;
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox));  
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos()); 
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
				}
			}else if(typeBox == Load.PERISHABLE){
				if(ship.getClient()[whatClient-1].getType().equalsIgnoreCase("plata")){
					
					totalValue = ((weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE)-(((weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE)*0.015);
					System.out.println("Obtuvo un descuento sorpresa por ser cliente plata del 1,5%");
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox)); 
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}else if(ship.getClient()[whatClient-1].getType().equalsIgnoreCase("oro")){
					
					totalValue = ((weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE)-(((weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE)*0.03);
					System.out.println("Obtuvo un descuento sorpresa por ser cliente oro del 3%");
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox));  
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					ship.addTravel(totalWeigth, totalBox);
					weigth = weigth * numberOfBox;
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}else if(ship.getClient()[whatClient-1].getType().equalsIgnoreCase("platinum")){
					
					totalValue = ((weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE)-(((weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE)*0.05);
					System.out.println("Obtuvo un descuento sorpresa por ser cliente platinum del 5%");
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox)); 
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}else{
					
					totalValue = (weigth * numberOfBox) * Load.KG_LOAD_PERISHABLE;
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox));  
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos()); 
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}
			}else if(typeBox == Load.NOT_PERISHABLE){
				
				if(ship.getClient()[whatClient-1].getType().equalsIgnoreCase("oro")){
					totalValue = ((weigth * numberOfBox) * Load.KG_LOAD_NOT_PERISHABLE)-(((weigth * numberOfBox) * Load.KG_LOAD_NOT_PERISHABLE)*0.03);
					System.out.println("Obtuvo un descuento sorpresa por ser cliente oro del 3%");
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox)); 
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);					
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}else if(ship.getClient()[whatClient-1].getType().equalsIgnoreCase("platinum")){
					totalValue = ((weigth * numberOfBox) * Load.KG_LOAD_NOT_PERISHABLE)-(((weigth * numberOfBox) * Load.KG_LOAD_NOT_PERISHABLE)*0.05);
					System.out.println("Obtuvo un descuento sorpresa por ser cliente platinum del 5%");
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox));  
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}else{
					totalValue = (weigth * numberOfBox) * Load.KG_LOAD_NOT_PERISHABLE;
					ship.getClient()[whatClient-1].setNumberKilos(ship.getClient()[whatClient-1].getNumberKilos()+ (weigth*numberOfBox));  
					ship.getClient()[whatClient-1].setTotalValue(ship.getClient()[whatClient-1].getTotalValue() + totalValue);
					System.out.println("El costo del envio es de " + totalValue);
					System.out.println("La cantidad de peso en kilos acumulado por el cliente numero " + (whatClient) + " llamado " + ship.getClient()[whatClient-1].getNameClient() + " es de: " + ship.getClient()[whatClient-1].getNumberKilos());
					weigth = weigth * numberOfBox;
					totalWeigth += weigth;
					totalBox += numberOfBox;
					ship.addTravel(totalWeigth, totalBox);
					ship.getTravel().get(ship.getTrip()).addLoadTrip(numberOfBox, weigth, typeBox);
					
				}
			}else{
				System.out.println("nada");
			}
			
			System.out.println("Desea hacer otra accion? digite el numero 1 si es asi, de lo contrario presione 2");
			volver = in.nextInt();
			
		}else{
			System.out.println("EL peso de su carga hace que el barco excede su capacidad maxima");
		}
		}else{
			System.out.println("No puede zarpar porque tiene pocas cajas");
		}
	}	
	
	/*
	name:unloadBoat
	allows unload the boat
	**/
	public void unloadBoat(){
		ship.setTrip();
		System.out.println("El barco ha sido descargado");
	}

	/*
	name: totalWeightOfLoads
	allows show the total weight of the loads
	**/
	public void totalWeightOfLoads(){
		int weigthTotal =0;
		for(int i = 0; i < ship.getTravel().get(ship.getTrip()).getLoad().size(); i++){
			weigthTotal += ship.getTravel().get(ship.getTrip()).getLoad().get(i).getWeigth();
		}
		System.out.println("El peso total de el viaje actual es de: " + weigthTotal + " Kg");
	}
	
	/*
	name: modifyClient
	allows modify the client
	**/
	public void modifyClient(){
		System.out.println("Este proceso debe repetirse minimo 3 veces para comprobar si entra al ultimo rango");
		for(int i = 0; i < 5; i++){
			if(ship.getClient()[i].getType().equalsIgnoreCase("normal")){
				if(ship.getClient()[i].getNumberKilos() >= 35000){
					ship.getClient()[i].setType("Plata");
					String c = ship.getClient()[i].getNameClient();
					System.out.println("El cliente " + c + " ascendio a categoria " + ship.getClient()[i].getType());
				}else{
					String c = ship.getClient()[i].getNameClient();
					System.out.println("El cliente " + c + " se mantiene en la misma categoria");
				}
			}else if(ship.getClient()[i].getType().equalsIgnoreCase("plata")){
				if((ship.getClient()[i].getNumberKilos() >= 55000) || ship.getClient()[i].getTotalValue() >= 2000000){
					ship.getClient()[i].setType("Oro");
					String c = ship.getClient()[i].getNameClient();
					System.out.println("El cliente " + c + " ascendio a categoria " + ship.getClient()[i].getType());
				}else{
					String c = ship.getClient()[i].getNameClient();
					System.out.println("El cliente " + c + " se mantiene en la misma categoria");
				}
			}else if(ship.getClient()[i].getType().equalsIgnoreCase("oro")){
				if(ship.getClient()[i].getTotalValue() >= 5000000){
					ship.getClient()[i].setType("Platinum");
					String c = ship.getClient()[i].getNameClient();
					System.out.println("El cliente " + c + " ascendio a categoria " + ship.getClient()[i].getType());
				}else{
					String c = ship.getClient()[i].getNameClient();
					System.out.println("El cliente " + c + " se mantiene en la misma categoria");
				}
			}
		}
	}
	
	/*
	name: exit
	allows exit to the app
	**/
	public void exit(){
		volver = 0;
	}
	
	public void startProgram(){
		informationPrincipal();
		while(volver == 1){
			menu();
		}
			
	}
}
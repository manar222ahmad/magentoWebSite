package myTestcases;

import java.util.Random;

public class Parameters {

	Random rand =new Random();
	
	
	String [] firstNames ={"John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Benjamin", "Isabella"};
	String [] lastNames ={"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};
	String CommonPassword="Asd123!@#$";
	
	
	int randomIndex =rand.nextInt(10);
	int randomEmailId =rand.nextInt(9999);
	String emailID =firstNames[randomIndex]+lastNames[randomIndex]+randomEmailId+"@"+"gmail.com";
	
}

    

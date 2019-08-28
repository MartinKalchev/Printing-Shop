import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class main {

	public static void main(String[] args) throws NotEnoughPaper, IOException {
		Format f1 = Format.A1;
		Format f2 = Format.A2;
		Format f3 = Format.A3;
		Format f4 = Format.A4;
		Format f5 = Format.A5;
		
		Type t1 = Type.GLANCED;
		Type t2 = Type.NORMAL;
		Type t3 = Type.NEWSPAPER;
		
		Employee e1 = Employee.OPERATOR;
		Employee e2 = Employee.OPERATOR;
		Employee e3 = Employee.MANAGER;
		
		
		Publishing book1 = new Publishing("Big Book of Science",200,f3,t2);
		Publishing book2 = new Publishing("Big Book of Fantasy",200,f4,t1);
		Publishing book3 = new Publishing("Book of Folklore",100,f2,t2);
		Publishing book4 = new Publishing("Lord of The Rings",220,f4,t1);
		Publishing newspaper = new Publishing("NY Times",55,f5,t3);
		
		Publisher p1 = new Publisher();
		p1.addPublishing(book1);
		p1.addPublishing(book2);
		p1.addPublishing(book3);
		p1.addPublishing(book4);
		p1.addPublishing(newspaper);
		p1.addEmployee(e1);
		p1.addEmployee(e2);
		p1.addEmployee(e3);
		
		
		File file = new File("file.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		 
		System.out.println("The price of " + book1.getTitle() + " is: " + book1.PaperPrice());
		double b1 = book1.PaperPrice();
		bw.write("The price of " + book1.getTitle()+ " is: " + (int) b1);
		bw.newLine();
		
		System.out.println("The price of " + book2.getTitle() + " is: " + book2.PaperPrice());
		double b2 = book2.PaperPrice();
		bw.write("The price of " + book2.getTitle()+ " is: " + (int) b2);
		bw.newLine();
		
		System.out.println("The price of " + book3.getTitle() + " is: " + book3.PaperPrice());
		double b3 = book3.PaperPrice();
		bw.write("The price of " + book3.getTitle()+ " is: " + (int) b3);
		bw.newLine();
		
		System.out.println("The price of " + book4.getTitle() + " is: " + book4.PaperPrice());
		double b4 = book4.PaperPrice();
		bw.write("The price of " + book4.getTitle()+ " is: " + (int) b4);
		bw.newLine();
		
		System.out.println("The price of" + newspaper.getTitle() + " is: " + newspaper.PaperPrice());
		double nw = newspaper.PaperPrice();
		bw.write("The price of " + newspaper.getTitle() + " is: " + (int) nw);
		bw.newLine();
	
		System.out.println("The total costs of the Publisher is: " + p1.totalCosts());
		double tp = p1.totalCosts();
		bw.write("The total cost is:" + (int) tp);
		bw.newLine();
		
		System.out.println("The revenue of the Publisher is: " + p1.revenue());
		double rev = p1.revenue();
		bw.write("The revenue is:" + (int) rev);
		bw.newLine();
		
		System.out.println("The base salary of the Manager is: " + e3.getBase_sal());
		p1.bonus_sal(.20);
		
		double sal = p1.totalSalCost();
		bw.write("Total salary cost is: " + (int) sal);
		bw.newLine();
		
		
		PrintingMachine machine1 = new PrintingMachine(1000,"Machine 1");
		PrintingMachine machine2 = new PrintingMachine(1000,"Machine 2");
		machine1.setNormal_paper(true);
		machine2.setColored_paper(false);
		machine1.setCurrentNumPaper(1000);
		machine2.setCurrentNumPaper(800);
		
		machine1.addPublishings(book1);
		machine1.addPublishings(book2);
		machine1.addPublishings(newspaper);
		machine2.addPublishings(book3);
		machine2.addPublishings(book4);
		
		System.out.println();
		System.out.println("Start of publishing!!!");
		System.out.println();
		
		p1.addMachines(machine1);
		p1.addMachines(machine2);
	    p1.publish();
	
	    System.out.println();
	    
		bw.close();

		 File readfile = 
			      new File("file.txt"); 
			    Scanner sc = new Scanner(file); 
			  
			    while (sc.hasNextLine()) 
			      System.out.println(sc.nextLine());
			    
			    sc.close();
	}

}

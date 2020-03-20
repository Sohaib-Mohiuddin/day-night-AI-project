package daynight;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DayNight {
	
	
	private static void removeCommas() throws FileNotFoundException {
		Scanner input = new Scanner(new File("test.txt"));
        while (input.hasNext()) { // Input == people.txt
        	String line = input.nextLine().replace(",", "");
            System.out.println(line);
        }
    }

	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		removeCommas();
		File file = new File("test.txt"); 
		Scanner scanner = new Scanner(file);
		//Scanner scanner = new Scanner(System.in);
		ArrayList<Integer>  pixels = new ArrayList<Integer>();
		

		while (scanner.hasNext()) {
		    if (scanner.hasNextInt()) {
		        pixels.add(scanner.nextInt());
		    } else {
		        scanner.next();
		    }
		}
		System.out.println(pixels.size());
		process(pixels);
		
	}
	
	private static void process(ArrayList<Integer> pixels) {
		Iterator<Integer> itr =  pixels.iterator(); 
		double average, sum = 0;
		int count = 0;
		while(itr.hasNext()){
			double brightness=brightness(itr.next(), itr.next(), itr.next());
			System.out.println(brightness);
			count++;
			sum+=brightness;
		}
		average =sum/count;
		System.out.println("sum "+ sum +", count " +count+",average "+average);
		if(average<0.5) {
			System.out.println("night");
		}
		else{
			System.out.println("day");
		}
		
	}

	private static double brightness(Integer R, Integer G, Integer B) {
		//Y = 0.2126 R + 0.7152 G + 0.0722 B
		double r=R/255;
		double g=G/255;
		double b=B/255;
		double brightness=b*0.2126+r*0.7152+g*0.0722;
		return brightness;
	}
}

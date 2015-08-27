package app;

import java.util.Locale;
import java.util.Scanner;

public class UnitConversionApp {
	
	public static Scanner scanner;
	public static double value;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		System.out.print("Vilken sorts enheter vill du konvertera mellan? 1) Temperatur, 2) Längd, 3) Vikt: ");
		int conversionType = scanner.nextInt();
		chooseConversionProgram(conversionType);
		

	}
	
	public static void chooseConversionProgram(int conversionType){
		switch(conversionType) {
		case 1 :
			temperatureConversionProgram();
			break;
		case 2 :
			lengthConversionProgram();
			break;
		case 3 :
			break;
		}
	}
	
	public static void temperatureConversionProgram(){
		System.out.print("Vad vill du konvertera FRÅN? 1) celcius, 2) farenheit, 3) kelvin : ");
		
		int from = scanner.nextInt();
		
		System.out.print("Vad vill du konvertera TILL? 1) celcius, 2) farenheit, 3) kelvin : ");
		int to = scanner.nextInt();
		
		
		System.out.print("Ange värdet som ska konverteras (" + chosenTempScale(from) + "): ");
		value = scanner.nextDouble();
		
		// trivial conversion
		if(from == to){
			System.out.printf(Locale.US, "Temperaturen blir %.2f grader %s", value, chosenTempScale(to));
		}
		
		// 
		int celcius = 1;
		int farenheit = 2;
		int kelvin = 3;
		
		if(from == celcius){
			if(to == farenheit){
				printTempAnswer(value, from, celciusToFarenheit(value), to);
			} else if (to == kelvin){
				printTempAnswer(value, from, celciusToKelvin(value), to);	
			}
		} else if(from == farenheit){
			if(to == celcius){
				printTempAnswer(value, from, farenheitToCelcius(value), to);
			} else if(to == kelvin){
				printTempAnswer(value, from, farenheitToKelvin(value), to);
			}
		} else if(from == kelvin){
			if(to == celcius){
				printTempAnswer(value, from, kelvinToCelcius(value), to);
			} else if(to == farenheit){
				printTempAnswer(value, from, kelvinToFarenheit(value), to);
			}
		}
	}
	

	public static String chosenTempScale(int optionValue){
		switch(optionValue){
		case 1:
			return "Celcius";
		case 2: 
			return "Farenheit";
		case 3: 
			return "Kelvin";
		default:
			return "!!! något gick fel i val av tempratur !!";
		
		}
	}
	
	private static double celciusToFarenheit(double value) {
		// [°F] = [°C] × 9⁄5 + 32
		return value * 9/5 + 32;
	}
	
	private static double celciusToKelvin(double value) {
		// [K] = [°C] + 273.15
		return value + 273.15;
	}
	
	private static double farenheitToCelcius(double value) {
		// [°C] = ([°F] − 32) × 5⁄9
		return (value - 32) * 5/9;
	}
	
	private static double farenheitToKelvin(double value) {
		// [°C] = ([°F] − 32) × 5⁄9
		double celcius = farenheitToCelcius(value);
		return celciusToKelvin(celcius);
	}
	
	private static double kelvinToCelcius(double value) {
		return value - 273.15;
	}
	
	private static double kelvinToFarenheit(double value) {
		double celcius = farenheitToCelcius(value);
		return celcius - 273.15;
	}
	
	
	private static void printTempAnswer(double origValue, int from, double convertedValue, int to){
		System.out.printf(	Locale.US, "%.2f grader %s blir %.2f grader %s.",
				origValue,
				chosenTempScale(from),
				convertedValue,
				chosenTempScale(to)
				);
	}
	
	public static void lengthConversionProgram(){
		System.out.print("Vad vill du konvertera FRÅN? 1) meter, 2) fot/foot, 3) tum/inch : ");
		
		int from = scanner.nextInt();
		
		System.out.print("Vad vill du konvertera TILL? 1) meter, 2) fot/foot, 3) tum/inch : ");
		int to = scanner.nextInt();
		
		
		System.out.print("Ange värdet som ska konverteras (" + chosenLengthScale(from) + "): ");
		value = scanner.nextDouble();
		
		// trivial conversion
		if(from == to){
			System.out.printf(Locale.US, "Temperaturen blir %.2f grader %s", value, chosenLengthScale(to));
		}
		
		// 
		int meter = 1;
		int foot = 2;
		int inch = 3;
		
		if(from == meter){
			if(to == foot){
				printLengthAnswer(value, from, meterToFoot(value), to);
			} else if (to == inch){
				printLengthAnswer(value, from, meterToInch(value), to);	
			}
		} else if(from == foot){
			if(to == meter){
				printLengthAnswer(value, from, footToMeter(value), to);
			} else if(to == inch){
				printLengthAnswer(value, from, footToInch(value), to);
			}
		} else if(from == inch){
			if(to == meter){
				printLengthAnswer(value, from, inchToMeter(value), to);
			} else if(to == foot){
				printLengthAnswer(value, from, inchToFoot(value), to);
			}
		}
	}
	
	public static String chosenLengthScale(int optionValue){
		switch(optionValue){
		case 1:
			return "meter";
		case 2: 
			return "fot/foot";
		case 3: 
			return "tum/inch";
		default:
			return "!!! något gick fel i val av längdenhet !!";
		
		}
	}
	
	private static double meterToFoot(double value) {
		return value * 3.28084;
	}
	
	private static double meterToInch(double value) {
		return value * 39.3701;
	}
	
	private static double footToMeter(double value) {
		return value * 0.3048;
	}
	
	private static double footToInch(double value) {

		return value * 12;
	}
	
	private static double inchToMeter(double value) {
		return value * 0.0254;
	}
	
	private static double inchToFoot(double value) {
		return value * 0.0833333;
	}
	
	private static void printLengthAnswer(double origValue, int from, double convertedValue, int to){
		System.out.printf(	Locale.US, "%.2f %s blir %.2f %s.",
				origValue,
				chosenLengthScale(from),
				convertedValue,
				chosenLengthScale(to)
				);
	}

}

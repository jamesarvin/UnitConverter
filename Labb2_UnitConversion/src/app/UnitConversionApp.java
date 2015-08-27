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

}

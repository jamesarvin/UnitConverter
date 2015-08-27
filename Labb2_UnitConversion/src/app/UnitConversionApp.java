package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UnitConversionApp {
	
	public static Scanner scanner;
	// public static double value;
	public static int chosenConversionProgram; // stores the first choice (what type of conversion user wanted)

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		
		boolean keepGoing = true;
		while(keepGoing){
		
		System.out.print("\nVilken sorts enheter vill du konvertera mellan? 1) Temperatur, 2) Längd, 3) Vikt: ");
		// save this choice where is is easily accessed for all methods that could need it
		chosenConversionProgram = scanner.nextInt();
		// chooseConversionProgram(chosenConversionProgram);
		
		// run program
		askForAndGetOptionValues();
		
		// after running once, ask if user wants to continue
		System.out.print("\n\nVill du fortsätta med en ny konvertering? 1) Ja, 2) Nej : ");
		keepGoing = scanner.nextInt() == 1 ? true : false;
		}
		
		// finish up
		scanner.close();
		System.out.println("\nBye bye! Välkommen åter!");
		
	}
	
	
	/*
	 * Methods making up a general program that should work for any of the supported types of conversions
	 * 
	 */
	
	
	private static void askForAndGetOptionValues(){
		String optionMessageFROM = "Vad vill du konvertera FRÅN? ";
		String optionMessageTO = "Vad vill du konvertera TILL? ";
		switch(chosenConversionProgram){
		// temperature
		case 1: 
			optionMessageFROM += "1) celcius, 2) farenheit, 3) kelvin :";
			optionMessageTO += "1) celcius, 2) farenheit, 3) kelvin :";
			break;
		// length
		case 2:
			optionMessageFROM += "1) meter, 2) fot/foot, 3) tum/inch :";
			optionMessageTO += "1) meter, 2) fot/foot, 3) tum/inch :";
			break;
		case 3:
			optionMessageFROM += "1) kg, 2) pound, 3) ounce :";
			optionMessageTO += "1) kg, 2) pound, 3) ounce :";
			break;
		}
		
		
		// get the FROM option
		System.out.println(optionMessageFROM);
		int from = scanner.nextInt();
		// get the TO option
		System.out.println(optionMessageTO);
		int to = scanner.nextInt();
		
		// launch rest of program
		conversionProgram(from, to);		
	}

	
	private static void conversionProgram(int from, int to){
		
		System.out.print("Ange värdet som ska konverteras (" + getChosenUnitAsString(from) + "): ");
		double value = scanner.nextDouble();
		
		// trivial conversion
		if(from == to){
			switch(chosenConversionProgram){
			// temperature
			case 1 :
				System.out.printf(Locale.US, "Temperaturen blir %.2f grader %s", value, getChosenUnitAsString(to));
				break;
			case 2 :
				System.out.printf(Locale.US, "Längden blir %.2f grader %s", value, getChosenUnitAsString(to));
				break;
			case 3 :
				System.out.printf(Locale.US, "Vikten blir %.2f grader %s", value, getChosenUnitAsString(to));
				break;
			}
		}
		
		// named integers for code readability in if-statements
		
		// temperature
		int celcius = 1;
		int farenheit = 2;
		int kelvin = 3;
		
		// length 
		int meter = 1;
		int foot = 2;
		int inch = 3;
		
		// weight
		int kg = 1;
		int pound = 2;
		int ounce = 3;
		
		// options
		int temprature = 1;
		int length = 2;
		int weight = 3;
		
		// from == 1
		if(from == celcius || from == meter || from == kg){
			
			// to == 2
			if(to == farenheit || to == foot || to == pound){
				// temperature  c -> f
				if(chosenConversionProgram == temprature)
					printAnswer(value, from, celciusToFarenheit(value), to);
				// length  m -> foot
				else if(chosenConversionProgram == length)
					printAnswer(value, from, meterToFoot(value), to);
				// weight  kg -> pound
				else if(chosenConversionProgram == weight)
					printAnswer(value, from, kgToPound(value), to);
					
			// to == 3	
			} else if (to == kelvin || to == inch || to == ounce){
				// temperature c -> K
				if(chosenConversionProgram == temprature)
					printAnswer(value, from, celciusToKelvin(value), to);
				// length  m -> foot
				else if(chosenConversionProgram == length)
					printAnswer(value, from, meterToInch(value), to);
				// weight  kg -> pound
				else if(chosenConversionProgram == weight)
					printAnswer(value, from, kgToOunce(value), to);
				}
			}
		
		// from == 2 
		else if(from == farenheit || from == foot || from == pound){
				
			// to == 1
			if(to == celcius || to == meter || to == kg){
				// temperature  f -> c 
				if(chosenConversionProgram == temprature)
					printAnswer(value, from, farenheitToCelcius(value), to);
				// length  foot -> meter
				else if(chosenConversionProgram == length)
					printAnswer(value, from, footToMeter(value), to);
				// weight pound -> kg
				else if(chosenConversionProgram == weight)
					printAnswer(value, from, poundToKg(value), to);

			// to == 3	
			} else if (to == kelvin || to == inch || to == ounce){
				// temperature f -> K
				if(chosenConversionProgram == temprature)
					printAnswer(value, from, farenheitToKelvin(value), to);
				// length  foot -> inch
				else if(chosenConversionProgram == length)
					printAnswer(value, from, footToInch(value), to);
				// weight  pound -> ounce
				else if(chosenConversionProgram == weight)
					printAnswer(value, from, poundToOunce(value), to);
			}
		}
		// from == 3 
		else if(from == kelvin || from == inch || from == ounce){
				
			// to == 1
			if(to == celcius || to == meter || to == kg){
				// temperature  k -> c 
				if(chosenConversionProgram == temprature)
					printAnswer(value, from, kelvinToCelcius(value), to);
				// length  inch -> meter
				else if(chosenConversionProgram == length)
					printAnswer(value, from, inchToMeter(value), to);
				// weight ounce -> kg
				else if(chosenConversionProgram == weight)
					printAnswer(value, from, ounceToKg(value), to);

			// to == 2	
			} else if (to == farenheit || to == foot || to == pound){
				// temperature k -> f 
				if(chosenConversionProgram == temprature)
					printAnswer(value, from, kelvinToFarenheit(value), to);
				// length  inch -> foot
				else if(chosenConversionProgram == length)
					printAnswer(value, from, inchToFoot(value), to);
				// weight  ounce -> pound
				else if(chosenConversionProgram == weight)
					printAnswer(value, from, ounceToPound(value), to);
			}
		}
		
	}
	
	public static String getChosenUnitAsString(int optionValue){
		
		List<String> stringOptions = new ArrayList<String>();
		
		// populate list with different values, depending on what type of conversion user has chosen
		switch(chosenConversionProgram){
		// temperature
		case 1:
			stringOptions.addAll(Arrays.asList("Celcius", "Farenheit", "Kelvin"));
			break;
		// length
		case 2:
			stringOptions.addAll(Arrays.asList("meter", "fot/foot", "tum/inch"));
			break;
		// weight
		case 3:
			stringOptions.addAll(Arrays.asList("kg", "pound", "ounce"));
			break;
		}
		
		optionValue--; // so that choice 1 -> index 0
		
		return stringOptions.get(optionValue);
	}
	
	private static void printAnswer(double origValue, int from, double convertedValue, int to){
		System.out.printf(	Locale.US, 
							"%.2f %s blir %.2f %s.",
							origValue,
							getChosenUnitAsString(from),
							convertedValue,
							getChosenUnitAsString(to)
							);
	}
	
	/*
	 * 
	 * Conversion methods 
	 * 
	 */
	
	// Temperature 
	
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
		double celcius = farenheitToCelcius(value);
		return celciusToKelvin(celcius);
	}
	
	private static double kelvinToCelcius(double value) {
		return value - 273.15;
	}
	
	private static double kelvinToFarenheit(double value) {
		double celcius = kelvinToCelcius(value);
		return celciusToFarenheit(celcius);
	}
	
	// Length
	
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
	
	// Weight
	
	private static double kgToPound(double value){
		return value * 2.20462;
	}
	private static double kgToOunce(double value){
		return value * 35.274;
	}
	private static double poundToKg(double value){
		return value * 0.453592;
	}
	private static double poundToOunce(double value){
		return value * 16;
	}
	private static double ounceToKg(double value){
		return value * 0.0283495;
	}
	private static double ounceToPound(double value){
		return value * 0.0625;
	}
	
	
	
	
	
}

package project4;

import java.util.Scanner;

class ConversionCalculator{
    private char fromSelection;
    private double fromData, toData;
    private final Scanner scanner;
    ConversionCalculator(Scanner scanner){
        this.scanner = scanner;
    }
    public void getFromSelection(){
        while (true){
            try{
                System.out.print("Select what you want to convert: Meters (M) / Kilograms (K) / Liters (L): ");
                String input = scanner.nextLine().trim().toLowerCase();
                if(input.isEmpty()) {
                    throw new Exception();
                }
                fromSelection = input.charAt(0);
                if(!(fromSelection == 'm' || fromSelection == 'k' || fromSelection == 'l')) throw new Exception();
                break;
            } catch (Exception e){
                System.out.println("Invalid input, Try again");
            }
        }
    }
    public void getFromData(){
        while (true){
            try{
                if(fromSelection == 'm'){
                    System.out.print("Kindly provide meters to convert: ");
                } else if (fromSelection == 'k') {
                    System.out.print("Kindly provide kilograms to convert: ");
                } else if (fromSelection == 'l'){
                    System.out.print("Kindly provide liters to convert: ");
                }
                String input = scanner.nextLine().trim();

                // Instantly catch empty Enter presses
                if (input.isEmpty()) {
                    throw new Exception("Input cannot be empty.");
                }
                fromData = Double.parseDouble(input);
                break;
            } catch (Exception e){
                System.out.println("Invalid input, Try again");
            }
        }
    }
    public void calculateConversion(){
        if(fromSelection == 'm') {
            toData = fromData * 3.28084;
            System.out.printf("%.2f meters is equal to %.2f feet %n",fromData,toData);
        }
        else if (fromSelection == 'k') {
            toData = fromData * 2.20462;
            System.out.printf("%.2f kilograms is equal to %.2f pounds %n",fromData,toData);
        }
        else if (fromSelection == 'l') {
            toData = fromData * 0.264172;
            System.out.printf("%.2f liters is equal to %.2f gallons %n",fromData,toData);
        }
    }
    public void run(){
        getFromSelection();
        getFromData();
        calculateConversion();
    }
}
public class UnitConverter {
    static {
            System.out.println("===== Day4 - Unit Converter =====\n");
    }
    public static void main(String[] args){
        System.out.println("Conversion of physical units like meters to feet,kilograms to pounds and liters to gallons.");

        // Import scanner to read user input
        Scanner scanner = new Scanner(System.in);

        ConversionCalculator converter = new ConversionCalculator(scanner);
        converter.run();

        scanner.close();
    }

}

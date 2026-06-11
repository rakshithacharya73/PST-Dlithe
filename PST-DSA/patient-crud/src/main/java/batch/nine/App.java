package batch.nine;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        API api = new API();
        System.out.println("---------Welcome to Nitte Hospital-------");
        while(true){
            System.out.println("1. Admit\n2. Records\n3. Update\n4. Discharge\nAny to exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: 
                        // insert new patient
                        System.out.println("enter the name "); 
                        String name = scanner.next();
                        System.out.println("Gender "); 
                        String gender = scanner.next();
                        System.out.println("Age "); 
                        int age = scanner.nextInt();
                        System.out.println("Height in CM ");
                        double height = scanner.nextDouble();
                        System.out.println("Weight ");
                        double weight = scanner.nextDouble();
                        api.insertRecord(name, gender, age, height, weight);
                    break;
                case 2: api.findAll(); break;
                case 3: 
                        System.out.println("Enter id");
                        int id = scanner.nextInt();
                        System.out.println("Enter the weight ");
                        weight = scanner.nextDouble();
                        api.updateTable(id, weight);
                    break;
                case 4: 
                        System.out.println("Enter id");
                        id = scanner.nextInt();
                        api.deleteById(id);
                    break;
                default: return;
            }
        }
    }
}

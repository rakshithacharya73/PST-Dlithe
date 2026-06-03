import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger(demo.class.getName());
        String[] recruiters = { "Google", "Dlithe", "Accenture", "Cognizant", "ZOHO" };

        int day = 0;
        try {
            System.out.println("Enter the date to get name of company");
            day = sc.nextInt();
            day--;
            logger.info("Requested day " + day);
            System.out.println(recruiters[day]);
            // KYC kyc= KYC.getkyc();
            // kyc.name="rakshith";
            // kyc.contact=79755481555l;}

        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            //e.printStackTrace();
            Scanner t=new Scanner(System.in);
            System.out.println("day must be between 1 and  " + recruiters.length); // day -- if 0 that will -1
            logger.severe(e.toString());
            day = t.nextInt();
            day--;
            logger.info("Requested day " + day);
            System.out.println(recruiters[day]);
        } 
        catch (Exception e){
        
        }
        /*
           * catch (InputMismatchException e) {
           * e.printStackTrace();
           * }
           */
        finally {

        }
    }
}

class KYC {
    String name;
    long contact;
    private static KYC kyc = new KYC();

    public static KYC getkyc() {

        return kyc;
    }

    private KYC() {

    }
}

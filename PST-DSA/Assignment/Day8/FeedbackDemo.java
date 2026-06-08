import java.io.*;
import java.util.*;

public class FeedbackDemo {

    public static void main(String[] args) {

        String fileName = "feedbacks.dat";

        // Store at least 3 feedback objects
        List<Feedback> feedbackList = new ArrayList<>();

        feedbackList.add(new Feedback(
                "Ramesh",
                "B101",
                "4AL22CS001",
                4.5,
                "Excellent teaching"));

        feedbackList.add(new Feedback(
                "Suresh",
                "B102",
                "4AL22CS002",
                4.0,
                "Good explanation"));

        feedbackList.add(new Feedback(
                "Mahesh",
                "B103",
                "4AL22CS003",
                5.0,
                "Very interactive sessions"));

        // Serialize list into file
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(feedbackList);
            System.out.println("Feedbacks stored successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read feedback by USN
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Student USN: ");
        String searchUsn = sc.nextLine();

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Feedback> list =
                    (List<Feedback>) ois.readObject();

            boolean found = false;

            for (Feedback f : list) {
                if (f.getStudentUsn().equalsIgnoreCase(searchUsn)) {
                    System.out.println("\nFeedback Found:");
                    System.out.println(f);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No feedback found for USN: " + searchUsn);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
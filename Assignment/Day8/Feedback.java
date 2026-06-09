package Assignment.Day8;
/*

Serialized POJO Class: Feedback contains properties of trainerName(String), batchId(String), studentUsn(String), rating(double), comments(String) perform followings:
1.store atleast 3 feedbacks objects as list into file
2.read feedbacks by usn
 */
import java.io.Serializable;

public class Feedback implements Serializable {
    private String trainerName;
    private String batchId;
    private String studentUsn;
    private double rating;
    private String comments;

    public Feedback(String trainerName, String batchId, String studentUsn,
                    double rating, String comments) {
        this.trainerName = trainerName;
        this.batchId = batchId;
        this.studentUsn = studentUsn;
        this.rating = rating;
        this.comments = comments;
    }

    public String getStudentUsn() {
        return studentUsn;
    }

    @Override
    public String toString() {
        return "Trainer Name: " + trainerName +
                "\nBatch ID: " + batchId +
                "\nStudent USN: " + studentUsn +
                "\nRating: " + rating +
                "\nComments: " + comments;
    }
}
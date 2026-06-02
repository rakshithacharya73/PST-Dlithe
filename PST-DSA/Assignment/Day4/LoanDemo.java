/*
Problem Statement: Loan Application Management System Context:
A small financial institution wants to build a simple Java application to manage loan applications. Each applicant can apply for multiple loans, view their current loans, and cancel them if needed. The system should be modular, using abstract classes and overriding to enforce a contract while allowing flexibility in implementation.
Requirements: Create an abstract class LoanRemote that declares the following abstract methods: applyLoan(int applicantId, String loanType) viewLoan(int applicantId) cancelLoan(int applicantId)

Additionally, include a concrete helper method log(String message) to print system logs. Implement a concrete subclass LoanService that overrides all abstract methods. Use a 2D array (String[][] loans) to store loan applications. Rows represent applicants. Columns represent loan slots for each applicant. applyLoan should add a loan type to the applicant’s record if space is available.

viewLoan should display all loans for a given applicant. cancelLoan should clear all loans for a given applicant. Create a driver class LoanDemo with a main method to test the functionality. Apply multiple loans for different applicants. View loans before and after cancellation. Demonstrate system logs printed by the helper method.

Expected Output (Sample Run): Loan applied: Personal Loan for applicant 0 Loan applied: Business Loan for applicant 0 Loan applied: Education Loan for applicant 1 Applicant 0 loans: [Personal Loan, Business Loan] Loans cancelled for applicant 0 Applicant 0 loans: [null, null]
*/
package Assignment.Day4;


package Assignment.Day4;

import java.util.Arrays;

abstract class LoanRemote {

    abstract void applyLoan(int applicantId, String loanType);

    abstract void viewLoan(int applicantId);

    abstract void cancelLoan(int applicantId);

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class LoanService extends LoanRemote {

    private String[][] loans;

    public LoanService(int applicants, int maxLoans) {
        loans = new String[applicants][maxLoans];
    }

    @Override
    public void applyLoan(int applicantId, String loanType) {
        for (int i = 0; i < loans[applicantId].length; i++) {
            if (loans[applicantId][i] == null) {
                loans[applicantId][i] = loanType;
                log("Loan applied: " + loanType + " for applicant " + applicantId);
                return;
            }
        }
        log("No loan slot available for applicant " + applicantId);
    }

    @Override
    public void viewLoan(int applicantId) {
        System.out.println("Applicant " + applicantId + " loans: "
                + Arrays.toString(loans[applicantId]));
    }

    @Override
    public void cancelLoan(int applicantId) {
        for (int i = 0; i < loans[applicantId].length; i++) {
            loans[applicantId][i] = null;
        }
        log("Loans cancelled for applicant " + applicantId);
    }
}

public class LoanDemo {
    public static void main(String[] args) {

        LoanService service = new LoanService(5, 3);

        service.applyLoan(0, "Personal Loan");
        service.applyLoan(0, "Business Loan");
        service.applyLoan(1, "Education Loan");

        System.out.println();

        service.viewLoan(0);
        service.viewLoan(1);

        System.out.println();

        service.cancelLoan(0);

        System.out.println();

        service.viewLoan(0);
        service.viewLoan(1);
    }
}
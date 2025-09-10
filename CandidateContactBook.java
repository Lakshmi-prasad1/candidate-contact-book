import java.util.ArrayList;
import java.util.Scanner;

class Candidate {
    String name;
    String email;
    String phone;

    Candidate(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}

public class CandidateContactBook {
    static ArrayList<Candidate> candidates = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Candidate Contact Book ---");
            System.out.println("1. Add Candidate");
            System.out.println("2. View All");
            System.out.println("3. Search Candidate");
            System.out.println("4. Delete Candidate");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addCandidate(); break;
                case 2: viewAll(); break;
                case 3: searchCandidate(); break;
                case 4: deleteCandidate(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addCandidate() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        candidates.add(new Candidate(name, email, phone));
        System.out.println("Candidate added successfully!");
    }

    static void viewAll() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates found.");
            return;
        }
        for (Candidate c : candidates) {
            System.out.println(c);
        }
    }

    static void searchCandidate() {
        System.out.print("Enter name/email to search: ");
        String keyword = sc.nextLine().toLowerCase();
        for (Candidate c : candidates) {
            if (c.name.toLowerCase().contains(keyword) || c.email.toLowerCase().contains(keyword)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Candidate not found.");
    }

    static void deleteCandidate() {
        System.out.print("Enter name/email to delete: ");
        String keyword = sc.nextLine().toLowerCase();
        for (Candidate c : candidates) {
            if (c.name.toLowerCase().contains(keyword) || c.email.toLowerCase().contains(keyword)) {
                candidates.remove(c);
                System.out.println("Candidate deleted!");
                return;
            }
        }
        System.out.println("Candidate not found.");
    }
}

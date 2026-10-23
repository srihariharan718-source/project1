import java.util.ArrayList;
import java.util.Scanner;

class Project {
    int id;
    String name;
    String client;
    double amount;
    String paymentStatus;

    Project(int id, String name, String client, double amount) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    void display() {
        System.out.println("Project ID: " + id);
        System.out.println("Project Name: " + name);
        System.out.println("Client Name: " + client);
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("---------------------------");
    }
}

public class FreelancerSystem {
    static ArrayList<Project> projects = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    static void addProject() {
        System.out.print("Enter project name: ");
        String name = sc.nextLine();

        System.out.print("Enter client name: ");
        String client = sc.nextLine();

        System.out.print("Enter project amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return;
        }

        Project p = new Project(nextId++, name, client, amount);
        projects.add(p);

        System.out.println("Project added successfully!");
    }

    static void viewProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }

        for (Project p : projects) {
            p.display();
        }
    }

    static void updatePayment() {
        System.out.print("Enter project ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Project p : projects) {
            if (p.id == id) {
                System.out.println("1. Pending");
                System.out.println("2. Paid");
                System.out.print("Choose payment status: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    p.paymentStatus = "Pending";
                } else if (choice == 2) {
                    p.paymentStatus = "Paid";
                } else {
                    System.out.println("Invalid choice.");
                    return;
                }

                System.out.println("Payment status updated!");
                return;
            }
        }

        System.out.println("Project ID not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== FREELANCER PROJECT SYSTEM ===");
            System.out.println("1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("3. Update Payment Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addProject();
                    break;

                case 2:
                    viewProjects();
                    break;

                case 3:
                    updatePayment();
                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}

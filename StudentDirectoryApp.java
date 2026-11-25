import java.util.Scanner;

class StudentDirectory {

    // Node of Linked List
    class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // 1. Add Student
    void addStudent(Student s) {

        if (search(s.rollNo) != null) {
            System.out.println("Roll number already exists!");
            return;
        }

        Node newNode = new Node(s);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student added successfully!");
    }

    // 2. Display All Students
    void displayStudents() {

        if (head == null) {
            System.out.println("No student records found!");
            return;
        }

        Node temp = head;

        System.out.println("\n===== STUDENT RECORDS =====");

        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // 3. Search Student
    Student search(int rollNo) {

        Node temp = head;

        while (temp != null) {

            if (temp.data.rollNo == rollNo) {
                return temp.data;
            }

            temp = temp.next;
        }

        return null;
    }

    // 4. Update Student
    void updateStudent(int rollNo,
                       String phone, String email) {

        Student s = search(rollNo);

        if (s == null) {
            System.out.println("Student not found!");
        } else {

            s.phone = phone;
            s.email = email;

            System.out.println("Student updated successfully!");
        }
    }

    // 5. Delete Student
    void deleteStudent(int rollNo) {

        if (head == null) {
            System.out.println("Directory is empty!");
            return;
        }

        if (head.data.rollNo == rollNo) {

            head = head.next;

            System.out.println("Student deleted successfully!");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               temp.next.data.rollNo != rollNo) {

            temp = temp.next;
        }

        if (temp.next == null) {

            System.out.println("Student not found!");

        } else {

            temp.next = temp.next.next;

            System.out.println("Student deleted successfully!");
        }
    }

    // 6. Sort Students by Name
    void sortStudents() {

        if (head == null || head.next == null) {
            System.out.println("Not enough records to sort!");
            return;
        }

        for (Node i = head; i.next != null; i = i.next) {

            for (Node j = head; j.next != null; j = j.next) {

                if (j.data.name.compareToIgnoreCase(
                    j.next.data.name) > 0) {

                    Student temp = j.data;

                    j.data = j.next.data;

                    j.next.data = temp;
                }
            }
        }

        System.out.println("Students sorted alphabetically!");
    }
}

// Main Class
public class StudentDirectoryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDirectory directory = new StudentDirectory();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("    STUDENT CONTACT DIRECTORY");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // Add
                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Student s = new Student(
                        roll, name, phone, email
                    );

                    directory.addStudent(s);

                    break;

                // Display
                case 2:

                    directory.displayStudents();

                    break;

                // Search
                case 3:

                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();

                    Student found = directory.search(roll);

                    if (found != null) {

                        System.out.println("\nStudent Found!");
                        found.display();

                    } else {

                        System.out.println("Student not found!");
                    }

                    break;

                // Update
                case 4:

                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    phone = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    email = sc.nextLine();

                    directory.updateStudent(roll, phone, email);

                    break;

                // Delete
                case 5:

                    System.out.print("Enter Roll Number: ");
                    roll = sc.nextInt();

                    directory.deleteStudent(roll);

                    break;

                // Sort
                case 6:

                    directory.sortStudents();

                    break;

                // Exit
                case 7:

                    System.out.println("Thank you for using Student Directory!");

                    break;

                default:

                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}

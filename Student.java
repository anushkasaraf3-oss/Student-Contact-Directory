public class Student {

    int rollNo;
    String name;
    String phone;
    String email;

    // Constructor
    public Student(int rollNo, String name,
                   String phone, String email) {

        this.rollNo = rollNo;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Display student details
    public void display() {

        System.out.println("----------------------------");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Phone       : " + phone);
        System.out.println("Email       : " + email);
        System.out.println("----------------------------");
    }
}

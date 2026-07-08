import java.util.Scanner;

class Doctor {
    int id;
    String name;

    Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Appointment {
    Doctor doctor;
    Patient patient;
    String time;
    String status;

    Appointment(Doctor doctor, Patient patient, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
        status = "Booked";
    }
}

public class HospitalAppointmentBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Doctor[] doctors = {
                new Doctor(1, "Dr. Sharma"),
                new Doctor(2, "Dr. Mehta")
        };

        Patient[] patients = {
                new Patient(1, "Rahul"),
                new Patient(2, "Priya")
        };

        Appointment[] appointments = new Appointment[10];
        int count = 0;

        int choice;

        do {
            System.out.println("\n1. Book Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. Show Appointments");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Doctor ID: ");
                int doctorId = sc.nextInt();

                System.out.print("Patient ID: ");
                int patientId = sc.nextInt();

                sc.nextLine();

                System.out.print("Time Slot: ");
                String slot = sc.nextLine();

                boolean available = true;

                for (int i = 0; i < count; i++) {
                    if (appointments[i].doctor.id == doctorId
                            && appointments[i].time.equals(slot)
                            && appointments[i].status.equals("Booked")) {
                        available = false;
                    }
                }

                if (available) {
                    appointments[count] = new Appointment(doctors[doctorId - 1],
                            patients[patientId - 1],
                            slot);

                    count++;
                    System.out.println("Appointment booked.");
                } else {
                    System.out.println("Slot already booked.");
                }
            }

            else if (choice == 2) {

                System.out.print("Doctor ID: ");
                int doctorId = sc.nextInt();

                sc.nextLine();

                System.out.print("Time Slot: ");
                String slot = sc.nextLine();

                for (int i = 0; i < count; i++) {
                    if (appointments[i].doctor.id == doctorId
                            && appointments[i].time.equals(slot)) {

                        appointments[i].status = "Cancelled";
                    }
                }

                System.out.println("Appointment cancelled.");
            }

            else if (choice == 3) {

                for (int i = 0; i < count; i++) {

                    System.out.println("\nDoctor: "
                            + appointments[i].doctor.name);

                    System.out.println("Patient: "
                            + appointments[i].patient.name);

                    System.out.println("Time: "
                            + appointments[i].time);

                    System.out.println("Status: "
                            + appointments[i].status);
                }
            }

        } while (choice != 4);

        sc.close();
    }
}

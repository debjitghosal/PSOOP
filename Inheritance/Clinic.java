/*
Give the definition of four classes, Person, Doctor, Patient and Billing, whose objects are records for a clinic. 
Class Doctor will be derived from the class Person. A doctor have name and Date  (inherited from the class Person), it’s speciality; fees and income;
Patient will be derived from the class Person. A Patient record has the patient’s name and Date  (inherited from the class Person) and a Doctor object.
A Billing object will contain a Patient object, a Doctor object, Date of bill using date object and an amount due of type double. Be sure your classes have a reasonable complement of constructors, copy constructor, override equals(check equality of object)  and toString methods and member functions. 
First write a driver program to test all your member functions, and then write a test program that creates at least two patients, at least two doctors, and at least two Billing records, then prints out the total income from the Billing records.
At the time of Billing the Patient’s Doctor  name and Billing object’s doctor name equality should be checked.
Total bill generated will be no of days the patient admitted ( current date-admitted date ) * 2000+ doctore fees * no of days from the date of billing ( current date-admitted date ).
Update the Doctors income to no of days from the date of billing ( current date-admitted date ).
*/

import java.util.*;

class Person {
    String name;
    Date date; //joining date

    public Person(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}

class Doctor extends Person {
    String speciality;
    double fees;
    double income;

    public Doctor(String name, Date date, String speciality, double fees, double income) {
        super(name, date);
        this.speciality = speciality;
        this.fees = fees;
        this.income = income;
    }
}

class Patient extends Person {
    Doctor doctor;

    public Patient(String name, Date date, Doctor doctor) {
        super(name, date);
        this.doctor = doctor;
    }
}

class Billing {
    Patient patient;
    Doctor doctor;
    Date last_date; //leaving date
    double amountDue;

    public Billing(Patient patient, Doctor doctor, Date last_Date, double amountDue) {
        this.patient = patient;
        this.doctor = doctor;
        this.last_date = last_Date;
        this.amountDue = amountDue;
    }

    //Billing function to calculate due amount.
    public void calculateDue(Date date,Date last_Date) {
        //days patient was admitted.
        long milliseconds = last_date.getTime() - date.getTime();
        int days = (int) (milliseconds / (1000 * 60 * 60 * 24));
        
        amountDue = days * 2000 + doctor.fees * days;
        System.out.println("Days: " + days);
        System.out.println("The bill is: " + amountDue);
        
    }
}

public class Clinic {
  // @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        //leaving date and person date are different.
        Date joinDate = new Date(2024,2,7);
        Date newDate = new Date(2024, 3, 1);

        //Initialise doctor, patient and billing objects
        Doctor doctor1 = new Doctor("Dr. Jack", joinDate, "Cardiologist", 500, 0);
        Doctor doctor2 = new Doctor("Dr. Jill", joinDate, "Neurologist", 600, 0);
        Patient patient1 = new Patient("John", newDate, doctor1);
        Patient patient2 = new Patient("Jane", newDate, doctor2);
        Billing billing1 = new Billing(patient1, doctor1, newDate, 0);
        Billing billing2 = new Billing(patient2, doctor2, newDate, 0);
        billing1.calculateDue(joinDate, newDate);
        billing2.calculateDue(joinDate, newDate);

    }
}

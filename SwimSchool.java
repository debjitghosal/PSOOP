import java.util.Scanner;

class SwimSchool {
 int[][] jeffSchedule = new int[4][3];
 int[][] annaSchedule = new int[4][3];
 Scanner sc = new Scanner(System.in);

 public static void main(String[] args) {
  SwimSchool swimSchool = new SwimSchool();
  swimSchool.start();
 }

 void start() {
  int choice;
  do {
   printMenu();
   choice = getUserChoice();
   switch (choice) {
    case 1:
     markBusy();
     break;
    case 2:
     markFree();
     break;
    case 3:
     printSchedules();
     break;
    case 4:
     showIndividualAvailability();
     break;
    case 5:
     showGroupAvailability();
     break;
    case 6:
     System.out.println("Exiting...");
     break;
    default:
     System.out.println("Invalid choice. Please enter a number between 1 and 6.");
   }
  } while (choice != 6);
 }

 void printMenu() {
  System.out.println("\nMenu:");
  System.out.println("1. Schedule a lesson");
  System.out.println("2. Cancel a lesson");
  System.out.println("3. View schedules");
  System.out.println("4. Show available slots for individual lessons");
  System.out.println("5. Show available slots for group lessons");
  System.out.println("6. Exit");
 }

 int getUserChoice() {
  System.out.print("Enter your choice: ");
  return sc.nextInt();
 }

 void markBusy() {
  System.out.println("Which instructor?");
  System.out.println("1. Jeff");
  System.out.println("2. Anna");
  int instructor = sc.nextInt();

  System.out.println("Which day?");
  int day = sc.nextInt() - 1;

  System.out.println("Which hour?");
  int hour = sc.nextInt() - 1;
  if (instructor == 1)
   jeffSchedule[day][hour] = 1;
  else if (instructor == 2)
   annaSchedule[day][hour] = 1;
  else
   System.out.println("Invalid choice.");
 }

 void markFree() {
  System.out.println("Which instructor?");
  System.out.println("1. Jeff");
  System.out.println("2. Anna");
  int instructor = sc.nextInt();

  System.out.println("Which day?");
  int day = sc.nextInt() - 1;

  System.out.println("Which hour?");
  int hour = sc.nextInt() - 1;
  if (instructor == 1)
   jeffSchedule[day][hour] = 0;
  else if (instructor == 2)
   annaSchedule[day][hour] = 0;
  else
   System.out.println("Invalid choice.");
 }

 void printSchedules() {
  System.out.println("\nJeff's Schedule:");
  printSchedule(jeffSchedule);

  System.out.println("\nAnna's Schedule:");
  printSchedule(annaSchedule);
 }

 void printSchedule(int[][] schedule) {
  for (int i = 0; i < 4; i++) {
   for (int j = 0; j < 3; j++) {
    System.out.print(schedule[i][j] == 1 ? "X " : "- ");
   }
   System.out.println();
  }
 }

 void showIndividualAvailability() {
  System.out.println("Available slots for individual lessons (Jeff):");
  showAvailability(jeffSchedule);
  System.out.println("Available slots for individual lessons (Anna):");
  showAvailability(annaSchedule);
 }

 void showAvailability(int[][] schedule) {
  System.out.println("Day\tHour");
  for (int i = 0; i < 4; i++) {
   for (int j = 0; j < 3; j++) {
    if (schedule[i][j] == 0) {
     System.out.println((i + 1) + "\t" + (j + 1));
    }
   }
  }
 }

 void showGroupAvailability() {
  System.out.println("Available slots for group lessons:");
  System.out.println("Day\tHour");
  for (int i = 0; i < 4; i++) {
   for (int j = 0; j < 3; j++) {
    if (jeffSchedule[i][j] == 0 && annaSchedule[i][j] == 0) {
     System.out.println((i + 1) + "\t" + (j + 1));
    }
   }
  }
 }
}

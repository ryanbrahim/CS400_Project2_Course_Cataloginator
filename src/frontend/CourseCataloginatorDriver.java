// --== CS400 File Header Information ==--
// Name: Bailey Hurlburt
// Email: bhurlburt@wisc.edu
// Team: MG
// Role: Front End Developer
// TA: Harit
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
package frontend;

import java.io.FileNotFoundException;
import java.util.Scanner;
import backend.CourseCatalog;

/**
 * This is the driver for the Course Catalog Program, allows user interaction with accessing CS
 * Courses
 * 
 * @author Bailey
 *
 */
public class CourseCataloginatorDriver {
  // Constants
  private static final String[] userCommands = {"all courses", "courses at level", "help", "exit"}; // possible
                                                                                                    // commands
  private static final String fileName = "Final.csv"; // file to read data from
  // Class Variables
  public static CourseCatalog catalog;

  /**
   * Main method for Course Catalog, runs user interface and allows user interaction
   * 
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String args[]) throws FileNotFoundException {

    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    catalog = new CourseCatalog(fileName);

    // check whether the input is a string or number
    boolean isCourseNum = true;

    System.out.println("Welcome to the Course Catalog!");
    printUserCommands();

    // User input loop
    while (true) {
      // get user's command
      String inputCommand = scanner.nextLine().toLowerCase().trim();

      // check if the inputCommand is an int
      isInteger(inputCommand);

      // exit command
      if (inputCommand.equals("exit")) {
        break;
      }

      // get specific course info command
      else if (isInteger(inputCommand)) {
        if (catalog.contains(Integer.parseInt(inputCommand))) {
          printCourseInfo(Integer.parseInt(inputCommand));
        } else {
          // invalid course number
          System.out.println();
          System.out
              .println("The command you entered is invalid. Type 'all courses' to see possible "
                  + "courses, or 'help' to get a list of commands.");
          System.out.print(":");
        }
      }

      // help command
      else if (inputCommand.equals("help")) {
        printUserCommands();
      }

      // print out all CS courses command
      else if (inputCommand.equals("all courses")) {
        printAllCourseNumbers();
      }

      // print out courses based on given bounds
      else if (inputCommand.equals("courses at level")) {

        String lowerBound = null;
        String upperBound = null;

        // retrieve user inputted lower bound
        System.out.print("Enter the lower bound: ");
        while (!isInteger(lowerBound)) {

          // check if the next input is an integer, if not continue loop
          if (intScanner.hasNextInt()) {
            lowerBound = intScanner.nextLine();
            break;
          }

          System.out.print("Given input is not a valid integer, please re-enter an integer: ");
          lowerBound = intScanner.nextLine();
        }
        
        // retrieve user inputted upper bound
        System.out.print("Enter the upper bound: ");
        while (!isInteger(upperBound)) {

          // check if the next input is an integer, if not continue loop
          if (intScanner.hasNextInt()) {
            upperBound = intScanner.nextLine();
            break;
          }

          System.out.print("That input is not a valid integer, please re-enter an integer: ");
          upperBound = intScanner.nextLine();
        }
        // call printCoursesAtLevel() if the given bounds are correct format, otherwise give error message
        if (isInteger(lowerBound) && isInteger(upperBound)) {
          printCoursesAtLevel(lowerBound, upperBound);
        } else {
          System.out.println("Given input was incorrect, please try again with integers.");
          System.out.print(":");
        }

      }

      // invalid command
      else {
        System.out.println();
        System.out.println("The command you entered is invalid. Type 'all courses' to see possible "
            + "courses, or 'help' to get a list of commands.");
        System.out.print(":");
      }
    }

    // closing program
    scanner.close();
    System.out.println();
    System.out.println("Thank you so very much for using The Course Catalog, "
        + "we will forever be indebted to you. ");
  }

  /**
   * checks whether the given string is an integer or not
   * 
   * @param input
   * @return true if input is an integer, false otherwise
   */
  private static boolean isInteger(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Helper method to print out the potential user commands
   * 
   */
  private static void printUserCommands() {
    System.out.println();
    System.out.println("Possible commands: ");
    System.out.println(":input a specific CS course number ");
    System.out.println(":" + userCommands[2] + " (will show all possible commands) ");
    System.out.println(":" + userCommands[3] + " (will exit the program)");
    System.out.println(":" + userCommands[0] + " (will receive a list of all course numbers)");
    System.out.println(
        ":" + userCommands[1] + " (will receive a list of the courses between two bounds)");
    System.out.print(":");
  }

  /**
   * Helper method to print out the information for a particular CS course
   * 
   * @param courseNum - the int number of the course
   */
  private static void printCourseInfo(int courseNum) {
    System.out.println();
    System.out.println(catalog.get(courseNum).description);
    System.out.print(":");
  }

  /**
   * Helper method to print out all of the CS courses, formatted correctly
   * 
   */
  private static void printAllCourseNumbers() {

    // prints all of the course's numbers
    System.out.println();
    System.out.println("Course Number List: ");
    catalog.inOrderTraversal((courseNum, course) -> {
      System.out.print(courseNum + " - ");
    });
    System.out.println();
    System.out.print(":");
  }

  /**
   * Helper method to print out the course number and course description based on lower and upper
   * bound
   * 
   * @param oldLowerBound
   * @param oldUpperBound
   */
  private static void printCoursesAtLevel(String userLowerBound, String userUpperBound) {

    // parse the lower and upper bounds
    int lowerBound = Integer.parseInt(userLowerBound);
    int upperBound = Integer.parseInt(userUpperBound);

    // prints course # and course description
    System.out.println();
    catalog.inOrderTraversal((courseNum, course) -> {
      if (courseNum <= upperBound && courseNum >= lowerBound) {
        System.out.println(courseNum + " " + course.description);
      }
    });
    System.out.print(":");
  }
}

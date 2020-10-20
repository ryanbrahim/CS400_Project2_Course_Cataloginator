// --== CS400 File Header Information ==--
// Name: Prannav Arora
// Email: parora9@wisc.edu
// Team: MG
// TA: Harit
// Lecturer: Gary
// Notes to Grader: <optional extra notes>

package testing;

import backend.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

/**
 * Tests the backend for P2
 * 
 * @author Prannav Arora
 *
 */
class Tests_P2 {

  /**
   * Tests the backend's get method to see if courses are "gotten" properly
   */
  @Test
  void testGet() {
    try {
      CourseCatalog cc = new CourseCatalog("Final.csv");
      assertTrue(cc.get(200).toString().equals("(200)"));
      assertTrue(cc.get(200).description.equals("PROGRAMMING-I"));

      // Test - getting a course shouldn't cause it to be removed
      assertTrue(cc.get(540).toString().equals("(540)"));
      assertTrue(cc.get(540).description.equals("INTRODUCTION-TO-ARTIFICIAL-INTELLIGENCE"));
      assertTrue(cc.contains(540) == true);

      // Test a case where we try to get an invalid course:
      assertTrue(cc.get(700) == null);
    } catch (FileNotFoundException e) {
      fail("Final.csv not found");
    } catch (Exception e) {
      fail("Some other exception was caught in testGet()");
    }
  }


  /**
   * Tests that course catalog has the right number of courses.
   */
  @Test
  void testGetSize() {
    try {
      CourseCatalog cc = new CourseCatalog("Final.csv");
      // System.out.println(cc.getSize());
      assertTrue(cc.getSize() == 57);
    } catch (FileNotFoundException e) {
      fail("Final.csv not found");
    } catch (Exception e) {
      fail("Some other exception was caught in testGetSize()");
    }
  }


  /**
   * Tests that course catalog has the right number of courses.
   */
  @Test
  void testContains() {
    try {
      CourseCatalog cc = new CourseCatalog("Final.csv");
      assertTrue(cc.contains(577) == true);
      // System.out.println(cc.contains(577));
      assertTrue(cc.contains(150) == false);
      // System.out.println(cc.contains(150));
    } catch (FileNotFoundException e) {
      fail("Final.csv not found");
    } catch (Exception e) {
      fail("Some other exception was caught in testContains()");
    }
  }


  /**
   * Tests in order traversal for CourseCatalog
   */
  @Test
  void testInOrderTraversal() {
    try {
      CourseCatalog cc = new CourseCatalog("Final.csv");

      // THIS IS COMMENTED BECAUSE IT PRINTS IT OUT STUFF
      // cc.inOrderTraversal((key, value) -> System.out.println(key + " :: " + value.description));
    } catch (FileNotFoundException e) {
      fail("Final.csv not found");
    } catch (Exception e) {
      fail("Some other exception was caught in testInOrderTraversal()");
    }
  }

}

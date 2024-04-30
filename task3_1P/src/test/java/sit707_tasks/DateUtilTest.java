package sit707_tasks;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "223558537";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Niwanthi";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
    public void testDayEquivalenceClasses() {
        // Test cases for day equivalence classes
        
        // D1: Day between 1 to 28 (non-leap year)
        DateUtil dateD1 = new DateUtil(15, 1, 2023);
        dateD1.increment();
        assertEquals( 16, dateD1.getDay());
        
        // D2: Day 29 (leap year)
        DateUtil dateD2 = new DateUtil(29, 2, 2024);
        dateD2.increment();
        assertEquals( 1, dateD2.getDay());
        assertEquals( 3, dateD2.getMonth());
        
        // D3: Day 30
        DateUtil dateD3 = new DateUtil(30, 4, 2022);
        dateD3.increment();
        assertEquals( 1, dateD3.getDay());
        assertEquals( 5, dateD3.getMonth());
        
        // D4: Day 31
        DateUtil dateD4 = new DateUtil(31, 12, 2023);
        dateD4.increment();
        assertEquals( 1, dateD4.getDay());
        assertEquals( 1, dateD4.getMonth());
        assertEquals( 2024, dateD4.getYear());
    }

	@Test
	public void testMonthEquivalenceClasses() {
	    // Test cases for month equivalence classes
	    
	    // M1: Months with 30 days
	    DateUtil dateM1 = new DateUtil(15, 4, 2023);
	    dateM1.increment();
	    assertEquals( 16, dateM1.getDay());
	    
	    // M2: Months with 31 days
	    DateUtil dateM2 = new DateUtil(15, 3, 2023);
	    dateM2.increment();
	    assertEquals( 3, dateM2.getMonth());
	    assertEquals( 16, dateM2.getDay());
	    
	    // M3: February (non-leap year)
	    DateUtil dateM3 = new DateUtil(28, 2, 2023);
	    dateM3.increment();
	    assertEquals(3, dateM3.getMonth());
	    assertEquals(1, dateM3.getDay());
	    
	    // M4: February (leap year)
	    DateUtil dateM4 = new DateUtil(28, 2, 2024);
	    dateM4.increment();
	    assertEquals(29, dateM4.getDay());
	}

	@Test
	public void testYearEquivalenceClasses() {
	    // Test cases for year equivalence classes
	    
	    // Y1: Years without a leap year
	    DateUtil dateY1 = new DateUtil(15, 1, 2023);
	    dateY1.increment();
	    assertEquals(16, dateY1.getDay());
	    
	    // Y2: Leap years
	    DateUtil dateY2 = new DateUtil(15, 1, 2024);
	    dateY2.increment();
	    assertEquals( 1, dateY2.getMonth());
	    assertEquals(16, dateY2.getDay());
	}
	
}

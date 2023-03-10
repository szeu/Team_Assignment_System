/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package comp3111G15;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * The LibraryTest is used for unit testing
 * @author SzeWingKwan
 *
 */
public class LibraryTest {
	
	ArrayList<Student> student_data;
	Student student1;
	Student student2;
	Student student3;
	Student student4;
	Student student5;
	Student student6;
	Student student7;
	Student student8;
	Team team;
	ArrayList<Student> ATUStudent;
	Team ATUTeam1;
	Team ATUTeam2;
	ATUEngine ATUEngine;
	Student studentChangeable;
	
	/**
	 * Set up control variables
	 * @throws Exception exception
	 */
	@Before
	public void setUp() throws Exception {
		student_data = new ArrayList<Student>();
		ATUStudent = new ArrayList<Student>();

		student1 = new Student(0, "20004488", "SAFFRON, Corgipoo", "CorgipooSAF@connect.ust.hk", 
				"26", "80", "0", "1", "0", "");
		student2 = new Student(1, "20023331", "HYSSOP, Chamois", "ChamoisHYS@connect.ust.hk", 
				"27", "85", "0", "1", "1", "");
		student3 = new Student(2, "20067232", "CHRYSANTHEMUM, Abelisaurus", "AbelisaurusCHR@connect.ust.hk", 
				"57", "60", "1", "0", "1", "");
		
		
		
		student4 = new Student(3, "2", "CHRYSANTHEMUM, Abelisaurus", "AbelisaurusCHR@connect.ust.hk", 
				"1", "1", "1", "0", "1", "");
		student5 = new Student(4, "3", "CHRYSANTHEMUM, Abelisaurus", "AbelisaurusCHR@connect.ust.hk", 
				"1", "1", "1", "0", "1", "");
		student6 = new Student(5, "4", "CHRYSANTHEMUM, Abelisaurus", "AbelisaurusCHR@connect.ust.hk", 
				"1", "1", "1", "0", "1", "");
		student7 = new Student(6, "5", "CHRYSANTHEMUM, Abelisaurus", "AbelisaurusCHR@connect.ust.hk", 
				"1", "1", "1", "0", "1", "");
		student8 = new Student(7, "5", "CHRYSANTHEMUM, Abelisaurus", "AbelisaurusCHR@connect.ust.hk", 
				"14", "1", "1", "0", "1", "I hate freeriders");
		
		studentChangeable = new Student(100, "0", "A, A", "x@connect.ust.hk", 
			    "0", "0", "0", "0", "0", "");
		studentChangeable.setStudentID("21112211");
		studentChangeable.setStudentName("Sal");
		studentChangeable.setStudentEmail("SalVa@connect.ust.hk");
		studentChangeable.setK1Energy("90");
		studentChangeable.setK2Energy("88");
		studentChangeable.setK3Tick1("1");
		studentChangeable.setK3Tick2("1");
		studentChangeable.setConcerns("I am really good!");
		studentChangeable.setIndex("101");
		
		student_data.add(student1);
		student_data.add(student2);
		student_data.add(student3);
		
		team = new Team(1, student_data, 0);
		
		ATUStudent.add(student3);
		ATUStudent.add(student2);
		ATUStudent.add(student1);
		
		ATUTeam1 = new Team(1, ATUStudent, 0);
	}
	
	
	/**
	 * Test for team id
	 */
	@Test
	public void isTeamIdEqual() {
		assertEquals(1, team.getID());
	}
	
	/**
	 * Test for team recommended leader
	 */
	@Test
	public void isTeamLeaderEqual() {
		assertEquals(student1, team.getLeader());
	}
	
	/**
	 * Test for team K1
	 */
	@Test
	public void isTeamK1AverageEqual() {
		assertEquals((int)(student1.getK1Energy_int()+student2.getK1Energy_int()+student3.getK1Energy_int())/3, (int)team.getK1Average());
	}
	
	/**
	 * Test for team K2
	 */
	@Test
	public void isTeamK2AverageEqual() {
		assertEquals((int)(student1.getK2Energy_int()+student2.getK2Energy_int()+student3.getK2Energy_int())/3, (int)team.getK2Average());
	}
	
	/**
	 * Test for team member list
	 */
	@Test
	public void isMemberListEqual() {
		assertEquals(student_data, team.getMemberList());
	}
	
	/**
	 * Test for team
	 */
	@Test
	public void isTeamEqual() {
		assertEquals(true, team.equals(team));
	}
	
	/**
	 * Test for student name
	 */
	@Test
	public void isStudentNameEqual() {
		assertEquals("SAFFRON, Corgipoo", student1.getStudentName());
	}
	
	/**
	 * Test for student id
	 */
	@Test
	public void isStudentIDEqual() {
		assertEquals("20004488", student1.getStudentID());
	}
	
	/**
	 * Test for student email
	 */
	@Test
	public void isStudentEmailEqual() {
		assertEquals("CorgipooSAF@connect.ust.hk", student1.getStudentEmail());
	}
	
	/**
	 * Test for student K1
	 */
	@Test
	public void isStudentK1Equal() {
		assertEquals("26", student1.getK1Energy());
	}
	
	/**
	 * Test for student K2
	 */
	@Test
	public void isStudentK2Equal() {
		assertEquals("80", student1.getK2Energy());
	}
	
	/**
	 * Test for student K1 compare - larger
	 */
	@Test
	public void isStudentK1Larger() {
		assertEquals(-1, student2.compareTo(student1));
	}
	
	/**
	 * Test for student K1 compare - smaller
	 */
	@Test
	public void isStudentK1Smaller() {
		assertEquals(1, student2.compareTo(student3));
	}
	
	/**
	 * Test for student K1 compare - equal
	 */
	@Test
	public void isStudentK1CompareEqual1() {
		assertEquals(0, student2.compareTo(student2));
	}
	
	/**
	 * Test for student K3 tick 1 - false
	 */
	@Test
	public void isStudentK3Tick1ReturnFalse() {
		assertFalse(Integer.parseInt(student1.getK3Tick1()) == 1);
	}
	
	/**
	 * Test for student K3 tick 2 - true
	 */
	@Test
	public void isStudentK3Tick2ReturnTrue() {
		assertTrue(Integer.parseInt(student1.getK3Tick2()) == 1);
	}
	
	/**
	 * Test for student concerns
	 */
	@Test
	public void changeConcerns() {
		assertEquals(90, studentChangeable.getK1Energy_int());
		assertEquals(88, studentChangeable.getK2Energy_int());
		assertEquals("21112211", studentChangeable.getStudentID());
		assertEquals("Sal", studentChangeable.getStudentName());
		assertEquals("SalVa@connect.ust.hk", studentChangeable.getStudentEmail());
		assertEquals("I am really good!", studentChangeable.getConcerns());
		assertEquals("101", studentChangeable.getIndex());
		assertEquals(true, studentChangeable.getK3Tick1_bool());
		assertEquals(true, studentChangeable.getK3Tick2_bool());
	}
	
	/**
	 * Test for InputManager statistic
	 */
	@Test
	public void checkStatistics() {
		ArrayList<Statistics> stats = InputManager.getStatistics(student_data);
		assertEquals("3", stats.get(0).getValue());
		assertEquals("(36.7, 26, 57)", stats.get(1).getValue());
		assertEquals("(75.0, 60, 85)", stats.get(2).getValue());
		assertEquals("1", stats.get(3).getValue());
		assertEquals("2", stats.get(4).getValue());
		assertEquals("2", stats.get(5).getValue());
		assertEquals("0", stats.get(0).getIndex());
		assertEquals("K3_Tick2 = 1", stats.get(4).getEntry());
	}
	
	/**
	 * Test for InputManager K1 mean, min, max
	 */
	@Test
	public void isK1MMMEqual() {
		String[] k1 = InputManager.get_student_k1_mmm(student_data);
		assertEquals("36.7", k1[0]);
		assertEquals("26", k1[1]);
		assertEquals("57", k1[2]);
	}

	/**
	 * Test for InputManager K2 mean, min, max
	 */
	@Test
	public void isK2MMMEqual() {
		String[] k2 = InputManager.get_student_k2_mmm(student_data);
		assertEquals("75.0", k2[0]);
		assertEquals("60", k2[1]);
		assertEquals("85", k2[2]);
	}
	
	/**
	 * Test for InputManager K3 tick 1
	 */
	@Test
	public void isK3_tick1Equal() {
		String t = InputManager.get_k3_ticks(student_data)[0];
		assertEquals("1", t);
	}
	
	/**
	 * Test for InputManager K3 tick 2
	 */
	@Test
	public void isK3_tick2Equal() {
		String t = InputManager.get_k3_ticks(student_data)[1];
		assertEquals("2", t);
	}
	
	/**
	 * Test for InputManager preference
	 */
	@Test
	public void isMyPrefEqual() {
		String t = InputManager.get_k3_ticks(student_data)[2];
		assertEquals("2", t);
	}
	
	/**
	 * Test for Security password
	 */
	@Test
	public void isPasswordCorrect() {
		assertFalse(Security.checkPW("abcd"));
		assertTrue(Security.checkPW("1234"));
	}
	
	/**
	 * Test for RequestWindowController
	 */
	@Test
	public void checkUserLevelDialogResult() {
		ArrayList<Boolean> results1 = RequestWindowController.onDialogGetResult(RequestWindowController.levels[0]);
		assertFalse(results1.get(0));
		assertFalse(results1.get(1));
		ArrayList<Boolean> result2 = RequestWindowController.onDialogGetResult(RequestWindowController.levels[1]);
		assertTrue(result2.get(0));
	}
	
	/**
	 * Test for ATUEngine
	 */
	@Test
	public void isATUEngineExecutedCorrectly() {
		ArrayList<Student> temp = new ArrayList<Student>();
		temp.add(student1);
		temp.add(student2);
		temp.add(student3);
		
		ATUEngine = new ATUEngine(temp);
		assertEquals(ATUTeam1.getMemberList().get(0).getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(0).getStudentID());
		assertEquals(ATUTeam1.getMemberList().get(1).getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(1).getStudentID());
		assertEquals(ATUTeam1.getMemberList().get(2).getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(2).getStudentID());
		
		temp.add(student4);
		ATUEngine = new ATUEngine(temp);
		assertEquals(student1.getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(3).getStudentID());
		
		temp.add(student5);
		temp.add(student6);
		temp.add(student7);
		temp.add(student8);
		ATUEngine = new ATUEngine(temp);
		assertEquals(student2.getStudentID(), ATUEngine.getTeamlist().get(1).getMemberList().get(0).getStudentID());
		
		student8.setMyPreference("0");
		student3.setMyPreference("0");
		student2.setMyPreference("0");
		temp = new ArrayList<Student>();
		temp.add(student1);
		temp.add(student2);
		temp.add(student3);
		
		ATUEngine = new ATUEngine(temp);
		assertEquals(ATUTeam1.getMemberList().get(0).getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(0).getStudentID());
		assertEquals(ATUTeam1.getMemberList().get(1).getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(1).getStudentID());
		assertEquals(ATUTeam1.getMemberList().get(2).getStudentID(), ATUEngine.getTeamlist().get(0).getMemberList().get(2).getStudentID());
		
		temp.add(student4);
		temp.add(student5);
		temp.add(student6);
		temp.add(student7);
		ATUEngine = new ATUEngine(temp);
		assertEquals(student2.getStudentID(), ATUEngine.getTeamlist().get(1).getMemberList().get(0).getStudentID());
	}
}
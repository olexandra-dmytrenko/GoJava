package belskii.artem.kickstarter.dao.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
private Project testProject;
	@Before
	public void setUp() throws Exception {
		testProject = new Project("My test project",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8");
	}

	@Test
	public void testProject() {
		assertEquals("My test project", testProject.getName());
	}

	@Test
	public void testGetName() {
		assertEquals("My test project", testProject.getName());
	}

	@Test
	public void testUpdateName() {
		testProject.updateName("New project name");
		assertEquals("New project name", testProject.getName());
	}

	@Test
	public void testGetGoal() {
		assertEquals(new Long(1), testProject.getGoal());
	}

	@Test
	public void testUpdateGoal() {
		testProject.updateGoal(new Long(10000));
		assertEquals(new Long(10000), testProject.getGoal());
	}

	@Test
	public void testGetBalance() {
		assertEquals(new Long(1), testProject.getBalance());
	}

	@Test
	public void testUpdateBalance() {
		testProject.updateBalance(new Long(100000));
		assertEquals(new Long(100000), testProject.getBalance());
	}

	@Test
	public void getStartDate() {
		assertEquals("28.07.2015",testProject.getStartDate());
	}

	@Test
	public void updateStartDate() {
		testProject.updateStartDate("27.07.2015");
		assertEquals("27.07.2015",testProject.getStartDate());
	}

	@Test
	public void testGetEndDate() {
		assertEquals("30.07.2015",testProject.getEndDate());
	}

	@Test
	public void testUpdateEndDate() {
		testProject.updateEndDate("31.07.2015");
		assertEquals("31.07.2015",testProject.getEndDate());
	}

	@Test
	public void testGetVideoUrl() {
		assertEquals("https://www.youtube.com/watch?v=uC0pqWX3yB8",testProject.getVideoUrl());
	}

	@Test
	public void testUpdateVideoUrl() {
		testProject.updateVideoUrl("https://www.youtube.com/");
		assertEquals("https://www.youtube.com/",testProject.getVideoUrl());
	}

}

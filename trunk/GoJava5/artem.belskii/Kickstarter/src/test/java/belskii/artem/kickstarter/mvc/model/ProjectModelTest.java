package belskii.artem.kickstarter.mvc.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.dao.project.ProjectDao;
import belskii.artem.kickstarter.dao.project.ProjectDaoImplHardCoding;

public class ProjectModelTest {
	ProjectDao projects;
	@Before
	public void setUp() throws Exception {
		projects = new ProjectDaoImplHardCoding(); 
	}

	@Test
	public void testAddProject() {
		Project testProject = new Project("My test project",new Long(1), new Long(1),"28.07.2015","30.07.2015","https://www.youtube.com/watch?v=uC0pqWX3yB8");
		projects.addProject(testProject);
		assertEquals("My test project", projects.getProjectDetails(0).getName());
	}

	@Test
	public void testGetProjectList() {
	}

	@Test
	public void testGetProjectDetails() {
	}

}

package masumi.swing.exploreProblem;


import static org.junit.Assert.*;
import masumi.contexts.ExploreProblem;
import masumi.swing.MainInteraction;
import masumi.swing.mocks.MockSwingFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test_framework.Story;

/**
 * Story to describe what happens when we start exploring a problem
 * 
 * @author Mike Charlton
 *
 */
public class Open extends Story {
	
	public Open() {
		super(new MockSwingFactory());
	}
	
	/**
	 * Masumi will be started on setUp and the Main Context will be entered.
	 * @throws java.lang.Exception
	 */
	@Before
	public void before() throws Exception {
		setUp();
	}

	/**
	 * At the end of each test, reset the test
	 * @throws java.lang.Exception
	 */
	@After
	public void after() throws Exception {
		tearDown();
	}

	/**
	 * The main interaction widget should contain the problem text widgets
	 */
	@Test
	public void opening_Masumi_adds_the_problem_widgets() {
		// When
		assertTrue(masumi.is_running());
		MainInteraction main = (MainInteraction)mainInteraction;
		ExploreProblem exploreProblem = mainContext.exploreProblem;
		
		// It should
		assertTrue(mainContext.is_entered());
		assertTrue(main.is_open());
		assertTrue(exploreProblem.is_entered());
		assertTrue(main.contains(exploreProblem.getInteraction()));
	}

}

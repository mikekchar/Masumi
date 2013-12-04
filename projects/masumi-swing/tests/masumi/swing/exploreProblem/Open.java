package masumi.swing.exploreProblem;


import static org.junit.Assert.*;

import javax.swing.ScrollPaneConstants;

import masumi.contexts.ExploreProblem;
import masumi.swing.MainInteraction;
import masumi.swing.mocks.MockSwingFactory;
import masumi.swing.widgets.Problem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import masumi.swing.Story;

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
		Problem problem = ((Problem) exploreProblem.getInteraction().getWidget());
		
		// It should
		assertTrue(mainContext.is_entered());
		assertTrue(main.is_open());
		assertTrue(exploreProblem.is_entered());
		assertTrue(main.contains(exploreProblem.getInteraction()));
		
		assertTrue(problem.getText().equals("Type here to explore a problem."));
		
		assertTrue(problem.getHorizontalScrollBarPolicy() == 
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		assertTrue(problem.getVerticalScrollBarPolicy() == 
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		assertTrue(problem.is_editable());
		assertTrue(problem.has_lineWrap());
	}

}

/**
 * 
 */
package masumi.swing.exploreProblem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import masumi.contexts.ExploreProblem;
import masumi.swing.MainInteraction;
import masumi.swing.Story;
import masumi.swing.mocks.MockSwingFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Story to describe what happens to the problem display when you close Masumi
 * 
 * @author Mike Charlton
 *
 */
public class Close extends Story {
	
	public Close() {
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
	 * How do we close Masumi?
	 */
	@Test
	public void closing_the_main_interaction_closes_exploreProblem() {
		// When
		assertTrue(masumi.is_running());
		ExploreProblem exploreProblem = mainContext.exploreProblem;
		((MainInteraction)mainInteraction).request_closure();
		
		// It should
		assertFalse(mainInteraction.is_open());
		assertFalse(exploreProblem.getInteraction().is_open());
		assertFalse(masumi.is_running());
	}

}

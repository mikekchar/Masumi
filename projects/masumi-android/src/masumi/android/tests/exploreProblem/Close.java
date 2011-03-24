/**
 * 
 */
package masumi.android.tests.exploreProblem;

import masumi.android.tests.Story;
import masumi.contexts.ExploreProblem;

/**
 * Story to describe what happens to the problem display when you close Masumi
 * 
 * @author Mike Charlton
 *
 */
public class Close extends Story {
	
	/**
	 * How do we close Masumi?
	 */
	public void test_closing_the_main_interaction_closes_exploreProblem() {
		// When
		assertTrue(getMasumi().is_running());
		mainInteraction.request_closure();
		ExploreProblem exploreProblem = mainContext.exploreProblem;
		
		// It should
		assertFalse(mainInteraction.is_open());
		assertFalse(exploreProblem.getInteraction().is_open());
		assertFalse(getMasumi().is_running());
	}

}

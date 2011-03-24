package masumi.android.tests.exploreProblem;

import masumi.android.tests.Story;
import masumi.contexts.ExploreProblem;

/**
 * Story to describe what happens when we start exploring a problem
 * 
 * @author Mike Charlton
 *
 */
public class Open extends Story {
	

	/**
	 * The main interaction widget should contain the problem text widgets
	 */
	public void test_opening_Masumi_adds_the_problem_widgets() {
		// When
		assertTrue(getMasumi().is_running());
		ExploreProblem exploreProblem = mainContext.exploreProblem;
		
		// It should
		assertTrue(mainContext.is_entered());
		assertTrue(mainInteraction.is_open());
		assertTrue(exploreProblem.is_entered());
		assertTrue(mainInteraction.contains(exploreProblem.getInteraction()));
	}

}

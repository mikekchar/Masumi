package masumi.android.tests.exploreProblem;

import masumi.android.tests.Story;
import masumi.contexts.ExploreProblem;
import masumi.android.widgets.Problem;

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
		Problem problem = (Problem) exploreProblem.getInteraction().getWidget();
		
		// It should
		assertTrue(mainContext.is_entered());
		assertTrue(mainInteraction.is_open());
		assertTrue(exploreProblem.is_entered());
		assertTrue(mainInteraction.contains(exploreProblem.getInteraction()));

		String text = problem.getText();
		assertTrue(text.equals("Type here to explore a problem."));
		
		// I don't seem to be able to test that the widget is editable.  Sigh...
	}

}

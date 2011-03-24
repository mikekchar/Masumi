package masumi.android.tests.main;

import masumi.android.tests.Story;

/**
 * Story to describe what happens when you close Masumi
 * 
 * @author Mike Charlton
 *
 */
public class Close extends Story {

	/**
	 * How do we close Masumi?
	 */
	public void test_closing_the_main_interaction_exits_Masumi() {
		// When
		assertTrue(getMasumi().is_running());
		mainInteraction.request_closure();
		
		// It should
		assertFalse(mainInteraction.is_open());
		assertFalse(getMasumi().is_running());
	}

}

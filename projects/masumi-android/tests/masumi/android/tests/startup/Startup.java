package masumi.android.tests.startup;

import masumi.android.tests.Story;

/**
 * Story to describe what happens when you start Masumi
 * 
 * @author Mike Charlton
 *
 */

public class Startup extends Story{

	/**
	 * What should happen when Masumi is first started.
	 */
	public void test_running_Masumi_opens_the_main_interaction() {
		// When
		assertTrue(getMasumi().is_running());
		
		// It should
		assertTrue(mainContext.is_entered());
		assertTrue(mainInteraction.is_open());
	}
	
	public void test_masumi_should_have_a_build_version() {
		// When
		assertTrue(getMasumi().is_running());
		
		// It should
		String version = getMasumi().version();
		assertNotNull(version);
	}
}

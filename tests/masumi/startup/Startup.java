package masumi.startup;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import test_framework.Story;

/**
 * Story to describe what happens when you start Masumi
 * 
 * @author Mike Charlton
 *
 */

public class Startup extends Story{

	@After
	public void tearDown() throws Exception {
		reset();
	}

	/**
	 * What should happen when Masumi is first started.
	 */
	@Test
	public void running_Masumi_opens_the_main_interaction() {
		// When
		this.run_masumi();
		
		// It should
		assertTrue(this.masumi().is_running());
		assertTrue(this.main_context().is_entered());
		assertTrue(this.main_interaction().is_open());
	}
}

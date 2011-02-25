package masumi.swing.startup;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import test_framework.Story;
import masumi.swing.mocks.MockSwingFactory;

/**
 * Story to describe what happens when you start Masumi
 * 
 * @author Mike Charlton
 *
 */

public class Startup extends Story{

	public Startup() {
		super(new MockSwingFactory());
	}

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
	
	@Test
	public void masumi_should_have_a_build_version() {
		// When
		this.run_masumi();
		
		// It should
		String version = this.masumi().version();
		// The version is null unless it is in the Jar.  Not sure how I should test this.
		assertTrue(version == null);
	}
}

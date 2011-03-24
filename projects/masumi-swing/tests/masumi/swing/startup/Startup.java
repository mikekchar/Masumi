package masumi.swing.startup;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
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

	@Before
	public void before() throws Exception {
		setUp();
	}
	
	@After
	public void after() throws Exception {
		tearDown();
	}

	/**
	 * What should happen when Masumi is first started.
	 */
	@Test
	public void running_Masumi_opens_the_main_interaction() {
		// When
		assertTrue(masumi.is_running());
		
		// It should
		assertTrue(mainContext.is_entered());
		assertTrue(mainInteraction.is_open());
	}
	
	@Test
	public void masumi_should_have_a_build_version() {
		// When
		assertTrue(masumi.is_running());
		
		// It should
		String version = masumi.version();
		// The version is null unless it is in the Jar.  Not sure how I should test this.
		assertTrue(version == null);
	}
}

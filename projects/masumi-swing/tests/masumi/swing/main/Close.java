/**
 * 
 */
package masumi.swing.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import masumi.swing.MainInteraction;
import masumi.swing.mocks.MockSwingFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test_framework.Story;

/**
 * Story to describe what happens when you close Masumi
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
	public void closing_the_main_interaction_exits_Masumi() {
		// When
		assertTrue(masumi.is_running());
		((MainInteraction)mainInteraction).request_closure();
		
		// It should
		assertFalse(mainInteraction.is_open());
		assertFalse(masumi.is_running());
	}

}

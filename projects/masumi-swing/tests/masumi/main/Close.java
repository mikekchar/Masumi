/**
 * 
 */
package masumi.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test_framework.Story;
import masumi.swing.MainInteraction;


/**
 * Story to describe what happens when you close Masumi
 * 
 * @author Mike Charlton
 *
 */
public class Close extends Story {
	
	public Close() {
		super();
	}
	
	/**
	 * Masumi will be started on setUp and the Main Context will be entered.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.run_masumi();
	}

	/**
	 * At the end of each test, reset the test
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		reset();
	}

	/**
	 * How do we close Masumi?
	 */
	@Test
	public void closing_the_main_interaction_exits_Masumi() {
		// When
		assertTrue(this.masumi().is_running());
		((MainInteraction)main_interaction()).request_closure();
		
		// It should
		assertFalse(main_interaction().is_open());
		assertFalse(masumi().is_running());
	}

}

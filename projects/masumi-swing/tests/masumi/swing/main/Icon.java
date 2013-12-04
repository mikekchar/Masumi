/**
 * 
 */
package masumi.swing.main;

import static org.junit.Assert.*;
import masumi.swing.MainInteraction;
import masumi.swing.Story;
import masumi.swing.mocks.MockSwingFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Story to describe what happens when you close Masumi
 * 
 * @author Mike Charlton
 *
 */
public class Icon extends Story {
	
	public Icon() {
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
	 * Masumi should have an icon in the main interaction.
	 */
	@Test
	public void the_Main_Interaction_displays_an_icon() {
		// When
		assertTrue(masumi.is_running());
		
		// It should
		assertTrue(((MainInteraction)mainInteraction).get_icon_image() != null);
	}

}

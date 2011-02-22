/**
 * 
 */
package masumi.main;

import static org.junit.Assert.assertTrue;
import masumi.swing.MainInteraction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test_framework.Story;
import masumi.mocks.MockSwingFactory;


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
	public void setUp() throws Exception {
		run_masumi();
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
	 * Masumi should have an icon in the main interaction.
	 */
	@Test
	public void the_Main_Interaction_displays_an_icon() {
		// When
		assertTrue(masumi().is_running());
		
		// It should
		assertTrue(((MainInteraction)main_interaction()).icon != null);
		assertTrue(((MainInteraction)main_interaction()).icon.getImage() == ((MainInteraction)main_interaction()).get_icon_image());
	}

}

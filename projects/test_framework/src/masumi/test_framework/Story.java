package test_framework;

import test_framework.MockMasumi;
import masumi.contexts.Main;
import masumi.swing.SwingFactory;

/**
 * Implements a context in which to test Masumi.
 * 
 * @author Mike Charlton
 *
 */
public class Story {

	private MockMasumi masumi;
	private Main mainContext;
	private Main.Interaction mainInteraction;
	
	public Story() {
		masumi = new MockMasumi(new SwingFactory());
		mainContext = null;
		mainInteraction = null;
	}
	
	/**
	 * Run Masumi.  Usually this will be run by the setUp methods in the concrete classes.
	 */
	public void run_masumi() {
		mainContext = (Main)masumi.run();
		mainInteraction = (Main.Interaction)(mainContext.interaction);
	}
	
	/**
	 * Make sure that Masumi has properly exited.  Usually this will be run by the tearDown methods.
	 */
	public void reset() {
		if (mainContext.is_entered()) {
			mainContext.exit();
		}
		mainContext = null;
		mainInteraction = null;
	}
	
	
	/**
	 * Returns the Main Context for this Masumi run.
	 */
	public Main main_context() {
		return mainContext;
	}
	
	/**
	 * @return the Interaction for the Main Context.  It is possible for this to be null.
	 */
	public Main.Interaction main_interaction() {
		return mainInteraction;
	}
	
	/**
	 * @return The Masumi instance used.
	 */
	public MockMasumi masumi() {
		return masumi;
	}

}
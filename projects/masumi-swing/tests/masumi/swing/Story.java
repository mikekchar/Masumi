package masumi.swing;

import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;

/**
 * Implements a context in which to test Masumi.
 * 
 * @author Mike Charlton
 *
 */
public class Story {

	protected final MockMasumi masumi;
	protected Main mainContext;
	protected Main.Interaction mainInteraction;
	
	protected Story(InteractionFactory aFactory) {
		masumi = new MockMasumi(aFactory);
		mainContext = null;
		mainInteraction = null;
	}
	
	/**
	 * Run Masumi.  Usually this will be run by the setUp methods in the concrete classes.
	 */
    void runMasumi() {
		mainContext = (Main)masumi.run();
		mainInteraction = (Main.Interaction)(mainContext.getInteraction());
	}
	
	/**
	 * Masumi will be started on setUp and the Main Context will be entered.
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		runMasumi();
		mainInteraction = (Main.Interaction)(mainContext.getInteraction());
	}

	/**
	 * Make sure that Masumi has properly exited.  Usually this will be run by the tearDown methods.
     * @throws java.lang.Exception
     */
	public void tearDown() throws Exception {
		if ((mainContext != null) && (mainContext.is_entered())) {
			mainContext.exit();
		}
		mainContext = null;
		mainInteraction = null;
	}
}
package masumi.swing;

import masumi.contexts.Main;

/**
 * Implements the Swing version of the widgets.
 * 
 * @author Mike Charlton
 *
 */
public class SwingFactory implements masumi.contexts.InteractionFactory {
	
	@Override
	public boolean showUI() {
		return true;
	}

	@Override
	public Main.Interaction create_interaction(Main context) {
		return new MainInteraction(context);
	}

}

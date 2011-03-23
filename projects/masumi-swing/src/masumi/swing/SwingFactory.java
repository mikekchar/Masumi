package masumi.swing;

import masumi.contexts.ExploreProblem;
import masumi.contexts.Main;
import masumi.contexts.ExploreProblem.Interaction;

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
		return new MainInteraction(context, this);
	}

	@Override
	public Interaction create_interaction(ExploreProblem context) {
		return new ExploreProblemInteraction(context);
	}

}

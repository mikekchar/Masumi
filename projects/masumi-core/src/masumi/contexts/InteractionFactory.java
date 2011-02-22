package masumi.contexts;

/**
 * Creates an Interaction given a Context.
 * This is an abstract class.
 * Because Masumi can use different widget sets, we need a way to create the
 * correct Interaction for each Context. Each context must have an entry here.
 * Then there must be an entry in the concrete class for each widget set that
 * creates the correct Interaction for the widget set.  Follow the examples.
 * 
 * @author Mike Charlton
 *
 */
public interface InteractionFactory {
	
	/**
	 * There are times (when testing for instance) when we don't want to display the UI to the user.
	 * This method should be called by open() on the interaction before displaying the UI.
	 * @return true if the UI should be shown.
	 */
	public boolean showUI();
	
	public Main.Interaction create_interaction(Main context);

}

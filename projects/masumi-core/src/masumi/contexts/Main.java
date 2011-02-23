package masumi.contexts;

import masumi.contexts.InteractionFactory;

/**
 * This is the Main Context.  
 * It corresponds to the main window frame in the application.  It provides
 * only one piece of functionality to the user -- to exit the application.
 * When this Context is closed, the application will exit.
 * The Main Context is also used to house all the other Contexts in
 * the application.
 * @author Mike Charlton
 *
 */
public class Main extends Context {
	
	/**
	 * The Main.Interaction contains the main window frame widgets.
	 * It has no functionality other than the default (to open and close).
	 * 
	 * @author Mike Charlton
	 *
	 */
	public interface Interaction extends Context.Interaction{
		// Nothing to do
	}
	
	public Main(InteractionFactory aFactory) {
		super(aFactory);
	}

	@Override
	public Context.Interaction create_interaction(){
		return factory.create_interaction(this);
	}
	
	/**
	 * When the Main Context exits, Masumi should exit too.
	 */
	@Override 
	public void exit(){
		super.exit();
		parent.exit();
	}

}

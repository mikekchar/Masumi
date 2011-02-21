package masumi.contexts;

import masumi.contexts.InteractionFactory;

/**
 * This is a user interaction context.
 * Basically, all user interaction is grouped into a Context.  The Context contains
 * all the model objects that are necessary to provide the functionality that the user
 * needs in this context.  The Context also contains a single interaction that defines
 * what information can be sent to and from the user.
 * 
 * @author Mike Charlton
 *
 */
public abstract class Context {

	/**
	 * This represents the information or actions that can be sent to or from a user.
	 * Generally speaking an interaction will be associated with one or more
	 * UI widgets that the user can interact with.  The interaction defines how
	 * information passes to and from the UI.
	 * 
	 * Each Context will define a single interaction interface.
	 * The UI layer (for example, masumi.swing) will define concrete classes that
	 * define that interface.  It can be composed of one or more UI widgets that
	 * the user interacts with.
	 * 
	 * The default interaction interface defines 3 methods:
	 *  - open(): Display all the widgets to the user
	 *  - close(): Hide all the widgets from the user
	 *  - is_open(): Returns true if the widgets are visible from the user.
	 *  
	 *  It is common for the widgets themselves to call close() which will
	 *  in turn exit the Context.
	 * 
	 * @author Mike Charlton
	 *
	 */
	protected interface Interaction {
		public void open();
		public void close();
		public boolean is_open();
	}
	
	protected boolean entered;
	protected InteractionFactory factory;
	public Interaction interaction;
	protected Context parent;

	public Context(InteractionFactory aFactory) {
		factory = aFactory;
		entered = false;
		parent = null;
		interaction = create_interaction();
	}

	/**
	 * Creates the  concrete Interaction for the Context.
	 * Each Context must implement the code:
	 * <code>
	 * 			factory.create_interaction(this);
	 * </code>
	 * @return the concrete Interaction
	 * TODO Try to make this done using generics.
	 */
	public abstract Interaction create_interaction();

	/**
	 * Enter a new UI Context.
	 * It is important to realize that even though the new Context is entered, the old
	 * Context is still active.  There is no concept of "modal" Contexts.  However, a child
	 * Context must be able to request functionality from a parent, and so the parent
	 * is kept.  Ideally, the parent should not contact the child except for entering it.
	 * It is common for a child Context to call exit() on the parent Context.
	 * 
	 * @param aParent The context that was active when this Context is entered.
	 */
	public void enter(Context aParent) {
		entered = true;
		parent = aParent;
		if (interaction != null) {
			interaction.open();
		}
	}

	/**
	 * @return true if the Context has been entered but not exited.
	 */
	public boolean is_entered() {
		return entered;
	}

	/**
	 * Exit the Context.
	 * This will close the interaction if it isn't already closed.
	 */
	public void exit() {
		if (is_entered()) {
			if(interaction != null) {
				interaction.close();
			}
			entered = false;
		}
	}

}
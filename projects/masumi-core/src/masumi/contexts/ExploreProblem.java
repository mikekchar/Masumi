package masumi.contexts;

public class ExploreProblem extends Context {

	/**
	 * The ExploreProblem.Interaction contains the text widget that holds the problem.
	 * The user is able to enter and otherwise interact with the problem through
	 * this interaction.
	 * 
	 * @author Mike Charlton
	 *
	 */
	public interface Interaction extends Context.Interaction{
		/**
		 * Select all the text in the problem.  Note: this also grabs focus.
		 */
		public void selectAll();
		
		/**
		 * Append the string to the current problem.
		 */
		public void appendText(String aString);
	}
	
	public ExploreProblem(InteractionFactory aFactory) {
		super(aFactory);
	}
	
	public Interaction getInteraction() {
		return (Interaction) interaction;
	}

	@Override
	public Context.Interaction create_interaction(){
		return factory.create_interaction(this);
	}
	
	@Override
	public void enter(Context parent) {
		super.enter(parent);
		getInteraction().appendText("Type here to explore a problem.");
		getInteraction().selectAll();
		getInteraction().update();
	}

}

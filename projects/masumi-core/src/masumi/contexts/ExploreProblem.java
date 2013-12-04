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
		 * Set text of the current problem.
         * @param aString The text you want in the current problem.
         */
		public void setText(String aString);
	}

    String problemText;
	
	public ExploreProblem(InteractionFactory aFactory) {
		super(aFactory);
        problemText = aFactory.getString("exploreProblem");
	}
	
	public Interaction getInteraction() {
		return (Interaction) interaction;
	}

    public void updateProblem(String aString) {
        problemText = aString;
    }

	@Override
	public Context.Interaction create_interaction(){
		return factory.create_interaction(this);
	}
	
	@Override
	public void enter(Context parent) {
		super.enter(parent);
		getInteraction().setText(problemText);
		getInteraction().selectAll();
		getInteraction().update();
	}

}

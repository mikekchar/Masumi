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
		// Nothing to do
	}
	
	public ExploreProblem(InteractionFactory aFactory) {
		super(aFactory);
	}

	@Override
	public Context.Interaction create_interaction(){
		return factory.create_interaction(this);
	}

}

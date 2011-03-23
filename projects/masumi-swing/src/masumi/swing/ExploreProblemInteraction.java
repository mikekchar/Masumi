package masumi.swing;

import masumi.contexts.Context;
import masumi.contexts.ExploreProblem;
import masumi.contexts.Widget;

public class ExploreProblemInteraction implements ExploreProblem.Interaction {

	public ExploreProblem context;
	
	public ExploreProblemInteraction(ExploreProblem aContext) {
		context = aContext;
	}

	/**
	 * This removes the widgets from the screen.
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns true if a problem is being explored currently.
	 */
	@Override
	public boolean is_open() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Create the widgets necessary for exploring the problem.
	 */
	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Context.Interaction anInteraction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Context.Interaction anInteraction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Widget getWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(masumi.contexts.Context.Interaction anInteraction) {
		// TODO Auto-generated method stub
		
	}

}

package masumi.swing;

import masumi.contexts.Context;
import masumi.contexts.ExploreProblem;
import masumi.contexts.Widget;
import masumi.swing.widgets.Problem;

public class ExploreProblemInteraction implements ExploreProblem.Interaction {

	public ExploreProblem context;
	private boolean isOpen;
	private Problem problem;
	
	public ExploreProblemInteraction(ExploreProblem aContext) {
		context = aContext;
		isOpen = false;
		problem = new Problem();
	}

	/**
	 * This removes the widgets from the screen.
	 */
	@Override
	public void close() {
		problem.setVisible(false);
		isOpen = false;
	}

	/**
	 * Returns true if a problem is being explored currently.
	 */
	@Override
	public boolean is_open() {
		return isOpen;
	}

	/**
	 * Create the widgets necessary for exploring the problem.
	 */
	@Override
	public void open() {
		problem.setVisible(true);
	}

	@Override
	public void add(Context.Interaction anInteraction) {
		// Don't do anything
	}

	@Override
	public boolean contains(Context.Interaction anInteraction) {
		return false;
	}

	@Override
	public Widget getWidget() {
		return problem;
	}

	@Override
	public void remove(masumi.contexts.Context.Interaction anInteraction) {
		// Don't do anything
	}

}

package masumi.swing;

import masumi.contexts.Context;
import masumi.contexts.ExploreProblem;
import masumi.contexts.Widget;
import masumi.swing.widgets.Problem;

public class ExploreProblemInteraction implements ExploreProblem.Interaction {

	private final ExploreProblem context;
	private boolean isOpen;
	private final Problem problem;
	
	public ExploreProblemInteraction(ExploreProblem aContext) {
		context = aContext;
		isOpen = false;
		problem = new Problem();
	}
	
	/**
	 * Create the widgets necessary for exploring the problem.
	 */
	public void open() {
		problem.setVisible(true);
	}

	/**
	 * This removes the widgets from the screen.
	 */
	public void close() {
		problem.setVisible(false);
		isOpen = false;
	}

	/**
	 * Returns true if a problem is being explored currently.
	 */
	public boolean is_open() {
		return isOpen;
	}
	
	public void update() {
		problem.validate();
	}

	public void add(Context.Interaction anInteraction) {
		// Don't do anything
	}

	public boolean contains(Context.Interaction anInteraction) {
		return false;
	}

	public Widget getWidget() {
		return problem;
	}

	public void remove(masumi.contexts.Context.Interaction anInteraction) {
		// Don't do anything
	}

	public void selectAll() {
		problem.selectAll();
	}
	
	public void setText(String aString) {
		problem.setText(aString);
	}
}

package masumi.android;

import masumi.android.widgets.Problem;
import masumi.contexts.ExploreProblem;
import masumi.contexts.Widget;
import masumi.contexts.ExploreProblem.Interaction;

public class ExploreProblemInteraction implements Interaction {

	private final ExploreProblem context;
	private boolean isOpen;
	private Problem problem;
	public final AndroidFactory factory;
	
	public ExploreProblemInteraction(ExploreProblem aContext, AndroidFactory aFactory) {
		context = aContext;
		factory = aFactory;
		isOpen = false;
		problem = null;
	}
	
	public void add(masumi.contexts.Context.Interaction anInteraction) {
		// Nothing to do here
	}

	public void close() {
		isOpen = false;
	}

	public boolean contains(masumi.contexts.Context.Interaction anInteraction) {
		return false;
	}

	public Widget getWidget() {
		return problem;
	}

	public boolean is_open() {
		return isOpen;
	}

	public void open() {
		problem = new Problem(this);
		isOpen = true;
	}

	public void remove(masumi.contexts.Context.Interaction anInteraction) {
		// Nothing to do right now
	}

	public void setText(String aString) {
		problem.setText(aString);
	}

	public void selectAll() {
		problem.selectAll();
	}

	public void update() {
		// Nothing to do
	}
}

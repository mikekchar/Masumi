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
	
	@Override
	public void add(masumi.contexts.Context.Interaction anInteraction) {
		// Nothing to do here
	}

	@Override
	public void close() {
		isOpen = false;
	}

	@Override
	public boolean contains(masumi.contexts.Context.Interaction anInteraction) {
		return false;
	}

	@Override
	public Widget getWidget() {
		return problem;
	}

	@Override
	public boolean is_open() {
		return isOpen;
	}

	@Override
	public void open() {
		problem = new Problem(this);
		isOpen = true;
	}

	@Override
	public void remove(masumi.contexts.Context.Interaction anInteraction) {
		// Nothing to do right now
	}

	@Override
	public void setText(String aString) {
		problem.setText(aString);
	}

	@Override
	public void selectAll() {
		problem.selectAll();
	}

	@Override
	public void update() {
		// Nothing to do
	}

}

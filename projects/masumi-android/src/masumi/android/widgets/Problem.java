package masumi.android.widgets;

import masumi.android.ExploreProblemInteraction;
import masumi.contexts.Widget;
import android.widget.TextView;

public class Problem extends TextView implements Widget {

	
	public Problem(ExploreProblemInteraction anInteraction) {
		super(anInteraction.getApplicationContext());
		setText("Welcome to Masumi!");
	}

	@Override
	public void add(Widget aWidget) {
		// Nothing to do
	}

	@Override
	public void remove(Widget aWidget) {
		// Nothing to do
	}

	@Override
	public boolean contains(Widget aWidget) {
		return false;
	}

}

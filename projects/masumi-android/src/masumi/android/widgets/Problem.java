package masumi.android.widgets;

import masumi.android.ExploreProblemInteraction;
import masumi.contexts.Widget;
import android.widget.EditText;
import 	android.view.ViewGroup.LayoutParams;


public class Problem extends EditText implements Widget {

	
	public Problem(ExploreProblemInteraction anInteraction) {
		super(anInteraction.getApplicationContext());
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, 
													LayoutParams.FILL_PARENT);
		this.setLayoutParams(params);
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

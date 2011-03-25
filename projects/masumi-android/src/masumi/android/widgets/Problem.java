package masumi.android.widgets;

import masumi.android.ExploreProblemInteraction;
import masumi.contexts.Widget;
import android.widget.EditText;
import android.text.InputType;
import android.view.*;
import 	android.view.ViewGroup.LayoutParams;


public class Problem extends EditText implements Widget {

	
	public Problem(ExploreProblemInteraction anInteraction) {
		super(anInteraction.getApplicationContext());
		this.setId(2);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, 
													LayoutParams.FILL_PARENT);
		setLayoutParams(params);
		setGravity(Gravity.TOP);
		setMinLines(5);
		setInputType(InputType.TYPE_CLASS_TEXT | 
				InputType.TYPE_TEXT_FLAG_MULTI_LINE |
				InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);
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

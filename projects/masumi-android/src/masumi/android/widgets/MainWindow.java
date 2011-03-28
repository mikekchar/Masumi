package masumi.android.widgets;

import android.view.View;
import android.widget.LinearLayout;
import masumi.contexts.Widget;
import masumi.android.MainInteraction;

public class MainWindow extends LinearLayout implements Widget{

	
	public MainWindow(MainInteraction anInteraction) {
		super(anInteraction.factory.getApplicationContext());
		setId(anInteraction.factory.newId());
	}

	@Override
	public void add(Widget aWidget) {
		addView((View) aWidget);
	}

	@Override
	public void remove(Widget aWidget) {
		removeView((View) aWidget);
	}

	@Override
	public boolean contains(Widget aWidget) {
		return indexOfChild((View) aWidget) != -1;
	}
	
}

package masumi.swing.widgets;

import javax.swing.JLabel;

import masumi.contexts.Widget;

public class Problem extends JLabel implements Widget {

	private static final long serialVersionUID = -2256119425016378573L;

	public Problem() {
		super("Welcome to Masumi!");
	}
	
	@Override
	public void add(Widget aWidget) {
		// Don't do anything for now
	}

	@Override
	public boolean contains(Widget widget) {
		return false;
	}

	@Override
	public void remove(Widget aWidget) {
		// Don't do anything for now
	}

}

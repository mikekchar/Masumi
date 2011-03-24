package masumi.swing.widgets;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import masumi.contexts.Widget;

public class Problem extends JScrollPane implements Widget {

	private static final long serialVersionUID = -2256119425016378573L;

	private JTextArea text;
	
	public Problem() {
		super();
		text = new JTextArea();
		text.setEditable(true);
		text.setLineWrap(true);
		setViewportView(text);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	public String getText() {
		return text.getText();
	}
	
	public void appendText(String aString) {
		text.append(aString);
	}
	
	public boolean is_editable() {
		return text.isEditable();
	}
	
	public boolean has_lineWrap() {
		return text.getLineWrap();
	}
	
	public void selectAll() {
		text.selectAll();
		text.grabFocus();
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

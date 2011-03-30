package masumi.swing.widgets;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import masumi.contexts.Widget;

public class Problem extends JScrollPane implements Widget {

	private static final long serialVersionUID = -2256119425016378573L;

	private class ZoomAction extends AbstractAction {
		private static final long serialVersionUID = -1536912129826641287L;
		final Problem problem;
		
		public ZoomAction(Problem aProblem) {
			super();
			problem = aProblem;
		}

		public void actionPerformed(ActionEvent arg0) {
			problem.zoom();
		}
	}

	private class UnZoomAction extends AbstractAction {

		private static final long serialVersionUID = -1765540335925609751L;
		final Problem problem;
		
		public UnZoomAction(Problem aProblem) {
			super();
			problem = aProblem;
		}

		public void actionPerformed(ActionEvent arg0) {
			problem.unZoom();
		}
	}

	private final JTextArea text;
	
	public Problem() {
		super();
		text = new JTextArea();
		text.setEditable(true);
		text.setLineWrap(true);
		Font font = new Font("sans", Font.PLAIN, 12);
		text.setFont(font);
		setViewportView(text);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
	
		setUpInputMap();
	}
	
	void setUpInputMap() {
		ZoomAction zoom;
		UnZoomAction unZoom;

		zoom = new ZoomAction(this);
		unZoom = new UnZoomAction(this);
		text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
								InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK, true), 
								"UnZoom");
		text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
								InputEvent.CTRL_MASK, true), 
								"Zoom");
		text.getActionMap().put("Zoom", zoom);
		text.getActionMap().put("UnZoom", unZoom);
	}
	
	void zoom() {
		Font font = text.getFont();
		int size = font.getSize();
		size = size + 2;
		String name = font.getName();
		int style = font.getStyle();
		font = new Font(name, style, size);
		text.setFont(font);
	}
	
	void unZoom() {
		Font font = text.getFont();
		int size = font.getSize();
		if (size > 6) {
			size = size - 2;
			String name = font.getName();
			int style = font.getStyle();
			font = new Font(name, style, size);
			text.setFont(font);
		}
	}

	public String getText() {
		return text.getText();
	}
	
	public void setText(String aString) {
		text.setText(aString);
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
	
	public void add(Widget aWidget) {
		// Don't do anything for now
	}

	public boolean contains(Widget widget) {
		return false;
	}

	public void remove(Widget aWidget) {
		// Don't do anything for now
	}
}

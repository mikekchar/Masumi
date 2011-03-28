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
		Problem problem;
		
		public ZoomAction(Problem aProblem) {
			super();
			problem = aProblem;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			problem.zoom();
		}
	}

	private class UnZoomAction extends AbstractAction {

		private static final long serialVersionUID = -1765540335925609751L;
		Problem problem;
		
		public UnZoomAction(Problem aProblem) {
			super();
			problem = aProblem;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			problem.unzoom();
		}
	}

	private JTextArea text;
	
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
	
	public void setUpInputMap() {
		ZoomAction zoom;
		UnZoomAction unzoom;

		zoom = new ZoomAction(this);
		unzoom = new UnZoomAction(this);
		text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
								InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK, true), 
								"UnZoom");
		text.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 
								InputEvent.CTRL_MASK, true), 
								"Zoom");
		text.getActionMap().put("Zoom", zoom);
		text.getActionMap().put("UnZoom", unzoom);		
	}
	
	public void zoom() {
		Font font = text.getFont();
		int size = font.getSize();
		size = size + 2;
		String name = font.getName();
		int style = font.getStyle();
		font = new Font(name, style, size);
		text.setFont(font);
	}
	
	public void unzoom() {
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

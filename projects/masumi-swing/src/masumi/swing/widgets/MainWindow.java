package masumi.swing.widgets;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import masumi.contexts.Widget;
import masumi.swing.MainInteraction;

public class MainWindow extends JFrame implements Widget{

	/**
	 * A Mediator to get events from the JFrame
	 * 
	 * @author Mike Charlton
	 *
	 */
	private class FrameMediator extends WindowAdapter {
		private MainInteraction interaction;
		
		FrameMediator(MainInteraction theInteraction) {
			interaction = theInteraction;
		}
		
		/**
		 * The windowClosing event simply requests that the interaction close
		 */
		@Override
		public void windowClosing(WindowEvent arg0) {
			interaction.request_closure();
		}
		
	}

	private static final long serialVersionUID = 781198792258981628L;

	private MainInteraction interaction;
	public ImageIcon icon;

	public MainWindow(MainInteraction anInteraction) {
		super();
		
		interaction = anInteraction;
		setSize(300,400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new FrameMediator(interaction));
		setTitle("Masumi");
		URL url = interaction.getClass().getResource("resources/masumi-icon.png");
		icon = new ImageIcon(url);
		setIconImage(icon.getImage());
		setVisible(interaction.showUI());
	}

	@Override
	public void add(Widget aWidget) {
		this.getContentPane().add((Component) aWidget);
	}

	@Override
	public void remove(Widget aWidget) {
		this.getContentPane().remove((Component)aWidget);
	}

	@Override
	public boolean contains(Widget widget) {
		boolean retVal = false;
		Component[] components = this.getContentPane().getComponents();
		for(int i = 0; i < components.length; i++) {
			if (components[i] == (Component)widget) {
				retVal = true;
				break;
			}
		}
		return retVal;
	}
	
}

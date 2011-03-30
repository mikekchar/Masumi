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
		private final MainInteraction interaction;
		
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

	private final ImageIcon icon;

	public MainWindow(MainInteraction anInteraction) {
		super();
		
		setSize(300,400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new FrameMediator(anInteraction));
		setTitle("Masumi");
		URL url = anInteraction.getClass().getResource("resources/masumi-icon.png");
		icon = new ImageIcon(url);
		setIconImage(icon.getImage());
		setVisible(anInteraction.showUI());
	}

		public void add(Widget aWidget) {
		this.getContentPane().add((Component) aWidget);
	}

	public void remove(Widget aWidget) {
		this.getContentPane().remove((Component)aWidget);
	}

	public boolean contains(Widget widget) {
		boolean retVal;

        retVal= false;
		Component[] components = this.getContentPane().getComponents();
        for (Component component : components) {
            if (component == widget) {
                retVal = true;
                break;
            }
        }
		return retVal;
	}
	
}

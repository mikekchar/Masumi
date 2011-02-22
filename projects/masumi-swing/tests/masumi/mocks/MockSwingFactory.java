package masumi.mocks;

import masumi.swing.SwingFactory;

public class MockSwingFactory extends SwingFactory {

	@Override
	public boolean showUI() {
		return false;
	}
}

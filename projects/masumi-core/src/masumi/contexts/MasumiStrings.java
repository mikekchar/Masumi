package masumi.contexts;

import java.util.ListResourceBundle;

public class MasumiStrings extends ListResourceBundle {

	static Object[][] contents = {
		{ "exploreProblem", "Type here to explore a problem." }		
	};
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}

}

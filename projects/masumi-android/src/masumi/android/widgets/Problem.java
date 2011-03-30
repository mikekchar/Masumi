package masumi.android.widgets;

import masumi.android.ExploreProblemInteraction;
import masumi.contexts.Widget;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.text.InputType;


public class Problem extends RelativeLayout implements Widget {

	private class Editor extends EditText {
		
		public Editor(ExploreProblemInteraction anInteraction) {
			super(anInteraction.factory.getApplicationContext());
			setId(anInteraction.factory.newId());
			setMinLines(5);
			setInputType(InputType.TYPE_CLASS_TEXT | 
					InputType.TYPE_TEXT_FLAG_MULTI_LINE);
			this.setImeOptions(EditorInfo.IME_ACTION_DONE);
		}
	}
	
	private class Viewer extends WebView {
		public Viewer(ExploreProblemInteraction anInteraction) {
			super(anInteraction.factory.getApplicationContext());
			setId(anInteraction.factory.newId());
		}
		
		public void setText(String aString) {
			viewer.loadDataWithBaseURL("fake.url.com", aString, "", "", "");
		}
	}
	
	private final Editor editor;
	private final Viewer viewer;
	
	public Problem(ExploreProblemInteraction anInteraction) {
		super(anInteraction.factory.getApplicationContext());
		setId(anInteraction.factory.newId());
		viewer = new Viewer(anInteraction);
		LayoutParams viewerParams = new LayoutParams(LayoutParams.FILL_PARENT, 
				LayoutParams.WRAP_CONTENT);
		editor = new Editor(anInteraction);
		LayoutParams editorParams = new LayoutParams(LayoutParams.FILL_PARENT, 
				LayoutParams.WRAP_CONTENT);
		viewerParams.addRule(ALIGN_PARENT_TOP);
		viewerParams.addRule(ABOVE, editor.getId());
		editorParams.addRule(ALIGN_PARENT_BOTTOM);
		addView(viewer, viewerParams);
		addView(editor, editorParams);

		editor.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View view, int keyCode, KeyEvent event) {
				if ((event.getAction() == KeyEvent.ACTION_DOWN) && 
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
					viewer.setText(editor.getText().toString());
					return true;
				}
				return false;
			}
		});

		editor.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
//				if (actionId == EditorInfo.IME_ACTION_DONE) {
					viewer.setText(editor.getText().toString());
//				}
				return false;
			}			
		});
	}
	
	public void setText(String aString) {
		viewer.setText(aString);
		editor.setText(aString);
	}
	
	public String getText() {
		return editor.getText().toString();
	}
	
	public void selectAll() {
		editor.selectAll();
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

package masumi.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
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

	static class Editor extends EditText {

        static class OnKeyPreImeListener {

            public OnKeyPreImeListener() {
            }

            public boolean onKeyPreIme(int keyCode, KeyEvent event) {
                return false;
            }
        }

        static class OnTextChangedListener implements TextWatcher {

            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do Nothing
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do Nothing
            }

            public void afterTextChanged(Editable editable) {
                // Do Nothing
            }
        }

        OnKeyPreImeListener keyPreImeListener;

		public Editor(ExploreProblemInteraction anInteraction) {
			super(anInteraction.factory.getApplicationContext());
			setId(anInteraction.factory.newId());
			setMinLines(5);
			setInputType(InputType.TYPE_CLASS_TEXT | 
					InputType.TYPE_TEXT_FLAG_MULTI_LINE);
			this.setImeOptions(EditorInfo.IME_ACTION_DONE);
            keyPreImeListener = null;
		}

        public void setOnKeyPreImeListener(OnKeyPreImeListener listener) {
            keyPreImeListener = listener;
        }

        @Override
        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyPreImeListener != null) {
                return keyPreImeListener.onKeyPreIme(keyCode, event);
            }
            return super.dispatchKeyEvent(event);
        }

	}
	
	static class Viewer extends WebView {
		public Viewer(ExploreProblemInteraction anInteraction) {
			super(anInteraction.factory.getApplicationContext());
			setId(anInteraction.factory.newId());
		}
		
		public void setText(String aString) {
            int scale = Math.round(100 * this.getScale());
            this.setInitialScale(scale);
			loadDataWithBaseURL("fake.url.com", aString, "", "UTF-8", "");
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
			public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					viewer.setText(editor.getText().toString());
				}
				return false;
			}			
		});

        editor.setOnKeyPreImeListener(new Editor.OnKeyPreImeListener() {
            public boolean onKeyPreIme(int KeyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                    viewer.setText(editor.getText().toString());
                }
                return editor.dispatchKeyEvent(event);
            }
        });

        editor.addTextChangedListener(new Editor.OnTextChangedListener() {
            public void afterTextChanged(Editable s) {
                viewer.setText(editor.getText().toString());
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

	public void add(Widget aWidget) {
		// Nothing to do
	}

	public void remove(Widget aWidget) {
		// Nothing to do
	}

	public boolean contains(Widget aWidget) {
		return false;
	}

}

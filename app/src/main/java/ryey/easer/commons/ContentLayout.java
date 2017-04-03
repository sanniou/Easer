package ryey.easer.commons;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ContentLayout extends LinearLayout {
    public ContentLayout(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);
    }

    public abstract void fill(StorageData data);

    public abstract StorageData getData();

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        View child;
        for (int i = 0; i < getChildCount(); i++) {
            child = getChildAt(i);
            setEnabled(child, enabled);
        }
    }

    protected static void setEnabled(View v, boolean enabled) {
        v.setEnabled(enabled);
        if (v instanceof ViewGroup) {
            View child;
            for (int i = 0; i < ((ViewGroup) v).getChildCount(); i++) {
                child = ((ViewGroup) v).getChildAt(i);
                setEnabled(child, enabled);
            }
        }
    }

    public static abstract class LabeledContentLayout extends ContentLayout {
        TextView textView;
        public LabeledContentLayout(Context context) {
            super(context);
            textView = new TextView(context);
            addView(textView);
        }

        protected void setDesc(String description) {
            textView.setText(description);
        }
    }
}
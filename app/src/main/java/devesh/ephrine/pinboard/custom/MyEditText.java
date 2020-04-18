package devesh.ephrine.pinboard.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import devesh.ephrine.pinboard.R;

public class MyEditText extends EditText {

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttributes(context, attrs);
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
      //  TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.Simplified);

        //int typefaceValue = values.getInt(R.styleable.Simplified_typeface, 0);
        //values.recycle();

       // setTypeface(MyFontUtil.obtaintTypeface(context, typefaceValue));
    }

}
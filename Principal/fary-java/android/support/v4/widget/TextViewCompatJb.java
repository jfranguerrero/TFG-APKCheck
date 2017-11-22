package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@TargetApi(16)
@RequiresApi(16)
class TextViewCompatJb
{
  TextViewCompatJb() {}
  
  static int getMaxLines(TextView paramTextView)
  {
    return paramTextView.getMaxLines();
  }
  
  static int getMinLines(TextView paramTextView)
  {
    return paramTextView.getMinLines();
  }
}

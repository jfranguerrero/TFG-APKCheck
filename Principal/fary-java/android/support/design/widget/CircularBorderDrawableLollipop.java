package android.support.design.widget;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.support.annotation.RequiresApi;

@TargetApi(21)
@RequiresApi(21)
class CircularBorderDrawableLollipop
  extends CircularBorderDrawable
{
  CircularBorderDrawableLollipop() {}
  
  public void getOutline(Outline paramOutline)
  {
    copyBounds(mRect);
    paramOutline.setOval(mRect);
  }
}

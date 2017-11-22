package android.support.v4.widget;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListPopupWindow;

@TargetApi(19)
@RequiresApi(19)
class ListPopupWindowCompatKitKat
{
  ListPopupWindowCompatKitKat() {}
  
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return ((ListPopupWindow)paramObject).createDragToOpenListener(paramView);
  }
}

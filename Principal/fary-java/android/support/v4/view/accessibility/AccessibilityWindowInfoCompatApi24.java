package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityWindowInfo;

@TargetApi(24)
@RequiresApi(24)
class AccessibilityWindowInfoCompatApi24
{
  AccessibilityWindowInfoCompatApi24() {}
  
  public static Object getAnchor(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getAnchor();
  }
  
  public static CharSequence getTitle(Object paramObject)
  {
    return ((AccessibilityWindowInfo)paramObject).getTitle();
  }
}

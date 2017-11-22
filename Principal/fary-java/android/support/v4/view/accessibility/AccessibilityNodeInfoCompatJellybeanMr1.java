package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(17)
@RequiresApi(17)
class AccessibilityNodeInfoCompatJellybeanMr1
{
  AccessibilityNodeInfoCompatJellybeanMr1() {}
  
  public static Object getLabelFor(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLabelFor();
  }
  
  public static Object getLabeledBy(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getLabeledBy();
  }
  
  public static void setLabelFor(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setLabelFor(paramView);
  }
  
  public static void setLabelFor(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLabelFor(paramView, paramInt);
  }
  
  public static void setLabeledBy(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setLabeledBy(paramView);
  }
  
  public static void setLabeledBy(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setLabeledBy(paramView, paramInt);
  }
}

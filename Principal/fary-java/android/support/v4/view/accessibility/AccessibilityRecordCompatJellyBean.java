package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

@TargetApi(16)
@RequiresApi(16)
class AccessibilityRecordCompatJellyBean
{
  AccessibilityRecordCompatJellyBean() {}
  
  public static void setSource(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setSource(paramView, paramInt);
  }
}

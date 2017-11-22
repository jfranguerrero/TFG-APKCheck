package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(18)
@RequiresApi(18)
class ViewGroupCompatJellybeanMR2
{
  ViewGroupCompatJellybeanMR2() {}
  
  public static int getLayoutMode(ViewGroup paramViewGroup)
  {
    return paramViewGroup.getLayoutMode();
  }
  
  public static void setLayoutMode(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.setLayoutMode(paramInt);
  }
}

package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(23)
@RequiresApi(23)
class ViewCompatMarshmallow
{
  ViewCompatMarshmallow() {}
  
  public static int getScrollIndicators(View paramView)
  {
    return paramView.getScrollIndicators();
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
  }
  
  public static void setScrollIndicators(View paramView, int paramInt)
  {
    paramView.setScrollIndicators(paramInt);
  }
  
  public static void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
  {
    paramView.setScrollIndicators(paramInt1, paramInt2);
  }
}

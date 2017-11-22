package android.support.transition;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class ViewGroupOverlay
  extends ViewOverlay
{
  ViewGroupOverlay(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    super(paramContext, paramViewGroup, paramView);
  }
  
  public static ViewGroupOverlay createFrom(ViewGroup paramViewGroup)
  {
    return (ViewGroupOverlay)ViewOverlay.createFrom(paramViewGroup);
  }
  
  public void add(View paramView)
  {
    mOverlayViewGroup.add(paramView);
  }
  
  public void remove(View paramView)
  {
    mOverlayViewGroup.remove(paramView);
  }
}

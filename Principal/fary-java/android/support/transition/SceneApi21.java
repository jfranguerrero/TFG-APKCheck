package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Scene;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(21)
@RequiresApi(21)
class SceneApi21
  extends SceneWrapper
{
  SceneApi21() {}
  
  public void enter()
  {
    mScene.enter();
  }
  
  public void init(ViewGroup paramViewGroup)
  {
    mScene = new Scene(paramViewGroup);
  }
  
  public void init(ViewGroup paramViewGroup, View paramView)
  {
    mScene = new Scene(paramViewGroup, paramView);
  }
}

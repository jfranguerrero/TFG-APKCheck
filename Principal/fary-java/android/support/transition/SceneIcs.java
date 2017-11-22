package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class SceneIcs
  extends SceneImpl
{
  ScenePort mScene;
  
  SceneIcs() {}
  
  public void enter()
  {
    mScene.enter();
  }
  
  public void exit()
  {
    mScene.exit();
  }
  
  public ViewGroup getSceneRoot()
  {
    return mScene.getSceneRoot();
  }
  
  public void init(ViewGroup paramViewGroup)
  {
    mScene = new ScenePort(paramViewGroup);
  }
  
  public void init(ViewGroup paramViewGroup, View paramView)
  {
    mScene = new ScenePort(paramViewGroup, paramView);
  }
  
  public void setEnterAction(Runnable paramRunnable)
  {
    mScene.setEnterAction(paramRunnable);
  }
  
  public void setExitAction(Runnable paramRunnable)
  {
    mScene.setExitAction(paramRunnable);
  }
}

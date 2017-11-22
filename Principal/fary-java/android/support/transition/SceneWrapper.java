package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Scene;
import android.view.ViewGroup;

@TargetApi(19)
@RequiresApi(19)
abstract class SceneWrapper
  extends SceneImpl
{
  Scene mScene;
  
  SceneWrapper() {}
  
  public void exit()
  {
    mScene.exit();
  }
  
  public ViewGroup getSceneRoot()
  {
    return mScene.getSceneRoot();
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

package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.ViewGroup;

@TargetApi(19)
@RequiresApi(19)
class TransitionManagerStaticsKitKat
  extends TransitionManagerStaticsImpl
{
  TransitionManagerStaticsKitKat() {}
  
  public void beginDelayedTransition(ViewGroup paramViewGroup)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup);
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, TransitionImpl paramTransitionImpl)
  {
    if (paramTransitionImpl == null) {}
    for (paramTransitionImpl = null;; paramTransitionImpl = mTransition)
    {
      TransitionManager.beginDelayedTransition(paramViewGroup, paramTransitionImpl);
      return;
    }
  }
  
  public void go(SceneImpl paramSceneImpl)
  {
    TransitionManager.go(mScene);
  }
  
  public void go(SceneImpl paramSceneImpl, TransitionImpl paramTransitionImpl)
  {
    Scene localScene = mScene;
    if (paramTransitionImpl == null) {}
    for (paramSceneImpl = null;; paramSceneImpl = mTransition)
    {
      TransitionManager.go(localScene, paramSceneImpl);
      return;
    }
  }
}

package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class TransitionManagerStaticsIcs
  extends TransitionManagerStaticsImpl
{
  TransitionManagerStaticsIcs() {}
  
  public void beginDelayedTransition(ViewGroup paramViewGroup)
  {
    TransitionManagerPort.beginDelayedTransition(paramViewGroup);
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, TransitionImpl paramTransitionImpl)
  {
    if (paramTransitionImpl == null) {}
    for (paramTransitionImpl = null;; paramTransitionImpl = mTransition)
    {
      TransitionManagerPort.beginDelayedTransition(paramViewGroup, paramTransitionImpl);
      return;
    }
  }
  
  public void go(SceneImpl paramSceneImpl)
  {
    TransitionManagerPort.go(mScene);
  }
  
  public void go(SceneImpl paramSceneImpl, TransitionImpl paramTransitionImpl)
  {
    ScenePort localScenePort = mScene;
    if (paramTransitionImpl == null) {}
    for (paramSceneImpl = null;; paramSceneImpl = mTransition)
    {
      TransitionManagerPort.go(localScenePort, paramSceneImpl);
      return;
    }
  }
}

package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionManagerIcs
  extends TransitionManagerImpl
{
  private final TransitionManagerPort mTransitionManager = new TransitionManagerPort();
  
  TransitionManagerIcs() {}
  
  public void setTransition(SceneImpl paramSceneImpl1, SceneImpl paramSceneImpl2, TransitionImpl paramTransitionImpl)
  {
    TransitionManagerPort localTransitionManagerPort = mTransitionManager;
    ScenePort localScenePort = mScene;
    paramSceneImpl2 = mScene;
    if (paramTransitionImpl == null) {}
    for (paramSceneImpl1 = null;; paramSceneImpl1 = mTransition)
    {
      localTransitionManagerPort.setTransition(localScenePort, paramSceneImpl2, paramSceneImpl1);
      return;
    }
  }
  
  public void setTransition(SceneImpl paramSceneImpl, TransitionImpl paramTransitionImpl)
  {
    TransitionManagerPort localTransitionManagerPort = mTransitionManager;
    ScenePort localScenePort = mScene;
    if (paramTransitionImpl == null) {}
    for (paramSceneImpl = null;; paramSceneImpl = mTransition)
    {
      localTransitionManagerPort.setTransition(localScenePort, paramSceneImpl);
      return;
    }
  }
  
  public void transitionTo(SceneImpl paramSceneImpl)
  {
    mTransitionManager.transitionTo(mScene);
  }
}

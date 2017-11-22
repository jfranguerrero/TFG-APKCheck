package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Scene;
import android.transition.TransitionManager;

@TargetApi(19)
@RequiresApi(19)
class TransitionManagerKitKat
  extends TransitionManagerImpl
{
  private final TransitionManager mTransitionManager = new TransitionManager();
  
  TransitionManagerKitKat() {}
  
  public void setTransition(SceneImpl paramSceneImpl1, SceneImpl paramSceneImpl2, TransitionImpl paramTransitionImpl)
  {
    TransitionManager localTransitionManager = mTransitionManager;
    Scene localScene = mScene;
    paramSceneImpl2 = mScene;
    if (paramTransitionImpl == null) {}
    for (paramSceneImpl1 = null;; paramSceneImpl1 = mTransition)
    {
      localTransitionManager.setTransition(localScene, paramSceneImpl2, paramSceneImpl1);
      return;
    }
  }
  
  public void setTransition(SceneImpl paramSceneImpl, TransitionImpl paramTransitionImpl)
  {
    TransitionManager localTransitionManager = mTransitionManager;
    Scene localScene = mScene;
    if (paramTransitionImpl == null) {}
    for (paramSceneImpl = null;; paramSceneImpl = mTransition)
    {
      localTransitionManager.setTransition(localScene, paramSceneImpl);
      return;
    }
  }
  
  public void transitionTo(SceneImpl paramSceneImpl)
  {
    mTransitionManager.transitionTo(mScene);
  }
}

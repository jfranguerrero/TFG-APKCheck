package android.support.transition;

import android.view.ViewGroup;

abstract class TransitionManagerStaticsImpl
{
  TransitionManagerStaticsImpl() {}
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, TransitionImpl paramTransitionImpl);
  
  public abstract void go(SceneImpl paramSceneImpl);
  
  public abstract void go(SceneImpl paramSceneImpl, TransitionImpl paramTransitionImpl);
}

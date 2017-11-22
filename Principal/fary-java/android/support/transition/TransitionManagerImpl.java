package android.support.transition;

abstract class TransitionManagerImpl
{
  TransitionManagerImpl() {}
  
  public abstract void setTransition(SceneImpl paramSceneImpl1, SceneImpl paramSceneImpl2, TransitionImpl paramTransitionImpl);
  
  public abstract void setTransition(SceneImpl paramSceneImpl, TransitionImpl paramTransitionImpl);
  
  public abstract void transitionTo(SceneImpl paramSceneImpl);
}

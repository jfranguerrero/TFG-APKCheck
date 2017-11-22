package android.support.transition;

abstract interface TransitionSetImpl
{
  public abstract TransitionSetImpl addTransition(TransitionImpl paramTransitionImpl);
  
  public abstract int getOrdering();
  
  public abstract TransitionSetImpl removeTransition(TransitionImpl paramTransitionImpl);
  
  public abstract TransitionSetImpl setOrdering(int paramInt);
}

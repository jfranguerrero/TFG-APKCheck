package android.support.transition;

abstract interface TransitionInterfaceListener<TransitionT extends TransitionInterface>
{
  public abstract void onTransitionCancel(TransitionT paramTransitionT);
  
  public abstract void onTransitionEnd(TransitionT paramTransitionT);
  
  public abstract void onTransitionPause(TransitionT paramTransitionT);
  
  public abstract void onTransitionResume(TransitionT paramTransitionT);
  
  public abstract void onTransitionStart(TransitionT paramTransitionT);
}

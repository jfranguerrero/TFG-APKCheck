package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;

abstract interface VisibilityInterface
  extends TransitionInterface
{
  public abstract boolean isVisible(TransitionValues paramTransitionValues);
  
  public abstract Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2);
  
  public abstract Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2);
}

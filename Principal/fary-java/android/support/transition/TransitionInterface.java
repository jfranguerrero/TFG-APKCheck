package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;

abstract interface TransitionInterface
{
  public abstract void captureEndValues(TransitionValues paramTransitionValues);
  
  public abstract void captureStartValues(TransitionValues paramTransitionValues);
  
  public abstract Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2);
}

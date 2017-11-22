package android.support.transition;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

public class TransitionSet
  extends Transition
{
  public static final int ORDERING_SEQUENTIAL = 1;
  public static final int ORDERING_TOGETHER = 0;
  
  public TransitionSet()
  {
    super(true);
    if (Build.VERSION.SDK_INT < 19)
    {
      mImpl = new TransitionSetIcs(this);
      return;
    }
    mImpl = new TransitionSetKitKat(this);
  }
  
  @NonNull
  public TransitionSet addTransition(@NonNull Transition paramTransition)
  {
    ((TransitionSetImpl)mImpl).addTransition(mImpl);
    return this;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    mImpl.captureEndValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    mImpl.captureStartValues(paramTransitionValues);
  }
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @NonNull TransitionValues paramTransitionValues1, @NonNull TransitionValues paramTransitionValues2)
  {
    return mImpl.createAnimator(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
  }
  
  public int getOrdering()
  {
    return ((TransitionSetImpl)mImpl).getOrdering();
  }
  
  @NonNull
  public TransitionSet removeTransition(@NonNull Transition paramTransition)
  {
    ((TransitionSetImpl)mImpl).removeTransition(mImpl);
    return this;
  }
  
  @NonNull
  public TransitionSet setOrdering(int paramInt)
  {
    ((TransitionSetImpl)mImpl).setOrdering(paramInt);
    return this;
  }
}

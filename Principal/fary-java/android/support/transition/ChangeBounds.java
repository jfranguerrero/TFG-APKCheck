package android.support.transition;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

public class ChangeBounds
  extends Transition
{
  public ChangeBounds()
  {
    super(true);
    if (Build.VERSION.SDK_INT < 19)
    {
      mImpl = new ChangeBoundsIcs(this);
      return;
    }
    mImpl = new ChangeBoundsKitKat(this);
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
  
  public void setResizeClip(boolean paramBoolean)
  {
    ((ChangeBoundsInterface)mImpl).setResizeClip(paramBoolean);
  }
}

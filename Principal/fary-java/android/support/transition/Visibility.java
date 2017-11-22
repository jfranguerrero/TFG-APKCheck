package android.support.transition;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public abstract class Visibility
  extends Transition
  implements VisibilityInterface
{
  public Visibility()
  {
    this(false);
  }
  
  Visibility(boolean paramBoolean)
  {
    super(true);
    if (!paramBoolean) {
      if (Build.VERSION.SDK_INT < 19) {
        break label37;
      }
    }
    label37:
    for (mImpl = new VisibilityKitKat();; mImpl = new VisibilityIcs())
    {
      mImpl.init(this);
      return;
    }
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    mImpl.captureEndValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    mImpl.captureStartValues(paramTransitionValues);
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues)
  {
    return ((VisibilityImpl)mImpl).isVisible(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((VisibilityImpl)mImpl).onAppear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((VisibilityImpl)mImpl).onDisappear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
  }
}

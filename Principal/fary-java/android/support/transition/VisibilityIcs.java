package android.support.transition;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class VisibilityIcs
  extends TransitionIcs
  implements VisibilityImpl
{
  VisibilityIcs() {}
  
  public void init(TransitionInterface paramTransitionInterface, Object paramObject)
  {
    mExternalTransition = paramTransitionInterface;
    if (paramObject == null)
    {
      mTransition = new VisibilityWrapper((VisibilityInterface)paramTransitionInterface);
      return;
    }
    mTransition = ((VisibilityPort)paramObject);
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues)
  {
    return ((VisibilityPort)mTransition).isVisible(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((VisibilityPort)mTransition).onAppear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((VisibilityPort)mTransition).onDisappear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
  }
  
  private static class VisibilityWrapper
    extends VisibilityPort
  {
    private VisibilityInterface mVisibility;
    
    VisibilityWrapper(VisibilityInterface paramVisibilityInterface)
    {
      mVisibility = paramVisibilityInterface;
    }
    
    public void captureEndValues(TransitionValues paramTransitionValues)
    {
      mVisibility.captureEndValues(paramTransitionValues);
    }
    
    public void captureStartValues(TransitionValues paramTransitionValues)
    {
      mVisibility.captureStartValues(paramTransitionValues);
    }
    
    public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
    {
      return mVisibility.createAnimator(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
    }
    
    public boolean isVisible(TransitionValues paramTransitionValues)
    {
      return mVisibility.isVisible(paramTransitionValues);
    }
    
    public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
    {
      return mVisibility.onAppear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
    }
    
    public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
    {
      return mVisibility.onDisappear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
    }
  }
}

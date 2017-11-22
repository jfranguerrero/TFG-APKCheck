package android.support.transition;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Visibility;
import android.view.ViewGroup;

@TargetApi(19)
@RequiresApi(19)
class VisibilityKitKat
  extends TransitionKitKat
  implements VisibilityImpl
{
  VisibilityKitKat() {}
  
  public void init(TransitionInterface paramTransitionInterface, Object paramObject)
  {
    mExternalTransition = paramTransitionInterface;
    if (paramObject == null)
    {
      mTransition = new VisibilityWrapper((VisibilityInterface)paramTransitionInterface);
      return;
    }
    mTransition = ((Visibility)paramObject);
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues)
  {
    return ((Visibility)mTransition).isVisible(convertToPlatform(paramTransitionValues));
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((Visibility)mTransition).onAppear(paramViewGroup, convertToPlatform(paramTransitionValues1), paramInt1, convertToPlatform(paramTransitionValues2), paramInt2);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((Visibility)mTransition).onDisappear(paramViewGroup, convertToPlatform(paramTransitionValues1), paramInt1, convertToPlatform(paramTransitionValues2), paramInt2);
  }
  
  private static class VisibilityWrapper
    extends Visibility
  {
    private final VisibilityInterface mVisibility;
    
    VisibilityWrapper(VisibilityInterface paramVisibilityInterface)
    {
      mVisibility = paramVisibilityInterface;
    }
    
    public void captureEndValues(android.transition.TransitionValues paramTransitionValues)
    {
      TransitionKitKat.wrapCaptureEndValues(mVisibility, paramTransitionValues);
    }
    
    public void captureStartValues(android.transition.TransitionValues paramTransitionValues)
    {
      TransitionKitKat.wrapCaptureStartValues(mVisibility, paramTransitionValues);
    }
    
    public Animator createAnimator(ViewGroup paramViewGroup, android.transition.TransitionValues paramTransitionValues1, android.transition.TransitionValues paramTransitionValues2)
    {
      return mVisibility.createAnimator(paramViewGroup, TransitionKitKat.convertToSupport(paramTransitionValues1), TransitionKitKat.convertToSupport(paramTransitionValues2));
    }
    
    public boolean isVisible(android.transition.TransitionValues paramTransitionValues)
    {
      if (paramTransitionValues == null) {
        return false;
      }
      TransitionValues localTransitionValues = new TransitionValues();
      TransitionKitKat.copyValues(paramTransitionValues, localTransitionValues);
      return mVisibility.isVisible(localTransitionValues);
    }
    
    public Animator onAppear(ViewGroup paramViewGroup, android.transition.TransitionValues paramTransitionValues1, int paramInt1, android.transition.TransitionValues paramTransitionValues2, int paramInt2)
    {
      return mVisibility.onAppear(paramViewGroup, TransitionKitKat.convertToSupport(paramTransitionValues1), paramInt1, TransitionKitKat.convertToSupport(paramTransitionValues2), paramInt2);
    }
    
    public Animator onDisappear(ViewGroup paramViewGroup, android.transition.TransitionValues paramTransitionValues1, int paramInt1, android.transition.TransitionValues paramTransitionValues2, int paramInt2)
    {
      return mVisibility.onDisappear(paramViewGroup, TransitionKitKat.convertToSupport(paramTransitionValues1), paramInt1, TransitionKitKat.convertToSupport(paramTransitionValues2), paramInt2);
    }
  }
}

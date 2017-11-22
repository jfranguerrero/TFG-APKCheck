package android.support.transition;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class FadeIcs
  extends TransitionIcs
  implements VisibilityImpl
{
  public FadeIcs(TransitionInterface paramTransitionInterface)
  {
    init(paramTransitionInterface, new FadePort());
  }
  
  public FadeIcs(TransitionInterface paramTransitionInterface, int paramInt)
  {
    init(paramTransitionInterface, new FadePort(paramInt));
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues)
  {
    return ((FadePort)mTransition).isVisible(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((FadePort)mTransition).onAppear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues2, paramInt2);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return ((FadePort)mTransition).onDisappear(paramViewGroup, paramTransitionValues1, paramInt1, paramTransitionValues1, paramInt1);
  }
}

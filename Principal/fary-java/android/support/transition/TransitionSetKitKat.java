package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.TransitionSet;

@TargetApi(19)
@RequiresApi(19)
class TransitionSetKitKat
  extends TransitionKitKat
  implements TransitionSetImpl
{
  private TransitionSet mTransitionSet = new TransitionSet();
  
  public TransitionSetKitKat(TransitionInterface paramTransitionInterface)
  {
    init(paramTransitionInterface, mTransitionSet);
  }
  
  public TransitionSetKitKat addTransition(TransitionImpl paramTransitionImpl)
  {
    mTransitionSet.addTransition(mTransition);
    return this;
  }
  
  public int getOrdering()
  {
    return mTransitionSet.getOrdering();
  }
  
  public TransitionSetKitKat removeTransition(TransitionImpl paramTransitionImpl)
  {
    mTransitionSet.removeTransition(mTransition);
    return this;
  }
  
  public TransitionSetKitKat setOrdering(int paramInt)
  {
    mTransitionSet.setOrdering(paramInt);
    return this;
  }
}

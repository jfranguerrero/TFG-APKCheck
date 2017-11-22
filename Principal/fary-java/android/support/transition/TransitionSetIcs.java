package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionSetIcs
  extends TransitionIcs
  implements TransitionSetImpl
{
  private TransitionSetPort mTransitionSet = new TransitionSetPort();
  
  public TransitionSetIcs(TransitionInterface paramTransitionInterface)
  {
    init(paramTransitionInterface, mTransitionSet);
  }
  
  public TransitionSetIcs addTransition(TransitionImpl paramTransitionImpl)
  {
    mTransitionSet.addTransition(mTransition);
    return this;
  }
  
  public int getOrdering()
  {
    return mTransitionSet.getOrdering();
  }
  
  public TransitionSetIcs removeTransition(TransitionImpl paramTransitionImpl)
  {
    mTransitionSet.removeTransition(mTransition);
    return this;
  }
  
  public TransitionSetIcs setOrdering(int paramInt)
  {
    mTransitionSet.setOrdering(paramInt);
    return this;
  }
}

package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Transition;

@TargetApi(23)
@RequiresApi(23)
class TransitionApi23
  extends TransitionKitKat
{
  TransitionApi23() {}
  
  public TransitionImpl removeTarget(int paramInt)
  {
    mTransition.removeTarget(paramInt);
    return this;
  }
}

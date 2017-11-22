package android.support.transition;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;

@TargetApi(14)
@RequiresApi(14)
class ChangeBoundsIcs
  extends TransitionIcs
  implements ChangeBoundsInterface
{
  public ChangeBoundsIcs(TransitionInterface paramTransitionInterface)
  {
    init(paramTransitionInterface, new ChangeBoundsPort());
  }
  
  public void setResizeClip(boolean paramBoolean)
  {
    ((ChangeBoundsPort)mTransition).setResizeClip(paramBoolean);
  }
}

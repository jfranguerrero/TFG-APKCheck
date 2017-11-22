package android.support.design.internal;

import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.ViewGroup;

class BottomNavigationAnimationHelperIcs
  extends BottomNavigationAnimationHelperBase
{
  private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
  private final TransitionSet mSet = new AutoTransition();
  
  BottomNavigationAnimationHelperIcs()
  {
    mSet.setOrdering(0);
    mSet.setDuration(115L);
    mSet.setInterpolator(new FastOutSlowInInterpolator());
    TextScale localTextScale = new TextScale();
    mSet.addTransition(localTextScale);
  }
  
  void beginDelayedTransition(ViewGroup paramViewGroup)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, mSet);
  }
}

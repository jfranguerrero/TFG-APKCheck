package android.support.design.widget;

import android.util.StateSet;
import java.util.ArrayList;

final class StateListAnimator
{
  private final ValueAnimatorCompat.AnimatorListener mAnimationListener = new ValueAnimatorCompat.AnimatorListenerAdapter()
  {
    public void onAnimationEnd(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
    {
      if (mRunningAnimator == paramAnonymousValueAnimatorCompat) {
        mRunningAnimator = null;
      }
    }
  };
  private Tuple mLastMatch = null;
  ValueAnimatorCompat mRunningAnimator = null;
  private final ArrayList<Tuple> mTuples = new ArrayList();
  
  StateListAnimator() {}
  
  private void cancel()
  {
    if (mRunningAnimator != null)
    {
      mRunningAnimator.cancel();
      mRunningAnimator = null;
    }
  }
  
  private void start(Tuple paramTuple)
  {
    mRunningAnimator = mAnimator;
    mRunningAnimator.start();
  }
  
  public void addState(int[] paramArrayOfInt, ValueAnimatorCompat paramValueAnimatorCompat)
  {
    paramArrayOfInt = new Tuple(paramArrayOfInt, paramValueAnimatorCompat);
    paramValueAnimatorCompat.addListener(mAnimationListener);
    mTuples.add(paramArrayOfInt);
  }
  
  public void jumpToCurrentState()
  {
    if (mRunningAnimator != null)
    {
      mRunningAnimator.end();
      mRunningAnimator = null;
    }
  }
  
  void setState(int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    int j = mTuples.size();
    int i = 0;
    Object localObject1 = localObject2;
    if (i < j)
    {
      localObject1 = (Tuple)mTuples.get(i);
      if (!StateSet.stateSetMatches(mSpecs, paramArrayOfInt)) {}
    }
    else
    {
      if (localObject1 != mLastMatch) {
        break label64;
      }
    }
    label64:
    do
    {
      return;
      i += 1;
      break;
      if (mLastMatch != null) {
        cancel();
      }
      mLastMatch = ((Tuple)localObject1);
    } while (localObject1 == null);
    start((Tuple)localObject1);
  }
  
  static class Tuple
  {
    final ValueAnimatorCompat mAnimator;
    final int[] mSpecs;
    
    Tuple(int[] paramArrayOfInt, ValueAnimatorCompat paramValueAnimatorCompat)
    {
      mSpecs = paramArrayOfInt;
      mAnimator = paramValueAnimatorCompat;
    }
  }
}

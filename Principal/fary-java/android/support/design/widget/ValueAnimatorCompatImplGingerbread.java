package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class ValueAnimatorCompatImplGingerbread
  extends ValueAnimatorCompat.Impl
{
  private static final int DEFAULT_DURATION = 200;
  private static final int HANDLER_DELAY = 10;
  private static final Handler sHandler = new Handler(Looper.getMainLooper());
  private float mAnimatedFraction;
  private long mDuration = 200L;
  private final float[] mFloatValues = new float[2];
  private final int[] mIntValues = new int[2];
  private Interpolator mInterpolator;
  private boolean mIsRunning;
  private ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> mListeners;
  private final Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      update();
    }
  };
  private long mStartTime;
  private ArrayList<ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy> mUpdateListeners;
  
  ValueAnimatorCompatImplGingerbread() {}
  
  private void dispatchAnimationCancel()
  {
    if (mListeners != null)
    {
      int i = 0;
      int j = mListeners.size();
      while (i < j)
      {
        ((ValueAnimatorCompat.Impl.AnimatorListenerProxy)mListeners.get(i)).onAnimationCancel();
        i += 1;
      }
    }
  }
  
  private void dispatchAnimationEnd()
  {
    if (mListeners != null)
    {
      int i = 0;
      int j = mListeners.size();
      while (i < j)
      {
        ((ValueAnimatorCompat.Impl.AnimatorListenerProxy)mListeners.get(i)).onAnimationEnd();
        i += 1;
      }
    }
  }
  
  private void dispatchAnimationStart()
  {
    if (mListeners != null)
    {
      int i = 0;
      int j = mListeners.size();
      while (i < j)
      {
        ((ValueAnimatorCompat.Impl.AnimatorListenerProxy)mListeners.get(i)).onAnimationStart();
        i += 1;
      }
    }
  }
  
  private void dispatchAnimationUpdate()
  {
    if (mUpdateListeners != null)
    {
      int i = 0;
      int j = mUpdateListeners.size();
      while (i < j)
      {
        ((ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy)mUpdateListeners.get(i)).onAnimationUpdate();
        i += 1;
      }
    }
  }
  
  public void addListener(ValueAnimatorCompat.Impl.AnimatorListenerProxy paramAnimatorListenerProxy)
  {
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    mListeners.add(paramAnimatorListenerProxy);
  }
  
  public void addUpdateListener(ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy)
  {
    if (mUpdateListeners == null) {
      mUpdateListeners = new ArrayList();
    }
    mUpdateListeners.add(paramAnimatorUpdateListenerProxy);
  }
  
  public void cancel()
  {
    mIsRunning = false;
    sHandler.removeCallbacks(mRunnable);
    dispatchAnimationCancel();
    dispatchAnimationEnd();
  }
  
  public void end()
  {
    if (mIsRunning)
    {
      mIsRunning = false;
      sHandler.removeCallbacks(mRunnable);
      mAnimatedFraction = 1.0F;
      dispatchAnimationUpdate();
      dispatchAnimationEnd();
    }
  }
  
  public float getAnimatedFloatValue()
  {
    return AnimationUtils.lerp(mFloatValues[0], mFloatValues[1], getAnimatedFraction());
  }
  
  public float getAnimatedFraction()
  {
    return mAnimatedFraction;
  }
  
  public int getAnimatedIntValue()
  {
    return AnimationUtils.lerp(mIntValues[0], mIntValues[1], getAnimatedFraction());
  }
  
  public long getDuration()
  {
    return mDuration;
  }
  
  public boolean isRunning()
  {
    return mIsRunning;
  }
  
  public void setDuration(long paramLong)
  {
    mDuration = paramLong;
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    mFloatValues[0] = paramFloat1;
    mFloatValues[1] = paramFloat2;
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    mIntValues[0] = paramInt1;
    mIntValues[1] = paramInt2;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    mInterpolator = paramInterpolator;
  }
  
  public void start()
  {
    if (mIsRunning) {
      return;
    }
    if (mInterpolator == null) {
      mInterpolator = new AccelerateDecelerateInterpolator();
    }
    mIsRunning = true;
    mAnimatedFraction = 0.0F;
    startInternal();
  }
  
  final void startInternal()
  {
    mStartTime = SystemClock.uptimeMillis();
    dispatchAnimationUpdate();
    dispatchAnimationStart();
    sHandler.postDelayed(mRunnable, 10L);
  }
  
  final void update()
  {
    if (mIsRunning)
    {
      float f2 = MathUtils.constrain((float)(SystemClock.uptimeMillis() - mStartTime) / (float)mDuration, 0.0F, 1.0F);
      float f1 = f2;
      if (mInterpolator != null) {
        f1 = mInterpolator.getInterpolation(f2);
      }
      mAnimatedFraction = f1;
      dispatchAnimationUpdate();
      if (SystemClock.uptimeMillis() >= mStartTime + mDuration)
      {
        mIsRunning = false;
        dispatchAnimationEnd();
      }
    }
    if (mIsRunning) {
      sHandler.postDelayed(mRunnable, 10L);
    }
  }
}

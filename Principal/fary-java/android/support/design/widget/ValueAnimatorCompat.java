package android.support.design.widget;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;

class ValueAnimatorCompat
{
  private final Impl mImpl;
  
  ValueAnimatorCompat(Impl paramImpl)
  {
    mImpl = paramImpl;
  }
  
  public void addListener(final AnimatorListener paramAnimatorListener)
  {
    if (paramAnimatorListener != null)
    {
      mImpl.addListener(new ValueAnimatorCompat.Impl.AnimatorListenerProxy()
      {
        public void onAnimationCancel()
        {
          paramAnimatorListener.onAnimationCancel(ValueAnimatorCompat.this);
        }
        
        public void onAnimationEnd()
        {
          paramAnimatorListener.onAnimationEnd(ValueAnimatorCompat.this);
        }
        
        public void onAnimationStart()
        {
          paramAnimatorListener.onAnimationStart(ValueAnimatorCompat.this);
        }
      });
      return;
    }
    mImpl.addListener(null);
  }
  
  public void addUpdateListener(final AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (paramAnimatorUpdateListener != null)
    {
      mImpl.addUpdateListener(new ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy()
      {
        public void onAnimationUpdate()
        {
          paramAnimatorUpdateListener.onAnimationUpdate(ValueAnimatorCompat.this);
        }
      });
      return;
    }
    mImpl.addUpdateListener(null);
  }
  
  public void cancel()
  {
    mImpl.cancel();
  }
  
  public void end()
  {
    mImpl.end();
  }
  
  public float getAnimatedFloatValue()
  {
    return mImpl.getAnimatedFloatValue();
  }
  
  public float getAnimatedFraction()
  {
    return mImpl.getAnimatedFraction();
  }
  
  public int getAnimatedIntValue()
  {
    return mImpl.getAnimatedIntValue();
  }
  
  public long getDuration()
  {
    return mImpl.getDuration();
  }
  
  public boolean isRunning()
  {
    return mImpl.isRunning();
  }
  
  public void setDuration(long paramLong)
  {
    mImpl.setDuration(paramLong);
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    mImpl.setFloatValues(paramFloat1, paramFloat2);
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    mImpl.setIntValues(paramInt1, paramInt2);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    mImpl.setInterpolator(paramInterpolator);
  }
  
  public void start()
  {
    mImpl.start();
  }
  
  static abstract interface AnimatorListener
  {
    public abstract void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat);
    
    public abstract void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat);
    
    public abstract void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat);
  }
  
  static class AnimatorListenerAdapter
    implements ValueAnimatorCompat.AnimatorListener
  {
    AnimatorListenerAdapter() {}
    
    public void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat) {}
    
    public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat) {}
    
    public void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat) {}
  }
  
  static abstract interface AnimatorUpdateListener
  {
    public abstract void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat);
  }
  
  static abstract interface Creator
  {
    @NonNull
    public abstract ValueAnimatorCompat createAnimator();
  }
  
  static abstract class Impl
  {
    Impl() {}
    
    abstract void addListener(AnimatorListenerProxy paramAnimatorListenerProxy);
    
    abstract void addUpdateListener(AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy);
    
    abstract void cancel();
    
    abstract void end();
    
    abstract float getAnimatedFloatValue();
    
    abstract float getAnimatedFraction();
    
    abstract int getAnimatedIntValue();
    
    abstract long getDuration();
    
    abstract boolean isRunning();
    
    abstract void setDuration(long paramLong);
    
    abstract void setFloatValues(float paramFloat1, float paramFloat2);
    
    abstract void setIntValues(int paramInt1, int paramInt2);
    
    abstract void setInterpolator(Interpolator paramInterpolator);
    
    abstract void start();
    
    static abstract interface AnimatorListenerProxy
    {
      public abstract void onAnimationCancel();
      
      public abstract void onAnimationEnd();
      
      public abstract void onAnimationStart();
    }
    
    static abstract interface AnimatorUpdateListenerProxy
    {
      public abstract void onAnimationUpdate();
    }
  }
}

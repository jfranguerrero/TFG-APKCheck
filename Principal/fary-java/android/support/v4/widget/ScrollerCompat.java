package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public final class ScrollerCompat
{
  private final boolean mIsIcsOrNewer;
  OverScroller mScroller;
  
  ScrollerCompat(boolean paramBoolean, Context paramContext, Interpolator paramInterpolator)
  {
    mIsIcsOrNewer = paramBoolean;
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      mScroller = paramContext;
      return;
    }
  }
  
  public static ScrollerCompat create(Context paramContext)
  {
    return create(paramContext, null);
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false) {
      return new ScrollerCompat(bool, paramContext, paramInterpolator);
    }
  }
  
  public void abortAnimation()
  {
    mScroller.abortAnimation();
  }
  
  public boolean computeScrollOffset()
  {
    return mScroller.computeScrollOffset();
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    mScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public float getCurrVelocity()
  {
    if (mIsIcsOrNewer) {
      return ScrollerCompatIcs.getCurrVelocity(mScroller);
    }
    return 0.0F;
  }
  
  public int getCurrX()
  {
    return mScroller.getCurrX();
  }
  
  public int getCurrY()
  {
    return mScroller.getCurrY();
  }
  
  public int getFinalX()
  {
    return mScroller.getFinalX();
  }
  
  public int getFinalY()
  {
    return mScroller.getFinalY();
  }
  
  public boolean isFinished()
  {
    return mScroller.isFinished();
  }
  
  public boolean isOverScrolled()
  {
    return mScroller.isOverScrolled();
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    mScroller.notifyHorizontalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    mScroller.notifyVerticalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return mScroller.springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mScroller.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}

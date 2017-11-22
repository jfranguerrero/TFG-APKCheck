package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int mTempLeftRightOffset = 0;
  private int mTempTopBottomOffset = 0;
  private ViewOffsetHelper mViewOffsetHelper;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getLeftAndRightOffset()
  {
    if (mViewOffsetHelper != null) {
      return mViewOffsetHelper.getLeftAndRightOffset();
    }
    return 0;
  }
  
  public int getTopAndBottomOffset()
  {
    if (mViewOffsetHelper != null) {
      return mViewOffsetHelper.getTopAndBottomOffset();
    }
    return 0;
  }
  
  protected void layoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    layoutChild(paramCoordinatorLayout, paramV, paramInt);
    if (mViewOffsetHelper == null) {
      mViewOffsetHelper = new ViewOffsetHelper(paramV);
    }
    mViewOffsetHelper.onViewLayout();
    if (mTempTopBottomOffset != 0)
    {
      mViewOffsetHelper.setTopAndBottomOffset(mTempTopBottomOffset);
      mTempTopBottomOffset = 0;
    }
    if (mTempLeftRightOffset != 0)
    {
      mViewOffsetHelper.setLeftAndRightOffset(mTempLeftRightOffset);
      mTempLeftRightOffset = 0;
    }
    return true;
  }
  
  public boolean setLeftAndRightOffset(int paramInt)
  {
    if (mViewOffsetHelper != null) {
      return mViewOffsetHelper.setLeftAndRightOffset(paramInt);
    }
    mTempLeftRightOffset = paramInt;
    return false;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    if (mViewOffsetHelper != null) {
      return mViewOffsetHelper.setTopAndBottomOffset(paramInt);
    }
    mTempTopBottomOffset = paramInt;
    return false;
  }
}

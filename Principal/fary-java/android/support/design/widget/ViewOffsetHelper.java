package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class ViewOffsetHelper
{
  private int mLayoutLeft;
  private int mLayoutTop;
  private int mOffsetLeft;
  private int mOffsetTop;
  private final View mView;
  
  public ViewOffsetHelper(View paramView)
  {
    mView = paramView;
  }
  
  private void updateOffsets()
  {
    ViewCompat.offsetTopAndBottom(mView, mOffsetTop - (mView.getTop() - mLayoutTop));
    ViewCompat.offsetLeftAndRight(mView, mOffsetLeft - (mView.getLeft() - mLayoutLeft));
  }
  
  public int getLayoutLeft()
  {
    return mLayoutLeft;
  }
  
  public int getLayoutTop()
  {
    return mLayoutTop;
  }
  
  public int getLeftAndRightOffset()
  {
    return mOffsetLeft;
  }
  
  public int getTopAndBottomOffset()
  {
    return mOffsetTop;
  }
  
  public void onViewLayout()
  {
    mLayoutTop = mView.getTop();
    mLayoutLeft = mView.getLeft();
    updateOffsets();
  }
  
  public boolean setLeftAndRightOffset(int paramInt)
  {
    if (mOffsetLeft != paramInt)
    {
      mOffsetLeft = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    if (mOffsetTop != paramInt)
    {
      mOffsetTop = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
}

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ButtonBarLayout
  extends LinearLayout
{
  private static final int ALLOW_STACKING_MIN_HEIGHT_DP = 320;
  private static final int PEEK_BUTTON_DP = 16;
  private boolean mAllowStacking;
  private int mLastWidthSize = -1;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (ConfigurationHelper.getScreenHeightDp(getResources()) >= 320) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ButtonBarLayout);
      mAllowStacking = paramContext.getBoolean(R.styleable.ButtonBarLayout_allowStacking, bool);
      paramContext.recycle();
      return;
    }
  }
  
  private int getNextVisibleChildIndex(int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private boolean isStacked()
  {
    return getOrientation() == 1;
  }
  
  private void setStacked(boolean paramBoolean)
  {
    label17:
    View localView;
    if (paramBoolean)
    {
      i = 1;
      setOrientation(i);
      if (!paramBoolean) {
        break label78;
      }
      i = 5;
      setGravity(i);
      localView = findViewById(R.id.spacer);
      if (localView != null) {
        if (!paramBoolean) {
          break label84;
        }
      }
    }
    label78:
    label84:
    for (int i = 8;; i = 4)
    {
      localView.setVisibility(i);
      i = getChildCount() - 2;
      while (i >= 0)
      {
        bringChildToFront(getChildAt(i));
        i -= 1;
      }
      i = 0;
      break;
      i = 80;
      break label17;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1);
    if (mAllowStacking)
    {
      if ((m > mLastWidthSize) && (isStacked())) {
        setStacked(false);
      }
      mLastWidthSize = m;
    }
    int i = 0;
    int j;
    int k;
    if ((!isStacked()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = View.MeasureSpec.makeMeasureSpec(m, Integer.MIN_VALUE);
      i = 1;
      super.onMeasure(j, paramInt2);
      k = i;
      if (mAllowStacking)
      {
        k = i;
        if (!isStacked())
        {
          if (Build.VERSION.SDK_INT < 11) {
            break label275;
          }
          if ((ViewCompat.getMeasuredWidthAndState(this) & 0xFF000000) != 16777216) {
            break label269;
          }
          j = 1;
          label119:
          k = i;
          if (j != 0)
          {
            setStacked(true);
            k = 1;
          }
        }
      }
      if (k != 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
      paramInt1 = 0;
      i = getNextVisibleChildIndex(0);
      if (i >= 0)
      {
        View localView = getChildAt(i);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramInt2 = 0 + (getPaddingTop() + localView.getMeasuredHeight() + topMargin + bottomMargin);
        if (!isStacked()) {
          break label346;
        }
        i = getNextVisibleChildIndex(i + 1);
        paramInt1 = paramInt2;
        if (i < 0) {}
      }
    }
    label269:
    label275:
    label346:
    for (paramInt1 = (int)(paramInt2 + (getChildAt(i).getPaddingTop() + 16.0F * getResourcesgetDisplayMetricsdensity));; paramInt1 = paramInt2 + getPaddingBottom())
    {
      if (ViewCompat.getMinimumHeight(this) != paramInt1) {
        setMinimumHeight(paramInt1);
      }
      return;
      j = paramInt1;
      break;
      j = 0;
      break label119;
      k = 0;
      j = 0;
      int n = getChildCount();
      while (j < n)
      {
        k += getChildAt(j).getMeasuredWidth();
        j += 1;
      }
      if (getPaddingLeft() + k + getPaddingRight() > m) {}
      for (j = 1;; j = 0) {
        break;
      }
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (mAllowStacking != paramBoolean)
    {
      mAllowStacking = paramBoolean;
      if ((!mAllowStacking) && (getOrientation() == 1)) {
        setStacked(false);
      }
      requestLayout();
    }
  }
}

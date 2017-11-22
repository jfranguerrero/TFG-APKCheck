package android.support.design.internal;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout
  extends ViewGroup
{
  private int mBaseline = -1;
  
  public BaselineLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public BaselineLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    return mBaseline;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    int i = getPaddingTop();
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() == 8)
      {
        paramInt2 += 1;
      }
      else
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        int i2 = k + (paramInt3 - paramInt1 - m - k - n) / 2;
        if ((mBaseline != -1) && (localView.getBaseline() != -1)) {}
        for (paramInt4 = mBaseline + i - localView.getBaseline();; paramInt4 = i)
        {
          localView.layout(i2, paramInt4, i2 + n, paramInt4 + i1);
          break;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = getChildCount();
    int i3 = 0;
    int i = 0;
    int j = -1;
    int k = -1;
    int i1 = 0;
    int i2 = 0;
    if (i2 < i4)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        i2 += 1;
        break;
        measureChild(localView, paramInt1, paramInt2);
        int i5 = localView.getBaseline();
        int n = j;
        m = k;
        if (i5 != -1)
        {
          n = Math.max(j, i5);
          m = Math.max(k, localView.getMeasuredHeight() - i5);
        }
        i3 = Math.max(i3, localView.getMeasuredWidth());
        i = Math.max(i, localView.getMeasuredHeight());
        i1 = ViewUtils.combineMeasuredStates(i1, ViewCompat.getMeasuredState(localView));
        j = n;
        k = m;
      }
    }
    int m = i;
    if (j != -1)
    {
      m = Math.max(i, j + k);
      mBaseline = j;
    }
    i = Math.max(m, getSuggestedMinimumHeight());
    setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), paramInt1, i1), ViewCompat.resolveSizeAndState(i, paramInt2, i1 << 16));
  }
}

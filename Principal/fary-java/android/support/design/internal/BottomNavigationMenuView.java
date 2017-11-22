package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.design.R.dimen;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  private static final Pools.Pool<BottomNavigationItemView> sItemPool = new Pools.SynchronizedPool(5);
  private int mActiveButton = 0;
  private final int mActiveItemMaxWidth;
  private final BottomNavigationAnimationHelperBase mAnimationHelper;
  private BottomNavigationItemView[] mButtons;
  private final int mInactiveItemMaxWidth;
  private final int mInactiveItemMinWidth;
  private int mItemBackgroundRes;
  private final int mItemHeight;
  private ColorStateList mItemIconTint;
  private ColorStateList mItemTextColor;
  private MenuBuilder mMenu;
  private final View.OnClickListener mOnClickListener;
  private BottomNavigationPresenter mPresenter;
  private boolean mShiftingMode = true;
  private int[] mTempChildWidths;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    mInactiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    mInactiveItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    mActiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    mItemHeight = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    if (Build.VERSION.SDK_INT >= 14) {}
    for (mAnimationHelper = new BottomNavigationAnimationHelperIcs();; mAnimationHelper = new BottomNavigationAnimationHelperBase())
    {
      mOnClickListener = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = (BottomNavigationItemView)paramAnonymousView;
          int i = paramAnonymousView.getItemPosition();
          if (!mMenu.performItemAction(paramAnonymousView.getItemData(), mPresenter, 0)) {
            BottomNavigationMenuView.this.activateNewButton(i);
          }
        }
      };
      mTempChildWidths = new int[5];
      return;
    }
  }
  
  private void activateNewButton(int paramInt)
  {
    if (mActiveButton == paramInt) {
      return;
    }
    mAnimationHelper.beginDelayedTransition(this);
    mMenu.getItem(paramInt).setChecked(true);
    mActiveButton = paramInt;
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)sItemPool.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  public void buildMenuView()
  {
    Object localObject1;
    int i;
    if (mButtons != null)
    {
      localObject1 = mButtons;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        sItemPool.release(localObject2);
        i += 1;
      }
    }
    removeAllViews();
    if (mMenu.size() == 0) {
      return;
    }
    mButtons = new BottomNavigationItemView[mMenu.size()];
    if (mMenu.size() > 3) {}
    for (boolean bool = true;; bool = false)
    {
      mShiftingMode = bool;
      i = 0;
      while (i < mMenu.size())
      {
        mPresenter.setUpdateSuspended(true);
        mMenu.getItem(i).setCheckable(true);
        mPresenter.setUpdateSuspended(false);
        localObject1 = getNewItem();
        mButtons[i] = localObject1;
        ((BottomNavigationItemView)localObject1).setIconTintList(mItemIconTint);
        ((BottomNavigationItemView)localObject1).setTextColor(mItemTextColor);
        ((BottomNavigationItemView)localObject1).setItemBackground(mItemBackgroundRes);
        ((BottomNavigationItemView)localObject1).setShiftingMode(mShiftingMode);
        ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)mMenu.getItem(i), 0);
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(mOnClickListener);
        addView((View)localObject1);
        i += 1;
      }
    }
    mActiveButton = Math.min(mMenu.size() - 1, mActiveButton);
    mMenu.getItem(mActiveButton).setChecked(true);
  }
  
  @Nullable
  public ColorStateList getIconTintList()
  {
    return mItemIconTint;
  }
  
  public int getItemBackgroundRes()
  {
    return mItemBackgroundRes;
  }
  
  public ColorStateList getItemTextColor()
  {
    return mItemTextColor;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    mMenu = paramMenuBuilder;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    paramInt3 -= paramInt1;
    paramInt4 -= paramInt2;
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() == 8)
      {
        paramInt1 += 1;
      }
      else
      {
        if (ViewCompat.getLayoutDirection(this) == 1) {
          localView.layout(paramInt3 - paramInt2 - localView.getMeasuredWidth(), 0, paramInt3 - paramInt2, paramInt4);
        }
        for (;;)
        {
          paramInt2 += localView.getMeasuredWidth();
          break;
          localView.layout(paramInt2, 0, localView.getMeasuredWidth() + paramInt2, paramInt4);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int j = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(mItemHeight, 1073741824);
    int k;
    Object localObject;
    int i;
    if (mShiftingMode)
    {
      paramInt1 = j - 1;
      k = Math.min(paramInt2 - mInactiveItemMinWidth * paramInt1, mActiveItemMaxWidth);
      int m = Math.min((paramInt2 - k) / paramInt1, mInactiveItemMaxWidth);
      paramInt2 = paramInt2 - k - m * paramInt1;
      paramInt1 = 0;
      if (paramInt1 < j)
      {
        localObject = mTempChildWidths;
        if (paramInt1 == mActiveButton) {}
        for (i = k;; i = m)
        {
          localObject[paramInt1] = i;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject = mTempChildWidths;
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
          paramInt1 += 1;
          paramInt2 = i;
          break;
        }
      }
    }
    else
    {
      if (j == 0) {}
      for (paramInt1 = 1;; paramInt1 = j)
      {
        k = Math.min(paramInt2 / paramInt1, mActiveItemMaxWidth);
        paramInt2 -= k * j;
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          mTempChildWidths[paramInt1] = k;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject = mTempChildWidths;
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
          paramInt1 += 1;
          paramInt2 = i;
        }
      }
    }
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() == 8) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(mTempChildWidths[paramInt1], 1073741824), n);
        getLayoutParamswidth = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
    }
    setMeasuredDimension(ViewCompat.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), ViewCompat.resolveSizeAndState(mItemHeight, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    mItemIconTint = paramColorStateList;
    if (mButtons == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = mButtons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    mItemBackgroundRes = paramInt;
    if (mButtons == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = mButtons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    mItemTextColor = paramColorStateList;
    if (mButtons == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = mButtons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    mPresenter = paramBottomNavigationPresenter;
  }
  
  public void updateMenuView()
  {
    int j = mMenu.size();
    if (j != mButtons.length) {
      buildMenuView();
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < j)
      {
        mPresenter.setUpdateSuspended(true);
        if (mMenu.getItem(i).isChecked()) {
          mActiveButton = i;
        }
        mButtons[i].initialize((MenuItemImpl)mMenu.getItem(i), 0);
        mPresenter.setUpdateSuspended(false);
        i += 1;
      }
    }
  }
}

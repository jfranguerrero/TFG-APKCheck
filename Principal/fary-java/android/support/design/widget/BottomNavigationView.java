package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R.color;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationView
  extends FrameLayout
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private OnNavigationItemSelectedListener mListener;
  private final MenuBuilder mMenu;
  private MenuInflater mMenuInflater;
  private final BottomNavigationMenuView mMenuView;
  private final BottomNavigationPresenter mPresenter = new BottomNavigationPresenter();
  
  public BottomNavigationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    mMenu = new BottomNavigationMenu(paramContext);
    mMenuView = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    gravity = 17;
    mMenuView.setLayoutParams(localLayoutParams);
    mPresenter.setBottomNavigationMenuView(mMenuView);
    mMenuView.setPresenter(mPresenter);
    mMenu.addMenuPresenter(mPresenter);
    mPresenter.initForMenu(getContext(), mMenu);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.BottomNavigationView, paramInt, R.style.Widget_Design_BottomNavigationView);
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_itemIconTint))
    {
      mMenuView.setIconTintList(paramAttributeSet.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
      if (!paramAttributeSet.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
        break label305;
      }
      mMenuView.setItemTextColor(paramAttributeSet.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
    }
    for (;;)
    {
      if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_elevation)) {
        ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
      }
      paramInt = paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
      mMenuView.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_menu)) {
        inflateMenu(paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_menu, 0));
      }
      paramAttributeSet.recycle();
      addView(mMenuView, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21) {
        addCompatibilityTopDivider(paramContext);
      }
      mMenu.setCallback(new MenuBuilder.Callback()
      {
        public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
        {
          return (mListener != null) && (!mListener.onNavigationItemSelected(paramAnonymousMenuItem));
        }
        
        public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
      });
      return;
      mMenuView.setIconTintList(createDefaultColorStateList(16842808));
      break;
      label305:
      mMenuView.setItemTextColor(createDefaultColorStateList(16842808));
    }
  }
  
  private void addCompatibilityTopDivider(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.design_bottom_navigation_shadow_color));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
    addView(localView);
  }
  
  private ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = AppCompatResources.getColorStateList(getContext(), resourceId);
    } while (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true));
    paramInt = data;
    int i = localColorStateList.getDefaultColor();
    localObject = DISABLED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(DISABLED_STATE_SET, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  private MenuInflater getMenuInflater()
  {
    if (mMenuInflater == null) {
      mMenuInflater = new SupportMenuInflater(getContext());
    }
    return mMenuInflater;
  }
  
  @DrawableRes
  public int getItemBackgroundResource()
  {
    return mMenuView.getItemBackgroundRes();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return mMenuView.getIconTintList();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return mMenuView.getItemTextColor();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  @NonNull
  public Menu getMenu()
  {
    return mMenu;
  }
  
  public void inflateMenu(int paramInt)
  {
    mPresenter.setUpdateSuspended(true);
    getMenuInflater().inflate(paramInt, mMenu);
    mPresenter.setUpdateSuspended(false);
    mPresenter.updateMenuView(true);
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    mMenuView.setItemBackgroundRes(paramInt);
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    mMenuView.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    mMenuView.setItemTextColor(paramColorStateList);
  }
  
  public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    mListener = paramOnNavigationItemSelectedListener;
  }
  
  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(@NonNull MenuItem paramMenuItem);
  }
}

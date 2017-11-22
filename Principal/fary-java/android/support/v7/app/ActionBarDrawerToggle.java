package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private boolean mHasCustomUpIndicator;
  private Drawable mHomeAsUpIndicator;
  private final int mOpenDrawerContentDescRes;
  private DrawerArrowDrawable mSlider;
  View.OnClickListener mToolbarNavigationClickListener;
  private boolean mWarnedForDisplayHomeAsUp = false;
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    this(paramActivity, null, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, Toolbar paramToolbar, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    this(paramActivity, paramToolbar, paramDrawerLayout, null, paramInt1, paramInt2);
  }
  
  ActionBarDrawerToggle(Activity paramActivity, Toolbar paramToolbar, DrawerLayout paramDrawerLayout, DrawerArrowDrawable paramDrawerArrowDrawable, @StringRes int paramInt1, @StringRes int paramInt2)
  {
    if (paramToolbar != null)
    {
      mActivityImpl = new ToolbarCompatDelegate(paramToolbar);
      paramToolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (mDrawerIndicatorEnabled) {
            toggle();
          }
          while (mToolbarNavigationClickListener == null) {
            return;
          }
          mToolbarNavigationClickListener.onClick(paramAnonymousView);
        }
      });
      mDrawerLayout = paramDrawerLayout;
      mOpenDrawerContentDescRes = paramInt1;
      mCloseDrawerContentDescRes = paramInt2;
      if (paramDrawerArrowDrawable != null) {
        break label200;
      }
    }
    label200:
    for (mSlider = new DrawerArrowDrawable(mActivityImpl.getActionBarThemedContext());; mSlider = paramDrawerArrowDrawable)
    {
      mHomeAsUpIndicator = getThemeUpIndicator();
      return;
      if ((paramActivity instanceof DelegateProvider))
      {
        mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
        break;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        mActivityImpl = new JellybeanMr2Delegate(paramActivity);
        break;
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        mActivityImpl = new IcsDelegate(paramActivity);
        break;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        mActivityImpl = new HoneycombDelegate(paramActivity);
        break;
      }
      mActivityImpl = new DummyDelegate(paramActivity);
      break;
    }
  }
  
  private void setPosition(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      mSlider.setVerticalMirror(true);
    }
    for (;;)
    {
      mSlider.setProgress(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        mSlider.setVerticalMirror(false);
      }
    }
  }
  
  @NonNull
  public DrawerArrowDrawable getDrawerArrowDrawable()
  {
    return mSlider;
  }
  
  Drawable getThemeUpIndicator()
  {
    return mActivityImpl.getThemeUpIndicator();
  }
  
  public View.OnClickListener getToolbarNavigationClickListener()
  {
    return mToolbarNavigationClickListener;
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!mHasCustomUpIndicator) {
      mHomeAsUpIndicator = getThemeUpIndicator();
    }
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    setPosition(0.0F);
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    setPosition(1.0F);
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    setPosition(Math.min(1.0F, Math.max(0.0F, paramFloat)));
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (mDrawerIndicatorEnabled))
    {
      toggle();
      return true;
    }
    return false;
  }
  
  void setActionBarDescription(int paramInt)
  {
    mActivityImpl.setActionBarDescription(paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if ((!mWarnedForDisplayHomeAsUp) && (!mActivityImpl.isNavigationVisible()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      mWarnedForDisplayHomeAsUp = true;
    }
    mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
  }
  
  public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable paramDrawerArrowDrawable)
  {
    mSlider = paramDrawerArrowDrawable;
    syncState();
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label54;
      }
      DrawerArrowDrawable localDrawerArrowDrawable = mSlider;
      if (!mDrawerLayout.isDrawerOpen(8388611)) {
        break label46;
      }
      i = mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localDrawerArrowDrawable, i);
    }
    for (;;)
    {
      mDrawerIndicatorEnabled = paramBoolean;
      return;
      label46:
      i = mOpenDrawerContentDescRes;
      break;
      label54:
      setActionBarUpIndicator(mHomeAsUpIndicator, 0);
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = mDrawerLayout.getResources().getDrawable(paramInt);
    }
    setHomeAsUpIndicator(localDrawable);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      mHomeAsUpIndicator = getThemeUpIndicator();
    }
    for (mHasCustomUpIndicator = false;; mHasCustomUpIndicator = true)
    {
      if (!mDrawerIndicatorEnabled) {
        setActionBarUpIndicator(mHomeAsUpIndicator, 0);
      }
      return;
      mHomeAsUpIndicator = paramDrawable;
    }
  }
  
  public void setToolbarNavigationClickListener(View.OnClickListener paramOnClickListener)
  {
    mToolbarNavigationClickListener = paramOnClickListener;
  }
  
  public void syncState()
  {
    DrawerArrowDrawable localDrawerArrowDrawable;
    if (mDrawerLayout.isDrawerOpen(8388611))
    {
      setPosition(1.0F);
      if (mDrawerIndicatorEnabled)
      {
        localDrawerArrowDrawable = mSlider;
        if (!mDrawerLayout.isDrawerOpen(8388611)) {
          break label61;
        }
      }
    }
    label61:
    for (int i = mCloseDrawerContentDescRes;; i = mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localDrawerArrowDrawable, i);
      return;
      setPosition(0.0F);
      break;
    }
  }
  
  void toggle()
  {
    int i = mDrawerLayout.getDrawerLockMode(8388611);
    if ((mDrawerLayout.isDrawerVisible(8388611)) && (i != 2)) {
      mDrawerLayout.closeDrawer(8388611);
    }
    while (i == 1) {
      return;
    }
    mDrawerLayout.openDrawer(8388611);
  }
  
  public static abstract interface Delegate
  {
    public abstract Context getActionBarThemedContext();
    
    public abstract Drawable getThemeUpIndicator();
    
    public abstract boolean isNavigationVisible();
    
    public abstract void setActionBarDescription(@StringRes int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt);
  }
  
  public static abstract interface DelegateProvider
  {
    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  static class DummyDelegate
    implements ActionBarDrawerToggle.Delegate
  {
    final Activity mActivity;
    
    DummyDelegate(Activity paramActivity)
    {
      mActivity = paramActivity;
    }
    
    public Context getActionBarThemedContext()
    {
      return mActivity;
    }
    
    public Drawable getThemeUpIndicator()
    {
      return null;
    }
    
    public boolean isNavigationVisible()
    {
      return true;
    }
    
    public void setActionBarDescription(@StringRes int paramInt) {}
    
    public void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt) {}
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static class HoneycombDelegate
    implements ActionBarDrawerToggle.Delegate
  {
    final Activity mActivity;
    ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;
    
    HoneycombDelegate(Activity paramActivity)
    {
      mActivity = paramActivity;
    }
    
    public Context getActionBarThemedContext()
    {
      return mActivity;
    }
    
    public Drawable getThemeUpIndicator()
    {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(mActivity);
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = mActivity.getActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(mSetIndicatorInfo, mActivity, paramInt);
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = mActivity.getActionBar();
      if (localActionBar != null)
      {
        localActionBar.setDisplayShowHomeEnabled(true);
        mSetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(mSetIndicatorInfo, mActivity, paramDrawable, paramInt);
        localActionBar.setDisplayShowHomeEnabled(false);
      }
    }
  }
  
  @TargetApi(14)
  @RequiresApi(14)
  private static class IcsDelegate
    extends ActionBarDrawerToggle.HoneycombDelegate
  {
    IcsDelegate(Activity paramActivity)
    {
      super();
    }
    
    public Context getActionBarThemedContext()
    {
      ActionBar localActionBar = mActivity.getActionBar();
      if (localActionBar != null) {
        return localActionBar.getThemedContext();
      }
      return mActivity;
    }
  }
  
  @TargetApi(18)
  @RequiresApi(18)
  private static class JellybeanMr2Delegate
    implements ActionBarDrawerToggle.Delegate
  {
    final Activity mActivity;
    
    JellybeanMr2Delegate(Activity paramActivity)
    {
      mActivity = paramActivity;
    }
    
    public Context getActionBarThemedContext()
    {
      ActionBar localActionBar = mActivity.getActionBar();
      if (localActionBar != null) {
        return localActionBar.getThemedContext();
      }
      return mActivity;
    }
    
    public Drawable getThemeUpIndicator()
    {
      TypedArray localTypedArray = getActionBarThemedContext().obtainStyledAttributes(null, new int[] { 16843531 }, 16843470, 0);
      Drawable localDrawable = localTypedArray.getDrawable(0);
      localTypedArray.recycle();
      return localDrawable;
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = mActivity.getActionBar();
      return (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0);
    }
    
    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = mActivity.getActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = mActivity.getActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  static class ToolbarCompatDelegate
    implements ActionBarDrawerToggle.Delegate
  {
    final CharSequence mDefaultContentDescription;
    final Drawable mDefaultUpIndicator;
    final Toolbar mToolbar;
    
    ToolbarCompatDelegate(Toolbar paramToolbar)
    {
      mToolbar = paramToolbar;
      mDefaultUpIndicator = paramToolbar.getNavigationIcon();
      mDefaultContentDescription = paramToolbar.getNavigationContentDescription();
    }
    
    public Context getActionBarThemedContext()
    {
      return mToolbar.getContext();
    }
    
    public Drawable getThemeUpIndicator()
    {
      return mDefaultUpIndicator;
    }
    
    public boolean isNavigationVisible()
    {
      return true;
    }
    
    public void setActionBarDescription(@StringRes int paramInt)
    {
      if (paramInt == 0)
      {
        mToolbar.setNavigationContentDescription(mDefaultContentDescription);
        return;
      }
      mToolbar.setNavigationContentDescription(paramInt);
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt)
    {
      mToolbar.setNavigationIcon(paramDrawable);
      setActionBarDescription(paramInt);
    }
  }
}

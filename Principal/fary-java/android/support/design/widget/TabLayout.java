package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.content.res.AppCompatResources;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout
  extends HorizontalScrollView
{
  private static final int ANIMATION_DURATION = 300;
  static final int DEFAULT_GAP_TEXT_ICON = 8;
  private static final int DEFAULT_HEIGHT = 48;
  private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
  static final int FIXED_WRAP_GUTTER_MIN = 16;
  public static final int GRAVITY_CENTER = 1;
  public static final int GRAVITY_FILL = 0;
  private static final int INVALID_WIDTH = -1;
  public static final int MODE_FIXED = 1;
  public static final int MODE_SCROLLABLE = 0;
  static final int MOTION_NON_ADJACENT_OFFSET = 24;
  private static final int TAB_MIN_WIDTH_MARGIN = 56;
  private static final Pools.Pool<Tab> sTabPool = new Pools.SynchronizedPool(16);
  private AdapterChangeListener mAdapterChangeListener;
  private int mContentInsetStart;
  private OnTabSelectedListener mCurrentVpSelectedListener;
  int mMode;
  private TabLayoutOnPageChangeListener mPageChangeListener;
  private PagerAdapter mPagerAdapter;
  private DataSetObserver mPagerAdapterObserver;
  private final int mRequestedTabMaxWidth;
  private final int mRequestedTabMinWidth;
  private ValueAnimatorCompat mScrollAnimator;
  private final int mScrollableTabMinWidth;
  private OnTabSelectedListener mSelectedListener;
  private final ArrayList<OnTabSelectedListener> mSelectedListeners = new ArrayList();
  private Tab mSelectedTab;
  private boolean mSetupViewPagerImplicitly;
  final int mTabBackgroundResId;
  int mTabGravity;
  int mTabMaxWidth = Integer.MAX_VALUE;
  int mTabPaddingBottom;
  int mTabPaddingEnd;
  int mTabPaddingStart;
  int mTabPaddingTop;
  private final SlidingTabStrip mTabStrip;
  int mTabTextAppearance;
  ColorStateList mTabTextColors;
  float mTabTextMultiLineSize;
  float mTabTextSize;
  private final Pools.Pool<TabView> mTabViewPool = new Pools.SimplePool(12);
  private final ArrayList<Tab> mTabs = new ArrayList();
  ViewPager mViewPager;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    setHorizontalScrollBarEnabled(false);
    mTabStrip = new SlidingTabStrip(paramContext);
    super.addView(mTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.design.R.styleable.TabLayout, paramInt, R.style.Widget_Design_TabLayout);
    mTabStrip.setSelectedIndicatorHeight(paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, 0));
    mTabStrip.setSelectedIndicatorColor(paramAttributeSet.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
    paramInt = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
    mTabPaddingBottom = paramInt;
    mTabPaddingEnd = paramInt;
    mTabPaddingTop = paramInt;
    mTabPaddingStart = paramInt;
    mTabPaddingStart = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, mTabPaddingStart);
    mTabPaddingTop = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, mTabPaddingTop);
    mTabPaddingEnd = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, mTabPaddingEnd);
    mTabPaddingBottom = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, mTabPaddingBottom);
    mTabTextAppearance = paramAttributeSet.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
    paramContext = paramContext.obtainStyledAttributes(mTabTextAppearance, android.support.v7.appcompat.R.styleable.TextAppearance);
    try
    {
      mTabTextSize = paramContext.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      mTabTextColors = paramContext.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
      paramContext.recycle();
      if (paramAttributeSet.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor)) {
        mTabTextColors = paramAttributeSet.getColorStateList(android.support.design.R.styleable.TabLayout_tabTextColor);
      }
      if (paramAttributeSet.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor))
      {
        paramInt = paramAttributeSet.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0);
        mTabTextColors = createColorStateList(mTabTextColors.getDefaultColor(), paramInt);
      }
      mRequestedTabMinWidth = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
      mRequestedTabMaxWidth = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
      mTabBackgroundResId = paramAttributeSet.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
      mContentInsetStart = paramAttributeSet.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
      mMode = paramAttributeSet.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
      mTabGravity = paramAttributeSet.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
      paramAttributeSet.recycle();
      paramContext = getResources();
      mTabTextMultiLineSize = paramContext.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      mScrollableTabMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      applyModeAndGravity();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void addTabFromItemView(@NonNull TabItem paramTabItem)
  {
    Tab localTab = newTab();
    if (mText != null) {
      localTab.setText(mText);
    }
    if (mIcon != null) {
      localTab.setIcon(mIcon);
    }
    if (mCustomLayout != 0) {
      localTab.setCustomView(mCustomLayout);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      localTab.setContentDescription(paramTabItem.getContentDescription());
    }
    addTab(localTab);
  }
  
  private void addTabView(Tab paramTab)
  {
    TabView localTabView = mView;
    mTabStrip.addView(localTabView, paramTab.getPosition(), createLayoutParamsForTabs());
  }
  
  private void addViewInternal(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      addTabFromItemView((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void animateToTab(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (mTabStrip.childrenNeedLayout()))
    {
      setScrollPosition(paramInt, 0.0F, true);
      return;
    }
    int i = getScrollX();
    int j = calculateScrollXForTab(paramInt, 0.0F);
    if (i != j)
    {
      if (mScrollAnimator == null)
      {
        mScrollAnimator = ViewUtils.createAnimator();
        mScrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        mScrollAnimator.setDuration(300L);
        mScrollAnimator.addUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
          {
            scrollTo(paramAnonymousValueAnimatorCompat.getAnimatedIntValue(), 0);
          }
        });
      }
      mScrollAnimator.setIntValues(i, j);
      mScrollAnimator.start();
    }
    mTabStrip.animateIndicatorToPosition(paramInt, 300);
  }
  
  private void applyModeAndGravity()
  {
    int i = 0;
    if (mMode == 0) {
      i = Math.max(0, mContentInsetStart - mTabPaddingStart);
    }
    ViewCompat.setPaddingRelative(mTabStrip, i, 0, 0, 0);
    switch (mMode)
    {
    }
    for (;;)
    {
      updateTabViews(true);
      return;
      mTabStrip.setGravity(1);
      continue;
      mTabStrip.setGravity(8388611);
    }
  }
  
  private int calculateScrollXForTab(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (mMode == 0)
    {
      localView2 = mTabStrip.getChildAt(paramInt);
      if (paramInt + 1 >= mTabStrip.getChildCount()) {
        break label107;
      }
      localView1 = mTabStrip.getChildAt(paramInt + 1);
      if (localView2 == null) {
        break label113;
      }
    }
    label107:
    label113:
    for (paramInt = localView2.getWidth();; paramInt = 0)
    {
      i = j;
      if (localView1 != null) {
        i = localView1.getWidth();
      }
      i = localView2.getLeft() + (int)((paramInt + i) * paramFloat * 0.5F) + localView2.getWidth() / 2 - getWidth() / 2;
      return i;
      localView1 = null;
      break;
    }
  }
  
  private void configureTab(Tab paramTab, int paramInt)
  {
    paramTab.setPosition(paramInt);
    mTabs.add(paramInt, paramTab);
    int i = mTabs.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((Tab)mTabs.get(paramInt)).setPosition(paramInt);
      paramInt += 1;
    }
  }
  
  private static ColorStateList createColorStateList(int paramInt1, int paramInt2)
  {
    int[][] arrayOfInt = new int[2][];
    int[] arrayOfInt1 = new int[2];
    arrayOfInt[0] = SELECTED_STATE_SET;
    arrayOfInt1[0] = paramInt2;
    paramInt2 = 0 + 1;
    arrayOfInt[paramInt2] = EMPTY_STATE_SET;
    arrayOfInt1[paramInt2] = paramInt1;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private LinearLayout.LayoutParams createLayoutParamsForTabs()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    updateTabViewLayoutParams(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabView createTabView(@NonNull Tab paramTab)
  {
    if (mTabViewPool != null) {}
    for (TabView localTabView1 = (TabView)mTabViewPool.acquire();; localTabView1 = null)
    {
      TabView localTabView2 = localTabView1;
      if (localTabView1 == null) {
        localTabView2 = new TabView(getContext());
      }
      localTabView2.setTab(paramTab);
      localTabView2.setFocusable(true);
      localTabView2.setMinimumWidth(getTabMinWidth());
      return localTabView2;
    }
  }
  
  private void dispatchTabReselected(@NonNull Tab paramTab)
  {
    int i = mSelectedListeners.size() - 1;
    while (i >= 0)
    {
      ((OnTabSelectedListener)mSelectedListeners.get(i)).onTabReselected(paramTab);
      i -= 1;
    }
  }
  
  private void dispatchTabSelected(@NonNull Tab paramTab)
  {
    int i = mSelectedListeners.size() - 1;
    while (i >= 0)
    {
      ((OnTabSelectedListener)mSelectedListeners.get(i)).onTabSelected(paramTab);
      i -= 1;
    }
  }
  
  private void dispatchTabUnselected(@NonNull Tab paramTab)
  {
    int i = mSelectedListeners.size() - 1;
    while (i >= 0)
    {
      ((OnTabSelectedListener)mSelectedListeners.get(i)).onTabUnselected(paramTab);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int k = 0;
    int i = 0;
    int m = mTabs.size();
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        Tab localTab = (Tab)mTabs.get(i);
        if ((localTab != null) && (localTab.getIcon() != null) && (!TextUtils.isEmpty(localTab.getText()))) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        return 72;
      }
      i += 1;
    }
    return 48;
  }
  
  private float getScrollPosition()
  {
    return mTabStrip.getIndicatorPosition();
  }
  
  private int getTabMinWidth()
  {
    if (mRequestedTabMinWidth != -1) {
      return mRequestedTabMinWidth;
    }
    if (mMode == 0) {
      return mScrollableTabMinWidth;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, mTabStrip.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeTabViewAt(int paramInt)
  {
    TabView localTabView = (TabView)mTabStrip.getChildAt(paramInt);
    mTabStrip.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.reset();
      mTabViewPool.release(localTabView);
    }
    requestLayout();
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = mTabStrip.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = mTabStrip.getChildAt(i);
        if (i == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void setupWithViewPager(@Nullable ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mViewPager != null)
    {
      if (mPageChangeListener != null) {
        mViewPager.removeOnPageChangeListener(mPageChangeListener);
      }
      if (mAdapterChangeListener != null) {
        mViewPager.removeOnAdapterChangeListener(mAdapterChangeListener);
      }
    }
    if (mCurrentVpSelectedListener != null)
    {
      removeOnTabSelectedListener(mCurrentVpSelectedListener);
      mCurrentVpSelectedListener = null;
    }
    if (paramViewPager != null)
    {
      mViewPager = paramViewPager;
      if (mPageChangeListener == null) {
        mPageChangeListener = new TabLayoutOnPageChangeListener(this);
      }
      mPageChangeListener.reset();
      paramViewPager.addOnPageChangeListener(mPageChangeListener);
      mCurrentVpSelectedListener = new ViewPagerOnTabSelectedListener(paramViewPager);
      addOnTabSelectedListener(mCurrentVpSelectedListener);
      PagerAdapter localPagerAdapter = paramViewPager.getAdapter();
      if (localPagerAdapter != null) {
        setPagerAdapter(localPagerAdapter, paramBoolean1);
      }
      if (mAdapterChangeListener == null) {
        mAdapterChangeListener = new AdapterChangeListener();
      }
      mAdapterChangeListener.setAutoRefresh(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(mAdapterChangeListener);
      setScrollPosition(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    for (;;)
    {
      mSetupViewPagerImplicitly = paramBoolean2;
      return;
      mViewPager = null;
      setPagerAdapter(null, false);
    }
  }
  
  private void updateAllTabs()
  {
    int i = 0;
    int j = mTabs.size();
    while (i < j)
    {
      ((Tab)mTabs.get(i)).updateView();
      i += 1;
    }
  }
  
  private void updateTabViewLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((mMode == 1) && (mTabGravity == 0))
    {
      width = 0;
      weight = 1.0F;
      return;
    }
    width = -2;
    weight = 0.0F;
  }
  
  public void addOnTabSelectedListener(@NonNull OnTabSelectedListener paramOnTabSelectedListener)
  {
    if (!mSelectedListeners.contains(paramOnTabSelectedListener)) {
      mSelectedListeners.add(paramOnTabSelectedListener);
    }
  }
  
  public void addTab(@NonNull Tab paramTab)
  {
    addTab(paramTab, mTabs.isEmpty());
  }
  
  public void addTab(@NonNull Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, mTabs.isEmpty());
  }
  
  public void addTab(@NonNull Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (mParent != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    configureTab(paramTab, paramInt);
    addTabView(paramTab);
    if (paramBoolean) {
      paramTab.select();
    }
  }
  
  public void addTab(@NonNull Tab paramTab, boolean paramBoolean)
  {
    addTab(paramTab, mTabs.size(), paramBoolean);
  }
  
  public void addView(View paramView)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }
  
  public void clearOnTabSelectedListeners()
  {
    mSelectedListeners.clear();
  }
  
  int dpToPx(int paramInt)
  {
    return Math.round(getResourcesgetDisplayMetricsdensity * paramInt);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    if (mSelectedTab != null) {
      return mSelectedTab.getPosition();
    }
    return -1;
  }
  
  @Nullable
  public Tab getTabAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (Tab)mTabs.get(paramInt);
  }
  
  public int getTabCount()
  {
    return mTabs.size();
  }
  
  public int getTabGravity()
  {
    return mTabGravity;
  }
  
  int getTabMaxWidth()
  {
    return mTabMaxWidth;
  }
  
  public int getTabMode()
  {
    return mMode;
  }
  
  @Nullable
  public ColorStateList getTabTextColors()
  {
    return mTabTextColors;
  }
  
  @NonNull
  public Tab newTab()
  {
    Tab localTab2 = (Tab)sTabPool.acquire();
    Tab localTab1 = localTab2;
    if (localTab2 == null) {
      localTab1 = new Tab();
    }
    mParent = this;
    mView = createTabView(localTab1);
    return localTab1;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (mViewPager == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        setupWithViewPager((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mSetupViewPagerImplicitly)
    {
      setupWithViewPager(null);
      mSetupViewPagerImplicitly = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      label48:
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (mRequestedTabMaxWidth <= 0) {
          break label200;
        }
        i = mRequestedTabMaxWidth;
      }
      break;
    }
    View localView;
    for (;;)
    {
      mTabMaxWidth = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getChildCount() == 1)
      {
        localView = getChildAt(0);
        paramInt1 = 0;
      }
      switch (mMode)
      {
      default: 
        if (paramInt1 != 0)
        {
          paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), getLayoutParamsheight);
          localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
        }
        return;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
        break label48;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        break label48;
        label200:
        i -= dpToPx(56);
      }
    }
    if (localView.getMeasuredWidth() < getMeasuredWidth()) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      break;
    }
    if (localView.getMeasuredWidth() != getMeasuredWidth()) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      break;
    }
  }
  
  void populateFromPagerAdapter()
  {
    removeAllTabs();
    if (mPagerAdapter != null)
    {
      int j = mPagerAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        addTab(newTab().setText(mPagerAdapter.getPageTitle(i)), false);
        i += 1;
      }
      if ((mViewPager != null) && (j > 0))
      {
        i = mViewPager.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          selectTab(getTabAt(i));
        }
      }
    }
  }
  
  public void removeAllTabs()
  {
    int i = mTabStrip.getChildCount() - 1;
    while (i >= 0)
    {
      removeTabViewAt(i);
      i -= 1;
    }
    Iterator localIterator = mTabs.iterator();
    while (localIterator.hasNext())
    {
      Tab localTab = (Tab)localIterator.next();
      localIterator.remove();
      localTab.reset();
      sTabPool.release(localTab);
    }
    mSelectedTab = null;
  }
  
  public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener paramOnTabSelectedListener)
  {
    mSelectedListeners.remove(paramOnTabSelectedListener);
  }
  
  public void removeTab(Tab paramTab)
  {
    if (mParent != this) {
      throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }
    removeTabAt(paramTab.getPosition());
  }
  
  public void removeTabAt(int paramInt)
  {
    if (mSelectedTab != null) {}
    for (int i = mSelectedTab.getPosition();; i = 0)
    {
      removeTabViewAt(paramInt);
      localTab = (Tab)mTabs.remove(paramInt);
      if (localTab != null)
      {
        localTab.reset();
        sTabPool.release(localTab);
      }
      int k = mTabs.size();
      int j = paramInt;
      while (j < k)
      {
        ((Tab)mTabs.get(j)).setPosition(j);
        j += 1;
      }
    }
    if (i == paramInt) {
      if (!mTabs.isEmpty()) {
        break label123;
      }
    }
    label123:
    for (Tab localTab = null;; localTab = (Tab)mTabs.get(Math.max(0, paramInt - 1)))
    {
      selectTab(localTab);
      return;
    }
  }
  
  void selectTab(Tab paramTab)
  {
    selectTab(paramTab, true);
  }
  
  void selectTab(Tab paramTab, boolean paramBoolean)
  {
    Tab localTab = mSelectedTab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        dispatchTabReselected(paramTab);
        animateToTab(paramTab.getPosition());
      }
      return;
    }
    int i;
    if (paramTab != null)
    {
      i = paramTab.getPosition();
      label40:
      if (paramBoolean)
      {
        if (((localTab != null) && (localTab.getPosition() != -1)) || (i == -1)) {
          break label111;
        }
        setScrollPosition(i, 0.0F, true);
      }
    }
    for (;;)
    {
      if (i != -1) {
        setSelectedTabView(i);
      }
      if (localTab != null) {
        dispatchTabUnselected(localTab);
      }
      mSelectedTab = paramTab;
      if (paramTab == null) {
        break;
      }
      dispatchTabSelected(paramTab);
      return;
      i = -1;
      break label40;
      label111:
      animateToTab(i);
    }
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable OnTabSelectedListener paramOnTabSelectedListener)
  {
    if (mSelectedListener != null) {
      removeOnTabSelectedListener(mSelectedListener);
    }
    mSelectedListener = paramOnTabSelectedListener;
    if (paramOnTabSelectedListener != null) {
      addOnTabSelectedListener(paramOnTabSelectedListener);
    }
  }
  
  void setPagerAdapter(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((mPagerAdapter != null) && (mPagerAdapterObserver != null)) {
      mPagerAdapter.unregisterDataSetObserver(mPagerAdapterObserver);
    }
    mPagerAdapter = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (mPagerAdapterObserver == null) {
        mPagerAdapterObserver = new PagerAdapterObserver();
      }
      paramPagerAdapter.registerDataSetObserver(mPagerAdapterObserver);
    }
    populateFromPagerAdapter();
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }
  
  void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= mTabStrip.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        mTabStrip.setIndicatorPositionFromTabPosition(paramInt, paramFloat);
      }
      if ((mScrollAnimator != null) && (mScrollAnimator.isRunning())) {
        mScrollAnimator.cancel();
      }
      scrollTo(calculateScrollXForTab(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    setSelectedTabView(i);
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    mTabStrip.setSelectedIndicatorColor(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    mTabStrip.setSelectedIndicatorHeight(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (mTabGravity != paramInt)
    {
      mTabGravity = paramInt;
      applyModeAndGravity();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != mMode)
    {
      mMode = paramInt;
      applyModeAndGravity();
    }
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(createColorStateList(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (mTabTextColors != paramColorStateList)
    {
      mTabTextColors = paramColorStateList;
      updateAllTabs();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    setPagerAdapter(paramPagerAdapter, false);
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager)
  {
    setupWithViewPager(paramViewPager, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager, boolean paramBoolean)
  {
    setupWithViewPager(paramViewPager, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
  
  void updateTabViews(boolean paramBoolean)
  {
    int i = 0;
    while (i < mTabStrip.getChildCount())
    {
      View localView = mTabStrip.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      updateTabViewLayoutParams((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
  }
  
  private class AdapterChangeListener
    implements ViewPager.OnAdapterChangeListener
  {
    private boolean mAutoRefresh;
    
    AdapterChangeListener() {}
    
    public void onAdapterChanged(@NonNull ViewPager paramViewPager, @Nullable PagerAdapter paramPagerAdapter1, @Nullable PagerAdapter paramPagerAdapter2)
    {
      if (mViewPager == paramViewPager) {
        setPagerAdapter(paramPagerAdapter2, mAutoRefresh);
      }
    }
    
    void setAutoRefresh(boolean paramBoolean)
    {
      mAutoRefresh = paramBoolean;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Mode {}
  
  public static abstract interface OnTabSelectedListener
  {
    public abstract void onTabReselected(TabLayout.Tab paramTab);
    
    public abstract void onTabSelected(TabLayout.Tab paramTab);
    
    public abstract void onTabUnselected(TabLayout.Tab paramTab);
  }
  
  private class PagerAdapterObserver
    extends DataSetObserver
  {
    PagerAdapterObserver() {}
    
    public void onChanged()
    {
      populateFromPagerAdapter();
    }
    
    public void onInvalidated()
    {
      populateFromPagerAdapter();
    }
  }
  
  private class SlidingTabStrip
    extends LinearLayout
  {
    private ValueAnimatorCompat mIndicatorAnimator;
    private int mIndicatorLeft = -1;
    private int mIndicatorRight = -1;
    private int mSelectedIndicatorHeight;
    private final Paint mSelectedIndicatorPaint;
    int mSelectedPosition = -1;
    float mSelectionOffset;
    
    SlidingTabStrip(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      mSelectedIndicatorPaint = new Paint();
    }
    
    private void updateIndicatorPosition()
    {
      View localView = getChildAt(mSelectedPosition);
      int i;
      int j;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        int m = localView.getLeft();
        int k = localView.getRight();
        i = m;
        j = k;
        if (mSelectionOffset > 0.0F)
        {
          i = m;
          j = k;
          if (mSelectedPosition < getChildCount() - 1)
          {
            localView = getChildAt(mSelectedPosition + 1);
            i = (int)(mSelectionOffset * localView.getLeft() + (1.0F - mSelectionOffset) * m);
            j = (int)(mSelectionOffset * localView.getRight() + (1.0F - mSelectionOffset) * k);
          }
        }
      }
      for (;;)
      {
        setIndicatorPosition(i, j);
        return;
        j = -1;
        i = -1;
      }
    }
    
    void animateIndicatorToPosition(final int paramInt1, int paramInt2)
    {
      if ((mIndicatorAnimator != null) && (mIndicatorAnimator.isRunning())) {
        mIndicatorAnimator.cancel();
      }
      final int i;
      Object localObject;
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        i = 1;
        localObject = getChildAt(paramInt1);
        if (localObject != null) {
          break label56;
        }
        updateIndicatorPosition();
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        label56:
        final int k = ((View)localObject).getLeft();
        final int m = ((View)localObject).getRight();
        final int j;
        if (Math.abs(paramInt1 - mSelectedPosition) <= 1)
        {
          i = mIndicatorLeft;
          j = mIndicatorRight;
        }
        while ((i != k) || (j != m))
        {
          localObject = ViewUtils.createAnimator();
          mIndicatorAnimator = ((ValueAnimatorCompat)localObject);
          ((ValueAnimatorCompat)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
          ((ValueAnimatorCompat)localObject).setDuration(paramInt2);
          ((ValueAnimatorCompat)localObject).setFloatValues(0.0F, 1.0F);
          ((ValueAnimatorCompat)localObject).addUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
            {
              float f = paramAnonymousValueAnimatorCompat.getAnimatedFraction();
              setIndicatorPosition(AnimationUtils.lerp(i, k, f), AnimationUtils.lerp(j, m, f));
            }
          });
          ((ValueAnimatorCompat)localObject).addListener(new ValueAnimatorCompat.AnimatorListenerAdapter()
          {
            public void onAnimationEnd(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
            {
              mSelectedPosition = paramInt1;
              mSelectionOffset = 0.0F;
            }
          });
          ((ValueAnimatorCompat)localObject).start();
          return;
          j = dpToPx(24);
          if (paramInt1 < mSelectedPosition)
          {
            if (i != 0)
            {
              j = k - j;
              i = j;
            }
            else
            {
              j = m + j;
              i = j;
            }
          }
          else if (i != 0)
          {
            j = m + j;
            i = j;
          }
          else
          {
            j = k - j;
            i = j;
          }
        }
      }
    }
    
    boolean childrenNeedLayout()
    {
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        if (getChildAt(i).getWidth() <= 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      if ((mIndicatorLeft >= 0) && (mIndicatorRight > mIndicatorLeft)) {
        paramCanvas.drawRect(mIndicatorLeft, getHeight() - mSelectedIndicatorHeight, mIndicatorRight, getHeight(), mSelectedIndicatorPaint);
      }
    }
    
    float getIndicatorPosition()
    {
      return mSelectedPosition + mSelectionOffset;
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((mIndicatorAnimator != null) && (mIndicatorAnimator.isRunning()))
      {
        mIndicatorAnimator.cancel();
        long l = mIndicatorAnimator.getDuration();
        animateIndicatorToPosition(mSelectedPosition, Math.round((1.0F - mIndicatorAnimator.getAnimatedFraction()) * (float)l));
        return;
      }
      updateIndicatorPosition();
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {}
      int m;
      do
      {
        int n;
        int j;
        Object localObject;
        do
        {
          do
          {
            return;
          } while ((mMode != 1) || (mTabGravity != 1));
          n = getChildCount();
          j = 0;
          i = 0;
          while (i < n)
          {
            localObject = getChildAt(i);
            k = j;
            if (((View)localObject).getVisibility() == 0) {
              k = Math.max(j, ((View)localObject).getMeasuredWidth());
            }
            i += 1;
            j = k;
          }
        } while (j <= 0);
        int k = dpToPx(16);
        int i = 0;
        if (j * n <= getMeasuredWidth() - k * 2)
        {
          k = 0;
          for (;;)
          {
            m = i;
            if (k >= n) {
              break;
            }
            localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
            if ((width != j) || (weight != 0.0F))
            {
              width = j;
              weight = 0.0F;
              i = 1;
            }
            k += 1;
          }
        }
        mTabGravity = 0;
        updateTabViews(false);
        m = 1;
      } while (m == 0);
      super.onMeasure(paramInt1, paramInt2);
    }
    
    void setIndicatorPosition(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != mIndicatorLeft) || (paramInt2 != mIndicatorRight))
      {
        mIndicatorLeft = paramInt1;
        mIndicatorRight = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void setIndicatorPositionFromTabPosition(int paramInt, float paramFloat)
    {
      if ((mIndicatorAnimator != null) && (mIndicatorAnimator.isRunning())) {
        mIndicatorAnimator.cancel();
      }
      mSelectedPosition = paramInt;
      mSelectionOffset = paramFloat;
      updateIndicatorPosition();
    }
    
    void setSelectedIndicatorColor(int paramInt)
    {
      if (mSelectedIndicatorPaint.getColor() != paramInt)
      {
        mSelectedIndicatorPaint.setColor(paramInt);
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void setSelectedIndicatorHeight(int paramInt)
    {
      if (mSelectedIndicatorHeight != paramInt)
      {
        mSelectedIndicatorHeight = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
  }
  
  public static final class Tab
  {
    public static final int INVALID_POSITION = -1;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    TabLayout mParent;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    TabLayout.TabView mView;
    
    Tab() {}
    
    @Nullable
    public CharSequence getContentDescription()
    {
      return mContentDesc;
    }
    
    @Nullable
    public View getCustomView()
    {
      return mCustomView;
    }
    
    @Nullable
    public Drawable getIcon()
    {
      return mIcon;
    }
    
    public int getPosition()
    {
      return mPosition;
    }
    
    @Nullable
    public Object getTag()
    {
      return mTag;
    }
    
    @Nullable
    public CharSequence getText()
    {
      return mText;
    }
    
    public boolean isSelected()
    {
      if (mParent == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return mParent.getSelectedTabPosition() == mPosition;
    }
    
    void reset()
    {
      mParent = null;
      mView = null;
      mTag = null;
      mIcon = null;
      mText = null;
      mContentDesc = null;
      mPosition = -1;
      mCustomView = null;
    }
    
    public void select()
    {
      if (mParent == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      mParent.selectTab(this);
    }
    
    @NonNull
    public Tab setContentDescription(@StringRes int paramInt)
    {
      if (mParent == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return setContentDescription(mParent.getResources().getText(paramInt));
    }
    
    @NonNull
    public Tab setContentDescription(@Nullable CharSequence paramCharSequence)
    {
      mContentDesc = paramCharSequence;
      updateView();
      return this;
    }
    
    @NonNull
    public Tab setCustomView(@LayoutRes int paramInt)
    {
      return setCustomView(LayoutInflater.from(mView.getContext()).inflate(paramInt, mView, false));
    }
    
    @NonNull
    public Tab setCustomView(@Nullable View paramView)
    {
      mCustomView = paramView;
      updateView();
      return this;
    }
    
    @NonNull
    public Tab setIcon(@DrawableRes int paramInt)
    {
      if (mParent == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return setIcon(AppCompatResources.getDrawable(mParent.getContext(), paramInt));
    }
    
    @NonNull
    public Tab setIcon(@Nullable Drawable paramDrawable)
    {
      mIcon = paramDrawable;
      updateView();
      return this;
    }
    
    void setPosition(int paramInt)
    {
      mPosition = paramInt;
    }
    
    @NonNull
    public Tab setTag(@Nullable Object paramObject)
    {
      mTag = paramObject;
      return this;
    }
    
    @NonNull
    public Tab setText(@StringRes int paramInt)
    {
      if (mParent == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return setText(mParent.getResources().getText(paramInt));
    }
    
    @NonNull
    public Tab setText(@Nullable CharSequence paramCharSequence)
    {
      mText = paramCharSequence;
      updateView();
      return this;
    }
    
    void updateView()
    {
      if (mView != null) {
        mView.update();
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface TabGravity {}
  
  public static class TabLayoutOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int mPreviousScrollState;
    private int mScrollState;
    private final WeakReference<TabLayout> mTabLayoutRef;
    
    public TabLayoutOnPageChangeListener(TabLayout paramTabLayout)
    {
      mTabLayoutRef = new WeakReference(paramTabLayout);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      mPreviousScrollState = mScrollState;
      mScrollState = paramInt;
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      TabLayout localTabLayout = (TabLayout)mTabLayoutRef.get();
      boolean bool1;
      if (localTabLayout != null)
      {
        if ((mScrollState == 2) && (mPreviousScrollState != 1)) {
          break label66;
        }
        bool1 = true;
        if ((mScrollState == 2) && (mPreviousScrollState == 0)) {
          break label72;
        }
      }
      label66:
      label72:
      for (boolean bool2 = true;; bool2 = false)
      {
        localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
        return;
        bool1 = false;
        break;
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)mTabLayoutRef.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount())) {
        if ((mScrollState != 0) && ((mScrollState != 2) || (mPreviousScrollState != 0))) {
          break label66;
        }
      }
      label66:
      for (boolean bool = true;; bool = false)
      {
        localTabLayout.selectTab(localTabLayout.getTabAt(paramInt), bool);
        return;
      }
    }
    
    void reset()
    {
      mScrollState = 0;
      mPreviousScrollState = 0;
    }
  }
  
  class TabView
    extends LinearLayout
    implements View.OnLongClickListener
  {
    private ImageView mCustomIconView;
    private TextView mCustomTextView;
    private View mCustomView;
    private int mDefaultMaxLines = 2;
    private ImageView mIconView;
    private TabLayout.Tab mTab;
    private TextView mTextView;
    
    public TabView(Context paramContext)
    {
      super();
      if (mTabBackgroundResId != 0) {
        ViewCompat.setBackground(this, AppCompatResources.getDrawable(paramContext, mTabBackgroundResId));
      }
      ViewCompat.setPaddingRelative(this, mTabPaddingStart, mTabPaddingTop, mTabPaddingEnd, mTabPaddingBottom);
      setGravity(17);
      setOrientation(1);
      setClickable(true);
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
    }
    
    private float approximateLineWidth(Layout paramLayout, int paramInt, float paramFloat)
    {
      return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
    }
    
    private void updateTextAndIcon(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
    {
      Drawable localDrawable;
      CharSequence localCharSequence1;
      label32:
      CharSequence localCharSequence2;
      label48:
      label73:
      int i;
      if (mTab != null)
      {
        localDrawable = mTab.getIcon();
        if (mTab == null) {
          break label207;
        }
        localCharSequence1 = mTab.getText();
        if (mTab == null) {
          break label213;
        }
        localCharSequence2 = mTab.getContentDescription();
        if (paramImageView != null)
        {
          if (localDrawable == null) {
            break label219;
          }
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
          paramImageView.setContentDescription(localCharSequence2);
        }
        if (TextUtils.isEmpty(localCharSequence1)) {
          break label233;
        }
        i = 1;
        label89:
        if (paramTextView != null)
        {
          if (i == 0) {
            break label238;
          }
          paramTextView.setText(localCharSequence1);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
      }
      for (;;)
      {
        paramTextView.setContentDescription(localCharSequence2);
        if (paramImageView != null)
        {
          paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
          int k = 0;
          int j = k;
          if (i != 0)
          {
            j = k;
            if (paramImageView.getVisibility() == 0) {
              j = dpToPx(8);
            }
          }
          if (j != bottomMargin)
          {
            bottomMargin = j;
            paramImageView.requestLayout();
          }
        }
        if ((i != 0) || (TextUtils.isEmpty(localCharSequence2))) {
          break label252;
        }
        setOnLongClickListener(this);
        return;
        localDrawable = null;
        break;
        label207:
        localCharSequence1 = null;
        break label32;
        label213:
        localCharSequence2 = null;
        break label48;
        label219:
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
        break label73;
        label233:
        i = 0;
        break label89;
        label238:
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
      }
      label252:
      setOnLongClickListener(null);
      setLongClickable(false);
    }
    
    public TabLayout.Tab getTab()
    {
      return mTab;
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
    
    public boolean onLongClick(View paramView)
    {
      int[] arrayOfInt = new int[2];
      Rect localRect = new Rect();
      getLocationOnScreen(arrayOfInt);
      getWindowVisibleDisplayFrame(localRect);
      Context localContext = getContext();
      int i = getWidth();
      int k = getHeight();
      int m = arrayOfInt[1];
      int n = k / 2;
      int j = arrayOfInt[0] + i / 2;
      i = j;
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        i = getResourcesgetDisplayMetricswidthPixels - j;
      }
      paramView = Toast.makeText(localContext, mTab.getContentDescription(), 0);
      if (m + n < localRect.height()) {
        paramView.setGravity(8388661, i, arrayOfInt[1] + k - top);
      }
      for (;;)
      {
        paramView.show();
        return true;
        paramView.setGravity(81, 0, k);
      }
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getSize(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt1);
      int k = getTabMaxWidth();
      float f2;
      float f1;
      if ((k > 0) && ((j == 0) || (i > k)))
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(mTabMaxWidth, Integer.MIN_VALUE);
        super.onMeasure(paramInt1, paramInt2);
        if (mTextView != null)
        {
          getResources();
          f2 = mTabTextSize;
          j = mDefaultMaxLines;
          if ((mIconView == null) || (mIconView.getVisibility() != 0)) {
            break label274;
          }
          i = 1;
          f1 = f2;
        }
      }
      for (;;)
      {
        f2 = mTextView.getTextSize();
        int m = mTextView.getLineCount();
        j = TextViewCompat.getMaxLines(mTextView);
        if ((f1 != f2) || ((j >= 0) && (i != j)))
        {
          k = 1;
          j = k;
          if (mMode == 1)
          {
            j = k;
            if (f1 > f2)
            {
              j = k;
              if (m == 1)
              {
                Layout localLayout = mTextView.getLayout();
                if (localLayout != null)
                {
                  j = k;
                  if (approximateLineWidth(localLayout, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
                }
                else
                {
                  j = 0;
                }
              }
            }
          }
          if (j != 0)
          {
            mTextView.setTextSize(0, f1);
            mTextView.setMaxLines(i);
            super.onMeasure(paramInt1, paramInt2);
          }
        }
        return;
        break;
        label274:
        i = j;
        f1 = f2;
        if (mTextView != null)
        {
          i = j;
          f1 = f2;
          if (mTextView.getLineCount() > 1)
          {
            f1 = mTabTextMultiLineSize;
            i = j;
          }
        }
      }
    }
    
    public boolean performClick()
    {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (mTab != null)
      {
        if (!bool2) {
          playSoundEffect(0);
        }
        mTab.select();
        bool1 = true;
      }
      return bool1;
    }
    
    void reset()
    {
      setTab(null);
      setSelected(false);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
          sendAccessibilityEvent(4);
        }
        if (mTextView != null) {
          mTextView.setSelected(paramBoolean);
        }
        if (mIconView != null) {
          mIconView.setSelected(paramBoolean);
        }
        if (mCustomView != null) {
          mCustomView.setSelected(paramBoolean);
        }
        return;
      }
    }
    
    void setTab(@Nullable TabLayout.Tab paramTab)
    {
      if (paramTab != mTab)
      {
        mTab = paramTab;
        update();
      }
    }
    
    final void update()
    {
      TabLayout.Tab localTab = mTab;
      Object localObject;
      if (localTab != null)
      {
        localObject = localTab.getCustomView();
        if (localObject == null) {
          break label305;
        }
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null) {
            ((ViewGroup)localViewParent).removeView((View)localObject);
          }
          addView((View)localObject);
        }
        mCustomView = ((View)localObject);
        if (mTextView != null) {
          mTextView.setVisibility(8);
        }
        if (mIconView != null)
        {
          mIconView.setVisibility(8);
          mIconView.setImageDrawable(null);
        }
        mCustomTextView = ((TextView)((View)localObject).findViewById(16908308));
        if (mCustomTextView != null) {
          mDefaultMaxLines = TextViewCompat.getMaxLines(mCustomTextView);
        }
        mCustomIconView = ((ImageView)((View)localObject).findViewById(16908294));
        label140:
        if (mCustomView != null) {
          break label338;
        }
        if (mIconView == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
          addView((View)localObject, 0);
          mIconView = ((ImageView)localObject);
        }
        if (mTextView == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
          addView((View)localObject);
          mTextView = ((TextView)localObject);
          mDefaultMaxLines = TextViewCompat.getMaxLines(mTextView);
        }
        TextViewCompat.setTextAppearance(mTextView, mTabTextAppearance);
        if (mTabTextColors != null) {
          mTextView.setTextColor(mTabTextColors);
        }
        updateTextAndIcon(mTextView, mIconView);
        label281:
        if ((localTab == null) || (!localTab.isSelected())) {
          break label367;
        }
      }
      label305:
      label338:
      label367:
      for (boolean bool = true;; bool = false)
      {
        setSelected(bool);
        return;
        localObject = null;
        break;
        if (mCustomView != null)
        {
          removeView(mCustomView);
          mCustomView = null;
        }
        mCustomTextView = null;
        mCustomIconView = null;
        break label140;
        if ((mCustomTextView == null) && (mCustomIconView == null)) {
          break label281;
        }
        updateTextAndIcon(mCustomTextView, mCustomIconView);
        break label281;
      }
    }
  }
  
  public static class ViewPagerOnTabSelectedListener
    implements TabLayout.OnTabSelectedListener
  {
    private final ViewPager mViewPager;
    
    public ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
    {
      mViewPager = paramViewPager;
    }
    
    public void onTabReselected(TabLayout.Tab paramTab) {}
    
    public void onTabSelected(TabLayout.Tab paramTab)
    {
      mViewPager.setCurrentItem(paramTab.getPosition());
    }
    
    public void onTabUnselected(TabLayout.Tab paramTab) {}
  }
}

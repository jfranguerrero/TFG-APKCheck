package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
{
  private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
  private static final String LOG_TAG = "FloatingActionButton";
  public static final int SIZE_AUTO = -1;
  public static final int SIZE_MINI = 1;
  public static final int SIZE_NORMAL = 0;
  private ColorStateList mBackgroundTint;
  private PorterDuff.Mode mBackgroundTintMode;
  private int mBorderWidth;
  boolean mCompatPadding;
  private AppCompatImageHelper mImageHelper;
  int mImagePadding;
  private FloatingActionButtonImpl mImpl;
  private int mMaxImageSize;
  private int mRippleColor;
  final Rect mShadowPadding = new Rect();
  private int mSize;
  private final Rect mTouchArea = new Rect();
  
  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton, paramInt, R.style.Widget_Design_FloatingActionButton);
    mBackgroundTint = paramContext.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
    mBackgroundTintMode = ViewUtils.parseTintMode(paramContext.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    mRippleColor = paramContext.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
    mSize = paramContext.getInt(R.styleable.FloatingActionButton_fabSize, -1);
    mBorderWidth = paramContext.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = paramContext.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = paramContext.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    mCompatPadding = paramContext.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    paramContext.recycle();
    mImageHelper = new AppCompatImageHelper(this);
    mImageHelper.loadFromAttributes(paramAttributeSet, paramInt);
    mMaxImageSize = ((int)getResources().getDimension(R.dimen.design_fab_image_size));
    getImpl().setBackgroundDrawable(mBackgroundTint, mBackgroundTintMode, mRippleColor, mBorderWidth);
    getImpl().setElevation(f1);
    getImpl().setPressedTranslationZ(f2);
  }
  
  private FloatingActionButtonImpl createImpl()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      return new FloatingActionButtonLollipop(this, new ShadowDelegateImpl(), ViewUtils.DEFAULT_ANIMATOR_CREATOR);
    }
    if (i >= 14) {
      return new FloatingActionButtonIcs(this, new ShadowDelegateImpl(), ViewUtils.DEFAULT_ANIMATOR_CREATOR);
    }
    return new FloatingActionButtonGingerbread(this, new ShadowDelegateImpl(), ViewUtils.DEFAULT_ANIMATOR_CREATOR);
  }
  
  private FloatingActionButtonImpl getImpl()
  {
    if (mImpl == null) {
      mImpl = createImpl();
    }
    return mImpl;
  }
  
  private int getSizeDimension(int paramInt)
  {
    Resources localResources = getResources();
    switch (paramInt)
    {
    case 0: 
    default: 
      return localResources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
    case -1: 
      if (Math.max(ConfigurationHelper.getScreenWidthDp(localResources), ConfigurationHelper.getScreenHeightDp(localResources)) < 470) {
        return getSizeDimension(1);
      }
      return getSizeDimension(0);
    }
    return localResources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
  }
  
  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default: 
      return paramInt1;
    case 0: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  @Nullable
  private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable final OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return null;
    }
    new FloatingActionButtonImpl.InternalVisibilityChangedListener()
    {
      public void onHidden()
      {
        paramOnVisibilityChangedListener.onHidden(FloatingActionButton.this);
      }
      
      public void onShown()
      {
        paramOnVisibilityChangedListener.onShown(FloatingActionButton.this);
      }
    };
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().onDrawableStateChanged(getDrawableState());
  }
  
  @Nullable
  public ColorStateList getBackgroundTintList()
  {
    return mBackgroundTint;
  }
  
  @Nullable
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return mBackgroundTintMode;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  @NonNull
  public Drawable getContentBackground()
  {
    return getImpl().getContentBackground();
  }
  
  public boolean getContentRect(@NonNull Rect paramRect)
  {
    boolean bool = false;
    if (ViewCompat.isLaidOut(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      left += mShadowPadding.left;
      top += mShadowPadding.top;
      right -= mShadowPadding.right;
      bottom -= mShadowPadding.bottom;
      bool = true;
    }
    return bool;
  }
  
  @ColorInt
  public int getRippleColor()
  {
    return mRippleColor;
  }
  
  public int getSize()
  {
    return mSize;
  }
  
  int getSizeDimension()
  {
    return getSizeDimension(mSize);
  }
  
  public boolean getUseCompatPadding()
  {
    return mCompatPadding;
  }
  
  public void hide()
  {
    hide(null);
  }
  
  public void hide(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    hide(paramOnVisibilityChangedListener, true);
  }
  
  void hide(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().hide(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().jumpDrawableToCurrentState();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    mImagePadding = ((i - mMaxImageSize) / 2);
    getImpl().updatePadding();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(mShadowPadding.left + paramInt1 + mShadowPadding.right, mShadowPadding.top + paramInt1 + mShadowPadding.bottom);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return super.onTouchEvent(paramMotionEvent);
    } while ((!getContentRect(mTouchArea)) || (mTouchArea.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())));
    return false;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (mBackgroundTint != paramColorStateList)
    {
      mBackgroundTint = paramColorStateList;
      getImpl().setBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (mBackgroundTintMode != paramMode)
    {
      mBackgroundTintMode = paramMode;
      getImpl().setBackgroundTintMode(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    mImageHelper.setImageResource(paramInt);
  }
  
  public void setRippleColor(@ColorInt int paramInt)
  {
    if (mRippleColor != paramInt)
    {
      mRippleColor = paramInt;
      getImpl().setRippleColor(paramInt);
    }
  }
  
  public void setSize(int paramInt)
  {
    if (paramInt != mSize)
    {
      mSize = paramInt;
      requestLayout();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (mCompatPadding != paramBoolean)
    {
      mCompatPadding = paramBoolean;
      getImpl().onCompatShadowChanged();
    }
  }
  
  public void show()
  {
    show(null);
  }
  
  public void show(@Nullable OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    show(paramOnVisibilityChangedListener, true);
  }
  
  void show(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().show(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  public static class Behavior
    extends CoordinatorLayout.Behavior<FloatingActionButton>
  {
    private static final boolean AUTO_HIDE_DEFAULT = true;
    private boolean mAutoHideEnabled;
    private FloatingActionButton.OnVisibilityChangedListener mInternalAutoHideListener;
    private Rect mTmpRect;
    
    public Behavior()
    {
      mAutoHideEnabled = true;
    }
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
      mAutoHideEnabled = paramContext.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      paramContext.recycle();
    }
    
    private static boolean isBottomSheet(@NonNull View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.LayoutParams)) {
        return ((CoordinatorLayout.LayoutParams)paramView).getBehavior() instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = mShadowPadding;
      CoordinatorLayout.LayoutParams localLayoutParams;
      int j;
      int i;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
        j = 0;
        i = 0;
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - rightMargin) {
          break label109;
        }
        i = right;
        if (paramFloatingActionButton.getBottom() < paramCoordinatorLayout.getHeight() - bottomMargin) {
          break label131;
        }
        j = bottom;
      }
      for (;;)
      {
        if (j != 0) {
          ViewCompat.offsetTopAndBottom(paramFloatingActionButton, j);
        }
        if (i != 0) {
          ViewCompat.offsetLeftAndRight(paramFloatingActionButton, i);
        }
        return;
        label109:
        if (paramFloatingActionButton.getLeft() > leftMargin) {
          break;
        }
        i = -left;
        break;
        label131:
        if (paramFloatingActionButton.getTop() <= topMargin) {
          j = -top;
        }
      }
    }
    
    private boolean shouldUpdateVisibility(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      if (!mAutoHideEnabled) {}
      while ((localLayoutParams.getAnchorId() != paramView.getId()) || (paramFloatingActionButton.getUserSetVisibility() != 0)) {
        return false;
      }
      return true;
    }
    
    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!shouldUpdateVisibility(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (mTmpRect == null) {
        mTmpRect = new Rect();
      }
      Rect localRect = mTmpRect;
      ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.hide(mInternalAutoHideListener, false);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.show(mInternalAutoHideListener, false);
      }
    }
    
    private boolean updateFabVisibilityForBottomSheet(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      if (!shouldUpdateVisibility(paramView, paramFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + topMargin) {
        paramFloatingActionButton.hide(mInternalAutoHideListener, false);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.show(mInternalAutoHideListener, false);
      }
    }
    
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, @NonNull Rect paramRect)
    {
      paramCoordinatorLayout = mShadowPadding;
      paramRect.set(paramFloatingActionButton.getLeft() + left, paramFloatingActionButton.getTop() + top, paramFloatingActionButton.getRight() - right, paramFloatingActionButton.getBottom() - bottom);
      return true;
    }
    
    public boolean isAutoHideEnabled()
    {
      return mAutoHideEnabled;
    }
    
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
    {
      if (dodgeInsetEdges == 0) {
        dodgeInsetEdges = 80;
      }
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        updateFabVisibilityForAppBarLayout(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
      for (;;)
      {
        return false;
        if (isBottomSheet(paramView)) {
          updateFabVisibilityForBottomSheet(paramView, paramFloatingActionButton);
        }
      }
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      for (;;)
      {
        View localView;
        if (i < j)
        {
          localView = (View)localList.get(i);
          if (!(localView instanceof AppBarLayout)) {
            break label76;
          }
          if (!updateFabVisibilityForAppBarLayout(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton)) {
            break label94;
          }
        }
        label76:
        while ((isBottomSheet(localView)) && (updateFabVisibilityForBottomSheet(localView, paramFloatingActionButton)))
        {
          paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
          offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
          return true;
        }
        label94:
        i += 1;
      }
    }
    
    public void setAutoHideEnabled(boolean paramBoolean)
    {
      mAutoHideEnabled = paramBoolean;
    }
    
    @VisibleForTesting
    void setInternalAutoHideListener(FloatingActionButton.OnVisibilityChangedListener paramOnVisibilityChangedListener)
    {
      mInternalAutoHideListener = paramOnVisibilityChangedListener;
    }
  }
  
  public static abstract class OnVisibilityChangedListener
  {
    public OnVisibilityChangedListener() {}
    
    public void onHidden(FloatingActionButton paramFloatingActionButton) {}
    
    public void onShown(FloatingActionButton paramFloatingActionButton) {}
  }
  
  private class ShadowDelegateImpl
    implements ShadowViewDelegate
  {
    ShadowDelegateImpl() {}
    
    public float getRadius()
    {
      return getSizeDimension() / 2.0F;
    }
    
    public boolean isCompatPaddingEnabled()
    {
      return mCompatPadding;
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      FloatingActionButton.this.setBackgroundDrawable(paramDrawable);
    }
    
    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      mShadowPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
      setPadding(mImagePadding + paramInt1, mImagePadding + paramInt2, mImagePadding + paramInt3, mImagePadding + paramInt4);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Size {}
}

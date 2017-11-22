package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.design.R.color;
import android.support.v4.content.ContextCompat;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

abstract class FloatingActionButtonImpl
{
  static final Interpolator ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
  static final int ANIM_STATE_HIDING = 1;
  static final int ANIM_STATE_NONE = 0;
  static final int ANIM_STATE_SHOWING = 2;
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] FOCUSED_ENABLED_STATE_SET;
  static final long PRESSED_ANIM_DELAY = 100L;
  static final long PRESSED_ANIM_DURATION = 100L;
  static final int[] PRESSED_ENABLED_STATE_SET = { 16842919, 16842910 };
  static final int SHOW_HIDE_ANIM_DURATION = 200;
  int mAnimState = 0;
  final ValueAnimatorCompat.Creator mAnimatorCreator;
  CircularBorderDrawable mBorderDrawable;
  Drawable mContentBackground;
  float mElevation;
  private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
  float mPressedTranslationZ;
  Drawable mRippleDrawable;
  final ShadowViewDelegate mShadowViewDelegate;
  Drawable mShapeDrawable;
  private final Rect mTmpRect = new Rect();
  final VisibilityAwareImageButton mView;
  
  static
  {
    FOCUSED_ENABLED_STATE_SET = new int[] { 16842908, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  FloatingActionButtonImpl(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate, ValueAnimatorCompat.Creator paramCreator)
  {
    mView = paramVisibilityAwareImageButton;
    mShadowViewDelegate = paramShadowViewDelegate;
    mAnimatorCreator = paramCreator;
  }
  
  private void ensurePreDrawListener()
  {
    if (mPreDrawListener == null) {
      mPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          onPreDraw();
          return true;
        }
      };
    }
  }
  
  CircularBorderDrawable createBorderDrawable(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = mView.getContext();
    CircularBorderDrawable localCircularBorderDrawable = newCircularDrawable();
    localCircularBorderDrawable.setGradientColors(ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_outer_color));
    localCircularBorderDrawable.setBorderWidth(paramInt);
    localCircularBorderDrawable.setBorderTint(paramColorStateList);
    return localCircularBorderDrawable;
  }
  
  GradientDrawable createShapeDrawable()
  {
    GradientDrawable localGradientDrawable = newGradientDrawableForShape();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  final Drawable getContentBackground()
  {
    return mContentBackground;
  }
  
  abstract float getElevation();
  
  abstract void getPadding(Rect paramRect);
  
  abstract void hide(@Nullable InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean);
  
  boolean isOrWillBeHidden()
  {
    if (mView.getVisibility() == 0) {
      if (mAnimState != 1) {}
    }
    while (mAnimState != 2)
    {
      return true;
      return false;
    }
    return false;
  }
  
  boolean isOrWillBeShown()
  {
    if (mView.getVisibility() != 0) {
      if (mAnimState != 2) {}
    }
    while (mAnimState != 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  abstract void jumpDrawableToCurrentState();
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawable();
  }
  
  GradientDrawable newGradientDrawableForShape()
  {
    return new GradientDrawable();
  }
  
  void onAttachedToWindow()
  {
    if (requirePreDrawListener())
    {
      ensurePreDrawListener();
      mView.getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
    }
  }
  
  abstract void onCompatShadowChanged();
  
  void onDetachedFromWindow()
  {
    if (mPreDrawListener != null)
    {
      mView.getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
      mPreDrawListener = null;
    }
  }
  
  abstract void onDrawableStateChanged(int[] paramArrayOfInt);
  
  abstract void onElevationsChanged(float paramFloat1, float paramFloat2);
  
  void onPaddingUpdated(Rect paramRect) {}
  
  void onPreDraw() {}
  
  boolean requirePreDrawListener()
  {
    return false;
  }
  
  abstract void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2);
  
  abstract void setBackgroundTintList(ColorStateList paramColorStateList);
  
  abstract void setBackgroundTintMode(PorterDuff.Mode paramMode);
  
  final void setElevation(float paramFloat)
  {
    if (mElevation != paramFloat)
    {
      mElevation = paramFloat;
      onElevationsChanged(paramFloat, mPressedTranslationZ);
    }
  }
  
  final void setPressedTranslationZ(float paramFloat)
  {
    if (mPressedTranslationZ != paramFloat)
    {
      mPressedTranslationZ = paramFloat;
      onElevationsChanged(mElevation, paramFloat);
    }
  }
  
  abstract void setRippleColor(int paramInt);
  
  abstract void show(@Nullable InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean);
  
  final void updatePadding()
  {
    Rect localRect = mTmpRect;
    getPadding(localRect);
    onPaddingUpdated(localRect);
    mShadowViewDelegate.setShadowPadding(left, top, right, bottom);
  }
  
  static abstract interface InternalVisibilityChangedListener
  {
    public abstract void onHidden();
    
    public abstract void onShown();
  }
}

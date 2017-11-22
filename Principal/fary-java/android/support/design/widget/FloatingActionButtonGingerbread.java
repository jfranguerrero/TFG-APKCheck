package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.R.anim;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;

class FloatingActionButtonGingerbread
  extends FloatingActionButtonImpl
{
  ShadowDrawableWrapper mShadowDrawable;
  private final StateListAnimator mStateListAnimator = new StateListAnimator();
  
  FloatingActionButtonGingerbread(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate, ValueAnimatorCompat.Creator paramCreator)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate, paramCreator);
    mStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createAnimator(new ElevateToTranslationZAnimation()));
    mStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createAnimator(new ElevateToTranslationZAnimation()));
    mStateListAnimator.addState(ENABLED_STATE_SET, createAnimator(new ResetElevationAnimation()));
    mStateListAnimator.addState(EMPTY_STATE_SET, createAnimator(new DisabledElevationAnimation()));
  }
  
  private ValueAnimatorCompat createAnimator(@NonNull ShadowAnimatorImpl paramShadowAnimatorImpl)
  {
    ValueAnimatorCompat localValueAnimatorCompat = mAnimatorCreator.createAnimator();
    localValueAnimatorCompat.setInterpolator(ANIM_INTERPOLATOR);
    localValueAnimatorCompat.setDuration(100L);
    localValueAnimatorCompat.addListener(paramShadowAnimatorImpl);
    localValueAnimatorCompat.addUpdateListener(paramShadowAnimatorImpl);
    localValueAnimatorCompat.setFloatValues(0.0F, 1.0F);
    return localValueAnimatorCompat;
  }
  
  private static ColorStateList createColorStateList(int paramInt)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = FOCUSED_ENABLED_STATE_SET;
    arrayOfInt1[0] = paramInt;
    int i = 0 + 1;
    arrayOfInt[i] = PRESSED_ENABLED_STATE_SET;
    arrayOfInt1[i] = paramInt;
    paramInt = i + 1;
    arrayOfInt[paramInt] = new int[0];
    arrayOfInt1[paramInt] = 0;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  float getElevation()
  {
    return mElevation;
  }
  
  void getPadding(Rect paramRect)
  {
    mShadowDrawable.getPadding(paramRect);
  }
  
  void hide(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeHidden()) {
      return;
    }
    mAnimState = 1;
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_fab_out);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        mAnimState = 0;
        paramAnonymousAnimation = mView;
        if (paramBoolean) {}
        for (int i = 8;; i = 4)
        {
          paramAnonymousAnimation.internalSetVisibility(i, paramBoolean);
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onHidden();
          }
          return;
        }
      }
    });
    mView.startAnimation(localAnimation);
  }
  
  void jumpDrawableToCurrentState()
  {
    mStateListAnimator.jumpToCurrentState();
  }
  
  void onCompatShadowChanged() {}
  
  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    mStateListAnimator.setState(paramArrayOfInt);
  }
  
  void onElevationsChanged(float paramFloat1, float paramFloat2)
  {
    if (mShadowDrawable != null)
    {
      mShadowDrawable.setShadowSize(paramFloat1, mPressedTranslationZ + paramFloat1);
      updatePadding();
    }
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    if (paramMode != null) {
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    }
    mRippleDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(mRippleDrawable, createColorStateList(paramInt1));
    if (paramInt2 > 0)
    {
      mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = mBorderDrawable;
      paramColorStateList[1] = mShapeDrawable;
      paramColorStateList[2] = mRippleDrawable;
    }
    for (;;)
    {
      mContentBackground = new LayerDrawable(paramColorStateList);
      mShadowDrawable = new ShadowDrawableWrapper(mView.getContext(), mContentBackground, mShadowViewDelegate.getRadius(), mElevation, mElevation + mPressedTranslationZ);
      mShadowDrawable.setAddPaddingForCorners(false);
      mShadowViewDelegate.setBackgroundDrawable(mShadowDrawable);
      return;
      mBorderDrawable = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = mShapeDrawable;
      paramColorStateList[1] = mRippleDrawable;
    }
  }
  
  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mShapeDrawable != null) {
      DrawableCompat.setTintList(mShapeDrawable, paramColorStateList);
    }
    if (mBorderDrawable != null) {
      mBorderDrawable.setBorderTint(paramColorStateList);
    }
  }
  
  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mShapeDrawable != null) {
      DrawableCompat.setTintMode(mShapeDrawable, paramMode);
    }
  }
  
  void setRippleColor(int paramInt)
  {
    if (mRippleDrawable != null) {
      DrawableCompat.setTintList(mRippleDrawable, createColorStateList(paramInt));
    }
  }
  
  void show(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (isOrWillBeShown()) {
      return;
    }
    mAnimState = 2;
    mView.internalSetVisibility(0, paramBoolean);
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_fab_in);
    localAnimation.setDuration(200L);
    localAnimation.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    localAnimation.setAnimationListener(new AnimationUtils.AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        mAnimState = 0;
        if (paramInternalVisibilityChangedListener != null) {
          paramInternalVisibilityChangedListener.onShown();
        }
      }
    });
    mView.startAnimation(localAnimation);
  }
  
  private class DisabledElevationAnimation
    extends FloatingActionButtonGingerbread.ShadowAnimatorImpl
  {
    DisabledElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return 0.0F;
    }
  }
  
  private class ElevateToTranslationZAnimation
    extends FloatingActionButtonGingerbread.ShadowAnimatorImpl
  {
    ElevateToTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return mElevation + mPressedTranslationZ;
    }
  }
  
  private class ResetElevationAnimation
    extends FloatingActionButtonGingerbread.ShadowAnimatorImpl
  {
    ResetElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return mElevation;
    }
  }
  
  private abstract class ShadowAnimatorImpl
    extends ValueAnimatorCompat.AnimatorListenerAdapter
    implements ValueAnimatorCompat.AnimatorUpdateListener
  {
    private float mShadowSizeEnd;
    private float mShadowSizeStart;
    private boolean mValidValues;
    
    private ShadowAnimatorImpl() {}
    
    protected abstract float getTargetShadowSize();
    
    public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
    {
      mShadowDrawable.setShadowSize(mShadowSizeEnd);
      mValidValues = false;
    }
    
    public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
    {
      if (!mValidValues)
      {
        mShadowSizeStart = mShadowDrawable.getShadowSize();
        mShadowSizeEnd = getTargetShadowSize();
        mValidValues = true;
      }
      mShadowDrawable.setShadowSize(mShadowSizeStart + (mShadowSizeEnd - mShadowSizeStart) * paramValueAnimatorCompat.getAnimatedFraction());
    }
  }
}

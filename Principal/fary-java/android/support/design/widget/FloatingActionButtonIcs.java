package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.view.ViewPropertyAnimator;

@TargetApi(14)
@RequiresApi(14)
class FloatingActionButtonIcs
  extends FloatingActionButtonGingerbread
{
  private float mRotation = mView.getRotation();
  
  FloatingActionButtonIcs(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate, ValueAnimatorCompat.Creator paramCreator)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate, paramCreator);
  }
  
  private boolean shouldAnimateVisibilityChange()
  {
    return (ViewCompat.isLaidOut(mView)) && (!mView.isInEditMode());
  }
  
  private void updateFromViewRotation()
  {
    if (Build.VERSION.SDK_INT == 19)
    {
      if (mRotation % 90.0F == 0.0F) {
        break label79;
      }
      if (mView.getLayerType() != 1) {
        mView.setLayerType(1, null);
      }
    }
    for (;;)
    {
      if (mShadowDrawable != null) {
        mShadowDrawable.setRotation(-mRotation);
      }
      if (mBorderDrawable != null) {
        mBorderDrawable.setRotation(-mRotation);
      }
      return;
      label79:
      if (mView.getLayerType() != 0) {
        mView.setLayerType(0, null);
      }
    }
  }
  
  void hide(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeHidden()) {
      return;
    }
    mView.animate().cancel();
    if (shouldAnimateVisibilityChange())
    {
      mAnimState = 1;
      mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
      {
        private boolean mCancelled;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          mCancelled = true;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          mAnimState = 0;
          if (!mCancelled)
          {
            paramAnonymousAnimator = mView;
            if (!paramBoolean) {
              break label59;
            }
          }
          label59:
          for (int i = 8;; i = 4)
          {
            paramAnonymousAnimator.internalSetVisibility(i, paramBoolean);
            if (paramInternalVisibilityChangedListener != null) {
              paramInternalVisibilityChangedListener.onHidden();
            }
            return;
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          mView.internalSetVisibility(0, paramBoolean);
          mCancelled = false;
        }
      });
      return;
    }
    VisibilityAwareImageButton localVisibilityAwareImageButton = mView;
    if (paramBoolean) {}
    for (int i = 8;; i = 4)
    {
      localVisibilityAwareImageButton.internalSetVisibility(i, paramBoolean);
      if (paramInternalVisibilityChangedListener == null) {
        break;
      }
      paramInternalVisibilityChangedListener.onHidden();
      return;
    }
  }
  
  void onPreDraw()
  {
    float f = mView.getRotation();
    if (mRotation != f)
    {
      mRotation = f;
      updateFromViewRotation();
    }
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  void show(@Nullable final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeShown()) {}
    do
    {
      return;
      mView.animate().cancel();
      if (shouldAnimateVisibilityChange())
      {
        mAnimState = 2;
        if (mView.getVisibility() != 0)
        {
          mView.setAlpha(0.0F);
          mView.setScaleY(0.0F);
          mView.setScaleX(0.0F);
        }
        mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            mAnimState = 0;
            if (paramInternalVisibilityChangedListener != null) {
              paramInternalVisibilityChangedListener.onShown();
            }
          }
          
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            mView.internalSetVisibility(0, paramBoolean);
          }
        });
        return;
      }
      mView.internalSetVisibility(0, paramBoolean);
      mView.setAlpha(1.0F);
      mView.setScaleY(1.0F);
      mView.setScaleX(1.0F);
    } while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onShown();
  }
}

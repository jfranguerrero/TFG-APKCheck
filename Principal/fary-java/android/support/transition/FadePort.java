package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Map;

@TargetApi(14)
@RequiresApi(14)
class FadePort
  extends VisibilityPort
{
  private static boolean DBG = false;
  public static final int IN = 1;
  private static final String LOG_TAG = "Fade";
  public static final int OUT = 2;
  private static final String PROPNAME_SCREEN_X = "android:fade:screenX";
  private static final String PROPNAME_SCREEN_Y = "android:fade:screenY";
  private int mFadingMode;
  
  public FadePort()
  {
    this(3);
  }
  
  public FadePort(int paramInt)
  {
    mFadingMode = paramInt;
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    int[] arrayOfInt = new int[2];
    view.getLocationOnScreen(arrayOfInt);
    values.put("android:fade:screenX", Integer.valueOf(arrayOfInt[0]));
    values.put("android:fade:screenY", Integer.valueOf(arrayOfInt[1]));
  }
  
  private Animator createAnimation(View paramView, float paramFloat1, float paramFloat2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    ObjectAnimator localObjectAnimator = null;
    if (paramFloat1 == paramFloat2)
    {
      paramView = localObjectAnimator;
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationEnd(null);
        paramView = localObjectAnimator;
      }
    }
    do
    {
      return paramView;
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramFloat1, paramFloat2 });
      if (DBG) {
        Log.d("Fade", "Created animator " + localObjectAnimator);
      }
      paramView = localObjectAnimator;
    } while (paramAnimatorListenerAdapter == null);
    localObjectAnimator.addListener(paramAnimatorListenerAdapter);
    return localObjectAnimator;
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    super.captureStartValues(paramTransitionValues);
    captureValues(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, final TransitionValues paramTransitionValues2, int paramInt2)
  {
    if (((mFadingMode & 0x1) != 1) || (paramTransitionValues2 == null)) {
      return null;
    }
    paramTransitionValues2 = view;
    if (DBG) {
      if (paramTransitionValues1 == null) {
        break label124;
      }
    }
    label124:
    for (paramViewGroup = view;; paramViewGroup = null)
    {
      Log.d("Fade", "Fade.onAppear: startView, startVis, endView, endVis = " + paramViewGroup + ", " + paramInt1 + ", " + paramTransitionValues2 + ", " + paramInt2);
      paramTransitionValues2.setAlpha(0.0F);
      addListener(new TransitionPort.TransitionListenerAdapter()
      {
        boolean mCanceled = false;
        float mPausedAlpha;
        
        public void onTransitionCancel(TransitionPort paramAnonymousTransitionPort)
        {
          paramTransitionValues2.setAlpha(1.0F);
          mCanceled = true;
        }
        
        public void onTransitionEnd(TransitionPort paramAnonymousTransitionPort)
        {
          if (!mCanceled) {
            paramTransitionValues2.setAlpha(1.0F);
          }
        }
        
        public void onTransitionPause(TransitionPort paramAnonymousTransitionPort)
        {
          mPausedAlpha = paramTransitionValues2.getAlpha();
          paramTransitionValues2.setAlpha(1.0F);
        }
        
        public void onTransitionResume(TransitionPort paramAnonymousTransitionPort)
        {
          paramTransitionValues2.setAlpha(mPausedAlpha);
        }
      });
      return createAnimation(paramTransitionValues2, 0.0F, 1.0F, null);
    }
  }
  
  public Animator onDisappear(final ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, final TransitionValues paramTransitionValues2, final int paramInt2)
  {
    if ((mFadingMode & 0x2) != 2) {
      return null;
    }
    Object localObject4 = null;
    View localView;
    label37:
    Object localObject5;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramTransitionValues1 != null)
    {
      localView = view;
      if (paramTransitionValues2 == null) {
        break label255;
      }
      paramTransitionValues2 = view;
      if (DBG) {
        Log.d("Fade", "Fade.onDisappear: startView, startVis, endView, endVis = " + localView + ", " + paramInt1 + ", " + paramTransitionValues2 + ", " + paramInt2);
      }
      localObject5 = null;
      localObject3 = null;
      if ((paramTransitionValues2 != null) && (paramTransitionValues2.getParent() != null)) {
        break label432;
      }
      if (paramTransitionValues2 == null) {
        break label261;
      }
      localObject1 = paramTransitionValues2;
      localObject2 = localObject3;
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label482;
      }
      paramInt1 = ((Integer)values.get("android:fade:screenX")).intValue();
      int i = ((Integer)values.get("android:fade:screenY")).intValue();
      paramTransitionValues1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramTransitionValues1);
      ViewCompat.offsetLeftAndRight((View)localObject1, paramInt1 - paramTransitionValues1[0] - ((View)localObject1).getLeft());
      ViewCompat.offsetTopAndBottom((View)localObject1, i - paramTransitionValues1[1] - ((View)localObject1).getTop());
      ViewGroupOverlay.createFrom(paramViewGroup).add((View)localObject1);
      createAnimation(paramTransitionValues2, 1.0F, 0.0F, new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramTransitionValues2.setAlpha(1.0F);
          if (val$finalViewToKeep != null) {
            val$finalViewToKeep.setVisibility(paramInt2);
          }
          if (val$finalOverlayView != null) {
            ViewGroupOverlay.createFrom(paramViewGroup).remove(val$finalOverlayView);
          }
        }
      });
      localView = null;
      break;
      label255:
      paramTransitionValues2 = null;
      break label37;
      label261:
      localObject1 = localObject5;
      paramTransitionValues2 = localObject4;
      localObject2 = localObject3;
      if (localView != null) {
        if (localView.getParent() == null)
        {
          localObject1 = localView;
          paramTransitionValues2 = localView;
          localObject2 = localObject3;
        }
        else
        {
          localObject1 = localObject5;
          paramTransitionValues2 = localObject4;
          localObject2 = localObject3;
          if ((localView.getParent() instanceof View))
          {
            localObject1 = localObject5;
            paramTransitionValues2 = localObject4;
            localObject2 = localObject3;
            if (localView.getParent().getParent() == null)
            {
              paramInt1 = ((View)localView.getParent()).getId();
              localObject1 = localObject5;
              paramTransitionValues2 = localObject4;
              localObject2 = localObject3;
              if (paramInt1 != -1)
              {
                localObject1 = localObject5;
                paramTransitionValues2 = localObject4;
                localObject2 = localObject3;
                if (paramViewGroup.findViewById(paramInt1) != null)
                {
                  localObject1 = localObject5;
                  paramTransitionValues2 = localObject4;
                  localObject2 = localObject3;
                  if (mCanRemoveViews)
                  {
                    localObject1 = localView;
                    paramTransitionValues2 = localView;
                    localObject2 = localObject3;
                    continue;
                    label432:
                    if (paramInt2 == 4)
                    {
                      localObject2 = paramTransitionValues2;
                      localObject1 = localObject5;
                    }
                    else if (localView == paramTransitionValues2)
                    {
                      localObject2 = paramTransitionValues2;
                      localObject1 = localObject5;
                    }
                    else
                    {
                      paramTransitionValues2 = localView;
                      localObject1 = paramTransitionValues2;
                      localObject2 = localObject3;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label482:
    if (localObject2 != null)
    {
      ((View)localObject2).setVisibility(0);
      createAnimation(paramTransitionValues2, 1.0F, 0.0F, new AnimatorListenerAdapter()
      {
        boolean mCanceled = false;
        float mPausedAlpha = -1.0F;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          mCanceled = true;
          if (mPausedAlpha >= 0.0F) {
            paramTransitionValues2.setAlpha(mPausedAlpha);
          }
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!mCanceled) {
            paramTransitionValues2.setAlpha(1.0F);
          }
          if ((val$finalViewToKeep != null) && (!mCanceled)) {
            val$finalViewToKeep.setVisibility(paramInt2);
          }
          if (val$finalOverlayView != null) {
            ViewGroupOverlay.createFrom(paramViewGroup).add(val$finalOverlayView);
          }
        }
      });
    }
    return null;
  }
}

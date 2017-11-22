package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewPropertyAnimator;

@TargetApi(19)
@RequiresApi(19)
class ViewPropertyAnimatorCompatKK
{
  ViewPropertyAnimatorCompatKK() {}
  
  public static void setUpdateListener(final View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    ValueAnimator.AnimatorUpdateListener local1 = null;
    if (paramViewPropertyAnimatorUpdateListener != null) {
      local1 = new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          val$listener.onAnimationUpdate(paramView);
        }
      };
    }
    paramView.animate().setUpdateListener(local1);
  }
}

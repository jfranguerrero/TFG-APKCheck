package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

@TargetApi(14)
@RequiresApi(14)
public class TextScale
  extends Transition
{
  private static final String PROPNAME_SCALE = "android:textscale:scale";
  
  public TextScale() {}
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    if ((view instanceof TextView))
    {
      TextView localTextView = (TextView)view;
      values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null) || (!(view instanceof TextView)) || (!(view instanceof TextView))) {}
    label148:
    label152:
    for (;;)
    {
      return null;
      paramViewGroup = (TextView)view;
      paramTransitionValues1 = values;
      paramTransitionValues2 = values;
      float f1;
      if (paramTransitionValues1.get("android:textscale:scale") != null)
      {
        f1 = ((Float)paramTransitionValues1.get("android:textscale:scale")).floatValue();
        if (paramTransitionValues2.get("android:textscale:scale") == null) {
          break label148;
        }
      }
      for (float f2 = ((Float)paramTransitionValues2.get("android:textscale:scale")).floatValue();; f2 = 1.0F)
      {
        if (f1 == f2) {
          break label152;
        }
        paramTransitionValues1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
        paramTransitionValues1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            paramViewGroup.setScaleX(f);
            paramViewGroup.setScaleY(f);
          }
        });
        return paramTransitionValues1;
        f1 = 1.0F;
        break;
      }
    }
  }
}

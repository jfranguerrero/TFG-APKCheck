package android.support.v4.animation;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface AnimatorUpdateListenerCompat
{
  public abstract void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat);
}

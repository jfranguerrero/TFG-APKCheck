package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class Transition
  implements TransitionInterface
{
  TransitionImpl mImpl;
  
  public Transition()
  {
    this(false);
  }
  
  Transition(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label36;
      }
      mImpl = new TransitionApi23();
    }
    for (;;)
    {
      mImpl.init(this);
      return;
      label36:
      if (Build.VERSION.SDK_INT >= 19) {
        mImpl = new TransitionKitKat();
      } else {
        mImpl = new TransitionIcs();
      }
    }
  }
  
  @NonNull
  public Transition addListener(@NonNull TransitionListener paramTransitionListener)
  {
    mImpl.addListener(paramTransitionListener);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@IdRes int paramInt)
  {
    mImpl.addTarget(paramInt);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull View paramView)
  {
    mImpl.addTarget(paramView);
    return this;
  }
  
  public abstract void captureEndValues(@NonNull TransitionValues paramTransitionValues);
  
  public abstract void captureStartValues(@NonNull TransitionValues paramTransitionValues);
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  @NonNull
  public Transition excludeChildren(@IdRes int paramInt, boolean paramBoolean)
  {
    mImpl.excludeChildren(paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull View paramView, boolean paramBoolean)
  {
    mImpl.excludeChildren(paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull Class paramClass, boolean paramBoolean)
  {
    mImpl.excludeChildren(paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@IdRes int paramInt, boolean paramBoolean)
  {
    mImpl.excludeTarget(paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull View paramView, boolean paramBoolean)
  {
    mImpl.excludeTarget(paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull Class paramClass, boolean paramBoolean)
  {
    mImpl.excludeTarget(paramClass, paramBoolean);
    return this;
  }
  
  public long getDuration()
  {
    return mImpl.getDuration();
  }
  
  @Nullable
  public TimeInterpolator getInterpolator()
  {
    return mImpl.getInterpolator();
  }
  
  @NonNull
  public String getName()
  {
    return mImpl.getName();
  }
  
  public long getStartDelay()
  {
    return mImpl.getStartDelay();
  }
  
  @NonNull
  public List<Integer> getTargetIds()
  {
    return mImpl.getTargetIds();
  }
  
  @NonNull
  public List<View> getTargets()
  {
    return mImpl.getTargets();
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return mImpl.getTransitionProperties();
  }
  
  @NonNull
  public TransitionValues getTransitionValues(@NonNull View paramView, boolean paramBoolean)
  {
    return mImpl.getTransitionValues(paramView, paramBoolean);
  }
  
  @NonNull
  public Transition removeListener(@NonNull TransitionListener paramTransitionListener)
  {
    mImpl.removeListener(paramTransitionListener);
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@IdRes int paramInt)
  {
    mImpl.removeTarget(paramInt);
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull View paramView)
  {
    mImpl.removeTarget(paramView);
    return this;
  }
  
  @NonNull
  public Transition setDuration(long paramLong)
  {
    mImpl.setDuration(paramLong);
    return this;
  }
  
  @NonNull
  public Transition setInterpolator(@Nullable TimeInterpolator paramTimeInterpolator)
  {
    mImpl.setInterpolator(paramTimeInterpolator);
    return this;
  }
  
  @NonNull
  public Transition setStartDelay(long paramLong)
  {
    mImpl.setStartDelay(paramLong);
    return this;
  }
  
  public String toString()
  {
    return mImpl.toString();
  }
  
  public static abstract interface TransitionListener
    extends TransitionInterfaceListener<Transition>
  {
    public abstract void onTransitionCancel(@NonNull Transition paramTransition);
    
    public abstract void onTransitionEnd(@NonNull Transition paramTransition);
    
    public abstract void onTransitionPause(@NonNull Transition paramTransition);
    
    public abstract void onTransitionResume(@NonNull Transition paramTransition);
    
    public abstract void onTransitionStart(@NonNull Transition paramTransition);
  }
}

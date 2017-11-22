package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(19)
@RequiresApi(19)
class TransitionKitKat
  extends TransitionImpl
{
  private CompatListener mCompatListener;
  TransitionInterface mExternalTransition;
  Transition mTransition;
  
  TransitionKitKat() {}
  
  static android.transition.TransitionValues convertToPlatform(TransitionValues paramTransitionValues)
  {
    if (paramTransitionValues == null) {
      return null;
    }
    android.transition.TransitionValues localTransitionValues = new android.transition.TransitionValues();
    copyValues(paramTransitionValues, localTransitionValues);
    return localTransitionValues;
  }
  
  static TransitionValues convertToSupport(android.transition.TransitionValues paramTransitionValues)
  {
    if (paramTransitionValues == null) {
      return null;
    }
    TransitionValues localTransitionValues = new TransitionValues();
    copyValues(paramTransitionValues, localTransitionValues);
    return localTransitionValues;
  }
  
  static void copyValues(TransitionValues paramTransitionValues, android.transition.TransitionValues paramTransitionValues1)
  {
    if (paramTransitionValues == null) {}
    do
    {
      return;
      view = view;
    } while (values.size() <= 0);
    values.putAll(values);
  }
  
  static void copyValues(android.transition.TransitionValues paramTransitionValues, TransitionValues paramTransitionValues1)
  {
    if (paramTransitionValues == null) {}
    do
    {
      return;
      view = view;
    } while (values.size() <= 0);
    values.putAll(values);
  }
  
  static void wrapCaptureEndValues(TransitionInterface paramTransitionInterface, android.transition.TransitionValues paramTransitionValues)
  {
    TransitionValues localTransitionValues = new TransitionValues();
    copyValues(paramTransitionValues, localTransitionValues);
    paramTransitionInterface.captureEndValues(localTransitionValues);
    copyValues(localTransitionValues, paramTransitionValues);
  }
  
  static void wrapCaptureStartValues(TransitionInterface paramTransitionInterface, android.transition.TransitionValues paramTransitionValues)
  {
    TransitionValues localTransitionValues = new TransitionValues();
    copyValues(paramTransitionValues, localTransitionValues);
    paramTransitionInterface.captureStartValues(localTransitionValues);
    copyValues(localTransitionValues, paramTransitionValues);
  }
  
  public TransitionImpl addListener(TransitionInterfaceListener paramTransitionInterfaceListener)
  {
    if (mCompatListener == null)
    {
      mCompatListener = new CompatListener();
      mTransition.addListener(mCompatListener);
    }
    mCompatListener.addListener(paramTransitionInterfaceListener);
    return this;
  }
  
  public TransitionImpl addTarget(int paramInt)
  {
    mTransition.addTarget(paramInt);
    return this;
  }
  
  public TransitionImpl addTarget(View paramView)
  {
    mTransition.addTarget(paramView);
    return this;
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    android.transition.TransitionValues localTransitionValues = new android.transition.TransitionValues();
    copyValues(paramTransitionValues, localTransitionValues);
    mTransition.captureEndValues(localTransitionValues);
    copyValues(localTransitionValues, paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    android.transition.TransitionValues localTransitionValues = new android.transition.TransitionValues();
    copyValues(paramTransitionValues, localTransitionValues);
    mTransition.captureStartValues(localTransitionValues);
    copyValues(localTransitionValues, paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    android.transition.TransitionValues localTransitionValues;
    if (paramTransitionValues1 != null)
    {
      localTransitionValues = new android.transition.TransitionValues();
      copyValues(paramTransitionValues1, localTransitionValues);
      paramTransitionValues1 = localTransitionValues;
      if (paramTransitionValues2 == null) {
        break label60;
      }
      localTransitionValues = new android.transition.TransitionValues();
      copyValues(paramTransitionValues2, localTransitionValues);
    }
    label60:
    for (paramTransitionValues2 = localTransitionValues;; paramTransitionValues2 = null)
    {
      return mTransition.createAnimator(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
      paramTransitionValues1 = null;
      break;
    }
  }
  
  public TransitionImpl excludeChildren(int paramInt, boolean paramBoolean)
  {
    mTransition.excludeChildren(paramInt, paramBoolean);
    return this;
  }
  
  public TransitionImpl excludeChildren(View paramView, boolean paramBoolean)
  {
    mTransition.excludeChildren(paramView, paramBoolean);
    return this;
  }
  
  public TransitionImpl excludeChildren(Class paramClass, boolean paramBoolean)
  {
    mTransition.excludeChildren(paramClass, paramBoolean);
    return this;
  }
  
  public TransitionImpl excludeTarget(int paramInt, boolean paramBoolean)
  {
    mTransition.excludeTarget(paramInt, paramBoolean);
    return this;
  }
  
  public TransitionImpl excludeTarget(View paramView, boolean paramBoolean)
  {
    mTransition.excludeTarget(paramView, paramBoolean);
    return this;
  }
  
  public TransitionImpl excludeTarget(Class paramClass, boolean paramBoolean)
  {
    mTransition.excludeTarget(paramClass, paramBoolean);
    return this;
  }
  
  public long getDuration()
  {
    return mTransition.getDuration();
  }
  
  public TimeInterpolator getInterpolator()
  {
    return mTransition.getInterpolator();
  }
  
  public String getName()
  {
    return mTransition.getName();
  }
  
  public long getStartDelay()
  {
    return mTransition.getStartDelay();
  }
  
  public List<Integer> getTargetIds()
  {
    return mTransition.getTargetIds();
  }
  
  public List<View> getTargets()
  {
    return mTransition.getTargets();
  }
  
  public String[] getTransitionProperties()
  {
    return mTransition.getTransitionProperties();
  }
  
  public TransitionValues getTransitionValues(View paramView, boolean paramBoolean)
  {
    TransitionValues localTransitionValues = new TransitionValues();
    copyValues(mTransition.getTransitionValues(paramView, paramBoolean), localTransitionValues);
    return localTransitionValues;
  }
  
  public void init(TransitionInterface paramTransitionInterface, Object paramObject)
  {
    mExternalTransition = paramTransitionInterface;
    if (paramObject == null)
    {
      mTransition = new TransitionWrapper(paramTransitionInterface);
      return;
    }
    mTransition = ((Transition)paramObject);
  }
  
  public TransitionImpl removeListener(TransitionInterfaceListener paramTransitionInterfaceListener)
  {
    if (mCompatListener == null) {}
    do
    {
      return this;
      mCompatListener.removeListener(paramTransitionInterfaceListener);
    } while (!mCompatListener.isEmpty());
    mTransition.removeListener(mCompatListener);
    mCompatListener = null;
    return this;
  }
  
  public TransitionImpl removeTarget(int paramInt)
  {
    if (paramInt > 0) {
      getTargetIds().remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public TransitionImpl removeTarget(View paramView)
  {
    mTransition.removeTarget(paramView);
    return this;
  }
  
  public TransitionImpl setDuration(long paramLong)
  {
    mTransition.setDuration(paramLong);
    return this;
  }
  
  public TransitionImpl setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    mTransition.setInterpolator(paramTimeInterpolator);
    return this;
  }
  
  public TransitionImpl setStartDelay(long paramLong)
  {
    mTransition.setStartDelay(paramLong);
    return this;
  }
  
  public String toString()
  {
    return mTransition.toString();
  }
  
  private class CompatListener
    implements Transition.TransitionListener
  {
    private final ArrayList<TransitionInterfaceListener> mListeners = new ArrayList();
    
    CompatListener() {}
    
    void addListener(TransitionInterfaceListener paramTransitionInterfaceListener)
    {
      mListeners.add(paramTransitionInterfaceListener);
    }
    
    boolean isEmpty()
    {
      return mListeners.isEmpty();
    }
    
    public void onTransitionCancel(Transition paramTransition)
    {
      paramTransition = mListeners.iterator();
      while (paramTransition.hasNext()) {
        ((TransitionInterfaceListener)paramTransition.next()).onTransitionCancel(mExternalTransition);
      }
    }
    
    public void onTransitionEnd(Transition paramTransition)
    {
      paramTransition = mListeners.iterator();
      while (paramTransition.hasNext()) {
        ((TransitionInterfaceListener)paramTransition.next()).onTransitionEnd(mExternalTransition);
      }
    }
    
    public void onTransitionPause(Transition paramTransition)
    {
      paramTransition = mListeners.iterator();
      while (paramTransition.hasNext()) {
        ((TransitionInterfaceListener)paramTransition.next()).onTransitionPause(mExternalTransition);
      }
    }
    
    public void onTransitionResume(Transition paramTransition)
    {
      paramTransition = mListeners.iterator();
      while (paramTransition.hasNext()) {
        ((TransitionInterfaceListener)paramTransition.next()).onTransitionResume(mExternalTransition);
      }
    }
    
    public void onTransitionStart(Transition paramTransition)
    {
      paramTransition = mListeners.iterator();
      while (paramTransition.hasNext()) {
        ((TransitionInterfaceListener)paramTransition.next()).onTransitionStart(mExternalTransition);
      }
    }
    
    void removeListener(TransitionInterfaceListener paramTransitionInterfaceListener)
    {
      mListeners.remove(paramTransitionInterfaceListener);
    }
  }
  
  private static class TransitionWrapper
    extends Transition
  {
    private TransitionInterface mTransition;
    
    public TransitionWrapper(TransitionInterface paramTransitionInterface)
    {
      mTransition = paramTransitionInterface;
    }
    
    public void captureEndValues(android.transition.TransitionValues paramTransitionValues)
    {
      TransitionKitKat.wrapCaptureEndValues(mTransition, paramTransitionValues);
    }
    
    public void captureStartValues(android.transition.TransitionValues paramTransitionValues)
    {
      TransitionKitKat.wrapCaptureStartValues(mTransition, paramTransitionValues);
    }
    
    public Animator createAnimator(ViewGroup paramViewGroup, android.transition.TransitionValues paramTransitionValues1, android.transition.TransitionValues paramTransitionValues2)
    {
      return mTransition.createAnimator(paramViewGroup, TransitionKitKat.convertToSupport(paramTransitionValues1), TransitionKitKat.convertToSupport(paramTransitionValues2));
    }
  }
}

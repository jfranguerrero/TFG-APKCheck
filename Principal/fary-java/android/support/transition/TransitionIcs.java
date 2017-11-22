package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
@RequiresApi(14)
class TransitionIcs
  extends TransitionImpl
{
  private CompatListener mCompatListener;
  TransitionInterface mExternalTransition;
  TransitionPort mTransition;
  
  TransitionIcs() {}
  
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
    mTransition.captureEndValues(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    mTransition.captureStartValues(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return mTransition.createAnimator(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
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
    return mTransition.getTransitionValues(paramView, paramBoolean);
  }
  
  public void init(TransitionInterface paramTransitionInterface, Object paramObject)
  {
    mExternalTransition = paramTransitionInterface;
    if (paramObject == null)
    {
      mTransition = new TransitionWrapper(paramTransitionInterface);
      return;
    }
    mTransition = ((TransitionPort)paramObject);
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
    mTransition.removeTarget(paramInt);
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
    implements TransitionPort.TransitionListener
  {
    private final ArrayList<TransitionInterfaceListener> mListeners = new ArrayList();
    
    CompatListener() {}
    
    public void addListener(TransitionInterfaceListener paramTransitionInterfaceListener)
    {
      mListeners.add(paramTransitionInterfaceListener);
    }
    
    public boolean isEmpty()
    {
      return mListeners.isEmpty();
    }
    
    public void onTransitionCancel(TransitionPort paramTransitionPort)
    {
      paramTransitionPort = mListeners.iterator();
      while (paramTransitionPort.hasNext()) {
        ((TransitionInterfaceListener)paramTransitionPort.next()).onTransitionCancel(mExternalTransition);
      }
    }
    
    public void onTransitionEnd(TransitionPort paramTransitionPort)
    {
      paramTransitionPort = mListeners.iterator();
      while (paramTransitionPort.hasNext()) {
        ((TransitionInterfaceListener)paramTransitionPort.next()).onTransitionEnd(mExternalTransition);
      }
    }
    
    public void onTransitionPause(TransitionPort paramTransitionPort)
    {
      paramTransitionPort = mListeners.iterator();
      while (paramTransitionPort.hasNext()) {
        ((TransitionInterfaceListener)paramTransitionPort.next()).onTransitionPause(mExternalTransition);
      }
    }
    
    public void onTransitionResume(TransitionPort paramTransitionPort)
    {
      paramTransitionPort = mListeners.iterator();
      while (paramTransitionPort.hasNext()) {
        ((TransitionInterfaceListener)paramTransitionPort.next()).onTransitionResume(mExternalTransition);
      }
    }
    
    public void onTransitionStart(TransitionPort paramTransitionPort)
    {
      paramTransitionPort = mListeners.iterator();
      while (paramTransitionPort.hasNext()) {
        ((TransitionInterfaceListener)paramTransitionPort.next()).onTransitionStart(mExternalTransition);
      }
    }
    
    public void removeListener(TransitionInterfaceListener paramTransitionInterfaceListener)
    {
      mListeners.remove(paramTransitionInterfaceListener);
    }
  }
  
  private static class TransitionWrapper
    extends TransitionPort
  {
    private TransitionInterface mTransition;
    
    public TransitionWrapper(TransitionInterface paramTransitionInterface)
    {
      mTransition = paramTransitionInterface;
    }
    
    public void captureEndValues(TransitionValues paramTransitionValues)
    {
      mTransition.captureEndValues(paramTransitionValues);
    }
    
    public void captureStartValues(TransitionValues paramTransitionValues)
    {
      mTransition.captureStartValues(paramTransitionValues);
    }
    
    public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
    {
      return mTransition.createAnimator(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
    }
  }
}

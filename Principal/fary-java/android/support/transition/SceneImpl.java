package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

abstract class SceneImpl
{
  SceneImpl() {}
  
  public abstract void enter();
  
  public abstract void exit();
  
  public abstract ViewGroup getSceneRoot();
  
  public abstract void init(ViewGroup paramViewGroup);
  
  public abstract void init(ViewGroup paramViewGroup, View paramView);
  
  public abstract void setEnterAction(Runnable paramRunnable);
  
  public abstract void setExitAction(Runnable paramRunnable);
}

package android.support.transition;

import android.content.Context;
import android.view.ViewGroup;

abstract class SceneStaticsImpl
{
  SceneStaticsImpl() {}
  
  public abstract SceneImpl getSceneForLayout(ViewGroup paramViewGroup, int paramInt, Context paramContext);
}

package android.support.transition;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
class SceneStaticsIcs
  extends SceneStaticsImpl
{
  SceneStaticsIcs() {}
  
  public SceneImpl getSceneForLayout(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    SceneIcs localSceneIcs = new SceneIcs();
    mScene = ScenePort.getSceneForLayout(paramViewGroup, paramInt, paramContext);
    return localSceneIcs;
  }
}

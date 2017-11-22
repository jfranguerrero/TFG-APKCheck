package android.support.transition;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.transition.Scene;
import android.view.ViewGroup;

@TargetApi(19)
@RequiresApi(19)
class SceneStaticsKitKat
  extends SceneStaticsImpl
{
  SceneStaticsKitKat() {}
  
  public SceneImpl getSceneForLayout(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    SceneKitKat localSceneKitKat = new SceneKitKat();
    mScene = Scene.getSceneForLayout(paramViewGroup, paramInt, paramContext);
    return localSceneKitKat;
  }
}

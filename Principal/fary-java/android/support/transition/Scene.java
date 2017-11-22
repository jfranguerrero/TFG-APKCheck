package android.support.transition;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public class Scene
{
  private static SceneStaticsImpl sImpl = new SceneStaticsIcs();
  SceneImpl mImpl;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      sImpl = new SceneStaticsApi21();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      sImpl = new SceneStaticsKitKat();
      return;
    }
  }
  
  private Scene(SceneImpl paramSceneImpl)
  {
    mImpl = paramSceneImpl;
  }
  
  public Scene(@NonNull ViewGroup paramViewGroup)
  {
    mImpl = createSceneImpl();
    mImpl.init(paramViewGroup);
  }
  
  public Scene(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    mImpl = createSceneImpl();
    mImpl.init(paramViewGroup, paramView);
  }
  
  private SceneImpl createSceneImpl()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new SceneApi21();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return new SceneKitKat();
    }
    return new SceneIcs();
  }
  
  @NonNull
  public static Scene getSceneForLayout(@NonNull ViewGroup paramViewGroup, @LayoutRes int paramInt, @NonNull Context paramContext)
  {
    Object localObject2 = (SparseArray)paramViewGroup.getTag(R.id.transition_scene_layoutid_cache);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SparseArray();
      paramViewGroup.setTag(R.id.transition_scene_layoutid_cache, localObject1);
    }
    localObject2 = (Scene)((SparseArray)localObject1).get(paramInt);
    if (localObject2 != null) {
      return localObject2;
    }
    paramViewGroup = new Scene(sImpl.getSceneForLayout(paramViewGroup, paramInt, paramContext));
    ((SparseArray)localObject1).put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public void enter()
  {
    mImpl.enter();
  }
  
  public void exit()
  {
    mImpl.exit();
  }
  
  @NonNull
  public ViewGroup getSceneRoot()
  {
    return mImpl.getSceneRoot();
  }
  
  public void setEnterAction(@Nullable Runnable paramRunnable)
  {
    mImpl.setEnterAction(paramRunnable);
  }
  
  public void setExitAction(@Nullable Runnable paramRunnable)
  {
    mImpl.setExitAction(paramRunnable);
  }
}

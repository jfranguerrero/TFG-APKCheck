package android.support.transition;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
@RequiresApi(14)
final class ScenePort
{
  private Context mContext;
  Runnable mEnterAction;
  Runnable mExitAction;
  private View mLayout;
  private int mLayoutId = -1;
  private ViewGroup mSceneRoot;
  
  public ScenePort(ViewGroup paramViewGroup)
  {
    mSceneRoot = paramViewGroup;
  }
  
  private ScenePort(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    mContext = paramContext;
    mSceneRoot = paramViewGroup;
    mLayoutId = paramInt;
  }
  
  public ScenePort(ViewGroup paramViewGroup, View paramView)
  {
    mSceneRoot = paramViewGroup;
    mLayout = paramView;
  }
  
  static ScenePort getCurrentScene(View paramView)
  {
    return (ScenePort)paramView.getTag(R.id.transition_current_scene);
  }
  
  public static ScenePort getSceneForLayout(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    return new ScenePort(paramViewGroup, paramInt, paramContext);
  }
  
  static void setCurrentScene(View paramView, ScenePort paramScenePort)
  {
    paramView.setTag(R.id.transition_current_scene, paramScenePort);
  }
  
  public void enter()
  {
    if ((mLayoutId > 0) || (mLayout != null))
    {
      getSceneRoot().removeAllViews();
      if (mLayoutId <= 0) {
        break label72;
      }
      LayoutInflater.from(mContext).inflate(mLayoutId, mSceneRoot);
    }
    for (;;)
    {
      if (mEnterAction != null) {
        mEnterAction.run();
      }
      setCurrentScene(mSceneRoot, this);
      return;
      label72:
      mSceneRoot.addView(mLayout);
    }
  }
  
  public void exit()
  {
    if ((getCurrentScene(mSceneRoot) == this) && (mExitAction != null)) {
      mExitAction.run();
    }
  }
  
  public ViewGroup getSceneRoot()
  {
    return mSceneRoot;
  }
  
  boolean isCreatedFromLayoutResource()
  {
    return mLayoutId > 0;
  }
  
  public void setEnterAction(Runnable paramRunnable)
  {
    mEnterAction = paramRunnable;
  }
  
  public void setExitAction(Runnable paramRunnable)
  {
    mExitAction = paramRunnable;
  }
}

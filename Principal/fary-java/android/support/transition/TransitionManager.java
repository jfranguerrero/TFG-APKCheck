package android.support.transition;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

public class TransitionManager
{
  private static TransitionManagerStaticsImpl sImpl = new TransitionManagerStaticsKitKat();
  private TransitionManagerImpl mImpl;
  
  static
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      sImpl = new TransitionManagerStaticsIcs();
      return;
    }
  }
  
  public TransitionManager()
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      mImpl = new TransitionManagerIcs();
      return;
    }
    mImpl = new TransitionManagerKitKat();
  }
  
  public static void beginDelayedTransition(@NonNull ViewGroup paramViewGroup)
  {
    sImpl.beginDelayedTransition(paramViewGroup);
  }
  
  public static void beginDelayedTransition(@NonNull ViewGroup paramViewGroup, @Nullable Transition paramTransition)
  {
    TransitionManagerStaticsImpl localTransitionManagerStaticsImpl = sImpl;
    if (paramTransition == null) {}
    for (paramTransition = null;; paramTransition = mImpl)
    {
      localTransitionManagerStaticsImpl.beginDelayedTransition(paramViewGroup, paramTransition);
      return;
    }
  }
  
  public static void go(@NonNull Scene paramScene)
  {
    sImpl.go(mImpl);
  }
  
  public static void go(@NonNull Scene paramScene, @Nullable Transition paramTransition)
  {
    TransitionManagerStaticsImpl localTransitionManagerStaticsImpl = sImpl;
    SceneImpl localSceneImpl = mImpl;
    if (paramTransition == null) {}
    for (paramScene = null;; paramScene = mImpl)
    {
      localTransitionManagerStaticsImpl.go(localSceneImpl, paramScene);
      return;
    }
  }
  
  public void setTransition(@NonNull Scene paramScene1, @NonNull Scene paramScene2, @Nullable Transition paramTransition)
  {
    TransitionManagerImpl localTransitionManagerImpl = mImpl;
    SceneImpl localSceneImpl = mImpl;
    paramScene2 = mImpl;
    if (paramTransition == null) {}
    for (paramScene1 = null;; paramScene1 = mImpl)
    {
      localTransitionManagerImpl.setTransition(localSceneImpl, paramScene2, paramScene1);
      return;
    }
  }
  
  public void setTransition(@NonNull Scene paramScene, @Nullable Transition paramTransition)
  {
    TransitionManagerImpl localTransitionManagerImpl = mImpl;
    SceneImpl localSceneImpl = mImpl;
    if (paramTransition == null) {}
    for (paramScene = null;; paramScene = mImpl)
    {
      localTransitionManagerImpl.setTransition(localSceneImpl, paramScene);
      return;
    }
  }
  
  public void transitionTo(@NonNull Scene paramScene)
  {
    mImpl.transitionTo(mImpl);
  }
}

package android.support.transition;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Map;

@TargetApi(14)
@RequiresApi(14)
abstract class VisibilityPort
  extends TransitionPort
{
  private static final String PROPNAME_PARENT = "android:visibility:parent";
  private static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
  private static final String[] sTransitionProperties = { "android:visibility:visibility", "android:visibility:parent" };
  
  VisibilityPort() {}
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    int i = view.getVisibility();
    values.put("android:visibility:visibility", Integer.valueOf(i));
    values.put("android:visibility:parent", view.getParent());
  }
  
  private VisibilityInfo getVisibilityChangeInfo(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    VisibilityInfo localVisibilityInfo = new VisibilityInfo();
    visibilityChange = false;
    fadeIn = false;
    if (paramTransitionValues1 != null)
    {
      startVisibility = ((Integer)values.get("android:visibility:visibility")).intValue();
      startParent = ((ViewGroup)values.get("android:visibility:parent"));
      if (paramTransitionValues2 == null) {
        break label149;
      }
      endVisibility = ((Integer)values.get("android:visibility:visibility")).intValue();
      endParent = ((ViewGroup)values.get("android:visibility:parent"));
      label104:
      if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null)) {
        break label190;
      }
      if ((startVisibility != endVisibility) || (startParent != endParent)) {
        break label162;
      }
    }
    label149:
    label162:
    label190:
    do
    {
      return localVisibilityInfo;
      startVisibility = -1;
      startParent = null;
      break;
      endVisibility = -1;
      endParent = null;
      break label104;
      if (startVisibility != endVisibility) {
        if (startVisibility == 0)
        {
          fadeIn = false;
          visibilityChange = true;
        }
      }
      while (paramTransitionValues1 == null)
      {
        fadeIn = true;
        visibilityChange = true;
        return localVisibilityInfo;
        if (endVisibility == 0)
        {
          fadeIn = true;
          visibilityChange = true;
          continue;
          if (startParent != endParent) {
            if (endParent == null)
            {
              fadeIn = false;
              visibilityChange = true;
            }
            else if (startParent == null)
            {
              fadeIn = true;
              visibilityChange = true;
            }
          }
        }
      }
    } while (paramTransitionValues2 != null);
    fadeIn = false;
    visibilityChange = true;
    return localVisibilityInfo;
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    int j = -1;
    Object localObject2 = null;
    VisibilityInfo localVisibilityInfo = getVisibilityChangeInfo(paramTransitionValues1, paramTransitionValues2);
    Object localObject1 = localObject2;
    View localView;
    if (visibilityChange)
    {
      i = 0;
      if ((mTargets.size() > 0) || (mTargetIds.size() > 0))
      {
        if (paramTransitionValues1 == null) {
          break label175;
        }
        localObject1 = view;
        if (paramTransitionValues2 == null) {
          break label181;
        }
        localView = view;
        label69:
        if (localObject1 == null) {
          break label187;
        }
        i = ((View)localObject1).getId();
        label81:
        if (localView != null) {
          j = localView.getId();
        }
        if ((!isValidTarget((View)localObject1, i)) && (!isValidTarget(localView, j))) {
          break label193;
        }
      }
    }
    label175:
    label181:
    label187:
    label193:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (startParent == null))
      {
        localObject1 = localObject2;
        if (endParent == null) {}
      }
      else
      {
        if (!fadeIn) {
          break label199;
        }
        localObject1 = onAppear(paramViewGroup, paramTransitionValues1, startVisibility, paramTransitionValues2, endVisibility);
      }
      return localObject1;
      localObject1 = null;
      break;
      localView = null;
      break label69;
      i = -1;
      break label81;
    }
    label199:
    return onDisappear(paramViewGroup, paramTransitionValues1, startVisibility, paramTransitionValues2, endVisibility);
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues)
  {
    if (paramTransitionValues == null) {
      return false;
    }
    int i = ((Integer)values.get("android:visibility:visibility")).intValue();
    paramTransitionValues = (View)values.get("android:visibility:parent");
    if ((i == 0) && (paramTransitionValues != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    return null;
  }
  
  private static class VisibilityInfo
  {
    ViewGroup endParent;
    int endVisibility;
    boolean fadeIn;
    ViewGroup startParent;
    int startVisibility;
    boolean visibilityChange;
    
    VisibilityInfo() {}
  }
}

package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

@TargetApi(14)
@RequiresApi(14)
class ChangeBoundsPort
  extends TransitionPort
{
  private static final String LOG_TAG = "ChangeBounds";
  private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
  private static final String PROPNAME_PARENT = "android:changeBounds:parent";
  private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
  private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
  private static RectEvaluator sRectEvaluator = new RectEvaluator();
  private static final String[] sTransitionProperties = { "android:changeBounds:bounds", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  boolean mReparent = false;
  boolean mResizeClip = false;
  int[] tempLocation = new int[2];
  
  ChangeBoundsPort() {}
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = view;
    values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
    values.put("android:changeBounds:parent", view.getParent());
    view.getLocationInWindow(tempLocation);
    values.put("android:changeBounds:windowX", Integer.valueOf(tempLocation[0]));
    values.put("android:changeBounds:windowY", Integer.valueOf(tempLocation[1]));
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, final TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null))
    {
      paramViewGroup = null;
      return paramViewGroup;
    }
    Object localObject2 = values;
    Object localObject1 = values;
    localObject2 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
    ViewGroup localViewGroup = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
    if ((localObject2 == null) || (localViewGroup == null)) {
      return null;
    }
    localObject1 = view;
    int i;
    label93:
    int i9;
    int i10;
    int i7;
    int i8;
    int i5;
    int i6;
    int i3;
    int i4;
    int m;
    int n;
    int i1;
    int i2;
    int k;
    int j;
    if ((localObject2 == localViewGroup) || (((ViewGroup)localObject2).getId() == localViewGroup.getId()))
    {
      i = 1;
      if ((mReparent) && (i == 0)) {
        break label906;
      }
      paramViewGroup = (Rect)values.get("android:changeBounds:bounds");
      paramTransitionValues1 = (Rect)values.get("android:changeBounds:bounds");
      i9 = left;
      i10 = left;
      i7 = top;
      i8 = top;
      i5 = right;
      i6 = right;
      i3 = bottom;
      i4 = bottom;
      m = i5 - i9;
      n = i3 - i7;
      i1 = i6 - i10;
      i2 = i4 - i8;
      k = 0;
      j = 0;
      i = k;
      if (m != 0)
      {
        i = k;
        if (n != 0)
        {
          i = k;
          if (i1 != 0)
          {
            i = k;
            if (i2 != 0)
            {
              if (i9 != i10) {
                j = 0 + 1;
              }
              i = j;
              if (i7 != i8) {
                i = j + 1;
              }
              j = i;
              if (i5 != i6) {
                j = i + 1;
              }
              i = j;
              if (i3 != i4) {
                i = j + 1;
              }
            }
          }
        }
      }
      if (i <= 0) {
        break label1212;
      }
      if (mResizeClip) {
        break label580;
      }
      paramViewGroup = new PropertyValuesHolder[i];
      if (i9 != i10) {
        ((View)localObject1).setLeft(i9);
      }
      if (i7 != i8) {
        ((View)localObject1).setTop(i7);
      }
      if (i5 != i6) {
        ((View)localObject1).setRight(i5);
      }
      if (i3 != i4) {
        ((View)localObject1).setBottom(i3);
      }
      if (i9 == i10) {
        break label1226;
      }
      j = 0 + 1;
      paramViewGroup[0] = PropertyValuesHolder.ofInt("left", new int[] { i9, i10 });
    }
    for (;;)
    {
      i = j;
      if (i7 != i8)
      {
        paramViewGroup[j] = PropertyValuesHolder.ofInt("top", new int[] { i7, i8 });
        i = j + 1;
      }
      j = i;
      if (i5 != i6)
      {
        paramViewGroup[i] = PropertyValuesHolder.ofInt("right", new int[] { i5, i6 });
        j = i + 1;
      }
      if (i3 != i4) {
        paramViewGroup[j] = PropertyValuesHolder.ofInt("bottom", new int[] { i3, i4 });
      }
      for (;;)
      {
        paramTransitionValues1 = ObjectAnimator.ofPropertyValuesHolder(localObject1, paramViewGroup);
        paramViewGroup = paramTransitionValues1;
        if (!(((View)localObject1).getParent() instanceof ViewGroup)) {
          break;
        }
        paramViewGroup = (ViewGroup)((View)localObject1).getParent();
        addListener(new TransitionPort.TransitionListenerAdapter()
        {
          boolean mCanceled = false;
          
          public void onTransitionCancel(TransitionPort paramAnonymousTransitionPort)
          {
            mCanceled = true;
          }
          
          public void onTransitionEnd(TransitionPort paramAnonymousTransitionPort)
          {
            if (!mCanceled) {}
          }
          
          public void onTransitionPause(TransitionPort paramAnonymousTransitionPort) {}
          
          public void onTransitionResume(TransitionPort paramAnonymousTransitionPort) {}
        });
        return paramTransitionValues1;
        i = 0;
        break label93;
        label580:
        if (m != i1) {
          ((View)localObject1).setRight(Math.max(m, i1) + i10);
        }
        if (n != i2) {
          ((View)localObject1).setBottom(Math.max(n, i2) + i8);
        }
        if (i9 != i10) {
          ((View)localObject1).setTranslationX(i9 - i10);
        }
        if (i7 != i8) {
          ((View)localObject1).setTranslationY(i7 - i8);
        }
        float f1 = i10 - i9;
        float f2 = i8 - i7;
        k = i1 - m;
        i3 = i2 - n;
        j = 0;
        if (f1 != 0.0F) {
          j = 0 + 1;
        }
        i = j;
        if (f2 != 0.0F) {
          i = j + 1;
        }
        if (k == 0)
        {
          j = i;
          if (i3 == 0) {}
        }
        else
        {
          j = i + 1;
        }
        paramViewGroup = new PropertyValuesHolder[j];
        if (f1 != 0.0F)
        {
          i = 0 + 1;
          paramViewGroup[0] = PropertyValuesHolder.ofFloat("translationX", new float[] { ((View)localObject1).getTranslationX(), 0.0F });
        }
        for (;;)
        {
          if (f2 != 0.0F) {
            paramViewGroup[i] = PropertyValuesHolder.ofFloat("translationY", new float[] { ((View)localObject1).getTranslationY(), 0.0F });
          }
          for (;;)
          {
            if ((k != 0) || (i3 != 0))
            {
              new Rect(0, 0, m, n);
              new Rect(0, 0, i1, i2);
            }
            paramViewGroup = ObjectAnimator.ofPropertyValuesHolder(localObject1, paramViewGroup);
            if ((((View)localObject1).getParent() instanceof ViewGroup))
            {
              paramTransitionValues1 = (ViewGroup)((View)localObject1).getParent();
              addListener(new TransitionPort.TransitionListenerAdapter()
              {
                boolean mCanceled = false;
                
                public void onTransitionCancel(TransitionPort paramAnonymousTransitionPort)
                {
                  mCanceled = true;
                }
                
                public void onTransitionEnd(TransitionPort paramAnonymousTransitionPort)
                {
                  if (!mCanceled) {}
                }
                
                public void onTransitionPause(TransitionPort paramAnonymousTransitionPort) {}
                
                public void onTransitionResume(TransitionPort paramAnonymousTransitionPort) {}
              });
            }
            paramViewGroup.addListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymousAnimator) {}
            });
            return paramViewGroup;
            label906:
            i = ((Integer)values.get("android:changeBounds:windowX")).intValue();
            j = ((Integer)values.get("android:changeBounds:windowY")).intValue();
            k = ((Integer)values.get("android:changeBounds:windowX")).intValue();
            m = ((Integer)values.get("android:changeBounds:windowY")).intValue();
            if ((i != k) || (j != m))
            {
              paramViewGroup.getLocationInWindow(tempLocation);
              paramTransitionValues1 = Bitmap.createBitmap(((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
              ((View)localObject1).draw(new Canvas(paramTransitionValues1));
              paramTransitionValues1 = new BitmapDrawable(paramTransitionValues1);
              ((View)localObject1).setVisibility(4);
              ViewOverlay.createFrom(paramViewGroup).add(paramTransitionValues1);
              paramTransitionValues2 = new Rect(i - tempLocation[0], j - tempLocation[1], i - tempLocation[0] + ((View)localObject1).getWidth(), j - tempLocation[1] + ((View)localObject1).getHeight());
              localObject2 = new Rect(k - tempLocation[0], m - tempLocation[1], k - tempLocation[0] + ((View)localObject1).getWidth(), m - tempLocation[1] + ((View)localObject1).getHeight());
              paramTransitionValues2 = ObjectAnimator.ofObject(paramTransitionValues1, "bounds", sRectEvaluator, new Object[] { paramTransitionValues2, localObject2 });
              paramTransitionValues2.addListener(new AnimatorListenerAdapter()
              {
                public void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  ViewOverlay.createFrom(paramViewGroup).remove(paramTransitionValues1);
                  val$view.setVisibility(0);
                }
              });
              return paramTransitionValues2;
            }
            label1212:
            return null;
          }
          i = 0;
        }
      }
      label1226:
      j = 0;
    }
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public void setReparent(boolean paramBoolean)
  {
    mReparent = paramBoolean;
  }
  
  public void setResizeClip(boolean paramBoolean)
  {
    mResizeClip = paramBoolean;
  }
}

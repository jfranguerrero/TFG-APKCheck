package android.support.transition;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@TargetApi(14)
@RequiresApi(14)
class ViewOverlay
{
  protected OverlayViewGroup mOverlayViewGroup = new OverlayViewGroup(paramContext, paramViewGroup, paramView, this);
  
  ViewOverlay(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  public static ViewOverlay createFrom(View paramView)
  {
    ViewGroup localViewGroup = getContentView(paramView);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof OverlayViewGroup)) {
          return mViewOverlay;
        }
        i += 1;
      }
      return new ViewGroupOverlay(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  static ViewGroup getContentView(View paramView)
  {
    while (paramView != null)
    {
      if ((paramView.getId() == 16908290) && ((paramView instanceof ViewGroup))) {
        return (ViewGroup)paramView;
      }
      if ((paramView.getParent() instanceof ViewGroup)) {
        paramView = (ViewGroup)paramView.getParent();
      }
    }
    return null;
  }
  
  public void add(Drawable paramDrawable)
  {
    mOverlayViewGroup.add(paramDrawable);
  }
  
  public void clear()
  {
    mOverlayViewGroup.clear();
  }
  
  ViewGroup getOverlayView()
  {
    return mOverlayViewGroup;
  }
  
  boolean isEmpty()
  {
    return mOverlayViewGroup.isEmpty();
  }
  
  public void remove(Drawable paramDrawable)
  {
    mOverlayViewGroup.remove(paramDrawable);
  }
  
  static class OverlayViewGroup
    extends ViewGroup
  {
    static Method sInvalidateChildInParentFastMethod;
    ArrayList<Drawable> mDrawables = null;
    ViewGroup mHostView;
    View mRequestingView;
    ViewOverlay mViewOverlay;
    
    static
    {
      try
      {
        sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    
    OverlayViewGroup(Context paramContext, ViewGroup paramViewGroup, View paramView, ViewOverlay paramViewOverlay)
    {
      super();
      mHostView = paramViewGroup;
      mRequestingView = paramView;
      setRight(paramViewGroup.getWidth());
      setBottom(paramViewGroup.getHeight());
      paramViewGroup.addView(this);
      mViewOverlay = paramViewOverlay;
    }
    
    private void getOffset(int[] paramArrayOfInt)
    {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      ViewGroup localViewGroup = (ViewGroup)getParent();
      mHostView.getLocationOnScreen(arrayOfInt1);
      mRequestingView.getLocationOnScreen(arrayOfInt2);
      arrayOfInt2[0] -= arrayOfInt1[0];
      arrayOfInt2[1] -= arrayOfInt1[1];
    }
    
    public void add(Drawable paramDrawable)
    {
      if (mDrawables == null) {
        mDrawables = new ArrayList();
      }
      if (!mDrawables.contains(paramDrawable))
      {
        mDrawables.add(paramDrawable);
        invalidate(paramDrawable.getBounds());
        paramDrawable.setCallback(this);
      }
    }
    
    public void add(View paramView)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if ((localViewGroup != mHostView) && (localViewGroup.getParent() != null))
        {
          int[] arrayOfInt1 = new int[2];
          int[] arrayOfInt2 = new int[2];
          localViewGroup.getLocationOnScreen(arrayOfInt1);
          mHostView.getLocationOnScreen(arrayOfInt2);
          ViewCompat.offsetLeftAndRight(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
          ViewCompat.offsetTopAndBottom(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
        }
        localViewGroup.removeView(paramView);
        if (paramView.getParent() != null) {
          localViewGroup.removeView(paramView);
        }
      }
      super.addView(paramView, getChildCount() - 1);
    }
    
    public void clear()
    {
      removeAllViews();
      if (mDrawables != null) {
        mDrawables.clear();
      }
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      int i = 0;
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      ViewGroup localViewGroup = (ViewGroup)getParent();
      mHostView.getLocationOnScreen(arrayOfInt1);
      mRequestingView.getLocationOnScreen(arrayOfInt2);
      paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
      paramCanvas.clipRect(new Rect(0, 0, mRequestingView.getWidth(), mRequestingView.getHeight()));
      super.dispatchDraw(paramCanvas);
      if (mDrawables == null) {}
      for (;;)
      {
        int j = 0;
        while (j < i)
        {
          ((Drawable)mDrawables.get(j)).draw(paramCanvas);
          j += 1;
        }
        i = mDrawables.size();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public void invalidateChildFast(View paramView, Rect paramRect)
    {
      if (mHostView != null)
      {
        int i = paramView.getLeft();
        int j = paramView.getTop();
        paramView = new int[2];
        getOffset(paramView);
        paramRect.offset(paramView[0] + i, paramView[1] + j);
        mHostView.invalidate(paramRect);
      }
    }
    
    public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
    {
      if (mHostView != null)
      {
        paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
        if ((mHostView instanceof ViewGroup))
        {
          paramArrayOfInt[0] = 0;
          paramArrayOfInt[1] = 0;
          int[] arrayOfInt = new int[2];
          getOffset(arrayOfInt);
          paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
          return super.invalidateChildInParent(paramArrayOfInt, paramRect);
        }
        invalidate(paramRect);
      }
      return null;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected ViewParent invalidateChildInParentFast(int paramInt1, int paramInt2, Rect paramRect)
    {
      if (((mHostView instanceof ViewGroup)) && (sInvalidateChildInParentFastMethod != null)) {}
      try
      {
        getOffset(new int[2]);
        sInvalidateChildInParentFastMethod.invoke(mHostView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect });
        return null;
      }
      catch (IllegalAccessException paramRect)
      {
        for (;;)
        {
          paramRect.printStackTrace();
        }
      }
      catch (InvocationTargetException paramRect)
      {
        for (;;)
        {
          paramRect.printStackTrace();
        }
      }
    }
    
    public void invalidateDrawable(Drawable paramDrawable)
    {
      invalidate(paramDrawable.getBounds());
    }
    
    boolean isEmpty()
    {
      return (getChildCount() == 0) && ((mDrawables == null) || (mDrawables.size() == 0));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void remove(Drawable paramDrawable)
    {
      if (mDrawables != null)
      {
        mDrawables.remove(paramDrawable);
        invalidate(paramDrawable.getBounds());
        paramDrawable.setCallback(null);
      }
    }
    
    public void remove(View paramView)
    {
      super.removeView(paramView);
      if (isEmpty()) {
        mHostView.removeView(this);
      }
    }
    
    protected boolean verifyDrawable(Drawable paramDrawable)
    {
      return (super.verifyDrawable(paramDrawable)) || ((mDrawables != null) && (mDrawables.contains(paramDrawable)));
    }
    
    static class TouchInterceptor
      extends View
    {
      TouchInterceptor(Context paramContext)
      {
        super();
      }
    }
  }
}

package android.support.v4.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@TargetApi(11)
@RequiresApi(11)
class DrawableWrapperHoneycomb
  extends DrawableWrapperGingerbread
{
  DrawableWrapperHoneycomb(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  DrawableWrapperHoneycomb(DrawableWrapperGingerbread.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public void jumpToCurrentState()
  {
    mDrawable.jumpToCurrentState();
  }
  
  @NonNull
  DrawableWrapperGingerbread.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateHoneycomb(mState, null);
  }
  
  private static class DrawableWrapperStateHoneycomb
    extends DrawableWrapperGingerbread.DrawableWrapperState
  {
    DrawableWrapperStateHoneycomb(@Nullable DrawableWrapperGingerbread.DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
    {
      super(paramResources);
    }
    
    public Drawable newDrawable(@Nullable Resources paramResources)
    {
      return new DrawableWrapperHoneycomb(this, paramResources);
    }
  }
}

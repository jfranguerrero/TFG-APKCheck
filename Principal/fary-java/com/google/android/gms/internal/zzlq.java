package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

@zzmb
@TargetApi(19)
public class zzlq
  extends zzlo
{
  private Object zzPI = new Object();
  private PopupWindow zzPJ;
  private boolean zzPK = false;
  
  zzlq(Context paramContext, zzov.zza paramZza, zzqp paramZzqp, zzln.zza paramZza1)
  {
    super(paramContext, paramZza, paramZzqp, paramZza1);
  }
  
  private void zziC()
  {
    synchronized (zzPI)
    {
      zzPK = true;
      if (((mContext instanceof Activity)) && (((Activity)mContext).isDestroyed())) {
        zzPJ = null;
      }
      if (zzPJ != null)
      {
        if (zzPJ.isShowing()) {
          zzPJ.dismiss();
        }
        zzPJ = null;
      }
      return;
    }
  }
  
  public void cancel()
  {
    zziC();
    super.cancel();
  }
  
  protected void zzO(int paramInt)
  {
    zziC();
    super.zzO(paramInt);
  }
  
  protected void zziB()
  {
    if ((mContext instanceof Activity)) {}
    Object localObject2;
    for (Window localWindow = ((Activity)mContext).getWindow();; localObject2 = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null)) {}
      while (((Activity)mContext).isDestroyed()) {
        return;
      }
      FrameLayout localFrameLayout = new FrameLayout(mContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(zzGt.getView(), -1, -1);
      synchronized (zzPI)
      {
        if (zzPK) {
          return;
        }
      }
      zzPJ = new PopupWindow(localFrameLayout, 1, 1, false);
      zzPJ.setOutsideTouchable(true);
      zzPJ.setClippingEnabled(false);
      zzpe.zzbc("Displaying the 1x1 popup off the screen.");
      try
      {
        zzPJ.showAtLocation(localObject1.getDecorView(), 0, -1, -1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          zzPJ = null;
        }
      }
    }
  }
}

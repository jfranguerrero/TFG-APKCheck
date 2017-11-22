package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class zzabu
  extends ImageView
{
  private Uri zzaDu;
  private int zzaDv;
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void zzcK(int paramInt)
  {
    zzaDv = paramInt;
  }
  
  public void zzr(Uri paramUri)
  {
    zzaDu = paramUri;
  }
  
  public int zzwO()
  {
    return zzaDv;
  }
}

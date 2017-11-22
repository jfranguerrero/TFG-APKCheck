package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzs;

public final class zzabt
  extends Drawable
  implements Drawable.Callback
{
  private int mFrom;
  private boolean zzaCZ = true;
  private int zzaDe = 0;
  private int zzaDf;
  private int zzaDg = 255;
  private int zzaDh;
  private int zzaDi = 0;
  private boolean zzaDj;
  private zzb zzaDk;
  private Drawable zzaDl;
  private Drawable zzaDm;
  private boolean zzaDn;
  private boolean zzaDo;
  private boolean zzaDp;
  private int zzaDq;
  private long zzaed;
  
  public zzabt(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zza.zzwN();
    }
    zzaDl = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = zzaDk;
    zzaDt |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zza.zzwN();
    }
    zzaDm = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = zzaDk;
    zzaDt |= paramDrawable1.getChangingConfigurations();
  }
  
  zzabt(zzb paramZzb)
  {
    zzaDk = new zzb(paramZzb);
  }
  
  public boolean canConstantState()
  {
    if (!zzaDn) {
      if ((zzaDl.getConstantState() == null) || (zzaDm.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      zzaDo = bool;
      zzaDn = true;
      return zzaDo;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (zzaDe)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = zzaDi;
        bool = zzaCZ;
        localDrawable1 = zzaDl;
        localDrawable2 = zzaDm;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == zzaDg)
        {
          localDrawable2.setAlpha(zzaDg);
          localDrawable2.draw(paramCanvas);
        }
        return;
        zzaed = SystemClock.uptimeMillis();
        zzaDe = 2;
        i = k;
      }
    } while (zzaed < 0L);
    float f = (float)(SystemClock.uptimeMillis() - zzaed) / zzaDh;
    if (f >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        zzaDe = 0;
      }
      zzaDi = ((int)(Math.min(f, 1.0F) * (zzaDf + 0) + 0.0F));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(zzaDg - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(zzaDg);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(zzaDg);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | zzaDk.mChangingConfigurations | zzaDk.zzaDt;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      zzaDk.mChangingConfigurations = getChangingConfigurations();
      return zzaDk;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(zzaDl.getIntrinsicHeight(), zzaDm.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(zzaDl.getIntrinsicWidth(), zzaDm.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!zzaDp)
    {
      zzaDq = Drawable.resolveOpacity(zzaDl.getOpacity(), zzaDm.getOpacity());
      zzaDp = true;
    }
    return zzaDq;
  }
  
  @TargetApi(11)
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (zzs.zzyx())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!zzaDj) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      zzaDl.mutate();
      zzaDm.mutate();
      zzaDj = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    zzaDl.setBounds(paramRect);
    zzaDm.setBounds(paramRect);
  }
  
  @TargetApi(11)
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (zzs.zzyx())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (zzaDi == zzaDg) {
      zzaDi = paramInt;
    }
    zzaDg = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    zzaDl.setColorFilter(paramColorFilter);
    zzaDm.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    mFrom = 0;
    zzaDf = zzaDg;
    zzaDi = 0;
    zzaDh = paramInt;
    zzaDe = 1;
    invalidateSelf();
  }
  
  @TargetApi(11)
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (zzs.zzyx())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
  
  public Drawable zzwM()
  {
    return zzaDm;
  }
  
  private static final class zza
    extends Drawable
  {
    private static final zza zzaDr = new zza();
    private static final zza zzaDs = new zza(null);
    
    private zza() {}
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return zzaDs;
    }
    
    public int getOpacity()
    {
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    private static final class zza
      extends Drawable.ConstantState
    {
      private zza() {}
      
      public int getChangingConfigurations()
      {
        return 0;
      }
      
      public Drawable newDrawable()
      {
        return zzabt.zza.zzwN();
      }
    }
  }
  
  static final class zzb
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    int zzaDt;
    
    zzb(zzb paramZzb)
    {
      if (paramZzb != null)
      {
        mChangingConfigurations = mChangingConfigurations;
        zzaDt = zzaDt;
      }
    }
    
    public int getChangingConfigurations()
    {
      return mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new zzabt(this);
    }
  }
}

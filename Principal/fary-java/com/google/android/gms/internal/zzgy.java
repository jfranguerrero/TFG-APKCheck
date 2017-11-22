package com.google.android.gms.internal;

import android.graphics.Point;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzgy
  extends zzhb.zza
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private final FrameLayout zzGI;
  private Map<String, WeakReference<View>> zzGJ = new HashMap();
  @Nullable
  private zzgn zzGK;
  boolean zzGL = false;
  int zzGM;
  int zzGN;
  @Nullable
  private zzgu zzGd;
  private final Object zzrN = new Object();
  @Nullable
  private FrameLayout zzsc;
  
  public zzgy(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    zzGI = paramFrameLayout1;
    zzsc = paramFrameLayout2;
    zzv.zzdh().zza(zzGI, this);
    zzv.zzdh().zza(zzGI, this);
    zzGI.setOnTouchListener(this);
    zzGI.setOnClickListener(this);
  }
  
  private void zzd(zzgv paramZzgv)
  {
    final View localView;
    synchronized (zzrN)
    {
      if ((zzGJ == null) || (!zzGJ.containsKey("2011")))
      {
        paramZzgv.zzfW();
        return;
      }
      localView = (View)((WeakReference)zzGJ.get("2011")).get();
      if (!(localView instanceof FrameLayout))
      {
        paramZzgv.zzfW();
        return;
      }
    }
    paramZzgv.zza(localView, new zzgs()
    {
      public void zzc(MotionEvent paramAnonymousMotionEvent)
      {
        onTouch(null, paramAnonymousMotionEvent);
      }
      
      public void zzfR()
      {
        onClick(localView);
      }
    });
  }
  
  public void destroy()
  {
    synchronized (zzrN)
    {
      if (zzsc != null) {
        zzsc.removeAllViews();
      }
      zzsc = null;
      zzGJ = null;
      zzGK = null;
      zzGd = null;
      return;
    }
  }
  
  int getMeasuredHeight()
  {
    return zzGI.getMeasuredHeight();
  }
  
  int getMeasuredWidth()
  {
    return zzGI.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    synchronized (zzrN)
    {
      if (zzGd == null) {
        return;
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("x", zzB(zzGM));
      localJSONObject.put("y", zzB(zzGN));
      if ((zzGK != null) && (zzGK.zzfJ().equals(paramView))) {
        if (((zzGd instanceof zzgt)) && (((zzgt)zzGd).zzfT() != null))
        {
          ((zzgt)zzGd).zzfT().zza(paramView, "1007", localJSONObject, zzGJ, zzGI);
          return;
          paramView = finally;
          throw paramView;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zzpe.zzbe("Unable to get click location");
        continue;
        zzGd.zza(paramView, "1007", localJSONObject, zzGJ, zzGI);
        continue;
        zzGd.zza(paramView, zzGJ, localJSONObject, zzGI);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    synchronized (zzrN)
    {
      if (zzGL)
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((i != 0) && (j != 0) && (zzsc != null))
        {
          zzsc.setLayoutParams(new FrameLayout.LayoutParams(i, j));
          zzGL = false;
        }
      }
      if (zzGd != null) {
        zzGd.zzd(zzGI, zzGJ);
      }
      return;
    }
  }
  
  public void onScrollChanged()
  {
    synchronized (zzrN)
    {
      if (zzGd != null) {
        zzGd.zzd(zzGI, zzGJ);
      }
      return;
    }
  }
  
  public boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (zzrN)
    {
      if (zzGd == null) {
        return false;
      }
      Point localPoint = zze(paramMotionEvent);
      zzGM = x;
      zzGN = y;
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(x, y);
      zzGd.zzd(paramMotionEvent);
      paramMotionEvent.recycle();
      return false;
    }
  }
  
  int zzB(int paramInt)
  {
    return zzeh.zzeO().zzc(zzGd.getContext(), paramInt);
  }
  
  public zzd zzU(String paramString)
  {
    Object localObject1 = null;
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzGJ == null) {
          return null;
        }
        paramString = (WeakReference)zzGJ.get(paramString);
        if (paramString == null)
        {
          paramString = localObject1;
          paramString = zze.zzA(paramString);
          return paramString;
        }
      }
      paramString = (View)paramString.get();
    }
  }
  
  @Nullable
  zzgn zzc(zzgv paramZzgv)
  {
    return paramZzgv.zza(this);
  }
  
  public void zzc(String paramString, zzd arg2)
  {
    View localView = (View)zze.zzE(???);
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzGJ == null) {
          return;
        }
        if (localView == null)
        {
          zzGJ.remove(paramString);
          return;
        }
      }
      zzGJ.put(paramString, new WeakReference(localView));
      localView.setOnTouchListener(this);
      localView.setClickable(true);
      localView.setOnClickListener(this);
    }
  }
  
  Point zze(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    zzGI.getLocationOnScreen(arrayOfInt);
    float f1 = paramMotionEvent.getRawX();
    float f2 = arrayOfInt[0];
    float f3 = paramMotionEvent.getRawY();
    float f4 = arrayOfInt[1];
    return new Point((int)(f1 - f2), (int)(f3 - f4));
  }
  
  public void zze(final zzd paramZzd)
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        zzj(null);
        paramZzd = zze.zzE(paramZzd);
        if (!(paramZzd instanceof zzgv))
        {
          zzpe.zzbe("Not an instance of native engine. This is most likely a transient error");
          return;
        }
        if (zzsc != null)
        {
          zzsc.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
          zzGI.requestLayout();
        }
        zzGL = true;
        paramZzd = (zzgv)paramZzd;
        if ((zzGd != null) && (((Boolean)zzfx.zzDV.get()).booleanValue())) {
          zzGd.zzc(zzGI, zzGJ);
        }
        if (((zzGd instanceof zzgt)) && (((zzgt)zzGd).zzfS()))
        {
          ((zzgt)zzGd).zzc(paramZzd);
          if (((Boolean)zzfx.zzDV.get()).booleanValue()) {
            zzsc.setClickable(false);
          }
          zzsc.removeAllViews();
          zzGK = zzc(paramZzd);
          if (zzGK != null)
          {
            if (zzGJ != null) {
              zzGJ.put("1007", new WeakReference(zzGK.zzfJ()));
            }
            zzsc.addView(zzGK);
          }
          paramZzd.zza(zzGI, zzGJ, this, this);
          zzpi.zzWR.post(new Runnable()
          {
            public void run()
            {
              zzqp localZzqp = paramZzd.zzfU();
              if ((localZzqp != null) && (zzgy.zza(zzgy.this) != null)) {
                zzgy.zza(zzgy.this).addView(localZzqp.getView());
              }
              if (!(paramZzd instanceof zzgt)) {
                zzgy.zza(zzgy.this, paramZzd);
              }
            }
          });
          zzj(zzGI);
          return;
        }
      }
      zzGd = paramZzd;
      if ((paramZzd instanceof zzgt)) {
        ((zzgt)paramZzd).zzc(null);
      }
    }
  }
  
  void zzj(@Nullable View paramView)
  {
    if (zzGd != null) {
      if (!(zzGd instanceof zzgt)) {
        break label40;
      }
    }
    label40:
    for (zzgu localZzgu = ((zzgt)zzGd).zzfT();; localZzgu = zzGd)
    {
      if (localZzgu != null) {
        localZzgu.zzj(paramView);
      }
      return;
    }
  }
}

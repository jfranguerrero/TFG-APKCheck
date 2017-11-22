package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzf;
import java.util.Map;
import java.util.Set;

@zzmb
public class zzkj
  extends zzko
{
  static final Set<String> zzLq = zzf.zzc(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" });
  private final zzqp zzGt;
  private PopupWindow zzLA;
  private RelativeLayout zzLB;
  private ViewGroup zzLC;
  private final Activity zzLg;
  private String zzLr = "top-right";
  private boolean zzLs = true;
  private int zzLt = 0;
  private int zzLu = 0;
  private int zzLv = 0;
  private int zzLw = 0;
  private ImageView zzLx;
  private LinearLayout zzLy;
  private zzkp zzLz;
  private int zzrG = -1;
  private int zzrH = -1;
  private final Object zzrN = new Object();
  private zzec zzum;
  
  public zzkj(zzqp paramZzqp, zzkp paramZzkp)
  {
    super(paramZzqp, "resize");
    zzGt = paramZzqp;
    zzLg = paramZzqp.zzkR();
    zzLz = paramZzkp;
  }
  
  private int[] zzgQ()
  {
    if (!zzgS()) {
      return null;
    }
    if (zzLs) {
      return new int[] { zzLt + zzLv, zzLu + zzLw };
    }
    int[] arrayOfInt1 = zzv.zzcJ().zzi(zzLg);
    int[] arrayOfInt2 = zzv.zzcJ().zzk(zzLg);
    int m = arrayOfInt1[0];
    int j = zzLt + zzLv;
    int k = zzLu + zzLw;
    int i;
    if (j < 0)
    {
      i = 0;
      if (k >= arrayOfInt2[0]) {
        break label149;
      }
      j = arrayOfInt2[0];
    }
    for (;;)
    {
      return new int[] { i, j };
      i = j;
      if (zzrG + j <= m) {
        break;
      }
      i = m - zzrG;
      break;
      label149:
      j = k;
      if (zzrH + k > arrayOfInt2[1]) {
        j = arrayOfInt2[1] - zzrH;
      }
    }
  }
  
  private void zzj(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width"))) {
      zzrG = zzv.zzcJ().zzaW((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height"))) {
      zzrH = zzv.zzcJ().zzaW((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX"))) {
      zzLv = zzv.zzcJ().zzaW((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY"))) {
      zzLw = zzv.zzcJ().zzaW((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen"))) {
      zzLs = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    }
    paramMap = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(paramMap)) {
      zzLr = paramMap;
    }
  }
  
  public void execute(Map<String, String> paramMap)
  {
    synchronized (zzrN)
    {
      if (zzLg == null)
      {
        zzay("Not an activity context. Cannot resize.");
        return;
      }
      if (zzGt.zzbD() == null)
      {
        zzay("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (zzGt.zzbD().zzzl)
    {
      zzay("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (zzGt.zzkZ())
    {
      zzay("Cannot resize an expanded banner.");
      return;
    }
    zzj(paramMap);
    if (!zzgP())
    {
      zzay("Invalid width and height options. Cannot resize.");
      return;
    }
    paramMap = zzLg.getWindow();
    if ((paramMap == null) || (paramMap.getDecorView() == null))
    {
      zzay("Activity context is not ready, cannot get window or decor view.");
      return;
    }
    int[] arrayOfInt = zzgQ();
    if (arrayOfInt == null)
    {
      zzay("Resize location out of screen or close button is not visible.");
      return;
    }
    int i = zzeh.zzeO().zzb(zzLg, zzrG);
    int j = zzeh.zzeO().zzb(zzLg, zzrH);
    Object localObject2 = zzGt.getView().getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
    {
      ((ViewGroup)localObject2).removeView(zzGt.getView());
      if (zzLA == null)
      {
        zzLC = ((ViewGroup)localObject2);
        localObject2 = zzv.zzcJ().zzp(zzGt.getView());
        zzLx = new ImageView(zzLg);
        zzLx.setImageBitmap((Bitmap)localObject2);
        zzum = zzGt.zzbD();
        zzLC.addView(zzLx);
        zzLB = new RelativeLayout(zzLg);
        zzLB.setBackgroundColor(0);
        zzLB.setLayoutParams(new ViewGroup.LayoutParams(i, j));
        zzLA = zzv.zzcJ().zza(zzLB, i, j, false);
        zzLA.setOutsideTouchable(true);
        zzLA.setTouchable(true);
        localObject2 = zzLA;
        if (zzLs) {
          break label1083;
        }
      }
    }
    label1024:
    label1038:
    label1040:
    label1083:
    for (boolean bool = true;; bool = false)
    {
      ((PopupWindow)localObject2).setClippingEnabled(bool);
      zzLB.addView(zzGt.getView(), -1, -1);
      zzLy = new LinearLayout(zzLg);
      localObject2 = new RelativeLayout.LayoutParams(zzeh.zzeO().zzb(zzLg, 50), zzeh.zzeO().zzb(zzLg, 50));
      String str = zzLr;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        for (;;)
        {
          zzLy.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              zzs(true);
            }
          });
          zzLy.setContentDescription("Close button");
          zzLB.addView(zzLy, (ViewGroup.LayoutParams)localObject2);
          try
          {
            zzLA.showAtLocation(paramMap.getDecorView(), 0, zzeh.zzeO().zzb(zzLg, arrayOfInt[0]), zzeh.zzeO().zzb(zzLg, arrayOfInt[1]));
            zzb(arrayOfInt[0], arrayOfInt[1]);
            zzGt.zza(new zzec(zzLg, new AdSize(zzrG, zzrH)));
            zzc(arrayOfInt[0], arrayOfInt[1]);
            zzaA("resized");
            return;
          }
          catch (RuntimeException paramMap)
          {
            paramMap = String.valueOf(paramMap.getMessage());
            if (paramMap.length() == 0) {
              break label1024;
            }
            for (paramMap = "Cannot show popup window: ".concat(paramMap);; paramMap = new String("Cannot show popup window: "))
            {
              zzay(paramMap);
              zzLB.removeView(zzGt.getView());
              if (zzLC != null)
              {
                zzLC.removeView(zzLx);
                zzLC.addView(zzGt.getView());
                zzGt.zza(zzum);
              }
              return;
            }
            i = -1;
            switch (i)
            {
            }
          }
          zzLA.dismiss();
          break;
          zzay("Webview is detached, probably in the middle of a resize or expand.");
          return;
          if (!str.equals("top-left")) {
            break label1038;
          }
          i = 0;
          break label1040;
          if (!str.equals("top-center")) {
            break label1038;
          }
          i = 1;
          break label1040;
          if (!str.equals("center")) {
            break label1038;
          }
          i = 2;
          break label1040;
          if (!str.equals("bottom-left")) {
            break label1038;
          }
          i = 3;
          break label1040;
          if (!str.equals("bottom-center")) {
            break label1038;
          }
          i = 4;
          break label1040;
          if (!str.equals("bottom-right")) {
            break label1038;
          }
          i = 5;
          break label1040;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        }
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      zzLt = paramInt1;
      zzLu = paramInt2;
      if ((zzLA != null) && (paramBoolean))
      {
        int[] arrayOfInt = zzgQ();
        if (arrayOfInt != null)
        {
          zzLA.update(zzeh.zzeO().zzb(zzLg, arrayOfInt[0]), zzeh.zzeO().zzb(zzLg, arrayOfInt[1]), zzLA.getWidth(), zzLA.getHeight());
          zzc(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      zzs(true);
    }
  }
  
  void zzb(int paramInt1, int paramInt2)
  {
    if (zzLz != null) {
      zzLz.zza(paramInt1, paramInt2, zzrG, zzrH);
    }
  }
  
  void zzc(int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt2 - zzv.zzcJ().zzk(zzLg)[0], zzrG, zzrH);
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    zzLt = paramInt1;
    zzLu = paramInt2;
  }
  
  boolean zzgP()
  {
    return (zzrG > -1) && (zzrH > -1);
  }
  
  public boolean zzgR()
  {
    for (;;)
    {
      synchronized (zzrN)
      {
        if (zzLA != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean zzgS()
  {
    Object localObject = zzv.zzcJ().zzi(zzLg);
    int[] arrayOfInt = zzv.zzcJ().zzk(zzLg);
    int k = localObject[0];
    int i = localObject[1];
    if ((zzrG < 50) || (zzrG > k))
    {
      zzpe.zzbe("Width is too small or too large.");
      return false;
    }
    if ((zzrH < 50) || (zzrH > i))
    {
      zzpe.zzbe("Height is too small or too large.");
      return false;
    }
    if ((zzrH == i) && (zzrG == k))
    {
      zzpe.zzbe("Cannot resize to a full-screen ad.");
      return false;
    }
    label188:
    int j;
    if (zzLs)
    {
      localObject = zzLr;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          j = zzLt + zzLv + zzrG - 50;
          i = zzLu + zzLw;
        }
        break;
      }
    }
    while ((j >= 0) && (j + 50 <= k) && (i >= arrayOfInt[0]) && (i + 50 <= arrayOfInt[1]))
    {
      return true;
      if (!((String)localObject).equals("top-left")) {
        break label188;
      }
      i = 0;
      break label188;
      if (!((String)localObject).equals("top-center")) {
        break label188;
      }
      i = 1;
      break label188;
      if (!((String)localObject).equals("center")) {
        break label188;
      }
      i = 2;
      break label188;
      if (!((String)localObject).equals("bottom-left")) {
        break label188;
      }
      i = 3;
      break label188;
      if (!((String)localObject).equals("bottom-center")) {
        break label188;
      }
      i = 4;
      break label188;
      if (!((String)localObject).equals("bottom-right")) {
        break label188;
      }
      i = 5;
      break label188;
      i = zzLt;
      j = zzLv + i;
      i = zzLu + zzLw;
      continue;
      j = zzLt + zzLv + zzrG / 2 - 25;
      i = zzLu + zzLw;
      continue;
      j = zzLt + zzLv + zzrG / 2 - 25;
      i = zzLu + zzLw + zzrH / 2 - 25;
      continue;
      i = zzLt;
      j = zzLv + i;
      i = zzLu + zzLw + zzrH - 50;
      continue;
      j = zzLt + zzLv + zzrG / 2 - 25;
      i = zzLu + zzLw + zzrH - 50;
      continue;
      j = zzLt + zzLv + zzrG - 50;
      i = zzLu + zzLw + zzrH - 50;
    }
  }
  
  public void zzs(boolean paramBoolean)
  {
    synchronized (zzrN)
    {
      if (zzLA != null)
      {
        zzLA.dismiss();
        zzLB.removeView(zzGt.getView());
        if (zzLC != null)
        {
          zzLC.removeView(zzLx);
          zzLC.addView(zzGt.getView());
          zzGt.zza(zzum);
        }
        if (paramBoolean)
        {
          zzaA("default");
          if (zzLz != null) {
            zzLz.zzbZ();
          }
        }
        zzLA = null;
        zzLB = null;
        zzLC = null;
        zzLy = null;
      }
      return;
    }
  }
}

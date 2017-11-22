package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzqp;
import java.util.HashMap;

@zzmb
public class zzl
  extends FrameLayout
  implements zzi
{
  private final zzqp zzGt;
  private String zzHV;
  private final FrameLayout zzNl;
  private final zzgf zzNm;
  private final zzaa zzNn;
  private final long zzNo;
  @Nullable
  private zzj zzNp;
  private boolean zzNq;
  private boolean zzNr;
  private boolean zzNs;
  private boolean zzNt;
  private long zzNu;
  private long zzNv;
  private Bitmap zzNw;
  private ImageView zzNx;
  private boolean zzNy;
  
  public zzl(Context paramContext, zzqp paramZzqp, int paramInt, boolean paramBoolean, zzgf paramZzgf)
  {
    super(paramContext);
    zzGt = paramZzqp;
    zzNm = paramZzgf;
    zzNl = new FrameLayout(paramContext);
    addView(zzNl, new FrameLayout.LayoutParams(-1, -1));
    zzc.zzt(paramZzqp.zzbz());
    zzNp = zzbzzzsN.zza(paramContext, paramZzqp, paramInt, paramBoolean, paramZzgf);
    if (zzNp != null)
    {
      zzNl.addView(zzNp, new FrameLayout.LayoutParams(-1, -1, 17));
      if (((Boolean)zzfx.zzBr.get()).booleanValue()) {
        zzhG();
      }
    }
    zzNx = new ImageView(paramContext);
    zzNo = ((Long)zzfx.zzBv.get()).longValue();
    zzNt = ((Boolean)zzfx.zzBt.get()).booleanValue();
    if (zzNm != null)
    {
      paramZzqp = zzNm;
      if (!zzNt) {
        break label248;
      }
    }
    label248:
    for (paramContext = "1";; paramContext = "0")
    {
      paramZzqp.zzg("spinner_used", paramContext);
      zzNn = new zzaa(this);
      zzNn.zzid();
      if (zzNp != null) {
        zzNp.zza(this);
      }
      if (zzNp == null) {
        zzk("AdVideoUnderlay Error", "Allocating player failed.");
      }
      return;
    }
  }
  
  private void zza(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int j = paramVarArgs.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString == null) {}
      for (paramString = str;; paramString = null)
      {
        i += 1;
        break;
        localHashMap.put(paramString, str);
      }
    }
    zzGt.zza("onVideoEvent", localHashMap);
  }
  
  private void zzg(int paramInt1, int paramInt2)
  {
    if (!zzNt) {}
    do
    {
      return;
      paramInt1 = Math.max(paramInt1 / ((Integer)zzfx.zzBu.get()).intValue(), 1);
      paramInt2 = Math.max(paramInt2 / ((Integer)zzfx.zzBu.get()).intValue(), 1);
    } while ((zzNw != null) && (zzNw.getWidth() == paramInt1) && (zzNw.getHeight() == paramInt2));
    zzNw = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    zzNy = false;
  }
  
  @TargetApi(14)
  private void zzhI()
  {
    if (zzNw == null) {}
    long l;
    do
    {
      do
      {
        return;
        l = zzv.zzcP().elapsedRealtime();
        if (zzNp.getBitmap(zzNw) != null) {
          zzNy = true;
        }
        l = zzv.zzcP().elapsedRealtime() - l;
        if (zzpe.zzkh()) {
          zzpe.v(46 + "Spinner frame grab took " + l + "ms");
        }
      } while (l <= zzNo);
      zzpe.zzbe("Spinner frame grab crossed jank threshold! Suspending spinner.");
      zzNt = false;
      zzNw = null;
    } while (zzNm == null);
    zzNm.zzg("spinner_jank", Long.toString(l));
  }
  
  private void zzhJ()
  {
    if ((zzNy) && (zzNw != null) && (!zzhL()))
    {
      zzNx.setImageBitmap(zzNw);
      zzNx.invalidate();
      zzNl.addView(zzNx, new FrameLayout.LayoutParams(-1, -1));
      zzNl.bringChildToFront(zzNx);
    }
  }
  
  private void zzhK()
  {
    if (zzhL()) {
      zzNl.removeView(zzNx);
    }
  }
  
  private boolean zzhL()
  {
    return zzNx.getParent() != null;
  }
  
  private void zzhM()
  {
    if (zzGt.zzkR() == null) {
      break label12;
    }
    label12:
    while (zzNr) {
      return;
    }
    if ((zzGt.zzkR().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzNs = bool;
      if (zzNs) {
        break;
      }
      zzGt.zzkR().getWindow().addFlags(128);
      zzNr = true;
      return;
    }
  }
  
  private void zzhN()
  {
    if (zzGt.zzkR() == null) {}
    while ((!zzNr) || (zzNs)) {
      return;
    }
    zzGt.zzkR().getWindow().clearFlags(128);
    zzNr = false;
  }
  
  public static void zzi(zzqp paramZzqp)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramZzqp.zza("onVideoEvent", localHashMap);
  }
  
  public void destroy()
  {
    zzNn.cancel();
    if (zzNp != null) {
      zzNp.stop();
    }
    zzhN();
  }
  
  public void onPaused()
  {
    zza("pause", new String[0]);
    zzhN();
    zzNq = false;
  }
  
  public void pause()
  {
    if (zzNp == null) {
      return;
    }
    zzNp.pause();
  }
  
  public void play()
  {
    if (zzNp == null) {
      return;
    }
    zzNp.play();
  }
  
  public void seekTo(int paramInt)
  {
    if (zzNp == null) {
      return;
    }
    zzNp.seekTo(paramInt);
  }
  
  public void zza(float paramFloat1, float paramFloat2)
  {
    if (zzNp != null) {
      zzNp.zza(paramFloat1, paramFloat2);
    }
  }
  
  public void zzaB(String paramString)
  {
    zzHV = paramString;
  }
  
  public void zzb(float paramFloat)
  {
    if (zzNp == null) {
      return;
    }
    zzNp.zzb(paramFloat);
  }
  
  public void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    zzNl.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public void zzf(int paramInt1, int paramInt2)
  {
    zzg(paramInt1, paramInt2);
  }
  
  @TargetApi(14)
  public void zzf(MotionEvent paramMotionEvent)
  {
    if (zzNp == null) {
      return;
    }
    zzNp.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void zzgq()
  {
    if (zzNp == null) {
      return;
    }
    if (!TextUtils.isEmpty(zzHV))
    {
      zzNp.setVideoPath(zzHV);
      return;
    }
    zza("no_src", new String[0]);
  }
  
  public void zzhA()
  {
    zzhM();
    zzNq = true;
  }
  
  public void zzhB()
  {
    zza("ended", new String[0]);
    zzhN();
  }
  
  public void zzhC()
  {
    zzhJ();
    zzNv = zzNu;
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        zzl.zza(zzl.this, "surfaceDestroyed", new String[0]);
      }
    });
  }
  
  public void zzhD()
  {
    if (zzNq) {
      zzhK();
    }
    zzhI();
  }
  
  public void zzhE()
  {
    if (zzNp == null) {
      return;
    }
    zzNp.zzhE();
  }
  
  public void zzhF()
  {
    if (zzNp == null) {
      return;
    }
    zzNp.zzhF();
  }
  
  @TargetApi(14)
  public void zzhG()
  {
    if (zzNp == null) {
      return;
    }
    TextView localTextView = new TextView(zzNp.getContext());
    String str = String.valueOf(zzNp.zzhd());
    if (str.length() != 0) {}
    for (str = "AdMob - ".concat(str);; str = new String("AdMob - "))
    {
      localTextView.setText(str);
      localTextView.setTextColor(-65536);
      localTextView.setBackgroundColor(65280);
      zzNl.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
      zzNl.bringChildToFront(localTextView);
      return;
    }
  }
  
  void zzhH()
  {
    if (zzNp == null) {}
    long l;
    do
    {
      return;
      l = zzNp.getCurrentPosition();
    } while ((zzNu == l) || (l <= 0L));
    zza("timeupdate", new String[] { "time", String.valueOf((float)l / 1000.0F) });
    zzNu = l;
  }
  
  public void zzhy()
  {
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        zzl.zza(zzl.this, "surfaceCreated", new String[0]);
      }
    });
  }
  
  public void zzhz()
  {
    if (zzNp == null) {}
    while (zzNv != 0L) {
      return;
    }
    zza("canplaythrough", new String[] { "duration", String.valueOf(zzNp.getDuration() / 1000.0F), "videoWidth", String.valueOf(zzNp.getVideoWidth()), "videoHeight", String.valueOf(zzNp.getVideoHeight()) });
  }
  
  public void zzk(String paramString1, @Nullable String paramString2)
  {
    zza("error", new String[] { "what", paramString1, "extra", paramString2 });
  }
}

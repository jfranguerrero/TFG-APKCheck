package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzkr.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqq.zza;
import com.google.android.gms.internal.zzqr;
import java.util.Collections;
import java.util.Map;

@zzmb
public class zze
  extends zzkr.zza
  implements zzv
{
  static final int zzMx = Color.argb(0, 0, 0, 0);
  private final Activity mActivity;
  zzqp zzGt;
  zzp zzMA;
  boolean zzMB = false;
  FrameLayout zzMC;
  WebChromeClient.CustomViewCallback zzMD;
  boolean zzME = false;
  boolean zzMF = false;
  zzb zzMG;
  boolean zzMH = false;
  int zzMI = 0;
  zzm zzMJ;
  private final Object zzMK = new Object();
  private Runnable zzML;
  private boolean zzMM;
  private boolean zzMN;
  private boolean zzMO = false;
  private boolean zzMP = false;
  private boolean zzMQ = true;
  AdOverlayInfoParcel zzMy;
  zzc zzMz;
  
  public zze(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzMJ = new zzt();
  }
  
  public void close()
  {
    zzMI = 2;
    mActivity.finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    zzMI = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    mActivity.requestWindowFeature(1);
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    zzME = bool;
    try
    {
      zzMy = AdOverlayInfoParcel.zzb(mActivity.getIntent());
      if (zzMy != null) {
        break label80;
      }
      throw new zza("Could not get info for ad overlay.");
    }
    catch (zza paramBundle)
    {
      zzpe.zzbe(paramBundle.getMessage());
      zzMI = 3;
      mActivity.finish();
    }
    return;
    label80:
    if (zzMy.zzvf.zzYc > 7500000) {
      zzMI = 3;
    }
    if (mActivity.getIntent() != null) {
      zzMQ = mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    }
    if (zzMy.zzNi != null)
    {
      zzMF = zzMy.zzNi.zztH;
      label151:
      if ((((Boolean)zzfx.zzDJ.get()).booleanValue()) && (zzMF) && (zzMy.zzNi.zztM != -1)) {
        new zzd(null).zziw();
      }
      if (paramBundle == null)
      {
        if ((zzMy.zzMY != null) && (zzMQ)) {
          zzMy.zzMY.zzbO();
        }
        if ((zzMy.zzNf != 1) && (zzMy.zzMX != null)) {
          zzMy.zzMX.onAdClicked();
        }
      }
      zzMG = new zzb(mActivity, zzMy.zzNh);
      zzMG.setId(1000);
      switch (zzMy.zzNf)
      {
      }
    }
    for (;;)
    {
      throw new zza("Could not determine ad overlay type.");
      zzMF = false;
      break label151;
      zzA(false);
      return;
      zzMz = new zzc(zzMy.zzMZ);
      zzA(false);
      return;
      zzA(true);
      return;
      if (zzME)
      {
        zzMI = 3;
        mActivity.finish();
        return;
      }
      if (com.google.android.gms.ads.internal.zzv.zzcG().zza(mActivity, zzMy.zzMW, zzMy.zzNe)) {
        break;
      }
      zzMI = 3;
      mActivity.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (zzGt != null) {
      zzMG.removeView(zzGt.getView());
    }
    zzhm();
  }
  
  public void onPause()
  {
    zzhi();
    if (zzMy.zzMY != null) {
      zzMy.zzMY.onPause();
    }
    if ((!((Boolean)zzfx.zzEZ.get()).booleanValue()) && (zzGt != null) && ((!mActivity.isFinishing()) || (zzMz == null))) {
      com.google.android.gms.ads.internal.zzv.zzcL().zzl(zzGt);
    }
    zzhm();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((zzMy != null) && (zzMy.zzNf == 4))
    {
      if (!zzME) {
        break label105;
      }
      zzMI = 3;
      mActivity.finish();
    }
    for (;;)
    {
      if (zzMy.zzMY != null) {
        zzMy.zzMY.onResume();
      }
      if (!((Boolean)zzfx.zzEZ.get()).booleanValue())
      {
        if ((zzGt == null) || (zzGt.isDestroyed())) {
          break;
        }
        com.google.android.gms.ads.internal.zzv.zzcL().zzm(zzGt);
      }
      return;
      label105:
      zzME = true;
    }
    zzpe.zzbe("The webview does not exist. Ignoring action.");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", zzME);
  }
  
  public void onStart()
  {
    if (((Boolean)zzfx.zzEZ.get()).booleanValue())
    {
      if ((zzGt != null) && (!zzGt.isDestroyed())) {
        com.google.android.gms.ads.internal.zzv.zzcL().zzm(zzGt);
      }
    }
    else {
      return;
    }
    zzpe.zzbe("The webview does not exist. Ignoring action.");
  }
  
  public void onStop()
  {
    if ((((Boolean)zzfx.zzEZ.get()).booleanValue()) && (zzGt != null) && ((!mActivity.isFinishing()) || (zzMz == null))) {
      com.google.android.gms.ads.internal.zzv.zzcL().zzl(zzGt);
    }
    zzhm();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    mActivity.setRequestedOrientation(paramInt);
  }
  
  protected void zzA(boolean paramBoolean)
    throws zze.zza
  {
    if (!zzMN) {
      mActivity.requestWindowFeature(1);
    }
    Object localObject = mActivity.getWindow();
    if (localObject == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((zzs.isAtLeastN()) && (((Boolean)zzfx.zzEY.get()).booleanValue())) {}
    for (boolean bool1 = com.google.android.gms.ads.internal.zzv.zzcJ().zza(mActivity, mActivity.getResources().getConfiguration());; bool1 = true)
    {
      int i;
      label159:
      boolean bool2;
      if ((zzMy.zzNi != null) && (zzMy.zzNi.zztI))
      {
        i = 1;
        if (((!zzMF) || (i != 0)) && (bool1)) {
          ((Window)localObject).setFlags(1024, 1024);
        }
        zzqq localZzqq = zzMy.zzMZ.zzkV();
        if (localZzqq == null) {
          break label659;
        }
        bool1 = localZzqq.zzdz();
        zzMH = false;
        if (bool1)
        {
          if (zzMy.orientation != com.google.android.gms.ads.internal.zzv.zzcL().zzkp()) {
            break label670;
          }
          if (mActivity.getResources().getConfiguration().orientation != 1) {
            break label664;
          }
          bool2 = true;
          label204:
          zzMH = bool2;
        }
        label210:
        bool2 = zzMH;
        zzpe.zzbc(46 + "Delay onShow to next orientation change: " + bool2);
        setRequestedOrientation(zzMy.orientation);
        if (com.google.android.gms.ads.internal.zzv.zzcL().zza((Window)localObject)) {
          zzpe.zzbc("Hardware acceleration on the AdActivity window enabled.");
        }
        if (zzMF) {
          break label721;
        }
        zzMG.setBackgroundColor(-16777216);
        label287:
        mActivity.setContentView(zzMG);
        zzbp();
        if (!paramBoolean) {
          break label788;
        }
        zzGt = com.google.android.gms.ads.internal.zzv.zzcK().zza(mActivity, zzMy.zzMZ.zzbD(), true, bool1, null, zzMy.zzvf, null, null, zzMy.zzMZ.zzbz());
        zzGt.zzkV().zza(null, null, zzMy.zzNa, zzMy.zzNe, true, zzMy.zzNg, null, zzMy.zzMZ.zzkV().zzln(), null, null);
        zzGt.zzkV().zza(new zzqq.zza()
        {
          public void zza(zzqp paramAnonymousZzqp, boolean paramAnonymousBoolean)
          {
            paramAnonymousZzqp.zzhp();
          }
        });
        if (zzMy.url == null) {
          break label734;
        }
        zzGt.loadUrl(zzMy.url);
        label456:
        if (zzMy.zzMZ != null) {
          zzMy.zzMZ.zzc(this);
        }
        label479:
        zzGt.zzb(this);
        localObject = zzGt.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeView(zzGt.getView());
        }
        if (zzMF) {
          zzGt.zzlm();
        }
        zzMG.addView(zzGt.getView(), -1, -1);
        if ((!paramBoolean) && (!zzMH)) {
          zzhp();
        }
        zzz(bool1);
        if (zzGt.zzkW()) {
          zza(bool1, true);
        }
        localObject = zzGt.zzbz();
        if (localObject == null) {
          break label815;
        }
      }
      label659:
      label664:
      label670:
      label721:
      label734:
      label788:
      label815:
      for (localObject = zzsO;; localObject = null)
      {
        if (localObject == null) {
          break label821;
        }
        zzMJ = ((zzn)localObject).zza(mActivity, zzGt, zzMG);
        return;
        i = 0;
        break;
        bool1 = false;
        break label159;
        bool2 = false;
        break label204;
        if (zzMy.orientation != com.google.android.gms.ads.internal.zzv.zzcL().zzkq()) {
          break label210;
        }
        if (mActivity.getResources().getConfiguration().orientation == 2) {}
        for (bool2 = true;; bool2 = false)
        {
          zzMH = bool2;
          break;
        }
        zzMG.setBackgroundColor(zzMx);
        break label287;
        if (zzMy.zzNd != null)
        {
          zzGt.loadDataWithBaseURL(zzMy.zzNb, zzMy.zzNd, "text/html", "UTF-8", null);
          break label456;
        }
        throw new zza("No URL or HTML to display in ad overlay.");
        zzGt = zzMy.zzMZ;
        zzGt.setContext(mActivity);
        break label479;
      }
      label821:
      zzpe.zzbe("Appstreaming controller is null.");
      return;
    }
  }
  
  protected void zzK(int paramInt)
  {
    zzGt.zzK(paramInt);
  }
  
  public void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zzMC = new FrameLayout(mActivity);
    zzMC.setBackgroundColor(-16777216);
    zzMC.addView(paramView, -1, -1);
    mActivity.setContentView(zzMC);
    zzbp();
    zzMD = paramCustomViewCallback;
    zzMB = true;
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (zzMA != null) {
      zzMA.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  public void zzbp()
  {
    zzMN = true;
  }
  
  public void zzg(zzqp paramZzqp, Map<String, String> paramMap) {}
  
  public void zzhi()
  {
    if ((zzMy != null) && (zzMB)) {
      setRequestedOrientation(zzMy.orientation);
    }
    if (zzMC != null)
    {
      mActivity.setContentView(zzMG);
      zzbp();
      zzMC.removeAllViews();
      zzMC = null;
    }
    if (zzMD != null)
    {
      zzMD.onCustomViewHidden();
      zzMD = null;
    }
    zzMB = false;
  }
  
  public void zzhj()
  {
    zzMI = 1;
    mActivity.finish();
  }
  
  public boolean zzhk()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    zzMI = 0;
    if (zzGt == null) {
      return bool2;
    }
    if (zzGt.zzlb()) {}
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      zzGt.zza("onbackblocked", Collections.emptyMap());
      return bool1;
      bool1 = false;
    }
  }
  
  public void zzhl()
  {
    zzMG.removeView(zzMA);
    zzz(true);
  }
  
  protected void zzhm()
  {
    if ((!mActivity.isFinishing()) || (zzMO)) {
      return;
    }
    zzMO = true;
    if (zzGt != null)
    {
      zzK(zzMI);
      synchronized (zzMK)
      {
        if ((!zzMM) && (zzGt.zzlh()))
        {
          zzML = new Runnable()
          {
            public void run()
            {
              zzhn();
            }
          };
          zzpi.zzWR.postDelayed(zzML, ((Long)zzfx.zzCz.get()).longValue());
          return;
        }
      }
    }
    zzhn();
  }
  
  void zzhn()
  {
    if (zzMP) {
      return;
    }
    zzMP = true;
    if (zzGt != null)
    {
      zzMG.removeView(zzGt.getView());
      if (zzMz == null) {
        break label142;
      }
      zzGt.setContext(zzMz.zzqr);
      zzGt.zzJ(false);
      zzMz.parent.addView(zzGt.getView(), zzMz.index, zzMz.zzMT);
      zzMz = null;
    }
    for (;;)
    {
      zzGt = null;
      if ((zzMy == null) || (zzMy.zzMY == null)) {
        break;
      }
      zzMy.zzMY.zzbN();
      return;
      label142:
      if (mActivity.getApplicationContext() != null) {
        zzGt.setContext(mActivity.getApplicationContext());
      }
    }
  }
  
  public void zzho()
  {
    if (zzMH)
    {
      zzMH = false;
      zzhp();
    }
  }
  
  protected void zzhp()
  {
    zzGt.zzhp();
  }
  
  public void zzhq()
  {
    zzMG.disable();
  }
  
  public void zzhr()
  {
    synchronized (zzMK)
    {
      zzMM = true;
      if (zzML != null)
      {
        zzpi.zzWR.removeCallbacks(zzML);
        zzpi.zzWR.post(zzML);
      }
      return;
    }
  }
  
  public void zzn(com.google.android.gms.dynamic.zzd paramZzd)
  {
    if ((((Boolean)zzfx.zzEY.get()).booleanValue()) && (zzs.isAtLeastN()))
    {
      paramZzd = (Configuration)com.google.android.gms.dynamic.zze.zzE(paramZzd);
      if (com.google.android.gms.ads.internal.zzv.zzcJ().zza(mActivity, paramZzd))
      {
        mActivity.getWindow().addFlags(1024);
        mActivity.getWindow().clearFlags(2048);
      }
    }
    else
    {
      return;
    }
    mActivity.getWindow().addFlags(2048);
    mActivity.getWindow().clearFlags(1024);
  }
  
  public void zzz(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      zzMA = new zzp(mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      zzMA.zza(paramBoolean, zzMy.zzNc);
      zzMG.addView(zzMA, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  @zzmb
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzmb
  static class zzb
    extends RelativeLayout
  {
    boolean zzMS;
    zzpl zzvO;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
      zzvO = new zzpl(paramContext, paramString);
    }
    
    void disable()
    {
      zzMS = true;
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!zzMS) {
        zzvO.zzg(paramMotionEvent);
      }
      return false;
    }
  }
  
  @zzmb
  public static class zzc
  {
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzMT;
    public final Context zzqr;
    
    public zzc(zzqp paramZzqp)
      throws zze.zza
    {
      zzMT = paramZzqp.getLayoutParams();
      ViewParent localViewParent = paramZzqp.getParent();
      zzqr = paramZzqp.zzkS();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        parent = ((ViewGroup)localViewParent);
        index = parent.indexOfChild(paramZzqp.getView());
        parent.removeView(paramZzqp.getView());
        paramZzqp.zzJ(true);
        return;
      }
      throw new zze.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzmb
  private class zzd
    extends zzpd
  {
    private zzd() {}
    
    public void onStop() {}
    
    public void zzcm()
    {
      Object localObject = com.google.android.gms.ads.internal.zzv.zzde().zza(Integer.valueOf(zzMy.zzNi.zztM));
      if (localObject != null)
      {
        localObject = com.google.android.gms.ads.internal.zzv.zzcL().zza(zze.zza(zze.this), (Bitmap)localObject, zzMy.zzNi.zztK, zzMy.zzNi.zztL);
        zzpi.zzWR.post(new Runnable()
        {
          public void run()
          {
            zze.zza(zze.this).getWindow().setBackgroundDrawable(zzMU);
          }
        });
      }
    }
  }
}

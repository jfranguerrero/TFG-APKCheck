package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.internal.zzav;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzfn;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgw;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzov.zza;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@zzmb
public final class zzw
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public final Context zzqr;
  boolean zztH = false;
  @Nullable
  zznt zzvA;
  @Nullable
  List<String> zzvB;
  @Nullable
  zzk zzvC;
  @Nullable
  public zzpb zzvD = null;
  @Nullable
  View zzvE = null;
  public int zzvF = 0;
  boolean zzvG = false;
  private HashSet<zzow> zzvH = null;
  private int zzvI = -1;
  private int zzvJ = -1;
  private zzpt zzvK;
  private boolean zzvL = true;
  private boolean zzvM = true;
  private boolean zzvN = false;
  final String zzvc;
  public String zzvd;
  final zzav zzve;
  public final zzqa zzvf;
  @Nullable
  zza zzvg;
  @Nullable
  public zzpd zzvh;
  @Nullable
  public zzpk zzvi;
  public zzec zzvj;
  @Nullable
  public zzov zzvk;
  public zzov.zza zzvl;
  @Nullable
  public zzow zzvm;
  @Nullable
  zzek zzvn;
  @Nullable
  zzel zzvo;
  @Nullable
  zzer zzvp;
  @Nullable
  zzet zzvq;
  @Nullable
  zzkz zzvr;
  @Nullable
  zzld zzvs;
  @Nullable
  zzhj zzvt;
  @Nullable
  zzhk zzvu;
  SimpleArrayMap<String, zzhl> zzvv;
  SimpleArrayMap<String, zzhm> zzvw;
  zzgw zzvx;
  @Nullable
  zzfn zzvy;
  @Nullable
  zzgj zzvz;
  
  public zzw(Context paramContext, zzec paramZzec, String paramString, zzqa paramZzqa)
  {
    this(paramContext, paramZzec, paramString, paramZzqa, null);
  }
  
  zzw(Context paramContext, zzec paramZzec, String paramString, zzqa paramZzqa, zzav paramZzav)
  {
    zzfx.initialize(paramContext);
    if (zzv.zzcN().zzjN() != null)
    {
      List localList = zzfx.zzfo();
      if (zzYb != 0) {
        localList.add(Integer.toString(zzYb));
      }
      zzv.zzcN().zzjN().zzc(localList);
    }
    zzvc = UUID.randomUUID().toString();
    if ((zzzl) || (zzzn))
    {
      zzvg = null;
      zzvj = paramZzec;
      zzvd = paramString;
      zzqr = paramContext;
      zzvf = paramZzqa;
      if (paramZzav == null) {
        break label247;
      }
    }
    for (;;)
    {
      zzve = paramZzav;
      zzvK = new zzpt(200L);
      zzvw = new SimpleArrayMap();
      return;
      zzvg = new zza(paramContext, paramString, this, this);
      zzvg.setMinimumWidth(widthPixels);
      zzvg.setMinimumHeight(heightPixels);
      zzvg.setVisibility(4);
      break;
      label247:
      paramZzav = new zzav(new zzi(this));
    }
  }
  
  private void zzdp()
  {
    if (zzvg == null) {}
    Rect localRect1;
    Rect localRect2;
    do
    {
      View localView;
      do
      {
        return;
        localView = zzvg.getRootView().findViewById(16908290);
      } while (localView == null);
      localRect1 = new Rect();
      localRect2 = new Rect();
      zzvg.getGlobalVisibleRect(localRect1);
      localView.getGlobalVisibleRect(localRect2);
      if (top != top) {
        zzvL = false;
      }
    } while (bottom == bottom);
    zzvM = false;
  }
  
  private void zzh(boolean paramBoolean)
  {
    boolean bool = true;
    if ((zzvg == null) || (zzvk == null) || (zzvk.zzMZ == null) || (zzvk.zzMZ.zzkV() == null)) {}
    while ((paramBoolean) && (!zzvK.tryAcquire())) {
      return;
    }
    Object localObject;
    int i;
    int j;
    if (zzvk.zzMZ.zzkV().zzdz())
    {
      localObject = new int[2];
      zzvg.getLocationOnScreen((int[])localObject);
      i = zzeh.zzeO().zzc(zzqr, localObject[0]);
      j = zzeh.zzeO().zzc(zzqr, localObject[1]);
      if ((i != zzvI) || (j != zzvJ))
      {
        zzvI = i;
        zzvJ = j;
        localObject = zzvk.zzMZ.zzkV();
        i = zzvI;
        j = zzvJ;
        if (paramBoolean) {
          break label189;
        }
      }
    }
    label189:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((zzqq)localObject).zza(i, j, paramBoolean);
      zzdp();
      return;
    }
  }
  
  public void destroy()
  {
    zzdo();
    zzvo = null;
    zzvp = null;
    zzvs = null;
    zzvr = null;
    zzvz = null;
    zzvq = null;
    zzi(false);
    if (zzvg != null) {
      zzvg.removeAllViews();
    }
    zzdj();
    zzdl();
    zzvk = null;
  }
  
  public void onGlobalLayout()
  {
    zzh(false);
  }
  
  public void onScrollChanged()
  {
    zzh(true);
    zzvN = true;
  }
  
  public void zza(HashSet<zzow> paramHashSet)
  {
    zzvH = paramHashSet;
  }
  
  public HashSet<zzow> zzdi()
  {
    return zzvH;
  }
  
  public void zzdj()
  {
    if ((zzvk != null) && (zzvk.zzMZ != null)) {
      zzvk.zzMZ.destroy();
    }
  }
  
  public void zzdk()
  {
    if ((zzvk != null) && (zzvk.zzMZ != null)) {
      zzvk.zzMZ.stopLoading();
    }
  }
  
  public void zzdl()
  {
    if ((zzvk != null) && (zzvk.zzKB != null)) {}
    try
    {
      zzvk.zzKB.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzpe.zzbe("Could not destroy mediation adapter.");
    }
  }
  
  public boolean zzdm()
  {
    return zzvF == 0;
  }
  
  public boolean zzdn()
  {
    return zzvF == 1;
  }
  
  public void zzdo()
  {
    if (zzvg != null) {
      zzvg.zzdo();
    }
  }
  
  public String zzdq()
  {
    if ((zzvL) && (zzvM)) {
      return "";
    }
    if (zzvL)
    {
      if (zzvN) {
        return "top-scrollable";
      }
      return "top-locked";
    }
    if (zzvM)
    {
      if (zzvN) {
        return "bottom-scrollable";
      }
      return "bottom-locked";
    }
    return "";
  }
  
  public void zzdr()
  {
    if (zzvm == null) {
      return;
    }
    if (zzvk != null)
    {
      zzvm.zzm(zzvk.zzVv);
      zzvm.zzn(zzvk.zzVw);
      zzvm.zzD(zzvk.zzRK);
    }
    zzvm.zzC(zzvj.zzzl);
  }
  
  public void zzi(boolean paramBoolean)
  {
    if (zzvF == 0) {
      zzdk();
    }
    if (zzvh != null) {
      zzvh.cancel();
    }
    if (zzvi != null) {
      zzvi.cancel();
    }
    if (paramBoolean) {
      zzvk = null;
    }
  }
  
  public static class zza
    extends ViewSwitcher
  {
    private final zzpl zzvO;
    @Nullable
    private final zzpw zzvP;
    private boolean zzvQ;
    
    public zza(Context paramContext, String paramString, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
    {
      super();
      zzvO = new zzpl(paramContext);
      zzvO.setAdUnitId(paramString);
      zzvQ = true;
      if ((paramContext instanceof Activity)) {}
      for (zzvP = new zzpw((Activity)paramContext, this, paramOnGlobalLayoutListener, paramOnScrollChangedListener);; zzvP = new zzpw(null, this, paramOnGlobalLayoutListener, paramOnScrollChangedListener))
      {
        zzvP.zzkE();
        return;
      }
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (zzvP != null) {
        zzvP.onAttachedToWindow();
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (zzvP != null) {
        zzvP.onDetachedFromWindow();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (zzvQ) {
        zzvO.zzg(paramMotionEvent);
      }
      return false;
    }
    
    public void removeAllViews()
    {
      Object localObject = new ArrayList();
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView != null) && ((localView instanceof zzqp))) {
          ((List)localObject).add((zzqp)localView);
        }
        i += 1;
      }
      super.removeAllViews();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zzqp)((Iterator)localObject).next()).destroy();
      }
    }
    
    public void zzdo()
    {
      zzpe.v("Disable position monitoring on adFrame.");
      if (zzvP != null) {
        zzvP.zzkF();
      }
    }
    
    public zzpl zzds()
    {
      return zzvO;
    }
    
    public void zzdt()
    {
      zzpe.v("Enable debug gesture detector on adFrame.");
      zzvQ = true;
    }
    
    public void zzdu()
    {
      zzpe.v("Disable debug gesture detector on adFrame.");
      zzvQ = false;
    }
  }
}

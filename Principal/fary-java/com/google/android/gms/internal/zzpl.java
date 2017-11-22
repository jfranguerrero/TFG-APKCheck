package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzmb
public class zzpl
{
  private final Context mContext;
  private int mState = 0;
  private final float zzLP;
  private String zzWZ;
  private float zzXa;
  private float zzXb;
  private float zzXc;
  private String zztq;
  
  public zzpl(Context paramContext)
  {
    mContext = paramContext;
    zzLP = getResourcesgetDisplayMetricsdensity;
  }
  
  public zzpl(Context paramContext, String paramString)
  {
    this(paramContext);
    zzWZ = paramString;
  }
  
  private int zza(List<String> paramList, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return -1;
    }
    paramList.add(paramString);
    return paramList.size() - 1;
  }
  
  static String zzaZ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "No debug information";
    }
    Object localObject;
    do
    {
      return paramString;
      paramString = paramString.replaceAll("\\+", "%20");
      localObject = new Uri.Builder().encodedQuery(paramString).build();
      paramString = new StringBuilder();
      localObject = zzv.zzcJ().zzg((Uri)localObject);
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.append(str).append(" = ").append((String)((Map)localObject).get(str)).append("\n\n");
      }
      localObject = paramString.toString().trim();
      paramString = (String)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return "No debug information";
  }
  
  private void zzku()
  {
    if (!(mContext instanceof Activity))
    {
      zzpe.zzbd("Can not create dialog without Activity Context");
      return;
    }
    Object localObject = zzv.zzcN().getResources();
    String str1;
    String str2;
    label54:
    String str3;
    if (localObject != null)
    {
      str1 = ((Resources)localObject).getString(R.string.debug_menu_title);
      if (localObject == null) {
        break label204;
      }
      str2 = ((Resources)localObject).getString(R.string.debug_menu_ad_information);
      if (localObject == null) {
        break label212;
      }
      str3 = ((Resources)localObject).getString(R.string.debug_menu_creative_preview);
      label69:
      if (localObject == null) {
        break label220;
      }
    }
    label204:
    label212:
    label220:
    for (localObject = ((Resources)localObject).getString(R.string.debug_menu_troubleshooting);; localObject = "Troubleshooting")
    {
      ArrayList localArrayList = new ArrayList();
      final int i = zza(localArrayList, str2, true);
      final int j = zza(localArrayList, str3, ((Boolean)zzfx.zzEQ.get()).booleanValue());
      final int k = zza(localArrayList, (String)localObject, ((Boolean)zzfx.zzER.get()).booleanValue());
      new AlertDialog.Builder(mContext).setTitle(str1).setItems((CharSequence[])localArrayList.toArray(new String[0]), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (paramAnonymousInt == i) {
            zzpl.zza(zzpl.this);
          }
          do
          {
            return;
            if ((paramAnonymousInt == j) && (((Boolean)zzfx.zzEQ.get()).booleanValue()))
            {
              zzpl.zzb(zzpl.this);
              return;
            }
          } while ((paramAnonymousInt != k) || (!((Boolean)zzfx.zzER.get()).booleanValue()));
          zzpl.zzc(zzpl.this);
        }
      }).create().show();
      return;
      str1 = "Select a Debug Mode";
      break;
      str2 = "Ad Information";
      break label54;
      str3 = "Creative Preview";
      break label69;
    }
  }
  
  private void zzkv()
  {
    if (!(mContext instanceof Activity))
    {
      zzpe.zzbd("Can not create dialog without Activity Context");
      return;
    }
    final String str = zzaZ(zzWZ);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(mContext);
    localBuilder.setMessage(str);
    localBuilder.setTitle("Ad Information");
    localBuilder.setPositiveButton("Share", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzv.zzcJ().zzb(zzpl.zzd(zzpl.this), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
      }
    });
    localBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.create().show();
  }
  
  private void zzkw()
  {
    zzpe.zzbc("Debug mode [Creative Preview] selected.");
    zzph.zza(new Runnable()
    {
      public void run()
      {
        zzv.zzcR().zzj(zzpl.zzd(zzpl.this), zzpl.zze(zzpl.this));
      }
    });
  }
  
  private void zzkx()
  {
    zzpe.zzbc("Debug mode [Troubleshooting] selected.");
    zzph.zza(new Runnable()
    {
      public void run()
      {
        zzv.zzcR().zzk(zzpl.zzd(zzpl.this), zzpl.zze(zzpl.this));
      }
    });
  }
  
  public void setAdUnitId(String paramString)
  {
    zztq = paramString;
  }
  
  public void showDialog()
  {
    if ((((Boolean)zzfx.zzER.get()).booleanValue()) || (((Boolean)zzfx.zzEQ.get()).booleanValue()))
    {
      zzku();
      return;
    }
    zzkv();
  }
  
  void zza(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      mState = 0;
      zzXa = paramFloat1;
      zzXb = paramFloat2;
      zzXc = paramFloat2;
    }
    label24:
    label227:
    do
    {
      do
      {
        break label24;
        do
        {
          return;
        } while (mState == -1);
        if (paramInt != 2) {
          break;
        }
        if (paramFloat2 > zzXb) {
          zzXb = paramFloat2;
        }
        while (zzXb - zzXc > 30.0F * zzLP)
        {
          mState = -1;
          return;
          if (paramFloat2 < zzXc) {
            zzXc = paramFloat2;
          }
        }
        if ((mState == 0) || (mState == 2)) {
          if (paramFloat1 - zzXa >= 50.0F * zzLP) {
            zzXa = paramFloat1;
          }
        }
        for (mState += 1;; mState += 1)
        {
          do
          {
            if ((mState != 1) && (mState != 3)) {
              break label227;
            }
            if (paramFloat1 <= zzXa) {
              break;
            }
            zzXa = paramFloat1;
            return;
          } while (((mState != 1) && (mState != 3)) || (paramFloat1 - zzXa > -50.0F * zzLP));
          zzXa = paramFloat1;
        }
      } while ((mState != 2) || (paramFloat1 >= zzXa));
      zzXa = paramFloat1;
      return;
    } while ((paramInt != 1) || (mState != 4));
    showDialog();
  }
  
  public void zzaY(String paramString)
  {
    zzWZ = paramString;
  }
  
  public void zzg(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    int i = 0;
    while (i < j)
    {
      zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, i), paramMotionEvent.getHistoricalY(0, i));
      i += 1;
    }
    zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
}

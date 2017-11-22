package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzh;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private T zzaQd;
  private Bundle zzaQe;
  private LinkedList<zza> zzaQf;
  private final zzf<T> zzaQg = new zzf()
  {
    public void zza(T paramAnonymousT)
    {
      zza.zza(zza.this, paramAnonymousT);
      paramAnonymousT = zza.zza(zza.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((zza.zza)paramAnonymousT.next()).zzb(zza.zzb(zza.this));
      }
      zza.zza(zza.this).clear();
      zza.zza(zza.this, null);
    }
  };
  
  public zza() {}
  
  private void zza(Bundle paramBundle, zza paramZza)
  {
    if (zzaQd != null)
    {
      paramZza.zzb(zzaQd);
      return;
    }
    if (zzaQf == null) {
      zzaQf = new LinkedList();
    }
    zzaQf.add(paramZza);
    if (paramBundle != null)
    {
      if (zzaQe != null) {
        break label76;
      }
      zzaQe = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      zza(zzaQg);
      return;
      label76:
      zzaQe.putAll(paramBundle);
    }
  }
  
  @VisibleForTesting
  static void zza(final FrameLayout paramFrameLayout, GoogleApiAvailability paramGoogleApiAvailability)
  {
    Context localContext = paramFrameLayout.getContext();
    int i = paramGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    String str2 = zzh.zzi(localContext, i);
    String str1 = zzh.zzk(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = paramGoogleApiAvailability.zzb(localContext, i, null);
    if (paramFrameLayout != null)
    {
      paramGoogleApiAvailability = new Button(localContext);
      paramGoogleApiAvailability.setId(16908313);
      paramGoogleApiAvailability.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramGoogleApiAvailability.setText(str1);
      localLinearLayout.addView(paramGoogleApiAvailability);
      paramGoogleApiAvailability.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            startActivity(paramFrameLayout);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", paramAnonymousView);
          }
        }
      });
    }
  }
  
  public static void zzb(FrameLayout paramFrameLayout)
  {
    zza(paramFrameLayout, GoogleApiAvailability.getInstance());
  }
  
  private void zzgk(int paramInt)
  {
    while ((!zzaQf.isEmpty()) && (((zza)zzaQf.getLast()).getState() >= paramInt)) {
      zzaQf.removeLast();
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 1;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onCreate(paramBundle);
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 2;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(zza.zzb(zza.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
    });
    if (zzaQd == null) {
      zza(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (zzaQd != null)
    {
      zzaQd.onDestroy();
      return;
    }
    zzgk(1);
  }
  
  public void onDestroyView()
  {
    if (zzaQd != null)
    {
      zzaQd.onDestroyView();
      return;
    }
    zzgk(2);
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    zza(paramBundle2, new zza()
    {
      public int getState()
      {
        return 0;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
    });
  }
  
  public void onLowMemory()
  {
    if (zzaQd != null) {
      zzaQd.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (zzaQd != null)
    {
      zzaQd.onPause();
      return;
    }
    zzgk(5);
  }
  
  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (zzaQd != null) {
      zzaQd.onSaveInstanceState(paramBundle);
    }
    while (zzaQe == null) {
      return;
    }
    paramBundle.putAll(zzaQe);
  }
  
  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (zzaQd != null)
    {
      zzaQd.onStop();
      return;
    }
    zzgk(4);
  }
  
  public T zzAY()
  {
    return zzaQd;
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }
  
  protected abstract void zza(zzf<T> paramZzf);
  
  private static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}

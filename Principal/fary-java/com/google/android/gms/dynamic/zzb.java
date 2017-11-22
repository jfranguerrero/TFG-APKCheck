package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"NewApi"})
public final class zzb
  extends zzc.zza
{
  private Fragment zzaQn;
  
  private zzb(Fragment paramFragment)
  {
    zzaQn = paramFragment;
  }
  
  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzb(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return zzaQn.getArguments();
  }
  
  public int getId()
  {
    return zzaQn.getId();
  }
  
  public boolean getRetainInstance()
  {
    return zzaQn.getRetainInstance();
  }
  
  public String getTag()
  {
    return zzaQn.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return zzaQn.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return zzaQn.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzA(zzaQn.getView());
  }
  
  public boolean isAdded()
  {
    return zzaQn.isAdded();
  }
  
  public boolean isDetached()
  {
    return zzaQn.isDetached();
  }
  
  public boolean isHidden()
  {
    return zzaQn.isHidden();
  }
  
  public boolean isInLayout()
  {
    return zzaQn.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return zzaQn.isRemoving();
  }
  
  public boolean isResumed()
  {
    return zzaQn.isResumed();
  }
  
  public boolean isVisible()
  {
    return zzaQn.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    zzaQn.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    zzaQn.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    zzaQn.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    zzaQn.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    zzaQn.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    zzaQn.startActivityForResult(paramIntent, paramInt);
  }
  
  public zzd zzAZ()
  {
    return zze.zzA(zzaQn.getActivity());
  }
  
  public zzc zzBa()
  {
    return zza(zzaQn.getParentFragment());
  }
  
  public zzd zzBb()
  {
    return zze.zzA(zzaQn.getResources());
  }
  
  public zzc zzBc()
  {
    return zza(zzaQn.getTargetFragment());
  }
  
  public void zzC(zzd paramZzd)
  {
    paramZzd = (View)zze.zzE(paramZzd);
    zzaQn.registerForContextMenu(paramZzd);
  }
  
  public void zzD(zzd paramZzd)
  {
    paramZzd = (View)zze.zzE(paramZzd);
    zzaQn.unregisterForContextMenu(paramZzd);
  }
}

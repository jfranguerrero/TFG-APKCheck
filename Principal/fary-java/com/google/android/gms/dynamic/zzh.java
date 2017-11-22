package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzh
  extends zzc.zza
{
  private Fragment zzaQq;
  
  private zzh(Fragment paramFragment)
  {
    zzaQq = paramFragment;
  }
  
  public static zzh zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzh(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return zzaQq.getArguments();
  }
  
  public int getId()
  {
    return zzaQq.getId();
  }
  
  public boolean getRetainInstance()
  {
    return zzaQq.getRetainInstance();
  }
  
  public String getTag()
  {
    return zzaQq.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return zzaQq.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return zzaQq.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzA(zzaQq.getView());
  }
  
  public boolean isAdded()
  {
    return zzaQq.isAdded();
  }
  
  public boolean isDetached()
  {
    return zzaQq.isDetached();
  }
  
  public boolean isHidden()
  {
    return zzaQq.isHidden();
  }
  
  public boolean isInLayout()
  {
    return zzaQq.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return zzaQq.isRemoving();
  }
  
  public boolean isResumed()
  {
    return zzaQq.isResumed();
  }
  
  public boolean isVisible()
  {
    return zzaQq.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    zzaQq.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    zzaQq.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    zzaQq.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    zzaQq.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    zzaQq.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    zzaQq.startActivityForResult(paramIntent, paramInt);
  }
  
  public zzd zzAZ()
  {
    return zze.zzA(zzaQq.getActivity());
  }
  
  public zzc zzBa()
  {
    return zza(zzaQq.getParentFragment());
  }
  
  public zzd zzBb()
  {
    return zze.zzA(zzaQq.getResources());
  }
  
  public zzc zzBc()
  {
    return zza(zzaQq.getTargetFragment());
  }
  
  public void zzC(zzd paramZzd)
  {
    paramZzd = (View)zze.zzE(paramZzd);
    zzaQq.registerForContextMenu(paramZzd);
  }
  
  public void zzD(zzd paramZzd)
  {
    paramZzd = (View)zze.zzE(paramZzd);
    zzaQq.unregisterForContextMenu(paramZzd);
  }
}

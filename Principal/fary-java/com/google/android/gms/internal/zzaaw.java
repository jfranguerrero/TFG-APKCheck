package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzaaw
{
  protected final zzaax zzaBs;
  
  protected zzaaw(zzaax paramZzaax)
  {
    zzaBs = paramZzaax;
  }
  
  protected static zzaax zzc(zzaav paramZzaav)
  {
    if (paramZzaav.zzwl()) {
      return zzabm.zza(paramZzaav.zzwn());
    }
    return zzaay.zzt(paramZzaav.zzwm());
  }
  
  public static zzaax zzs(Activity paramActivity)
  {
    return zzc(new zzaav(paramActivity));
  }
  
  @MainThread
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public Activity getActivity()
  {
    return zzaBs.zzwo();
  }
  
  @MainThread
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @MainThread
  public void onCreate(Bundle paramBundle) {}
  
  @MainThread
  public void onDestroy() {}
  
  @MainThread
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  @MainThread
  public void onStart() {}
  
  @MainThread
  public void onStop() {}
}

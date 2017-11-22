package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

abstract interface zzf<TResult>
{
  public abstract void cancel();
  
  public abstract void onComplete(@NonNull Task<TResult> paramTask);
}

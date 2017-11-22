package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class zze<T>
  extends zzd.zza
{
  private final T mWrappedObject;
  
  private zze(T paramT)
  {
    mWrappedObject = paramT;
  }
  
  public static <T> zzd zzA(T paramT)
  {
    return new zze(paramT);
  }
  
  public static <T> T zzE(zzd paramZzd)
  {
    int j = 0;
    if ((paramZzd instanceof zze)) {
      return mWrappedObject;
    }
    IBinder localIBinder = paramZzd.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    paramZzd = null;
    int k = arrayOfField.length;
    int i = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      if (localField.isSynthetic()) {
        break label169;
      }
      j += 1;
      paramZzd = localField;
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      if (j == 1)
      {
        if (!paramZzd.isAccessible())
        {
          paramZzd.setAccessible(true);
          try
          {
            paramZzd = paramZzd.get(localIBinder);
            return paramZzd;
          }
          catch (NullPointerException paramZzd)
          {
            throw new IllegalArgumentException("Binder object is null.", paramZzd);
          }
          catch (IllegalAccessException paramZzd)
          {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramZzd);
          }
        }
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
      }
      i = arrayOfField.length;
      throw new IllegalArgumentException(64 + "Unexpected number of IObjectWrapper declared fields: " + i);
    }
  }
}

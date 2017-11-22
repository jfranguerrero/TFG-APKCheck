package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;

@zzmb
public class zzdl
  extends zza
{
  public static final Parcelable.Creator<zzdl> CREATOR = new zzdm();
  public final int version;
  @Nullable
  private ParcelFileDescriptor zzyw;
  
  public zzdl()
  {
    this(1, null);
  }
  
  zzdl(int paramInt, @Nullable ParcelFileDescriptor paramParcelFileDescriptor)
  {
    version = paramInt;
    zzyw = paramParcelFileDescriptor;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzdm.zza(this, paramParcel, paramInt);
  }
  
  /* Error */
  public boolean zzer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/google/android/gms/internal/zzdl:zzyw	Landroid/os/ParcelFileDescriptor;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	zzdl
    //   12	7	1	bool	boolean
    //   6	2	2	localParcelFileDescriptor	ParcelFileDescriptor
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  /* Error */
  @Nullable
  public java.io.InputStream zzes()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 31	com/google/android/gms/internal/zzdl:zzyw	Landroid/os/ParcelFileDescriptor;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: new 44	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   20: dup
    //   21: aload_0
    //   22: getfield 31	com/google/android/gms/internal/zzdl:zzyw	Landroid/os/ParcelFileDescriptor;
    //   25: invokespecial 47	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   28: astore_1
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 31	com/google/android/gms/internal/zzdl:zzyw	Landroid/os/ParcelFileDescriptor;
    //   34: goto -21 -> 13
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzdl
    //   1	28	1	localObject1	Object
    //   37	4	1	localObject2	Object
    //   8	2	2	localParcelFileDescriptor	ParcelFileDescriptor
    // Exception table:
    //   from	to	target	type
    //   4	9	37	finally
    //   17	34	37	finally
  }
  
  ParcelFileDescriptor zzet()
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = zzyw;
      return localParcelFileDescriptor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

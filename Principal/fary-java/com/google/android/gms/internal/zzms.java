package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.zzo;
import java.io.IOException;
import java.io.OutputStream;

@zzmb
public final class zzms
  extends zza
{
  public static final Parcelable.Creator<zzms> CREATOR = new zzmt();
  final int mVersionCode;
  ParcelFileDescriptor zzSn;
  private Parcelable zzSo;
  private boolean zzSp;
  
  zzms(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    mVersionCode = paramInt;
    zzSn = paramParcelFileDescriptor;
    zzSo = null;
    zzSp = true;
  }
  
  public zzms(SafeParcelable paramSafeParcelable)
  {
    mVersionCode = 1;
    zzSn = null;
    zzSo = paramSafeParcelable;
    zzSp = false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Parcel localParcel;
    if (zzSn == null) {
      localParcel = Parcel.obtain();
    }
    try
    {
      zzSo.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      zzSn = zzj(arrayOfByte);
      zzmt.zza(this, paramParcel, paramInt);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public <T extends SafeParcelable> T zza(Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/gms/internal/zzms:zzSp	Z
    //   4: ifeq +95 -> 99
    //   7: aload_0
    //   8: getfield 34	com/google/android/gms/internal/zzms:zzSn	Landroid/os/ParcelFileDescriptor;
    //   11: ifnonnull +10 -> 21
    //   14: ldc 71
    //   16: invokestatic 77	com/google/android/gms/internal/zzpe:e	(Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 79	java/io/DataInputStream
    //   24: dup
    //   25: new 81	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 34	com/google/android/gms/internal/zzms:zzSn	Landroid/os/ParcelFileDescriptor;
    //   33: invokespecial 84	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   36: invokespecial 87	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 91	java/io/DataInputStream:readInt	()I
    //   44: newarray byte
    //   46: astore_3
    //   47: aload_2
    //   48: aload_3
    //   49: iconst_0
    //   50: aload_3
    //   51: arraylength
    //   52: invokevirtual 95	java/io/DataInputStream:readFully	([BII)V
    //   55: aload_2
    //   56: invokestatic 101	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   59: invokestatic 47	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   62: astore_2
    //   63: aload_2
    //   64: aload_3
    //   65: iconst_0
    //   66: aload_3
    //   67: arraylength
    //   68: invokevirtual 104	android/os/Parcel:unmarshall	([BII)V
    //   71: aload_2
    //   72: iconst_0
    //   73: invokevirtual 108	android/os/Parcel:setDataPosition	(I)V
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: invokeinterface 114 2 0
    //   84: checkcast 116	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   87: putfield 36	com/google/android/gms/internal/zzms:zzSo	Landroid/os/Parcelable;
    //   90: aload_2
    //   91: invokevirtual 58	android/os/Parcel:recycle	()V
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 38	com/google/android/gms/internal/zzms:zzSp	Z
    //   99: aload_0
    //   100: getfield 36	com/google/android/gms/internal/zzms:zzSo	Landroid/os/Parcelable;
    //   103: checkcast 116	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   106: areturn
    //   107: astore_1
    //   108: new 118	java/lang/IllegalStateException
    //   111: dup
    //   112: ldc 120
    //   114: aload_1
    //   115: invokespecial 123	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: athrow
    //   119: astore_1
    //   120: aload_2
    //   121: invokestatic 101	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_2
    //   128: invokevirtual 58	android/os/Parcel:recycle	()V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	zzms
    //   0	133	1	paramCreator	Parcelable.Creator<T>
    //   39	89	2	localObject	Object
    //   46	21	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   40	55	107	java/io/IOException
    //   40	55	119	finally
    //   108	119	119	finally
    //   63	90	126	finally
  }
  
  protected <T> ParcelFileDescriptor zzj(final byte[] paramArrayOfByte)
  {
    try
    {
      ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
      localAutoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(arrayOfParcelFileDescriptor[1]);
      zzpe.zzb("Error transporting the ad response", paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      try
      {
        new Thread(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: new 30	java/io/DataOutputStream
            //   3: dup
            //   4: aload_0
            //   5: getfield 19	com/google/android/gms/internal/zzms$1:zzSq	Ljava/io/OutputStream;
            //   8: invokespecial 33	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   11: astore_2
            //   12: aload_2
            //   13: astore_1
            //   14: aload_2
            //   15: aload_0
            //   16: getfield 21	com/google/android/gms/internal/zzms$1:zzSr	[B
            //   19: arraylength
            //   20: invokevirtual 37	java/io/DataOutputStream:writeInt	(I)V
            //   23: aload_2
            //   24: astore_1
            //   25: aload_2
            //   26: aload_0
            //   27: getfield 21	com/google/android/gms/internal/zzms$1:zzSr	[B
            //   30: invokevirtual 41	java/io/DataOutputStream:write	([B)V
            //   33: aload_2
            //   34: invokestatic 47	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
            //   37: return
            //   38: astore_3
            //   39: aconst_null
            //   40: astore_2
            //   41: aload_2
            //   42: astore_1
            //   43: ldc 49
            //   45: aload_3
            //   46: invokestatic 54	com/google/android/gms/internal/zzpe:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
            //   49: aload_2
            //   50: astore_1
            //   51: invokestatic 60	com/google/android/gms/ads/internal/zzv:zzcN	()Lcom/google/android/gms/internal/zzoy;
            //   54: aload_3
            //   55: ldc 62
            //   57: invokevirtual 68	com/google/android/gms/internal/zzoy:zza	(Ljava/lang/Throwable;Ljava/lang/String;)V
            //   60: aload_2
            //   61: ifnonnull +11 -> 72
            //   64: aload_0
            //   65: getfield 19	com/google/android/gms/internal/zzms$1:zzSq	Ljava/io/OutputStream;
            //   68: invokestatic 47	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
            //   71: return
            //   72: aload_2
            //   73: invokestatic 47	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
            //   76: return
            //   77: astore_2
            //   78: aconst_null
            //   79: astore_1
            //   80: aload_1
            //   81: ifnonnull +12 -> 93
            //   84: aload_0
            //   85: getfield 19	com/google/android/gms/internal/zzms$1:zzSq	Ljava/io/OutputStream;
            //   88: invokestatic 47	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
            //   91: aload_2
            //   92: athrow
            //   93: aload_1
            //   94: invokestatic 47	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
            //   97: goto -6 -> 91
            //   100: astore_2
            //   101: goto -21 -> 80
            //   104: astore_3
            //   105: goto -64 -> 41
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	108	0	this	1
            //   13	81	1	localDataOutputStream1	java.io.DataOutputStream
            //   11	62	2	localDataOutputStream2	java.io.DataOutputStream
            //   77	15	2	localObject1	Object
            //   100	1	2	localObject2	Object
            //   38	17	3	localIOException1	IOException
            //   104	1	3	localIOException2	IOException
            // Exception table:
            //   from	to	target	type
            //   0	12	38	java/io/IOException
            //   0	12	77	finally
            //   14	23	100	finally
            //   25	33	100	finally
            //   43	49	100	finally
            //   51	60	100	finally
            //   14	23	104	java/io/IOException
            //   25	33	104	java/io/IOException
          }
        }).start();
        paramArrayOfByte = arrayOfParcelFileDescriptor[0];
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        final ParcelFileDescriptor.AutoCloseOutputStream localAutoCloseOutputStream;
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      localAutoCloseOutputStream = null;
    }
    zzv.zzcN().zza(paramArrayOfByte, "LargeParcelTeleporter.pipeData.2");
    zzo.zzb(localAutoCloseOutputStream);
    return null;
  }
}

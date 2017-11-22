package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzzn
  extends IInterface
{
  public abstract void zza(zzzm paramZzzm)
    throws RemoteException;
  
  public abstract void zza(zzzm paramZzzm, zzzh paramZzzh)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzzn
  {
    public static zzzn zzbo(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
      if ((localIInterface != null) && ((localIInterface instanceof zzzn))) {
        return (zzzn)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        paramParcel2 = zzzm.zza.zzbn(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (zzzh)zzzh.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(paramParcel2, paramParcel1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
      zza(zzzm.zza.zzbn(paramParcel1.readStrongBinder()));
      return true;
    }
    
    private static class zza
      implements zzzn
    {
      private IBinder zzrp;
      
      zza(IBinder paramIBinder)
      {
        zzrp = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return zzrp;
      }
      
      public void zza(zzzm paramZzzm)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
          if (paramZzzm != null) {
            localIBinder = paramZzzm.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          zzrp.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      /* Error */
      public void zza(zzzm paramZzzm, zzzh paramZzzh)
        throws RemoteException
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: aload 4
        //   9: ldc 32
        //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +10 -> 25
        //   18: aload_1
        //   19: invokeinterface 40 1 0
        //   24: astore_3
        //   25: aload 4
        //   27: aload_3
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +37 -> 69
        //   35: aload 4
        //   37: iconst_1
        //   38: invokevirtual 58	android/os/Parcel:writeInt	(I)V
        //   41: aload_2
        //   42: aload 4
        //   44: iconst_0
        //   45: invokevirtual 64	com/google/android/gms/internal/zzzh:writeToParcel	(Landroid/os/Parcel;I)V
        //   48: aload_0
        //   49: getfield 18	com/google/android/gms/internal/zzzn$zza$zza:zzrp	Landroid/os/IBinder;
        //   52: iconst_1
        //   53: aload 4
        //   55: aconst_null
        //   56: iconst_1
        //   57: invokeinterface 49 5 0
        //   62: pop
        //   63: aload 4
        //   65: invokevirtual 52	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aload 4
        //   71: iconst_0
        //   72: invokevirtual 58	android/os/Parcel:writeInt	(I)V
        //   75: goto -27 -> 48
        //   78: astore_1
        //   79: aload 4
        //   81: invokevirtual 52	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	zza
        //   0	86	1	paramZzzm	zzzm
        //   0	86	2	paramZzzh	zzzh
        //   1	27	3	localIBinder	IBinder
        //   5	75	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   7	14	78	finally
        //   18	25	78	finally
        //   25	31	78	finally
        //   35	48	78	finally
        //   48	63	78	finally
        //   69	75	78	finally
      }
    }
  }
}

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzdr
  extends IInterface
{
  public abstract zzdl zza(zzdo paramZzdo)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzdr
  {
    public static zzdr zzi(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
      if ((localIInterface != null) && ((localIInterface instanceof zzdr))) {
        return (zzdr)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.cache.ICacheService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.cache.ICacheService");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (zzdo)zzdo.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label104;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        label104:
        paramParcel2.writeInt(0);
      }
    }
    
    private static class zza
      implements zzdr
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
      
      public zzdl zza(zzdo paramZzdo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.cache.ICacheService");
            if (paramZzdo != null)
            {
              localParcel1.writeInt(1);
              paramZzdo.writeToParcel(localParcel1, 0);
              zzrp.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramZzdo = (zzdl)zzdl.CREATOR.createFromParcel(localParcel2);
                return paramZzdo;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramZzdo = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
    }
  }
}

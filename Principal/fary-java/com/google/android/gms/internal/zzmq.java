package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzmq
  extends IInterface
{
  public abstract void zza(zzmh paramZzmh, zzmr paramZzmr)
    throws RemoteException;
  
  public abstract zzmk zzd(zzmh paramZzmh)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzmq
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }
    
    public static zzmq zzae(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if ((localIInterface != null) && ((localIInterface instanceof zzmq))) {
        return (zzmq)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (zzmh)zzmh.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = zzd((zzmh)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzmh)zzmh.CREATOR.createFromParcel(paramParcel1);
      }
      zza((zzmh)localObject1, zzmr.zza.zzaf(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzmq
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
      
      public void zza(zzmh paramZzmh, zzmr paramZzmr)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramZzmh != null)
            {
              localParcel1.writeInt(1);
              paramZzmh.writeToParcel(localParcel1, 0);
              if (paramZzmr != null)
              {
                paramZzmh = paramZzmr.asBinder();
                localParcel1.writeStrongBinder(paramZzmh);
                zzrp.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramZzmh = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public zzmk zzd(zzmh paramZzmh)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramZzmh != null)
            {
              localParcel1.writeInt(1);
              paramZzmh.writeToParcel(localParcel1, 0);
              zzrp.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramZzmh = (zzmk)zzmk.CREATOR.createFromParcel(localParcel2);
                return paramZzmh;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramZzmh = null;
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

package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzv
  extends IInterface
{
  public abstract void zza(zzu paramZzu, zzan paramZzan)
    throws RemoteException;
  
  public abstract void zza(zzu paramZzu, zzj paramZzj)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzv
  {
    public static zzv zzbu(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((localIInterface != null) && ((localIInterface instanceof zzv))) {
        return (zzv)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      zzu localZzu1 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel1.createStringArray();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel1.createStringArray();
        paramParcel1.readString();
        paramParcel1.readStrongBinder();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel1.createStringArray();
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.createStringArray();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel1.createStringArray();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel1.createStringArray();
        paramParcel2.writeNoException();
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        zzu.zza.zzbt(paramParcel1.readStrongBinder());
        paramParcel1.readInt();
        paramParcel1.readString();
        paramParcel2.writeNoException();
        return true;
      case 46: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        localZzu1 = zzu.zza.zzbt(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject = (zzj)zzj.CREATOR.createFromParcel(paramParcel1);
        }
        zza(localZzu1, (zzj)localObject);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      zzu localZzu2 = zzu.zza.zzbt(paramParcel1.readStrongBinder());
      localObject = localZzu1;
      if (paramParcel1.readInt() != 0) {
        localObject = (zzan)zzan.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localZzu2, (zzan)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzv
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
      
      /* Error */
      public void zza(zzu paramZzu, zzan paramZzan)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +61 -> 77
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +50 -> 82
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 53	com/google/android/gms/common/internal/zzan:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/common/internal/zzv$zza$zza:zzrp	Landroid/os/IBinder;
        //   50: bipush 47
        //   52: aload_3
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -53 -> 26
        //   82: aload_3
        //   83: iconst_0
        //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   87: goto -41 -> 46
        //   90: astore_1
        //   91: aload 4
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	zza
        //   0	102	1	paramZzu	zzu
        //   0	102	2	paramZzan	zzan
        //   3	94	3	localParcel1	Parcel
        //   7	85	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	90	finally
        //   19	26	90	finally
        //   26	31	90	finally
        //   35	46	90	finally
        //   46	67	90	finally
        //   82	87	90	finally
      }
      
      /* Error */
      public void zza(zzu paramZzu, zzj paramZzj)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 32
        //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +61 -> 77
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +50 -> 82
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 70	com/google/android/gms/common/internal/zzj:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/common/internal/zzv$zza$zza:zzrp	Landroid/os/IBinder;
        //   50: bipush 46
        //   52: aload_3
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -53 -> 26
        //   82: aload_3
        //   83: iconst_0
        //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   87: goto -41 -> 46
        //   90: astore_1
        //   91: aload 4
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	zza
        //   0	102	1	paramZzu	zzu
        //   0	102	2	paramZzj	zzj
        //   3	94	3	localParcel1	Parcel
        //   7	85	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	90	finally
        //   19	26	90	finally
        //   26	31	90	finally
        //   35	46	90	finally
        //   46	67	90	finally
        //   82	87	90	finally
      }
    }
  }
}

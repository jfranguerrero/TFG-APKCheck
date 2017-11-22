package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  private static final String[] zzaCo = { "data" };
  private final Parcelable.Creator<T> zzaCp;
  
  public zzd(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    zzaCp = paramCreator;
  }
  
  public static <T extends SafeParcelable> void zza(DataHolder.zza paramZza, T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = new ContentValues();
    paramT.put("data", localParcel.marshall());
    paramZza.zza(paramT);
    localParcel.recycle();
  }
  
  public static DataHolder.zza zzwC()
  {
    return DataHolder.zzc(zzaCo);
  }
  
  public T zzcB(int paramInt)
  {
    Object localObject = zzazI.zzg("data", paramInt, zzazI.zzcC(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)zzaCp.createFromParcel(localParcel);
    localParcel.recycle();
    return localObject;
  }
}

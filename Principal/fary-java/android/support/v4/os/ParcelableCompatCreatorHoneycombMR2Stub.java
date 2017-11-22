package android.support.v4.os;

import android.annotation.TargetApi;
import android.os.Parcelable.Creator;
import android.support.annotation.RequiresApi;

@TargetApi(13)
@RequiresApi(13)
class ParcelableCompatCreatorHoneycombMR2Stub
{
  ParcelableCompatCreatorHoneycombMR2Stub() {}
  
  static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    return new ParcelableCompatCreatorHoneycombMR2(paramParcelableCompatCreatorCallbacks);
  }
}

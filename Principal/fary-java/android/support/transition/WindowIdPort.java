package android.support.transition;

import android.annotation.TargetApi;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;

@TargetApi(14)
@RequiresApi(14)
class WindowIdPort
{
  private final IBinder mToken;
  
  private WindowIdPort(IBinder paramIBinder)
  {
    mToken = paramIBinder;
  }
  
  static WindowIdPort getWindowId(@NonNull View paramView)
  {
    return new WindowIdPort(paramView.getWindowToken());
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WindowIdPort)) && (mToken.equals(mToken));
  }
}

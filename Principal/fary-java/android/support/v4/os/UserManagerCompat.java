package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat
{
  private UserManagerCompat() {}
  
  public static boolean isUserUnlocked(Context paramContext)
  {
    if (BuildCompat.isAtLeastN()) {
      return UserManagerCompatApi24.isUserUnlocked(paramContext);
    }
    return true;
  }
}

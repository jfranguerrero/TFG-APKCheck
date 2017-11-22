package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzmb
public class zzpz
  implements zzpx.zza
{
  @Nullable
  private final String zzHY;
  
  public zzpz()
  {
    this(null);
  }
  
  public zzpz(@Nullable String paramString)
  {
    zzHY = paramString;
  }
  
  @WorkerThread
  public void zzu(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = String.valueOf(paramString);
        if (((String)localObject1).length() != 0)
        {
          localObject1 = "Pinging URL: ".concat((String)localObject1);
          zzpy.zzbc((String)localObject1);
          localObject1 = (HttpURLConnection)new URL(paramString).openConnection();
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object localObject1;
        int i;
        str1 = String.valueOf(localIndexOutOfBoundsException.getMessage());
        zzpy.zzbe(String.valueOf(paramString).length() + 32 + String.valueOf(str1).length() + "Error while parsing ping URL: " + paramString + ". " + str1);
        return;
      }
      catch (IOException localIOException)
      {
        String str1;
        String str2 = String.valueOf(localIOException.getMessage());
        zzpy.zzbe(String.valueOf(paramString).length() + 27 + String.valueOf(str2).length() + "Error while pinging URL: " + paramString + ". " + str2);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        String str3 = String.valueOf(localRuntimeException.getMessage());
        zzpy.zzbe(String.valueOf(paramString).length() + 27 + String.valueOf(str3).length() + "Error while pinging URL: " + paramString + ". " + str3);
      }
      try
      {
        zzeh.zzeO().zza(true, (HttpURLConnection)localObject1, zzHY);
        i = ((HttpURLConnection)localObject1).getResponseCode();
        if ((i < 200) || (i >= 300)) {
          zzpy.zzbe(String.valueOf(paramString).length() + 65 + "Received non-success response code " + i + " from pinging URL: " + paramString);
        }
        ((HttpURLConnection)localObject1).disconnect();
        return;
      }
      finally
      {
        str1.disconnect();
      }
      localObject1 = new String("Pinging URL: ");
    }
  }
}

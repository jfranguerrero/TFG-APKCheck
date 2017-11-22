package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzmb
public abstract class zzil
  implements Releasable
{
  protected Context mContext;
  protected String zzHY;
  protected WeakReference<zzqp> zzHZ;
  
  public zzil(zzqp paramZzqp)
  {
    mContext = paramZzqp.getContext();
    zzHY = zzv.zzcJ().zzh(mContext, zzkYzzaZ);
    zzHZ = new WeakReference(paramZzqp);
  }
  
  private void zza(String paramString, Map<String, String> paramMap)
  {
    zzqp localZzqp = (zzqp)zzHZ.get();
    if (localZzqp != null) {
      localZzqp.zza(paramString, paramMap);
    }
  }
  
  private String zzaf(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "internal";
        if (paramString.equals("error"))
        {
          i = 0;
          continue;
          if (paramString.equals("playerFailed"))
          {
            i = 1;
            continue;
            if (paramString.equals("inProgress"))
            {
              i = 2;
              continue;
              if (paramString.equals("contentLengthMissing"))
              {
                i = 3;
                continue;
                if (paramString.equals("noCacheDir"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("expireFailed"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("badUrl"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("downloadTimeout"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("sizeExceeded"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("externalAbort")) {
                            i = 9;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return "internal";
    return "io";
    return "network";
    return "policy";
  }
  
  public abstract void abort();
  
  public void release() {}
  
  protected void zza(final String paramString1, final String paramString2, final int paramInt)
  {
    zzpx.zzXU.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheComplete");
        localHashMap.put("src", paramString1);
        localHashMap.put("cachedSrc", paramString2);
        localHashMap.put("totalBytes", Integer.toString(paramInt));
        zzil.zza(zzil.this, "onPrecacheEvent", localHashMap);
      }
    });
  }
  
  protected void zza(final String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    zzpx.zzXU.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheProgress");
        localHashMap.put("src", paramString1);
        localHashMap.put("cachedSrc", paramString2);
        localHashMap.put("bytesLoaded", Integer.toString(paramInt1));
        localHashMap.put("totalBytes", Integer.toString(paramInt2));
        if (paramBoolean) {}
        for (String str = "1";; str = "0")
        {
          localHashMap.put("cacheReady", str);
          zzil.zza(zzil.this, "onPrecacheEvent", localHashMap);
          return;
        }
      }
    });
  }
  
  public void zza(final String paramString1, final String paramString2, final String paramString3, @Nullable final String paramString4)
  {
    zzpx.zzXU.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheCanceled");
        localHashMap.put("src", paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          localHashMap.put("cachedSrc", paramString2);
        }
        localHashMap.put("type", zzil.zza(zzil.this, paramString3));
        localHashMap.put("reason", paramString3);
        if (!TextUtils.isEmpty(paramString4)) {
          localHashMap.put("message", paramString4);
        }
        zzil.zza(zzil.this, "onPrecacheEvent", localHashMap);
      }
    });
  }
  
  public abstract boolean zzad(String paramString);
  
  protected String zzae(String paramString)
  {
    return zzeh.zzeO().zzbb(paramString);
  }
}

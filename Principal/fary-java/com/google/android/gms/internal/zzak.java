package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public abstract class zzak<K, V>
{
  private static final String TAG = zzak.class.getSimpleName();
  
  public zzak() {}
  
  protected static <K, V> HashMap<K, V> zzl(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (HashMap)new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0))).readObject();
        return paramString;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      Log.d(TAG, "decode object failure");
      return null;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeObject(zzQ());
      localObjectOutputStream.close();
      localObject = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      return localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  protected abstract HashMap<K, V> zzQ();
  
  protected abstract void zzk(String paramString);
}

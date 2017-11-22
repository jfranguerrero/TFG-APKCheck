package com.google.android.gms.common.util;

import android.database.CharArrayBuffer;
import android.text.TextUtils;

public final class zzg
{
  public static void zzb(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if (TextUtils.isEmpty(paramString)) {
      sizeCopied = 0;
    }
    for (;;)
    {
      sizeCopied = paramString.length();
      return;
      if ((data == null) || (data.length < paramString.length())) {
        data = paramString.toCharArray();
      } else {
        paramString.getChars(0, paramString.length(), data, 0);
      }
    }
  }
}

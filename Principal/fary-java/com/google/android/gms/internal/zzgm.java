package com.google.android.gms.internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import java.util.List;

@zzmb
public class zzgm
{
  private static final int zzFE = Color.rgb(12, 174, 206);
  private static final int zzFF = Color.rgb(204, 204, 204);
  static final int zzFG = zzFF;
  static final int zzFH = zzFE;
  private final int mBackgroundColor;
  private final int mTextColor;
  private final String zzFI;
  private final List<Drawable> zzFJ;
  private final int zzFK;
  private final int zzFL;
  private final int zzFM;
  
  public zzgm(String paramString, List<Drawable> paramList, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2)
  {
    zzFI = paramString;
    zzFJ = paramList;
    if (paramInteger1 != null)
    {
      i = paramInteger1.intValue();
      mBackgroundColor = i;
      if (paramInteger2 == null) {
        break label87;
      }
      i = paramInteger2.intValue();
      label42:
      mTextColor = i;
      if (paramInteger3 == null) {
        break label95;
      }
    }
    label87:
    label95:
    for (int i = paramInteger3.intValue();; i = 12)
    {
      zzFK = i;
      zzFL = paramInt1;
      zzFM = paramInt2;
      return;
      i = zzFG;
      break;
      i = zzFH;
      break label42;
    }
  }
  
  public int getBackgroundColor()
  {
    return mBackgroundColor;
  }
  
  public String getText()
  {
    return zzFI;
  }
  
  public int getTextColor()
  {
    return mTextColor;
  }
  
  public int getTextSize()
  {
    return zzFK;
  }
  
  public List<Drawable> zzfG()
  {
    return zzFJ;
  }
  
  public int zzfH()
  {
    return zzFL;
  }
  
  public int zzfI()
  {
    return zzFM;
  }
}

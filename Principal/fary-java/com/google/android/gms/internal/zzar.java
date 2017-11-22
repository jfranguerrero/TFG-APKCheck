package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzar
  implements zzaq
{
  protected MotionEvent zzpI;
  protected LinkedList<MotionEvent> zzpJ = new LinkedList();
  protected long zzpK = 0L;
  protected long zzpL = 0L;
  protected long zzpM = 0L;
  protected long zzpN = 0L;
  protected long zzpO = 0L;
  protected long zzpP = 0L;
  protected long zzpQ = 0L;
  private boolean zzpR = false;
  protected boolean zzpS = false;
  protected DisplayMetrics zzpT;
  
  protected zzar(Context paramContext)
  {
    try
    {
      zzan.zzR();
      zzpT = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private String zza(Context paramContext, String paramString, boolean paramBoolean, View paramView, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 8
    //   8: astore 7
    //   10: aload 5
    //   12: ifnull +20 -> 32
    //   15: aload 8
    //   17: astore 7
    //   19: aload 5
    //   21: arraylength
    //   22: ifle +10 -> 32
    //   25: aload 5
    //   27: invokestatic 88	com/google/android/gms/internal/zzad$zza:zzc	([B)Lcom/google/android/gms/internal/zzad$zza;
    //   30: astore 7
    //   32: iload_3
    //   33: ifeq +32 -> 65
    //   36: aload_0
    //   37: aload_1
    //   38: aload 4
    //   40: invokevirtual 91	com/google/android/gms/internal/zzar:zza	(Landroid/content/Context;Landroid/view/View;)Lcom/google/android/gms/internal/zzaf$zza;
    //   43: astore_1
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 52	com/google/android/gms/internal/zzar:zzpR	Z
    //   49: aload_1
    //   50: ifnull +10 -> 60
    //   53: aload_1
    //   54: invokevirtual 97	com/google/android/gms/internal/zzaf$zza:zzacZ	()I
    //   57: ifne +19 -> 76
    //   60: iconst_5
    //   61: invokestatic 103	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   64: areturn
    //   65: aload_0
    //   66: aload_1
    //   67: aload 7
    //   69: invokevirtual 106	com/google/android/gms/internal/zzar:zza	(Landroid/content/Context;Lcom/google/android/gms/internal/zzad$zza;)Lcom/google/android/gms/internal/zzaf$zza;
    //   72: astore_1
    //   73: goto -24 -> 49
    //   76: iload_3
    //   77: invokestatic 110	com/google/android/gms/internal/zzar:zzb	(Z)Z
    //   80: ifne +15 -> 95
    //   83: iload 6
    //   85: istore_3
    //   86: aload_1
    //   87: aload_2
    //   88: iload_3
    //   89: invokestatic 113	com/google/android/gms/internal/zzan:zza	(Lcom/google/android/gms/internal/zzaf$zza;Ljava/lang/String;Z)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: iconst_0
    //   96: istore_3
    //   97: goto -11 -> 86
    //   100: astore_1
    //   101: bipush 7
    //   103: invokestatic 103	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   106: areturn
    //   107: astore_1
    //   108: bipush 7
    //   110: invokestatic 103	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   113: areturn
    //   114: astore_1
    //   115: iconst_3
    //   116: invokestatic 103	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   119: areturn
    //   120: astore 5
    //   122: aload 8
    //   124: astore 7
    //   126: goto -94 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	zzar
    //   0	129	1	paramContext	Context
    //   0	129	2	paramString	String
    //   0	129	3	paramBoolean	boolean
    //   0	129	4	paramView	View
    //   0	129	5	paramArrayOfByte	byte[]
    //   1	83	6	bool	boolean
    //   8	117	7	localObject1	Object
    //   4	119	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	49	100	java/security/NoSuchAlgorithmException
    //   53	60	100	java/security/NoSuchAlgorithmException
    //   60	65	100	java/security/NoSuchAlgorithmException
    //   65	73	100	java/security/NoSuchAlgorithmException
    //   76	83	100	java/security/NoSuchAlgorithmException
    //   86	93	100	java/security/NoSuchAlgorithmException
    //   36	49	107	java/io/UnsupportedEncodingException
    //   53	60	107	java/io/UnsupportedEncodingException
    //   60	65	107	java/io/UnsupportedEncodingException
    //   65	73	107	java/io/UnsupportedEncodingException
    //   76	83	107	java/io/UnsupportedEncodingException
    //   86	93	107	java/io/UnsupportedEncodingException
    //   36	49	114	java/lang/Throwable
    //   53	60	114	java/lang/Throwable
    //   60	65	114	java/lang/Throwable
    //   65	73	114	java/lang/Throwable
    //   76	83	114	java/lang/Throwable
    //   86	93	114	java/lang/Throwable
    //   25	32	120	com/google/android/gms/internal/zzbus
  }
  
  private static boolean zza(zzbd paramZzbd)
  {
    return (paramZzbd != null) && (zzce != null) && (zzqQ != null);
  }
  
  private boolean zzb(zzbd paramZzbd)
  {
    return (zzpT != null) && (paramZzbd != null) && (zzcc != null) && (zzqR != null);
  }
  
  private static boolean zzb(boolean paramBoolean)
  {
    if (!((Boolean)zzfx.zzDi.get()).booleanValue()) {
      return true;
    }
    return (((Boolean)zzfx.zzDD.get()).booleanValue()) && (paramBoolean);
  }
  
  protected abstract long zza(StackTraceElement[] paramArrayOfStackTraceElement)
    throws zzaz;
  
  protected abstract zzaf.zza zza(Context paramContext, View paramView);
  
  protected abstract zzaf.zza zza(Context paramContext, zzad.zza paramZza);
  
  public String zza(Context paramContext, String paramString, View paramView)
  {
    return zza(paramContext, paramString, true, paramView, null);
  }
  
  public String zza(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((zzbe.zzbd()) && (((Boolean)zzfx.zzDC.get()).booleanValue())) {
      throw new IllegalStateException("The caller must not be called from the UI thread.");
    }
    return zza(paramContext, null, false, null, paramArrayOfByte);
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if (zzpI != null) {
      zzpI.recycle();
    }
    if (zzpT != null) {}
    for (zzpI = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * zzpT.density, paramInt2 * zzpT.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);; zzpI = null)
    {
      zzpS = false;
      return;
    }
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    if (zzpR)
    {
      zzpN = 0L;
      zzpM = 0L;
      zzpL = 0L;
      zzpK = 0L;
      zzpO = 0L;
      zzpQ = 0L;
      zzpP = 0L;
      Iterator localIterator = zzpJ.iterator();
      while (localIterator.hasNext()) {
        ((MotionEvent)localIterator.next()).recycle();
      }
      zzpJ.clear();
      zzpI = null;
      zzpR = false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      zzpS = true;
      return;
      zzpI = MotionEvent.obtain(paramMotionEvent);
      zzpJ.add(zzpI);
      if (zzpJ.size() > 6) {
        ((MotionEvent)zzpJ.remove()).recycle();
      }
      zzpM += 1L;
      try
      {
        zzpO = zza(new Throwable().getStackTrace());
      }
      catch (zzaz paramMotionEvent) {}
      continue;
      zzpK += 1L;
      continue;
      zzpN += 1L;
      continue;
      zzpL += paramMotionEvent.getHistorySize() + 1;
      if ((((Boolean)zzfx.zzDq.get()).booleanValue()) || (((Boolean)zzfx.zzDl.get()).booleanValue())) {
        try
        {
          paramMotionEvent = zzb(paramMotionEvent);
          if (zza(paramMotionEvent)) {
            zzpP += zzce.longValue() + zzqQ.longValue();
          }
          if (zzb(paramMotionEvent))
          {
            long l1 = zzpQ;
            long l2 = zzcc.longValue();
            zzpQ = (zzqR.longValue() + l2 + l1);
          }
        }
        catch (zzaz paramMotionEvent) {}
      }
    }
  }
  
  protected abstract zzbd zzb(MotionEvent paramMotionEvent)
    throws zzaz;
  
  public String zzb(Context paramContext)
  {
    if ((zzbe.zzbd()) && (((Boolean)zzfx.zzDC.get()).booleanValue())) {
      throw new IllegalStateException("The caller must not be called from the UI thread.");
    }
    return zza(paramContext, null, false, null, null);
  }
  
  public String zzb(Context paramContext, String paramString)
  {
    return zza(paramContext, paramString, null);
  }
}

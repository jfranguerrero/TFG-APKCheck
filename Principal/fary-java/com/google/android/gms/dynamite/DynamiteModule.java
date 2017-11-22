package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zze;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class DynamiteModule
{
  public static final zzb zzaQA = new zzb()
  {
    public DynamiteModule.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, DynamiteModule.zzb.zza paramAnonymousZza)
      throws DynamiteModule.zza
    {
      DynamiteModule.zzb.zzb localZzb = new DynamiteModule.zzb.zzb();
      zzaQD = paramAnonymousZza.zzA(paramAnonymousContext, paramAnonymousString);
      if (zzaQD != 0) {}
      for (zzaQE = paramAnonymousZza.zzb(paramAnonymousContext, paramAnonymousString, false); (zzaQD == 0) && (zzaQE == 0); zzaQE = paramAnonymousZza.zzb(paramAnonymousContext, paramAnonymousString, true))
      {
        zzaQF = 0;
        return localZzb;
      }
      if (zzaQE >= zzaQD)
      {
        zzaQF = 1;
        return localZzb;
      }
      zzaQF = -1;
      return localZzb;
    }
  };
  private static zza zzaQr;
  private static final HashMap<String, byte[]> zzaQs = new HashMap();
  private static String zzaQt;
  private static final DynamiteModule.zzb.zza zzaQu = new DynamiteModule.zzb.zza()
  {
    public int zzA(Context paramAnonymousContext, String paramAnonymousString)
    {
      return DynamiteModule.zzA(paramAnonymousContext, paramAnonymousString);
    }
    
    public DynamiteModule zza(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt)
      throws DynamiteModule.zza
    {
      return DynamiteModule.zzc(paramAnonymousContext, paramAnonymousString, paramAnonymousInt);
    }
    
    public int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
      throws DynamiteModule.zza
    {
      return DynamiteModule.zzb(paramAnonymousContext, paramAnonymousString, paramAnonymousBoolean);
    }
  };
  private static final DynamiteModule.zzb.zza zzaQv = new DynamiteModule.zzb.zza()
  {
    public int zzA(Context paramAnonymousContext, String paramAnonymousString)
    {
      return DynamiteModule.zzA(paramAnonymousContext, paramAnonymousString);
    }
    
    public DynamiteModule zza(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt)
      throws DynamiteModule.zza
    {
      return DynamiteModule.zzd(paramAnonymousContext, paramAnonymousString, paramAnonymousInt);
    }
    
    public int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
      throws DynamiteModule.zza
    {
      return DynamiteModule.zzc(paramAnonymousContext, paramAnonymousString, paramAnonymousBoolean);
    }
  };
  public static final zzb zzaQw = new zzb()
  {
    public DynamiteModule.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, DynamiteModule.zzb.zza paramAnonymousZza)
      throws DynamiteModule.zza
    {
      DynamiteModule.zzb.zzb localZzb = new DynamiteModule.zzb.zzb();
      zzaQE = paramAnonymousZza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if (zzaQE != 0) {
        zzaQF = 1;
      }
      do
      {
        return localZzb;
        zzaQD = paramAnonymousZza.zzA(paramAnonymousContext, paramAnonymousString);
      } while (zzaQD == 0);
      zzaQF = -1;
      return localZzb;
    }
  };
  public static final zzb zzaQx = new zzb()
  {
    public DynamiteModule.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, DynamiteModule.zzb.zza paramAnonymousZza)
      throws DynamiteModule.zza
    {
      DynamiteModule.zzb.zzb localZzb = new DynamiteModule.zzb.zzb();
      zzaQD = paramAnonymousZza.zzA(paramAnonymousContext, paramAnonymousString);
      if (zzaQD != 0) {
        zzaQF = -1;
      }
      do
      {
        return localZzb;
        zzaQE = paramAnonymousZza.zzb(paramAnonymousContext, paramAnonymousString, true);
      } while (zzaQE == 0);
      zzaQF = 1;
      return localZzb;
    }
  };
  public static final zzb zzaQy = new zzb()
  {
    public DynamiteModule.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, DynamiteModule.zzb.zza paramAnonymousZza)
      throws DynamiteModule.zza
    {
      DynamiteModule.zzb.zzb localZzb = new DynamiteModule.zzb.zzb();
      zzaQD = paramAnonymousZza.zzA(paramAnonymousContext, paramAnonymousString);
      zzaQE = paramAnonymousZza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if ((zzaQD == 0) && (zzaQE == 0))
      {
        zzaQF = 0;
        return localZzb;
      }
      if (zzaQD >= zzaQE)
      {
        zzaQF = -1;
        return localZzb;
      }
      zzaQF = 1;
      return localZzb;
    }
  };
  public static final zzb zzaQz = new zzb()
  {
    public DynamiteModule.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, DynamiteModule.zzb.zza paramAnonymousZza)
      throws DynamiteModule.zza
    {
      DynamiteModule.zzb.zzb localZzb = new DynamiteModule.zzb.zzb();
      zzaQD = paramAnonymousZza.zzA(paramAnonymousContext, paramAnonymousString);
      zzaQE = paramAnonymousZza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if ((zzaQD == 0) && (zzaQE == 0))
      {
        zzaQF = 0;
        return localZzb;
      }
      if (zzaQE >= zzaQD)
      {
        zzaQF = 1;
        return localZzb;
      }
      zzaQF = -1;
      return localZzb;
    }
  };
  private final Context zzaQB;
  
  private DynamiteModule(Context paramContext)
  {
    zzaQB = ((Context)zzac.zzw(paramContext));
  }
  
  public static int zzA(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getClassLoader();
      Object localObject = String.valueOf("com.google.android.gms.dynamite.descriptors.");
      String str = String.valueOf("ModuleDescriptor");
      localObject = paramContext.loadClass(String.valueOf(localObject).length() + 1 + String.valueOf(paramString).length() + String.valueOf(str).length() + (String)localObject + paramString + "." + str);
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        Log.e("DynamiteModule", String.valueOf(paramContext).length() + 51 + String.valueOf(paramString).length() + "Module descriptor id '" + paramContext + "' didn't match expected id '" + paramString + "'");
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.w("DynamiteModule", String.valueOf(paramString).length() + 45 + "Local module descriptor class for " + paramString + " not found.");
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Failed to load module descriptor class: ".concat(paramContext);; paramContext = new String("Failed to load module descriptor class: "))
    {
      Log.e("DynamiteModule", paramContext);
      break;
    }
  }
  
  public static int zzB(Context paramContext, String paramString)
  {
    return zzb(paramContext, paramString, false);
  }
  
  private static DynamiteModule zzC(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "Selected local version of ".concat(paramString);; paramString = new String("Selected local version of "))
    {
      Log.i("DynamiteModule", paramString);
      return new DynamiteModule(paramContext.getApplicationContext());
    }
  }
  
  /* Error */
  private static ClassLoader zzD(Context paramContext, String paramString)
    throws ClassNotFoundException, java.lang.IllegalArgumentException, IllegalAccessException, java.lang.NoSuchFieldException
  {
    // Byte code:
    //   0: ldc 24
    //   2: monitorenter
    //   3: getstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   6: ifnull +12 -> 18
    //   9: getstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   12: astore_0
    //   13: ldc 24
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 106	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   22: invokevirtual 110	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   25: ldc 24
    //   27: invokevirtual 229	java/lang/Class:getName	()Ljava/lang/String;
    //   30: invokevirtual 145	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   33: astore_0
    //   34: aload_0
    //   35: ldc -26
    //   37: invokevirtual 153	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   40: astore_2
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_2
    //   44: aconst_null
    //   45: invokevirtual 160	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 141	java/lang/ClassLoader
    //   51: putstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   54: getstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   57: ifnull +20 -> 77
    //   60: getstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: ldc 24
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: astore_0
    //   72: ldc 24
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: new 22	com/google/android/gms/dynamite/DynamiteModule$9
    //   80: dup
    //   81: aload_1
    //   82: invokestatic 233	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   85: invokespecial 236	com/google/android/gms/dynamite/DynamiteModule$9:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   88: putstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   91: aload_2
    //   92: aconst_null
    //   93: getstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   96: invokevirtual 240	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   99: getstatic 226	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc 24
    //   107: monitorexit
    //   108: aload_1
    //   109: areturn
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString	String
    //   40	52	2	localField	Field
    // Exception table:
    //   from	to	target	type
    //   3	16	71	finally
    //   18	43	71	finally
    //   66	69	71	finally
    //   72	75	71	finally
    //   105	108	71	finally
    //   113	115	71	finally
    //   43	66	110	finally
    //   77	105	110	finally
    //   111	113	110	finally
  }
  
  private static Context zza(Context paramContext, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("DynamiteModule", "No valid DynamiteLoader APK path");
      return null;
    }
    try
    {
      paramContext = (Context)zze.zzE(zzb.zza.zzcf((IBinder)zzD(paramContext, paramString2).loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0])).zza(zze.zzA(paramContext), paramString1, paramArrayOfByte));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.toString());
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Failed to load DynamiteLoader: ".concat(paramContext);; paramContext = new String("Failed to load DynamiteLoader: "))
    {
      Log.e("DynamiteModule", paramContext);
      return null;
    }
  }
  
  public static DynamiteModule zza(Context paramContext, zzb paramZzb, String paramString)
    throws DynamiteModule.zza
  {
    if ("com.google.android.gms".equals(paramContext.getApplicationContext().getPackageName())) {
      return zza(paramContext, paramZzb, paramString, zzaQu);
    }
    try
    {
      DynamiteModule localDynamiteModule = zza(paramContext, paramZzb, paramString, zzaQv);
      return localDynamiteModule;
    }
    catch (zza localZza)
    {
      str = String.valueOf(localZza.toString());
      if (str.length() == 0) {}
    }
    for (String str = "Failed to load module via fast route".concat(str);; str = new String("Failed to load module via fast route"))
    {
      Log.w("DynamiteModule", str);
      return zza(paramContext, paramZzb, paramString, zzaQu);
    }
  }
  
  public static DynamiteModule zza(Context paramContext, zzb paramZzb, String paramString, DynamiteModule.zzb.zza paramZza)
    throws DynamiteModule.zza
  {
    DynamiteModule.zzb.zzb localZzb = paramZzb.zza(paramContext, paramString, paramZza);
    int i = zzaQD;
    int j = zzaQE;
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length() + "Considering local module " + paramString + ":" + i + " and remote module " + paramString + ":" + j);
    if ((zzaQF == 0) || ((zzaQF == -1) && (zzaQD == 0)) || ((zzaQF == 1) && (zzaQE == 0)))
    {
      i = zzaQD;
      j = zzaQE;
      throw new zza(91 + "No acceptable module found. Local version is " + i + " and remote version is " + j + ".", null);
    }
    if (zzaQF == -1) {
      return zzC(paramContext, paramString);
    }
    if (zzaQF == 1) {
      try
      {
        paramZza = paramZza.zza(paramContext, paramString, zzaQE);
        return paramZza;
      }
      catch (zza localZza)
      {
        paramZza = String.valueOf(localZza.getMessage());
        if (paramZza.length() != 0) {}
        for (paramZza = "Failed to load remote module: ".concat(paramZza);; paramZza = new String("Failed to load remote module: "))
        {
          Log.w("DynamiteModule", paramZza);
          if ((zzaQD == 0) || (
          {
            public int zzA(Context paramAnonymousContext, String paramAnonymousString)
            {
              return zzaQC;
            }
            
            public DynamiteModule zza(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt)
              throws DynamiteModule.zza
            {
              throw new DynamiteModule.zza("local only VersionPolicy should not load from remote", null);
            }
            
            public int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              return 0;
            }
          } != -1)) {
            break;
          }
          return zzC(paramContext, paramString);
        }
        throw new zza("Remote load failed. No local fallback found.", localZza, null);
      }
    }
    i = zzaQF;
    throw new zza(47 + "VersionPolicy returned invalid code:" + i, null);
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.zza
  {
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 51 + "Selected remote version of " + paramString + ", version >= " + paramInt);
    zza localZza = zzaU(paramContext);
    if (localZza == null) {
      throw new zza("Failed to create IDynamiteLoader.", null);
    }
    try
    {
      paramContext = localZza.zza(zze.zzA(paramContext), paramString, paramInt);
      if (zze.zzE(paramContext) == null) {
        throw new zza("Failed to load remote module.", null);
      }
    }
    catch (RemoteException paramContext)
    {
      throw new zza("Failed to load remote module.", paramContext, null);
    }
    return new DynamiteModule((Context)zze.zzE(paramContext));
  }
  
  /* Error */
  private static zza zzaU(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 366	com/google/android/gms/dynamite/DynamiteModule:zzaQr	Lcom/google/android/gms/dynamite/zza;
    //   6: ifnull +12 -> 18
    //   9: getstatic 366	com/google/android/gms/dynamite/DynamiteModule:zzaQr	Lcom/google/android/gms/dynamite/zza;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 372	com/google/android/gms/common/zzc:zzuz	()Lcom/google/android/gms/common/zzc;
    //   21: aload_0
    //   22: invokevirtual 376	com/google/android/gms/common/zzc:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   25: ifeq +8 -> 33
    //   28: ldc 2
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc_w 290
    //   37: iconst_3
    //   38: invokevirtual 380	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   41: invokevirtual 110	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   44: ldc_w 382
    //   47: invokevirtual 145	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: invokevirtual 385	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   53: checkcast 264	android/os/IBinder
    //   56: invokestatic 391	com/google/android/gms/dynamite/zza$zza:zzce	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamite/zza;
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +49 -> 110
    //   64: aload_0
    //   65: putstatic 366	com/google/android/gms/dynamite/DynamiteModule:zzaQr	Lcom/google/android/gms/dynamite/zza;
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: areturn
    //   73: astore_0
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 126	java/lang/String:length	()I
    //   92: ifeq +23 -> 115
    //   95: ldc_w 393
    //   98: aload_0
    //   99: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_0
    //   103: ldc -90
    //   105: aload_0
    //   106: invokestatic 178	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   109: pop
    //   110: ldc 2
    //   112: monitorexit
    //   113: aconst_null
    //   114: areturn
    //   115: new 114	java/lang/String
    //   118: dup
    //   119: ldc_w 393
    //   122: invokespecial 201	java/lang/String:<init>	(Ljava/lang/String;)V
    //   125: astore_0
    //   126: goto -23 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	16	73	finally
    //   18	31	73	finally
    //   33	60	73	finally
    //   64	68	73	finally
    //   68	71	73	finally
    //   74	77	73	finally
    //   80	103	73	finally
    //   103	110	73	finally
    //   110	113	73	finally
    //   115	126	73	finally
    //   33	60	79	java/lang/Exception
    //   64	68	79	java/lang/Exception
  }
  
  public static int zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    zza localZza = zzaU(paramContext);
    if (localZza == null) {
      return 0;
    }
    try
    {
      int i = localZza.zza(zze.zzA(paramContext), paramString, paramBoolean);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Failed to retrieve remote module version: ".concat(paramContext);; paramContext = new String("Failed to retrieve remote module version: "))
    {
      Log.w("DynamiteModule", paramContext);
      return 0;
    }
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.zza
  {
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 51 + "Selected remote version of " + paramString + ", version >= " + paramInt);
    byte[] arrayOfByte;
    String str;
    try
    {
      arrayOfByte = (byte[])zzaQs.get(String.valueOf(paramString).length() + 12 + paramString + ":" + paramInt);
      str = zzaQt;
      if (arrayOfByte == null) {
        throw new zza("Module implementation could not be found.", null);
      }
    }
    finally {}
    paramContext = zza(paramContext.getApplicationContext(), paramString, arrayOfByte, str);
    if (paramContext == null) {
      throw new zza("Failed to get module context", null);
    }
    return new DynamiteModule(paramContext);
  }
  
  public static int zzc(Context paramContext, String paramString, boolean paramBoolean)
    throws DynamiteModule.zza
  {
    Object localObject4 = null;
    Object localObject1;
    if (paramBoolean) {
      localObject1 = "api_force_staging";
    }
    try
    {
      String str = String.valueOf("content://com.google.android.gms.chimera/");
      localObject1 = Uri.parse(String.valueOf(str).length() + 1 + String.valueOf(localObject1).length() + String.valueOf(paramString).length() + str + (String)localObject1 + "/" + paramString);
      if (paramContext != null)
      {
        paramContext = paramContext.getContentResolver();
        if (paramContext != null) {}
      }
      else
      {
        throw new zza("Failed to get dynamite module ContentResolver.", null);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject1 = null;
        paramContext = (Context)localObject1;
        try
        {
          if (!(paramString instanceof zza)) {
            break;
          }
          paramContext = (Context)localObject1;
          throw paramString;
        }
        finally
        {
          paramString = paramContext;
          paramContext = localObject2;
        }
        if (paramString != null) {
          paramString.close();
        }
        throw paramContext;
        localObject3 = "api";
      }
      localObject3 = paramContext.query((Uri)localObject3, null, null, null, null);
      if (localObject3 != null) {
        paramContext = (Context)localObject3;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          Object localObject3;
          if (!((Cursor)localObject3).moveToFirst())
          {
            paramContext = (Context)localObject3;
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            paramContext = (Context)localObject3;
            throw new zza("Failed to connect to dynamite module ContentResolver.", null);
          }
          paramContext = (Context)localObject3;
          int i = ((Cursor)localObject3).getInt(0);
          if (i > 0) {
            paramContext = (Context)localObject3;
          }
          try
          {
            paramContext = Base64.decode(((Cursor)localObject3).getString(3), 0);
            zzaQs.put(String.valueOf(paramString).length() + 12 + paramString + ":" + i, paramContext);
            zzaQt = ((Cursor)localObject3).getString(2);
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            return i;
          }
          finally
          {
            paramContext = (Context)localObject3;
          }
          paramContext = (Context)localObject3;
          throw new zza("V2 version check failed", paramString, null);
        }
        catch (Exception paramString) {}
        paramContext = finally;
        paramString = localObject4;
      }
    }
  }
  
  public Context zzBd()
  {
    return zzaQB;
  }
  
  public IBinder zzdX(String paramString)
    throws DynamiteModule.zza
  {
    try
    {
      IBinder localIBinder = (IBinder)zzaQB.getClassLoader().loadClass(paramString).newInstance();
      return localIBinder;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to instantiate module class: ".concat(paramString);; paramString = new String("Failed to instantiate module class: ")) {
        throw new zza(paramString, localClassNotFoundException, null);
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader
  {
    public static ClassLoader sClassLoader;
    
    public DynamiteLoaderClassLoader() {}
  }
  
  public static class zza
    extends Exception
  {
    private zza(String paramString)
    {
      super();
    }
    
    private zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface zzb
  {
    public abstract zzb zza(Context paramContext, String paramString, zza paramZza)
      throws DynamiteModule.zza;
    
    public static abstract interface zza
    {
      public abstract int zzA(Context paramContext, String paramString);
      
      public abstract DynamiteModule zza(Context paramContext, String paramString, int paramInt)
        throws DynamiteModule.zza;
      
      public abstract int zzb(Context paramContext, String paramString, boolean paramBoolean)
        throws DynamiteModule.zza;
    }
    
    public static class zzb
    {
      public int zzaQD = 0;
      public int zzaQE = 0;
      public int zzaQF = 0;
      
      public zzb() {}
    }
  }
}

package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzabv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zzaCG = new Object();
  private static HashSet<Uri> zzaCH = new HashSet();
  private static ImageManager zzaCI;
  private static ImageManager zzaCJ;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zzaCK;
  private final zzb zzaCL;
  private final zzabv zzaCM;
  private final Map<zza, ImageReceiver> zzaCN;
  private final Map<Uri, ImageReceiver> zzaCO;
  private final Map<Uri, Long> zzaCP;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext.getApplicationContext();
    mHandler = new Handler(Looper.getMainLooper());
    zzaCK = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      zzaCL = new zzb(mContext);
      if (zzs.zzyA()) {
        zzwJ();
      }
    }
    for (;;)
    {
      zzaCM = new zzabv();
      zzaCN = new HashMap();
      zzaCO = new HashMap();
      zzaCP = new HashMap();
      return;
      zzaCL = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    return zzg(paramContext, false);
  }
  
  private Bitmap zza(zza.zza paramZza)
  {
    if (zzaCL == null) {
      return null;
    }
    return (Bitmap)zzaCL.get(paramZza);
  }
  
  public static ImageManager zzg(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (zzaCJ == null) {
        zzaCJ = new ImageManager(paramContext, true);
      }
      return zzaCJ;
    }
    if (zzaCI == null) {
      zzaCI = new ImageManager(paramContext, false);
    }
    return zzaCI;
  }
  
  @TargetApi(14)
  private void zzwJ()
  {
    mContext.registerComponentCallbacks(new zze(zzaCL));
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zza.zzb(paramImageView, paramUri);
    paramImageView.zzcI(paramInt);
    zza(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zza.zzc(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zzcI(paramInt);
    zza(paramOnImageLoadedListener);
  }
  
  public void zza(zza paramZza)
  {
    zzc.zzdn("ImageManager.loadImage() must be called in the main thread");
    new zzd(paramZza).run();
  }
  
  @KeepName
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zza> zzaCQ;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      mUri = paramUri;
      zzaCQ = new ArrayList();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzc(ImageManager.this, mUri, paramBundle));
    }
    
    public void zzb(zza paramZza)
    {
      zzc.zzdn("ImageReceiver.addImageRequest() must be called in the main thread");
      zzaCQ.add(paramZza);
    }
    
    public void zzc(zza paramZza)
    {
      zzc.zzdn("ImageReceiver.removeImageRequest() must be called in the main thread");
      zzaCQ.remove(paramZza);
    }
    
    public void zzwL()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  @TargetApi(11)
  private static final class zza
  {
    static int zza(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class zzb
    extends LruCache<zza.zza, Bitmap>
  {
    public zzb(Context paramContext)
    {
      super();
    }
    
    @TargetApi(11)
    private static int zzaz(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((getApplicationInfoflags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!zzs.zzyx())) {
          break label55;
        }
      }
      label55:
      for (int i = ImageManager.zza.zza(localActivityManager);; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }
    
    protected int zza(zza.zza paramZza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void zza(boolean paramBoolean, zza.zza paramZza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramZza, paramBitmap1, paramBitmap2);
    }
  }
  
  private final class zzc
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zzaCS;
    
    public zzc(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      mUri = paramUri;
      zzaCS = paramParcelFileDescriptor;
    }
    
    public void run()
    {
      zzc.zzdo("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      boolean bool1 = false;
      boolean bool2 = false;
      Bitmap localBitmap = null;
      CountDownLatch localCountDownLatch = null;
      if (zzaCS != null) {}
      try
      {
        localBitmap = BitmapFactory.decodeFileDescriptor(zzaCS.getFileDescriptor());
        bool1 = bool2;
        String str2;
        Object localObject;
        String str1;
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          for (;;)
          {
            zzaCS.close();
            localCountDownLatch = new CountDownLatch(1);
            ImageManager.zzg(ImageManager.this).post(new ImageManager.zzf(ImageManager.this, mUri, localBitmap, bool1, localCountDownLatch));
            try
            {
              localCountDownLatch.await();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              str1 = String.valueOf(mUri);
              Log.w("ImageManager", String.valueOf(str1).length() + 32 + "Latch interrupted while posting " + str1);
            }
            localOutOfMemoryError = localOutOfMemoryError;
            str2 = String.valueOf(mUri);
            Log.e("ImageManager", String.valueOf(str2).length() + 34 + "OOM while loading bitmap for uri: " + str2, localOutOfMemoryError);
            bool1 = true;
            localObject = localCountDownLatch;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("ImageManager", "closed failed", localIOException);
          }
        }
      }
    }
  }
  
  private final class zzd
    implements Runnable
  {
    private final zza zzaCT;
    
    public zzd(zza paramZza)
    {
      zzaCT = paramZza;
    }
    
    public void run()
    {
      zzc.zzdn("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(zzaCT);
      if (localObject1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(zzaCT);
        ((ImageManager.ImageReceiver)localObject1).zzc(zzaCT);
      }
      zza.zza localZza = zzaCT.zzaCV;
      if (uri == null)
      {
        zzaCT.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.zza(ImageManager.this, localZza);
      if (localObject1 != null)
      {
        zzaCT.zza(ImageManager.zzb(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.zzd(ImageManager.this).get(uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          zzaCT.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
          return;
        }
        ImageManager.zzd(ImageManager.this).remove(uri);
      }
      zzaCT.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, uri);
        ImageManager.zze(ImageManager.this).put(uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).zzb(zzaCT);
      if (!(zzaCT instanceof zza.zzc)) {
        ImageManager.zza(ImageManager.this).put(zzaCT, localObject1);
      }
      synchronized (ImageManager.zzui())
      {
        if (!ImageManager.zzwK().contains(uri))
        {
          ImageManager.zzwK().add(uri);
          ((ImageManager.ImageReceiver)localObject1).zzwL();
        }
        return;
      }
    }
  }
  
  @TargetApi(14)
  private static final class zze
    implements ComponentCallbacks2
  {
    private final ImageManager.zzb zzaCL;
    
    public zze(ImageManager.zzb paramZzb)
    {
      zzaCL = paramZzb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      zzaCL.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        zzaCL.evictAll();
      }
      while (paramInt < 20) {
        return;
      }
      zzaCL.trimToSize(zzaCL.size() / 2);
    }
  }
  
  private final class zzf
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private boolean zzaCU;
    private final CountDownLatch zzth;
    
    public zzf(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      mUri = paramUri;
      mBitmap = paramBitmap;
      zzaCU = paramBoolean;
      zzth = paramCountDownLatch;
    }
    
    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int j = paramImageReceiver.size();
      int i = 0;
      if (i < j)
      {
        zza localZza = (zza)paramImageReceiver.get(i);
        if (paramBoolean) {
          localZza.zza(ImageManager.zzb(ImageManager.this), mBitmap, false);
        }
        for (;;)
        {
          if (!(localZza instanceof zza.zzc)) {
            ImageManager.zza(ImageManager.this).remove(localZza);
          }
          i += 1;
          break;
          ImageManager.zzd(ImageManager.this).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localZza.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }
    
    public void run()
    {
      zzc.zzdn("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (mBitmap != null) {
        bool = true;
      }
      while (ImageManager.zzh(ImageManager.this) != null) {
        if (zzaCU)
        {
          ImageManager.zzh(ImageManager.this).evictAll();
          System.gc();
          zzaCU = false;
          ImageManager.zzg(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.zzh(ImageManager.this).put(new zza.zza(mUri), mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(mUri);
      if (??? != null) {
        zza((ImageManager.ImageReceiver)???, bool);
      }
      zzth.countDown();
      synchronized (ImageManager.zzui())
      {
        ImageManager.zzwK().remove(mUri);
        return;
      }
    }
  }
}

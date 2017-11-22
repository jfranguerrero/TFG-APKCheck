package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpi;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzmb
@TargetApi(14)
public class zzd
  extends zzj
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static final Map<Integer, String> zzMc = new HashMap();
  private final zzz zzMd;
  private final boolean zzMe;
  private int zzMf = 0;
  private int zzMg = 0;
  private MediaPlayer zzMh;
  private Uri zzMi;
  private int zzMj;
  private int zzMk;
  private int zzMl;
  private int zzMm;
  private int zzMn;
  private zzy zzMo;
  private boolean zzMp;
  private int zzMq;
  private zzi zzMr;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      zzMc.put(Integer.valueOf(64532), "MEDIA_ERROR_IO");
      zzMc.put(Integer.valueOf(64529), "MEDIA_ERROR_MALFORMED");
      zzMc.put(Integer.valueOf(64526), "MEDIA_ERROR_UNSUPPORTED");
      zzMc.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
      zzMc.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
    }
    zzMc.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
    zzMc.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
    zzMc.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
    zzMc.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
    zzMc.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
    zzMc.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
    zzMc.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
    zzMc.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
    zzMc.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
    if (Build.VERSION.SDK_INT >= 19)
    {
      zzMc.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
      zzMc.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }
  }
  
  public zzd(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, zzz paramZzz)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    zzMd = paramZzz;
    zzMp = paramBoolean1;
    zzMe = paramBoolean2;
    zzMd.zza(this);
  }
  
  private void zzI(int paramInt)
  {
    if (paramInt == 3)
    {
      zzMd.zzib();
      zzNk.zzib();
    }
    for (;;)
    {
      zzMf = paramInt;
      return;
      if (zzMf == 3)
      {
        zzMd.zzic();
        zzNk.zzic();
      }
    }
  }
  
  private void zzJ(int paramInt)
  {
    zzMg = paramInt;
  }
  
  private void zza(float paramFloat)
  {
    if (zzMh != null) {}
    try
    {
      zzMh.setVolume(paramFloat, paramFloat);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
    zzpe.zzbe("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    return;
  }
  
  private void zzhe()
  {
    zzpe.v("AdMediaPlayerView init MediaPlayer");
    Object localObject1 = getSurfaceTexture();
    if ((zzMi == null) || (localObject1 == null)) {
      return;
    }
    zzy(false);
    try
    {
      zzMh = zzv.zzda().zzhO();
      zzMh.setOnBufferingUpdateListener(this);
      zzMh.setOnCompletionListener(this);
      zzMh.setOnErrorListener(this);
      zzMh.setOnInfoListener(this);
      zzMh.setOnPreparedListener(this);
      zzMh.setOnVideoSizeChangedListener(this);
      zzMl = 0;
      if (!zzMp) {
        break label276;
      }
      zzMo = new zzy(getContext());
      zzMo.zza((SurfaceTexture)localObject1, getWidth(), getHeight());
      zzMo.start();
      localObject2 = zzMo.zzhQ();
      if (localObject2 == null) {
        break label264;
      }
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2 = String.valueOf(zzMi);
        zzpe.zzc(String.valueOf(localObject2).length() + 36 + "Failed to initialize MediaPlayer at " + (String)localObject2, localIOException);
        onError(zzMh, 1, 0);
        return;
        zzMo.zzhP();
        zzMo = null;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    zzMh.setDataSource(getContext(), zzMi);
    localObject1 = zzv.zzdb().zza((SurfaceTexture)localObject1);
    zzMh.setSurface((Surface)localObject1);
    zzMh.setAudioStreamType(3);
    zzMh.setScreenOnWhilePlaying(true);
    zzMh.prepareAsync();
    zzI(1);
  }
  
  private void zzhf()
  {
    if (!zzMe) {}
    while ((!zzhg()) || (zzMh.getCurrentPosition() <= 0) || (zzMg == 3)) {
      return;
    }
    zzpe.v("AdMediaPlayerView nudging MediaPlayer");
    zza(0.0F);
    zzMh.start();
    int i = zzMh.getCurrentPosition();
    long l = zzv.zzcP().currentTimeMillis();
    while ((zzhg()) && (zzMh.getCurrentPosition() == i) && (zzv.zzcP().currentTimeMillis() - l <= 250L)) {}
    zzMh.pause();
    zzhh();
  }
  
  private boolean zzhg()
  {
    return (zzMh != null) && (zzMf != -1) && (zzMf != 0) && (zzMf != 1);
  }
  
  private void zzy(boolean paramBoolean)
  {
    zzpe.v("AdMediaPlayerView release");
    if (zzMo != null)
    {
      zzMo.zzhP();
      zzMo = null;
    }
    if (zzMh != null)
    {
      zzMh.reset();
      zzMh.release();
      zzMh = null;
      zzI(0);
      if (paramBoolean)
      {
        zzMg = 0;
        zzJ(0);
      }
    }
  }
  
  public int getCurrentPosition()
  {
    if (zzhg()) {
      return zzMh.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (zzhg()) {
      return zzMh.getDuration();
    }
    return -1;
  }
  
  public int getVideoHeight()
  {
    if (zzMh != null) {
      return zzMh.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (zzMh != null) {
      return zzMh.getVideoWidth();
    }
    return 0;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    zzMl = paramInt;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    zzpe.v("AdMediaPlayerView completion");
    zzI(5);
    zzJ(5);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        if (zzd.zza(zzd.this) != null) {
          zzd.zza(zzd.this).zzhB();
        }
      }
    });
  }
  
  public boolean onError(final MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)zzMc.get(Integer.valueOf(paramInt1));
    final String str = (String)zzMc.get(Integer.valueOf(paramInt2));
    zzpe.zzbe(String.valueOf(paramMediaPlayer).length() + 38 + String.valueOf(str).length() + "AdMediaPlayerView MediaPlayer error: " + paramMediaPlayer + ":" + str);
    zzI(-1);
    zzJ(-1);
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        if (zzd.zza(zzd.this) != null) {
          zzd.zza(zzd.this).zzk(paramMediaPlayer, str);
        }
      }
    });
    return true;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = (String)zzMc.get(Integer.valueOf(paramInt1));
    String str = (String)zzMc.get(Integer.valueOf(paramInt2));
    zzpe.v(String.valueOf(paramMediaPlayer).length() + 37 + String.valueOf(str).length() + "AdMediaPlayerView MediaPlayer info: " + paramMediaPlayer + ":" + str);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(zzMj, paramInt1);
    int m = getDefaultSize(zzMk, paramInt2);
    int j = m;
    int i = k;
    int n;
    if (zzMj > 0)
    {
      j = m;
      i = k;
      if (zzMk > 0)
      {
        j = m;
        i = k;
        if (zzMo == null)
        {
          m = View.MeasureSpec.getMode(paramInt1);
          paramInt1 = View.MeasureSpec.getSize(paramInt1);
          n = View.MeasureSpec.getMode(paramInt2);
          paramInt2 = View.MeasureSpec.getSize(paramInt2);
          if ((m != 1073741824) || (n != 1073741824)) {
            break label242;
          }
          if (zzMj * paramInt2 >= zzMk * paramInt1) {
            break label209;
          }
          i = zzMj * paramInt2 / zzMk;
          j = paramInt2;
        }
      }
    }
    for (;;)
    {
      setMeasuredDimension(i, j);
      if (zzMo != null) {
        zzMo.zzi(i, j);
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        if (((zzMm > 0) && (zzMm != i)) || ((zzMn > 0) && (zzMn != j))) {
          zzhf();
        }
        zzMm = i;
        zzMn = j;
      }
      return;
      label209:
      if (zzMj * paramInt2 > zzMk * paramInt1)
      {
        j = zzMk * paramInt1 / zzMj;
        i = paramInt1;
        continue;
        label242:
        if (m == 1073741824)
        {
          j = zzMk * paramInt1 / zzMj;
          if ((n == Integer.MIN_VALUE) && (j > paramInt2))
          {
            j = paramInt2;
            i = paramInt1;
          }
        }
        else
        {
          if (n == 1073741824)
          {
            k = zzMj * paramInt2 / zzMk;
            j = paramInt2;
            i = k;
            if (m != Integer.MIN_VALUE) {
              continue;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              continue;
            }
            j = paramInt2;
            i = paramInt1;
            continue;
          }
          k = zzMj;
          i = zzMk;
          if ((n == Integer.MIN_VALUE) && (i > paramInt2)) {
            k = zzMj * paramInt2 / zzMk;
          }
          for (;;)
          {
            j = paramInt2;
            i = k;
            if (m != Integer.MIN_VALUE) {
              break;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              break;
            }
            j = zzMk * paramInt1 / zzMj;
            i = paramInt1;
            break;
            paramInt2 = i;
          }
        }
        i = paramInt1;
      }
      else
      {
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    zzpe.v("AdMediaPlayerView prepared");
    zzI(2);
    zzMd.zzhz();
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        if (zzd.zza(zzd.this) != null) {
          zzd.zza(zzd.this).zzhz();
        }
      }
    });
    zzMj = paramMediaPlayer.getVideoWidth();
    zzMk = paramMediaPlayer.getVideoHeight();
    if (zzMq != 0) {
      seekTo(zzMq);
    }
    zzhf();
    int i = zzMj;
    int j = zzMk;
    zzpe.zzbd(62 + "AdMediaPlayerView stream dimensions: " + i + " x " + j);
    if (zzMg == 3) {
      play();
    }
    zzhh();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    zzpe.v("AdMediaPlayerView surface created");
    zzhe();
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        if (zzd.zza(zzd.this) != null) {
          zzd.zza(zzd.this).zzhy();
        }
      }
    });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    zzpe.v("AdMediaPlayerView surface destroyed");
    if ((zzMh != null) && (zzMq == 0)) {
      zzMq = zzMh.getCurrentPosition();
    }
    if (zzMo != null) {
      zzMo.zzhP();
    }
    zzpi.zzWR.post(new Runnable()
    {
      public void run()
      {
        if (zzd.zza(zzd.this) != null)
        {
          zzd.zza(zzd.this).onPaused();
          zzd.zza(zzd.this).zzhC();
        }
      }
    });
    zzy(true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    int j = 1;
    zzpe.v("AdMediaPlayerView surface changed");
    int i;
    if (zzMg == 3)
    {
      i = 1;
      if ((zzMj != paramInt1) || (zzMk != paramInt2)) {
        break label112;
      }
    }
    for (;;)
    {
      if ((zzMh != null) && (i != 0) && (j != 0))
      {
        if (zzMq != 0) {
          seekTo(zzMq);
        }
        play();
      }
      if (zzMo != null) {
        zzMo.zzi(paramInt1, paramInt2);
      }
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          if (zzd.zza(zzd.this) != null) {
            zzd.zza(zzd.this).zzf(paramInt1, paramInt2);
          }
        }
      });
      return;
      i = 0;
      break;
      label112:
      j = 0;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    zzMd.zzb(this);
    zzNj.zza(paramSurfaceTexture, zzMr);
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    zzpe.v(57 + "AdMediaPlayerView size changed: " + paramInt1 + " x " + paramInt2);
    zzMj = paramMediaPlayer.getVideoWidth();
    zzMk = paramMediaPlayer.getVideoHeight();
    if ((zzMj != 0) && (zzMk != 0)) {
      requestLayout();
    }
  }
  
  public void pause()
  {
    zzpe.v("AdMediaPlayerView pause");
    if ((zzhg()) && (zzMh.isPlaying()))
    {
      zzMh.pause();
      zzI(4);
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          if (zzd.zza(zzd.this) != null) {
            zzd.zza(zzd.this).onPaused();
          }
        }
      });
    }
    zzJ(4);
  }
  
  public void play()
  {
    zzpe.v("AdMediaPlayerView play");
    if (zzhg())
    {
      zzMh.start();
      zzI(3);
      zzNj.zzhA();
      zzpi.zzWR.post(new Runnable()
      {
        public void run()
        {
          if (zzd.zza(zzd.this) != null) {
            zzd.zza(zzd.this).zzhA();
          }
        }
      });
    }
    zzJ(3);
  }
  
  public void seekTo(int paramInt)
  {
    zzpe.v(34 + "AdMediaPlayerView seek " + paramInt);
    if (zzhg())
    {
      zzMh.seekTo(paramInt);
      zzMq = 0;
      return;
    }
    zzMq = paramInt;
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    zzMi = paramUri;
    zzMq = 0;
    zzhe();
    requestLayout();
    invalidate();
  }
  
  public void stop()
  {
    zzpe.v("AdMediaPlayerView stop");
    if (zzMh != null)
    {
      zzMh.stop();
      zzMh.release();
      zzMh = null;
      zzI(0);
      zzJ(0);
    }
    zzMd.onStop();
  }
  
  public String toString()
  {
    String str1 = String.valueOf(getClass().getName());
    String str2 = String.valueOf(Integer.toHexString(hashCode()));
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "@" + str2;
  }
  
  public void zza(float paramFloat1, float paramFloat2)
  {
    if (zzMo != null) {
      zzMo.zzb(paramFloat1, paramFloat2);
    }
  }
  
  public void zza(zzi paramZzi)
  {
    zzMr = paramZzi;
  }
  
  public String zzhd()
  {
    if (zzMp) {}
    for (String str = " spherical";; str = "")
    {
      str = String.valueOf(str);
      if (str.length() == 0) {
        break;
      }
      return "MediaPlayer".concat(str);
    }
    return new String("MediaPlayer");
  }
  
  public void zzhh()
  {
    zza(zzNk.zzie());
  }
}

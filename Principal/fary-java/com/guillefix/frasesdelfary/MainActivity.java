package com.guillefix.frasesdelfary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity
  extends AppCompatActivity
{
  private final int REQUEST_CODE_ASK_PERMISSIONS = 123;
  private final int[] buttonIds = { 2131689597, 2131689598, 2131689599, 2131689600, 2131689601, 2131689602, 2131689603, 2131689604, 2131689605, 2131689606, 2131689607, 2131689608, 2131689609, 2131689610, 2131689611, 2131689612, 2131689613, 2131689614, 2131689615, 2131689616, 2131689617, 2131689618 };
  private MediaPlayer player;
  private Resources res;
  int selectedSoundId;
  final int[] soundIds = { 2131230720, 2131230721, 2131230722, 2131230723, 2131230724, 2131230725, 2131230726, 2131230727, 2131230728, 2131230729, 2131230730, 2131230731, 2131230732, 2131230733, 2131230734, 2131230735, 2131230736, 2131230737, 2131230738, 2131230739, 2131230740, 2131230741 };
  
  public MainActivity() {}
  
  /* Error */
  private void playRandomSound()
  {
    // Byte code:
    //   0: invokestatic 100	java/lang/Math:random	()D
    //   3: aload_0
    //   4: getfield 52	com/guillefix/frasesdelfary/MainActivity:buttonIds	[I
    //   7: arraylength
    //   8: i2d
    //   9: dmul
    //   10: d2i
    //   11: istore_1
    //   12: aload_0
    //   13: getfield 83	com/guillefix/frasesdelfary/MainActivity:res	Landroid/content/res/Resources;
    //   16: aload_0
    //   17: getfield 76	com/guillefix/frasesdelfary/MainActivity:soundIds	[I
    //   20: iload_1
    //   21: iaload
    //   22: invokevirtual 106	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 87	com/guillefix/frasesdelfary/MainActivity:player	Landroid/media/MediaPlayer;
    //   30: invokevirtual 111	android/media/MediaPlayer:reset	()V
    //   33: aload_0
    //   34: getfield 87	com/guillefix/frasesdelfary/MainActivity:player	Landroid/media/MediaPlayer;
    //   37: aload_2
    //   38: invokevirtual 117	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   41: aload_2
    //   42: invokevirtual 121	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   45: aload_2
    //   46: invokevirtual 124	android/content/res/AssetFileDescriptor:getLength	()J
    //   49: invokevirtual 128	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   52: aload_0
    //   53: getfield 87	com/guillefix/frasesdelfary/MainActivity:player	Landroid/media/MediaPlayer;
    //   56: invokevirtual 131	android/media/MediaPlayer:prepare	()V
    //   59: aload_0
    //   60: getfield 87	com/guillefix/frasesdelfary/MainActivity:player	Landroid/media/MediaPlayer;
    //   63: invokevirtual 134	android/media/MediaPlayer:start	()V
    //   66: return
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 137	java/lang/IllegalArgumentException:printStackTrace	()V
    //   72: goto -20 -> 52
    //   75: astore_2
    //   76: aload_2
    //   77: invokevirtual 138	java/lang/IllegalStateException:printStackTrace	()V
    //   80: goto -28 -> 52
    //   83: astore_2
    //   84: aload_2
    //   85: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   88: goto -36 -> 52
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 138	java/lang/IllegalStateException:printStackTrace	()V
    //   96: goto -37 -> 59
    //   99: astore_2
    //   100: aload_2
    //   101: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   104: goto -45 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	MainActivity
    //   11	10	1	i	int
    //   25	21	2	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   67	2	2	localIllegalArgumentException	IllegalArgumentException
    //   75	2	2	localIllegalStateException1	IllegalStateException
    //   83	2	2	localIOException1	IOException
    //   91	2	2	localIllegalStateException2	IllegalStateException
    //   99	2	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   33	52	67	java/lang/IllegalArgumentException
    //   33	52	75	java/lang/IllegalStateException
    //   33	52	83	java/io/IOException
    //   52	59	91	java/lang/IllegalStateException
    //   52	59	99	java/io/IOException
  }
  
  private void randomYoutubeVideo()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add("https://www.youtube.com/watch?v=WosrUnjb2UQ");
    ((List)localObject).add("https://www.youtube.com/watch?v=SX8HPD3jIT0");
    ((List)localObject).add("https://www.youtube.com/watch?v=HgjQGGZiy-k");
    ((List)localObject).add("https://www.youtube.com/watch?v=ladsmDRCMyU");
    ((List)localObject).add("https://www.youtube.com/watch?v=HHenQqsI6Xo");
    ((List)localObject).add("https://www.youtube.com/watch?v=yv-zM2gR9uw");
    ((List)localObject).add("https://www.youtube.com/watch?v=i0IwVSW7occ");
    ((List)localObject).add("https://www.youtube.com/watch?v=LEV4NN_fqHU");
    ((List)localObject).add("https://www.youtube.com/watch?v=WDnxMkP7ew0");
    localObject = (String)((List)localObject).get(new Random().nextInt(((List)localObject).size()));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse((String)localObject));
    startActivity(localIntent);
  }
  
  private void showInstrucciones()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setPositiveButton(2131296325, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.setMessage(getString(2131296323)).setTitle(2131296324);
    localBuilder.create().show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968603);
    ((AdView)findViewById(2131689595)).loadAd(new AdRequest.Builder().build());
    player = new MediaPlayer();
    res = getResources();
    paramBundle = new View.OnClickListener()
    {
      /* Error */
      public void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_2
        //   2: iload_2
        //   3: aload_0
        //   4: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   7: invokestatic 33	com/guillefix/frasesdelfary/MainActivity:access$000	(Lcom/guillefix/frasesdelfary/MainActivity;)[I
        //   10: arraylength
        //   11: if_icmpge +107 -> 118
        //   14: aload_1
        //   15: invokevirtual 39	android/view/View:getId	()I
        //   18: aload_0
        //   19: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   22: invokestatic 33	com/guillefix/frasesdelfary/MainActivity:access$000	(Lcom/guillefix/frasesdelfary/MainActivity;)[I
        //   25: iload_2
        //   26: iaload
        //   27: if_icmpne +132 -> 159
        //   30: aload_0
        //   31: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   34: aload_0
        //   35: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   38: getfield 43	com/guillefix/frasesdelfary/MainActivity:soundIds	[I
        //   41: iload_2
        //   42: iaload
        //   43: putfield 47	com/guillefix/frasesdelfary/MainActivity:selectedSoundId	I
        //   46: aload_0
        //   47: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   50: invokestatic 51	com/guillefix/frasesdelfary/MainActivity:access$100	(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/content/res/Resources;
        //   53: aload_0
        //   54: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   57: getfield 43	com/guillefix/frasesdelfary/MainActivity:soundIds	[I
        //   60: iload_2
        //   61: iaload
        //   62: invokevirtual 57	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
        //   65: astore_1
        //   66: aload_0
        //   67: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   70: invokestatic 61	com/guillefix/frasesdelfary/MainActivity:access$200	(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;
        //   73: invokevirtual 66	android/media/MediaPlayer:reset	()V
        //   76: aload_0
        //   77: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   80: invokestatic 61	com/guillefix/frasesdelfary/MainActivity:access$200	(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;
        //   83: aload_1
        //   84: invokevirtual 72	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   87: aload_1
        //   88: invokevirtual 76	android/content/res/AssetFileDescriptor:getStartOffset	()J
        //   91: aload_1
        //   92: invokevirtual 79	android/content/res/AssetFileDescriptor:getLength	()J
        //   95: invokevirtual 83	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
        //   98: aload_0
        //   99: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   102: invokestatic 61	com/guillefix/frasesdelfary/MainActivity:access$200	(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;
        //   105: invokevirtual 86	android/media/MediaPlayer:prepare	()V
        //   108: aload_0
        //   109: getfield 17	com/guillefix/frasesdelfary/MainActivity$1:this$0	Lcom/guillefix/frasesdelfary/MainActivity;
        //   112: invokestatic 61	com/guillefix/frasesdelfary/MainActivity:access$200	(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;
        //   115: invokevirtual 89	android/media/MediaPlayer:start	()V
        //   118: return
        //   119: astore_1
        //   120: aload_1
        //   121: invokevirtual 92	java/lang/IllegalArgumentException:printStackTrace	()V
        //   124: goto -26 -> 98
        //   127: astore_1
        //   128: aload_1
        //   129: invokevirtual 93	java/lang/IllegalStateException:printStackTrace	()V
        //   132: goto -34 -> 98
        //   135: astore_1
        //   136: aload_1
        //   137: invokevirtual 94	java/io/IOException:printStackTrace	()V
        //   140: goto -42 -> 98
        //   143: astore_1
        //   144: aload_1
        //   145: invokevirtual 93	java/lang/IllegalStateException:printStackTrace	()V
        //   148: goto -40 -> 108
        //   151: astore_1
        //   152: aload_1
        //   153: invokevirtual 94	java/io/IOException:printStackTrace	()V
        //   156: goto -48 -> 108
        //   159: iload_2
        //   160: iconst_1
        //   161: iadd
        //   162: istore_2
        //   163: goto -161 -> 2
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	166	0	this	1
        //   0	166	1	paramAnonymousView	View
        //   1	162	2	i	int
        // Exception table:
        //   from	to	target	type
        //   76	98	119	java/lang/IllegalArgumentException
        //   76	98	127	java/lang/IllegalStateException
        //   76	98	135	java/io/IOException
        //   98	108	143	java/lang/IllegalStateException
        //   98	108	151	java/io/IOException
      }
    };
    View.OnLongClickListener local2 = new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        if ((ActivityCompat.checkSelfPermission(MainActivity.this, "android.permission.READ_EXTERNAL_STORAGE") != 0) || (ActivityCompat.checkSelfPermission(MainActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
          ActivityCompat.requestPermissions(MainActivity.this, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" }, 123);
        }
        label365:
        for (;;)
        {
          return false;
          int i = 0;
          for (;;)
          {
            if (i >= buttonIds.length) {
              break label365;
            }
            if (paramAnonymousView.getId() == buttonIds[i])
            {
              selectedSoundId = soundIds[i];
              Object localObject = getBaseContext().getResources().openRawResource(selectedSoundId);
              try
              {
                paramAnonymousView = new byte[((InputStream)localObject).available()];
                ((InputStream)localObject).read(paramAnonymousView);
                ((InputStream)localObject).close();
                localObject = getResources().getResourceEntryName(selectedSoundId) + ".mp3";
                if (!new File("/sdcard/media/audio/share/").exists()) {
                  new File("/sdcard/media/audio/share/").mkdirs();
                }
              }
              catch (IOException paramAnonymousView)
              {
                try
                {
                  FileOutputStream localFileOutputStream = new FileOutputStream("/sdcard/media/audio/share/" + (String)localObject);
                  localFileOutputStream.write(paramAnonymousView);
                  localFileOutputStream.flush();
                  localFileOutputStream.close();
                  sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + "/sdcard/media/audio/share/" + (String)localObject)));
                  paramAnonymousView = new Intent("android.intent.action.SEND");
                  paramAnonymousView.setType("audio/mp3");
                  paramAnonymousView.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + "/sdcard/media/audio/share/" + (String)localObject));
                  startActivity(Intent.createChooser(paramAnonymousView, "Enviar frase:"));
                }
                catch (FileNotFoundException paramAnonymousView)
                {
                  return false;
                }
                catch (IOException paramAnonymousView)
                {
                  return false;
                }
                paramAnonymousView = paramAnonymousView;
                return false;
              }
            }
            i += 1;
          }
        }
      }
    };
    int i = 0;
    while (i < buttonIds.length)
    {
      Button localButton = (Button)findViewById(buttonIds[i]);
      registerForContextMenu(localButton);
      localButton.setOnClickListener(paramBundle);
      localButton.setOnLongClickListener(local2);
      i += 1;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755008, paramMenu);
    ((SearchView)paramMenu.findItem(2131689656).getActionView()).setOnQueryTextListener(new SearchView.OnQueryTextListener()
    {
      private void buscarFrases(String paramAnonymousString)
      {
        int i = 0;
        if (i < buttonIds.length)
        {
          Button localButton = (Button)findViewById(buttonIds[i]);
          if (!localButton.getText().toString().toLowerCase().contains(paramAnonymousString.toLowerCase())) {
            localButton.setVisibility(8);
          }
          for (;;)
          {
            i += 1;
            break;
            localButton.setVisibility(0);
          }
        }
      }
      
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        buscarFrases(paramAnonymousString);
        return false;
      }
      
      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        buscarFrases(paramAnonymousString);
        return false;
      }
    });
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 2131689659)
    {
      paramMenuItem = new Intent("android.intent.action.SEND");
      paramMenuItem.setType("text/plain");
      paramMenuItem.putExtra("android.intent.extra.SUBJECT", "Compartir enlace a Play Store");
      paramMenuItem.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=com.guillefix.frasesdelfary");
      startActivity(Intent.createChooser(paramMenuItem, "Compartir enlace de la app"));
      return true;
    }
    Intent localIntent;
    if (i == 2131689660)
    {
      localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "fanchewbacca@gmail.com" });
      localIntent.putExtra("android.intent.extra.SUBJECT", "Frases del Fary");
      startActivity(Intent.createChooser(localIntent, ""));
    }
    if (i == 2131689658) {
      playRandomSound();
    }
    if (i == 2131689657) {
      showInstrucciones();
    }
    if (i == 2131689661) {
      randomYoutubeVideo();
    }
    if (i == 2131689662)
    {
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("market://details?id=com.guillefix.frasesdelfary"));
      startActivity(localIntent);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      Toast.makeText(getApplicationContext(), "Los permisos han sido concedidos", 1).show();
      return;
    }
    Toast.makeText(getApplicationContext(), "Los permisos no han sido concedidos", 1).show();
  }
  
  protected void onStop()
  {
    super.onStop();
    player.stop();
  }
}

package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
public class zzkl
  extends zzko
{
  private final Context mContext;
  private final Map<String, String> zzFs;
  
  public zzkl(zzqp paramZzqp, Map<String, String> paramMap)
  {
    super(paramZzqp, "storePicture");
    zzFs = paramMap;
    mContext = paramZzqp.zzkR();
  }
  
  public void execute()
  {
    if (mContext == null)
    {
      zzay("Activity context is not available");
      return;
    }
    if (!zzv.zzcJ().zzC(mContext).zzfi())
    {
      zzay("Feature is not supported by the device.");
      return;
    }
    final String str2 = (String)zzFs.get("iurl");
    if (TextUtils.isEmpty(str2))
    {
      zzay("Image url cannot be empty.");
      return;
    }
    if (!URLUtil.isValidUrl(str2))
    {
      str1 = String.valueOf(str2);
      if (str1.length() != 0) {}
      for (str1 = "Invalid image url: ".concat(str1);; str1 = new String("Invalid image url: "))
      {
        zzay(str1);
        return;
      }
    }
    final String str3 = zzax(str2);
    if (!zzv.zzcJ().zzaX(str3))
    {
      str1 = String.valueOf(str3);
      if (str1.length() != 0) {}
      for (str1 = "Image type not recognized: ".concat(str1);; str1 = new String("Image type not recognized: "))
      {
        zzay(str1);
        return;
      }
    }
    Resources localResources = zzv.zzcN().getResources();
    AlertDialog.Builder localBuilder = zzv.zzcJ().zzB(mContext);
    if (localResources != null)
    {
      str1 = localResources.getString(R.string.store_picture_title);
      localBuilder.setTitle(str1);
      if (localResources == null) {
        break label300;
      }
      str1 = localResources.getString(R.string.store_picture_message);
      label221:
      localBuilder.setMessage(str1);
      if (localResources == null) {
        break label306;
      }
      str1 = localResources.getString(R.string.accept);
      label241:
      localBuilder.setPositiveButton(str1, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = (DownloadManager)zzkl.zza(zzkl.this).getSystemService("download");
          try
          {
            paramAnonymousDialogInterface.enqueue(zzj(str2, str3));
            return;
          }
          catch (IllegalStateException paramAnonymousDialogInterface)
          {
            zzay("Could not store picture.");
          }
        }
      });
      if (localResources == null) {
        break label312;
      }
    }
    label300:
    label306:
    label312:
    for (String str1 = localResources.getString(R.string.decline);; str1 = "Decline")
    {
      localBuilder.setNegativeButton(str1, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zzay("User canceled the download.");
        }
      });
      localBuilder.create().show();
      return;
      str1 = "Save image";
      break;
      str1 = "Allow Ad to store image in Picture gallery?";
      break label221;
      str1 = "Accept";
      break label241;
    }
  }
  
  String zzax(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  DownloadManager.Request zzj(String paramString1, String paramString2)
  {
    paramString1 = new DownloadManager.Request(Uri.parse(paramString1));
    paramString1.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, paramString2);
    zzv.zzcL().zza(paramString1);
    return paramString1;
  }
}

package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
public class zzki
  extends zzko
{
  private final Context mContext;
  private final Map<String, String> zzFs;
  private String zzLk;
  private long zzLl;
  private long zzLm;
  private String zzLn;
  private String zzLo;
  
  public zzki(zzqp paramZzqp, Map<String, String> paramMap)
  {
    super(paramZzqp, "createCalendarEvent");
    zzFs = paramMap;
    mContext = paramZzqp.zzkR();
    zzgO();
  }
  
  private String zzav(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)zzFs.get(paramString))) {
      return "";
    }
    return (String)zzFs.get(paramString);
  }
  
  private long zzaw(String paramString)
  {
    paramString = (String)zzFs.get(paramString);
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  private void zzgO()
  {
    zzLk = zzav("description");
    zzLn = zzav("summary");
    zzLl = zzaw("start_ticks");
    zzLm = zzaw("end_ticks");
    zzLo = zzav("location");
  }
  
  @TargetApi(14)
  Intent createIntent()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", zzLk);
    localIntent.putExtra("eventLocation", zzLo);
    localIntent.putExtra("description", zzLn);
    if (zzLl > -1L) {
      localIntent.putExtra("beginTime", zzLl);
    }
    if (zzLm > -1L) {
      localIntent.putExtra("endTime", zzLm);
    }
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public void execute()
  {
    if (mContext == null)
    {
      zzay("Activity context is not available.");
      return;
    }
    if (!zzv.zzcJ().zzC(mContext).zzfk())
    {
      zzay("This feature is not available on the device.");
      return;
    }
    AlertDialog.Builder localBuilder = zzv.zzcJ().zzB(mContext);
    Resources localResources = zzv.zzcN().getResources();
    if (localResources != null)
    {
      str = localResources.getString(R.string.create_calendar_title);
      localBuilder.setTitle(str);
      if (localResources == null) {
        break label157;
      }
      str = localResources.getString(R.string.create_calendar_message);
      label85:
      localBuilder.setMessage(str);
      if (localResources == null) {
        break label163;
      }
      str = localResources.getString(R.string.accept);
      label103:
      localBuilder.setPositiveButton(str, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = createIntent();
          zzv.zzcJ().zzb(zzki.zza(zzki.this), paramAnonymousDialogInterface);
        }
      });
      if (localResources == null) {
        break label169;
      }
    }
    label157:
    label163:
    label169:
    for (String str = localResources.getString(R.string.decline);; str = "Decline")
    {
      localBuilder.setNegativeButton(str, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zzay("Operation denied by user.");
        }
      });
      localBuilder.create().show();
      return;
      str = "Create calendar event";
      break;
      str = "Allow Ad to create a calendar event?";
      break label85;
      str = "Accept";
      break label103;
    }
  }
}

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzpx;

@zzmb
public class zzp
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton zzNA;
  private final zzv zzNB;
  
  public zzp(Context paramContext, int paramInt, zzv paramZzv)
  {
    super(paramContext);
    zzNB = paramZzv;
    setOnClickListener(this);
    zzNA = new ImageButton(paramContext);
    zzNA.setImageResource(17301527);
    zzNA.setBackgroundColor(0);
    zzNA.setOnClickListener(this);
    zzNA.setPadding(0, 0, 0, 0);
    zzNA.setContentDescription("Interstitial close button");
    paramInt = zzeh.zzeO().zzb(paramContext, paramInt);
    addView(zzNA, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public void onClick(View paramView)
  {
    if (zzNB != null) {
      zzNB.zzhj();
    }
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        zzNA.setVisibility(4);
        return;
      }
      zzNA.setVisibility(8);
      return;
    }
    zzNA.setVisibility(0);
  }
}

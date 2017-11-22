package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.List;

@zzmb
class zzgn
  extends RelativeLayout
{
  private static final float[] zzFN = { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F };
  private final RelativeLayout zzFO;
  @Nullable
  private AnimationDrawable zzFP;
  
  public zzgn(Context paramContext, zzgm paramZzgm)
  {
    super(paramContext);
    zzac.zzw(paramZzgm);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    switch (paramZzgm.zzfI())
    {
    case 1: 
    default: 
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    }
    for (;;)
    {
      Object localObject2 = new ShapeDrawable(new RoundRectShape(zzFN, null, null));
      ((ShapeDrawable)localObject2).getPaint().setColor(paramZzgm.getBackgroundColor());
      zzFO = new RelativeLayout(paramContext);
      zzFO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      zzv.zzcL().zza(zzFO, (Drawable)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      if (!TextUtils.isEmpty(paramZzgm.getText()))
      {
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        TextView localTextView = new TextView(paramContext);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localTextView.setId(1195835393);
        localTextView.setTypeface(Typeface.DEFAULT);
        localTextView.setText(paramZzgm.getText());
        localTextView.setTextColor(paramZzgm.getTextColor());
        localTextView.setTextSize(paramZzgm.getTextSize());
        localTextView.setPadding(zzeh.zzeO().zzb(paramContext, 4), 0, zzeh.zzeO().zzb(paramContext, 4), 0);
        zzFO.addView(localTextView);
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, localTextView.getId());
      }
      paramContext = new ImageView(paramContext);
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramContext.setId(1195835394);
      localObject1 = paramZzgm.zzfG();
      if (((List)localObject1).size() <= 1) {
        break label432;
      }
      zzFP = new AnimationDrawable();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Drawable)((Iterator)localObject1).next();
        zzFP.addFrame((Drawable)localObject2, paramZzgm.zzfH());
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      continue;
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      continue;
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    }
    zzv.zzcL().zza(paramContext, zzFP);
    for (;;)
    {
      zzFO.addView(paramContext);
      addView(zzFO);
      return;
      label432:
      if (((List)localObject1).size() == 1) {
        paramContext.setImageDrawable((Drawable)((List)localObject1).get(0));
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    if (zzFP != null) {
      zzFP.start();
    }
    super.onAttachedToWindow();
  }
  
  public ViewGroup zzfJ()
  {
    return zzFO;
  }
}

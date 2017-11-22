package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.internal.zzak;
import com.google.android.gms.dynamic.zzg.zza;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mColor;
  private int mSize;
  private View zzaxs;
  private View.OnClickListener zzaxt = null;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zzb(paramContext, paramAttributeSet);
    setStyle(mSize, mColor);
  }
  
  private void zzaw(Context paramContext)
  {
    if (zzaxs != null) {
      removeView(zzaxs);
    }
    try
    {
      zzaxs = zzaj.zzd(paramContext, mSize, mColor);
      addView(zzaxs);
      zzaxs.setEnabled(isEnabled());
      zzaxs.setOnClickListener(this);
      return;
    }
    catch (zzg.zza localZza)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        zzaxs = zzc(paramContext, mSize, mColor);
      }
    }
  }
  
  private void zzb(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      mSize = paramContext.getInt(R.styleable.SignInButton_buttonSize, 0);
      mColor = paramContext.getInt(R.styleable.SignInButton_colorScheme, 2);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static Button zzc(Context paramContext, int paramInt1, int paramInt2)
  {
    zzak localZzak = new zzak(paramContext);
    localZzak.zza(paramContext.getResources(), paramInt1, paramInt2);
    return localZzak;
  }
  
  public void onClick(View paramView)
  {
    if ((zzaxt != null) && (paramView == zzaxs)) {
      zzaxt.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(mSize, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    zzaxs.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzaxt = paramOnClickListener;
    if (zzaxs != null) {
      zzaxs.setOnClickListener(this);
    }
  }
  
  @Deprecated
  public void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(mSize, mColor);
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, mColor);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    mSize = paramInt1;
    mColor = paramInt2;
    zzaw(getContext());
  }
  
  @Deprecated
  public void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ColorScheme {}
}

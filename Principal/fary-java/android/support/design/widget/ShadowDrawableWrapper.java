package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.R.color;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ShadowDrawableWrapper
  extends DrawableWrapper
{
  static final double COS_45 = Math.cos(Math.toRadians(45.0D));
  static final float SHADOW_BOTTOM_SCALE = 1.0F;
  static final float SHADOW_HORIZ_SCALE = 0.5F;
  static final float SHADOW_MULTIPLIER = 1.5F;
  static final float SHADOW_TOP_SCALE = 0.25F;
  private boolean mAddPaddingForCorners = true;
  final RectF mContentBounds;
  float mCornerRadius;
  final Paint mCornerShadowPaint;
  Path mCornerShadowPath;
  private boolean mDirty = true;
  final Paint mEdgeShadowPaint;
  float mMaxShadowSize;
  private boolean mPrintedShadowClipWarning = false;
  float mRawMaxShadowSize;
  float mRawShadowSize;
  private float mRotation;
  private final int mShadowEndColor;
  private final int mShadowMiddleColor;
  float mShadowSize;
  private final int mShadowStartColor;
  
  public ShadowDrawableWrapper(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    mShadowStartColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_start_color);
    mShadowMiddleColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_mid_color);
    mShadowEndColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_end_color);
    mCornerShadowPaint = new Paint(5);
    mCornerShadowPaint.setStyle(Paint.Style.FILL);
    mCornerRadius = Math.round(paramFloat1);
    mContentBounds = new RectF();
    mEdgeShadowPaint = new Paint(mCornerShadowPaint);
    mEdgeShadowPaint.setAntiAlias(false);
    setShadowSize(paramFloat2, paramFloat3);
  }
  
  private void buildComponents(Rect paramRect)
  {
    float f = mRawMaxShadowSize * 1.5F;
    mContentBounds.set(left + mRawMaxShadowSize, top + f, right - mRawMaxShadowSize, bottom - f);
    getWrappedDrawable().setBounds((int)mContentBounds.left, (int)mContentBounds.top, (int)mContentBounds.right, (int)mContentBounds.bottom);
    buildShadowCorners();
  }
  
  private void buildShadowCorners()
  {
    Object localObject = new RectF(-mCornerRadius, -mCornerRadius, mCornerRadius, mCornerRadius);
    RectF localRectF = new RectF((RectF)localObject);
    localRectF.inset(-mShadowSize, -mShadowSize);
    if (mCornerShadowPath == null) {
      mCornerShadowPath = new Path();
    }
    for (;;)
    {
      mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
      mCornerShadowPath.moveTo(-mCornerRadius, 0.0F);
      mCornerShadowPath.rLineTo(-mShadowSize, 0.0F);
      mCornerShadowPath.arcTo(localRectF, 180.0F, 90.0F, false);
      mCornerShadowPath.arcTo((RectF)localObject, 270.0F, -90.0F, false);
      mCornerShadowPath.close();
      float f1 = -top;
      if (f1 > 0.0F)
      {
        f2 = mCornerRadius / f1;
        float f3 = (1.0F - f2) / 2.0F;
        localPaint = mCornerShadowPaint;
        i = mShadowStartColor;
        j = mShadowMiddleColor;
        k = mShadowEndColor;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
      }
      Paint localPaint = mEdgeShadowPaint;
      f1 = top;
      float f2 = top;
      int i = mShadowStartColor;
      int j = mShadowMiddleColor;
      int k = mShadowEndColor;
      localObject = Shader.TileMode.CLAMP;
      localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
      mEdgeShadowPaint.setAntiAlias(false);
      return;
      mCornerShadowPath.reset();
    }
  }
  
  public static float calculateHorizontalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - COS_45) * paramFloat2);
    }
    return f;
  }
  
  public static float calculateVerticalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - COS_45) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    int k = paramCanvas.save();
    paramCanvas.rotate(mRotation, mContentBounds.centerX(), mContentBounds.centerY());
    float f1 = -mCornerRadius - mShadowSize;
    float f2 = mCornerRadius;
    int i;
    if (mContentBounds.width() - 2.0F * f2 > 0.0F)
    {
      i = 1;
      if (mContentBounds.height() - 2.0F * f2 <= 0.0F) {
        break label579;
      }
    }
    label579:
    for (int j = 1;; j = 0)
    {
      float f6 = mRawShadowSize;
      float f7 = mRawShadowSize;
      float f3 = mRawShadowSize;
      float f8 = mRawShadowSize;
      float f4 = mRawShadowSize;
      float f5 = mRawShadowSize;
      f3 = f2 / (f2 + (f3 - f8 * 0.5F));
      f6 = f2 / (f2 + (f6 - f7 * 0.25F));
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(mContentBounds.left + f2, mContentBounds.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, mContentBounds.width() - 2.0F * f2, -mCornerRadius, mEdgeShadowPaint);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(mContentBounds.right - f2, mContentBounds.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = mContentBounds.width();
        f7 = -mCornerRadius;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, mShadowSize + f7, mEdgeShadowPaint);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(mContentBounds.left + f2, mContentBounds.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, mContentBounds.height() - 2.0F * f2, -mCornerRadius, mEdgeShadowPaint);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(mContentBounds.right - f2, mContentBounds.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(mCornerShadowPath, mCornerShadowPaint);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, mContentBounds.height() - 2.0F * f2, -mCornerRadius, mEdgeShadowPaint);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      return;
      i = 0;
      break;
    }
  }
  
  private static int toEven(float paramFloat)
  {
    int j = Math.round(paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (mDirty)
    {
      buildComponents(getBounds());
      mDirty = false;
    }
    drawShadow(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public float getCornerRadius()
  {
    return mCornerRadius;
  }
  
  public float getMaxShadowSize()
  {
    return mRawMaxShadowSize;
  }
  
  public float getMinHeight()
  {
    float f = Math.max(mRawMaxShadowSize, mCornerRadius + mRawMaxShadowSize * 1.5F / 2.0F);
    return mRawMaxShadowSize * 1.5F * 2.0F + 2.0F * f;
  }
  
  public float getMinWidth()
  {
    float f = Math.max(mRawMaxShadowSize, mCornerRadius + mRawMaxShadowSize / 2.0F);
    return mRawMaxShadowSize * 2.0F + 2.0F * f;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(calculateVerticalPadding(mRawMaxShadowSize, mCornerRadius, mAddPaddingForCorners));
    int j = (int)Math.ceil(calculateHorizontalPadding(mRawMaxShadowSize, mCornerRadius, mAddPaddingForCorners));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public float getShadowSize()
  {
    return mRawShadowSize;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    mDirty = true;
  }
  
  public void setAddPaddingForCorners(boolean paramBoolean)
  {
    mAddPaddingForCorners = paramBoolean;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    mCornerShadowPaint.setAlpha(paramInt);
    mEdgeShadowPaint.setAlpha(paramInt);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    paramFloat = Math.round(paramFloat);
    if (mCornerRadius == paramFloat) {
      return;
    }
    mCornerRadius = paramFloat;
    mDirty = true;
    invalidateSelf();
  }
  
  public void setMaxShadowSize(float paramFloat)
  {
    setShadowSize(mRawShadowSize, paramFloat);
  }
  
  final void setRotation(float paramFloat)
  {
    if (mRotation != paramFloat)
    {
      mRotation = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setShadowSize(float paramFloat)
  {
    setShadowSize(paramFloat, mRawMaxShadowSize);
  }
  
  void setShadowSize(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F)) {
      throw new IllegalArgumentException("invalid shadow size");
    }
    float f1 = toEven(paramFloat1);
    float f2 = toEven(paramFloat2);
    paramFloat1 = f1;
    if (f1 > f2)
    {
      paramFloat2 = f2;
      paramFloat1 = paramFloat2;
      if (!mPrintedShadowClipWarning)
      {
        mPrintedShadowClipWarning = true;
        paramFloat1 = paramFloat2;
      }
    }
    if ((mRawShadowSize == paramFloat1) && (mRawMaxShadowSize == f2)) {
      return;
    }
    mRawShadowSize = paramFloat1;
    mRawMaxShadowSize = f2;
    mShadowSize = Math.round(1.5F * paramFloat1);
    mMaxShadowSize = f2;
    mDirty = true;
    invalidateSelf();
  }
}

package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int THUMB_ANIMATION_DURATION = 250;
  private static final int TOUCH_MODE_DOWN = 1;
  private static final int TOUCH_MODE_DRAGGING = 2;
  private static final int TOUCH_MODE_IDLE = 0;
  private boolean mHasThumbTint = false;
  private boolean mHasThumbTintMode = false;
  private boolean mHasTrackTint = false;
  private boolean mHasTrackTintMode = false;
  private int mMinFlingVelocity;
  private Layout mOffLayout;
  private Layout mOnLayout;
  ThumbAnimation mPositionAnimator;
  private boolean mShowText;
  private boolean mSplitTrack;
  private int mSwitchBottom;
  private int mSwitchHeight;
  private int mSwitchLeft;
  private int mSwitchMinWidth;
  private int mSwitchPadding;
  private int mSwitchRight;
  private int mSwitchTop;
  private TransformationMethod mSwitchTransformationMethod;
  private int mSwitchWidth;
  private final Rect mTempRect = new Rect();
  private ColorStateList mTextColors;
  private CharSequence mTextOff;
  private CharSequence mTextOn;
  private TextPaint mTextPaint = new TextPaint(1);
  private Drawable mThumbDrawable;
  private float mThumbPosition;
  private int mThumbTextPadding;
  private ColorStateList mThumbTintList = null;
  private PorterDuff.Mode mThumbTintMode = null;
  private int mThumbWidth;
  private int mTouchMode;
  private int mTouchSlop;
  private float mTouchX;
  private float mTouchY;
  private Drawable mTrackDrawable;
  private ColorStateList mTrackTintList = null;
  private PorterDuff.Mode mTrackTintMode = null;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    mTextPaint.density = getDisplayMetricsdensity;
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SwitchCompat, paramInt, 0);
    mThumbDrawable = paramAttributeSet.getDrawable(R.styleable.SwitchCompat_android_thumb);
    if (mThumbDrawable != null) {
      mThumbDrawable.setCallback(this);
    }
    mTrackDrawable = paramAttributeSet.getDrawable(R.styleable.SwitchCompat_track);
    if (mTrackDrawable != null) {
      mTrackDrawable.setCallback(this);
    }
    mTextOn = paramAttributeSet.getText(R.styleable.SwitchCompat_android_textOn);
    mTextOff = paramAttributeSet.getText(R.styleable.SwitchCompat_android_textOff);
    mShowText = paramAttributeSet.getBoolean(R.styleable.SwitchCompat_showText, true);
    mThumbTextPadding = paramAttributeSet.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    mSwitchMinWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    mSwitchPadding = paramAttributeSet.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    mSplitTrack = paramAttributeSet.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    localObject = paramAttributeSet.getColorStateList(R.styleable.SwitchCompat_thumbTint);
    if (localObject != null)
    {
      mThumbTintList = ((ColorStateList)localObject);
      mHasThumbTint = true;
    }
    localObject = DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
    if (mThumbTintMode != localObject)
    {
      mThumbTintMode = ((PorterDuff.Mode)localObject);
      mHasThumbTintMode = true;
    }
    if ((mHasThumbTint) || (mHasThumbTintMode)) {
      applyThumbTint();
    }
    localObject = paramAttributeSet.getColorStateList(R.styleable.SwitchCompat_trackTint);
    if (localObject != null)
    {
      mTrackTintList = ((ColorStateList)localObject);
      mHasTrackTint = true;
    }
    localObject = DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
    if (mTrackTintMode != localObject)
    {
      mTrackTintMode = ((PorterDuff.Mode)localObject);
      mHasTrackTintMode = true;
    }
    if ((mHasTrackTint) || (mHasTrackTintMode)) {
      applyTrackTint();
    }
    paramInt = paramAttributeSet.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (paramInt != 0) {
      setSwitchTextAppearance(paramContext, paramInt);
    }
    paramAttributeSet.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    mTouchSlop = paramContext.getScaledTouchSlop();
    mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private void animateThumbToCheckedState(final boolean paramBoolean)
  {
    if (mPositionAnimator != null) {
      cancelPositionAnimator();
    }
    float f2 = mThumbPosition;
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      mPositionAnimator = new ThumbAnimation(f2, f1);
      mPositionAnimator.setDuration(250L);
      mPositionAnimator.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (mPositionAnimator == paramAnonymousAnimation)
          {
            paramAnonymousAnimation = SwitchCompat.this;
            if (!paramBoolean) {
              break label39;
            }
          }
          label39:
          for (float f = 1.0F;; f = 0.0F)
          {
            paramAnonymousAnimation.setThumbPosition(f);
            mPositionAnimator = null;
            return;
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      startAnimation(mPositionAnimator);
      return;
    }
  }
  
  private void applyThumbTint()
  {
    if ((mThumbDrawable != null) && ((mHasThumbTint) || (mHasThumbTintMode)))
    {
      mThumbDrawable = mThumbDrawable.mutate();
      if (mHasThumbTint) {
        DrawableCompat.setTintList(mThumbDrawable, mThumbTintList);
      }
      if (mHasThumbTintMode) {
        DrawableCompat.setTintMode(mThumbDrawable, mThumbTintMode);
      }
      if (mThumbDrawable.isStateful()) {
        mThumbDrawable.setState(getDrawableState());
      }
    }
  }
  
  private void applyTrackTint()
  {
    if ((mTrackDrawable != null) && ((mHasTrackTint) || (mHasTrackTintMode)))
    {
      mTrackDrawable = mTrackDrawable.mutate();
      if (mHasTrackTint) {
        DrawableCompat.setTintList(mTrackDrawable, mTrackTintList);
      }
      if (mHasTrackTintMode) {
        DrawableCompat.setTintMode(mTrackDrawable, mTrackTintMode);
      }
      if (mTrackDrawable.isStateful()) {
        mTrackDrawable.setState(getDrawableState());
      }
    }
  }
  
  private void cancelPositionAnimator()
  {
    if (mPositionAnimator != null)
    {
      clearAnimation();
      mPositionAnimator = null;
    }
  }
  
  private void cancelSuperTouch(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private boolean getTargetCheckedState()
  {
    return mThumbPosition > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (ViewUtils.isLayoutRtl(this)) {}
    for (float f = 1.0F - mThumbPosition;; f = mThumbPosition) {
      return (int)(getThumbScrollRange() * f + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (mTrackDrawable != null)
    {
      Rect localRect2 = mTempRect;
      mTrackDrawable.getPadding(localRect2);
      if (mThumbDrawable != null) {}
      for (Rect localRect1 = DrawableUtils.getOpticalBounds(mThumbDrawable);; localRect1 = DrawableUtils.INSETS_NONE) {
        return mSwitchWidth - mThumbWidth - left - right - left - right;
      }
    }
    return 0;
  }
  
  private boolean hitThumb(float paramFloat1, float paramFloat2)
  {
    if (mThumbDrawable == null) {}
    int k;
    int i;
    int j;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      return false;
      k = getThumbOffset();
      mThumbDrawable.getPadding(mTempRect);
      i = mSwitchTop;
      j = mTouchSlop;
      k = mSwitchLeft + k - mTouchSlop;
      m = mThumbWidth;
      n = mTempRect.left;
      i1 = mTempRect.right;
      i2 = mTouchSlop;
      i3 = mSwitchBottom;
      i4 = mTouchSlop;
    } while ((paramFloat1 <= k) || (paramFloat1 >= m + k + n + i1 + i2) || (paramFloat2 <= i - j) || (paramFloat2 >= i3 + i4));
    return true;
  }
  
  private Layout makeLayout(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (mSwitchTransformationMethod != null)
    {
      paramCharSequence = mSwitchTransformationMethod.getTransformation(paramCharSequence, this);
      localTextPaint = mTextPaint;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, mTextPaint));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  private void setSwitchTypefaceByIndex(int paramInt1, int paramInt2)
  {
    Typeface localTypeface = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setSwitchTypeface(localTypeface, paramInt2);
      return;
      localTypeface = Typeface.SANS_SERIF;
      continue;
      localTypeface = Typeface.SERIF;
      continue;
      localTypeface = Typeface.MONOSPACE;
    }
  }
  
  private void stopDrag(MotionEvent paramMotionEvent)
  {
    mTouchMode = 0;
    int i;
    boolean bool2;
    float f;
    boolean bool1;
    if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
    {
      i = 1;
      bool2 = isChecked();
      if (i == 0) {
        break label141;
      }
      mVelocityTracker.computeCurrentVelocity(1000);
      f = mVelocityTracker.getXVelocity();
      if (Math.abs(f) <= mMinFlingVelocity) {
        break label132;
      }
      if (!ViewUtils.isLayoutRtl(this)) {
        break label114;
      }
      if (f >= 0.0F) {
        break label108;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1 != bool2) {
        playSoundEffect(0);
      }
      setChecked(bool1);
      cancelSuperTouch(paramMotionEvent);
      return;
      i = 0;
      break;
      label108:
      bool1 = false;
      continue;
      label114:
      if (f > 0.0F)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
        continue;
        label132:
        bool1 = getTargetCheckedState();
        continue;
        label141:
        bool1 = bool2;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = mTempRect;
    int m = mSwitchLeft;
    int i5 = mSwitchTop;
    int j = mSwitchRight;
    int i6 = mSwitchBottom;
    int k = m + getThumbOffset();
    if (mThumbDrawable != null) {}
    for (Object localObject = DrawableUtils.getOpticalBounds(mThumbDrawable);; localObject = DrawableUtils.INSETS_NONE)
    {
      int i = k;
      if (mTrackDrawable != null)
      {
        mTrackDrawable.getPadding(localRect);
        int i7 = k + left;
        k = i5;
        int n = i6;
        int i4 = n;
        int i1 = m;
        int i2 = j;
        int i3 = k;
        if (localObject != null)
        {
          i = m;
          if (left > left) {
            i = m + (left - left);
          }
          m = k;
          if (top > top) {
            m = k + (top - top);
          }
          k = j;
          if (right > right) {
            k = j - (right - right);
          }
          i4 = n;
          i1 = i;
          i2 = k;
          i3 = m;
          if (bottom > bottom)
          {
            i4 = n - (bottom - bottom);
            i3 = m;
            i2 = k;
            i1 = i;
          }
        }
        mTrackDrawable.setBounds(i1, i3, i2, i4);
        i = i7;
      }
      if (mThumbDrawable != null)
      {
        mThumbDrawable.getPadding(localRect);
        j = i - left;
        i = mThumbWidth + i + right;
        mThumbDrawable.setBounds(j, i5, i, i6);
        localObject = getBackground();
        if (localObject != null) {
          DrawableCompat.setHotspotBounds((Drawable)localObject, j, i5, i, i6);
        }
      }
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (mThumbDrawable != null) {
      DrawableCompat.setHotspot(mThumbDrawable, paramFloat1, paramFloat2);
    }
    if (mTrackDrawable != null) {
      DrawableCompat.setHotspot(mTrackDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = mThumbDrawable;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    localDrawable = mTrackDrawable;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int i;
    if (!ViewUtils.isLayoutRtl(this)) {
      i = super.getCompoundPaddingLeft();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingLeft() + mSwitchWidth;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + mSwitchPadding;
  }
  
  public int getCompoundPaddingRight()
  {
    int i;
    if (ViewUtils.isLayoutRtl(this)) {
      i = super.getCompoundPaddingRight();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingRight() + mSwitchWidth;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + mSwitchPadding;
  }
  
  public boolean getShowText()
  {
    return mShowText;
  }
  
  public boolean getSplitTrack()
  {
    return mSplitTrack;
  }
  
  public int getSwitchMinWidth()
  {
    return mSwitchMinWidth;
  }
  
  public int getSwitchPadding()
  {
    return mSwitchPadding;
  }
  
  public CharSequence getTextOff()
  {
    return mTextOff;
  }
  
  public CharSequence getTextOn()
  {
    return mTextOn;
  }
  
  public Drawable getThumbDrawable()
  {
    return mThumbDrawable;
  }
  
  public int getThumbTextPadding()
  {
    return mThumbTextPadding;
  }
  
  @Nullable
  public ColorStateList getThumbTintList()
  {
    return mThumbTintList;
  }
  
  @Nullable
  public PorterDuff.Mode getThumbTintMode()
  {
    return mThumbTintMode;
  }
  
  public Drawable getTrackDrawable()
  {
    return mTrackDrawable;
  }
  
  @Nullable
  public ColorStateList getTrackTintList()
  {
    return mTrackTintList;
  }
  
  @Nullable
  public PorterDuff.Mode getTrackTintMode()
  {
    return mTrackTintMode;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.jumpDrawablesToCurrentState();
      if (mThumbDrawable != null) {
        mThumbDrawable.jumpToCurrentState();
      }
      if (mTrackDrawable != null) {
        mTrackDrawable.jumpToCurrentState();
      }
      cancelPositionAnimator();
      if (!isChecked()) {
        break label59;
      }
    }
    label59:
    for (float f = 1.0F;; f = 0.0F)
    {
      setThumbPosition(f);
      return;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = mTempRect;
    Object localObject3 = mTrackDrawable;
    int k;
    int m;
    int n;
    int i1;
    Object localObject2;
    label151:
    int j;
    if (localObject3 != null)
    {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
      k = mSwitchTop;
      m = mSwitchBottom;
      n = top;
      i1 = bottom;
      localObject2 = mThumbDrawable;
      if (localObject3 != null)
      {
        if ((!mSplitTrack) || (localObject2 == null)) {
          break label320;
        }
        Rect localRect = DrawableUtils.getOpticalBounds((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        left += left;
        right -= right;
        i = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      }
      j = paramCanvas.save();
      if (localObject2 != null) {
        ((Drawable)localObject2).draw(paramCanvas);
      }
      if (!getTargetCheckedState()) {
        break label329;
      }
      localObject1 = mOnLayout;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (mTextColors != null) {
          mTextPaint.setColor(mTextColors.getColorForState((int[])localObject3, 0));
        }
        mTextPaint.drawableState = ((int[])localObject3);
        if (localObject2 == null) {
          break label338;
        }
        localObject2 = ((Drawable)localObject2).getBounds();
      }
    }
    label320:
    label329:
    label338:
    for (int i = left + right;; i = getWidth())
    {
      i /= 2;
      int i2 = ((Layout)localObject1).getWidth() / 2;
      k = (k + n + (m - i1)) / 2;
      m = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i - i2, k - m);
      ((Layout)localObject1).draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      return;
      ((Rect)localObject1).setEmpty();
      break;
      ((Drawable)localObject3).draw(paramCanvas);
      break label151;
      localObject1 = mOffLayout;
      break label180;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
      if (!isChecked()) {
        break label56;
      }
    }
    CharSequence localCharSequence2;
    label56:
    for (CharSequence localCharSequence1 = mTextOn;; localCharSequence1 = mTextOff)
    {
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (!TextUtils.isEmpty(localCharSequence2)) {
          break;
        }
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
    paramAccessibilityNodeInfo.setText(localStringBuilder);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    paramInt2 = 0;
    Rect localRect1;
    if (mThumbDrawable != null)
    {
      localRect1 = mTempRect;
      if (mTrackDrawable != null)
      {
        mTrackDrawable.getPadding(localRect1);
        Rect localRect2 = DrawableUtils.getOpticalBounds(mThumbDrawable);
        paramInt1 = Math.max(0, left - left);
        paramInt2 = Math.max(0, right - right);
      }
    }
    else
    {
      if (!ViewUtils.isLayoutRtl(this)) {
        break label191;
      }
      paramInt3 = getPaddingLeft() + paramInt1;
      paramInt4 = mSwitchWidth + paramInt3 - paramInt1 - paramInt2;
      label114:
      switch (getGravity() & 0x70)
      {
      default: 
        paramInt2 = getPaddingTop();
        paramInt1 = paramInt2 + mSwitchHeight;
      }
    }
    for (;;)
    {
      mSwitchLeft = paramInt3;
      mSwitchTop = paramInt2;
      mSwitchBottom = paramInt1;
      mSwitchRight = paramInt4;
      return;
      localRect1.setEmpty();
      break;
      label191:
      paramInt4 = getWidth() - getPaddingRight() - paramInt2;
      paramInt3 = paramInt4 - mSwitchWidth + paramInt1 + paramInt2;
      break label114;
      paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - mSwitchHeight / 2;
      paramInt1 = paramInt2 + mSwitchHeight;
      continue;
      paramInt1 = getHeight() - getPaddingBottom();
      paramInt2 = paramInt1 - mSwitchHeight;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (mShowText)
    {
      if (mOnLayout == null) {
        mOnLayout = makeLayout(mTextOn);
      }
      if (mOffLayout == null) {
        mOffLayout = makeLayout(mTextOff);
      }
    }
    Rect localRect = mTempRect;
    int i;
    int k;
    if (mThumbDrawable != null)
    {
      mThumbDrawable.getPadding(localRect);
      j = mThumbDrawable.getIntrinsicWidth() - left - right;
      i = mThumbDrawable.getIntrinsicHeight();
      if (!mShowText) {
        break label300;
      }
      k = Math.max(mOnLayout.getWidth(), mOffLayout.getWidth()) + mThumbTextPadding * 2;
      label130:
      mThumbWidth = Math.max(k, j);
      if (mTrackDrawable == null) {
        break label306;
      }
      mTrackDrawable.getPadding(localRect);
    }
    for (int j = mTrackDrawable.getIntrinsicHeight();; j = 0)
    {
      int i1 = left;
      int n = right;
      int m = i1;
      k = n;
      if (mThumbDrawable != null)
      {
        localRect = DrawableUtils.getOpticalBounds(mThumbDrawable);
        m = Math.max(i1, left);
        k = Math.max(n, right);
      }
      k = Math.max(mSwitchMinWidth, mThumbWidth * 2 + m + k);
      i = Math.max(j, i);
      mSwitchWidth = k;
      mSwitchHeight = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i) {
        setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), i);
      }
      return;
      j = 0;
      i = 0;
      break;
      label300:
      k = 0;
      break label130;
      label306:
      localRect.setEmpty();
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = mTextOn;; localCharSequence = mTextOff)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((isEnabled()) && (hitThumb(f1, f2)))
      {
        mTouchMode = 1;
        mTouchX = f1;
        mTouchY = f2;
        continue;
        switch (mTouchMode)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - mTouchX) > mTouchSlop) || (Math.abs(f2 - mTouchY) > mTouchSlop))
          {
            mTouchMode = 2;
            getParent().requestDisallowInterceptTouchEvent(true);
            mTouchX = f1;
            mTouchY = f2;
            return true;
          }
          break;
        case 2: 
          float f3 = paramMotionEvent.getX();
          int i = getThumbScrollRange();
          f1 = f3 - mTouchX;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (ViewUtils.isLayoutRtl(this)) {
              f2 = -f1;
            }
            f1 = constrain(mThumbPosition + f2, 0.0F, 1.0F);
            if (f1 != mThumbPosition)
            {
              mTouchX = f3;
              setThumbPosition(f1);
            }
            return true;
          }
          if (f1 > 0.0F) {}
          for (f1 = 1.0F;; f1 = -1.0F) {
            break;
          }
          if (mTouchMode == 2)
          {
            stopDrag(paramMotionEvent);
            super.onTouchEvent(paramMotionEvent);
            return true;
          }
          mTouchMode = 0;
          mVelocityTracker.clear();
        }
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (isShown()))
    {
      animateThumbToCheckedState(paramBoolean);
      return;
    }
    cancelPositionAnimator();
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      setThumbPosition(f);
      return;
    }
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (mShowText != paramBoolean)
    {
      mShowText = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    mSplitTrack = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    mSwitchMinWidth = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    mSwitchPadding = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    ColorStateList localColorStateList = paramContext.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (localColorStateList != null)
    {
      mTextColors = localColorStateList;
      paramInt = paramContext.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
      if ((paramInt != 0) && (paramInt != mTextPaint.getTextSize()))
      {
        mTextPaint.setTextSize(paramInt);
        requestLayout();
      }
      setSwitchTypefaceByIndex(paramContext.getInt(R.styleable.TextAppearance_android_typeface, -1), paramContext.getInt(R.styleable.TextAppearance_android_textStyle, -1));
      if (!paramContext.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
        break label127;
      }
    }
    label127:
    for (mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());; mSwitchTransformationMethod = null)
    {
      paramContext.recycle();
      return;
      mTextColors = getTextColors();
      break;
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (mTextPaint.getTypeface() != paramTypeface)
    {
      mTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    if (paramInt > 0)
    {
      int i;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setSwitchTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label88;
        }
        i = paramTypeface.getStyle();
        label31:
        paramInt &= (i ^ 0xFFFFFFFF);
        paramTypeface = mTextPaint;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = mTextPaint;
        if ((paramInt & 0x2) == 0) {
          break label94;
        }
      }
      label88:
      label94:
      for (float f = -0.25F;; f = 0.0F)
      {
        paramTypeface.setTextSkewX(f);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i = 0;
        break label31;
      }
    }
    mTextPaint.setFakeBoldText(false);
    mTextPaint.setTextSkewX(0.0F);
    setSwitchTypeface(paramTypeface);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    mTextOff = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    mTextOn = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (mThumbDrawable != null) {
      mThumbDrawable.setCallback(null);
    }
    mThumbDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    mThumbPosition = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    mThumbTextPadding = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(@Nullable ColorStateList paramColorStateList)
  {
    mThumbTintList = paramColorStateList;
    mHasThumbTint = true;
    applyThumbTint();
  }
  
  public void setThumbTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    mThumbTintMode = paramMode;
    mHasThumbTintMode = true;
    applyThumbTint();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (mTrackDrawable != null) {
      mTrackDrawable.setCallback(null);
    }
    mTrackDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setTrackTintList(@Nullable ColorStateList paramColorStateList)
  {
    mTrackTintList = paramColorStateList;
    mHasTrackTint = true;
    applyTrackTint();
  }
  
  public void setTrackTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    mTrackTintMode = paramMode;
    mHasTrackTintMode = true;
    applyTrackTint();
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mThumbDrawable) || (paramDrawable == mTrackDrawable);
  }
  
  private class ThumbAnimation
    extends Animation
  {
    final float mDiff;
    final float mEndPosition;
    final float mStartPosition;
    
    ThumbAnimation(float paramFloat1, float paramFloat2)
    {
      mStartPosition = paramFloat1;
      mEndPosition = paramFloat2;
      mDiff = (paramFloat2 - paramFloat1);
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      setThumbPosition(mStartPosition + mDiff * paramFloat);
    }
  }
}

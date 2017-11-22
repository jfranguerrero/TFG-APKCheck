package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.VisibleForTesting;
import android.support.design.R.color;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.string;
import android.support.design.R.styleable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintTypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class TextInputLayout
  extends LinearLayout
{
  private static final int ANIMATION_DURATION = 200;
  private static final int INVALID_MAX_LENGTH = -1;
  private static final String LOG_TAG = "TextInputLayout";
  private ValueAnimatorCompat mAnimator;
  final CollapsingTextHelper mCollapsingTextHelper = new CollapsingTextHelper(this);
  boolean mCounterEnabled;
  private int mCounterMaxLength;
  private int mCounterOverflowTextAppearance;
  private boolean mCounterOverflowed;
  private int mCounterTextAppearance;
  private TextView mCounterView;
  private ColorStateList mDefaultTextColor;
  EditText mEditText;
  private CharSequence mError;
  private boolean mErrorEnabled;
  private boolean mErrorShown;
  private int mErrorTextAppearance;
  TextView mErrorView;
  private ColorStateList mFocusedTextColor;
  private boolean mHasPasswordToggleTintList;
  private boolean mHasPasswordToggleTintMode;
  private boolean mHasReconstructedEditTextBackground;
  private CharSequence mHint;
  private boolean mHintAnimationEnabled;
  private boolean mHintEnabled;
  private boolean mHintExpanded;
  private boolean mInDrawableStateChanged;
  private LinearLayout mIndicatorArea;
  private int mIndicatorsAdded;
  private final FrameLayout mInputFrame;
  private Drawable mOriginalEditTextEndDrawable;
  private CharSequence mPasswordToggleContentDesc;
  private Drawable mPasswordToggleDrawable;
  private Drawable mPasswordToggleDummyDrawable;
  private boolean mPasswordToggleEnabled;
  private ColorStateList mPasswordToggleTintList;
  private PorterDuff.Mode mPasswordToggleTintMode;
  private CheckableImageButton mPasswordToggleView;
  private boolean mPasswordToggledVisible;
  private boolean mRestoringSavedState;
  private Paint mTmpPaint;
  private final Rect mTmpRect = new Rect();
  private Typeface mTypeface;
  
  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    ThemeUtils.checkAppCompatTheme(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    mInputFrame = new FrameLayout(paramContext);
    mInputFrame.setAddStatesFromChildren(true);
    addView(mInputFrame);
    mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
    mCollapsingTextHelper.setCollapsedTextGravity(8388659);
    if (mCollapsingTextHelper.getExpansionFraction() == 1.0F) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      mHintExpanded = bool1;
      paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.TextInputLayout, paramInt, android.support.design.R.style.Widget_Design_TextInputLayout);
      mHintEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
      setHint(paramContext.getText(R.styleable.TextInputLayout_android_hint));
      mHintAnimationEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
      if (paramContext.hasValue(R.styleable.TextInputLayout_android_textColorHint))
      {
        paramAttributeSet = paramContext.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
        mFocusedTextColor = paramAttributeSet;
        mDefaultTextColor = paramAttributeSet;
      }
      if (paramContext.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
        setHintTextAppearance(paramContext.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
      }
      mErrorTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
      bool1 = paramContext.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
      boolean bool2 = paramContext.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
      setCounterMaxLength(paramContext.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
      mCounterTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
      mCounterOverflowTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
      mPasswordToggleEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false);
      mPasswordToggleDrawable = paramContext.getDrawable(R.styleable.TextInputLayout_passwordToggleDrawable);
      mPasswordToggleContentDesc = paramContext.getText(R.styleable.TextInputLayout_passwordToggleContentDescription);
      if (paramContext.hasValue(R.styleable.TextInputLayout_passwordToggleTint))
      {
        mHasPasswordToggleTintList = true;
        mPasswordToggleTintList = paramContext.getColorStateList(R.styleable.TextInputLayout_passwordToggleTint);
      }
      if (paramContext.hasValue(R.styleable.TextInputLayout_passwordToggleTintMode))
      {
        mHasPasswordToggleTintMode = true;
        mPasswordToggleTintMode = ViewUtils.parseTintMode(paramContext.getInt(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
      }
      paramContext.recycle();
      setErrorEnabled(bool1);
      setCounterEnabled(bool2);
      applyPasswordToggleTint();
      if (ViewCompat.getImportantForAccessibility(this) == 0) {
        ViewCompat.setImportantForAccessibility(this, 1);
      }
      ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate());
      return;
    }
  }
  
  private void addIndicator(TextView paramTextView, int paramInt)
  {
    if (mIndicatorArea == null)
    {
      mIndicatorArea = new LinearLayout(getContext());
      mIndicatorArea.setOrientation(0);
      addView(mIndicatorArea, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      mIndicatorArea.addView(localSpace, localLayoutParams);
      if (mEditText != null) {
        adjustIndicatorPadding();
      }
    }
    mIndicatorArea.setVisibility(0);
    mIndicatorArea.addView(paramTextView, paramInt);
    mIndicatorsAdded += 1;
  }
  
  private void adjustIndicatorPadding()
  {
    ViewCompat.setPaddingRelative(mIndicatorArea, ViewCompat.getPaddingStart(mEditText), 0, ViewCompat.getPaddingEnd(mEditText), mEditText.getPaddingBottom());
  }
  
  private void applyPasswordToggleTint()
  {
    if ((mPasswordToggleDrawable != null) && ((mHasPasswordToggleTintList) || (mHasPasswordToggleTintMode)))
    {
      mPasswordToggleDrawable = DrawableCompat.wrap(mPasswordToggleDrawable).mutate();
      if (mHasPasswordToggleTintList) {
        DrawableCompat.setTintList(mPasswordToggleDrawable, mPasswordToggleTintList);
      }
      if (mHasPasswordToggleTintMode) {
        DrawableCompat.setTintMode(mPasswordToggleDrawable, mPasswordToggleTintMode);
      }
      if ((mPasswordToggleView != null) && (mPasswordToggleView.getDrawable() != mPasswordToggleDrawable)) {
        mPasswordToggleView.setImageDrawable(mPasswordToggleDrawable);
      }
    }
  }
  
  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void collapseHint(boolean paramBoolean)
  {
    if ((mAnimator != null) && (mAnimator.isRunning())) {
      mAnimator.cancel();
    }
    if ((paramBoolean) && (mHintAnimationEnabled)) {
      animateToExpansionFraction(1.0F);
    }
    for (;;)
    {
      mHintExpanded = false;
      return;
      mCollapsingTextHelper.setExpansionFraction(1.0F);
    }
  }
  
  private void ensureBackgroundDrawableStateWorkaround()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22)) {}
    Drawable localDrawable2;
    do
    {
      Drawable localDrawable1;
      do
      {
        return;
        localDrawable1 = mEditText.getBackground();
      } while ((localDrawable1 == null) || (mHasReconstructedEditTextBackground));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (mHasReconstructedEditTextBackground);
    ViewCompat.setBackground(mEditText, localDrawable2);
    mHasReconstructedEditTextBackground = true;
  }
  
  private void expandHint(boolean paramBoolean)
  {
    if ((mAnimator != null) && (mAnimator.isRunning())) {
      mAnimator.cancel();
    }
    if ((paramBoolean) && (mHintAnimationEnabled)) {
      animateToExpansionFraction(0.0F);
    }
    for (;;)
    {
      mHintExpanded = true;
      return;
      mCollapsingTextHelper.setExpansionFraction(0.0F);
    }
  }
  
  private boolean hasPasswordTransformation()
  {
    return (mEditText != null) && ((mEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private static void recursiveSetEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = 0;
    int j = paramViewGroup.getChildCount();
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        recursiveSetEnabled((ViewGroup)localView, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void removeIndicator(TextView paramTextView)
  {
    if (mIndicatorArea != null)
    {
      mIndicatorArea.removeView(paramTextView);
      int i = mIndicatorsAdded - 1;
      mIndicatorsAdded = i;
      if (i == 0) {
        mIndicatorArea.setVisibility(8);
      }
    }
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (mEditText != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    if (!(paramEditText instanceof TextInputEditText)) {
      Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
    }
    mEditText = paramEditText;
    if (!hasPasswordTransformation()) {
      mCollapsingTextHelper.setTypefaces(mEditText.getTypeface());
    }
    mCollapsingTextHelper.setExpandedTextSize(mEditText.getTextSize());
    int i = mEditText.getGravity();
    mCollapsingTextHelper.setCollapsedTextGravity(i & 0xFFFFFF8F | 0x30);
    mCollapsingTextHelper.setExpandedTextGravity(i);
    mEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout localTextInputLayout = TextInputLayout.this;
        if (!mRestoringSavedState) {}
        for (boolean bool = true;; bool = false)
        {
          localTextInputLayout.updateLabelState(bool);
          if (mCounterEnabled) {
            updateCounter(paramAnonymousEditable.length());
          }
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (mDefaultTextColor == null) {
      mDefaultTextColor = mEditText.getHintTextColors();
    }
    if ((mHintEnabled) && (TextUtils.isEmpty(mHint)))
    {
      setHint(mEditText.getHint());
      mEditText.setHint(null);
    }
    if (mCounterView != null) {
      updateCounter(mEditText.getText().length());
    }
    if (mIndicatorArea != null) {
      adjustIndicatorPadding();
    }
    updatePasswordToggleView();
    updateLabelState(false);
  }
  
  private void setError(@Nullable final CharSequence paramCharSequence, boolean paramBoolean)
  {
    boolean bool = true;
    mError = paramCharSequence;
    if (!mErrorEnabled)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      mErrorShown = bool;
      ViewCompat.animate(mErrorView).cancel();
      if (!mErrorShown) {
        break label159;
      }
      mErrorView.setText(paramCharSequence);
      mErrorView.setVisibility(0);
      if (!paramBoolean) {
        break label148;
      }
      if (ViewCompat.getAlpha(mErrorView) == 1.0F) {
        ViewCompat.setAlpha(mErrorView, 0.0F);
      }
      ViewCompat.animate(mErrorView).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        public void onAnimationStart(View paramAnonymousView)
        {
          paramAnonymousView.setVisibility(0);
        }
      }).start();
    }
    for (;;)
    {
      updateEditTextBackground();
      updateLabelState(paramBoolean);
      return;
      bool = false;
      break;
      label148:
      ViewCompat.setAlpha(mErrorView, 1.0F);
      continue;
      label159:
      if (mErrorView.getVisibility() == 0) {
        if (paramBoolean)
        {
          ViewCompat.animate(mErrorView).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter()
          {
            public void onAnimationEnd(View paramAnonymousView)
            {
              mErrorView.setText(paramCharSequence);
              paramAnonymousView.setVisibility(4);
            }
          }).start();
        }
        else
        {
          mErrorView.setText(paramCharSequence);
          mErrorView.setVisibility(4);
        }
      }
    }
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    mHint = paramCharSequence;
    mCollapsingTextHelper.setText(paramCharSequence);
  }
  
  private boolean shouldShowPasswordIcon()
  {
    return (mPasswordToggleEnabled) && ((hasPasswordTransformation()) || (mPasswordToggledVisible));
  }
  
  private void updateEditTextBackground()
  {
    if (mEditText == null) {}
    Drawable localDrawable2;
    do
    {
      return;
      localDrawable2 = mEditText.getBackground();
    } while (localDrawable2 == null);
    ensureBackgroundDrawableStateWorkaround();
    Drawable localDrawable1 = localDrawable2;
    if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if ((mErrorShown) && (mErrorView != null))
    {
      localDrawable1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(mErrorView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((mCounterOverflowed) && (mCounterView != null))
    {
      localDrawable1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(mCounterView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    DrawableCompat.clearColorFilter(localDrawable1);
    mEditText.refreshDrawableState();
  }
  
  private void updateInputLayoutMargins()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)mInputFrame.getLayoutParams();
    if (mHintEnabled)
    {
      if (mTmpPaint == null) {
        mTmpPaint = new Paint();
      }
      mTmpPaint.setTypeface(mCollapsingTextHelper.getCollapsedTypeface());
      mTmpPaint.setTextSize(mCollapsingTextHelper.getCollapsedTextSize());
    }
    for (int i = (int)-mTmpPaint.ascent();; i = 0)
    {
      if (i != topMargin)
      {
        topMargin = i;
        mInputFrame.requestLayout();
      }
      return;
    }
  }
  
  private void updatePasswordToggleView()
  {
    if (mEditText == null) {}
    Drawable[] arrayOfDrawable;
    do
    {
      do
      {
        return;
        if (shouldShowPasswordIcon())
        {
          if (mPasswordToggleView == null)
          {
            mPasswordToggleView = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, mInputFrame, false));
            mPasswordToggleView.setImageDrawable(mPasswordToggleDrawable);
            mPasswordToggleView.setContentDescription(mPasswordToggleContentDesc);
            mInputFrame.addView(mPasswordToggleView);
            mPasswordToggleView.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymousView)
              {
                passwordVisibilityToggleRequested();
              }
            });
          }
          mPasswordToggleView.setVisibility(0);
          mPasswordToggleView.setChecked(mPasswordToggledVisible);
          if (mPasswordToggleDummyDrawable == null) {
            mPasswordToggleDummyDrawable = new ColorDrawable();
          }
          mPasswordToggleDummyDrawable.setBounds(0, 0, mPasswordToggleView.getMeasuredWidth(), 1);
          arrayOfDrawable = TextViewCompat.getCompoundDrawablesRelative(mEditText);
          if (arrayOfDrawable[2] != mPasswordToggleDummyDrawable) {
            mOriginalEditTextEndDrawable = arrayOfDrawable[2];
          }
          TextViewCompat.setCompoundDrawablesRelative(mEditText, arrayOfDrawable[0], arrayOfDrawable[1], mPasswordToggleDummyDrawable, arrayOfDrawable[3]);
          mPasswordToggleView.setPadding(mEditText.getPaddingLeft(), mEditText.getPaddingTop(), mEditText.getPaddingRight(), mEditText.getPaddingBottom());
          return;
        }
        if ((mPasswordToggleView != null) && (mPasswordToggleView.getVisibility() == 0)) {
          mPasswordToggleView.setVisibility(8);
        }
      } while (mPasswordToggleDummyDrawable == null);
      arrayOfDrawable = TextViewCompat.getCompoundDrawablesRelative(mEditText);
    } while (arrayOfDrawable[2] != mPasswordToggleDummyDrawable);
    TextViewCompat.setCompoundDrawablesRelative(mEditText, arrayOfDrawable[0], arrayOfDrawable[1], mOriginalEditTextEndDrawable, arrayOfDrawable[3]);
    mPasswordToggleDummyDrawable = null;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      gravity = (gravity & 0xFFFFFF8F | 0x10);
      mInputFrame.addView(paramView, localLayoutParams);
      mInputFrame.setLayoutParams(paramLayoutParams);
      updateInputLayoutMargins();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  @VisibleForTesting
  void animateToExpansionFraction(float paramFloat)
  {
    if (mCollapsingTextHelper.getExpansionFraction() == paramFloat) {
      return;
    }
    if (mAnimator == null)
    {
      mAnimator = ViewUtils.createAnimator();
      mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
      mAnimator.setDuration(200L);
      mAnimator.addUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
        {
          mCollapsingTextHelper.setExpansionFraction(paramAnonymousValueAnimatorCompat.getAnimatedFloatValue());
        }
      });
    }
    mAnimator.setFloatValues(mCollapsingTextHelper.getExpansionFraction(), paramFloat);
    mAnimator.start();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    mRestoringSavedState = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    mRestoringSavedState = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (mHintEnabled) {
      mCollapsingTextHelper.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = true;
    if (mInDrawableStateChanged) {
      return;
    }
    mInDrawableStateChanged = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool1 = false;
    if ((ViewCompat.isLaidOut(this)) && (isEnabled())) {}
    for (;;)
    {
      updateLabelState(bool2);
      updateEditTextBackground();
      if (mCollapsingTextHelper != null) {
        bool1 = false | mCollapsingTextHelper.setState(arrayOfInt);
      }
      if (bool1) {
        invalidate();
      }
      mInDrawableStateChanged = false;
      return;
      bool2 = false;
    }
  }
  
  public int getCounterMaxLength()
  {
    return mCounterMaxLength;
  }
  
  @Nullable
  public EditText getEditText()
  {
    return mEditText;
  }
  
  @Nullable
  public CharSequence getError()
  {
    if (mErrorEnabled) {
      return mError;
    }
    return null;
  }
  
  @Nullable
  public CharSequence getHint()
  {
    if (mHintEnabled) {
      return mHint;
    }
    return null;
  }
  
  @Nullable
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return mPasswordToggleContentDesc;
  }
  
  @Nullable
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return mPasswordToggleDrawable;
  }
  
  @NonNull
  public Typeface getTypeface()
  {
    return mTypeface;
  }
  
  public boolean isCounterEnabled()
  {
    return mCounterEnabled;
  }
  
  public boolean isErrorEnabled()
  {
    return mErrorEnabled;
  }
  
  public boolean isHintAnimationEnabled()
  {
    return mHintAnimationEnabled;
  }
  
  public boolean isHintEnabled()
  {
    return mHintEnabled;
  }
  
  @VisibleForTesting
  final boolean isHintExpanded()
  {
    return mHintExpanded;
  }
  
  public boolean isPasswordVisibilityToggleEnabled()
  {
    return mPasswordToggleEnabled;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((mHintEnabled) && (mEditText != null))
    {
      Rect localRect = mTmpRect;
      ViewGroupUtils.getDescendantRect(this, mEditText, localRect);
      paramInt1 = left + mEditText.getCompoundPaddingLeft();
      paramInt3 = right - mEditText.getCompoundPaddingRight();
      mCollapsingTextHelper.setExpandedBounds(paramInt1, top + mEditText.getCompoundPaddingTop(), paramInt3, bottom - mEditText.getCompoundPaddingBottom());
      mCollapsingTextHelper.setCollapsedBounds(paramInt1, getPaddingTop(), paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
      mCollapsingTextHelper.recalculate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    updatePasswordToggleView();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setError(error);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (mErrorShown) {
      error = getError();
    }
    return localSavedState;
  }
  
  void passwordVisibilityToggleRequested()
  {
    int i;
    if (mPasswordToggleEnabled)
    {
      i = mEditText.getSelectionEnd();
      if (!hasPasswordTransformation()) {
        break label55;
      }
      mEditText.setTransformationMethod(null);
    }
    for (mPasswordToggledVisible = true;; mPasswordToggledVisible = false)
    {
      mPasswordToggleView.setChecked(mPasswordToggledVisible);
      mEditText.setSelection(i);
      return;
      label55:
      mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (mCounterEnabled != paramBoolean)
    {
      if (!paramBoolean) {
        break label151;
      }
      mCounterView = new AppCompatTextView(getContext());
      mCounterView.setId(R.id.textinput_counter);
      if (mTypeface != null) {
        mCounterView.setTypeface(mTypeface);
      }
      mCounterView.setMaxLines(1);
    }
    for (;;)
    {
      try
      {
        TextViewCompat.setTextAppearance(mCounterView, mCounterTextAppearance);
        addIndicator(mCounterView, -1);
        if (mEditText == null)
        {
          updateCounter(0);
          mCounterEnabled = paramBoolean;
          return;
        }
      }
      catch (Exception localException)
      {
        TextViewCompat.setTextAppearance(mCounterView, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
        mCounterView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
        continue;
        updateCounter(mEditText.getText().length());
        continue;
      }
      label151:
      removeIndicator(mCounterView);
      mCounterView = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (mCounterMaxLength != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      mCounterMaxLength = paramInt;
      if (mCounterEnabled) {
        if (mEditText != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = mEditText.getText().length())
    {
      updateCounter(paramInt);
      return;
      mCounterMaxLength = -1;
      break;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    recursiveSetEnabled(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(@Nullable CharSequence paramCharSequence)
  {
    if ((ViewCompat.isLaidOut(this)) && (isEnabled()) && ((mErrorView == null) || (!TextUtils.equals(mErrorView.getText(), paramCharSequence)))) {}
    for (boolean bool = true;; bool = false)
    {
      setError(paramCharSequence, bool);
      return;
    }
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    int j;
    if (mErrorEnabled != paramBoolean)
    {
      if (mErrorView != null) {
        ViewCompat.animate(mErrorView).cancel();
      }
      if (paramBoolean)
      {
        mErrorView = new AppCompatTextView(getContext());
        mErrorView.setId(R.id.textinput_error);
        if (mTypeface != null) {
          mErrorView.setTypeface(mTypeface);
        }
        j = 0;
      }
    }
    else
    {
      try
      {
        TextViewCompat.setTextAppearance(mErrorView, mErrorTextAppearance);
        i = j;
        if (Build.VERSION.SDK_INT >= 23)
        {
          int k = mErrorView.getTextColors().getDefaultColor();
          i = j;
          if (k == -65281) {
            i = 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 1;
        }
      }
      if (i != 0)
      {
        TextViewCompat.setTextAppearance(mErrorView, android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Caption);
        mErrorView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
      }
      mErrorView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(mErrorView, 1);
      addIndicator(mErrorView, 0);
    }
    for (;;)
    {
      mErrorEnabled = paramBoolean;
      return;
      mErrorShown = false;
      updateEditTextBackground();
      removeIndicator(mErrorView);
      mErrorView = null;
    }
  }
  
  public void setErrorTextAppearance(@StyleRes int paramInt)
  {
    mErrorTextAppearance = paramInt;
    if (mErrorView != null) {
      TextViewCompat.setTextAppearance(mErrorView, paramInt);
    }
  }
  
  public void setHint(@Nullable CharSequence paramCharSequence)
  {
    if (mHintEnabled)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    mHintAnimationEnabled = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    CharSequence localCharSequence;
    if (paramBoolean != mHintEnabled)
    {
      mHintEnabled = paramBoolean;
      localCharSequence = mEditText.getHint();
      if (mHintEnabled) {
        break label73;
      }
      if ((!TextUtils.isEmpty(mHint)) && (TextUtils.isEmpty(localCharSequence))) {
        mEditText.setHint(mHint);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (mEditText != null) {
        updateInputLayoutMargins();
      }
      return;
      label73:
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(mHint)) {
          setHint(localCharSequence);
        }
        mEditText.setHint(null);
      }
    }
  }
  
  public void setHintTextAppearance(@StyleRes int paramInt)
  {
    mCollapsingTextHelper.setCollapsedTextAppearance(paramInt);
    mFocusedTextColor = mCollapsingTextHelper.getCollapsedTextColor();
    if (mEditText != null)
    {
      updateLabelState(false);
      updateInputLayoutMargins();
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(@StringRes int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getResources().getText(paramInt);; localCharSequence = null)
    {
      setPasswordVisibilityToggleContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence paramCharSequence)
  {
    mPasswordToggleContentDesc = paramCharSequence;
    if (mPasswordToggleView != null) {
      mPasswordToggleView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(@DrawableRes int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(@Nullable Drawable paramDrawable)
  {
    mPasswordToggleDrawable = paramDrawable;
    if (mPasswordToggleView != null) {
      mPasswordToggleView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (mPasswordToggleEnabled != paramBoolean)
    {
      mPasswordToggleEnabled = paramBoolean;
      if ((!paramBoolean) && (mPasswordToggledVisible) && (mEditText != null)) {
        mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
      mPasswordToggledVisible = false;
      updatePasswordToggleView();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList paramColorStateList)
  {
    mPasswordToggleTintList = paramColorStateList;
    mHasPasswordToggleTintList = true;
    applyPasswordToggleTint();
  }
  
  public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    mPasswordToggleTintMode = paramMode;
    mHasPasswordToggleTintMode = true;
    applyPasswordToggleTint();
  }
  
  public void setTypeface(@Nullable Typeface paramTypeface)
  {
    if (paramTypeface != mTypeface)
    {
      mTypeface = paramTypeface;
      mCollapsingTextHelper.setTypefaces(paramTypeface);
      if (mCounterView != null) {
        mCounterView.setTypeface(paramTypeface);
      }
      if (mErrorView != null) {
        mErrorView.setTypeface(paramTypeface);
      }
    }
  }
  
  void updateCounter(int paramInt)
  {
    boolean bool2 = mCounterOverflowed;
    if (mCounterMaxLength == -1)
    {
      mCounterView.setText(String.valueOf(paramInt));
      mCounterOverflowed = false;
      if ((mEditText != null) && (bool2 != mCounterOverflowed))
      {
        updateLabelState(false);
        updateEditTextBackground();
      }
      return;
    }
    boolean bool1;
    label66:
    TextView localTextView;
    if (paramInt > mCounterMaxLength)
    {
      bool1 = true;
      mCounterOverflowed = bool1;
      if (bool2 != mCounterOverflowed)
      {
        localTextView = mCounterView;
        if (!mCounterOverflowed) {
          break label150;
        }
      }
    }
    label150:
    for (int i = mCounterOverflowTextAppearance;; i = mCounterTextAppearance)
    {
      TextViewCompat.setTextAppearance(localTextView, i);
      mCounterView.setText(getContext().getString(R.string.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(mCounterMaxLength) }));
      break;
      bool1 = false;
      break label66;
    }
  }
  
  void updateLabelState(boolean paramBoolean)
  {
    boolean bool1 = isEnabled();
    int i;
    boolean bool2;
    int j;
    if ((mEditText != null) && (!TextUtils.isEmpty(mEditText.getText())))
    {
      i = 1;
      bool2 = arrayContains(getDrawableState(), 16842908);
      if (TextUtils.isEmpty(getError())) {
        break label141;
      }
      j = 1;
      label52:
      if (mDefaultTextColor != null) {
        mCollapsingTextHelper.setExpandedTextColor(mDefaultTextColor);
      }
      if ((!bool1) || (!mCounterOverflowed) || (mCounterView == null)) {
        break label146;
      }
      mCollapsingTextHelper.setCollapsedTextColor(mCounterView.getTextColors());
      label103:
      if ((i == 0) && ((!isEnabled()) || ((!bool2) && (j == 0)))) {
        break label198;
      }
      if (mHintExpanded) {
        collapseHint(paramBoolean);
      }
    }
    label141:
    label146:
    label198:
    while (mHintExpanded)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label52;
      if ((bool1) && (bool2) && (mFocusedTextColor != null))
      {
        mCollapsingTextHelper.setCollapsedTextColor(mFocusedTextColor);
        break label103;
      }
      if (mDefaultTextColor == null) {
        break label103;
      }
      mCollapsingTextHelper.setCollapsedTextColor(mDefaultTextColor);
      break label103;
    }
    expandHint(paramBoolean);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public TextInputLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new TextInputLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public TextInputLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new TextInputLayout.SavedState[paramAnonymousInt];
      }
    });
    CharSequence error;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      error = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + error + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(error, paramParcel, paramInt);
    }
  }
  
  private class TextInputAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    TextInputAccessibilityDelegate() {}
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
      paramView = mCollapsingTextHelper.getText();
      if (!TextUtils.isEmpty(paramView)) {
        paramAccessibilityNodeInfoCompat.setText(paramView);
      }
      if (mEditText != null) {
        paramAccessibilityNodeInfoCompat.setLabelFor(mEditText);
      }
      if (mErrorView != null) {}
      for (paramView = mErrorView.getText();; paramView = null)
      {
        if (!TextUtils.isEmpty(paramView))
        {
          paramAccessibilityNodeInfoCompat.setContentInvalid(true);
          paramAccessibilityNodeInfoCompat.setError(paramView);
        }
        return;
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = mCollapsingTextHelper.getText();
      if (!TextUtils.isEmpty(paramView)) {
        paramAccessibilityEvent.getText().add(paramView);
      }
    }
  }
}

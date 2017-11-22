package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView
  extends FrameLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  public static final int INVALID_ITEM_POSITION = -1;
  private final int mDefaultMargin;
  private ImageView mIcon;
  private ColorStateList mIconTint;
  private MenuItemImpl mItemData;
  private int mItemPosition = -1;
  private final TextView mLargeLabel;
  private final float mScaleDownFactor;
  private final float mScaleUpFactor;
  private final int mShiftAmount;
  private boolean mShiftingMode;
  private final TextView mSmallLabel;
  
  public BottomNavigationItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    paramInt = paramAttributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_text_size);
    int i = paramAttributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_text_size);
    mDefaultMargin = paramAttributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    mShiftAmount = (paramInt - i);
    mScaleUpFactor = (i * 1.0F / paramInt);
    mScaleDownFactor = (paramInt * 1.0F / i);
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    mIcon = ((ImageView)findViewById(R.id.icon));
    mSmallLabel = ((TextView)findViewById(R.id.smallLabel));
    mLargeLabel = ((TextView)findViewById(R.id.largeLabel));
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public int getItemPosition()
  {
    return mItemPosition;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    mItemData = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((mItemData != null) && (mItemData.isCheckable()) && (mItemData.isChecked())) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    ViewCompat.setPivotX(mLargeLabel, mLargeLabel.getWidth() / 2);
    ViewCompat.setPivotY(mLargeLabel, mLargeLabel.getBaseline());
    ViewCompat.setPivotX(mSmallLabel, mSmallLabel.getWidth() / 2);
    ViewCompat.setPivotY(mSmallLabel, mSmallLabel.getBaseline());
    FrameLayout.LayoutParams localLayoutParams;
    if (mShiftingMode) {
      if (paramBoolean)
      {
        localLayoutParams = (FrameLayout.LayoutParams)mIcon.getLayoutParams();
        gravity = 49;
        topMargin = mDefaultMargin;
        mIcon.setLayoutParams(localLayoutParams);
        mLargeLabel.setVisibility(0);
        ViewCompat.setScaleX(mLargeLabel, 1.0F);
        ViewCompat.setScaleY(mLargeLabel, 1.0F);
        mSmallLabel.setVisibility(4);
      }
    }
    for (;;)
    {
      refreshDrawableState();
      return;
      localLayoutParams = (FrameLayout.LayoutParams)mIcon.getLayoutParams();
      gravity = 17;
      topMargin = mDefaultMargin;
      mIcon.setLayoutParams(localLayoutParams);
      mLargeLabel.setVisibility(4);
      ViewCompat.setScaleX(mLargeLabel, 0.5F);
      ViewCompat.setScaleY(mLargeLabel, 0.5F);
      break;
      if (paramBoolean)
      {
        localLayoutParams = (FrameLayout.LayoutParams)mIcon.getLayoutParams();
        gravity = 49;
        topMargin = (mDefaultMargin + mShiftAmount);
        mIcon.setLayoutParams(localLayoutParams);
        mLargeLabel.setVisibility(0);
        mSmallLabel.setVisibility(4);
        ViewCompat.setScaleX(mLargeLabel, 1.0F);
        ViewCompat.setScaleY(mLargeLabel, 1.0F);
        ViewCompat.setScaleX(mSmallLabel, mScaleUpFactor);
        ViewCompat.setScaleY(mSmallLabel, mScaleUpFactor);
      }
      else
      {
        localLayoutParams = (FrameLayout.LayoutParams)mIcon.getLayoutParams();
        gravity = 49;
        topMargin = mDefaultMargin;
        mIcon.setLayoutParams(localLayoutParams);
        mLargeLabel.setVisibility(4);
        mSmallLabel.setVisibility(0);
        ViewCompat.setScaleX(mLargeLabel, mScaleDownFactor);
        ViewCompat.setScaleY(mLargeLabel, mScaleDownFactor);
        ViewCompat.setScaleX(mSmallLabel, 1.0F);
        ViewCompat.setScaleY(mSmallLabel, 1.0F);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    mSmallLabel.setEnabled(paramBoolean);
    mLargeLabel.setEnabled(paramBoolean);
    mIcon.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    }
    ViewCompat.setPointerIcon(this, null);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        break label40;
      }
    }
    for (;;)
    {
      localObject = DrawableCompat.wrap(paramDrawable).mutate();
      DrawableCompat.setTintList((Drawable)localObject, mIconTint);
      mIcon.setImageDrawable((Drawable)localObject);
      return;
      label40:
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    mIconTint = paramColorStateList;
    if (mItemData != null) {
      setIcon(mItemData.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = ContextCompat.getDrawable(getContext(), paramInt))
    {
      ViewCompat.setBackground(this, localDrawable);
      return;
    }
  }
  
  public void setItemPosition(int paramInt)
  {
    mItemPosition = paramInt;
  }
  
  public void setShiftingMode(boolean paramBoolean)
  {
    mShiftingMode = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    mSmallLabel.setTextColor(paramColorStateList);
    mLargeLabel.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mSmallLabel.setText(paramCharSequence);
    mLargeLabel.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}

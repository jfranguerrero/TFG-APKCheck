package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private final AccessibilityDelegateCompat mAccessibilityDelegate = new AccessibilityDelegateCompat()
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      paramAnonymousAccessibilityNodeInfoCompat.setCheckable(mCheckable);
    }
  };
  private FrameLayout mActionArea;
  boolean mCheckable;
  private Drawable mEmptyDrawable;
  private boolean mHasIconTintList;
  private final int mIconSize;
  private ColorStateList mIconTintList;
  private MenuItemImpl mItemData;
  private boolean mNeedsEmptyIcon;
  private final CheckedTextView mTextView;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    mIconSize = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    mTextView = ((CheckedTextView)findViewById(R.id.design_menu_item_text));
    mTextView.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(mTextView, mAccessibilityDelegate);
  }
  
  private void adjustAppearance()
  {
    if (shouldExpandActionArea())
    {
      mTextView.setVisibility(8);
      if (mActionArea != null)
      {
        localLayoutParams = (LinearLayoutCompat.LayoutParams)mActionArea.getLayoutParams();
        width = -1;
        mActionArea.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      mTextView.setVisibility(0);
    } while (mActionArea == null);
    LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)mActionArea.getLayoutParams();
    width = -2;
    mActionArea.setLayoutParams(localLayoutParams);
  }
  
  private StateListDrawable createDefaultBackground()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (mActionArea == null) {
        mActionArea = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      mActionArea.removeAllViews();
      mActionArea.addView(paramView);
    }
  }
  
  private boolean shouldExpandActionArea()
  {
    return (mItemData.getTitle() == null) && (mItemData.getIcon() == null) && (mItemData.getActionView() != null);
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    mItemData = paramMenuItemImpl;
    if (paramMenuItemImpl.isVisible()) {}
    for (paramInt = 0;; paramInt = 8)
    {
      setVisibility(paramInt);
      if (getBackground() == null) {
        ViewCompat.setBackground(this, createDefaultBackground());
      }
      setCheckable(paramMenuItemImpl.isCheckable());
      setChecked(paramMenuItemImpl.isChecked());
      setEnabled(paramMenuItemImpl.isEnabled());
      setTitle(paramMenuItemImpl.getTitle());
      setIcon(paramMenuItemImpl.getIcon());
      setActionView(paramMenuItemImpl.getActionView());
      adjustAppearance();
      return;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
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
  
  public void recycle()
  {
    if (mActionArea != null) {
      mActionArea.removeAllViews();
    }
    mTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (mCheckable != paramBoolean)
    {
      mCheckable = paramBoolean;
      mAccessibilityDelegate.sendAccessibilityEvent(mTextView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    mTextView.setChecked(paramBoolean);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject;
    if (paramDrawable != null)
    {
      localObject = paramDrawable;
      if (mHasIconTintList)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject == null)
        {
          localObject = DrawableCompat.wrap(paramDrawable).mutate();
          DrawableCompat.setTintList((Drawable)localObject, mIconTintList);
        }
      }
      else
      {
        ((Drawable)localObject).setBounds(0, 0, mIconSize, mIconSize);
        paramDrawable = (Drawable)localObject;
      }
    }
    for (;;)
    {
      TextViewCompat.setCompoundDrawablesRelative(mTextView, paramDrawable, null, null, null);
      return;
      paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      break;
      if (mNeedsEmptyIcon)
      {
        if (mEmptyDrawable == null)
        {
          mEmptyDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
          if (mEmptyDrawable != null) {
            mEmptyDrawable.setBounds(0, 0, mIconSize, mIconSize);
          }
        }
        paramDrawable = mEmptyDrawable;
      }
    }
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    mIconTintList = paramColorStateList;
    if (mIconTintList != null) {}
    for (boolean bool = true;; bool = false)
    {
      mHasIconTintList = bool;
      if (mItemData != null) {
        setIcon(mItemData.getIcon());
      }
      return;
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    mNeedsEmptyIcon = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(mTextView, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    mTextView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTextView.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}

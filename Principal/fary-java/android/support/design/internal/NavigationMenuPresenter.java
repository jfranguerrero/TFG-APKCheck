package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter
  implements MenuPresenter
{
  private static final String STATE_ADAPTER = "android:menu:adapter";
  private static final String STATE_HEADER = "android:menu:header";
  private static final String STATE_HIERARCHY = "android:menu:list";
  NavigationMenuAdapter mAdapter;
  private MenuPresenter.Callback mCallback;
  LinearLayout mHeaderLayout;
  ColorStateList mIconTintList;
  private int mId;
  Drawable mItemBackground;
  LayoutInflater mLayoutInflater;
  MenuBuilder mMenu;
  private NavigationMenuView mMenuView;
  final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      setUpdateSuspended(true);
      paramAnonymousView = paramAnonymousView.getItemData();
      boolean bool = mMenu.performItemAction(paramAnonymousView, NavigationMenuPresenter.this, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        mAdapter.setCheckedItem(paramAnonymousView);
      }
      setUpdateSuspended(false);
      updateMenuView(false);
    }
  };
  int mPaddingSeparator;
  private int mPaddingTopDefault;
  int mTextAppearance;
  boolean mTextAppearanceSet;
  ColorStateList mTextColor;
  
  public NavigationMenuPresenter() {}
  
  public void addHeaderView(@NonNull View paramView)
  {
    mHeaderLayout.addView(paramView);
    mMenuView.setPadding(0, 0, 0, mMenuView.getPaddingBottom());
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dispatchApplyWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (mPaddingTopDefault != i)
    {
      mPaddingTopDefault = i;
      if (mHeaderLayout.getChildCount() == 0) {
        mMenuView.setPadding(0, mPaddingTopDefault, 0, mMenuView.getPaddingBottom());
      }
    }
    ViewCompat.dispatchApplyWindowInsets(mHeaderLayout, paramWindowInsetsCompat);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getHeaderCount()
  {
    return mHeaderLayout.getChildCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return mHeaderLayout.getChildAt(paramInt);
  }
  
  public int getId()
  {
    return mId;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return mItemBackground;
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return mTextColor;
  }
  
  @Nullable
  public ColorStateList getItemTintList()
  {
    return mIconTintList;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (mMenuView == null)
    {
      mMenuView = ((NavigationMenuView)mLayoutInflater.inflate(R.layout.design_navigation_menu, paramViewGroup, false));
      if (mAdapter == null) {
        mAdapter = new NavigationMenuAdapter();
      }
      mHeaderLayout = ((LinearLayout)mLayoutInflater.inflate(R.layout.design_navigation_item_header, mMenuView, false));
      mMenuView.setAdapter(mAdapter);
    }
    return mMenuView;
  }
  
  public View inflateHeaderView(@LayoutRes int paramInt)
  {
    View localView = mLayoutInflater.inflate(paramInt, mHeaderLayout, false);
    addHeaderView(localView);
    return localView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    mLayoutInflater = LayoutInflater.from(paramContext);
    mMenu = paramMenuBuilder;
    mPaddingSeparator = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mCallback != null) {
      mCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject != null) {
        mMenuView.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        mAdapter.restoreInstanceState((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        mHeaderLayout.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      Bundle localBundle = new Bundle();
      SparseArray localSparseArray;
      if (mMenuView != null)
      {
        localSparseArray = new SparseArray();
        mMenuView.saveHierarchyState(localSparseArray);
        localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
      }
      if (mAdapter != null) {
        localBundle.putBundle("android:menu:adapter", mAdapter.createInstanceState());
      }
      if (mHeaderLayout != null)
      {
        localSparseArray = new SparseArray();
        mHeaderLayout.saveHierarchyState(localSparseArray);
        localBundle.putSparseParcelableArray("android:menu:header", localSparseArray);
      }
      return localBundle;
    }
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void removeHeaderView(@NonNull View paramView)
  {
    mHeaderLayout.removeView(paramView);
    if (mHeaderLayout.getChildCount() == 0) {
      mMenuView.setPadding(0, mPaddingTopDefault, 0, mMenuView.getPaddingBottom());
    }
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  public void setCheckedItem(MenuItemImpl paramMenuItemImpl)
  {
    mAdapter.setCheckedItem(paramMenuItemImpl);
  }
  
  public void setId(int paramInt)
  {
    mId = paramInt;
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    mItemBackground = paramDrawable;
    updateMenuView(false);
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    mIconTintList = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    mTextAppearance = paramInt;
    mTextAppearanceSet = true;
    updateMenuView(false);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    mTextColor = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    if (mAdapter != null) {
      mAdapter.setUpdateSuspended(paramBoolean);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (mAdapter != null) {
      mAdapter.update();
    }
  }
  
  private static class HeaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public HeaderViewHolder(View paramView)
    {
      super();
    }
  }
  
  private class NavigationMenuAdapter
    extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
  {
    private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
    private static final String STATE_CHECKED_ITEM = "android:menu:checked";
    private static final int VIEW_TYPE_HEADER = 3;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_SEPARATOR = 2;
    private static final int VIEW_TYPE_SUBHEADER = 1;
    private MenuItemImpl mCheckedItem;
    private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> mItems = new ArrayList();
    private boolean mUpdateSuspended;
    
    NavigationMenuAdapter()
    {
      prepareMenuItems();
    }
    
    private void appendTransparentIconIfMissing(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        mItems.get(paramInt1)).needsEmptyIcon = true;
        paramInt1 += 1;
      }
    }
    
    private void prepareMenuItems()
    {
      if (mUpdateSuspended) {
        return;
      }
      mUpdateSuspended = true;
      mItems.clear();
      mItems.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
      int n = -1;
      int j = 0;
      boolean bool2 = false;
      int m = 0;
      int i2 = mMenu.getVisibleItems().size();
      while (m < i2)
      {
        Object localObject = (MenuItemImpl)mMenu.getVisibleItems().get(m);
        if (((MenuItemImpl)localObject).isChecked()) {
          setCheckedItem((MenuItemImpl)localObject);
        }
        if (((MenuItemImpl)localObject).isCheckable()) {
          ((MenuItemImpl)localObject).setExclusiveCheckable(false);
        }
        boolean bool1;
        int k;
        int i1;
        int i;
        if (((MenuItemImpl)localObject).hasSubMenu())
        {
          SubMenu localSubMenu = ((MenuItemImpl)localObject).getSubMenu();
          bool1 = bool2;
          k = n;
          i1 = j;
          if (localSubMenu.hasVisibleItems())
          {
            if (m != 0) {
              mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(mPaddingSeparator, 0));
            }
            mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject));
            i = 0;
            int i3 = mItems.size();
            i1 = 0;
            int i4 = localSubMenu.size();
            while (i1 < i4)
            {
              MenuItemImpl localMenuItemImpl = (MenuItemImpl)localSubMenu.getItem(i1);
              k = i;
              if (localMenuItemImpl.isVisible())
              {
                k = i;
                if (i == 0)
                {
                  k = i;
                  if (localMenuItemImpl.getIcon() != null) {
                    k = 1;
                  }
                }
                if (localMenuItemImpl.isCheckable()) {
                  localMenuItemImpl.setExclusiveCheckable(false);
                }
                if (((MenuItemImpl)localObject).isChecked()) {
                  setCheckedItem((MenuItemImpl)localObject);
                }
                mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl));
              }
              i1 += 1;
              i = k;
            }
            bool1 = bool2;
            k = n;
            i1 = j;
            if (i != 0)
            {
              appendTransparentIconIfMissing(i3, mItems.size());
              i1 = j;
              k = n;
              bool1 = bool2;
            }
          }
          m += 1;
          bool2 = bool1;
          n = k;
          j = i1;
        }
        else
        {
          k = ((MenuItemImpl)localObject).getGroupId();
          if (k != n)
          {
            j = mItems.size();
            if (((MenuItemImpl)localObject).getIcon() != null)
            {
              bool2 = true;
              label411:
              bool1 = bool2;
              i = j;
              if (m != 0)
              {
                i = j + 1;
                mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(mPaddingSeparator, mPaddingSeparator));
                bool1 = bool2;
              }
            }
          }
          for (;;)
          {
            localObject = new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject);
            needsEmptyIcon = bool1;
            mItems.add(localObject);
            i1 = i;
            break;
            bool2 = false;
            break label411;
            bool1 = bool2;
            i = j;
            if (!bool2)
            {
              bool1 = bool2;
              i = j;
              if (((MenuItemImpl)localObject).getIcon() != null)
              {
                bool1 = true;
                appendTransparentIconIfMissing(j, mItems.size());
                i = j;
              }
            }
          }
        }
      }
      mUpdateSuspended = false;
    }
    
    public Bundle createInstanceState()
    {
      Bundle localBundle = new Bundle();
      if (mCheckedItem != null) {
        localBundle.putInt("android:menu:checked", mCheckedItem.getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = mItems.iterator();
      label129:
      while (localIterator.hasNext())
      {
        Object localObject = (NavigationMenuPresenter.NavigationMenuItem)localIterator.next();
        if ((localObject instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          MenuItemImpl localMenuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).getMenuItem();
          if (localMenuItemImpl != null) {}
          for (localObject = localMenuItemImpl.getActionView();; localObject = null)
          {
            if (localObject == null) {
              break label129;
            }
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            ((View)localObject).saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localMenuItemImpl.getItemId(), localParcelableSparseArray);
            break;
          }
        }
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }
    
    public int getItemCount()
    {
      return mItems.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      NavigationMenuPresenter.NavigationMenuItem localNavigationMenuItem = (NavigationMenuPresenter.NavigationMenuItem)mItems.get(paramInt);
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)) {
        return 2;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)) {
        return 3;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem))
      {
        if (((NavigationMenuPresenter.NavigationMenuTextItem)localNavigationMenuItem).getMenuItem().hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
    
    public void onBindViewHolder(NavigationMenuPresenter.ViewHolder paramViewHolder, int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        return;
      case 0: 
        localObject = (NavigationMenuItemView)itemView;
        ((NavigationMenuItemView)localObject).setIconTintList(mIconTintList);
        if (mTextAppearanceSet) {
          ((NavigationMenuItemView)localObject).setTextAppearance(mTextAppearance);
        }
        if (mTextColor != null) {
          ((NavigationMenuItemView)localObject).setTextColor(mTextColor);
        }
        if (mItemBackground != null) {}
        for (paramViewHolder = mItemBackground.getConstantState().newDrawable();; paramViewHolder = null)
        {
          ViewCompat.setBackground((View)localObject, paramViewHolder);
          paramViewHolder = (NavigationMenuPresenter.NavigationMenuTextItem)mItems.get(paramInt);
          ((NavigationMenuItemView)localObject).setNeedsEmptyIcon(needsEmptyIcon);
          ((NavigationMenuItemView)localObject).initialize(paramViewHolder.getMenuItem(), 0);
          return;
        }
      case 1: 
        ((TextView)itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)mItems.get(paramInt)).getMenuItem().getTitle());
        return;
      }
      Object localObject = (NavigationMenuPresenter.NavigationMenuSeparatorItem)mItems.get(paramInt);
      itemView.setPadding(0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingTop(), 0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingBottom());
    }
    
    public NavigationMenuPresenter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return new NavigationMenuPresenter.NormalViewHolder(mLayoutInflater, paramViewGroup, mOnClickListener);
      case 1: 
        return new NavigationMenuPresenter.SubheaderViewHolder(mLayoutInflater, paramViewGroup);
      case 2: 
        return new NavigationMenuPresenter.SeparatorViewHolder(mLayoutInflater, paramViewGroup);
      }
      return new NavigationMenuPresenter.HeaderViewHolder(mHeaderLayout);
    }
    
    public void onViewRecycled(NavigationMenuPresenter.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder instanceof NavigationMenuPresenter.NormalViewHolder)) {
        ((NavigationMenuItemView)itemView).recycle();
      }
    }
    
    public void restoreInstanceState(Bundle paramBundle)
    {
      int i = paramBundle.getInt("android:menu:checked", 0);
      if (i != 0)
      {
        mUpdateSuspended = true;
        localObject1 = mItems.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (NavigationMenuPresenter.NavigationMenuItem)((Iterator)localObject1).next();
          if ((localObject2 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            localObject2 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject2).getMenuItem();
            if ((localObject2 != null) && (((MenuItemImpl)localObject2).getItemId() == i)) {
              setCheckedItem((MenuItemImpl)localObject2);
            }
          }
        }
        mUpdateSuspended = false;
        prepareMenuItems();
      }
      Object localObject1 = paramBundle.getSparseParcelableArray("android:menu:action_views");
      Object localObject2 = mItems.iterator();
      label182:
      while (((Iterator)localObject2).hasNext())
      {
        paramBundle = (NavigationMenuPresenter.NavigationMenuItem)((Iterator)localObject2).next();
        if ((paramBundle instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          MenuItemImpl localMenuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)paramBundle).getMenuItem();
          if (localMenuItemImpl != null) {}
          for (paramBundle = localMenuItemImpl.getActionView();; paramBundle = null)
          {
            if (paramBundle == null) {
              break label182;
            }
            paramBundle.restoreHierarchyState((SparseArray)((SparseArray)localObject1).get(localMenuItemImpl.getItemId()));
            break;
          }
        }
      }
    }
    
    public void setCheckedItem(MenuItemImpl paramMenuItemImpl)
    {
      if ((mCheckedItem == paramMenuItemImpl) || (!paramMenuItemImpl.isCheckable())) {
        return;
      }
      if (mCheckedItem != null) {
        mCheckedItem.setChecked(false);
      }
      mCheckedItem = paramMenuItemImpl;
      paramMenuItemImpl.setChecked(true);
    }
    
    public void setUpdateSuspended(boolean paramBoolean)
    {
      mUpdateSuspended = paramBoolean;
    }
    
    public void update()
    {
      prepareMenuItems();
      notifyDataSetChanged();
    }
  }
  
  private static class NavigationMenuHeaderItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    NavigationMenuHeaderItem() {}
  }
  
  private static abstract interface NavigationMenuItem {}
  
  private static class NavigationMenuSeparatorItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final int mPaddingBottom;
    private final int mPaddingTop;
    
    public NavigationMenuSeparatorItem(int paramInt1, int paramInt2)
    {
      mPaddingTop = paramInt1;
      mPaddingBottom = paramInt2;
    }
    
    public int getPaddingBottom()
    {
      return mPaddingBottom;
    }
    
    public int getPaddingTop()
    {
      return mPaddingTop;
    }
  }
  
  private static class NavigationMenuTextItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final MenuItemImpl mMenuItem;
    boolean needsEmptyIcon;
    
    NavigationMenuTextItem(MenuItemImpl paramMenuItemImpl)
    {
      mMenuItem = paramMenuItemImpl;
    }
    
    public MenuItemImpl getMenuItem()
    {
      return mMenuItem;
    }
  }
  
  private static class NormalViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public NormalViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      itemView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static class SeparatorViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SeparatorViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static class SubheaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SubheaderViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public ViewHolder(View paramView)
    {
      super();
    }
  }
}

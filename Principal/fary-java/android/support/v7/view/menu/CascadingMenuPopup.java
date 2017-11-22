package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class CascadingMenuPopup
  extends MenuPopup
  implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener
{
  static final int HORIZ_POSITION_LEFT = 0;
  static final int HORIZ_POSITION_RIGHT = 1;
  static final int SUBMENU_TIMEOUT_MS = 200;
  private View mAnchorView;
  private final Context mContext;
  private int mDropDownGravity = 0;
  private boolean mForceShowIcon;
  private final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      Object localObject;
      if ((isShowing()) && (mShowingMenus.size() > 0) && (!mShowingMenus.get(0)).window.isModal()))
      {
        localObject = mShownAnchorView;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = mShowingMenus.iterator();
        while (((Iterator)localObject).hasNext()) {
          nextwindow.show();
        }
      }
    }
  };
  private boolean mHasXOffset;
  private boolean mHasYOffset;
  private int mLastPosition;
  private final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener()
  {
    public void onItemHoverEnter(@NonNull final MenuBuilder paramAnonymousMenuBuilder, @NonNull final MenuItem paramAnonymousMenuItem)
    {
      mSubMenuHoverHandler.removeCallbacksAndMessages(null);
      int k = -1;
      int i = 0;
      int m = mShowingMenus.size();
      int j;
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (paramAnonymousMenuBuilder == mShowingMenus.get(i)).menu) {
            j = i;
          }
        }
        else
        {
          if (j != -1) {
            break;
          }
          return;
        }
        i += 1;
      }
      i = j + 1;
      if (i < mShowingMenus.size()) {}
      for (final CascadingMenuPopup.CascadingMenuInfo localCascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo)mShowingMenus.get(i);; localCascadingMenuInfo = null)
      {
        paramAnonymousMenuItem = new Runnable()
        {
          public void run()
          {
            if (localCascadingMenuInfo != null)
            {
              mShouldCloseImmediately = true;
              localCascadingMenuInfomenu.close(false);
              mShouldCloseImmediately = false;
            }
            if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
              paramAnonymousMenuBuilder.performItemAction(paramAnonymousMenuItem, 0);
            }
          }
        };
        long l = SystemClock.uptimeMillis();
        mSubMenuHoverHandler.postAtTime(paramAnonymousMenuItem, paramAnonymousMenuBuilder, l + 200L);
        return;
      }
    }
    
    public void onItemHoverExit(@NonNull MenuBuilder paramAnonymousMenuBuilder, @NonNull MenuItem paramAnonymousMenuItem)
    {
      mSubMenuHoverHandler.removeCallbacksAndMessages(paramAnonymousMenuBuilder);
    }
  };
  private final int mMenuMaxWidth;
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final boolean mOverflowOnly;
  private final List<MenuBuilder> mPendingMenus = new LinkedList();
  private final int mPopupStyleAttr;
  private final int mPopupStyleRes;
  private MenuPresenter.Callback mPresenterCallback;
  private int mRawDropDownGravity = 0;
  boolean mShouldCloseImmediately;
  private boolean mShowTitle;
  final List<CascadingMenuInfo> mShowingMenus = new ArrayList();
  View mShownAnchorView;
  final Handler mSubMenuHoverHandler;
  private ViewTreeObserver mTreeObserver;
  private int mXOffset;
  private int mYOffset;
  
  public CascadingMenuPopup(@NonNull Context paramContext, @NonNull View paramView, @AttrRes int paramInt1, @StyleRes int paramInt2, boolean paramBoolean)
  {
    mContext = paramContext;
    mAnchorView = paramView;
    mPopupStyleAttr = paramInt1;
    mPopupStyleRes = paramInt2;
    mOverflowOnly = paramBoolean;
    mForceShowIcon = false;
    mLastPosition = getInitialMenuPosition();
    paramContext = paramContext.getResources();
    mMenuMaxWidth = Math.max(getDisplayMetricswidthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    mSubMenuHoverHandler = new Handler();
  }
  
  private MenuPopupWindow createPopupWindow()
  {
    MenuPopupWindow localMenuPopupWindow = new MenuPopupWindow(mContext, null, mPopupStyleAttr, mPopupStyleRes);
    localMenuPopupWindow.setHoverListener(mMenuItemHoverListener);
    localMenuPopupWindow.setOnItemClickListener(this);
    localMenuPopupWindow.setOnDismissListener(this);
    localMenuPopupWindow.setAnchorView(mAnchorView);
    localMenuPopupWindow.setDropDownGravity(mDropDownGravity);
    localMenuPopupWindow.setModal(true);
    return localMenuPopupWindow;
  }
  
  private int findIndexOfAddedMenu(@NonNull MenuBuilder paramMenuBuilder)
  {
    int i = 0;
    int j = mShowingMenus.size();
    while (i < j)
    {
      if (paramMenuBuilder == mShowingMenus.get(i)).menu) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder paramMenuBuilder1, @NonNull MenuBuilder paramMenuBuilder2)
  {
    int i = 0;
    int j = paramMenuBuilder1.size();
    while (i < j)
    {
      MenuItem localMenuItem = paramMenuBuilder1.getItem(i);
      if ((localMenuItem.hasSubMenu()) && (paramMenuBuilder2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  private View findParentViewForSubmenu(@NonNull CascadingMenuInfo paramCascadingMenuInfo, @NonNull MenuBuilder paramMenuBuilder)
  {
    paramMenuBuilder = findMenuItemForSubmenu(menu, paramMenuBuilder);
    if (paramMenuBuilder == null) {
      return null;
    }
    ListView localListView = paramCascadingMenuInfo.getListView();
    paramCascadingMenuInfo = localListView.getAdapter();
    int j;
    label54:
    int m;
    int i;
    int n;
    if ((paramCascadingMenuInfo instanceof HeaderViewListAdapter))
    {
      paramCascadingMenuInfo = (HeaderViewListAdapter)paramCascadingMenuInfo;
      j = paramCascadingMenuInfo.getHeadersCount();
      paramCascadingMenuInfo = (MenuAdapter)paramCascadingMenuInfo.getWrappedAdapter();
      m = -1;
      i = 0;
      n = paramCascadingMenuInfo.getCount();
    }
    for (;;)
    {
      int k = m;
      if (i < n)
      {
        if (paramMenuBuilder == paramCascadingMenuInfo.getItem(i)) {
          k = i;
        }
      }
      else
      {
        if (k == -1) {
          break;
        }
        i = k + j - localListView.getFirstVisiblePosition();
        if ((i < 0) || (i >= localListView.getChildCount())) {
          break;
        }
        return localListView.getChildAt(i);
        j = 0;
        paramCascadingMenuInfo = (MenuAdapter)paramCascadingMenuInfo;
        break label54;
      }
      i += 1;
    }
  }
  
  private int getInitialMenuPosition()
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(mAnchorView) == 1) {
      i = 0;
    }
    return i;
  }
  
  private int getNextMenuPosition(int paramInt)
  {
    ListView localListView = ((CascadingMenuInfo)mShowingMenus.get(mShowingMenus.size() - 1)).getListView();
    int[] arrayOfInt = new int[2];
    localListView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    mShownAnchorView.getWindowVisibleDisplayFrame(localRect);
    if (mLastPosition == 1)
    {
      if (arrayOfInt[0] + localListView.getWidth() + paramInt > right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private void showMenu(@NonNull MenuBuilder paramMenuBuilder)
  {
    Object localObject3 = LayoutInflater.from(mContext);
    Object localObject1 = new MenuAdapter(paramMenuBuilder, (LayoutInflater)localObject3, mOverflowOnly);
    int m;
    MenuPopupWindow localMenuPopupWindow;
    Object localObject2;
    label136:
    int i;
    label167:
    int n;
    if ((!isShowing()) && (mForceShowIcon))
    {
      ((MenuAdapter)localObject1).setForceShowIcon(true);
      m = measureIndividualMenuWidth((ListAdapter)localObject1, null, mContext, mMenuMaxWidth);
      localMenuPopupWindow = createPopupWindow();
      localMenuPopupWindow.setAdapter((ListAdapter)localObject1);
      localMenuPopupWindow.setContentWidth(m);
      localMenuPopupWindow.setDropDownGravity(mDropDownGravity);
      if (mShowingMenus.size() <= 0) {
        break label386;
      }
      localObject1 = (CascadingMenuInfo)mShowingMenus.get(mShowingMenus.size() - 1);
      localObject2 = findParentViewForSubmenu((CascadingMenuInfo)localObject1, paramMenuBuilder);
      if (localObject2 == null) {
        break label437;
      }
      localMenuPopupWindow.setTouchModal(false);
      localMenuPopupWindow.setEnterTransition(null);
      int j = getNextMenuPosition(m);
      if (j != 1) {
        break label395;
      }
      i = 1;
      mLastPosition = j;
      int[] arrayOfInt = new int[2];
      ((View)localObject2).getLocationInWindow(arrayOfInt);
      n = window.getHorizontalOffset() + arrayOfInt[0];
      j = window.getVerticalOffset();
      int k = arrayOfInt[1];
      if ((mDropDownGravity & 0x5) != 5) {
        break label412;
      }
      if (i == 0) {
        break label400;
      }
      i = n + m;
      label234:
      localMenuPopupWindow.setHorizontalOffset(i);
      localMenuPopupWindow.setVerticalOffset(j + k);
    }
    for (;;)
    {
      localObject2 = new CascadingMenuInfo(localMenuPopupWindow, paramMenuBuilder, mLastPosition);
      mShowingMenus.add(localObject2);
      localMenuPopupWindow.show();
      if ((localObject1 == null) && (mShowTitle) && (paramMenuBuilder.getHeaderTitle() != null))
      {
        localObject1 = localMenuPopupWindow.getListView();
        localObject2 = (FrameLayout)((LayoutInflater)localObject3).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject1, false);
        localObject3 = (TextView)((FrameLayout)localObject2).findViewById(16908310);
        ((FrameLayout)localObject2).setEnabled(false);
        ((TextView)localObject3).setText(paramMenuBuilder.getHeaderTitle());
        ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
        localMenuPopupWindow.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((MenuAdapter)localObject1).setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(paramMenuBuilder));
      break;
      label386:
      localObject1 = null;
      localObject2 = null;
      break label136;
      label395:
      i = 0;
      break label167;
      label400:
      i = n - ((View)localObject2).getWidth();
      break label234;
      label412:
      if (i != 0)
      {
        i = n + ((View)localObject2).getWidth();
        break label234;
      }
      i = n - m;
      break label234;
      label437:
      if (mHasXOffset) {
        localMenuPopupWindow.setHorizontalOffset(mXOffset);
      }
      if (mHasYOffset) {
        localMenuPopupWindow.setVerticalOffset(mYOffset);
      }
      localMenuPopupWindow.setEpicenterBounds(getEpicenterBounds());
    }
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder)
  {
    paramMenuBuilder.addMenuPresenter(this, mContext);
    if (isShowing())
    {
      showMenu(paramMenuBuilder);
      return;
    }
    mPendingMenus.add(paramMenuBuilder);
  }
  
  protected boolean closeMenuOnSubMenuOpened()
  {
    return false;
  }
  
  public void dismiss()
  {
    int i = mShowingMenus.size();
    if (i > 0)
    {
      CascadingMenuInfo[] arrayOfCascadingMenuInfo = (CascadingMenuInfo[])mShowingMenus.toArray(new CascadingMenuInfo[i]);
      i -= 1;
      while (i >= 0)
      {
        CascadingMenuInfo localCascadingMenuInfo = arrayOfCascadingMenuInfo[i];
        if (window.isShowing()) {
          window.dismiss();
        }
        i -= 1;
      }
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    if (mShowingMenus.isEmpty()) {
      return null;
    }
    return ((CascadingMenuInfo)mShowingMenus.get(mShowingMenus.size() - 1)).getListView();
  }
  
  public boolean isShowing()
  {
    return (mShowingMenus.size() > 0) && (mShowingMenus.get(0)).window.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    int i = findIndexOfAddedMenu(paramMenuBuilder);
    if (i < 0) {}
    do
    {
      return;
      int j = i + 1;
      if (j < mShowingMenus.size()) {
        mShowingMenus.get(j)).menu.close(false);
      }
      CascadingMenuInfo localCascadingMenuInfo = (CascadingMenuInfo)mShowingMenus.remove(i);
      menu.removeMenuPresenter(this);
      if (mShouldCloseImmediately)
      {
        window.setExitTransition(null);
        window.setAnimationStyle(0);
      }
      window.dismiss();
      i = mShowingMenus.size();
      if (i > 0) {}
      for (mLastPosition = mShowingMenus.get(i - 1)).position; i == 0; mLastPosition = getInitialMenuPosition())
      {
        dismiss();
        if (mPresenterCallback != null) {
          mPresenterCallback.onCloseMenu(paramMenuBuilder, true);
        }
        if (mTreeObserver != null)
        {
          if (mTreeObserver.isAlive()) {
            mTreeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
          }
          mTreeObserver = null;
        }
        mOnDismissListener.onDismiss();
        return;
      }
    } while (!paramBoolean);
    mShowingMenus.get(0)).menu.close(false);
  }
  
  public void onDismiss()
  {
    Object localObject2 = null;
    int i = 0;
    int j = mShowingMenus.size();
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = (CascadingMenuInfo)mShowingMenus.get(i);
        if (window.isShowing()) {}
      }
      else
      {
        if (localObject1 != null) {
          menu.close(false);
        }
        return;
      }
      i += 1;
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    Iterator localIterator = mShowingMenus.iterator();
    while (localIterator.hasNext())
    {
      CascadingMenuInfo localCascadingMenuInfo = (CascadingMenuInfo)localIterator.next();
      if (paramSubMenuBuilder == menu) {
        localCascadingMenuInfo.getListView().requestFocus();
      }
    }
    do
    {
      return true;
      if (!paramSubMenuBuilder.hasVisibleItems()) {
        break;
      }
      addMenu(paramSubMenuBuilder);
    } while (mPresenterCallback == null);
    mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder);
    return true;
    return false;
  }
  
  public void setAnchorView(@NonNull View paramView)
  {
    if (mAnchorView != paramView)
    {
      mAnchorView = paramView;
      mDropDownGravity = GravityCompat.getAbsoluteGravity(mRawDropDownGravity, ViewCompat.getLayoutDirection(mAnchorView));
    }
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    mForceShowIcon = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    if (mRawDropDownGravity != paramInt)
    {
      mRawDropDownGravity = paramInt;
      mDropDownGravity = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(mAnchorView));
    }
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    mHasXOffset = true;
    mXOffset = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mOnDismissListener = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    mShowTitle = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    mHasYOffset = true;
    mYOffset = paramInt;
  }
  
  public void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = mPendingMenus.iterator();
      while (localIterator.hasNext()) {
        showMenu((MenuBuilder)localIterator.next());
      }
      mPendingMenus.clear();
      mShownAnchorView = mAnchorView;
    } while (mShownAnchorView == null);
    if (mTreeObserver == null) {}
    for (int i = 1;; i = 0)
    {
      mTreeObserver = mShownAnchorView.getViewTreeObserver();
      if (i == 0) {
        break;
      }
      mTreeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
      return;
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    Iterator localIterator = mShowingMenus.iterator();
    while (localIterator.hasNext()) {
      toMenuAdapter(((CascadingMenuInfo)localIterator.next()).getListView().getAdapter()).notifyDataSetChanged();
    }
  }
  
  private static class CascadingMenuInfo
  {
    public final MenuBuilder menu;
    public final int position;
    public final MenuPopupWindow window;
    
    public CascadingMenuInfo(@NonNull MenuPopupWindow paramMenuPopupWindow, @NonNull MenuBuilder paramMenuBuilder, int paramInt)
    {
      window = paramMenuPopupWindow;
      menu = paramMenuBuilder;
      position = paramInt;
    }
    
    public ListView getListView()
    {
      return window.getListView();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HorizPosition {}
}

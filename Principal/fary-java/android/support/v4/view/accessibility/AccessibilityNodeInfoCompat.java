package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
  public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_COLLAPSE = 524288;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_DISMISS = 1048576;
  public static final int ACTION_EXPAND = 262144;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 32;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PASTE = 32768;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int ACTION_SET_SELECTION = 131072;
  public static final int ACTION_SET_TEXT = 2097152;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  private final Object mInfo;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int mParentVirtualDescendantId = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      IMPL = new AccessibilityNodeInfoApi24Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new AccessibilityNodeInfoApi23Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 22)
    {
      IMPL = new AccessibilityNodeInfoApi22Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new AccessibilityNodeInfoApi21Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new AccessibilityNodeInfoKitKatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr1Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    mInfo = paramObject;
  }
  
  private static String getActionSymbolicName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "ACTION_UNKNOWN";
    case 1: 
      return "ACTION_FOCUS";
    case 2: 
      return "ACTION_CLEAR_FOCUS";
    case 4: 
      return "ACTION_SELECT";
    case 8: 
      return "ACTION_CLEAR_SELECTION";
    case 16: 
      return "ACTION_CLICK";
    case 32: 
      return "ACTION_LONG_CLICK";
    case 64: 
      return "ACTION_ACCESSIBILITY_FOCUS";
    case 128: 
      return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    case 256: 
      return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    case 512: 
      return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    case 1024: 
      return "ACTION_NEXT_HTML_ELEMENT";
    case 2048: 
      return "ACTION_PREVIOUS_HTML_ELEMENT";
    case 4096: 
      return "ACTION_SCROLL_FORWARD";
    case 8192: 
      return "ACTION_SCROLL_BACKWARD";
    case 65536: 
      return "ACTION_CUT";
    case 16384: 
      return "ACTION_COPY";
    case 32768: 
      return "ACTION_PASTE";
    }
    return "ACTION_SET_SELECTION";
  }
  
  public static AccessibilityNodeInfoCompat obtain()
  {
    return wrapNonNullInstance(IMPL.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return wrapNonNullInstance(IMPL.obtain(mInfo));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView, paramInt));
  }
  
  static AccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new AccessibilityNodeInfoCompat(paramObject);
    }
    return null;
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(mInfo, paramInt);
  }
  
  public void addAction(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    IMPL.addAction(mInfo, mAction);
  }
  
  public void addChild(View paramView)
  {
    IMPL.addChild(mInfo, paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    IMPL.addChild(mInfo, paramView, paramInt);
  }
  
  public boolean canOpenPopup()
  {
    return IMPL.canOpenPopup(mInfo);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (AccessibilityNodeInfoCompat)paramObject;
        if (mInfo != null) {
          break;
        }
      } while (mInfo == null);
      return false;
    } while (mInfo.equals(mInfo));
    return false;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = IMPL.findAccessibilityNodeInfosByText(mInfo, paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new AccessibilityNodeInfoCompat(paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String paramString)
  {
    paramString = IMPL.findAccessibilityNodeInfosByViewId(mInfo, paramString);
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(new AccessibilityNodeInfoCompat(localIterator.next()));
      }
    }
    paramString = Collections.emptyList();
    return paramString;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return wrapNonNullInstance(IMPL.findFocus(mInfo, paramInt));
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    return wrapNonNullInstance(IMPL.focusSearch(mInfo, paramInt));
  }
  
  public List<AccessibilityActionCompat> getActionList()
  {
    List localList = IMPL.getActionList(mInfo);
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = localList.size();
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(new AccessibilityActionCompat(localList.get(i)));
        i += 1;
      }
    }
    Object localObject = Collections.emptyList();
    return localObject;
  }
  
  public int getActions()
  {
    return IMPL.getActions(mInfo);
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(mInfo, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(mInfo, paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(IMPL.getChild(mInfo, paramInt));
  }
  
  public int getChildCount()
  {
    return IMPL.getChildCount(mInfo);
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName(mInfo);
  }
  
  public CollectionInfoCompat getCollectionInfo()
  {
    Object localObject = IMPL.getCollectionInfo(mInfo);
    if (localObject == null) {
      return null;
    }
    return new CollectionInfoCompat(localObject);
  }
  
  public CollectionItemInfoCompat getCollectionItemInfo()
  {
    Object localObject = IMPL.getCollectionItemInfo(mInfo);
    if (localObject == null) {
      return null;
    }
    return new CollectionItemInfoCompat(localObject);
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription(mInfo);
  }
  
  public int getDrawingOrder()
  {
    return IMPL.getDrawingOrder(mInfo);
  }
  
  public CharSequence getError()
  {
    return IMPL.getError(mInfo);
  }
  
  public Bundle getExtras()
  {
    return IMPL.getExtras(mInfo);
  }
  
  public Object getInfo()
  {
    return mInfo;
  }
  
  public int getInputType()
  {
    return IMPL.getInputType(mInfo);
  }
  
  public AccessibilityNodeInfoCompat getLabelFor()
  {
    return wrapNonNullInstance(IMPL.getLabelFor(mInfo));
  }
  
  public AccessibilityNodeInfoCompat getLabeledBy()
  {
    return wrapNonNullInstance(IMPL.getLabeledBy(mInfo));
  }
  
  public int getLiveRegion()
  {
    return IMPL.getLiveRegion(mInfo);
  }
  
  public int getMaxTextLength()
  {
    return IMPL.getMaxTextLength(mInfo);
  }
  
  public int getMovementGranularities()
  {
    return IMPL.getMovementGranularities(mInfo);
  }
  
  public CharSequence getPackageName()
  {
    return IMPL.getPackageName(mInfo);
  }
  
  public AccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(IMPL.getParent(mInfo));
  }
  
  public RangeInfoCompat getRangeInfo()
  {
    Object localObject = IMPL.getRangeInfo(mInfo);
    if (localObject == null) {
      return null;
    }
    return new RangeInfoCompat(localObject);
  }
  
  @Nullable
  public CharSequence getRoleDescription()
  {
    return IMPL.getRoleDescription(mInfo);
  }
  
  public CharSequence getText()
  {
    return IMPL.getText(mInfo);
  }
  
  public int getTextSelectionEnd()
  {
    return IMPL.getTextSelectionEnd(mInfo);
  }
  
  public int getTextSelectionStart()
  {
    return IMPL.getTextSelectionStart(mInfo);
  }
  
  public AccessibilityNodeInfoCompat getTraversalAfter()
  {
    return wrapNonNullInstance(IMPL.getTraversalAfter(mInfo));
  }
  
  public AccessibilityNodeInfoCompat getTraversalBefore()
  {
    return wrapNonNullInstance(IMPL.getTraversalBefore(mInfo));
  }
  
  public String getViewIdResourceName()
  {
    return IMPL.getViewIdResourceName(mInfo);
  }
  
  public AccessibilityWindowInfoCompat getWindow()
  {
    return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(mInfo));
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId(mInfo);
  }
  
  public int hashCode()
  {
    if (mInfo == null) {
      return 0;
    }
    return mInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    return IMPL.isAccessibilityFocused(mInfo);
  }
  
  public boolean isCheckable()
  {
    return IMPL.isCheckable(mInfo);
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked(mInfo);
  }
  
  public boolean isClickable()
  {
    return IMPL.isClickable(mInfo);
  }
  
  public boolean isContentInvalid()
  {
    return IMPL.isContentInvalid(mInfo);
  }
  
  public boolean isContextClickable()
  {
    return IMPL.isContextClickable(mInfo);
  }
  
  public boolean isDismissable()
  {
    return IMPL.isDismissable(mInfo);
  }
  
  public boolean isEditable()
  {
    return IMPL.isEditable(mInfo);
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled(mInfo);
  }
  
  public boolean isFocusable()
  {
    return IMPL.isFocusable(mInfo);
  }
  
  public boolean isFocused()
  {
    return IMPL.isFocused(mInfo);
  }
  
  public boolean isImportantForAccessibility()
  {
    return IMPL.isImportantForAccessibility(mInfo);
  }
  
  public boolean isLongClickable()
  {
    return IMPL.isLongClickable(mInfo);
  }
  
  public boolean isMultiLine()
  {
    return IMPL.isMultiLine(mInfo);
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword(mInfo);
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable(mInfo);
  }
  
  public boolean isSelected()
  {
    return IMPL.isSelected(mInfo);
  }
  
  public boolean isVisibleToUser()
  {
    return IMPL.isVisibleToUser(mInfo);
  }
  
  public boolean performAction(int paramInt)
  {
    return IMPL.performAction(mInfo, paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    return IMPL.performAction(mInfo, paramInt, paramBundle);
  }
  
  public void recycle()
  {
    IMPL.recycle(mInfo);
  }
  
  public boolean refresh()
  {
    return IMPL.refresh(mInfo);
  }
  
  public boolean removeAction(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    return IMPL.removeAction(mInfo, mAction);
  }
  
  public boolean removeChild(View paramView)
  {
    return IMPL.removeChild(mInfo, paramView);
  }
  
  public boolean removeChild(View paramView, int paramInt)
  {
    return IMPL.removeChild(mInfo, paramView, paramInt);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    IMPL.setAccessibilityFocused(mInfo, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    IMPL.setBoundsInParent(mInfo, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    IMPL.setBoundsInScreen(mInfo, paramRect);
  }
  
  public void setCanOpenPopup(boolean paramBoolean)
  {
    IMPL.setCanOpenPopup(mInfo, paramBoolean);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    IMPL.setCheckable(mInfo, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    IMPL.setChecked(mInfo, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(mInfo, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMPL.setClickable(mInfo, paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject)
  {
    IMPL.setCollectionInfo(mInfo, mInfo);
  }
  
  public void setCollectionItemInfo(Object paramObject)
  {
    IMPL.setCollectionItemInfo(mInfo, mInfo);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(mInfo, paramCharSequence);
  }
  
  public void setContentInvalid(boolean paramBoolean)
  {
    IMPL.setContentInvalid(mInfo, paramBoolean);
  }
  
  public void setContextClickable(boolean paramBoolean)
  {
    IMPL.setContextClickable(mInfo, paramBoolean);
  }
  
  public void setDismissable(boolean paramBoolean)
  {
    IMPL.setDismissable(mInfo, paramBoolean);
  }
  
  public void setDrawingOrder(int paramInt)
  {
    IMPL.setDrawingOrder(mInfo, paramInt);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    IMPL.setEditable(mInfo, paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(mInfo, paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    IMPL.setError(mInfo, paramCharSequence);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(mInfo, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(mInfo, paramBoolean);
  }
  
  public void setImportantForAccessibility(boolean paramBoolean)
  {
    IMPL.setImportantForAccessibility(mInfo, paramBoolean);
  }
  
  public void setInputType(int paramInt)
  {
    IMPL.setInputType(mInfo, paramInt);
  }
  
  public void setLabelFor(View paramView)
  {
    IMPL.setLabelFor(mInfo, paramView);
  }
  
  public void setLabelFor(View paramView, int paramInt)
  {
    IMPL.setLabelFor(mInfo, paramView, paramInt);
  }
  
  public void setLabeledBy(View paramView)
  {
    IMPL.setLabeledBy(mInfo, paramView);
  }
  
  public void setLabeledBy(View paramView, int paramInt)
  {
    IMPL.setLabeledBy(mInfo, paramView, paramInt);
  }
  
  public void setLiveRegion(int paramInt)
  {
    IMPL.setLiveRegion(mInfo, paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    IMPL.setLongClickable(mInfo, paramBoolean);
  }
  
  public void setMaxTextLength(int paramInt)
  {
    IMPL.setMaxTextLength(mInfo, paramInt);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    IMPL.setMovementGranularities(mInfo, paramInt);
  }
  
  public void setMultiLine(boolean paramBoolean)
  {
    IMPL.setMultiLine(mInfo, paramBoolean);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    IMPL.setPackageName(mInfo, paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    IMPL.setParent(mInfo, paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    mParentVirtualDescendantId = paramInt;
    IMPL.setParent(mInfo, paramView, paramInt);
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(mInfo, paramBoolean);
  }
  
  public void setRangeInfo(RangeInfoCompat paramRangeInfoCompat)
  {
    IMPL.setRangeInfo(mInfo, mInfo);
  }
  
  public void setRoleDescription(@Nullable CharSequence paramCharSequence)
  {
    IMPL.setRoleDescription(mInfo, paramCharSequence);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(mInfo, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    IMPL.setSelected(mInfo, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(mInfo, paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    IMPL.setSource(mInfo, paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    IMPL.setText(mInfo, paramCharSequence);
  }
  
  public void setTextSelection(int paramInt1, int paramInt2)
  {
    IMPL.setTextSelection(mInfo, paramInt1, paramInt2);
  }
  
  public void setTraversalAfter(View paramView)
  {
    IMPL.setTraversalAfter(mInfo, paramView);
  }
  
  public void setTraversalAfter(View paramView, int paramInt)
  {
    IMPL.setTraversalAfter(mInfo, paramView, paramInt);
  }
  
  public void setTraversalBefore(View paramView)
  {
    IMPL.setTraversalBefore(mInfo, paramView);
  }
  
  public void setTraversalBefore(View paramView, int paramInt)
  {
    IMPL.setTraversalBefore(mInfo, paramView, paramInt);
  }
  
  public void setViewIdResourceName(String paramString)
  {
    IMPL.setViewIdResourceName(mInfo, paramString);
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    IMPL.setVisibleToUser(mInfo, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Rect localRect = new Rect();
    getBoundsInParent(localRect);
    localStringBuilder.append("; boundsInParent: " + localRect);
    getBoundsInScreen(localRect);
    localStringBuilder.append("; boundsInScreen: " + localRect);
    localStringBuilder.append("; packageName: ").append(getPackageName());
    localStringBuilder.append("; className: ").append(getClassName());
    localStringBuilder.append("; text: ").append(getText());
    localStringBuilder.append("; contentDescription: ").append(getContentDescription());
    localStringBuilder.append("; viewId: ").append(getViewIdResourceName());
    localStringBuilder.append("; checkable: ").append(isCheckable());
    localStringBuilder.append("; checked: ").append(isChecked());
    localStringBuilder.append("; focusable: ").append(isFocusable());
    localStringBuilder.append("; focused: ").append(isFocused());
    localStringBuilder.append("; selected: ").append(isSelected());
    localStringBuilder.append("; clickable: ").append(isClickable());
    localStringBuilder.append("; longClickable: ").append(isLongClickable());
    localStringBuilder.append("; enabled: ").append(isEnabled());
    localStringBuilder.append("; password: ").append(isPassword());
    localStringBuilder.append("; scrollable: " + isScrollable());
    localStringBuilder.append("; [");
    int i = getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder.append(getActionSymbolicName(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder.append(", ");
        i = j;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class AccessibilityActionCompat
  {
    public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityActionCompat ACTION_COLLAPSE;
    public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionContextClick());
    public static final AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityActionCompat ACTION_DISMISS;
    public static final AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
    public static final AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
    public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
    public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    public static final AccessibilityActionCompat ACTION_SCROLL_UP;
    public static final AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityActionCompat ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionSetProgress());
    public static final AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityActionCompat ACTION_SET_TEXT;
    public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    final Object mAction;
    
    static
    {
      ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
      ACTION_SELECT = new AccessibilityActionCompat(4, null);
      ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
      ACTION_CLICK = new AccessibilityActionCompat(16, null);
      ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
      ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
      ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
      ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null);
      ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null);
      ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null);
      ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null);
      ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
      ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
      ACTION_COPY = new AccessibilityActionCompat(16384, null);
      ACTION_PASTE = new AccessibilityActionCompat(32768, null);
      ACTION_CUT = new AccessibilityActionCompat(65536, null);
      ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null);
      ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
      ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
      ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
      ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null);
      ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionShowOnScreen());
      ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollToPosition());
      ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollUp());
      ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollLeft());
      ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollDown());
      ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollRight());
    }
    
    public AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence)
    {
      this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(paramInt, paramCharSequence));
    }
    
    AccessibilityActionCompat(Object paramObject)
    {
      mAction = paramObject;
    }
    
    public int getId()
    {
      return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(mAction);
    }
    
    public CharSequence getLabel()
    {
      return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(mAction);
    }
  }
  
  static class AccessibilityNodeInfoApi21Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl
  {
    AccessibilityNodeInfoApi21Impl() {}
    
    public void addAction(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatApi21.addAction(paramObject1, paramObject2);
    }
    
    public int getAccessibilityActionId(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(paramObject);
    }
    
    public CharSequence getAccessibilityActionLabel(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(paramObject);
    }
    
    public List<Object> getActionList(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getActionList(paramObject);
    }
    
    public int getCollectionInfoSelectionMode(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.CollectionInfo.getSelectionMode(paramObject);
    }
    
    public CharSequence getError(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getError(paramObject);
    }
    
    public int getMaxTextLength(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getMaxTextLength(paramObject);
    }
    
    public Object getWindow(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.getWindow(paramObject);
    }
    
    public boolean isCollectionItemSelected(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(paramObject);
    }
    
    public Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence)
    {
      return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(paramInt, paramCharSequence);
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3);
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2);
    }
    
    public boolean removeAction(Object paramObject1, Object paramObject2)
    {
      return AccessibilityNodeInfoCompatApi21.removeAction(paramObject1, paramObject2);
    }
    
    public boolean removeChild(Object paramObject, View paramView)
    {
      return AccessibilityNodeInfoCompatApi21.removeChild(paramObject, paramView);
    }
    
    public boolean removeChild(Object paramObject, View paramView, int paramInt)
    {
      return AccessibilityNodeInfoCompatApi21.removeChild(paramObject, paramView, paramInt);
    }
    
    public void setError(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatApi21.setError(paramObject, paramCharSequence);
    }
    
    public void setMaxTextLength(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatApi21.setMaxTextLength(paramObject, paramInt);
    }
  }
  
  static class AccessibilityNodeInfoApi22Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl
  {
    AccessibilityNodeInfoApi22Impl() {}
    
    public Object getTraversalAfter(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi22.getTraversalAfter(paramObject);
    }
    
    public Object getTraversalBefore(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi22.getTraversalBefore(paramObject);
    }
    
    public void setTraversalAfter(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(paramObject, paramView);
    }
    
    public void setTraversalAfter(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(paramObject, paramView, paramInt);
    }
    
    public void setTraversalBefore(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(paramObject, paramView);
    }
    
    public void setTraversalBefore(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(paramObject, paramView, paramInt);
    }
  }
  
  static class AccessibilityNodeInfoApi23Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi22Impl
  {
    AccessibilityNodeInfoApi23Impl() {}
    
    public Object getActionContextClick()
    {
      return AccessibilityNodeInfoCompatApi23.getActionContextClick();
    }
    
    public Object getActionScrollDown()
    {
      return AccessibilityNodeInfoCompatApi23.getActionScrollDown();
    }
    
    public Object getActionScrollLeft()
    {
      return AccessibilityNodeInfoCompatApi23.getActionScrollLeft();
    }
    
    public Object getActionScrollRight()
    {
      return AccessibilityNodeInfoCompatApi23.getActionScrollRight();
    }
    
    public Object getActionScrollToPosition()
    {
      return AccessibilityNodeInfoCompatApi23.getActionScrollToPosition();
    }
    
    public Object getActionScrollUp()
    {
      return AccessibilityNodeInfoCompatApi23.getActionScrollUp();
    }
    
    public Object getActionShowOnScreen()
    {
      return AccessibilityNodeInfoCompatApi23.getActionShowOnScreen();
    }
    
    public boolean isContextClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi23.isContextClickable(paramObject);
    }
    
    public void setContextClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatApi23.setContextClickable(paramObject, paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoApi24Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi23Impl
  {
    AccessibilityNodeInfoApi24Impl() {}
    
    public Object getActionSetProgress()
    {
      return AccessibilityNodeInfoCompatApi24.getActionSetProgress();
    }
    
    public int getDrawingOrder(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi24.getDrawingOrder(paramObject);
    }
    
    public boolean isImportantForAccessibility(Object paramObject)
    {
      return AccessibilityNodeInfoCompatApi24.isImportantForAccessibility(paramObject);
    }
    
    public void setDrawingOrder(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatApi24.setDrawingOrder(paramObject, paramInt);
    }
    
    public void setImportantForAccessibility(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatApi24.setImportantForAccessibility(paramObject, paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoIcsImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
  {
    AccessibilityNodeInfoIcsImpl() {}
    
    public void addAction(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatIcs.addAction(paramObject, paramInt);
    }
    
    public void addChild(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.addChild(paramObject, paramView);
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(paramObject, paramString);
    }
    
    public int getActions(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getActions(paramObject);
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.getBoundsInParent(paramObject, paramRect);
    }
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.getBoundsInScreen(paramObject, paramRect);
    }
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatIcs.getChild(paramObject, paramInt);
    }
    
    public int getChildCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getChildCount(paramObject);
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getClassName(paramObject);
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getContentDescription(paramObject);
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getPackageName(paramObject);
    }
    
    public Object getParent(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getParent(paramObject);
    }
    
    public CharSequence getText(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getText(paramObject);
    }
    
    public int getWindowId(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.getWindowId(paramObject);
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isCheckable(paramObject);
    }
    
    public boolean isChecked(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isChecked(paramObject);
    }
    
    public boolean isClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isClickable(paramObject);
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isEnabled(paramObject);
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isFocusable(paramObject);
    }
    
    public boolean isFocused(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isFocused(paramObject);
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isLongClickable(paramObject);
    }
    
    public boolean isPassword(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isPassword(paramObject);
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isScrollable(paramObject);
    }
    
    public boolean isSelected(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.isSelected(paramObject);
    }
    
    public Object obtain()
    {
      return AccessibilityNodeInfoCompatIcs.obtain();
    }
    
    public Object obtain(View paramView)
    {
      return AccessibilityNodeInfoCompatIcs.obtain(paramView);
    }
    
    public Object obtain(Object paramObject)
    {
      return AccessibilityNodeInfoCompatIcs.obtain(paramObject);
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatIcs.performAction(paramObject, paramInt);
    }
    
    public void recycle(Object paramObject)
    {
      AccessibilityNodeInfoCompatIcs.recycle(paramObject);
    }
    
    public void setBoundsInParent(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.setBoundsInParent(paramObject, paramRect);
    }
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect)
    {
      AccessibilityNodeInfoCompatIcs.setBoundsInScreen(paramObject, paramRect);
    }
    
    public void setCheckable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setCheckable(paramObject, paramBoolean);
    }
    
    public void setChecked(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setChecked(paramObject, paramBoolean);
    }
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setClassName(paramObject, paramCharSequence);
    }
    
    public void setClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setClickable(paramObject, paramBoolean);
    }
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setContentDescription(paramObject, paramCharSequence);
    }
    
    public void setEnabled(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setEnabled(paramObject, paramBoolean);
    }
    
    public void setFocusable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setFocusable(paramObject, paramBoolean);
    }
    
    public void setFocused(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setFocused(paramObject, paramBoolean);
    }
    
    public void setLongClickable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setLongClickable(paramObject, paramBoolean);
    }
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setPackageName(paramObject, paramCharSequence);
    }
    
    public void setParent(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.setParent(paramObject, paramView);
    }
    
    public void setPassword(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setPassword(paramObject, paramBoolean);
    }
    
    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setScrollable(paramObject, paramBoolean);
    }
    
    public void setSelected(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatIcs.setSelected(paramObject, paramBoolean);
    }
    
    public void setSource(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatIcs.setSource(paramObject, paramView);
    }
    
    public void setText(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatIcs.setText(paramObject, paramCharSequence);
    }
  }
  
  static abstract interface AccessibilityNodeInfoImpl
  {
    public abstract void addAction(Object paramObject, int paramInt);
    
    public abstract void addAction(Object paramObject1, Object paramObject2);
    
    public abstract void addChild(Object paramObject, View paramView);
    
    public abstract void addChild(Object paramObject, View paramView, int paramInt);
    
    public abstract boolean canOpenPopup(Object paramObject);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString);
    
    public abstract List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString);
    
    public abstract Object findFocus(Object paramObject, int paramInt);
    
    public abstract Object focusSearch(Object paramObject, int paramInt);
    
    public abstract int getAccessibilityActionId(Object paramObject);
    
    public abstract CharSequence getAccessibilityActionLabel(Object paramObject);
    
    public abstract Object getActionContextClick();
    
    public abstract List<Object> getActionList(Object paramObject);
    
    public abstract Object getActionScrollDown();
    
    public abstract Object getActionScrollLeft();
    
    public abstract Object getActionScrollRight();
    
    public abstract Object getActionScrollToPosition();
    
    public abstract Object getActionScrollUp();
    
    public abstract Object getActionSetProgress();
    
    public abstract Object getActionShowOnScreen();
    
    public abstract int getActions(Object paramObject);
    
    public abstract void getBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract Object getChild(Object paramObject, int paramInt);
    
    public abstract int getChildCount(Object paramObject);
    
    public abstract CharSequence getClassName(Object paramObject);
    
    public abstract Object getCollectionInfo(Object paramObject);
    
    public abstract int getCollectionInfoColumnCount(Object paramObject);
    
    public abstract int getCollectionInfoRowCount(Object paramObject);
    
    public abstract int getCollectionInfoSelectionMode(Object paramObject);
    
    public abstract int getCollectionItemColumnIndex(Object paramObject);
    
    public abstract int getCollectionItemColumnSpan(Object paramObject);
    
    public abstract Object getCollectionItemInfo(Object paramObject);
    
    public abstract int getCollectionItemRowIndex(Object paramObject);
    
    public abstract int getCollectionItemRowSpan(Object paramObject);
    
    public abstract CharSequence getContentDescription(Object paramObject);
    
    public abstract int getDrawingOrder(Object paramObject);
    
    public abstract CharSequence getError(Object paramObject);
    
    public abstract Bundle getExtras(Object paramObject);
    
    public abstract int getInputType(Object paramObject);
    
    public abstract Object getLabelFor(Object paramObject);
    
    public abstract Object getLabeledBy(Object paramObject);
    
    public abstract int getLiveRegion(Object paramObject);
    
    public abstract int getMaxTextLength(Object paramObject);
    
    public abstract int getMovementGranularities(Object paramObject);
    
    public abstract CharSequence getPackageName(Object paramObject);
    
    public abstract Object getParent(Object paramObject);
    
    public abstract Object getRangeInfo(Object paramObject);
    
    public abstract CharSequence getRoleDescription(Object paramObject);
    
    public abstract CharSequence getText(Object paramObject);
    
    public abstract int getTextSelectionEnd(Object paramObject);
    
    public abstract int getTextSelectionStart(Object paramObject);
    
    public abstract Object getTraversalAfter(Object paramObject);
    
    public abstract Object getTraversalBefore(Object paramObject);
    
    public abstract String getViewIdResourceName(Object paramObject);
    
    public abstract Object getWindow(Object paramObject);
    
    public abstract int getWindowId(Object paramObject);
    
    public abstract boolean isAccessibilityFocused(Object paramObject);
    
    public abstract boolean isCheckable(Object paramObject);
    
    public abstract boolean isChecked(Object paramObject);
    
    public abstract boolean isClickable(Object paramObject);
    
    public abstract boolean isCollectionInfoHierarchical(Object paramObject);
    
    public abstract boolean isCollectionItemHeading(Object paramObject);
    
    public abstract boolean isCollectionItemSelected(Object paramObject);
    
    public abstract boolean isContentInvalid(Object paramObject);
    
    public abstract boolean isContextClickable(Object paramObject);
    
    public abstract boolean isDismissable(Object paramObject);
    
    public abstract boolean isEditable(Object paramObject);
    
    public abstract boolean isEnabled(Object paramObject);
    
    public abstract boolean isFocusable(Object paramObject);
    
    public abstract boolean isFocused(Object paramObject);
    
    public abstract boolean isImportantForAccessibility(Object paramObject);
    
    public abstract boolean isLongClickable(Object paramObject);
    
    public abstract boolean isMultiLine(Object paramObject);
    
    public abstract boolean isPassword(Object paramObject);
    
    public abstract boolean isScrollable(Object paramObject);
    
    public abstract boolean isSelected(Object paramObject);
    
    public abstract boolean isVisibleToUser(Object paramObject);
    
    public abstract Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence);
    
    public abstract Object obtain();
    
    public abstract Object obtain(View paramView);
    
    public abstract Object obtain(View paramView, int paramInt);
    
    public abstract Object obtain(Object paramObject);
    
    public abstract Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean);
    
    public abstract Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
    
    public abstract Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
    
    public abstract Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract Object obtainRangeInfo(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract boolean performAction(Object paramObject, int paramInt);
    
    public abstract boolean performAction(Object paramObject, int paramInt, Bundle paramBundle);
    
    public abstract void recycle(Object paramObject);
    
    public abstract boolean refresh(Object paramObject);
    
    public abstract boolean removeAction(Object paramObject1, Object paramObject2);
    
    public abstract boolean removeChild(Object paramObject, View paramView);
    
    public abstract boolean removeChild(Object paramObject, View paramView, int paramInt);
    
    public abstract void setAccessibilityFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void setBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract void setCanOpenPopup(Object paramObject, boolean paramBoolean);
    
    public abstract void setCheckable(Object paramObject, boolean paramBoolean);
    
    public abstract void setChecked(Object paramObject, boolean paramBoolean);
    
    public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setCollectionInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setCollectionItemInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setContentInvalid(Object paramObject, boolean paramBoolean);
    
    public abstract void setContextClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setDismissable(Object paramObject, boolean paramBoolean);
    
    public abstract void setDrawingOrder(Object paramObject, int paramInt);
    
    public abstract void setEditable(Object paramObject, boolean paramBoolean);
    
    public abstract void setEnabled(Object paramObject, boolean paramBoolean);
    
    public abstract void setError(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setFocusable(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setImportantForAccessibility(Object paramObject, boolean paramBoolean);
    
    public abstract void setInputType(Object paramObject, int paramInt);
    
    public abstract void setLabelFor(Object paramObject, View paramView);
    
    public abstract void setLabelFor(Object paramObject, View paramView, int paramInt);
    
    public abstract void setLabeledBy(Object paramObject, View paramView);
    
    public abstract void setLabeledBy(Object paramObject, View paramView, int paramInt);
    
    public abstract void setLiveRegion(Object paramObject, int paramInt);
    
    public abstract void setLongClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setMaxTextLength(Object paramObject, int paramInt);
    
    public abstract void setMovementGranularities(Object paramObject, int paramInt);
    
    public abstract void setMultiLine(Object paramObject, boolean paramBoolean);
    
    public abstract void setPackageName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setParent(Object paramObject, View paramView);
    
    public abstract void setParent(Object paramObject, View paramView, int paramInt);
    
    public abstract void setPassword(Object paramObject, boolean paramBoolean);
    
    public abstract void setRangeInfo(Object paramObject1, Object paramObject2);
    
    public abstract void setRoleDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setSelected(Object paramObject, boolean paramBoolean);
    
    public abstract void setSource(Object paramObject, View paramView);
    
    public abstract void setSource(Object paramObject, View paramView, int paramInt);
    
    public abstract void setText(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setTextSelection(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract void setTraversalAfter(Object paramObject, View paramView);
    
    public abstract void setTraversalAfter(Object paramObject, View paramView, int paramInt);
    
    public abstract void setTraversalBefore(Object paramObject, View paramView);
    
    public abstract void setTraversalBefore(Object paramObject, View paramView, int paramInt);
    
    public abstract void setViewIdResourceName(Object paramObject, String paramString);
    
    public abstract void setVisibleToUser(Object paramObject, boolean paramBoolean);
  }
  
  static class AccessibilityNodeInfoJellybeanImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
  {
    AccessibilityNodeInfoJellybeanImpl() {}
    
    public void addChild(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.addChild(paramObject, paramView, paramInt);
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.findFocus(paramObject, paramInt);
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.focusSearch(paramObject, paramInt);
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(paramObject);
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(paramObject);
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(paramObject);
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return AccessibilityNodeInfoCompatJellyBean.obtain(paramView, paramInt);
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return AccessibilityNodeInfoCompatJellyBean.performAction(paramObject, paramInt, paramBundle);
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(paramObject, paramBoolean);
    }
    
    public void setMovementGranularities(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(paramObject, paramInt);
    }
    
    public void setParent(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setParent(paramObject, paramView, paramInt);
    }
    
    public void setSource(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellyBean.setSource(paramObject, paramView, paramInt);
    }
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(paramObject, paramBoolean);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr1Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl
  {
    AccessibilityNodeInfoJellybeanMr1Impl() {}
    
    public Object getLabelFor(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(paramObject);
    }
    
    public Object getLabeledBy(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(paramObject);
    }
    
    public void setLabelFor(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(paramObject, paramView);
    }
    
    public void setLabelFor(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(paramObject, paramView, paramInt);
    }
    
    public void setLabeledBy(Object paramObject, View paramView)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(paramObject, paramView);
    }
    
    public void setLabeledBy(Object paramObject, View paramView, int paramInt)
    {
      AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(paramObject, paramView, paramInt);
    }
  }
  
  static class AccessibilityNodeInfoJellybeanMr2Impl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr1Impl
  {
    AccessibilityNodeInfoJellybeanMr2Impl() {}
    
    public List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(paramObject, paramString);
    }
    
    public int getTextSelectionEnd(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(paramObject);
    }
    
    public int getTextSelectionStart(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(paramObject);
    }
    
    public String getViewIdResourceName(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(paramObject);
    }
    
    public boolean isEditable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(paramObject);
    }
    
    public boolean refresh(Object paramObject)
    {
      return AccessibilityNodeInfoCompatJellybeanMr2.refresh(paramObject);
    }
    
    public void setEditable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatJellybeanMr2.setEditable(paramObject, paramBoolean);
    }
    
    public void setTextSelection(Object paramObject, int paramInt1, int paramInt2)
    {
      AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(paramObject, paramInt1, paramInt2);
    }
    
    public void setViewIdResourceName(Object paramObject, String paramString)
    {
      AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(paramObject, paramString);
    }
  }
  
  static class AccessibilityNodeInfoKitKatImpl
    extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl
  {
    AccessibilityNodeInfoKitKatImpl() {}
    
    public boolean canOpenPopup(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.canOpenPopup(paramObject);
    }
    
    public Object getCollectionInfo(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(paramObject);
    }
    
    public int getCollectionInfoColumnCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(paramObject);
    }
    
    public int getCollectionInfoRowCount(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(paramObject);
    }
    
    public int getCollectionItemColumnIndex(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(paramObject);
    }
    
    public int getCollectionItemColumnSpan(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(paramObject);
    }
    
    public Object getCollectionItemInfo(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(paramObject);
    }
    
    public int getCollectionItemRowIndex(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(paramObject);
    }
    
    public int getCollectionItemRowSpan(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(paramObject);
    }
    
    public Bundle getExtras(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getExtras(paramObject);
    }
    
    public int getInputType(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getInputType(paramObject);
    }
    
    public int getLiveRegion(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getLiveRegion(paramObject);
    }
    
    public Object getRangeInfo(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getRangeInfo(paramObject);
    }
    
    public CharSequence getRoleDescription(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.getRoleDescription(paramObject);
    }
    
    public boolean isCollectionInfoHierarchical(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(paramObject);
    }
    
    public boolean isCollectionItemHeading(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(paramObject);
    }
    
    public boolean isContentInvalid(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.isContentInvalid(paramObject);
    }
    
    public boolean isDismissable(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.isDismissable(paramObject);
    }
    
    public boolean isMultiLine(Object paramObject)
    {
      return AccessibilityNodeInfoCompatKitKat.isMultiLine(paramObject);
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean);
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3);
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
    }
    
    public Object obtainRangeInfo(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return AccessibilityNodeInfoCompatKitKat.obtainRangeInfo(paramInt, paramFloat1, paramFloat2, paramFloat3);
    }
    
    public void setCanOpenPopup(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(paramObject, paramBoolean);
    }
    
    public void setCollectionInfo(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatKitKat.setCollectionInfo(paramObject1, paramObject2);
    }
    
    public void setCollectionItemInfo(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(paramObject1, paramObject2);
    }
    
    public void setContentInvalid(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setContentInvalid(paramObject, paramBoolean);
    }
    
    public void setDismissable(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setDismissable(paramObject, paramBoolean);
    }
    
    public void setInputType(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatKitKat.setInputType(paramObject, paramInt);
    }
    
    public void setLiveRegion(Object paramObject, int paramInt)
    {
      AccessibilityNodeInfoCompatKitKat.setLiveRegion(paramObject, paramInt);
    }
    
    public void setMultiLine(Object paramObject, boolean paramBoolean)
    {
      AccessibilityNodeInfoCompatKitKat.setMultiLine(paramObject, paramBoolean);
    }
    
    public void setRangeInfo(Object paramObject1, Object paramObject2)
    {
      AccessibilityNodeInfoCompatKitKat.setRangeInfo(paramObject1, paramObject2);
    }
    
    public void setRoleDescription(Object paramObject, CharSequence paramCharSequence)
    {
      AccessibilityNodeInfoCompatKitKat.setRoleDescription(paramObject, paramCharSequence);
    }
  }
  
  static class AccessibilityNodeInfoStubImpl
    implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
  {
    AccessibilityNodeInfoStubImpl() {}
    
    public void addAction(Object paramObject, int paramInt) {}
    
    public void addAction(Object paramObject1, Object paramObject2) {}
    
    public void addChild(Object paramObject, View paramView) {}
    
    public void addChild(Object paramObject, View paramView, int paramInt) {}
    
    public boolean canOpenPopup(Object paramObject)
    {
      return false;
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return Collections.emptyList();
    }
    
    public List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString)
    {
      return Collections.emptyList();
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getAccessibilityActionId(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getAccessibilityActionLabel(Object paramObject)
    {
      return null;
    }
    
    public Object getActionContextClick()
    {
      return null;
    }
    
    public List<Object> getActionList(Object paramObject)
    {
      return null;
    }
    
    public Object getActionScrollDown()
    {
      return null;
    }
    
    public Object getActionScrollLeft()
    {
      return null;
    }
    
    public Object getActionScrollRight()
    {
      return null;
    }
    
    public Object getActionScrollToPosition()
    {
      return null;
    }
    
    public Object getActionScrollUp()
    {
      return null;
    }
    
    public Object getActionSetProgress()
    {
      return null;
    }
    
    public Object getActionShowOnScreen()
    {
      return null;
    }
    
    public int getActions(Object paramObject)
    {
      return 0;
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getChildCount(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return null;
    }
    
    public Object getCollectionInfo(Object paramObject)
    {
      return null;
    }
    
    public int getCollectionInfoColumnCount(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionInfoRowCount(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionInfoSelectionMode(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionItemColumnIndex(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionItemColumnSpan(Object paramObject)
    {
      return 0;
    }
    
    public Object getCollectionItemInfo(Object paramObject)
    {
      return null;
    }
    
    public int getCollectionItemRowIndex(Object paramObject)
    {
      return 0;
    }
    
    public int getCollectionItemRowSpan(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return null;
    }
    
    public int getDrawingOrder(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getError(Object paramObject)
    {
      return null;
    }
    
    public Bundle getExtras(Object paramObject)
    {
      return new Bundle();
    }
    
    public int getInputType(Object paramObject)
    {
      return 0;
    }
    
    public Object getLabelFor(Object paramObject)
    {
      return null;
    }
    
    public Object getLabeledBy(Object paramObject)
    {
      return null;
    }
    
    public int getLiveRegion(Object paramObject)
    {
      return 0;
    }
    
    public int getMaxTextLength(Object paramObject)
    {
      return -1;
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return null;
    }
    
    public Object getParent(Object paramObject)
    {
      return null;
    }
    
    public Object getRangeInfo(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getRoleDescription(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getText(Object paramObject)
    {
      return null;
    }
    
    public int getTextSelectionEnd(Object paramObject)
    {
      return -1;
    }
    
    public int getTextSelectionStart(Object paramObject)
    {
      return -1;
    }
    
    public Object getTraversalAfter(Object paramObject)
    {
      return null;
    }
    
    public Object getTraversalBefore(Object paramObject)
    {
      return null;
    }
    
    public String getViewIdResourceName(Object paramObject)
    {
      return null;
    }
    
    public Object getWindow(Object paramObject)
    {
      return null;
    }
    
    public int getWindowId(Object paramObject)
    {
      return 0;
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return false;
    }
    
    public boolean isChecked(Object paramObject)
    {
      return false;
    }
    
    public boolean isClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isCollectionInfoHierarchical(Object paramObject)
    {
      return false;
    }
    
    public boolean isCollectionItemHeading(Object paramObject)
    {
      return false;
    }
    
    public boolean isCollectionItemSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isContentInvalid(Object paramObject)
    {
      return false;
    }
    
    public boolean isContextClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isDismissable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEditable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isImportantForAccessibility(Object paramObject)
    {
      return true;
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isMultiLine(Object paramObject)
    {
      return false;
    }
    
    public boolean isPassword(Object paramObject)
    {
      return false;
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return false;
    }
    
    public boolean isSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return false;
    }
    
    public Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence)
    {
      return null;
    }
    
    public Object obtain()
    {
      return null;
    }
    
    public Object obtain(View paramView)
    {
      return null;
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return null;
    }
    
    public Object obtain(Object paramObject)
    {
      return null;
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return null;
    }
    
    public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return null;
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return null;
    }
    
    public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return null;
    }
    
    public Object obtainRangeInfo(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return null;
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void recycle(Object paramObject) {}
    
    public boolean refresh(Object paramObject)
    {
      return false;
    }
    
    public boolean removeAction(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    public boolean removeChild(Object paramObject, View paramView)
    {
      return false;
    }
    
    public boolean removeChild(Object paramObject, View paramView, int paramInt)
    {
      return false;
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public void setCanOpenPopup(Object paramObject, boolean paramBoolean) {}
    
    public void setCheckable(Object paramObject, boolean paramBoolean) {}
    
    public void setChecked(Object paramObject, boolean paramBoolean) {}
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setCollectionInfo(Object paramObject1, Object paramObject2) {}
    
    public void setCollectionItemInfo(Object paramObject1, Object paramObject2) {}
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setContentInvalid(Object paramObject, boolean paramBoolean) {}
    
    public void setContextClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setDismissable(Object paramObject, boolean paramBoolean) {}
    
    public void setDrawingOrder(Object paramObject, int paramInt) {}
    
    public void setEditable(Object paramObject, boolean paramBoolean) {}
    
    public void setEnabled(Object paramObject, boolean paramBoolean) {}
    
    public void setError(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setFocusable(Object paramObject, boolean paramBoolean) {}
    
    public void setFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setImportantForAccessibility(Object paramObject, boolean paramBoolean) {}
    
    public void setInputType(Object paramObject, int paramInt) {}
    
    public void setLabelFor(Object paramObject, View paramView) {}
    
    public void setLabelFor(Object paramObject, View paramView, int paramInt) {}
    
    public void setLabeledBy(Object paramObject, View paramView) {}
    
    public void setLabeledBy(Object paramObject, View paramView, int paramInt) {}
    
    public void setLiveRegion(Object paramObject, int paramInt) {}
    
    public void setLongClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setMaxTextLength(Object paramObject, int paramInt) {}
    
    public void setMovementGranularities(Object paramObject, int paramInt) {}
    
    public void setMultiLine(Object paramObject, boolean paramBoolean) {}
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setParent(Object paramObject, View paramView) {}
    
    public void setParent(Object paramObject, View paramView, int paramInt) {}
    
    public void setPassword(Object paramObject, boolean paramBoolean) {}
    
    public void setRangeInfo(Object paramObject1, Object paramObject2) {}
    
    public void setRoleDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setSelected(Object paramObject, boolean paramBoolean) {}
    
    public void setSource(Object paramObject, View paramView) {}
    
    public void setSource(Object paramObject, View paramView, int paramInt) {}
    
    public void setText(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setTextSelection(Object paramObject, int paramInt1, int paramInt2) {}
    
    public void setTraversalAfter(Object paramObject, View paramView) {}
    
    public void setTraversalAfter(Object paramObject, View paramView, int paramInt) {}
    
    public void setTraversalBefore(Object paramObject, View paramView) {}
    
    public void setTraversalBefore(Object paramObject, View paramView, int paramInt) {}
    
    public void setViewIdResourceName(Object paramObject, String paramString) {}
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
  }
  
  public static class CollectionInfoCompat
  {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    final Object mInfo;
    
    CollectionInfoCompat(Object paramObject)
    {
      mInfo = paramObject;
    }
    
    public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean));
    }
    
    public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(paramInt1, paramInt2, paramBoolean, paramInt3));
    }
    
    public int getColumnCount()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(mInfo);
    }
    
    public int getRowCount()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(mInfo);
    }
    
    public int getSelectionMode()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoSelectionMode(mInfo);
    }
    
    public boolean isHierarchical()
    {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(mInfo);
    }
  }
  
  public static class CollectionItemInfoCompat
  {
    final Object mInfo;
    
    CollectionItemInfoCompat(Object paramObject)
    {
      mInfo = paramObject;
    }
    
    public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
    }
    
    public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
    
    public int getColumnIndex()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(mInfo);
    }
    
    public int getColumnSpan()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(mInfo);
    }
    
    public int getRowIndex()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(mInfo);
    }
    
    public int getRowSpan()
    {
      return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(mInfo);
    }
    
    public boolean isHeading()
    {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(mInfo);
    }
    
    public boolean isSelected()
    {
      return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(mInfo);
    }
  }
  
  public static class RangeInfoCompat
  {
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    final Object mInfo;
    
    RangeInfoCompat(Object paramObject)
    {
      mInfo = paramObject;
    }
    
    public static RangeInfoCompat obtain(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return new RangeInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainRangeInfo(paramInt, paramFloat1, paramFloat2, paramFloat3));
    }
    
    public float getCurrent()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(mInfo);
    }
    
    public float getMax()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(mInfo);
    }
    
    public float getMin()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(mInfo);
    }
    
    public int getType()
    {
      return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(mInfo);
    }
  }
}

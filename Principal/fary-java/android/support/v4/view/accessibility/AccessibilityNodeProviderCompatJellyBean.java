package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(16)
@RequiresApi(16)
class AccessibilityNodeProviderCompatJellyBean
{
  AccessibilityNodeProviderCompatJellyBean() {}
  
  public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge paramAccessibilityNodeInfoBridge)
  {
    new AccessibilityNodeProvider()
    {
      public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        return (AccessibilityNodeInfo)val$bridge.createAccessibilityNodeInfo(paramAnonymousInt);
      }
      
      public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        return val$bridge.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return val$bridge.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    };
  }
  
  static abstract interface AccessibilityNodeInfoBridge
  {
    public abstract Object createAccessibilityNodeInfo(int paramInt);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt);
    
    public abstract boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle);
  }
}

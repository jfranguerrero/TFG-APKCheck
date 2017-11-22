package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;

public class WindowInsetsCompat
{
  private static final WindowInsetsCompatImpl IMPL = new WindowInsetsCompatBaseImpl();
  private final Object mInsets;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      IMPL = new WindowInsetsCompatApi21Impl();
      return;
    }
    if (i >= 20)
    {
      IMPL = new WindowInsetsCompatApi20Impl();
      return;
    }
  }
  
  public WindowInsetsCompat(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat == null) {}
    for (paramWindowInsetsCompat = null;; paramWindowInsetsCompat = IMPL.getSourceWindowInsets(mInsets))
    {
      mInsets = paramWindowInsetsCompat;
      return;
    }
  }
  
  WindowInsetsCompat(Object paramObject)
  {
    mInsets = paramObject;
  }
  
  static Object unwrap(WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat == null) {
      return null;
    }
    return mInsets;
  }
  
  static WindowInsetsCompat wrap(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new WindowInsetsCompat(paramObject);
  }
  
  public WindowInsetsCompat consumeStableInsets()
  {
    return IMPL.consumeStableInsets(mInsets);
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    return IMPL.consumeSystemWindowInsets(mInsets);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (WindowInsetsCompat)paramObject;
      if (mInsets != null) {
        break;
      }
    } while (mInsets == null);
    return false;
    return mInsets.equals(mInsets);
  }
  
  public int getStableInsetBottom()
  {
    return IMPL.getStableInsetBottom(mInsets);
  }
  
  public int getStableInsetLeft()
  {
    return IMPL.getStableInsetLeft(mInsets);
  }
  
  public int getStableInsetRight()
  {
    return IMPL.getStableInsetRight(mInsets);
  }
  
  public int getStableInsetTop()
  {
    return IMPL.getStableInsetTop(mInsets);
  }
  
  public int getSystemWindowInsetBottom()
  {
    return IMPL.getSystemWindowInsetBottom(mInsets);
  }
  
  public int getSystemWindowInsetLeft()
  {
    return IMPL.getSystemWindowInsetLeft(mInsets);
  }
  
  public int getSystemWindowInsetRight()
  {
    return IMPL.getSystemWindowInsetRight(mInsets);
  }
  
  public int getSystemWindowInsetTop()
  {
    return IMPL.getSystemWindowInsetTop(mInsets);
  }
  
  public boolean hasInsets()
  {
    return IMPL.hasInsets(mInsets);
  }
  
  public boolean hasStableInsets()
  {
    return IMPL.hasStableInsets(mInsets);
  }
  
  public boolean hasSystemWindowInsets()
  {
    return IMPL.hasSystemWindowInsets(mInsets);
  }
  
  public int hashCode()
  {
    if (mInsets == null) {
      return 0;
    }
    return mInsets.hashCode();
  }
  
  public boolean isConsumed()
  {
    return IMPL.isConsumed(mInsets);
  }
  
  public boolean isRound()
  {
    return IMPL.isRound(mInsets);
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return IMPL.replaceSystemWindowInsets(mInsets, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect)
  {
    return IMPL.replaceSystemWindowInsets(mInsets, paramRect);
  }
  
  private static class WindowInsetsCompatApi20Impl
    extends WindowInsetsCompat.WindowInsetsCompatBaseImpl
  {
    WindowInsetsCompatApi20Impl() {}
    
    public WindowInsetsCompat consumeSystemWindowInsets(Object paramObject)
    {
      return new WindowInsetsCompat(WindowInsetsCompatApi20.consumeSystemWindowInsets(paramObject));
    }
    
    public Object getSourceWindowInsets(Object paramObject)
    {
      return WindowInsetsCompatApi20.getSourceWindowInsets(paramObject);
    }
    
    public int getSystemWindowInsetBottom(Object paramObject)
    {
      return WindowInsetsCompatApi20.getSystemWindowInsetBottom(paramObject);
    }
    
    public int getSystemWindowInsetLeft(Object paramObject)
    {
      return WindowInsetsCompatApi20.getSystemWindowInsetLeft(paramObject);
    }
    
    public int getSystemWindowInsetRight(Object paramObject)
    {
      return WindowInsetsCompatApi20.getSystemWindowInsetRight(paramObject);
    }
    
    public int getSystemWindowInsetTop(Object paramObject)
    {
      return WindowInsetsCompatApi20.getSystemWindowInsetTop(paramObject);
    }
    
    public boolean hasInsets(Object paramObject)
    {
      return WindowInsetsCompatApi20.hasInsets(paramObject);
    }
    
    public boolean hasSystemWindowInsets(Object paramObject)
    {
      return WindowInsetsCompatApi20.hasSystemWindowInsets(paramObject);
    }
    
    public boolean isRound(Object paramObject)
    {
      return WindowInsetsCompatApi20.isRound(paramObject);
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return new WindowInsetsCompat(WindowInsetsCompatApi20.replaceSystemWindowInsets(paramObject, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  private static class WindowInsetsCompatApi21Impl
    extends WindowInsetsCompat.WindowInsetsCompatApi20Impl
  {
    WindowInsetsCompatApi21Impl() {}
    
    public WindowInsetsCompat consumeStableInsets(Object paramObject)
    {
      return new WindowInsetsCompat(WindowInsetsCompatApi21.consumeStableInsets(paramObject));
    }
    
    public int getStableInsetBottom(Object paramObject)
    {
      return WindowInsetsCompatApi21.getStableInsetBottom(paramObject);
    }
    
    public int getStableInsetLeft(Object paramObject)
    {
      return WindowInsetsCompatApi21.getStableInsetLeft(paramObject);
    }
    
    public int getStableInsetRight(Object paramObject)
    {
      return WindowInsetsCompatApi21.getStableInsetRight(paramObject);
    }
    
    public int getStableInsetTop(Object paramObject)
    {
      return WindowInsetsCompatApi21.getStableInsetTop(paramObject);
    }
    
    public boolean hasStableInsets(Object paramObject)
    {
      return WindowInsetsCompatApi21.hasStableInsets(paramObject);
    }
    
    public boolean isConsumed(Object paramObject)
    {
      return WindowInsetsCompatApi21.isConsumed(paramObject);
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object paramObject, Rect paramRect)
    {
      return new WindowInsetsCompat(WindowInsetsCompatApi21.replaceSystemWindowInsets(paramObject, paramRect));
    }
  }
  
  private static class WindowInsetsCompatBaseImpl
    implements WindowInsetsCompat.WindowInsetsCompatImpl
  {
    WindowInsetsCompatBaseImpl() {}
    
    public WindowInsetsCompat consumeStableInsets(Object paramObject)
    {
      return null;
    }
    
    public WindowInsetsCompat consumeSystemWindowInsets(Object paramObject)
    {
      return null;
    }
    
    public Object getSourceWindowInsets(Object paramObject)
    {
      return null;
    }
    
    public int getStableInsetBottom(Object paramObject)
    {
      return 0;
    }
    
    public int getStableInsetLeft(Object paramObject)
    {
      return 0;
    }
    
    public int getStableInsetRight(Object paramObject)
    {
      return 0;
    }
    
    public int getStableInsetTop(Object paramObject)
    {
      return 0;
    }
    
    public int getSystemWindowInsetBottom(Object paramObject)
    {
      return 0;
    }
    
    public int getSystemWindowInsetLeft(Object paramObject)
    {
      return 0;
    }
    
    public int getSystemWindowInsetRight(Object paramObject)
    {
      return 0;
    }
    
    public int getSystemWindowInsetTop(Object paramObject)
    {
      return 0;
    }
    
    public boolean hasInsets(Object paramObject)
    {
      return false;
    }
    
    public boolean hasStableInsets(Object paramObject)
    {
      return false;
    }
    
    public boolean hasSystemWindowInsets(Object paramObject)
    {
      return false;
    }
    
    public boolean isConsumed(Object paramObject)
    {
      return false;
    }
    
    public boolean isRound(Object paramObject)
    {
      return false;
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return null;
    }
    
    public WindowInsetsCompat replaceSystemWindowInsets(Object paramObject, Rect paramRect)
    {
      return null;
    }
  }
  
  private static abstract interface WindowInsetsCompatImpl
  {
    public abstract WindowInsetsCompat consumeStableInsets(Object paramObject);
    
    public abstract WindowInsetsCompat consumeSystemWindowInsets(Object paramObject);
    
    public abstract Object getSourceWindowInsets(Object paramObject);
    
    public abstract int getStableInsetBottom(Object paramObject);
    
    public abstract int getStableInsetLeft(Object paramObject);
    
    public abstract int getStableInsetRight(Object paramObject);
    
    public abstract int getStableInsetTop(Object paramObject);
    
    public abstract int getSystemWindowInsetBottom(Object paramObject);
    
    public abstract int getSystemWindowInsetLeft(Object paramObject);
    
    public abstract int getSystemWindowInsetRight(Object paramObject);
    
    public abstract int getSystemWindowInsetTop(Object paramObject);
    
    public abstract boolean hasInsets(Object paramObject);
    
    public abstract boolean hasStableInsets(Object paramObject);
    
    public abstract boolean hasSystemWindowInsets(Object paramObject);
    
    public abstract boolean isConsumed(Object paramObject);
    
    public abstract boolean isRound(Object paramObject);
    
    public abstract WindowInsetsCompat replaceSystemWindowInsets(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract WindowInsetsCompat replaceSystemWindowInsets(Object paramObject, Rect paramRect);
  }
}

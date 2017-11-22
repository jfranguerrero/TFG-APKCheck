package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (systemSupportsPrint())
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        mImpl = new PrintHelperApi24Impl(paramContext);
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        mImpl = new PrintHelperApi23Impl(paramContext);
        return;
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        mImpl = new PrintHelperApi20Impl(paramContext);
        return;
      }
      mImpl = new PrintHelperKitkatImpl(paramContext);
      return;
    }
    mImpl = new PrintHelperStubImpl(null);
  }
  
  public static boolean systemSupportsPrint()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public int getColorMode()
  {
    return mImpl.getColorMode();
  }
  
  public int getOrientation()
  {
    return mImpl.getOrientation();
  }
  
  public int getScaleMode()
  {
    return mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    mImpl.printBitmap(paramString, paramBitmap, null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    mImpl.printBitmap(paramString, paramBitmap, paramOnPrintFinishCallback);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    mImpl.printBitmap(paramString, paramUri, null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    mImpl.printBitmap(paramString, paramUri, paramOnPrintFinishCallback);
  }
  
  public void setColorMode(int paramInt)
  {
    mImpl.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    mImpl.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    mImpl.setScaleMode(paramInt);
  }
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
  
  private static final class PrintHelperApi20Impl
    extends PrintHelper.PrintHelperImpl<PrintHelperApi20>
  {
    PrintHelperApi20Impl(Context paramContext)
    {
      super();
    }
  }
  
  private static final class PrintHelperApi23Impl
    extends PrintHelper.PrintHelperImpl<PrintHelperApi23>
  {
    PrintHelperApi23Impl(Context paramContext)
    {
      super();
    }
  }
  
  private static final class PrintHelperApi24Impl
    extends PrintHelper.PrintHelperImpl<PrintHelperApi24>
  {
    PrintHelperApi24Impl(Context paramContext)
    {
      super();
    }
  }
  
  private static class PrintHelperImpl<RealHelper extends PrintHelperKitkat>
    implements PrintHelper.PrintHelperVersionImpl
  {
    private final RealHelper mPrintHelper;
    
    protected PrintHelperImpl(RealHelper paramRealHelper)
    {
      mPrintHelper = paramRealHelper;
    }
    
    public int getColorMode()
    {
      return mPrintHelper.getColorMode();
    }
    
    public int getOrientation()
    {
      return mPrintHelper.getOrientation();
    }
    
    public int getScaleMode()
    {
      return mPrintHelper.getScaleMode();
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
    {
      PrintHelperKitkat.OnPrintFinishCallback local1 = null;
      if (paramOnPrintFinishCallback != null) {
        local1 = new PrintHelperKitkat.OnPrintFinishCallback()
        {
          public void onFinish()
          {
            paramOnPrintFinishCallback.onFinish();
          }
        };
      }
      mPrintHelper.printBitmap(paramString, paramBitmap, local1);
    }
    
    public void printBitmap(String paramString, Uri paramUri, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
      throws FileNotFoundException
    {
      PrintHelperKitkat.OnPrintFinishCallback local2 = null;
      if (paramOnPrintFinishCallback != null) {
        local2 = new PrintHelperKitkat.OnPrintFinishCallback()
        {
          public void onFinish()
          {
            paramOnPrintFinishCallback.onFinish();
          }
        };
      }
      mPrintHelper.printBitmap(paramString, paramUri, local2);
    }
    
    public void setColorMode(int paramInt)
    {
      mPrintHelper.setColorMode(paramInt);
    }
    
    public void setOrientation(int paramInt)
    {
      mPrintHelper.setOrientation(paramInt);
    }
    
    public void setScaleMode(int paramInt)
    {
      mPrintHelper.setScaleMode(paramInt);
    }
  }
  
  private static final class PrintHelperKitkatImpl
    extends PrintHelper.PrintHelperImpl<PrintHelperKitkat>
  {
    PrintHelperKitkatImpl(Context paramContext)
    {
      super();
    }
  }
  
  private static final class PrintHelperStubImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    int mColorMode = 2;
    int mOrientation = 1;
    int mScaleMode = 2;
    
    private PrintHelperStubImpl() {}
    
    public int getColorMode()
    {
      return mColorMode;
    }
    
    public int getOrientation()
    {
      return mOrientation;
    }
    
    public int getScaleMode()
    {
      return mScaleMode;
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
    
    public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
    
    public void setColorMode(int paramInt)
    {
      mColorMode = paramInt;
    }
    
    public void setOrientation(int paramInt)
    {
      mOrientation = paramInt;
    }
    
    public void setScaleMode(int paramInt)
    {
      mScaleMode = paramInt;
    }
  }
  
  static abstract interface PrintHelperVersionImpl
  {
    public abstract int getColorMode();
    
    public abstract int getOrientation();
    
    public abstract int getScaleMode();
    
    public abstract void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback);
    
    public abstract void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
      throws FileNotFoundException;
    
    public abstract void setColorMode(int paramInt);
    
    public abstract void setOrientation(int paramInt);
    
    public abstract void setScaleMode(int paramInt);
  }
}

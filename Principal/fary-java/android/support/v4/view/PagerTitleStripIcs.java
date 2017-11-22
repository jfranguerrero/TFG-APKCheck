package android.support.v4.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.RequiresApi;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

@TargetApi(14)
@RequiresApi(14)
class PagerTitleStripIcs
{
  PagerTitleStripIcs() {}
  
  public static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new SingleLineAllCapsTransform(paramTextView.getContext()));
  }
  
  private static class SingleLineAllCapsTransform
    extends SingleLineTransformationMethod
  {
    private static final String TAG = "SingleLineAllCapsTransform";
    private Locale mLocale;
    
    public SingleLineAllCapsTransform(Context paramContext)
    {
      mLocale = getResourcesgetConfigurationlocale;
    }
    
    public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      paramCharSequence = super.getTransformation(paramCharSequence, paramView);
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(mLocale);
      }
      return null;
    }
  }
}

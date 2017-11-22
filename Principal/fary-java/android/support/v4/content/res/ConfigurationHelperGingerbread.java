package android.support.v4.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;

@TargetApi(9)
@RequiresApi(9)
class ConfigurationHelperGingerbread
{
  ConfigurationHelperGingerbread() {}
  
  static int getDensityDpi(@NonNull Resources paramResources)
  {
    return getDisplayMetricsdensityDpi;
  }
  
  static int getScreenHeightDp(@NonNull Resources paramResources)
  {
    paramResources = paramResources.getDisplayMetrics();
    return (int)(heightPixels / density);
  }
  
  static int getScreenWidthDp(@NonNull Resources paramResources)
  {
    paramResources = paramResources.getDisplayMetrics();
    return (int)(widthPixels / density);
  }
  
  static int getSmallestScreenWidthDp(@NonNull Resources paramResources)
  {
    return Math.min(getScreenWidthDp(paramResources), getScreenHeightDp(paramResources));
  }
}

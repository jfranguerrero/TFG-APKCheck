package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class MediaControllerCompatApi23
{
  MediaControllerCompatApi23() {}
  
  public static class TransportControls
    extends MediaControllerCompatApi21.TransportControls
  {
    public TransportControls() {}
    
    public static void playFromUri(Object paramObject, Uri paramUri, Bundle paramBundle)
    {
      ((MediaController.TransportControls)paramObject).playFromUri(paramUri, paramBundle);
    }
  }
}

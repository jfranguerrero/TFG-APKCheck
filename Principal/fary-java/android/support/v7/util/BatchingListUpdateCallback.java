package android.support.v7.util;

public class BatchingListUpdateCallback
  implements ListUpdateCallback
{
  private static final int TYPE_ADD = 1;
  private static final int TYPE_CHANGE = 3;
  private static final int TYPE_NONE = 0;
  private static final int TYPE_REMOVE = 2;
  int mLastEventCount = -1;
  Object mLastEventPayload = null;
  int mLastEventPosition = -1;
  int mLastEventType = 0;
  final ListUpdateCallback mWrapped;
  
  public BatchingListUpdateCallback(ListUpdateCallback paramListUpdateCallback)
  {
    mWrapped = paramListUpdateCallback;
  }
  
  public void dispatchLastEvent()
  {
    if (mLastEventType == 0) {
      return;
    }
    switch (mLastEventType)
    {
    }
    for (;;)
    {
      mLastEventPayload = null;
      mLastEventType = 0;
      return;
      mWrapped.onInserted(mLastEventPosition, mLastEventCount);
      continue;
      mWrapped.onRemoved(mLastEventPosition, mLastEventCount);
      continue;
      mWrapped.onChanged(mLastEventPosition, mLastEventCount, mLastEventPayload);
    }
  }
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((mLastEventType == 3) && (paramInt1 <= mLastEventPosition + mLastEventCount) && (paramInt1 + paramInt2 >= mLastEventPosition) && (mLastEventPayload == paramObject))
    {
      int i = mLastEventPosition;
      int j = mLastEventCount;
      mLastEventPosition = Math.min(paramInt1, mLastEventPosition);
      mLastEventCount = (Math.max(i + j, paramInt1 + paramInt2) - mLastEventPosition);
      return;
    }
    dispatchLastEvent();
    mLastEventPosition = paramInt1;
    mLastEventCount = paramInt2;
    mLastEventPayload = paramObject;
    mLastEventType = 3;
  }
  
  public void onInserted(int paramInt1, int paramInt2)
  {
    if ((mLastEventType == 1) && (paramInt1 >= mLastEventPosition) && (paramInt1 <= mLastEventPosition + mLastEventCount))
    {
      mLastEventCount += paramInt2;
      mLastEventPosition = Math.min(paramInt1, mLastEventPosition);
      return;
    }
    dispatchLastEvent();
    mLastEventPosition = paramInt1;
    mLastEventCount = paramInt2;
    mLastEventType = 1;
  }
  
  public void onMoved(int paramInt1, int paramInt2)
  {
    dispatchLastEvent();
    mWrapped.onMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2)
  {
    if ((mLastEventType == 2) && (mLastEventPosition >= paramInt1) && (mLastEventPosition <= paramInt1 + paramInt2))
    {
      mLastEventCount += paramInt2;
      mLastEventPosition = paramInt1;
      return;
    }
    dispatchLastEvent();
    mLastEventPosition = paramInt1;
    mLastEventCount = paramInt2;
    mLastEventType = 2;
  }
}

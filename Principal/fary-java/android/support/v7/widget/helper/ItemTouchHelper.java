package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  static final int ACTION_MODE_DRAG_MASK = 16711680;
  private static final int ACTION_MODE_IDLE_MASK = 255;
  static final int ACTION_MODE_SWIPE_MASK = 65280;
  public static final int ACTION_STATE_DRAG = 2;
  public static final int ACTION_STATE_IDLE = 0;
  public static final int ACTION_STATE_SWIPE = 1;
  static final int ACTIVE_POINTER_ID_NONE = -1;
  public static final int ANIMATION_TYPE_DRAG = 8;
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  static final boolean DEBUG = false;
  static final int DIRECTION_FLAG_COUNT = 8;
  public static final int DOWN = 2;
  public static final int END = 32;
  public static final int LEFT = 4;
  private static final int PIXELS_PER_SECOND = 1000;
  public static final int RIGHT = 8;
  public static final int START = 16;
  static final String TAG = "ItemTouchHelper";
  public static final int UP = 1;
  int mActionState = 0;
  int mActivePointerId = -1;
  Callback mCallback;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
  private List<Integer> mDistances;
  private long mDragScrollStartTimeInMs;
  float mDx;
  float mDy;
  GestureDetectorCompat mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  float mMaxSwipeVelocity;
  private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener()
  {
    public boolean onInterceptTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      int i = MotionEventCompat.getActionMasked(paramAnonymousMotionEvent);
      if (i == 0)
      {
        mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        mInitialTouchX = paramAnonymousMotionEvent.getX();
        mInitialTouchY = paramAnonymousMotionEvent.getY();
        obtainVelocityTracker();
        if (mSelected == null)
        {
          paramAnonymousRecyclerView = findAnimation(paramAnonymousMotionEvent);
          if (paramAnonymousRecyclerView != null)
          {
            ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
            mInitialTouchX -= mX;
            localItemTouchHelper = ItemTouchHelper.this;
            mInitialTouchY -= mY;
            endRecoverAnimation(mViewHolder, true);
            if (mPendingCleanup.remove(mViewHolder.itemView)) {
              mCallback.clearView(mRecyclerView, mViewHolder);
            }
            select(mViewHolder, mActionState);
            updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, 0);
          }
        }
      }
      for (;;)
      {
        if (mVelocityTracker != null) {
          mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        }
        if (mSelected == null) {
          break;
        }
        return true;
        if ((i == 3) || (i == 1))
        {
          mActivePointerId = -1;
          select(null, 0);
        }
        else if (mActivePointerId != -1)
        {
          int j = paramAnonymousMotionEvent.findPointerIndex(mActivePointerId);
          if (j >= 0) {
            checkSelectForSwipe(i, paramAnonymousMotionEvent, j);
          }
        }
      }
      return false;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      select(null, 0);
    }
    
    public void onTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      int i = 0;
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      if (mVelocityTracker != null) {
        mVelocityTracker.addMovement(paramAnonymousMotionEvent);
      }
      if (mActivePointerId == -1) {}
      int j;
      do
      {
        int k;
        do
        {
          return;
          j = MotionEventCompat.getActionMasked(paramAnonymousMotionEvent);
          k = paramAnonymousMotionEvent.findPointerIndex(mActivePointerId);
          if (k >= 0) {
            checkSelectForSwipe(j, paramAnonymousMotionEvent, k);
          }
          paramAnonymousRecyclerView = mSelected;
        } while (paramAnonymousRecyclerView == null);
        switch (j)
        {
        case 4: 
        case 5: 
        default: 
          return;
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            select(null, 0);
            mActivePointerId = -1;
            return;
            if (k < 0) {
              break;
            }
            updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, k);
            moveIfNecessary(paramAnonymousRecyclerView);
            mRecyclerView.removeCallbacks(mScrollRunnable);
            mScrollRunnable.run();
            mRecyclerView.invalidate();
            return;
            if (mVelocityTracker != null) {
              mVelocityTracker.clear();
            }
          }
        }
        j = MotionEventCompat.getActionIndex(paramAnonymousMotionEvent);
      } while (paramAnonymousMotionEvent.getPointerId(j) != mActivePointerId);
      if (j == 0) {
        i = 1;
      }
      mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
      updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, j);
    }
  };
  View mOverdrawChild = null;
  int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  List<RecoverAnimation> mRecoverAnimations = new ArrayList();
  RecyclerView mRecyclerView;
  final Runnable mScrollRunnable = new Runnable()
  {
    public void run()
    {
      if ((mSelected != null) && (scrollIfNecessary()))
      {
        if (mSelected != null) {
          moveIfNecessary(mSelected);
        }
        mRecyclerView.removeCallbacks(mScrollRunnable);
        ViewCompat.postOnAnimation(mRecyclerView, this);
      }
    }
  };
  RecyclerView.ViewHolder mSelected = null;
  int mSelectedFlags;
  float mSelectedStartX;
  float mSelectedStartY;
  private int mSlop;
  private List<RecyclerView.ViewHolder> mSwapTargets;
  float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  private Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  
  public ItemTouchHelper(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (mChildDrawingOrderCallback == null) {
      mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback()
      {
        public int onGetChildDrawingOrder(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (mOverdrawChild == null) {}
          int i;
          do
          {
            return paramAnonymousInt2;
            int j = mOverdrawChildPosition;
            i = j;
            if (j == -1)
            {
              i = mRecyclerView.indexOfChild(mOverdrawChild);
              mOverdrawChildPosition = i;
            }
            if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
              return i;
            }
          } while (paramAnonymousInt2 < i);
          return paramAnonymousInt2 + 1;
        }
      };
    }
    mRecyclerView.setChildDrawingOrderCallback(mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      int i;
      if (mDx > 0.0F)
      {
        i = 8;
        if ((mVelocityTracker == null) || (mActivePointerId <= -1)) {
          break label155;
        }
        mVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f2 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
        f1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
        if (f2 <= 0.0F) {
          break label149;
        }
      }
      label149:
      for (int j = 8;; j = 4)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (i != j) || (f2 < mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) || (f2 <= Math.abs(f1))) {
          break label155;
        }
        return j;
        i = 4;
        break;
      }
      label155:
      float f1 = mRecyclerView.getWidth();
      float f2 = mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(mDx) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      int i;
      if (mDy > 0.0F)
      {
        i = 2;
        if ((mVelocityTracker == null) || (mActivePointerId <= -1)) {
          break label152;
        }
        mVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f1 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, mActivePointerId);
        f2 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, mActivePointerId);
        if (f2 <= 0.0F) {
          break label146;
        }
      }
      label146:
      for (int j = 2;; j = 1)
      {
        f2 = Math.abs(f2);
        if (((j & paramInt) == 0) || (j != i) || (f2 < mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) || (f2 <= Math.abs(f1))) {
          break label152;
        }
        return j;
        i = 1;
        break;
      }
      label152:
      float f1 = mRecyclerView.getHeight();
      float f2 = mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(mDy) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void destroyCallbacks()
  {
    mRecyclerView.removeItemDecoration(this);
    mRecyclerView.removeOnItemTouchListener(mOnItemTouchListener);
    mRecyclerView.removeOnChildAttachStateChangeListener(this);
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(0);
      mCallback.clearView(mRecyclerView, mViewHolder);
      i -= 1;
    }
    mRecoverAnimations.clear();
    mOverdrawChild = null;
    mOverdrawChildPosition = -1;
    releaseVelocityTracker();
  }
  
  private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder paramViewHolder)
  {
    int i;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    label137:
    View localView;
    if (mSwapTargets == null)
    {
      mSwapTargets = new ArrayList();
      mDistances = new ArrayList();
      i = mCallback.getBoundingBoxMargin();
      m = Math.round(mSelectedStartX + mDx) - i;
      n = Math.round(mSelectedStartY + mDy) - i;
      i1 = itemView.getWidth() + m + i * 2;
      i2 = itemView.getHeight() + n + i * 2;
      i3 = (m + i1) / 2;
      i4 = (n + i2) / 2;
      RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
      int i5 = localLayoutManager.getChildCount();
      i = 0;
      if (i >= i5) {
        break label399;
      }
      localView = localLayoutManager.getChildAt(i);
      if (localView != itemView) {
        break label188;
      }
    }
    for (;;)
    {
      i += 1;
      break label137;
      mSwapTargets.clear();
      mDistances.clear();
      break;
      label188:
      if ((localView.getBottom() >= n) && (localView.getTop() <= i2) && (localView.getRight() >= m) && (localView.getLeft() <= i1))
      {
        RecyclerView.ViewHolder localViewHolder = mRecyclerView.getChildViewHolder(localView);
        if (mCallback.canDropOver(mRecyclerView, mSelected, localViewHolder))
        {
          int j = Math.abs(i3 - (localView.getLeft() + localView.getRight()) / 2);
          int k = Math.abs(i4 - (localView.getTop() + localView.getBottom()) / 2);
          int i6 = j * j + k * k;
          k = 0;
          int i7 = mSwapTargets.size();
          j = 0;
          while ((j < i7) && (i6 > ((Integer)mDistances.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          mSwapTargets.add(k, localViewHolder);
          mDistances.add(k, Integer.valueOf(i6));
        }
      }
    }
    label399:
    return mSwapTargets;
  }
  
  private RecyclerView.ViewHolder findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
    if (mActivePointerId == -1) {}
    do
    {
      float f3;
      float f1;
      do
      {
        return null;
        int i = paramMotionEvent.findPointerIndex(mActivePointerId);
        f3 = paramMotionEvent.getX(i);
        float f4 = mInitialTouchX;
        f1 = paramMotionEvent.getY(i);
        float f2 = mInitialTouchY;
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
      } while (((f3 < mSlop) && (f1 < mSlop)) || ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) || ((f1 > f3) && (localLayoutManager.canScrollVertically())));
      paramMotionEvent = findChildView(paramMotionEvent);
    } while (paramMotionEvent == null);
    return mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (mSelectedStartX + mDx - mSelected.itemView.getLeft());
    }
    while ((mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (mSelectedStartY + mDy - mSelected.itemView.getTop());
      return;
      paramArrayOfFloat[0] = ViewCompat.getTranslationX(mSelected.itemView);
    }
    paramArrayOfFloat[1] = ViewCompat.getTranslationY(mSelected.itemView);
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramView.getWidth() + paramFloat3) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramView.getHeight() + paramFloat4);
  }
  
  private void initGestureDetector()
  {
    if (mGestureDetector != null) {
      return;
    }
    mGestureDetector = new GestureDetectorCompat(mRecyclerView.getContext(), new ItemTouchHelperGestureListener());
  }
  
  private void releaseVelocityTracker()
  {
    if (mVelocityTracker != null)
    {
      mVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private void setupCallbacks()
  {
    mSlop = ViewConfiguration.get(mRecyclerView.getContext()).getScaledTouchSlop();
    mRecyclerView.addItemDecoration(this);
    mRecyclerView.addOnItemTouchListener(mOnItemTouchListener);
    mRecyclerView.addOnChildAttachStateChangeListener(this);
    initGestureDetector();
  }
  
  private int swipeIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    int i;
    if (mActionState == 2) {
      i = 0;
    }
    int m;
    int j;
    label131:
    do
    {
      int k;
      do
      {
        do
        {
          return i;
          i = mCallback.getMovementFlags(mRecyclerView, paramViewHolder);
          k = (mCallback.convertToAbsoluteDirection(i, ViewCompat.getLayoutDirection(mRecyclerView)) & 0xFF00) >> 8;
          if (k == 0) {
            return 0;
          }
          m = (i & 0xFF00) >> 8;
          if (Math.abs(mDx) <= Math.abs(mDy)) {
            break label131;
          }
          j = checkHorizontalSwipe(paramViewHolder, k);
          if (j <= 0) {
            break;
          }
          i = j;
        } while ((m & j) != 0);
        return Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection(mRecyclerView));
        j = checkVerticalSwipe(paramViewHolder, k);
        i = j;
      } while (j > 0);
      do
      {
        return 0;
        j = checkVerticalSwipe(paramViewHolder, k);
        i = j;
        if (j > 0) {
          break;
        }
        j = checkHorizontalSwipe(paramViewHolder, k);
      } while (j <= 0);
      i = j;
    } while ((m & j) != 0);
    return Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection(mRecyclerView));
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    if (mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (mRecyclerView != null) {
        destroyCallbacks();
      }
      mRecyclerView = paramRecyclerView;
    } while (mRecyclerView == null);
    paramRecyclerView = paramRecyclerView.getResources();
    mSwipeEscapeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
    mMaxSwipeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
    setupCallbacks();
  }
  
  boolean checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((mSelected != null) || (paramInt1 != 2) || (mActionState == 2) || (!mCallback.isItemViewSwipeEnabled())) {
      return false;
    }
    if (mRecyclerView.getScrollState() == 1) {
      return false;
    }
    RecyclerView.ViewHolder localViewHolder = findSwipedView(paramMotionEvent);
    if (localViewHolder == null) {
      return false;
    }
    paramInt1 = (0xFF00 & mCallback.getAbsoluteMovementFlags(mRecyclerView, localViewHolder)) >> 8;
    if (paramInt1 == 0) {
      return false;
    }
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    f1 -= mInitialTouchX;
    f2 -= mInitialTouchY;
    float f3 = Math.abs(f1);
    float f4 = Math.abs(f2);
    if ((f3 < mSlop) && (f4 < mSlop)) {
      return false;
    }
    if (f3 > f4)
    {
      if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
        return false;
      }
      if ((f1 > 0.0F) && ((paramInt1 & 0x8) == 0)) {
        return false;
      }
    }
    else
    {
      if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
        return false;
      }
      if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
        return false;
      }
    }
    mDy = 0.0F;
    mDx = 0.0F;
    mActivePointerId = paramMotionEvent.getPointerId(0);
    select(localViewHolder, 1);
    return true;
  }
  
  int endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      if (mViewHolder == paramViewHolder)
      {
        mOverridden |= paramBoolean;
        if (!mEnded) {
          localRecoverAnimation.cancel();
        }
        mRecoverAnimations.remove(i);
        return mAnimationType;
      }
      i -= 1;
    }
    return 0;
  }
  
  RecoverAnimation findAnimation(MotionEvent paramMotionEvent)
  {
    if (mRecoverAnimations.isEmpty())
    {
      paramMotionEvent = null;
      return paramMotionEvent;
    }
    View localView = findChildView(paramMotionEvent);
    int i = mRecoverAnimations.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label74;
      }
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      paramMotionEvent = localRecoverAnimation;
      if (mViewHolder.itemView == localView) {
        break;
      }
      i -= 1;
    }
    label74:
    return null;
  }
  
  View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (mSelected != null)
    {
      paramMotionEvent = mSelected.itemView;
      if (hitTest(paramMotionEvent, f1, f2, mSelectedStartX + mDx, mSelectedStartY + mDy)) {
        return paramMotionEvent;
      }
    }
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (RecoverAnimation)mRecoverAnimations.get(i);
      View localView = mViewHolder.itemView;
      if (hitTest(localView, f1, f2, mX, mY)) {
        return localView;
      }
      i -= 1;
    }
    return mRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  boolean hasRunningRecoverAnim()
  {
    int j = mRecoverAnimations.size();
    int i = 0;
    while (i < j)
    {
      if (!mRecoverAnimations.get(i)).mEnded) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void moveIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (mRecyclerView.isLayoutRequested()) {}
    label10:
    int i;
    int j;
    Object localObject;
    int k;
    int m;
    do
    {
      do
      {
        float f;
        do
        {
          break label10;
          do
          {
            return;
          } while (mActionState != 2);
          f = mCallback.getMoveThreshold(paramViewHolder);
          i = (int)(mSelectedStartX + mDx);
          j = (int)(mSelectedStartY + mDy);
        } while ((Math.abs(j - itemView.getTop()) < itemView.getHeight() * f) && (Math.abs(i - itemView.getLeft()) < itemView.getWidth() * f));
        localObject = findSwapTargets(paramViewHolder);
      } while (((List)localObject).size() == 0);
      localObject = mCallback.chooseDropTarget(paramViewHolder, (List)localObject, i, j);
      if (localObject == null)
      {
        mSwapTargets.clear();
        mDistances.clear();
        return;
      }
      k = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
      m = paramViewHolder.getAdapterPosition();
    } while (!mCallback.onMove(mRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject));
    mCallback.onMoved(mRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
  }
  
  void obtainVelocityTracker()
  {
    if (mVelocityTracker != null) {
      mVelocityTracker.recycle();
    }
    mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewAttachedToWindow(View paramView) {}
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {}
    do
    {
      return;
      if ((mSelected != null) && (paramView == mSelected))
      {
        select(null, 0);
        return;
      }
      endRecoverAnimation(paramView, false);
    } while (!mPendingCleanup.remove(itemView));
    mCallback.clearView(mRecyclerView, paramView);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    mOverdrawChildPosition = -1;
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      f1 = mTmpPosition[0];
      f2 = mTmpPosition[1];
    }
    mCallback.onDraw(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f1, f2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      f1 = mTmpPosition[0];
      f2 = mTmpPosition[1];
    }
    mCallback.onDrawOver(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f1, f2);
  }
  
  void postDispatchSwipe(final RecoverAnimation paramRecoverAnimation, final int paramInt)
  {
    mRecyclerView.post(new Runnable()
    {
      public void run()
      {
        if ((mRecyclerView != null) && (mRecyclerView.isAttachedToWindow()) && (!paramRecoverAnimationmOverridden) && (paramRecoverAnimationmViewHolder.getAdapterPosition() != -1))
        {
          RecyclerView.ItemAnimator localItemAnimator = mRecyclerView.getItemAnimator();
          if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!hasRunningRecoverAnim())) {
            mCallback.onSwiped(paramRecoverAnimationmViewHolder, paramInt);
          }
        }
        else
        {
          return;
        }
        mRecyclerView.post(this);
      }
    });
  }
  
  void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == mOverdrawChild)
    {
      mOverdrawChild = null;
      if (mChildDrawingOrderCallback != null) {
        mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  boolean scrollIfNecessary()
  {
    if (mSelected == null)
    {
      mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    int j;
    int k;
    int i;
    int m;
    if (mDragScrollStartTimeInMs == Long.MIN_VALUE)
    {
      l1 = 0L;
      RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
      if (mTmpRect == null) {
        mTmpRect = new Rect();
      }
      j = 0;
      k = 0;
      localLayoutManager.calculateItemDecorationsForChild(mSelected.itemView, mTmpRect);
      i = j;
      if (localLayoutManager.canScrollHorizontally())
      {
        m = (int)(mSelectedStartX + mDx);
        i = m - mTmpRect.left - mRecyclerView.getPaddingLeft();
        if ((mDx >= 0.0F) || (i >= 0)) {
          break label314;
        }
      }
      label136:
      j = k;
      if (localLayoutManager.canScrollVertically())
      {
        m = (int)(mSelectedStartY + mDy);
        j = m - mTmpRect.top - mRecyclerView.getPaddingTop();
        if ((mDy >= 0.0F) || (j >= 0)) {
          break label377;
        }
      }
    }
    for (;;)
    {
      k = i;
      if (i != 0) {
        k = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getWidth(), i, mRecyclerView.getWidth(), l1);
      }
      i = j;
      if (j != 0) {
        i = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getHeight(), j, mRecyclerView.getHeight(), l1);
      }
      if ((k == 0) && (i == 0)) {
        break label440;
      }
      if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
        mDragScrollStartTimeInMs = l2;
      }
      mRecyclerView.scrollBy(k, i);
      return true;
      l1 = l2 - mDragScrollStartTimeInMs;
      break;
      label314:
      i = j;
      if (mDx <= 0.0F) {
        break label136;
      }
      m = mSelected.itemView.getWidth() + m + mTmpRect.right - (mRecyclerView.getWidth() - mRecyclerView.getPaddingRight());
      i = j;
      if (m <= 0) {
        break label136;
      }
      i = m;
      break label136;
      label377:
      j = k;
      if (mDy > 0.0F)
      {
        m = mSelected.itemView.getHeight() + m + mTmpRect.bottom - (mRecyclerView.getHeight() - mRecyclerView.getPaddingBottom());
        j = k;
        if (m > 0) {
          j = m;
        }
      }
    }
    label440:
    mDragScrollStartTimeInMs = Long.MIN_VALUE;
    return false;
  }
  
  void select(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == mSelected) && (paramInt == mActionState)) {
      return;
    }
    mDragScrollStartTimeInMs = Long.MIN_VALUE;
    int k = mActionState;
    endRecoverAnimation(paramViewHolder, true);
    mActionState = paramInt;
    if (paramInt == 2)
    {
      mOverdrawChild = itemView;
      addChildDrawingOrderCallback();
    }
    int i = 0;
    final int j = 0;
    Object localObject;
    float f1;
    float f2;
    if (mSelected != null)
    {
      localObject = mSelected;
      if (itemView.getParent() == null) {
        break label510;
      }
      if (k == 2)
      {
        j = 0;
        releaseVelocityTracker();
      }
    }
    else
    {
      switch (j)
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        label169:
        if (k == 2)
        {
          i = 8;
          label179:
          getSelectedDxDy(mTmpPosition);
          float f3 = mTmpPosition[0];
          float f4 = mTmpPosition[1];
          localObject = new RecoverAnimation((RecyclerView.ViewHolder)localObject, i, k, f3, f4, f1, f2, j)
          {
            public void onAnimationEnd(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
            {
              super.onAnimationEnd(paramAnonymousValueAnimatorCompat);
              if (mOverridden) {}
              for (;;)
              {
                return;
                if (j <= 0) {
                  mCallback.clearView(mRecyclerView, val$prevSelected);
                }
                while (mOverdrawChild == val$prevSelected.itemView)
                {
                  removeChildDrawingOrderCallbackIfNecessary(val$prevSelected.itemView);
                  return;
                  mPendingCleanup.add(val$prevSelected.itemView);
                  mIsPendingCleanup = true;
                  if (j > 0) {
                    postDispatchSwipe(this, j);
                  }
                }
              }
            }
          };
          ((RecoverAnimation)localObject).setDuration(mCallback.getAnimationDuration(mRecyclerView, i, f1 - f3, f2 - f4));
          mRecoverAnimations.add(localObject);
          ((RecoverAnimation)localObject).start();
          i = 1;
          label277:
          mSelected = null;
          if (paramViewHolder != null)
          {
            mSelectedFlags = ((mCallback.getAbsoluteMovementFlags(mRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> mActionState * 8);
            mSelectedStartX = itemView.getLeft();
            mSelectedStartY = itemView.getTop();
            mSelected = paramViewHolder;
            if (paramInt == 2) {
              mSelected.itemView.performHapticFeedback(0);
            }
          }
          paramViewHolder = mRecyclerView.getParent();
          if (paramViewHolder != null) {
            if (mSelected == null) {
              break label539;
            }
          }
        }
        break;
      }
    }
    label510:
    label539:
    for (boolean bool = true;; bool = false)
    {
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
      if (i == 0) {
        mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
      }
      mCallback.onSelectedChanged(mSelected, mActionState);
      mRecyclerView.invalidate();
      return;
      j = swipeIfNecessary((RecyclerView.ViewHolder)localObject);
      break;
      f2 = 0.0F;
      f1 = Math.signum(mDx) * mRecyclerView.getWidth();
      break label169;
      f1 = 0.0F;
      f2 = Math.signum(mDy) * mRecyclerView.getHeight();
      break label169;
      if (j > 0)
      {
        i = 2;
        break label179;
      }
      i = 4;
      break label179;
      removeChildDrawingOrderCallbackIfNecessary(itemView);
      mCallback.clearView(mRecyclerView, (RecyclerView.ViewHolder)localObject);
      i = j;
      break label277;
    }
  }
  
  public void startDrag(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!mCallback.hasDragFlag(mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
      return;
    }
    if (itemView.getParent() != mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    mDy = 0.0F;
    mDx = 0.0F;
    select(paramViewHolder, 2);
  }
  
  public void startSwipe(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!mCallback.hasSwipeFlag(mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
      return;
    }
    if (itemView.getParent() != mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    mDy = 0.0F;
    mDx = 0.0F;
    select(paramViewHolder, 1);
  }
  
  void updateDxDy(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    mDx = (f1 - mInitialTouchX);
    mDy = (f2 - mInitialTouchY);
    if ((paramInt1 & 0x4) == 0) {
      mDx = Math.max(0.0F, mDx);
    }
    if ((paramInt1 & 0x8) == 0) {
      mDx = Math.min(0.0F, mDx);
    }
    if ((paramInt1 & 0x1) == 0) {
      mDy = Math.max(0.0F, mDy);
    }
    if ((paramInt1 & 0x2) == 0) {
      mDy = Math.min(0.0F, mDy);
    }
  }
  
  public static abstract class Callback
  {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
    static final int RELATIVE_DIR_FLAGS = 3158064;
    private static final Interpolator sDragScrollInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
      }
    };
    private static final ItemTouchUIUtil sUICallback = new ItemTouchUIUtilImpl.Gingerbread();
    private int mCachedMaxScrollSpeed = -1;
    
    static
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        sUICallback = new ItemTouchUIUtilImpl.Lollipop();
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        sUICallback = new ItemTouchUIUtilImpl.Honeycomb();
        return;
      }
    }
    
    public Callback() {}
    
    public static int convertToRelativeDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0xC0C0C;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= (i ^ 0xFFFFFFFF);
      if (paramInt2 == 0) {
        return paramInt1 | i << 2;
      }
      return paramInt1 | i << 1 & 0xFFF3F3F3 | (i << 1 & 0xC0C0C) << 2;
    }
    
    public static ItemTouchUIUtil getDefaultUIUtil()
    {
      return sUICallback;
    }
    
    private int getMaxDragScroll(RecyclerView paramRecyclerView)
    {
      if (mCachedMaxScrollSpeed == -1) {
        mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
      }
      return mCachedMaxScrollSpeed;
    }
    
    public static int makeFlag(int paramInt1, int paramInt2)
    {
      return paramInt2 << paramInt1 * 8;
    }
    
    public static int makeMovementFlags(int paramInt1, int paramInt2)
    {
      return makeFlag(0, paramInt2 | paramInt1) | makeFlag(1, paramInt2) | makeFlag(2, paramInt1);
    }
    
    public boolean canDropOver(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
    {
      return true;
    }
    
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder paramViewHolder, List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
    {
      int n = itemView.getWidth();
      int i1 = itemView.getHeight();
      Object localObject2 = null;
      int j = -1;
      int i2 = paramInt1 - itemView.getLeft();
      int i3 = paramInt2 - itemView.getTop();
      int i4 = paramList.size();
      int k = 0;
      while (k < i4)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramList.get(k);
        Object localObject1 = localObject2;
        int i = j;
        int m;
        if (i2 > 0)
        {
          m = itemView.getRight() - (paramInt1 + n);
          localObject1 = localObject2;
          i = j;
          if (m < 0)
          {
            localObject1 = localObject2;
            i = j;
            if (itemView.getRight() > itemView.getRight())
            {
              m = Math.abs(m);
              localObject1 = localObject2;
              i = j;
              if (m > j)
              {
                i = m;
                localObject1 = localViewHolder;
              }
            }
          }
        }
        localObject2 = localObject1;
        j = i;
        if (i2 < 0)
        {
          m = itemView.getLeft() - paramInt1;
          localObject2 = localObject1;
          j = i;
          if (m > 0)
          {
            localObject2 = localObject1;
            j = i;
            if (itemView.getLeft() < itemView.getLeft())
            {
              m = Math.abs(m);
              localObject2 = localObject1;
              j = i;
              if (m > i)
              {
                j = m;
                localObject2 = localViewHolder;
              }
            }
          }
        }
        localObject1 = localObject2;
        i = j;
        if (i3 < 0)
        {
          m = itemView.getTop() - paramInt2;
          localObject1 = localObject2;
          i = j;
          if (m > 0)
          {
            localObject1 = localObject2;
            i = j;
            if (itemView.getTop() < itemView.getTop())
            {
              m = Math.abs(m);
              localObject1 = localObject2;
              i = j;
              if (m > j)
              {
                i = m;
                localObject1 = localViewHolder;
              }
            }
          }
        }
        localObject2 = localObject1;
        j = i;
        if (i3 > 0)
        {
          m = itemView.getBottom() - (paramInt2 + i1);
          localObject2 = localObject1;
          j = i;
          if (m < 0)
          {
            localObject2 = localObject1;
            j = i;
            if (itemView.getBottom() > itemView.getBottom())
            {
              m = Math.abs(m);
              localObject2 = localObject1;
              j = i;
              if (m > i)
              {
                j = m;
                localObject2 = localViewHolder;
              }
            }
          }
        }
        k += 1;
      }
      return localObject2;
    }
    
    public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      sUICallback.clearView(itemView);
    }
    
    public int convertToAbsoluteDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0x303030;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= (i ^ 0xFFFFFFFF);
      if (paramInt2 == 0) {
        return paramInt1 | i >> 2;
      }
      return paramInt1 | i >> 1 & 0xFFCFCFCF | (i >> 1 & 0x303030) >> 2;
    }
    
    final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
    }
    
    public long getAnimationDuration(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
    {
      paramRecyclerView = paramRecyclerView.getItemAnimator();
      if (paramRecyclerView == null)
      {
        if (paramInt == 8) {
          return 200L;
        }
        return 250L;
      }
      if (paramInt == 8) {
        return paramRecyclerView.getMoveDuration();
      }
      return paramRecyclerView.getRemoveDuration();
    }
    
    public int getBoundingBoxMargin()
    {
      return 0;
    }
    
    public float getMoveThreshold(RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public abstract int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder);
    
    public float getSwipeEscapeVelocity(float paramFloat)
    {
      return paramFloat;
    }
    
    public float getSwipeThreshold(RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public float getSwipeVelocityThreshold(float paramFloat)
    {
      return paramFloat;
    }
    
    boolean hasDragFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return (0xFF0000 & getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder)) != 0;
    }
    
    boolean hasSwipeFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return (0xFF00 & getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder)) != 0;
    }
    
    public int interpolateOutOfBoundsScroll(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      paramInt3 = getMaxDragScroll(paramRecyclerView);
      int i = Math.abs(paramInt2);
      int j = (int)Math.signum(paramInt2);
      float f = Math.min(1.0F, 1.0F * i / paramInt1);
      paramInt1 = (int)(j * paramInt3 * sDragViewScrollCapInterpolator.getInterpolation(f));
      if (paramLong > 2000L) {}
      for (f = 1.0F;; f = (float)paramLong / 2000.0F)
      {
        paramInt1 = (int)(paramInt1 * sDragScrollInterpolator.getInterpolation(f));
        if (paramInt1 != 0) {
          return paramInt1;
        }
        if (paramInt2 <= 0) {
          break;
        }
        return 1;
      }
      return -1;
      return paramInt1;
    }
    
    public boolean isItemViewSwipeEnabled()
    {
      return true;
    }
    
    public boolean isLongPressDragEnabled()
    {
      return true;
    }
    
    public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      sUICallback.onDraw(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    public void onChildDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      sUICallback.onDrawOver(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        localRecoverAnimation.update();
        int k = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, mViewHolder, mX, mY, mActionState, false);
        paramCanvas.restoreToCount(k);
        i += 1;
      }
      if (paramViewHolder != null)
      {
        i = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
    }
    
    void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        int k = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, mViewHolder, mX, mY, mActionState, false);
        paramCanvas.restoreToCount(k);
        i += 1;
      }
      if (paramViewHolder != null)
      {
        i = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
      i = 0;
      paramInt = j - 1;
      if (paramInt >= 0)
      {
        paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
        if ((mEnded) && (!mIsPendingCleanup)) {
          paramList.remove(paramInt);
        }
        for (;;)
        {
          paramInt -= 1;
          break;
          if (!mEnded) {
            i = 1;
          }
        }
      }
      if (i != 0) {
        paramRecyclerView.invalidate();
      }
    }
    
    public abstract boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2);
    
    public void onMoved(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler)) {
        ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop(itemView, itemView, paramInt3, paramInt4);
      }
      do
      {
        do
        {
          return;
          if (localLayoutManager.canScrollHorizontally())
          {
            if (localLayoutManager.getDecoratedLeft(itemView) <= paramRecyclerView.getPaddingLeft()) {
              paramRecyclerView.scrollToPosition(paramInt2);
            }
            if (localLayoutManager.getDecoratedRight(itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
              paramRecyclerView.scrollToPosition(paramInt2);
            }
          }
        } while (!localLayoutManager.canScrollVertically());
        if (localLayoutManager.getDecoratedTop(itemView) <= paramRecyclerView.getPaddingTop()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      } while (localLayoutManager.getDecoratedBottom(itemView) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      paramRecyclerView.scrollToPosition(paramInt2);
    }
    
    public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (paramViewHolder != null) {
        sUICallback.onSelected(itemView);
      }
    }
    
    public abstract void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
  
  private class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    ItemTouchHelperGestureListener() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      Object localObject = findChildView(paramMotionEvent);
      if (localObject != null)
      {
        localObject = mRecyclerView.getChildViewHolder((View)localObject);
        if ((localObject != null) && (mCallback.hasDragFlag(mRecyclerView, (RecyclerView.ViewHolder)localObject))) {
          break label57;
        }
      }
      label57:
      do
      {
        do
        {
          return;
        } while (paramMotionEvent.getPointerId(0) != mActivePointerId);
        int i = paramMotionEvent.findPointerIndex(mActivePointerId);
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        mInitialTouchX = f1;
        mInitialTouchY = f2;
        paramMotionEvent = ItemTouchHelper.this;
        mDy = 0.0F;
        mDx = 0.0F;
      } while (!mCallback.isLongPressDragEnabled());
      select((RecyclerView.ViewHolder)localObject, 2);
    }
  }
  
  private class RecoverAnimation
    implements AnimatorListenerCompat
  {
    final int mActionState;
    final int mAnimationType;
    boolean mEnded = false;
    private float mFraction;
    public boolean mIsPendingCleanup;
    boolean mOverridden = false;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    private final ValueAnimatorCompat mValueAnimator;
    final RecyclerView.ViewHolder mViewHolder;
    float mX;
    float mY;
    
    public RecoverAnimation(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      mActionState = paramInt2;
      mAnimationType = paramInt1;
      mViewHolder = paramViewHolder;
      mStartDx = paramFloat1;
      mStartDy = paramFloat2;
      mTargetX = paramFloat3;
      mTargetY = paramFloat4;
      mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
      mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat()
      {
        public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
        {
          setFraction(paramAnonymousValueAnimatorCompat.getAnimatedFraction());
        }
      });
      mValueAnimator.setTarget(itemView);
      mValueAnimator.addListener(this);
      setFraction(0.0F);
    }
    
    public void cancel()
    {
      mValueAnimator.cancel();
    }
    
    public void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat)
    {
      setFraction(1.0F);
    }
    
    public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
    {
      if (!mEnded) {
        mViewHolder.setIsRecyclable(true);
      }
      mEnded = true;
    }
    
    public void onAnimationRepeat(ValueAnimatorCompat paramValueAnimatorCompat) {}
    
    public void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat) {}
    
    public void setDuration(long paramLong)
    {
      mValueAnimator.setDuration(paramLong);
    }
    
    public void setFraction(float paramFloat)
    {
      mFraction = paramFloat;
    }
    
    public void start()
    {
      mViewHolder.setIsRecyclable(false);
      mValueAnimator.start();
    }
    
    public void update()
    {
      if (mStartDx == mTargetX) {}
      for (mX = ViewCompat.getTranslationX(mViewHolder.itemView); mStartDy == mTargetY; mX = (mStartDx + mFraction * (mTargetX - mStartDx)))
      {
        mY = ViewCompat.getTranslationY(mViewHolder.itemView);
        return;
      }
      mY = (mStartDy + mFraction * (mTargetY - mStartDy));
    }
  }
  
  public static abstract class SimpleCallback
    extends ItemTouchHelper.Callback
  {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs;
    
    public SimpleCallback(int paramInt1, int paramInt2)
    {
      mDefaultSwipeDirs = paramInt2;
      mDefaultDragDirs = paramInt1;
    }
    
    public int getDragDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return mDefaultDragDirs;
    }
    
    public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return makeMovementFlags(getDragDirs(paramRecyclerView, paramViewHolder), getSwipeDirs(paramRecyclerView, paramViewHolder));
    }
    
    public int getSwipeDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return mDefaultSwipeDirs;
    }
    
    public void setDefaultDragDirs(int paramInt)
    {
      mDefaultDragDirs = paramInt;
    }
    
    public void setDefaultSwipeDirs(int paramInt)
    {
      mDefaultSwipeDirs = paramInt;
    }
  }
  
  public static abstract interface ViewDropHandler
  {
    public abstract void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2);
  }
}

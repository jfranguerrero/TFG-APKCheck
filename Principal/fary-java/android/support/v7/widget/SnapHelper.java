package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class SnapHelper
  extends RecyclerView.OnFlingListener
{
  static final float MILLISECONDS_PER_INCH = 100.0F;
  private Scroller mGravityScroller;
  RecyclerView mRecyclerView;
  private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener()
  {
    boolean mScrolled = false;
    
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (mScrolled))
      {
        mScrolled = false;
        snapToTargetExistingView();
      }
    }
    
    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        mScrolled = true;
      }
    }
  };
  
  public SnapHelper() {}
  
  private void destroyCallbacks()
  {
    mRecyclerView.removeOnScrollListener(mScrollListener);
    mRecyclerView.setOnFlingListener(null);
  }
  
  private void setupCallbacks()
    throws IllegalStateException
  {
    if (mRecyclerView.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    mRecyclerView.addOnScrollListener(mScrollListener);
    mRecyclerView.setOnFlingListener(this);
  }
  
  private boolean snapFromFling(@NonNull RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {}
    LinearSmoothScroller localLinearSmoothScroller;
    do
    {
      do
      {
        return false;
        localLinearSmoothScroller = createSnapScroller(paramLayoutManager);
      } while (localLinearSmoothScroller == null);
      paramInt1 = findTargetSnapPosition(paramLayoutManager, paramInt1, paramInt2);
    } while (paramInt1 == -1);
    localLinearSmoothScroller.setTargetPosition(paramInt1);
    paramLayoutManager.startSmoothScroll(localLinearSmoothScroller);
    return true;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
    throws IllegalStateException
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
    setupCallbacks();
    mGravityScroller = new Scroller(mRecyclerView.getContext(), new DecelerateInterpolator());
    snapToTargetExistingView();
  }
  
  @Nullable
  public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView);
  
  public int[] calculateScrollDistance(int paramInt1, int paramInt2)
  {
    mGravityScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return new int[] { mGravityScroller.getFinalX(), mGravityScroller.getFinalY() };
  }
  
  @Nullable
  protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return null;
    }
    new LinearSmoothScroller(mRecyclerView.getContext())
    {
      protected float calculateSpeedPerPixel(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / densityDpi;
      }
      
      protected void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        paramAnonymousView = calculateDistanceToFinalSnap(mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousAction.update(i, j, k, mDecelerateInterpolator);
        }
      }
    };
  }
  
  @Nullable
  public abstract View findSnapView(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public boolean onFling(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
    if (localLayoutManager == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (mRecyclerView.getAdapter() == null);
      i = mRecyclerView.getMinFlingVelocity();
    } while (((Math.abs(paramInt2) <= i) && (Math.abs(paramInt1) <= i)) || (!snapFromFling(localLayoutManager, paramInt1, paramInt2)));
    return true;
  }
  
  void snapToTargetExistingView()
  {
    if (mRecyclerView == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = mRecyclerView.getLayoutManager();
        } while (localObject == null);
        localView = findSnapView((RecyclerView.LayoutManager)localObject);
      } while (localView == null);
      localObject = calculateDistanceToFinalSnap((RecyclerView.LayoutManager)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    mRecyclerView.smoothScrollBy(localObject[0], localObject[1]);
  }
}

package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator()
  {
    public BackStackState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }
    
    public BackStackState[] newArray(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final boolean mAllowOptimization;
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final ArrayList<String> mSharedElementSourceNames;
  final ArrayList<String> mSharedElementTargetNames;
  final int mTransition;
  final int mTransitionStyle;
  
  public BackStackState(Parcel paramParcel)
  {
    mOps = paramParcel.createIntArray();
    mTransition = paramParcel.readInt();
    mTransitionStyle = paramParcel.readInt();
    mName = paramParcel.readString();
    mIndex = paramParcel.readInt();
    mBreadCrumbTitleRes = paramParcel.readInt();
    mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mBreadCrumbShortTitleRes = paramParcel.readInt();
    mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mSharedElementSourceNames = paramParcel.createStringArrayList();
    mSharedElementTargetNames = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      mAllowOptimization = bool;
      return;
    }
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord)
  {
    int k = mOps.size();
    mOps = new int[k * 6];
    if (!mAddToBackStack) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      BackStackRecord.Op localOp = (BackStackRecord.Op)mOps.get(i);
      int[] arrayOfInt = mOps;
      int m = j + 1;
      arrayOfInt[j] = cmd;
      arrayOfInt = mOps;
      int n = m + 1;
      if (fragment != null) {}
      for (j = fragment.mIndex;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = mOps;
        j = n + 1;
        arrayOfInt[n] = enterAnim;
        arrayOfInt = mOps;
        m = j + 1;
        arrayOfInt[j] = exitAnim;
        arrayOfInt = mOps;
        n = m + 1;
        arrayOfInt[m] = popEnterAnim;
        arrayOfInt = mOps;
        j = n + 1;
        arrayOfInt[n] = popExitAnim;
        i += 1;
        break;
      }
    }
    mTransition = mTransition;
    mTransitionStyle = mTransitionStyle;
    mName = mName;
    mIndex = mIndex;
    mBreadCrumbTitleRes = mBreadCrumbTitleRes;
    mBreadCrumbTitleText = mBreadCrumbTitleText;
    mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
    mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
    mSharedElementSourceNames = mSharedElementSourceNames;
    mSharedElementTargetNames = mSharedElementTargetNames;
    mAllowOptimization = mAllowOptimization;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int j = 0;
    int i = 0;
    if (j < mOps.length)
    {
      BackStackRecord.Op localOp = new BackStackRecord.Op();
      int[] arrayOfInt = mOps;
      int k = j + 1;
      cmd = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " op #" + i + " base fragment #" + mOps[k]);
      }
      arrayOfInt = mOps;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (fragment = ((Fragment)mActive.get(k));; fragment = null)
      {
        arrayOfInt = mOps;
        k = j + 1;
        enterAnim = arrayOfInt[j];
        arrayOfInt = mOps;
        j = k + 1;
        exitAnim = arrayOfInt[k];
        arrayOfInt = mOps;
        k = j + 1;
        popEnterAnim = arrayOfInt[j];
        arrayOfInt = mOps;
        j = k + 1;
        popExitAnim = arrayOfInt[k];
        mEnterAnim = enterAnim;
        mExitAnim = exitAnim;
        mPopEnterAnim = popEnterAnim;
        mPopExitAnim = popExitAnim;
        localBackStackRecord.addOp(localOp);
        i += 1;
        break;
      }
    }
    mTransition = mTransition;
    mTransitionStyle = mTransitionStyle;
    mName = mName;
    mIndex = mIndex;
    mAddToBackStack = true;
    mBreadCrumbTitleRes = mBreadCrumbTitleRes;
    mBreadCrumbTitleText = mBreadCrumbTitleText;
    mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
    mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
    mSharedElementSourceNames = mSharedElementSourceNames;
    mSharedElementTargetNames = mSharedElementTargetNames;
    mAllowOptimization = mAllowOptimization;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(mOps);
    paramParcel.writeInt(mTransition);
    paramParcel.writeInt(mTransitionStyle);
    paramParcel.writeString(mName);
    paramParcel.writeInt(mIndex);
    paramParcel.writeInt(mBreadCrumbTitleRes);
    TextUtils.writeToParcel(mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(mBreadCrumbShortTitleText, paramParcel, 0);
    paramParcel.writeStringList(mSharedElementSourceNames);
    paramParcel.writeStringList(mSharedElementTargetNames);
    if (mAllowOptimization) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}

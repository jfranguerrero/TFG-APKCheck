package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator()
  {
    public FragmentState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FragmentState(paramAnonymousParcel);
    }
    
    public FragmentState[] newArray(int paramAnonymousInt)
    {
      return new FragmentState[paramAnonymousInt];
    }
  };
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final boolean mHidden;
  final int mIndex;
  Fragment mInstance;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  
  public FragmentState(Parcel paramParcel)
  {
    mClassName = paramParcel.readString();
    mIndex = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      mFromLayout = bool1;
      mFragmentId = paramParcel.readInt();
      mContainerId = paramParcel.readInt();
      mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label124;
      }
      bool1 = true;
      label69:
      mRetainInstance = bool1;
      if (paramParcel.readInt() == 0) {
        break label129;
      }
      bool1 = true;
      label83:
      mDetached = bool1;
      mArguments = paramParcel.readBundle();
      if (paramParcel.readInt() == 0) {
        break label134;
      }
    }
    label124:
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      mHidden = bool1;
      mSavedFragmentState = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
      bool1 = false;
      break label83;
    }
  }
  
  public FragmentState(Fragment paramFragment)
  {
    mClassName = paramFragment.getClass().getName();
    mIndex = mIndex;
    mFromLayout = mFromLayout;
    mFragmentId = mFragmentId;
    mContainerId = mContainerId;
    mTag = mTag;
    mRetainInstance = mRetainInstance;
    mDetached = mDetached;
    mArguments = mArguments;
    mHidden = mHidden;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Fragment instantiate(FragmentHostCallback paramFragmentHostCallback, Fragment paramFragment, FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if (mInstance == null)
    {
      Context localContext = paramFragmentHostCallback.getContext();
      if (mArguments != null) {
        mArguments.setClassLoader(localContext.getClassLoader());
      }
      mInstance = Fragment.instantiate(localContext, mClassName, mArguments);
      if (mSavedFragmentState != null)
      {
        mSavedFragmentState.setClassLoader(localContext.getClassLoader());
        mInstance.mSavedFragmentState = mSavedFragmentState;
      }
      mInstance.setIndex(mIndex, paramFragment);
      mInstance.mFromLayout = mFromLayout;
      mInstance.mRestored = true;
      mInstance.mFragmentId = mFragmentId;
      mInstance.mContainerId = mContainerId;
      mInstance.mTag = mTag;
      mInstance.mRetainInstance = mRetainInstance;
      mInstance.mDetached = mDetached;
      mInstance.mHidden = mHidden;
      mInstance.mFragmentManager = mFragmentManager;
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Instantiated fragment " + mInstance);
      }
    }
    mInstance.mChildNonConfig = paramFragmentManagerNonConfig;
    return mInstance;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(mClassName);
    paramParcel.writeInt(mIndex);
    if (mFromLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(mFragmentId);
      paramParcel.writeInt(mContainerId);
      paramParcel.writeString(mTag);
      if (!mRetainInstance) {
        break label120;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!mDetached) {
        break label125;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(mArguments);
      if (!mHidden) {
        break label130;
      }
    }
    label120:
    label125:
    label130:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(mSavedFragmentState);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
      paramInt = 0;
      break label79;
    }
  }
}

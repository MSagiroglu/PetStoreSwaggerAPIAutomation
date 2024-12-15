
package pojos.storePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class InventoryPojo {
    /*
    {
  "5000": 1,
  "6000": 1,
  "sold": 18,
  "aviable": 1,
  "string": 265,
  "pending": 63,
  "available": 584,
  "on sale": 1,
  "Not Available": 1,
  "True": 2,
  "Unavailable": 1,
  "AVAILABLE": 33,
  "notAValidStatus": 2,
  "Pending": 1
}
     */

    private Integer m5000;
    private Integer m6000;
    private Integer mSold;
    private Integer mAviable;
    private Integer mString;
    private Integer mPending;
    private Integer mAvailable;
    private Integer mOnSale;
    private Integer mNotAvailable;
    private Integer mTrue;
    private Integer mUnavailable;
    private Integer mAVAILABLE;
    private Integer mNotAValidStatus;
    private Integer mPending1;

    public InventoryPojo(Integer m5000, Integer mUnavailable, Integer m6000, Integer mSold, Integer mAviable, Integer mString, Integer mPending, Integer mAvailable, Integer mOnSale, Integer mNotAvailable, Integer mTrue, Integer mAVAILABLE, Integer mNotAValidStatus, Integer mPending1) {
        this.m5000 = m5000;
        this.mUnavailable = mUnavailable;
        this.m6000 = m6000;
        this.mSold = mSold;
        this.mAviable = mAviable;
        this.mString = mString;
        this.mPending = mPending;
        this.mAvailable = mAvailable;
        this.mOnSale = mOnSale;
        this.mNotAvailable = mNotAvailable;
        this.mTrue = mTrue;
        this.mAVAILABLE = mAVAILABLE;
        this.mNotAValidStatus = mNotAValidStatus;
        this.mPending1 = mPending1;
    }

    public InventoryPojo() {
    }

    public Integer getM5000() {
        return m5000;
    }

    public void setM5000(Integer m5000) {
        this.m5000 = m5000;
    }

    public Integer getM6000() {
        return m6000;
    }

    public void setM6000(Integer m6000) {
        this.m6000 = m6000;
    }

    public Integer getmSold() {
        return mSold;
    }

    public void setmSold(Integer mSold) {
        this.mSold = mSold;
    }

    public Integer getmAviable() {
        return mAviable;
    }

    public void setmAviable(Integer mAviable) {
        this.mAviable = mAviable;
    }

    public Integer getmString() {
        return mString;
    }

    public void setmString(Integer mString) {
        this.mString = mString;
    }

    public Integer getmPending() {
        return mPending;
    }

    public void setmPending(Integer mPending) {
        this.mPending = mPending;
    }

    public Integer getmAvailable() {
        return mAvailable;
    }

    public void setmAvailable(Integer mAvailable) {
        this.mAvailable = mAvailable;
    }

    public Integer getmOnSale() {
        return mOnSale;
    }

    public void setmOnSale(Integer mOnSale) {
        this.mOnSale = mOnSale;
    }

    public Integer getmNotAvailable() {
        return mNotAvailable;
    }

    public void setmNotAvailable(Integer mNotAvailable) {
        this.mNotAvailable = mNotAvailable;
    }

    public Integer getmTrue() {
        return mTrue;
    }

    public void setmTrue(Integer mTrue) {
        this.mTrue = mTrue;
    }

    public Integer getmUnavailable() {
        return mUnavailable;
    }

    public void setmUnavailable(Integer mUnavailable) {
        this.mUnavailable = mUnavailable;
    }

    public Integer getmAVAILABLE() {
        return mAVAILABLE;
    }

    public void setmAVAILABLE(Integer mAVAILABLE) {
        this.mAVAILABLE = mAVAILABLE;
    }

    public Integer getmNotAValidStatus() {
        return mNotAValidStatus;
    }

    public void setmNotAValidStatus(Integer mNotAValidStatus) {
        this.mNotAValidStatus = mNotAValidStatus;
    }

    public Integer getmPending1() {
        return mPending1;
    }

    public void setmPending1(Integer mPending1) {
        this.mPending1 = mPending1;
    }

    @Override
    public String toString() {
        return "InventoryPojo{" +
                "m5000=" + m5000 +
                ", m6000=" + m6000 +
                ", mSold=" + mSold +
                ", mAviable=" + mAviable +
                ", mString=" + mString +
                ", mPending=" + mPending +
                ", mAvailable=" + mAvailable +
                ", mOnSale=" + mOnSale +
                ", mNotAvailable=" + mNotAvailable +
                ", mTrue=" + mTrue +
                ", mUnavailable=" + mUnavailable +
                ", mAVAILABLE=" + mAVAILABLE +
                ", mNotAValidStatus=" + mNotAValidStatus +
                ", mPending1=" + mPending1 +
                '}';
    }
}

package pojos.storePojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPostPojo {



    private Boolean mComplete;

    private Long mId;

    private Long mPetId;

    private Integer mQuantity;

    private String mShipDate;

    private String mStatus;

    public OrderPostPojo(Long mId, Long mPetId, Integer mQuantity, String mShipDate, String mStatus, Boolean mComplete) {
        this.mComplete = mComplete;
        this.mId = mId;
        this.mPetId = mPetId;
        this.mQuantity = mQuantity;
        this.mShipDate = mShipDate;
        this.mStatus = mStatus;
    }

    public OrderPostPojo() {
    }

    public Boolean getComplete() {
        return mComplete;
    }

    public void setComplete(Boolean complete) {
        mComplete = complete;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getPetId() {
        return mPetId;
    }

    public void setPetId(Long petId) {
        mPetId = petId;
    }

    public Integer getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Integer quantity) {
        mQuantity = quantity;
    }

    public String getShipDate() {
        return mShipDate;
    }

    public void setShipDate(String shipDate) {
        mShipDate = shipDate;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    @Override
    public String toString() {
        return "StorePostPojo{" +
                "mComplete=" + mComplete +
                ", mId=" + mId +
                ", mPetId=" + mPetId +
                ", mQuantity=" + mQuantity +
                ", mShipDate='" + mShipDate + '\'' +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }
}

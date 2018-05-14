package com.udacity.exploreindia.data.models.DAO;

import com.google.gson.annotations.SerializedName;

public class Place {
    @SerializedName("place_status")
    private String placeStatus;
    @SerializedName("place_add_date")
    private String placeAddDate;
    @SerializedName("place_add_by")
    private String placeAddBy;
    @SerializedName("place_type")
    private String placeType;
    @SerializedName("place_google_place_id")
    private String placeGooglePlaceId;
    @SerializedName("city_id")
    private String cityId;
    @SerializedName("place_description")
    private String placeDescription;
    @SerializedName("place_local_name")
    private String placeLocalName;
    @SerializedName("place_name")
    private String placeName;
    @SerializedName("place_id")
    private String placeId;

    public String getPlaceStatus() {
        return placeStatus;
    }

    public void setPlaceStatus(String placeStatus) {
        this.placeStatus = placeStatus;
    }

    public String getPlaceAddDate() {
        return placeAddDate;
    }

    public void setPlaceAddDate(String placeAddDate) {
        this.placeAddDate = placeAddDate;
    }

    public String getPlaceAddBy() {
        return placeAddBy;
    }

    public void setPlaceAddBy(String placeAddBy) {
        this.placeAddBy = placeAddBy;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceGooglePlaceId() {
        return placeGooglePlaceId;
    }

    public void setPlaceGooglePlaceId(String placeGooglePlaceId) {
        this.placeGooglePlaceId = placeGooglePlaceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getPlaceLocalName() {
        return placeLocalName;
    }

    public void setPlaceLocalName(String placeLocalName) {
        this.placeLocalName = placeLocalName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}

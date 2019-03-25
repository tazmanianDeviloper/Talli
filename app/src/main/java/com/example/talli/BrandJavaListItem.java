package com.example.talli;

/*
The class will initialize the necessary fields for the Brands button which will start the Brand
RecyclerView.
 */

public class BrandJavaListItem {

    private String BrandName;
    private String BrandImage;

    public BrandJavaListItem() {
    }

/*
The String field BrandImage will be initialized in Main with images from FireStore. The Images
are not ImageView because in FireStore the only allowed format is String.
 */

    public BrandJavaListItem(String BrandName, String BrandImage) {

        //condition for users without a name.
        if (BrandName.trim().equals("")) BrandName = "No Brand Name!!!";

        this.BrandName = BrandName;
        this.BrandImage = BrandImage;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView.
*/

    String getBrandName() {
        return BrandName;
    }

    String getBrandImage() {
        return BrandImage;
    }
}


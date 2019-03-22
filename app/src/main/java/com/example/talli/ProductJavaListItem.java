package com.example.talli;

/*
The class will initialize the necessary fields for the Product button which will start the Products
activity.
 */

public class ProductJavaListItem {

    private String productBrandName;
    private String productBrandImage;

    public ProductJavaListItem() {
    }

/*
The String field productBrandImage will be initialized in Main with images from FireStore. The Images
are not ImageView because in FireStore the only allowed format is String.
 */

    public ProductJavaListItem(String productBrandName, String productBrandImage) {

        //condition for users without a name.
        if (productBrandName.trim().equals("")) productBrandName = "No Brand Name!!!";

        this.productBrandName = productBrandName;
        this.productBrandImage = productBrandImage;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView.
*/

    public String getProductBrandName() {

        return productBrandName;
    }

    public String getProductBrandImage() {
        return productBrandImage;
    }
}

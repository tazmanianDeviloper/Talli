package com.example.talli;

/*
The class will initialize the necessary fields for the Product button which will start the Products
activity.
 */

public class ProductJavaListItem {

    private String productName;
    private String productImage;

    public ProductJavaListItem() {
    }

/*
The String field productImage will be initialized in Main with images from FireStore. The Images
are not ImageView because in FireStore the only allowed format is String.
 */

    public ProductJavaListItem(String productName, String productImage) {

        //condition for users without a name.
        if (productName.trim().equals("")) productName = "No Product Name!!!";

        this.productName = productName;
        this.productImage = productImage;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView.
*/

    public String getProductName() {

        return productName;
    }

    public String getProductImage() {
        return productImage;
    }
}

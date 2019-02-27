package com.example.talli;

import android.graphics.Bitmap;
import android.widget.ImageView;


/*
The class will initialize the necessary fields for people button which will start the people
activity.
 */

public class PeopleJavaListitem {

    private String pPeopleName;
    private ImageView pPeopleImage;
    private ImageView fFreindorNot;

    public PeopleJavaListitem() {
        // empty constructor for FireBase/FireStore
    }

/*
The constructor's ImageView fields will be initialized in Main with either mipmaps from fontawsome or
images later to be codded.
 */
    public PeopleJavaListitem(String pPeopleName, ImageView pPeopleImage, ImageView fFreindorNot) {

        this.pPeopleName = pPeopleName;
        this.pPeopleImage = pPeopleImage;
        this.fFreindorNot = fFreindorNot;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView
*/
    public String getpPeopleName() {
        return pPeopleName;
    }

    public ImageView getpPeopleImage() {
        return pPeopleImage;
    }

    public ImageView getfFreindorNot() {
        return fFreindorNot;
    }
}

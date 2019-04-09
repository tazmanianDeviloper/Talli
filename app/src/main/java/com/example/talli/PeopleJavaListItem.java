package com.example.talli;

/*
The class will initialize the necessary fields for the People button which will start the People
activity.
 */

import android.graphics.Typeface;
import android.widget.TextView;

public class PeopleJavaListItem extends MainActivity {

// Fontawsome icons represented by the fallowing two variables.
    private TextView userNoName;
    private TextView userNoImage;

// Firestore data-set represented by the fallowing two variables.
    private String userName;
    private String userImage;

    public PeopleJavaListItem() {
        // empty constructor for FireBase/FireStore
    }

/*
The String field userImage will be initialized in Main with images from FireStore. The Images
are not ImageView because in FireStore the only allowed format is String.
*/

    public PeopleJavaListItem(String userName, String userImage) {

        //condition for users without a name.
        if (userName.trim().equals("")) {
            userNoName.setText("No Name");
            this.userName = userName;

        }
        //condition for users without an image.
        if (userImage.trim().equals("")){
            userNoImage = (TextView) findViewById(R.id.user_no_image);
            Typeface userPlus = Typeface.createFromAsset(getAssets(),"fonts/font_awesome_5_pro_light_300.otf");
            userNoImage.setTypeface(userPlus);
            userNoImage.setText("\uf506");
        }


        this.userImage = userImage;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView.
*/

    String getUserName() {
        return userName;
    }

    String getUserImage() {
        return userImage;
    }
}

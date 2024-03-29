package com.example.talli;

/*
The class will initialize the necessary fields for the People button which will start the People
activity.
 */

public class PeopleJavaListItem {

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

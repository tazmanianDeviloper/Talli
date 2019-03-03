package com.example.talli;

import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;


/*
The class will initialize the necessary fields for people button which will start the people
activity.
 */

public class PeopleJavaListitem {

    private String peopleName;
    private CardView peopleCircleCardView;
    private CardView friendStatusCardView;


    public PeopleJavaListitem() {
        // empty constructor for FireBase/FireStore
    }

/*
The constructor's ImageView fields will be initialized in Main with either mipmaps from fontawsome or
images later to be codded.
 */

    public PeopleJavaListitem(String peopleName, CardView peopleCircleCardView, CardView friendStatusCardView) {
        this.peopleName = peopleName;
        this.peopleCircleCardView = peopleCircleCardView;
        this.friendStatusCardView = friendStatusCardView;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView
*/

    public String getPeopleName() {
        return peopleName;
    }

    public CardView getPeopleCircleCardView() {
        return peopleCircleCardView;
    }

    public CardView getFriendStatusCardView() {
        return friendStatusCardView;
    }
}

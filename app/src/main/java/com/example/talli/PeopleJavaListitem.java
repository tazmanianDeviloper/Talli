package com.example.talli;

/*
The class will initialize the necessary fields for people button which will start the people
activity.
 */

public class PeopleJavaListitem {

    private String peopleName;
    private String peopleImageUrl;

    public PeopleJavaListitem() {
        // empty constructor for FireBase/FireStore
    }

/*
The constructor's ImageView fields will be initialized in Main with either mipmaps from fontawsome or
images later to be codded.
 */

    public PeopleJavaListitem(String peopleName, String peopleImageUrl) {
        //condition for users without a name.
        if (peopleName.trim().equals("")) peopleName = "No Name";

        this.peopleName = peopleName;
        this.peopleImageUrl = peopleImageUrl;
    }

/*
Both parameterized constructor and getters are needed because one is for initialization and the
other is for the RecyclerView.
*/

    String getPeopleName() {
        return peopleName;
    }

    String getPeopleImageUrl() {
        return peopleImageUrl;
    }
}

package com.example.talli;

/*
The class will initialize the necessary fields for the People button which will start the People
activity.
 */

public class PeopleJavaListItem {

    private String peopleName;
    private String peopleImageUrl;

    public PeopleJavaListItem() {
        // empty constructor for FireBase/FireStore
    }

/*
The String field peopleImageUrl will be initialized in Main with images from FireStore. The Images
are not ImageView because in FireStore the only allowed format is String.
 */

    public PeopleJavaListItem(String peopleName, String peopleImageUrl) {
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

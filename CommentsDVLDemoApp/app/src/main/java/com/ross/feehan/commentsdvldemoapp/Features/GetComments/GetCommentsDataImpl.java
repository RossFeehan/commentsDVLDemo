package com.ross.feehan.commentsdvldemoapp.Features.GetComments;

import android.os.Handler;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class GetCommentsDataImpl implements GetCommentsDataInterface {

    private CommentsSharedPreferences commentsSP;

    //constructor
    public GetCommentsDataImpl(CommentsSharedPreferences commentsSP) {
        this.commentsSP = commentsSP;
    }

    //GetCommentsInterface methods
    /*Method that gets the comments stored on file from CommentsSharedPreferences class
     *Returns the list of comments to the GetCommentsLogicInterface Listener through implemented interface method
     */
    @Override
    public void getComments(GetCommentsLogicInterface getCommentsListener) {

        final GetCommentsLogicInterface commentsListener = getCommentsListener;

        //Just a timed handler to make the process look longer than it is on the UI
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Comment> comments = commentsSP.getComments();
                commentsListener.receiveComments(comments);
            }
        }, 2000);
    }
}
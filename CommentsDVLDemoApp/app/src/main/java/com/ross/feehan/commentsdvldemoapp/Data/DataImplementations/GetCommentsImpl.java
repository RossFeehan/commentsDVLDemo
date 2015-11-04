package com.ross.feehan.commentsdvldemoapp.Data.DataImplementations;

import android.os.Handler;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.GetCommentsInterface;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class GetCommentsImpl implements GetCommentsInterface {

    private CommentsSharedPreferences commentsSP;

    //constructor
    public GetCommentsImpl(CommentsSharedPreferences commentsSP) {
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
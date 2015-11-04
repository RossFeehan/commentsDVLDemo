package com.ross.feehan.commentsdvldemoapp.Data.DataImplementations;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.GetCommentsInterface;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class GetCommentsImpl implements GetCommentsInterface{

    private CommentsSharedPreferences commentsSP;
    private GetCommentsLogicInterface getCommentsListener;

    //constructor
    public GetCommentsImpl(CommentsSharedPreferences commentsSP){
        this.commentsSP = commentsSP;
    }

    //GetCommentsInterface methods
    /*Method that gets the comments stored on file from CommentsSharedPreferences class
     *Returns the list of comments to the GetCommentsLogicInterface Listener through implemented interface method
     */
    @Override
    public void getComments() {
        List<Comment> comments = commentsSP.getComments();
        getCommentsListener.receiveComments(comments);
    }

    /*Mehtod that registers the GetCommentsLogicInterface Listener
     *So the list of comments can be returned through an implemented interface method later on
     */
    @Override
    public void registerGetCommentsListener(GetCommentsLogicInterface getCommentsListener) {
        this.getCommentsListener = getCommentsListener;
    }
}

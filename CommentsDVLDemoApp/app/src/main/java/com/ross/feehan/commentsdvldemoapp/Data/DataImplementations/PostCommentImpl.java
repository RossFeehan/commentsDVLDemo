package com.ross.feehan.commentsdvldemoapp.Data.DataImplementations;

import android.os.Handler;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.PostCommentInterface;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;

import java.util.List;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentImpl implements PostCommentInterface {

    private CommentsSharedPreferences commentSP;

    //Constructor
    public PostCommentImpl(CommentsSharedPreferences commentSP){
        this.commentSP = commentSP;
    }

    /* Method that posts the comment
     *@Params Comment comment - The comment to post
     * @Params PostCommentsLogicInterface postCommentListener - The calling class listener to be notified
     */
    @Override
    public void postComment(Comment comment, PostCommentsLogicInterface postCommentListener) {

        final Comment commentToSave = comment;
        final PostCommentsLogicInterface postListener = postCommentListener;
        //Just a timed handler to make the process look longer than it is on the UI
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean posted = commentSP.saveComment(commentToSave);
                postListener.commentPosted(posted);
            }
        }, 2000);

    }
}

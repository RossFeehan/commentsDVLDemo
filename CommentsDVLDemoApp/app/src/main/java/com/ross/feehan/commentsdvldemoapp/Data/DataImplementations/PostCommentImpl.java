package com.ross.feehan.commentsdvldemoapp.Data.DataImplementations;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.PostCommentInterface;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;

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

        boolean posted = commentSP.saveComment(comment);
        postCommentListener.commentPosted(posted);
    }
}

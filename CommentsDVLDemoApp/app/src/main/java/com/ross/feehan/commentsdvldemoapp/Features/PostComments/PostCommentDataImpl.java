package com.ross.feehan.commentsdvldemoapp.Features.PostComments;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public class PostCommentDataImpl implements PostCommentDataInterface {

    private CommentsSharedPreferences commentSP;

    //CONSTRUCTOR
    public PostCommentDataImpl(CommentsSharedPreferences commentSP){
        this.commentSP = commentSP;
    }

    /* Method that posts the comment
     *@Params Comment comment - The comment to post
     * @Params PostCommentsLogicInterface postCommentListener - The calling class listener to be notified
     */
    @Override
    public void postComment(Comment comment, PostCommentLogicInterface postCommentListener) {

        boolean posted = commentSP.saveComment(comment);
        postCommentListener.commentPosted(posted);

    }
}
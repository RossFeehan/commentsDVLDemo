package com.ross.feehan.commentsdvldemoapp.Features.PostComments;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public interface PostCommentDataInterface {

    public void postComment(Comment comment, PostCommentLogicInterface postCommentListener);
}

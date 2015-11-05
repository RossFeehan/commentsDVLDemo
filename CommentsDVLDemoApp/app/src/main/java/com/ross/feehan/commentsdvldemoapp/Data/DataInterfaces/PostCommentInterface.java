package com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.PostCommentsLogicInterface;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public interface PostCommentInterface {

    public void postComment(Comment comment, PostCommentsLogicInterface postCommentListener);
}

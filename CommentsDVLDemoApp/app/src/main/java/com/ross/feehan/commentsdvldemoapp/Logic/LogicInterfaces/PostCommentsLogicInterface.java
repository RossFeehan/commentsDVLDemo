package com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.PostCommentViewInterface;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public interface PostCommentsLogicInterface {

    public void checkComment(Comment comment, PostCommentViewInterface postCommentViewListener);

    public void commentPosted(boolean commentPostedSuccessfully);
}

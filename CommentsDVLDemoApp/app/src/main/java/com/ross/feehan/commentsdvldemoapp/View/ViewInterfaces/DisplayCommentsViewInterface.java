package com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces;

import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public interface DisplayCommentsViewInterface extends LoadingProgressInterface{

    public void displayComments(List<Comment> comments);

    public void noCommentsYet();

    public void getCommentsFailed();


}

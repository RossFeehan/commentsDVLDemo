package com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public interface DeleteCommentViewInterface extends LoadingProgressInterface{

    public void deleteComment(int commentPosition);

    public void commentDeletedSuccessfully();

    public void commentDeletedUnsuccessfully();
}

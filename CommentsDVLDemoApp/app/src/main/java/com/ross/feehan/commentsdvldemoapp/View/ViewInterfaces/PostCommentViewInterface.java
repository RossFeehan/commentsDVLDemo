package com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public interface PostCommentViewInterface extends LoadingProgressInterface{

    public void commentPostedSuccessfully();

    public void commentUnsuccessfullyPosted();

    public void commentStructuredIncorrectlyBlank();

    public void commentStructuredIncorrectlyCharacterCount();
}

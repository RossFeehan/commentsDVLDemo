package com.ross.feehan.commentsdvldemoapp.Features.PostComments;

import com.ross.feehan.commentsdvldemoapp.Shared.Interfaces.ViewInterface;

/**
 * Created by Ross Feehan on 05/11/2015.
 * Copyright Ross Feehan
 */
public interface PostCommentViewInterface extends ViewInterface {

    public void commentPostedSuccessfully();

    public void commentUnsuccessfullyPosted();

    public void commentStructuredIncorrectlyBlank();

    public void commentStructuredIncorrectlyCharacterCount();
}

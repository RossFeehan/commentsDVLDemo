package com.ross.feehan.commentsdvldemoapp.Features.DeleteComments;

import com.ross.feehan.commentsdvldemoapp.Shared.Interfaces.ViewInterface;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public interface DeleteCommentViewInterface extends ViewInterface {

    public void deleteComment(int commentPosition);

    public void commentDeletedSuccessfully();

    public void commentDeletedUnsuccessfully();
}

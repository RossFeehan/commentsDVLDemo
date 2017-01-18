package com.ross.feehan.commentsdvldemoapp.Features.DeleteComments;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public interface DeleteCommentLogicInterface {

    public void deleteComment(int commentPosition);

    public void setCommentToBeDeleted();

    public void cancelCommentDeletion();

    public void commentDeleted(boolean deleted);
}

package com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces;

import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.DeleteCommentViewInterface;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public interface DeleteCommentLogicInterface {

    public void deleteComment(int commentPosition, DeleteCommentViewInterface deleteCommentViewListener);

    public void setCommentToBeDeleted();

    public void cancelCommentDeletion();

    public void commentDeleted(boolean deleted);
}

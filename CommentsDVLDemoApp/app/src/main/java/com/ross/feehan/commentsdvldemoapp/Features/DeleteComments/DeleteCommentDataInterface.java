package com.ross.feehan.commentsdvldemoapp.Features.DeleteComments;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public interface DeleteCommentDataInterface {

    void deleteComment(int commentPosition, DeleteCommentLogicInterface deleteCommentListener);
}

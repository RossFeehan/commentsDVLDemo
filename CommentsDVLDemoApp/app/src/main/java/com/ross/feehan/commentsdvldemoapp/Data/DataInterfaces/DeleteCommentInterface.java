package com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces;

import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.DeleteCommentLogicInterface;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public interface DeleteCommentInterface {

    void deleteComment(int commentPosition, DeleteCommentLogicInterface deleteCommentListener);
}

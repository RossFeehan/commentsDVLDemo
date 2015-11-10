package com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.DeleteCommentInterface;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.DeleteCommentLogicInterface;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.DeleteCommentViewInterface;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public class DeleteCommentsLogicImpl implements DeleteCommentLogicInterface {

    private DeleteCommentInterface deleteComment;
    private DeleteCommentViewInterface deleteCommentViewListener;
    private Boolean deleteCommentBool;

    //constructor
    public DeleteCommentsLogicImpl(DeleteCommentInterface deleteComment){
        this.deleteComment = deleteComment;
    }

    //DeleteCommentLogicInterface INTERFACE METHODS
    /*Method called by view module class to delete the comment
     *@Params int commentPosition - The position of the comment to delete
     * @Params DeleteCommentViewInterface deleteCommentViewListener - The view module class to notify
     * when the comment has been deleted
     */
    @Override
    public void deleteComment(int commentPosition, DeleteCommentViewInterface deleteCommentViewListener) {
        if(deleteCommentBool){
            this.deleteCommentViewListener = deleteCommentViewListener;
            deleteComment.deleteComment(commentPosition, this);
            //set bool to false to fix bug of snackbar onDismiss being called multiple times.
            //To stop multiple comments being deleted
            deleteCommentBool = false;
        }
    }

    @Override
    public void setCommentToBeDeleted() {
        deleteCommentBool = true;
    }

    @Override
    public void cancelCommentDeletion() {
        deleteCommentBool = false;
    }

    /*Method called by the data module class responsible for deleting the comment
     * This method checks that the comment was deleted successfully or unsuccessfully and notifies
     * the view module class
     * @Params boolean deleted - Boolean to notify if the comment was deleted successfully or unsuccessfully
     */
    @Override
    public void commentDeleted(boolean deleted) {
        //if the comment was deleted successfully
        if(deleted){
            deleteCommentViewListener.commentDeletedSuccessfully();
        }
        //else if the comment was not deleted successfully
        else{
            deleteCommentViewListener.commentDeletedUnsuccessfully();
        }
    }
}

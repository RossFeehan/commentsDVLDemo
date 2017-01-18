package com.ross.feehan.commentsdvldemoapp.Features.DeleteComments;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public class DeleteCommentLogicImpl implements DeleteCommentLogicInterface {

    private DeleteCommentDataInterface deleteCommentData;
    private DeleteCommentViewInterface view;
    private Boolean deleteCommentBool;

    //constructor
    public DeleteCommentLogicImpl(DeleteCommentDataInterface deleteComment, DeleteCommentViewInterface view){
        this.deleteCommentData = deleteComment;
        this.view = view;
    }

    //DeleteCommentLogicInterface INTERFACE METHODS
    /*Method called by view module class to delete the comment
     *@Params int commentPosition - The position of the comment to delete
     * @Params DeleteCommentViewInterface view - The view module class to notify
     * when the comment has been deleted
     */
    @Override
    public void deleteComment(int commentPosition) {
        if(deleteCommentBool){
            deleteCommentData.deleteComment(commentPosition, this);
            //set bool to false to fix bug of snackbar onDismiss being called multiple times.
            //To stop multiple comments being deleted
            deleteCommentBool = false;
        }
    }

    /*Method that sets the boolean of delete comment to true, this means the user has selected a comment to be deleted
     *but still has a choice to not delete the comment through the use of a snackbar that is on display to them in the activity
     */
    @Override
    public void setCommentToBeDeleted() {
        deleteCommentBool = true;
    }

    /*Method that sets delete comment bool to false because the user has decided not to delete the comment
     *through the use of the snackbar
     */
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
            view.commentDeletedSuccessfully();
        }
        //else if the comment was not deleted successfully
        else{
            view.commentDeletedUnsuccessfully();
        }
    }
}
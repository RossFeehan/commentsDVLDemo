package com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences;

import android.content.Context;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class CommentsSharedPreferences {

    private Context ctx;
    private static final String COMMENTSFILE = "CommentsFile";

    //Constructor
    public CommentsSharedPreferences(Context ctx){
        this.ctx = ctx;
    }

    /*Method to save comment to file
     *@Params Comment comment - The comment to save to file
     * @Return boolean - if the comment was saved successfully or not
     */
    public boolean saveComment(Comment comment){
        boolean saved = false;

        List<Comment> comments = getComments();
        comments.add(comment);

        return saveFile(comments);
    }

    /*Method to delete comment from file
     *@Params int commentPosition - The position of the comment to delete
     */
    public boolean deleteComment(int commentPosition){
        boolean deleted = false;
        List<Comment> comments = getComments();
        comments.remove(commentPosition);

        return saveFile(comments);
    }

    /*Method to retrieve all comments from file
     *@Return List<Comment> - The list of comments, null if there are none.
     */
    public List<Comment> getComments(){
        ArrayList<Comment> comments = new ArrayList<Comment>();

        try{
            FileInputStream fileInput = ctx.openFileInput(COMMENTSFILE);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            comments = (ArrayList<Comment>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    /*Method that handles saving file to device
     *@Params (List<Comment> comments - the list of comments to save
     */
    private boolean saveFile(List<Comment> comments){
        boolean saved = false;
        try{
            FileOutputStream fileOut = ctx.openFileOutput(COMMENTSFILE, Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(comments);
            objectOut.close();
            fileOut.close();
            saved = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return saved;
    }
}

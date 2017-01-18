package com.ross.feehan.commentsdvldemoapp.Shared;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ross Feehan on 13/11/2015.
 * Copyright Ross Feehan
 */
public class CommentsDVLDemoAppApplicationTest extends CommentsDVLDemoAppApplication {

    private DataDITestModule dataDITestModule;

    public List<Object> getModules(){
        return Arrays.<Object>asList(getDataDITestModules());
    }

    public DataDITestModule getDataDITestModules(){
        if(dataDITestModule == null){
            dataDITestModule = new DataDITestModule();
        }
        return dataDITestModule;
    }
}

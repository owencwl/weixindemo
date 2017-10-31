package com.owen.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by owen on 2017/3/12.
 */
public class DeleteLogo {

    public void dellogo(List<String> logolist,String logopath)throws IOException{


        for (String ss:logolist
             ) {

            FileUtils.deleteQuietly(new File(logopath+ss));
        }




    }


}

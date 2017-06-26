/*
 *
 *  @(#)Snippet.java Created on 2017年6月20日
 *
 * Copyright 2014 Huawei Tech. Co. Ltd. All Rights Reserved.
 *
 * Description
 *
 * CopyrightVersion
 *
 */
package com.cloud.register;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * <p>Title:  </p>
 * <p>Description:  </p>
 * <pre>  </pre>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 华为技术有限公司</p>
 * @author y00295039
 * @version V1.0 2017年6月20日
 * @since
 */
public class Snippet
{
    public static void main(String[] args) throws IOException {  
            File file = new File("d:\\zTemp\\aa");  
            FileOutputStream fis = new FileOutputStream(file);  
            FileChannel fc = fis.getChannel();  
            FileLock flock = fc.tryLock();  
            if(flock.isValid()){  
                System.out.println(file.getName()+ "is locked");  
            }  
            new Thread(){  
                public void run(){  
                    try{  
                        File file = new File("d:\\zTemp\\aa\\aa.txt");  
                        FileOutputStream fi = new FileOutputStream(file);  
                        fi.write('b');  
                    }catch(Exception e){  
                        e.printStackTrace();  
                    }  
                }  
            }.run();  
            flock.release();  
            System.out.println(file.getName()+ "is released");  
            fc.close();  
            fis.close();  
        } 
}


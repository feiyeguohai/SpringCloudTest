/*
 *
 *  @(#)HelloController.java Created on 2017年6月9日
 *
 * Copyright 2014 Huawei Tech. Co. Ltd. All Rights Reserved.
 *
 * Description
 *
 * CopyrightVersion
 *
 */
package com.cloud.register;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Title:  </p>
 * <p>Description:  </p>
 * <pre>  </pre>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 华为技术有限公司</p>
 * @author y00295039
 * @version V1.0 2017年6月9日
 * @since
 */
@RestController
public class HelloController
{

    @Value("${server.port}")
    String port;
    
    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name) {
        
        return "hi "+name+",i am from port:" +port;
    }
    
    
    
}

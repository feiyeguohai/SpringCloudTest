/*
 *
 *  @(#)HelloServiceFeignFallback.java Created on 2017年6月24日
 *
 * Copyright 2014 Huawei Tech. Co. Ltd. All Rights Reserved.
 *
 * Description
 *
 * CopyrightVersion
 *
 */
package com.cloud.consumerfeign;

import org.springframework.stereotype.Component;

/**
 * <p>Title:  </p>
 * <p>Description:  </p>
 * <pre>  </pre>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 华为技术有限公司</p>
 * @author y00295039
 * @version V1.0 2017年6月24日
 * @since
 */
@Component
public class HelloServiceFeignFallback implements HelloServiceFeign
{

    @Override
    public String sayHello(String name)
    {
        
        return "sorry, " + name + " , service is not available via feign.";
    }

}

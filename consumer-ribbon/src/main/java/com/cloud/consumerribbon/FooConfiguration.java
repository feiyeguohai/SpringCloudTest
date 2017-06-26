/*
 *
 *  @(#)FooConfiguration.java Created on 2017年6月17日
 *
 * Copyright 2014 Huawei Tech. Co. Ltd. All Rights Reserved.
 *
 * Description
 *
 * CopyrightVersion
 *
 */
package com.cloud.consumerribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

public class FooConfiguration
{
    public ServerList<Server> ribbonServerList(IClientConfig config){
        return null;
    }
}

/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.naming.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.common.Constants;
import com.alibaba.nacos.api.naming.CommonParams;
import com.alibaba.nacos.api.naming.pojo.AbstractHealthChecker;
import com.alibaba.nacos.core.utils.WebUtils;
import com.alibaba.nacos.naming.core.Cluster;
import com.alibaba.nacos.naming.core.Service;
import com.alibaba.nacos.naming.core.ServiceManager;
import com.alibaba.nacos.naming.exception.NacosException;
import com.alibaba.nacos.naming.misc.Loggers;
import com.alibaba.nacos.naming.misc.UtilsAndCommons;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nkorange
 */
@RestController
@RequestMapping(UtilsAndCommons.NACOS_NAMING_CONTEXT + "/cluster")
public class ClusterController {

    @Autowired
    protected ServiceManager serviceManager;

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(HttpServletRequest request) throws Exception {

        String namespaceId = WebUtils.optional(request, CommonParams.NAMESPACE_ID,
            Constants.DEFAULT_NAMESPACE_ID);
        String clusterName = WebUtils.required(request, CommonParams.CLUSTER_NAME);
        String serviceName = WebUtils.required(request, CommonParams.SERVICE_NAME);
        String healthChecker = WebUtils.required(request, "healthChecker");
        String metadata = WebUtils.optional(request, "metadata", StringUtils.EMPTY);
        String checkPort = WebUtils.required(request, "checkPort");
        String useInstancePort4Check = WebUtils.required(request, "useInstancePort4Check");

        Service service = serviceManager.getService(namespaceId, serviceName);
        if (service == null) {
            throw new NacosException(NacosException.INVALID_PARAM, "provider not found:" + serviceName);
        }

        Cluster cluster = service.getClusterMap().get(clusterName);
        if (cluster == null) {
            Loggers.SRV_LOG.warn("[UPDATE-CLUSTER] cluster not exist, will create it: {}, provider: {}", clusterName, serviceName);
            cluster = new Cluster();
            cluster.setName(clusterName);
            cluster.setService(service);
        }

        cluster.setDefCkport(NumberUtils.toInt(checkPort));
        cluster.setUseIPPort4Check(BooleanUtils.toBoolean(useInstancePort4Check));

        JSONObject healthCheckObj = JSON.parseObject(healthChecker);
        AbstractHealthChecker abstractHealthChecker;

        switch (healthCheckObj.getString("type")) {
            case AbstractHealthChecker.Tcp.TYPE:
                abstractHealthChecker = JSON.parseObject(healthChecker, AbstractHealthChecker.Tcp.class);
                break;
            case AbstractHealthChecker.Http.TYPE:
                abstractHealthChecker = JSON.parseObject(healthChecker, AbstractHealthChecker.Http.class);
                break;
            case AbstractHealthChecker.Mysql.TYPE:
                abstractHealthChecker = JSON.parseObject(healthChecker, AbstractHealthChecker.Mysql.class);
                break;
            case AbstractHealthChecker.None.TYPE:
                abstractHealthChecker = JSON.parseObject(healthChecker, AbstractHealthChecker.None.class);
                break;
            default:
                throw new NacosException(NacosException.INVALID_PARAM, "unknown health check type:" + healthChecker);
        }

        cluster.setHealthChecker(abstractHealthChecker);
        cluster.setMetadata(UtilsAndCommons.parseMetadata(metadata));
        cluster.init();
        service.getClusterMap().put(clusterName, cluster);
        service.setLastModifiedMillis(System.currentTimeMillis());
        service.recalculateChecksum();
        service.validate();

        serviceManager.addOrReplaceService(service);

        return "ok";
    }
}

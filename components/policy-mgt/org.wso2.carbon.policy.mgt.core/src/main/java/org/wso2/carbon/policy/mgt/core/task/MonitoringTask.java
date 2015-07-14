/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.wso2.carbon.policy.mgt.core.task;

import org.wso2.carbon.device.mgt.common.Device;
import org.wso2.carbon.device.mgt.core.dao.DeviceManagementDAOFactory;
import org.wso2.carbon.device.mgt.core.dao.DeviceTypeDAO;
import org.wso2.carbon.device.mgt.core.dto.DeviceType;
import org.wso2.carbon.device.mgt.core.service.DeviceManagementProviderService;
import org.wso2.carbon.ntask.core.Task;
import org.wso2.carbon.policy.mgt.common.spi.PolicyMonitoringService;
import org.wso2.carbon.policy.mgt.core.internal.PolicyManagementDataHolder;

import java.util.List;
import java.util.Map;

public class MonitoringTask implements Task {

    private DeviceTypeDAO deviceTypeDAO;

    @Override
    public void setProperties(Map<String, String> map) {

    }

    @Override
    public void init() {
        deviceTypeDAO = DeviceManagementDAOFactory.getDeviceTypeDAO();
    }

    @Override
    public void execute() {
        try {
            List<DeviceType> deviceTypes = deviceTypeDAO.getDeviceTypes();


            DeviceManagementProviderService deviceManagementProviderService =
                    PolicyManagementDataHolder.getInstance().getDeviceManagementService();

            for (DeviceType deviceType : deviceTypes) {
                PolicyMonitoringService monitoringService =
                        PolicyManagementDataHolder.getInstance().getPolicyMonitoringService(deviceType.getName());

                List<Device> devices = deviceManagementProviderService.getAllDevices(deviceType.getName());
                monitoringService.notifyDevices(devices);
            }

        } catch (Exception e) {

        }

    }
}
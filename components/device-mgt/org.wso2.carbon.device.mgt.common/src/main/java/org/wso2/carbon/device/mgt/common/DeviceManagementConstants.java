/**
 *  Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.carbon.device.mgt.common;

public final class DeviceManagementConstants {

    /*DEVICE Manager operations*/
    public static final String ADD_DEVICE_ENTRY = "Add device entry";
    public static final String STANDARD_TRANSACTION_MANAGER_JNDI_NAME = "java:comp/TransactionManager";
    public static final String STANDARD_USER_TRANSACTION_JNDI_NAME = "java:comp/UserTransaction";
    /*Data Source Configurations */

    public static final class DataSourceProperties {

        public static final String DB_CHECK_QUERY = "SELECT * FROM DM_DEVICE";
        public static final String SECURE_VAULT_NS = "http://org.wso2.securevault/configuration";
        public static final String DEVICE_CONFIG_XML_NAME = "device-config.xml";
    }

    public static final class SecureValueProperties {

        private SecureValueProperties() {
            throw new AssertionError();
        }

        public static final String SECRET_ALIAS_ATTRIBUTE_NAME_WITH_NAMESPACE = "secretAlias";
        public static final String SECURE_VAULT_NS = "http://org.wso2.securevault/configuration";
    }

}
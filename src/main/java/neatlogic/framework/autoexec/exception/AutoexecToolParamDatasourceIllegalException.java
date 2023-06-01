/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecToolParamDatasourceIllegalException extends ApiRuntimeException {

    private static final long serialVersionUID = -7415182960002285047L;

    public AutoexecToolParamDatasourceIllegalException(String param) {
        super("参数：“{0}”的数据源格式不正确，正确格式为：{\"dataList\":[{\"text\":\"是\",\"value\":\"1\"},{\"text\":\"否\",\"value\":\"0\"}]}，其中(text的key和value)与(value的key)不能为空", param);
    }


}

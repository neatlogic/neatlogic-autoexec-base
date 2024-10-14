/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.script.paramtype;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.node.AutoexecNodeVo;
import neatlogic.framework.cmdb.crossover.IResourceAccountCrossoverMapper;
import neatlogic.framework.cmdb.dto.resourcecenter.AccountVo;
import neatlogic.framework.common.constvalue.GroupSearch;
import neatlogic.framework.crossover.CrossoverServiceFactory;
import neatlogic.framework.crossover.IFileCrossoverService;
import neatlogic.framework.file.dto.FileVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lvzk
 * @since 2021/11/18 12:22
 **/
public abstract class ScriptParamTypeBase implements IScriptParamType{
    /**
     * 是否需要配置数据源
     *
     * @return true|false
     */
    @Override
    public Boolean needDataSource() {
        return myNeedDataSource();
    }

    protected Boolean myNeedDataSource(){
        return false;
    }

    /**
     * 根据参数值获取对应的text
     *
     * @return text
     */
    @Override
    public Object getTextByValue(Object value, JSONObject config) {
        return getMyTextByValue(value, config);
    }

    protected Object getMyTextByValue(Object value, JSONObject config){
        return value;
    }

    /**
     * 根据参数值获取对应给autoexec执行的参数
     *
     * @return param
     */
    @Override
    public Object getAutoexecParamByValue(Object value) {
        return getMyAutoexecParamByValue(value);
    }

    protected Object getMyAutoexecParamByValue(Object value){
        return value;
    }


    @Override
    public Object getExchangeParamByValue(Object value) {
        return getMyExchangeParamByValue(value);
    }
    protected Object getMyExchangeParamByValue(Object value){
        return value;
    }

    protected List<String> getStringList(JSONArray jsonArray) {
        List<String> resultList = new ArrayList<>();
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                resultList.addAll(getStringList(array));
            } else {
                resultList.add(obj.toString());
            }
        }
        return resultList;
    }

    protected List<Object> getObjectList(JSONArray jsonArray) {
        List<Object> resultList = new ArrayList<>();
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                resultList.addAll(getObjectList(array));
            } else {
                resultList.add(obj);
            }
        }
        return resultList;
    }

    protected String getFirstNotBlankString(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                String str = getFirstNotBlankString(array);
                if (StringUtils.isNotBlank(str)) {
                    return str;
                }
            } else {
                String str = obj.toString();
                if (StringUtils.isNotBlank(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    protected Object getFirstNotNullObject(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                Object obj2 = getFirstNotNullObject(array);
                if (obj2 != null) {
                    return obj2;
                }
            } else {
                return obj;
            }
        }
        return null;
    }

    protected Boolean getFirstNotNullBoolean(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                Boolean bool = getFirstNotNullBoolean(array);
                if (bool != null) {
                    return bool;
                }
            } else if (obj instanceof Boolean) {
                return (Boolean) obj;
            } else {
                String str = obj.toString();
                if (Objects.equals(str, Boolean.TRUE.toString())) {
                    return Boolean.TRUE;
                } else if (Objects.equals(str, Boolean.FALSE.toString())) {
                    return Boolean.FALSE;
                }
            }
        }
        return null;
    }

    protected Object getJSONObjectOrJSONArray(JSONArray jsonArray) {
        JSONArray jsonList = new JSONArray();
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONObject) {
                jsonList.add(obj);
            } else if (obj instanceof JSONArray) {
                jsonList.add(obj);
            } else if (obj instanceof Number) {
                jsonList.add(obj);
            } else {
                String str = obj.toString();
                if (str.startsWith("{") && str.endsWith("}")) {
                    JSONObject jsonObj = JSON.parseObject(str);
                    jsonList.add(jsonObj);
                } else if (str.startsWith("[") && str.endsWith("]")) {
                    JSONArray array = JSON.parseArray(str);
                    jsonList.add(array);
                } else {
                    jsonList.add(str);
                }
            }
        }
        if (jsonList.size() == 1) {
            Object obj = jsonList.get(0);
            if (obj instanceof JSONObject) {
                return obj;
            } else if (obj instanceof JSONArray) {
                return obj;
            }
        }
        return jsonList;
    }

    protected JSONObject getFileInfo(JSONArray jsonArray) {
        JSONObject resultObj = new JSONObject();
        JSONArray fileIdList = new JSONArray();
        JSONArray fileList = new JSONArray();
        IFileCrossoverService fileCrossoverService = CrossoverServiceFactory.getApi(IFileCrossoverService.class);
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONObject) {
                JSONObject jsonObj = (JSONObject) obj;
                Long fileId = jsonObj.getLong("id");
                JSONArray fileIdArray = jsonObj.getJSONArray("fileIdList");
                JSONArray fileArray = jsonObj.getJSONArray("fileList");
                if (CollectionUtils.isNotEmpty(fileIdArray) && CollectionUtils.isNotEmpty(fileArray)) {
                    fileIdList.addAll(fileIdArray);
                    fileList.addAll(fileArray);
                } else if (fileId != null) {
                    FileVo file = fileCrossoverService.getFileById(fileId);
                    if (file != null) {
                        fileIdList.add(fileId);
                        JSONObject fileObj = new JSONObject();
                        fileObj.put("id", fileId);
                        fileObj.put("name", file.getName());
                        fileList.add(fileObj);
                    }
                }
            } else if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                JSONObject jsonObj = getFileInfo(array);
                JSONArray fileIdArray = jsonObj.getJSONArray("fileIdList");
                if (CollectionUtils.isNotEmpty(fileIdArray)) {
                    fileIdList.addAll(fileIdArray);
                }
                JSONArray fileArray = jsonObj.getJSONArray("fileList");
                if (CollectionUtils.isNotEmpty(fileArray)) {
                    fileList.addAll(fileArray);
                }
            } else if (obj instanceof Long) {
                Long fileId = (Long) obj;
                FileVo file = fileCrossoverService.getFileById(fileId);
                if (file != null) {
                    fileIdList.add(fileId);
                    JSONObject fileObj = new JSONObject();
                    fileObj.put("id", fileId);
                    fileObj.put("name", file.getName());
                    fileList.add(fileObj);
                }
            } else {
                String str = obj.toString();
                if (str.startsWith("{") && str.endsWith("}")) {
                    JSONObject jsonObj = JSONObject.parseObject(str);
                    Long fileId = jsonObj.getLong("id");
                    JSONArray fileIdArray = jsonObj.getJSONArray("fileIdList");
                    JSONArray fileArray = jsonObj.getJSONArray("fileList");
                    if (CollectionUtils.isNotEmpty(fileIdArray) && CollectionUtils.isNotEmpty(fileArray)) {
                        fileIdList.addAll(fileIdArray);
                        fileList.addAll(fileArray);
                    } else if (fileId != null) {
                        FileVo file = fileCrossoverService.getFileById(fileId);
                        if (file != null) {
                            fileIdList.add(fileId);
                            JSONObject fileObj = new JSONObject();
                            fileObj.put("id", fileId);
                            fileObj.put("name", file.getName());
                            fileList.add(fileObj);
                        }
                    }
                } else if (str.startsWith("[") && str.endsWith("]")) {
                    JSONArray array = JSONArray.parseArray(str);
                    JSONObject jsonObj = getFileInfo(array);
                    JSONArray fileIdArray = jsonObj.getJSONArray("fileIdList");
                    if (CollectionUtils.isNotEmpty(fileIdArray)) {
                        fileIdList.addAll(fileIdArray);
                    }
                    JSONArray fileArray = jsonObj.getJSONArray("fileList");
                    if (CollectionUtils.isNotEmpty(fileArray)) {
                        fileList.addAll(fileArray);
                    }
                } else {
                    try {
                        Long fileId = Long.valueOf(str);
                        FileVo file = fileCrossoverService.getFileById(fileId);
                        if (file != null) {
                            fileIdList.add(fileId);
                            JSONObject fileObj = new JSONObject();
                            fileObj.put("id", fileId);
                            fileObj.put("name", file.getName());
                            fileList.add(fileObj);
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        }
        resultObj.put("fileIdList", fileIdList);
        resultObj.put("fileList", fileList);
        return resultObj;
    }

    protected List<String> getUserSelectInfo(JSONArray jsonArray) {
        List<String> resultList = new ArrayList<>();
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                for (Object obj2 : array) {
                    String str = obj2.toString();
                    if (str.length() == 37) {
                        if (str.startsWith(GroupSearch.USER.getValuePlugin())
                                || str.startsWith(GroupSearch.TEAM.getValuePlugin())
                                || str.startsWith(GroupSearch.ROLE.getValuePlugin())) {
                            resultList.add(str);
                        }
                    }
                }
            } else {
                String str = obj.toString();
                if (str.length() == 37) {
                    if (str.startsWith(GroupSearch.USER.getValuePlugin())
                            || str.startsWith(GroupSearch.TEAM.getValuePlugin())
                            || str.startsWith(GroupSearch.ROLE.getValuePlugin())) {
                        resultList.add(str);
                    }
                }
            }
        }
        return resultList;
    }

    protected List<AutoexecNodeVo> getInputNodeList(JSONArray jsonArray) {
        List<AutoexecNodeVo> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(jsonArray)) {
            return resultList;
        }
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.startsWith("{") && str.endsWith("}")) {
                    JSONObject jsonObj = JSON.parseObject(str);
                    String ip = jsonObj.getString("ip");
                    if (StringUtils.isNotBlank(ip)) {
                        resultList.add(convertToAutoexecNodeVo(jsonObj));
                    }
                } else if (str.startsWith("[") && str.endsWith("]")) {
                    JSONArray array = JSON.parseArray(str);
                    List<AutoexecNodeVo> list = getInputNodeList(array);
                    if (CollectionUtils.isNotEmpty(list)) {
                        resultList.addAll(list);
                    }
                } else if (str.contains("\n")) {
                    String[] split = str.split("\n");
                    for (String e : split) {
                        resultList.add(new AutoexecNodeVo(e));
                    }
                } else {
                    resultList.add(new AutoexecNodeVo(str));
                }
            } else if (obj instanceof JSONObject) {
                JSONObject jsonObj = (JSONObject) obj;
                JSONArray selectNodeArray = jsonObj.getJSONArray("selectNodeList");
                if (CollectionUtils.isNotEmpty(selectNodeArray)) {
                    resultList.addAll(selectNodeArray.toJavaList(AutoexecNodeVo.class));
                }
                JSONArray inputNodeArray = jsonObj.getJSONArray("inputNodeList");
                if (CollectionUtils.isNotEmpty(inputNodeArray)) {
                    resultList.addAll(inputNodeArray.toJavaList(AutoexecNodeVo.class));
                }
                String ip = jsonObj.getString("ip");
                if (StringUtils.isNotBlank(ip)) {
                    resultList.add(convertToAutoexecNodeVo(jsonObj));
                }
            } else if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                List<AutoexecNodeVo> list = getInputNodeList(array);
                if (CollectionUtils.isNotEmpty(list)) {
                    resultList.addAll(list);
                }
            }
        }
        return resultList;
    }

    protected AutoexecNodeVo convertToAutoexecNodeVo(JSONObject jsonObj) {
        Long id = jsonObj.getLong("id");
        String ip = jsonObj.getString("ip");
        Integer port = jsonObj.getInteger("port");
        String name = jsonObj.getString("name");
        AutoexecNodeVo autoexecNodeVo = new AutoexecNodeVo();
        autoexecNodeVo.setIp(ip);
        if (id != null) {
            autoexecNodeVo.setId(id);
        }
        if (port != null) {
            autoexecNodeVo.setPort(port);
        }
        if (StringUtils.isNotBlank(name)) {
            autoexecNodeVo.setName(name);
        }
        return autoexecNodeVo;
    }

    protected Long getAccountId(JSONArray jsonArray) {
        if (CollectionUtils.isEmpty(jsonArray)) {
            return null;
        }
        IResourceAccountCrossoverMapper resourceAccountCrossoverMapper = CrossoverServiceFactory.getApi(IResourceAccountCrossoverMapper.class);
        for (Object obj : jsonArray) {
            if (obj == null) {
                continue;
            }
            if (obj instanceof Long) {
                Long accountId = (Long) obj;
                AccountVo accountVo = resourceAccountCrossoverMapper.getAccountById(accountId);
                if (accountVo != null) {
                    return accountId;
                }
            } else if (obj instanceof String) {
                String account = (String) obj;
                try {
                    Long accountId = Long.valueOf(account);
                    AccountVo accountVo = resourceAccountCrossoverMapper.getAccountById(accountId);
                    if (accountVo != null) {
                        return accountId;
                    }
                } catch (NumberFormatException ex) {
                    AccountVo accountVo = resourceAccountCrossoverMapper.getPublicAccountByName(account);
                    if (accountVo != null) {
                        return accountVo.getId();
                    }
                }
            } else if (obj instanceof JSONObject) {
                JSONObject jsonObj = (JSONObject) obj;
                Long accountId = jsonObj.getLong("accountId");
                AccountVo accountVo = resourceAccountCrossoverMapper.getAccountById(accountId);
                if (accountVo != null) {
                    return accountId;
                }
            } else if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                Long accountId = getAccountId(array);
                if (accountId != null) {
                    return accountId;
                }
            }
        }
        return null;
    }

}

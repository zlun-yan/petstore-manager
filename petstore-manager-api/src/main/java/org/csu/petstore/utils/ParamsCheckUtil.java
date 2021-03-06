package org.csu.petstore.utils;

import org.apache.commons.lang3.StringUtils;
import org.csu.petstore.base.BaseResult;
import org.csu.petstore.base.ResponseCode;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamsCheckUtil {

    /**
     *校验API必须参数，如果漏参数将直接返回响应体 BaseResult
     * @param tips 如果出现漏参数，给出的提示语句，如果tips以字符串"params[aaa,bbb,ccc]"的形式传进来，则能定位到具体的参数缺失
     * @param params 传入的必须的参数，可变长参数传递
     * @return
     */
    public static BaseResult<Map<String, Object>> checkNecessaryParams(String tips, Object... params){
        boolean checkRet = true;
        int index = 0;
        List<Integer> lostParamIndexs = new ArrayList<Integer>();
        for(Object param : params ){
            index++;
            if(param == null){
                checkRet = false;
                lostParamIndexs.add(index);
            }
            else if( param instanceof String  && StringUtils.isBlank((String) param)){
                checkRet = false;
                lostParamIndexs.add(index);
            }
        }
        Map<String, Object> m = new HashMap<String, Object>();
        if(checkRet==false){
            if(tips!=null && tips.startsWith("参数不能为空,必传参数[") && tips.endsWith("]")){
                String paramNameStrs = tips.substring(12, tips.length()-1);
                String[] paramNames = paramNameStrs.split(",");
                String lostParams = "";
                for(Integer lostParamIndex : lostParamIndexs){
                    if(paramNames!=null && paramNames.length>=lostParamIndex)
                        lostParams = lostParams+paramNames[lostParamIndex-1]+",";
                }
                if(StringUtils.isNotBlank(lostParams)){
                    lostParams = lostParams.substring(0, lostParams.length()-1);
                    MessageFormat form = new MessageFormat("传参错误，必传参数{0}，缺少参数lostParams[{1}]");
                    tips = form.format(new Object[]{paramNameStrs, lostParams});
                }
            }
            BaseResult<Map<String,Object>> result = BaseResult.getInstance(ResponseCode.PARAMS_EMPTY_901);
            if (StringUtils.isNotBlank(tips)) {
                result.setMsg(tips);
            }
            return result;
        }

        return null;
    }
}

package com.huyan.eurekaclient.mapper;

import com.huyan.eurekaclient.entity.InterfaceUsage;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author by hu_yan on 2018/12/14.
 */
public interface InterfaceUsageMapper {

    @SelectProvider(type = Provider.class, method = "selectUsage")
    List<InterfaceUsage> getUsage(@Param("uid") String uid);

    class Provider {
        public String selectUsage(@Param("uid") String uid) {
            return new SQL() {{
                SELECT("id", "uid", "uri", "response_time", "update_time", "args", "status", "fail_message");
                FROM("interface_usage_statistics");
                if (StringUtils.isNotBlank(uid)) {
                    WHERE("uid=#{uid}");
                }
                ORDER_BY("update_time desc");
            }}.toString();
        }
    }
}

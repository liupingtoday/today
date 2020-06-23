package cn.js.today.domain.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;

/**
 * Simple to Introduction
 *
 * @Description: 系统软件地址信息表
 * @Author: liupingtoday
 * @Since 2020-06-23
 * @UpdateUser: liupingtoday
 * @UpdateDate: 2020-06-23
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
@Entity
@Table(name = "sys_post")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class SystemURL {

        /**
         * 系统编码
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonSerialize(using = ToStringSerializer.class)
        @Column(name = "system_code")
        private Long systemCode;

        /**
         * 系统名称
         */
        @Column(name = "system_name")
        private String systemName;

        /**
         * 机房
         */
        @Column(name = "machine_room")
        private String machineRoom;

        /**
         * 环境：开发环境、测试环境、预览环境、生产环境
         */
        @Column(name = "environment")
        private String environment;

        /**
         * 软件名称
         */
        @Column(name = "software_name")
        private String softwareName;

        /**
         * 软件访问链接地址
         */
        @Column(name = "url")
        private String url;

        /**
         * 备注
         */
        @Column(name = "remark")
        private String remark;

}

package com.healer.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李泽炜
 * @package com.healer.user.domain
 * @time 2021/3/1 11:34
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverLicense {
    @JsonProperty("config_str")
    private ConfigStr configStr;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("nation")
    private String nation;
    @JsonProperty("birth_date")
    private String birthDate;
    @JsonProperty("num")
    private String num;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("vehicle_type")
    private String vehicleType;
    @JsonProperty("issue_date")
    private String issueDate;
    @JsonProperty("success")
    private String success;
    @JsonProperty("name")
    private String name;
    @JsonProperty("addr")
    private String addr;
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("start_date")
    private String startDate;
}

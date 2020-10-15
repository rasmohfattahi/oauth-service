package com.mft.general.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SimplePageResponse<T> {

    @JsonProperty("entityList")
    private List<T> content;

    @JsonProperty("totalRecords")
    private long count;

}

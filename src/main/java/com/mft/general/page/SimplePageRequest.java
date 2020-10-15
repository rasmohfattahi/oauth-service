package com.mft.general.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
public class SimplePageRequest {

	@Min(0)
	@JsonProperty("pageNumber")
	private int page;

	@Min(1)
	@Max(40)
	@JsonProperty("pageSize")
	private int size = 30;

	private String sort = "id";

}

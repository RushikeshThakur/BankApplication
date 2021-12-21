package com.amdocs.bankapplication.helperobject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage {

	private Object data;
	private boolean success;
	private Object message;
	private Object status;
}

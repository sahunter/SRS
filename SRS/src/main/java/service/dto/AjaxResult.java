package service.dto;

import com.google.gson.Gson;

public class AjaxResult {
	
	public AjaxResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public AjaxResult(boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	private boolean success;
	private String message;
	private Object data;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static AjaxResult success(String message){
		return new AjaxResult(true, message);		
	}
	
	public static AjaxResult success(Object data){
		return new AjaxResult(true, null, data);		
	}
	
	public static AjaxResult success(Object data, String message){
		return new AjaxResult(true, message, data);		
	}
	
	public static AjaxResult error(String message){
		return new AjaxResult(false, message);		
	}
	
	public static AjaxResult error(Object data, String message){
		return new AjaxResult(false, message, data);		
	}
	
	@Override
	public String toString() {
		Gson g = new Gson();
		return g.toJson(this);
	}
	
	

}

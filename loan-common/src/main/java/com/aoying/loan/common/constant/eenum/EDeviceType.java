package com.aoying.loan.common.constant.eenum;

/**
 * 设备类型 枚举
 * @author nick
 */
public enum EDeviceType {
    /** Android */
    ANDROID(1, "Android", false),
    /** IOS */
    IOS(2, "IOS", false),
    /** 桌面版H5 */
    PC(3, "桌面版H5", true),
    /** 移动版H5 */
    PHONE(4, "移动版H5", false),
    /** 落地页 */
    LANDING(5, "落地页", false),
    /** 其他 */
    OTHER(10, "其他", true);

	private Integer val;
	private String name;
    /** 是否使用图形验证码 */
    private Boolean picVerfCode;

	EDeviceType(Integer val, String name, Boolean picVerfCode) {
		this.val = val;
		this.name = name;
        this.picVerfCode = picVerfCode;
    }

    /**
     * 是否使用图形验证码
     * @param val
     * @return
     */
    public static Boolean getPicVerfCode(Integer val) {
	    if (val == null) { return true; }
        for (EDeviceType t : EDeviceType.values()) {
	        if (t.getVal().equals(val)) {
	            return t.getPicVerfCode();
            }
        }
	    return true;
    }

	public Integer getVal() {
		return val;
	}

	public String getName() {
		return name;
	}

    public Boolean getPicVerfCode() {
        return picVerfCode;
    }
}
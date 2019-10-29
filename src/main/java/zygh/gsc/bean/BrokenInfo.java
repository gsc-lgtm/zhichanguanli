package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-15 14:42
 */

public class BrokenInfo {
    //故障id
    private Integer brokenId;
    //资产id
    private Integer aId;
    //运维公司id
    private Integer cId;
    //系统名称
    private String aSystem;
    //子系统名称
    private String aSubsystem;
    //ip地址
    private String aIp;
    //运维公司名
    private String cName;
    //资产大类
    private String aCategory;
    //资产小类
    private String aAttribute;
    //故障位置
    private String aLocation;
    //故障掉线持续时间
    private String lastTime;
    //主机状态
    private String hostStatus;
    //工单状态
    private String worksheetStatus;

    public Integer getBrokenId() {
        return brokenId;
    }

    public void setBrokenId(Integer brokenId) {
        this.brokenId = brokenId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getaSystem() {
        return aSystem;
    }

    public void setaSystem(String aSystem) {
        this.aSystem = aSystem == null ? null : aSystem.trim();
    }

    public String getaSubsystem() {
        return aSubsystem;
    }

    public void setaSubsystem(String aSubsystem) {
        this.aSubsystem = aSubsystem == null ? null : aSubsystem.trim();
    }

    public String getaIp() {
        return aIp;
    }

    public void setaIp(String aIp) {
        this.aIp = aIp == null ? null : aIp.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getaCategory() {
        return aCategory;
    }

    public void setaCategory(String aCategory) {
        this.aCategory = aCategory == null ? null : aCategory.trim();
    }

    public String getaAttribute() {
        return aAttribute;
    }

    public void setaAttribute(String aAttribute) {
        this.aAttribute = aAttribute == null ? null : aAttribute.trim();
    }

    public String getaLocation() {
        return aLocation;
    }

    public void setaLocation(String aLocation) {
        this.aLocation = aLocation == null ? null : aLocation.trim();
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime == null ? null : lastTime.trim();
    }

    public String getHostStatus() {
        return hostStatus;
    }

    public void setHostStatus(String hostStatus) {
        this.hostStatus = hostStatus == null ? null : hostStatus.trim();
    }

    public String getWorksheetStatus() {
        return worksheetStatus;
    }

    public void setWorksheetStatus(String worksheetStatus) {
        this.worksheetStatus = worksheetStatus == null ? null : worksheetStatus.trim();
    }
}

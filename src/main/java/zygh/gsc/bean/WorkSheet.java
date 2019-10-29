package zygh.gsc.bean;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-15 14:43
 */

public class WorkSheet {
    //工单id
    private Integer worksheetId;
    //故障Id
    private Integer brokenId;
    //支队ID
    private Integer troopId;
    //系统名称
    private String aSystem;
    //子系统名称
    private String aSubsystem;
    //发现时间
    private String findTime;
    //故障描述
    private String brokenDescribe;
    //报修人
    private String callPerson;
    //支队名称
    private String troopName;
    //区域名称
    private String regionName;
    //故障程度
    private String brokenLevel;
    //故障设施
    private String brokenFacility;
    //附件
    private String enclosure;
    //辅单
    private String supplement;
    //工单状态
    private String worksheetStatus;
    //派单级别
    private String distributeLevel;
    //运维公司
    private String cName;
    //运维小组
    private String cGroup;
    //运维小组负责人
    private String cPerson;
    //故障原因
    private String brokenReason;
    //故障现象
    private String brokenPhenomenon;
    //修复时间
    private String repairedTime;
    //未修复时间
    private String unrepairReason;
    //结案时间
    private String endTime;
    //是否保留
    private String remain;
    //故障位置
    private String aLocation;

    public String getaLocation() {
        return aLocation;
    }

    public void setaLocation(String aLocation) {
        this.aLocation = aLocation;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public Integer getWorksheetId() {
        return worksheetId;
    }

    public void setWorksheetId(Integer worksheetId) {
        this.worksheetId = worksheetId;
    }

    public Integer getBrokenId() {
        return brokenId;
    }

    public void setBrokenId(Integer brokenId) {
        this.brokenId = brokenId;
    }

    public Integer getTroopId() {
        return troopId;
    }

    public void setTroopId(Integer troopId) {
        this.troopId = troopId;
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

    public String getFindTime() {
        return findTime;
    }

    public void setFindTime(String findTime) {
        this.findTime = findTime == null ? null : findTime.trim();
    }

    public String getBrokenDescribe() {
        return brokenDescribe;
    }

    public void setBrokenDescribe(String brokenDescribe) {
        this.brokenDescribe = brokenDescribe == null ? null : brokenDescribe.trim();
    }

    public String getCallPerson() {
        return callPerson;
    }

    public void setCallPerson(String callPerson) {
        this.callPerson = callPerson == null ? null : callPerson.trim();
    }

    public String getTroopName() {
        return troopName;
    }

    public void setTroopName(String troopName) {
        this.troopName = troopName == null ? null : troopName.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getBrokenLevel() {
        return brokenLevel;
    }

    public void setBrokenLevel(String brokenLevel) {
        this.brokenLevel = brokenLevel == null ? null : brokenLevel.trim();
    }

    public String getBrokenFacility() {
        return brokenFacility;
    }

    public void setBrokenFacility(String brokenFacility) {
        this.brokenFacility = brokenFacility == null ? null : brokenFacility.trim();
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement == null ? null : supplement.trim();
    }

    public String getWorksheetStatus() {
        return worksheetStatus;
    }

    public void setWorksheetStatus(String worksheetStatus) {
        this.worksheetStatus = worksheetStatus == null ? null : worksheetStatus.trim();
    }

    public String getDistributeLevel() {
        return distributeLevel;
    }

    public void setDistributeLevel(String distributeLevel) {
        this.distributeLevel = distributeLevel == null ? null : distributeLevel.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcGroup() {
        return cGroup;
    }

    public void setcGroup(String cGroup) {
        this.cGroup = cGroup == null ? null : cGroup.trim();
    }

    public String getcPerson() {
        return cPerson;
    }

    public void setcPerson(String cPerson) {
        this.cPerson = cPerson == null ? null : cPerson.trim();
    }

    public String getBrokenReason() {
        return brokenReason;
    }

    public void setBrokenReason(String brokenReason) {
        this.brokenReason = brokenReason == null ? null : brokenReason.trim();
    }

    public String getBrokenPhenomenon() {
        return brokenPhenomenon;
    }

    public void setBrokenPhenomenon(String brokenPhenomenon) {
        this.brokenPhenomenon = brokenPhenomenon == null ? null : brokenPhenomenon.trim();
    }

    public String getRepairedTime() {
        return repairedTime;
    }

    public void setRepairedTime(String repairedTime) {
        this.repairedTime = repairedTime == null ? null : repairedTime.trim();
    }

    public String getUnrepairReason() {
        return unrepairReason;
    }

    public void setUnrepairReason(String unrepairReason) {
        this.unrepairReason = unrepairReason == null ? null : unrepairReason.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }
}

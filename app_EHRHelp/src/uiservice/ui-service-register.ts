/**
 * UI服务注册中心
 *
 * @export
 * @class UIServiceRegister
 */
export class UIServiceRegister {

    /**
     * 所有UI实体服务Map
     *
     * @protected
     * @type {*}
     * @memberof UIServiceRegister
     */
    protected allUIService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载UI实体服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof UIServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of UIServiceRegister.
     * @memberof UIServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UIServiceRegister
     */
    protected init(): void {
                this.allUIService.set('sallog', () => import('@/uiservice/sallog/sallog-ui-service'));
        this.allUIService.set('trmdepart', () => import('@/uiservice/trmdepart/trmdepart-ui-service'));
        this.allUIService.set('wfusergroupdetail', () => import('@/uiservice/wfuser-group-detail/wfuser-group-detail-ui-service'));
        this.allUIService.set('trmtrainplanterm', () => import('@/uiservice/trmtrainplanterm/trmtrainplanterm-ui-service'));
        this.allUIService.set('salschemeitem', () => import('@/uiservice/salschemeitem/salschemeitem-ui-service'));
        this.allUIService.set('trmlgbcost', () => import('@/uiservice/trmlgbcost/trmlgbcost-ui-service'));
        this.allUIService.set('pcmjxsygzzsq', () => import('@/uiservice/pcmjxsygzzsq/pcmjxsygzzsq-ui-service'));
        this.allUIService.set('pcmrecruitment', () => import('@/uiservice/pcmrecruitment/pcmrecruitment-ui-service'));
        this.allUIService.set('pimcorrectionapply', () => import('@/uiservice/pimcorrectionapply/pimcorrectionapply-ui-service'));
        this.allUIService.set('wfusergroup', () => import('@/uiservice/wfuser-group/wfuser-group-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/ormorg/ormorg-ui-service'));
        this.allUIService.set('pcmnotice', () => import('@/uiservice/pcmnotice/pcmnotice-ui-service'));
        this.allUIService.set('salstdgwgzrate', () => import('@/uiservice/salstdgwgzrate/salstdgwgzrate-ui-service'));
        this.allUIService.set('pcmydmx', () => import('@/uiservice/pcmydmx/pcmydmx-ui-service'));
        this.allUIService.set('pimqualtype', () => import('@/uiservice/pimqualtype/pimqualtype-ui-service'));
        this.allUIService.set('msgaccountdetail', () => import('@/uiservice/msg-account-detail/msg-account-detail-ui-service'));
        this.allUIService.set('pimmajorsetype', () => import('@/uiservice/pimmajorsetype/pimmajorsetype-ui-service'));
        this.allUIService.set('wzd0001', () => import('@/uiservice/wzd0001/wzd0001-ui-service'));
        this.allUIService.set('pimtitle', () => import('@/uiservice/pimtitle/pimtitle-ui-service'));
        this.allUIService.set('parlhmbkhmx', () => import('@/uiservice/parlhmbkhmx/parlhmbkhmx-ui-service'));
        this.allUIService.set('userdictitem', () => import('@/uiservice/user-dict-item/user-dict-item-ui-service'));
        this.allUIService.set('attendencesetup', () => import('@/uiservice/attendencesetup/attendencesetup-ui-service'));
        this.allUIService.set('pcmddsqdmx', () => import('@/uiservice/pcmddsqdmx/pcmddsqdmx-ui-service'));
        this.allUIService.set('pcmschooloffice', () => import('@/uiservice/pcmschooloffice/pcmschooloffice-ui-service'));
        this.allUIService.set('pimtypecontract', () => import('@/uiservice/pimtypecontract/pimtypecontract-ui-service'));
        this.allUIService.set('userdict', () => import('@/uiservice/user-dict/user-dict-ui-service'));
        this.allUIService.set('trmteachercharge', () => import('@/uiservice/trmteachercharge/trmteachercharge-ui-service'));
        this.allUIService.set('salstdzc', () => import('@/uiservice/salstdzc/salstdzc-ui-service'));
        this.allUIService.set('pcmxygzzsq', () => import('@/uiservice/pcmxygzzsq/pcmxygzzsq-ui-service'));
        this.allUIService.set('vacworkday', () => import('@/uiservice/vacworkday/vacworkday-ui-service'));
        this.allUIService.set('attendencetype', () => import('@/uiservice/attendencetype/attendencetype-ui-service'));
        this.allUIService.set('pimoutput', () => import('@/uiservice/pimoutput/pimoutput-ui-service'));
        this.allUIService.set('parjxzgpc', () => import('@/uiservice/parjxzgpc/parjxzgpc-ui-service'));
        this.allUIService.set('vacsystemhistory', () => import('@/uiservice/vacsystemhistory/vacsystemhistory-ui-service'));
        this.allUIService.set('attendancemreportmx', () => import('@/uiservice/attendancemreportmx/attendancemreportmx-ui-service'));
        this.allUIService.set('trmteachertrain', () => import('@/uiservice/trmteachertrain/trmteachertrain-ui-service'));
        this.allUIService.set('parjxkhjcsz', () => import('@/uiservice/parjxkhjcsz/parjxkhjcsz-ui-service'));
        this.allUIService.set('trmtrianperson', () => import('@/uiservice/trmtrianperson/trmtrianperson-ui-service'));
        this.allUIService.set('pimarchivesloanandreturn', () => import('@/uiservice/pimarchivesloanandreturn/pimarchivesloanandreturn-ui-service'));
        this.allUIService.set('pcmzjdyzw', () => import('@/uiservice/pcmzjdyzw/pcmzjdyzw-ui-service'));
        this.allUIService.set('userroledata', () => import('@/uiservice/user-role-data/user-role-data-ui-service'));
        this.allUIService.set('wfassistwork', () => import('@/uiservice/wfassist-work/wfassist-work-ui-service'));
        this.allUIService.set('pcmrcxl', () => import('@/uiservice/pcmrcxl/pcmrcxl-ui-service'));
        this.allUIService.set('pimbyzzjlmx', () => import('@/uiservice/pimbyzzjlmx/pimbyzzjlmx-ui-service'));
        this.allUIService.set('orgsecusertype', () => import('@/uiservice/org-sec-user-type/org-sec-user-type-ui-service'));
        this.allUIService.set('ormbmgwbz', () => import('@/uiservice/ormbmgwbz/ormbmgwbz-ui-service'));
        this.allUIService.set('pimcontract', () => import('@/uiservice/pimcontract/pimcontract-ui-service'));
        this.allUIService.set('saltype', () => import('@/uiservice/saltype/saltype-ui-service'));
        this.allUIService.set('userrole', () => import('@/uiservice/user-role/user-role-ui-service'));
        this.allUIService.set('pcmprofileinitnumber', () => import('@/uiservice/pcmprofileinitnumber/pcmprofileinitnumber-ui-service'));
        this.allUIService.set('pcmworkresume', () => import('@/uiservice/pcmworkresume/pcmworkresume-ui-service'));
        this.allUIService.set('trmtrainactment', () => import('@/uiservice/trmtrainactment/trmtrainactment-ui-service'));
        this.allUIService.set('pimsocialsecurity', () => import('@/uiservice/pimsocialsecurity/pimsocialsecurity-ui-service'));
        this.allUIService.set('wfcustomprocess', () => import('@/uiservice/wfcustom-process/wfcustom-process-ui-service'));
        this.allUIService.set('pimworkhistory', () => import('@/uiservice/pimworkhistory/pimworkhistory-ui-service'));
        this.allUIService.set('ormorgdz', () => import('@/uiservice/ormorgdz/ormorgdz-ui-service'));
        this.allUIService.set('parlhmbmx', () => import('@/uiservice/parlhmbmx/parlhmbmx-ui-service'));
        this.allUIService.set('pimpersonability', () => import('@/uiservice/pimperson-ability/pimperson-ability-ui-service'));
        this.allUIService.set('trminvoice', () => import('@/uiservice/trminvoice/trminvoice-ui-service'));
        this.allUIService.set('ormtitle', () => import('@/uiservice/ormtitle/ormtitle-ui-service'));
        this.allUIService.set('vacleacetype', () => import('@/uiservice/vacleacetype/vacleacetype-ui-service'));
        this.allUIService.set('salstdgw', () => import('@/uiservice/salstdgw/salstdgw-ui-service'));
        this.allUIService.set('pimarchiveschange', () => import('@/uiservice/pimarchiveschange/pimarchiveschange-ui-service'));
        this.allUIService.set('pcmdetail', () => import('@/uiservice/pcmdetail/pcmdetail-ui-service'));
        this.allUIService.set('pimexpaccount', () => import('@/uiservice/pimexpaccount/pimexpaccount-ui-service'));
        this.allUIService.set('pcmsyqgz', () => import('@/uiservice/pcmsyqgz/pcmsyqgz-ui-service'));
        this.allUIService.set('vacholiday', () => import('@/uiservice/vacholiday/vacholiday-ui-service'));
        this.allUIService.set('salsalarydetail', () => import('@/uiservice/salsalarydetail/salsalarydetail-ui-service'));
        this.allUIService.set('parjxmtfk', () => import('@/uiservice/parjxmtfk/parjxmtfk-ui-service'));
        this.allUIService.set('attendancemreport', () => import('@/uiservice/attendancemreport/attendancemreport-ui-service'));
        this.allUIService.set('trmtrainactapply', () => import('@/uiservice/trmtrainactapply/trmtrainactapply-ui-service'));
        this.allUIService.set('pcmgxml', () => import('@/uiservice/pcmgxml/pcmgxml-ui-service'));
        this.allUIService.set('userroledefieldes', () => import('@/uiservice/user-role-defieldes/user-role-defieldes-ui-service'));
        this.allUIService.set('pcmtxbz', () => import('@/uiservice/pcmtxbz/pcmtxbz-ui-service'));
        this.allUIService.set('ormxmxqhz', () => import('@/uiservice/ormxmxqhz/ormxmxqhz-ui-service'));
        this.allUIService.set('pimqualmajor', () => import('@/uiservice/pimqualmajor/pimqualmajor-ui-service'));
        this.allUIService.set('pcmxygzzkhjgjl', () => import('@/uiservice/pcmxygzzkhjgjl/pcmxygzzkhjgjl-ui-service'));
        this.allUIService.set('parjxkhmbmx', () => import('@/uiservice/parjxkhmbmx/parjxkhmbmx-ui-service'));
        this.allUIService.set('vacleavemanage', () => import('@/uiservice/vacleavemanage/vacleavemanage-ui-service'));
        this.allUIService.set('pcmlog', () => import('@/uiservice/pcmlog/pcmlog-ui-service'));
        this.allUIService.set('wfstepinst', () => import('@/uiservice/wfstep-inst/wfstep-inst-ui-service'));
        this.allUIService.set('wxaccesstoken', () => import('@/uiservice/wxaccess-token/wxaccess-token-ui-service'));
        this.allUIService.set('pimvacation', () => import('@/uiservice/pimvacation/pimvacation-ui-service'));
        this.allUIService.set('pimexitandentry', () => import('@/uiservice/pimexitandentry/pimexitandentry-ui-service'));
        this.allUIService.set('trmplanformu', () => import('@/uiservice/trmplanformu/trmplanformu-ui-service'));
        this.allUIService.set('loginlog', () => import('@/uiservice/login-log/login-log-ui-service'));
        this.allUIService.set('trmtraindemand', () => import('@/uiservice/trmtraindemand/trmtraindemand-ui-service'));
        this.allUIService.set('pimpersonchange', () => import('@/uiservice/pimpersonchange/pimpersonchange-ui-service'));
        this.allUIService.set('pcmeducationexperience', () => import('@/uiservice/pcmeducation-experience/pcmeducation-experience-ui-service'));
        this.allUIService.set('usergroup', () => import('@/uiservice/user-group/user-group-ui-service'));
        this.allUIService.set('trmtrainplan', () => import('@/uiservice/trmtrainplan/trmtrainplan-ui-service'));
        this.allUIService.set('userroledetail', () => import('@/uiservice/user-role-detail/user-role-detail-ui-service'));
        this.allUIService.set('orguser', () => import('@/uiservice/org-user/org-user-ui-service'));
        this.allUIService.set('pimachievements', () => import('@/uiservice/pimachievements/pimachievements-ui-service'));
        this.allUIService.set('pcmbdsqd', () => import('@/uiservice/pcmbdsqd/pcmbdsqd-ui-service'));
        this.allUIService.set('pcmxkml', () => import('@/uiservice/pcmxkml/pcmxkml-ui-service'));
        this.allUIService.set('pimlanguageability', () => import('@/uiservice/pimlanguageability/pimlanguageability-ui-service'));
        this.allUIService.set('wxorgsector', () => import('@/uiservice/wxorg-sector/wxorg-sector-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pimperson/pimperson-ui-service'));
        this.allUIService.set('userroledefield', () => import('@/uiservice/user-role-defield/user-role-defield-ui-service'));
        this.allUIService.set('userdgtheme', () => import('@/uiservice/user-dgtheme/user-dgtheme-ui-service'));
        this.allUIService.set('msgsendqueue', () => import('@/uiservice/msg-send-queue/msg-send-queue-ui-service'));
        this.allUIService.set('trmtraffic', () => import('@/uiservice/trmtraffic/trmtraffic-ui-service'));
        this.allUIService.set('wfuser', () => import('@/uiservice/wfuser/wfuser-ui-service'));
        this.allUIService.set('userroledatadetail', () => import('@/uiservice/user-role-data-detail/user-role-data-detail-ui-service'));
        this.allUIService.set('pimexaminationresults', () => import('@/uiservice/pimexaminationresults/pimexaminationresults-ui-service'));
        this.allUIService.set('pimarchives', () => import('@/uiservice/pimarchives/pimarchives-ui-service'));
        this.allUIService.set('vacleavesystemdetail', () => import('@/uiservice/vacleavesystemdetail/vacleavesystemdetail-ui-service'));
        this.allUIService.set('parjxzgpcmx', () => import('@/uiservice/parjxzgpcmx/parjxzgpcmx-ui-service'));
        this.allUIService.set('ormrank', () => import('@/uiservice/ormrank/ormrank-ui-service'));
        this.allUIService.set('vacleavedetail', () => import('@/uiservice/vacleavedetail/vacleavedetail-ui-service'));
        this.allUIService.set('trmtraindata', () => import('@/uiservice/trmtraindata/trmtraindata-ui-service'));
        this.allUIService.set('pcmgbhmc', () => import('@/uiservice/pcmgbhmc/pcmgbhmc-ui-service'));
        this.allUIService.set('parjgbmpjbz', () => import('@/uiservice/parjgbmpjbz/parjgbmpjbz-ui-service'));
        this.allUIService.set('wfuserassist', () => import('@/uiservice/wfuser-assist/wfuser-assist-ui-service'));
        this.allUIService.set('parndlhmbkh', () => import('@/uiservice/parndlhmbkh/parndlhmbkh-ui-service'));
        this.allUIService.set('usergroupdetail', () => import('@/uiservice/user-group-detail/user-group-detail-ui-service'));
        this.allUIService.set('userdictcat', () => import('@/uiservice/user-dict-cat/user-dict-cat-ui-service'));
        this.allUIService.set('pcmydjzmx', () => import('@/uiservice/pcmydjzmx/pcmydjzmx-ui-service'));
        this.allUIService.set('testresult', () => import('@/uiservice/test-result/test-result-ui-service'));
        this.allUIService.set('ormorginfo', () => import('@/uiservice/ormorginfo/ormorginfo-ui-service'));
        this.allUIService.set('vacinitnxj', () => import('@/uiservice/vacinitnxj/vacinitnxj-ui-service'));
        this.allUIService.set('salstdzx', () => import('@/uiservice/salstdzx/salstdzx-ui-service'));
        this.allUIService.set('pimworkflow', () => import('@/uiservice/pimworkflow/pimworkflow-ui-service'));
        this.allUIService.set('salitem', () => import('@/uiservice/salitem/salitem-ui-service'));
        this.allUIService.set('trmagencyrecord', () => import('@/uiservice/trmagencyrecord/trmagencyrecord-ui-service'));
        this.allUIService.set('ormbmkqdz', () => import('@/uiservice/ormbmkqdz/ormbmkqdz-ui-service'));
        this.allUIService.set('sgqmgr', () => import('@/uiservice/sgqmgr/sgqmgr-ui-service'));
        this.allUIService.set('trmdepartneeds', () => import('@/uiservice/trmdepartneeds/trmdepartneeds-ui-service'));
        this.allUIService.set('salstdxmgz', () => import('@/uiservice/salstdxmgz/salstdxmgz-ui-service'));
        this.allUIService.set('pcmcsrcmspj', () => import('@/uiservice/pcmcsrcmspj/pcmcsrcmspj-ui-service'));
        this.allUIService.set('parkhzcmx', () => import('@/uiservice/parkhzcmx/parkhzcmx-ui-service'));
        this.allUIService.set('salstdzyzg', () => import('@/uiservice/salstdzyzg/salstdzyzg-ui-service'));
        this.allUIService.set('pimarchivesrecord', () => import('@/uiservice/pimarchivesrecord/pimarchivesrecord-ui-service'));
        this.allUIService.set('pcmreason', () => import('@/uiservice/pcmreason/pcmreason-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/ormorgsector/ormorgsector-ui-service'));
        this.allUIService.set('trmdemdeftion', () => import('@/uiservice/trmdemdeftion/trmdemdeftion-ui-service'));
        this.allUIService.set('parjxjg', () => import('@/uiservice/parjxjg/parjxjg-ui-service'));
        this.allUIService.set('salsubject', () => import('@/uiservice/salsubject/salsubject-ui-service'));
        this.allUIService.set('pcmydlzmx', () => import('@/uiservice/pcmydlzmx/pcmydlzmx-ui-service'));
        this.allUIService.set('pimtitlecatalogue', () => import('@/uiservice/pimtitlecatalogue/pimtitlecatalogue-ui-service'));
        this.allUIService.set('parxmbpjbz', () => import('@/uiservice/parxmbpjbz/parxmbpjbz-ui-service'));
        this.allUIService.set('vacleavesystem', () => import('@/uiservice/vacleavesystem/vacleavesystem-ui-service'));
        this.allUIService.set('pcmypzjkxx', () => import('@/uiservice/pcmypzjkxx/pcmypzjkxx-ui-service'));
        this.allUIService.set('salstdgl', () => import('@/uiservice/salstdgl/salstdgl-ui-service'));
        this.allUIService.set('pimarmycadres', () => import('@/uiservice/pimarmycadres/pimarmycadres-ui-service'));
        this.allUIService.set('pimbyygzzsq', () => import('@/uiservice/pimbyygzzsq/pimbyygzzsq-ui-service'));
        this.allUIService.set('trmtrainteacher', () => import('@/uiservice/trmtrainteacher/trmtrainteacher-ui-service'));
        this.allUIService.set('pcmjxsbdjl', () => import('@/uiservice/pcmjxsbdjl/pcmjxsbdjl-ui-service'));
        this.allUIService.set('trmtrainbuapply', () => import('@/uiservice/trmtrainbuapply/trmtrainbuapply-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('querymodel', () => import('@/uiservice/query-model/query-model-ui-service'));
        this.allUIService.set('trmtrainagency', () => import('@/uiservice/trmtrainagency/trmtrainagency-ui-service'));
        this.allUIService.set('pimresearchfindings', () => import('@/uiservice/pimresearchfindings/pimresearchfindings-ui-service'));
        this.allUIService.set('msgsendqueuehis', () => import('@/uiservice/msg-send-queue-his/msg-send-queue-his-ui-service'));
        this.allUIService.set('salscheme', () => import('@/uiservice/salscheme/salscheme-ui-service'));
        this.allUIService.set('pimlwgz', () => import('@/uiservice/pimlwgz/pimlwgz-ui-service'));
        this.allUIService.set('pimcontracttype', () => import('@/uiservice/pimcontracttype/pimcontracttype-ui-service'));
        this.allUIService.set('salsalary', () => import('@/uiservice/salsalary/salsalary-ui-service'));
        this.allUIService.set('pcmnorecyclinglibrary', () => import('@/uiservice/pcmnorecycling-library/pcmnorecycling-library-ui-service'));
        this.allUIService.set('attendancedate', () => import('@/uiservice/attendancedate/attendancedate-ui-service'));
        this.allUIService.set('nationmgr', () => import('@/uiservice/nation-mgr/nation-mgr-ui-service'));
        this.allUIService.set('ormxmrypzxq', () => import('@/uiservice/ormxmrypzxq/ormxmrypzxq-ui-service'));
        this.allUIService.set('pcmydjpmx', () => import('@/uiservice/pcmydjpmx/pcmydjpmx-ui-service'));
        this.allUIService.set('pimdistirbution', () => import('@/uiservice/pimdistirbution/pimdistirbution-ui-service'));
        this.allUIService.set('pimlabourcampany', () => import('@/uiservice/pimlabourcampany/pimlabourcampany-ui-service'));
        this.allUIService.set('pcmydjdmx', () => import('@/uiservice/pcmydjdmx/pcmydjdmx-ui-service'));
        this.allUIService.set('tdzwxx', () => import('@/uiservice/tdzwxx/tdzwxx-ui-service'));
        this.allUIService.set('wfinstance', () => import('@/uiservice/wfinstance/wfinstance-ui-service'));
        this.allUIService.set('contractsignorg', () => import('@/uiservice/contract-sign-org/contract-sign-org-ui-service'));
        this.allUIService.set('parjxkhmb', () => import('@/uiservice/parjxkhmb/parjxkhmb-ui-service'));
        this.allUIService.set('salpersonstd', () => import('@/uiservice/salpersonstd/salpersonstd-ui-service'));
        this.allUIService.set('trmtraindemandsum', () => import('@/uiservice/trmtraindemandsum/trmtraindemandsum-ui-service'));
        this.allUIService.set('salsalarybill', () => import('@/uiservice/salsalarybill/salsalarybill-ui-service'));
        this.allUIService.set('parznbmmx', () => import('@/uiservice/parznbmmx/parznbmmx-ui-service'));
        this.allUIService.set('trmemployretion', () => import('@/uiservice/trmemployretion/trmemployretion-ui-service'));
        this.allUIService.set('parjxndkhjg', () => import('@/uiservice/parjxndkhjg/parjxndkhjg-ui-service'));
        this.allUIService.set('wfworklist', () => import('@/uiservice/wfwork-list/wfwork-list-ui-service'));
        this.allUIService.set('trmstaff', () => import('@/uiservice/trmstaff/trmstaff-ui-service'));
        this.allUIService.set('ormxmbmx', () => import('@/uiservice/ormxmbmx/ormxmbmx-ui-service'));
        this.allUIService.set('parldkhqz', () => import('@/uiservice/parldkhqz/parldkhqz-ui-service'));
        this.allUIService.set('questions', () => import('@/uiservice/questions/questions-ui-service'));
        this.allUIService.set('salruledetail', () => import('@/uiservice/salruledetail/salruledetail-ui-service'));
        this.allUIService.set('orgsecuser', () => import('@/uiservice/org-sec-user/org-sec-user-ui-service'));
        this.allUIService.set('salpersonstddetail', () => import('@/uiservice/salpersonstddetail/salpersonstddetail-ui-service'));
        this.allUIService.set('trmstay', () => import('@/uiservice/trmstay/trmstay-ui-service'));
        this.allUIService.set('trmcoursesystem', () => import('@/uiservice/trmcoursesystem/trmcoursesystem-ui-service'));
        this.allUIService.set('attensummary', () => import('@/uiservice/attensummary/attensummary-ui-service'));
        this.allUIService.set('salrule', () => import('@/uiservice/salrule/salrule-ui-service'));
        this.allUIService.set('ormxmrlcb', () => import('@/uiservice/ormxmrlcb/ormxmrlcb-ui-service'));
        this.allUIService.set('wfuiwizard', () => import('@/uiservice/wfuiwizard/wfuiwizard-ui-service'));
        this.allUIService.set('personstatemgr', () => import('@/uiservice/person-state-mgr/person-state-mgr-ui-service'));
        this.allUIService.set('ormpostdetails', () => import('@/uiservice/ormpost-details/ormpost-details-ui-service'));
        this.allUIService.set('wfreminder', () => import('@/uiservice/wfreminder/wfreminder-ui-service'));
        this.allUIService.set('pimstafftype', () => import('@/uiservice/pimstafftype/pimstafftype-ui-service'));
        this.allUIService.set('pcmsgqmgr', () => import('@/uiservice/pcmsgq-mgr/pcmsgq-mgr-ui-service'));
        this.allUIService.set('salitemsub', () => import('@/uiservice/salitemsub/salitemsub-ui-service'));
        this.allUIService.set('wfusercandidate', () => import('@/uiservice/wfuser-candidate/wfuser-candidate-ui-service'));
        this.allUIService.set('wftmpstepactor', () => import('@/uiservice/wftmp-step-actor/wftmp-step-actor-ui-service'));
        this.allUIService.set('pimgwtype', () => import('@/uiservice/pimgwtype/pimgwtype-ui-service'));
        this.allUIService.set('ormpostlib', () => import('@/uiservice/ormpost-lib/ormpost-lib-ui-service'));
        this.allUIService.set('archivescenter', () => import('@/uiservice/archivescenter/archivescenter-ui-service'));
        this.allUIService.set('userroledatas', () => import('@/uiservice/user-role-datas/user-role-datas-ui-service'));
        this.allUIService.set('parjxbzgl', () => import('@/uiservice/parjxbzgl/parjxbzgl-ui-service'));
        this.allUIService.set('vacusenxjmx', () => import('@/uiservice/vacusenxjmx/vacusenxjmx-ui-service'));
        this.allUIService.set('vacsynjcx', () => import('@/uiservice/vacsynjcx/vacsynjcx-ui-service'));
        this.allUIService.set('pcmzpmegl', () => import('@/uiservice/pcmzpmegl/pcmzpmegl-ui-service'));
        this.allUIService.set('attendancesummarymx', () => import('@/uiservice/attendancesummarymx/attendancesummarymx-ui-service'));
        this.allUIService.set('trmhmatser', () => import('@/uiservice/trmhmatser/trmhmatser-ui-service'));
        this.allUIService.set('userroleres', () => import('@/uiservice/user-role-res/user-role-res-ui-service'));
        this.allUIService.set('userobject', () => import('@/uiservice/user-object/user-object-ui-service'));
        this.allUIService.set('appcenter', () => import('@/uiservice/app-center/app-center-ui-service'));
        this.allUIService.set('pcmtxfpsq', () => import('@/uiservice/pcmtxfpsq/pcmtxfpsq-ui-service'));
        this.allUIService.set('ormzwdqgz', () => import('@/uiservice/ormzwdqgz/ormzwdqgz-ui-service'));
        this.allUIService.set('msgaccount', () => import('@/uiservice/msg-account/msg-account-ui-service'));
        this.allUIService.set('pcmyddgmx', () => import('@/uiservice/pcmyddgmx/pcmyddgmx-ui-service'));
        this.allUIService.set('ormxmbq', () => import('@/uiservice/ormxmbq/ormxmbq-ui-service'));
        this.allUIService.set('wfsystemuser', () => import('@/uiservice/wfsystem-user/wfsystem-user-ui-service'));
        this.allUIService.set('attendancerecordtemp', () => import('@/uiservice/attendancerecordtemp/attendancerecordtemp-ui-service'));
        this.allUIService.set('pcmgxxktemp', () => import('@/uiservice/pcmgxxktemp/pcmgxxktemp-ui-service'));
        this.allUIService.set('pcmrzgl', () => import('@/uiservice/pcmrzgl/pcmrzgl-ui-service'));
        this.allUIService.set('trmtrainfillin', () => import('@/uiservice/trmtrainfillin/trmtrainfillin-ui-service'));
        this.allUIService.set('user', () => import('@/uiservice/user/user-ui-service'));
        this.allUIService.set('salstdxmgzrate', () => import('@/uiservice/salstdxmgzrate/salstdxmgzrate-ui-service'));
        this.allUIService.set('vacdayoff', () => import('@/uiservice/vacdayoff/vacdayoff-ui-service'));
        this.allUIService.set('org', () => import('@/uiservice/org/org-ui-service'));
        this.allUIService.set('trmstaffnodes', () => import('@/uiservice/trmstaffnodes/trmstaffnodes-ui-service'));
        this.allUIService.set('wfaction', () => import('@/uiservice/wfaction/wfaction-ui-service'));
        this.allUIService.set('pcmawardswons', () => import('@/uiservice/pcmawardswons/pcmawardswons-ui-service'));
        this.allUIService.set('trmcouarrange', () => import('@/uiservice/trmcouarrange/trmcouarrange-ui-service'));
        this.allUIService.set('pimrewardpunishment', () => import('@/uiservice/pimrewardpunishment/pimrewardpunishment-ui-service'));
        this.allUIService.set('salstdzj', () => import('@/uiservice/salstdzj/salstdzj-ui-service'));
        this.allUIService.set('orgtype', () => import('@/uiservice/org-type/org-type-ui-service'));
        this.allUIService.set('attendancerecord', () => import('@/uiservice/attendancerecord/attendancerecord-ui-service'));
        this.allUIService.set('pimpatent', () => import('@/uiservice/pimpatent/pimpatent-ui-service'));
        this.allUIService.set('trmtrainaddress', () => import('@/uiservice/trmtrainaddress/trmtrainaddress-ui-service'));
        this.allUIService.set('archivesmanage', () => import('@/uiservice/archivesmanage/archivesmanage-ui-service'));
        this.allUIService.set('pcmprofile', () => import('@/uiservice/pcmprofile/pcmprofile-ui-service'));
        this.allUIService.set('trmtrainoutapply', () => import('@/uiservice/trmtrainoutapply/trmtrainoutapply-ui-service'));
        this.allUIService.set('archivalcatalogue', () => import('@/uiservice/archivalcatalogue/archivalcatalogue-ui-service'));
        this.allUIService.set('orgunitcat', () => import('@/uiservice/org-unit-cat/org-unit-cat-ui-service'));
        this.allUIService.set('parjxqdsz', () => import('@/uiservice/parjxqdsz/parjxqdsz-ui-service'));
        this.allUIService.set('vacsituationdetail', () => import('@/uiservice/vacsituationdetail/vacsituationdetail-ui-service'));
        this.allUIService.set('wfstep', () => import('@/uiservice/wfstep/wfstep-ui-service'));
        this.allUIService.set('trmtraincourse', () => import('@/uiservice/trmtraincourse/trmtraincourse-ui-service'));
        this.allUIService.set('dataentity', () => import('@/uiservice/data-entity/data-entity-ui-service'));
        this.allUIService.set('parkhfa', () => import('@/uiservice/parkhfa/parkhfa-ui-service'));
        this.allUIService.set('wxaccount', () => import('@/uiservice/wxaccount/wxaccount-ui-service'));
        this.allUIService.set('attendenceormorgsector', () => import('@/uiservice/attendenceormorgsector/attendenceormorgsector-ui-service'));
        this.allUIService.set('wfappsetting', () => import('@/uiservice/wfapp-setting/wfapp-setting-ui-service'));
        this.allUIService.set('trmdutycadres', () => import('@/uiservice/trmdutycadres/trmdutycadres-ui-service'));
        this.allUIService.set('vacoveralltion', () => import('@/uiservice/vacoveralltion/vacoveralltion-ui-service'));
        this.allUIService.set('partzgg', () => import('@/uiservice/partzgg/partzgg-ui-service'));
        this.allUIService.set('pcmydntmx', () => import('@/uiservice/pcmydntmx/pcmydntmx-ui-service'));
        this.allUIService.set('trmgradecadres', () => import('@/uiservice/trmgradecadres/trmgradecadres-ui-service'));
        this.allUIService.set('trmlgbdetail', () => import('@/uiservice/trmlgbdetail/trmlgbdetail-ui-service'));
        this.allUIService.set('ormrelation', () => import('@/uiservice/ormrelation/ormrelation-ui-service'));
        this.allUIService.set('trmtrainfacies', () => import('@/uiservice/trmtrainfacies/trmtrainfacies-ui-service'));
        this.allUIService.set('ormsignorg', () => import('@/uiservice/orm-sign-org/orm-sign-org-ui-service'));
        this.allUIService.set('pcmydgzmx', () => import('@/uiservice/pcmydgzmx/pcmydgzmx-ui-service'));
        this.allUIService.set('attendancesettings', () => import('@/uiservice/attendancesettings/attendancesettings-ui-service'));
        this.allUIService.set('salstddszn', () => import('@/uiservice/salstddszn/salstddszn-ui-service'));
        this.allUIService.set('ormdepestman', () => import('@/uiservice/ormdep-est-man/ormdep-est-man-ui-service'));
        this.allUIService.set('ormxmsfhz', () => import('@/uiservice/ormxmsfhz/ormxmsfhz-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/ormduty/ormduty-ui-service'));
        this.allUIService.set('pcmmspjxx', () => import('@/uiservice/pcmmspjxx/pcmmspjxx-ui-service'));
        this.allUIService.set('wfdynamicuser', () => import('@/uiservice/wfdynamic-user/wfdynamic-user-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('daterule', () => import('@/uiservice/date-rule/date-rule-ui-service'));
        this.allUIService.set('ormqybzwh', () => import('@/uiservice/ormqybzwh/ormqybzwh-ui-service'));
        this.allUIService.set('vacholidayrules', () => import('@/uiservice/vacholidayrules/vacholidayrules-ui-service'));
        this.allUIService.set('wxmessage', () => import('@/uiservice/wxmessage/wxmessage-ui-service'));
        this.allUIService.set('pimworkflowref', () => import('@/uiservice/pimworkflow-ref/pimworkflow-ref-ui-service'));
        this.allUIService.set('parjxkhxhz', () => import('@/uiservice/parjxkhxhz/parjxkhxhz-ui-service'));
        this.allUIService.set('pcmxygzzjlmx', () => import('@/uiservice/pcmxygzzjlmx/pcmxygzzjlmx-ui-service'));
        this.allUIService.set('wfworkflow', () => import('@/uiservice/wfworkflow/wfworkflow-ui-service'));
        this.allUIService.set('wfqj', () => import('@/uiservice/wfqj/wfqj-ui-service'));
        this.allUIService.set('pcmjxszzkhjgjl', () => import('@/uiservice/pcmjxszzkhjgjl/pcmjxszzkhjgjl-ui-service'));
        this.allUIService.set('salsource', () => import('@/uiservice/salsource/salsource-ui-service'));
        this.allUIService.set('userroledataaction', () => import('@/uiservice/user-role-data-action/user-role-data-action-ui-service'));
        this.allUIService.set('pimeducation', () => import('@/uiservice/pimeducation/pimeducation-ui-service'));
        this.allUIService.set('ormqygl', () => import('@/uiservice/ormqygl/ormqygl-ui-service'));
        this.allUIService.set('pcmjxsygzzsqmx', () => import('@/uiservice/pcmjxsygzzsqmx/pcmjxsygzzsqmx-ui-service'));
        this.allUIService.set('wfstepactor', () => import('@/uiservice/wfstep-actor/wfstep-actor-ui-service'));
        this.allUIService.set('pimprovince', () => import('@/uiservice/pimprovince/pimprovince-ui-service'));
        this.allUIService.set('pcmzsgl', () => import('@/uiservice/pcmzsgl/pcmzsgl-ui-service'));
        this.allUIService.set('orgsector', () => import('@/uiservice/org-sector/org-sector-ui-service'));
        this.allUIService.set('wxentapp', () => import('@/uiservice/wxent-app/wxent-app-ui-service'));
        this.allUIService.set('wfactor', () => import('@/uiservice/wfactor/wfactor-ui-service'));
        this.allUIService.set('wfiaaction', () => import('@/uiservice/wfiaaction/wfiaaction-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/ormpost/ormpost-ui-service'));
        this.allUIService.set('salplan', () => import('@/uiservice/salplan/salplan-ui-service'));
        this.allUIService.set('pcmzpmeglmx', () => import('@/uiservice/pcmzpmeglmx/pcmzpmeglmx-ui-service'));
        this.allUIService.set('parjxbzglmx', () => import('@/uiservice/parjxbzglmx/parjxbzglmx-ui-service'));
        this.allUIService.set('salstdgwgz', () => import('@/uiservice/salstdgwgz/salstdgwgz-ui-service'));
        this.allUIService.set('pimpersonabilitydetail', () => import('@/uiservice/pimperson-ability-detail/pimperson-ability-detail-ui-service'));
        this.allUIService.set('ormxmgl', () => import('@/uiservice/ormxmgl/ormxmgl-ui-service'));
        this.allUIService.set('attenmembwes', () => import('@/uiservice/attenmembwes/attenmembwes-ui-service'));
        this.allUIService.set('ormerporg', () => import('@/uiservice/ormerporg/ormerporg-ui-service'));
        this.allUIService.set('loginaccount', () => import('@/uiservice/login-account/login-account-ui-service'));
        this.allUIService.set('parbmfzjyx', () => import('@/uiservice/parbmfzjyx/parbmfzjyx-ui-service'));
        this.allUIService.set('orguserlevel', () => import('@/uiservice/org-user-level/org-user-level-ui-service'));
        this.allUIService.set('pcmddsqd', () => import('@/uiservice/pcmddsqd/pcmddsqd-ui-service'));
        this.allUIService.set('pcmjxsgz', () => import('@/uiservice/pcmjxsgz/pcmjxsgz-ui-service'));
        this.allUIService.set('vacsituation', () => import('@/uiservice/vacsituation/vacsituation-ui-service'));
        this.allUIService.set('pcmbdsqdmx', () => import('@/uiservice/pcmbdsqdmx/pcmbdsqdmx-ui-service'));
        this.allUIService.set('wxmedia', () => import('@/uiservice/wxmedia/wxmedia-ui-service'));
        this.allUIService.set('pcmjxsygzzjlmx', () => import('@/uiservice/pcmjxsygzzjlmx/pcmjxsygzzjlmx-ui-service'));
        this.allUIService.set('vacsystemapplication', () => import('@/uiservice/vacsystemapplication/vacsystemapplication-ui-service'));
        this.allUIService.set('trmzzobm', () => import('@/uiservice/trmzzobm/trmzzobm-ui-service'));
        this.allUIService.set('pcmydbxmx', () => import('@/uiservice/pcmydbxmx/pcmydbxmx-ui-service'));
        this.allUIService.set('pimpaper', () => import('@/uiservice/pimpaper/pimpaper-ui-service'));
        this.allUIService.set('attendrecorddetail', () => import('@/uiservice/attend-record-detail/attend-record-detail-ui-service'));
        this.allUIService.set('unires', () => import('@/uiservice/uni-res/uni-res-ui-service'));
        this.allUIService.set('pcmxygzzjgwh', () => import('@/uiservice/pcmxygzzjgwh/pcmxygzzjgwh-ui-service'));
        this.allUIService.set('salparam', () => import('@/uiservice/salparam/salparam-ui-service'));
        this.allUIService.set('parjxlhmb', () => import('@/uiservice/parjxlhmb/parjxlhmb-ui-service'));
        this.allUIService.set('pcmxygzzsqmx', () => import('@/uiservice/pcmxygzzsqmx/pcmxygzzsqmx-ui-service'));
        this.allUIService.set('wfversion', () => import('@/uiservice/wfversion/wfversion-ui-service'));
        this.allUIService.set('pimvocationalcatalog', () => import('@/uiservice/pimvocationalcatalog/pimvocationalcatalog-ui-service'));
        this.allUIService.set('pcmydtxmx', () => import('@/uiservice/pcmydtxmx/pcmydtxmx-ui-service'));
        this.allUIService.set('pcmpracticeexperience', () => import('@/uiservice/pcmpracticeexperience/pcmpracticeexperience-ui-service'));
        this.allUIService.set('msgtemplate', () => import('@/uiservice/msg-template/msg-template-ui-service'));
        this.allUIService.set('parfzsmx', () => import('@/uiservice/parfzsmx/parfzsmx-ui-service'));
        this.allUIService.set('pimcity', () => import('@/uiservice/pimcity/pimcity-ui-service'));
        this.allUIService.set('userroletype', () => import('@/uiservice/user-role-type/user-role-type-ui-service'));
        this.allUIService.set('pimvocational', () => import('@/uiservice/pimvocational/pimvocational-ui-service'));
        this.allUIService.set('pimfaminfo', () => import('@/uiservice/pimfaminfo/pimfaminfo-ui-service'));
        this.allUIService.set('pimenclosure', () => import('@/uiservice/pimenclosure/pimenclosure-ui-service'));
        this.allUIService.set('trmtrainresment', () => import('@/uiservice/trmtrainresment/trmtrainresment-ui-service'));
    }

    /**
     * 加载服务实体
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof UIServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allUIService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof UIServiceRegister
     */
    public async getService(name: string): Promise<any> {
        if (this.serviceCache.has(name)) {
            return this.serviceCache.get(name);
        }
        const entityService: any = await this.loadService(name);
        if (entityService && entityService.default) {
            const instance: any = new entityService.default();
            this.serviceCache.set(name, instance);
            return instance;
        }
    }

}
export const uiServiceRegister: UIServiceRegister = new UIServiceRegister();
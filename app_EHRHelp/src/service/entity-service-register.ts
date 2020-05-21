/**
 * 实体数据服务注册中心
 *
 * @export
 * @class EntityServiceRegister
 */
export class EntityServiceRegister {

    /**
     * 所有实体数据服务Map
     *
     * @protected
     * @type {*}
     * @memberof EntityServiceRegister
     */
    protected allEntityService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载实体数据服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof EntityServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of EntityServiceRegister.
     * @memberof EntityServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof EntityServiceRegister
     */
    protected init(): void {
                this.allEntityService.set('sallog', () => import('@/service/sallog/sallog-service'));
        this.allEntityService.set('trmdepart', () => import('@/service/trmdepart/trmdepart-service'));
        this.allEntityService.set('wfusergroupdetail', () => import('@/service/wfuser-group-detail/wfuser-group-detail-service'));
        this.allEntityService.set('trmtrainplanterm', () => import('@/service/trmtrainplanterm/trmtrainplanterm-service'));
        this.allEntityService.set('salschemeitem', () => import('@/service/salschemeitem/salschemeitem-service'));
        this.allEntityService.set('trmlgbcost', () => import('@/service/trmlgbcost/trmlgbcost-service'));
        this.allEntityService.set('pcmjxsygzzsq', () => import('@/service/pcmjxsygzzsq/pcmjxsygzzsq-service'));
        this.allEntityService.set('pcmrecruitment', () => import('@/service/pcmrecruitment/pcmrecruitment-service'));
        this.allEntityService.set('pimcorrectionapply', () => import('@/service/pimcorrectionapply/pimcorrectionapply-service'));
        this.allEntityService.set('wfusergroup', () => import('@/service/wfuser-group/wfuser-group-service'));
        this.allEntityService.set('ormorg', () => import('@/service/ormorg/ormorg-service'));
        this.allEntityService.set('pcmnotice', () => import('@/service/pcmnotice/pcmnotice-service'));
        this.allEntityService.set('salstdgwgzrate', () => import('@/service/salstdgwgzrate/salstdgwgzrate-service'));
        this.allEntityService.set('pcmydmx', () => import('@/service/pcmydmx/pcmydmx-service'));
        this.allEntityService.set('pimqualtype', () => import('@/service/pimqualtype/pimqualtype-service'));
        this.allEntityService.set('msgaccountdetail', () => import('@/service/msg-account-detail/msg-account-detail-service'));
        this.allEntityService.set('pimmajorsetype', () => import('@/service/pimmajorsetype/pimmajorsetype-service'));
        this.allEntityService.set('wzd0001', () => import('@/service/wzd0001/wzd0001-service'));
        this.allEntityService.set('pimtitle', () => import('@/service/pimtitle/pimtitle-service'));
        this.allEntityService.set('parlhmbkhmx', () => import('@/service/parlhmbkhmx/parlhmbkhmx-service'));
        this.allEntityService.set('userdictitem', () => import('@/service/user-dict-item/user-dict-item-service'));
        this.allEntityService.set('attendencesetup', () => import('@/service/attendencesetup/attendencesetup-service'));
        this.allEntityService.set('pcmddsqdmx', () => import('@/service/pcmddsqdmx/pcmddsqdmx-service'));
        this.allEntityService.set('pcmschooloffice', () => import('@/service/pcmschooloffice/pcmschooloffice-service'));
        this.allEntityService.set('pimtypecontract', () => import('@/service/pimtypecontract/pimtypecontract-service'));
        this.allEntityService.set('userdict', () => import('@/service/user-dict/user-dict-service'));
        this.allEntityService.set('trmteachercharge', () => import('@/service/trmteachercharge/trmteachercharge-service'));
        this.allEntityService.set('salstdzc', () => import('@/service/salstdzc/salstdzc-service'));
        this.allEntityService.set('pcmxygzzsq', () => import('@/service/pcmxygzzsq/pcmxygzzsq-service'));
        this.allEntityService.set('vacworkday', () => import('@/service/vacworkday/vacworkday-service'));
        this.allEntityService.set('attendencetype', () => import('@/service/attendencetype/attendencetype-service'));
        this.allEntityService.set('pimoutput', () => import('@/service/pimoutput/pimoutput-service'));
        this.allEntityService.set('parjxzgpc', () => import('@/service/parjxzgpc/parjxzgpc-service'));
        this.allEntityService.set('vacsystemhistory', () => import('@/service/vacsystemhistory/vacsystemhistory-service'));
        this.allEntityService.set('attendancemreportmx', () => import('@/service/attendancemreportmx/attendancemreportmx-service'));
        this.allEntityService.set('trmteachertrain', () => import('@/service/trmteachertrain/trmteachertrain-service'));
        this.allEntityService.set('parjxkhjcsz', () => import('@/service/parjxkhjcsz/parjxkhjcsz-service'));
        this.allEntityService.set('trmtrianperson', () => import('@/service/trmtrianperson/trmtrianperson-service'));
        this.allEntityService.set('pimarchivesloanandreturn', () => import('@/service/pimarchivesloanandreturn/pimarchivesloanandreturn-service'));
        this.allEntityService.set('pcmzjdyzw', () => import('@/service/pcmzjdyzw/pcmzjdyzw-service'));
        this.allEntityService.set('userroledata', () => import('@/service/user-role-data/user-role-data-service'));
        this.allEntityService.set('wfassistwork', () => import('@/service/wfassist-work/wfassist-work-service'));
        this.allEntityService.set('pcmrcxl', () => import('@/service/pcmrcxl/pcmrcxl-service'));
        this.allEntityService.set('pimbyzzjlmx', () => import('@/service/pimbyzzjlmx/pimbyzzjlmx-service'));
        this.allEntityService.set('orgsecusertype', () => import('@/service/org-sec-user-type/org-sec-user-type-service'));
        this.allEntityService.set('ormbmgwbz', () => import('@/service/ormbmgwbz/ormbmgwbz-service'));
        this.allEntityService.set('pimcontract', () => import('@/service/pimcontract/pimcontract-service'));
        this.allEntityService.set('saltype', () => import('@/service/saltype/saltype-service'));
        this.allEntityService.set('userrole', () => import('@/service/user-role/user-role-service'));
        this.allEntityService.set('pcmprofileinitnumber', () => import('@/service/pcmprofileinitnumber/pcmprofileinitnumber-service'));
        this.allEntityService.set('pcmworkresume', () => import('@/service/pcmworkresume/pcmworkresume-service'));
        this.allEntityService.set('trmtrainactment', () => import('@/service/trmtrainactment/trmtrainactment-service'));
        this.allEntityService.set('pimsocialsecurity', () => import('@/service/pimsocialsecurity/pimsocialsecurity-service'));
        this.allEntityService.set('wfcustomprocess', () => import('@/service/wfcustom-process/wfcustom-process-service'));
        this.allEntityService.set('pimworkhistory', () => import('@/service/pimworkhistory/pimworkhistory-service'));
        this.allEntityService.set('ormorgdz', () => import('@/service/ormorgdz/ormorgdz-service'));
        this.allEntityService.set('parlhmbmx', () => import('@/service/parlhmbmx/parlhmbmx-service'));
        this.allEntityService.set('pimpersonability', () => import('@/service/pimperson-ability/pimperson-ability-service'));
        this.allEntityService.set('trminvoice', () => import('@/service/trminvoice/trminvoice-service'));
        this.allEntityService.set('ormtitle', () => import('@/service/ormtitle/ormtitle-service'));
        this.allEntityService.set('vacleacetype', () => import('@/service/vacleacetype/vacleacetype-service'));
        this.allEntityService.set('salstdgw', () => import('@/service/salstdgw/salstdgw-service'));
        this.allEntityService.set('pimarchiveschange', () => import('@/service/pimarchiveschange/pimarchiveschange-service'));
        this.allEntityService.set('pcmdetail', () => import('@/service/pcmdetail/pcmdetail-service'));
        this.allEntityService.set('pimexpaccount', () => import('@/service/pimexpaccount/pimexpaccount-service'));
        this.allEntityService.set('pcmsyqgz', () => import('@/service/pcmsyqgz/pcmsyqgz-service'));
        this.allEntityService.set('vacholiday', () => import('@/service/vacholiday/vacholiday-service'));
        this.allEntityService.set('salsalarydetail', () => import('@/service/salsalarydetail/salsalarydetail-service'));
        this.allEntityService.set('parjxmtfk', () => import('@/service/parjxmtfk/parjxmtfk-service'));
        this.allEntityService.set('attendancemreport', () => import('@/service/attendancemreport/attendancemreport-service'));
        this.allEntityService.set('trmtrainactapply', () => import('@/service/trmtrainactapply/trmtrainactapply-service'));
        this.allEntityService.set('pcmgxml', () => import('@/service/pcmgxml/pcmgxml-service'));
        this.allEntityService.set('userroledefieldes', () => import('@/service/user-role-defieldes/user-role-defieldes-service'));
        this.allEntityService.set('pcmtxbz', () => import('@/service/pcmtxbz/pcmtxbz-service'));
        this.allEntityService.set('ormxmxqhz', () => import('@/service/ormxmxqhz/ormxmxqhz-service'));
        this.allEntityService.set('pimqualmajor', () => import('@/service/pimqualmajor/pimqualmajor-service'));
        this.allEntityService.set('pcmxygzzkhjgjl', () => import('@/service/pcmxygzzkhjgjl/pcmxygzzkhjgjl-service'));
        this.allEntityService.set('parjxkhmbmx', () => import('@/service/parjxkhmbmx/parjxkhmbmx-service'));
        this.allEntityService.set('vacleavemanage', () => import('@/service/vacleavemanage/vacleavemanage-service'));
        this.allEntityService.set('pcmlog', () => import('@/service/pcmlog/pcmlog-service'));
        this.allEntityService.set('wfstepinst', () => import('@/service/wfstep-inst/wfstep-inst-service'));
        this.allEntityService.set('wxaccesstoken', () => import('@/service/wxaccess-token/wxaccess-token-service'));
        this.allEntityService.set('pimvacation', () => import('@/service/pimvacation/pimvacation-service'));
        this.allEntityService.set('pimexitandentry', () => import('@/service/pimexitandentry/pimexitandentry-service'));
        this.allEntityService.set('trmplanformu', () => import('@/service/trmplanformu/trmplanformu-service'));
        this.allEntityService.set('loginlog', () => import('@/service/login-log/login-log-service'));
        this.allEntityService.set('trmtraindemand', () => import('@/service/trmtraindemand/trmtraindemand-service'));
        this.allEntityService.set('pimpersonchange', () => import('@/service/pimpersonchange/pimpersonchange-service'));
        this.allEntityService.set('pcmeducationexperience', () => import('@/service/pcmeducation-experience/pcmeducation-experience-service'));
        this.allEntityService.set('usergroup', () => import('@/service/user-group/user-group-service'));
        this.allEntityService.set('trmtrainplan', () => import('@/service/trmtrainplan/trmtrainplan-service'));
        this.allEntityService.set('userroledetail', () => import('@/service/user-role-detail/user-role-detail-service'));
        this.allEntityService.set('orguser', () => import('@/service/org-user/org-user-service'));
        this.allEntityService.set('pimachievements', () => import('@/service/pimachievements/pimachievements-service'));
        this.allEntityService.set('pcmbdsqd', () => import('@/service/pcmbdsqd/pcmbdsqd-service'));
        this.allEntityService.set('pcmxkml', () => import('@/service/pcmxkml/pcmxkml-service'));
        this.allEntityService.set('pimlanguageability', () => import('@/service/pimlanguageability/pimlanguageability-service'));
        this.allEntityService.set('wxorgsector', () => import('@/service/wxorg-sector/wxorg-sector-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pimperson/pimperson-service'));
        this.allEntityService.set('userroledefield', () => import('@/service/user-role-defield/user-role-defield-service'));
        this.allEntityService.set('userdgtheme', () => import('@/service/user-dgtheme/user-dgtheme-service'));
        this.allEntityService.set('msgsendqueue', () => import('@/service/msg-send-queue/msg-send-queue-service'));
        this.allEntityService.set('trmtraffic', () => import('@/service/trmtraffic/trmtraffic-service'));
        this.allEntityService.set('wfuser', () => import('@/service/wfuser/wfuser-service'));
        this.allEntityService.set('userroledatadetail', () => import('@/service/user-role-data-detail/user-role-data-detail-service'));
        this.allEntityService.set('pimexaminationresults', () => import('@/service/pimexaminationresults/pimexaminationresults-service'));
        this.allEntityService.set('pimarchives', () => import('@/service/pimarchives/pimarchives-service'));
        this.allEntityService.set('vacleavesystemdetail', () => import('@/service/vacleavesystemdetail/vacleavesystemdetail-service'));
        this.allEntityService.set('parjxzgpcmx', () => import('@/service/parjxzgpcmx/parjxzgpcmx-service'));
        this.allEntityService.set('ormrank', () => import('@/service/ormrank/ormrank-service'));
        this.allEntityService.set('vacleavedetail', () => import('@/service/vacleavedetail/vacleavedetail-service'));
        this.allEntityService.set('trmtraindata', () => import('@/service/trmtraindata/trmtraindata-service'));
        this.allEntityService.set('pcmgbhmc', () => import('@/service/pcmgbhmc/pcmgbhmc-service'));
        this.allEntityService.set('parjgbmpjbz', () => import('@/service/parjgbmpjbz/parjgbmpjbz-service'));
        this.allEntityService.set('wfuserassist', () => import('@/service/wfuser-assist/wfuser-assist-service'));
        this.allEntityService.set('parndlhmbkh', () => import('@/service/parndlhmbkh/parndlhmbkh-service'));
        this.allEntityService.set('usergroupdetail', () => import('@/service/user-group-detail/user-group-detail-service'));
        this.allEntityService.set('userdictcat', () => import('@/service/user-dict-cat/user-dict-cat-service'));
        this.allEntityService.set('pcmydjzmx', () => import('@/service/pcmydjzmx/pcmydjzmx-service'));
        this.allEntityService.set('testresult', () => import('@/service/test-result/test-result-service'));
        this.allEntityService.set('ormorginfo', () => import('@/service/ormorginfo/ormorginfo-service'));
        this.allEntityService.set('vacinitnxj', () => import('@/service/vacinitnxj/vacinitnxj-service'));
        this.allEntityService.set('salstdzx', () => import('@/service/salstdzx/salstdzx-service'));
        this.allEntityService.set('pimworkflow', () => import('@/service/pimworkflow/pimworkflow-service'));
        this.allEntityService.set('salitem', () => import('@/service/salitem/salitem-service'));
        this.allEntityService.set('trmagencyrecord', () => import('@/service/trmagencyrecord/trmagencyrecord-service'));
        this.allEntityService.set('ormbmkqdz', () => import('@/service/ormbmkqdz/ormbmkqdz-service'));
        this.allEntityService.set('sgqmgr', () => import('@/service/sgqmgr/sgqmgr-service'));
        this.allEntityService.set('trmdepartneeds', () => import('@/service/trmdepartneeds/trmdepartneeds-service'));
        this.allEntityService.set('salstdxmgz', () => import('@/service/salstdxmgz/salstdxmgz-service'));
        this.allEntityService.set('pcmcsrcmspj', () => import('@/service/pcmcsrcmspj/pcmcsrcmspj-service'));
        this.allEntityService.set('parkhzcmx', () => import('@/service/parkhzcmx/parkhzcmx-service'));
        this.allEntityService.set('salstdzyzg', () => import('@/service/salstdzyzg/salstdzyzg-service'));
        this.allEntityService.set('pimarchivesrecord', () => import('@/service/pimarchivesrecord/pimarchivesrecord-service'));
        this.allEntityService.set('pcmreason', () => import('@/service/pcmreason/pcmreason-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/ormorgsector/ormorgsector-service'));
        this.allEntityService.set('trmdemdeftion', () => import('@/service/trmdemdeftion/trmdemdeftion-service'));
        this.allEntityService.set('parjxjg', () => import('@/service/parjxjg/parjxjg-service'));
        this.allEntityService.set('salsubject', () => import('@/service/salsubject/salsubject-service'));
        this.allEntityService.set('pcmydlzmx', () => import('@/service/pcmydlzmx/pcmydlzmx-service'));
        this.allEntityService.set('pimtitlecatalogue', () => import('@/service/pimtitlecatalogue/pimtitlecatalogue-service'));
        this.allEntityService.set('parxmbpjbz', () => import('@/service/parxmbpjbz/parxmbpjbz-service'));
        this.allEntityService.set('vacleavesystem', () => import('@/service/vacleavesystem/vacleavesystem-service'));
        this.allEntityService.set('pcmypzjkxx', () => import('@/service/pcmypzjkxx/pcmypzjkxx-service'));
        this.allEntityService.set('salstdgl', () => import('@/service/salstdgl/salstdgl-service'));
        this.allEntityService.set('pimarmycadres', () => import('@/service/pimarmycadres/pimarmycadres-service'));
        this.allEntityService.set('pimbyygzzsq', () => import('@/service/pimbyygzzsq/pimbyygzzsq-service'));
        this.allEntityService.set('trmtrainteacher', () => import('@/service/trmtrainteacher/trmtrainteacher-service'));
        this.allEntityService.set('pcmjxsbdjl', () => import('@/service/pcmjxsbdjl/pcmjxsbdjl-service'));
        this.allEntityService.set('trmtrainbuapply', () => import('@/service/trmtrainbuapply/trmtrainbuapply-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('querymodel', () => import('@/service/query-model/query-model-service'));
        this.allEntityService.set('trmtrainagency', () => import('@/service/trmtrainagency/trmtrainagency-service'));
        this.allEntityService.set('pimresearchfindings', () => import('@/service/pimresearchfindings/pimresearchfindings-service'));
        this.allEntityService.set('msgsendqueuehis', () => import('@/service/msg-send-queue-his/msg-send-queue-his-service'));
        this.allEntityService.set('salscheme', () => import('@/service/salscheme/salscheme-service'));
        this.allEntityService.set('pimlwgz', () => import('@/service/pimlwgz/pimlwgz-service'));
        this.allEntityService.set('pimcontracttype', () => import('@/service/pimcontracttype/pimcontracttype-service'));
        this.allEntityService.set('salsalary', () => import('@/service/salsalary/salsalary-service'));
        this.allEntityService.set('pcmnorecyclinglibrary', () => import('@/service/pcmnorecycling-library/pcmnorecycling-library-service'));
        this.allEntityService.set('attendancedate', () => import('@/service/attendancedate/attendancedate-service'));
        this.allEntityService.set('nationmgr', () => import('@/service/nation-mgr/nation-mgr-service'));
        this.allEntityService.set('ormxmrypzxq', () => import('@/service/ormxmrypzxq/ormxmrypzxq-service'));
        this.allEntityService.set('pcmydjpmx', () => import('@/service/pcmydjpmx/pcmydjpmx-service'));
        this.allEntityService.set('pimdistirbution', () => import('@/service/pimdistirbution/pimdistirbution-service'));
        this.allEntityService.set('pimlabourcampany', () => import('@/service/pimlabourcampany/pimlabourcampany-service'));
        this.allEntityService.set('pcmydjdmx', () => import('@/service/pcmydjdmx/pcmydjdmx-service'));
        this.allEntityService.set('tdzwxx', () => import('@/service/tdzwxx/tdzwxx-service'));
        this.allEntityService.set('wfinstance', () => import('@/service/wfinstance/wfinstance-service'));
        this.allEntityService.set('contractsignorg', () => import('@/service/contract-sign-org/contract-sign-org-service'));
        this.allEntityService.set('parjxkhmb', () => import('@/service/parjxkhmb/parjxkhmb-service'));
        this.allEntityService.set('salpersonstd', () => import('@/service/salpersonstd/salpersonstd-service'));
        this.allEntityService.set('trmtraindemandsum', () => import('@/service/trmtraindemandsum/trmtraindemandsum-service'));
        this.allEntityService.set('salsalarybill', () => import('@/service/salsalarybill/salsalarybill-service'));
        this.allEntityService.set('parznbmmx', () => import('@/service/parznbmmx/parznbmmx-service'));
        this.allEntityService.set('trmemployretion', () => import('@/service/trmemployretion/trmemployretion-service'));
        this.allEntityService.set('parjxndkhjg', () => import('@/service/parjxndkhjg/parjxndkhjg-service'));
        this.allEntityService.set('wfworklist', () => import('@/service/wfwork-list/wfwork-list-service'));
        this.allEntityService.set('trmstaff', () => import('@/service/trmstaff/trmstaff-service'));
        this.allEntityService.set('ormxmbmx', () => import('@/service/ormxmbmx/ormxmbmx-service'));
        this.allEntityService.set('parldkhqz', () => import('@/service/parldkhqz/parldkhqz-service'));
        this.allEntityService.set('questions', () => import('@/service/questions/questions-service'));
        this.allEntityService.set('salruledetail', () => import('@/service/salruledetail/salruledetail-service'));
        this.allEntityService.set('orgsecuser', () => import('@/service/org-sec-user/org-sec-user-service'));
        this.allEntityService.set('salpersonstddetail', () => import('@/service/salpersonstddetail/salpersonstddetail-service'));
        this.allEntityService.set('trmstay', () => import('@/service/trmstay/trmstay-service'));
        this.allEntityService.set('trmcoursesystem', () => import('@/service/trmcoursesystem/trmcoursesystem-service'));
        this.allEntityService.set('attensummary', () => import('@/service/attensummary/attensummary-service'));
        this.allEntityService.set('salrule', () => import('@/service/salrule/salrule-service'));
        this.allEntityService.set('ormxmrlcb', () => import('@/service/ormxmrlcb/ormxmrlcb-service'));
        this.allEntityService.set('wfuiwizard', () => import('@/service/wfuiwizard/wfuiwizard-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('ormpostdetails', () => import('@/service/ormpost-details/ormpost-details-service'));
        this.allEntityService.set('wfreminder', () => import('@/service/wfreminder/wfreminder-service'));
        this.allEntityService.set('pimstafftype', () => import('@/service/pimstafftype/pimstafftype-service'));
        this.allEntityService.set('pcmsgqmgr', () => import('@/service/pcmsgq-mgr/pcmsgq-mgr-service'));
        this.allEntityService.set('salitemsub', () => import('@/service/salitemsub/salitemsub-service'));
        this.allEntityService.set('wfusercandidate', () => import('@/service/wfuser-candidate/wfuser-candidate-service'));
        this.allEntityService.set('wftmpstepactor', () => import('@/service/wftmp-step-actor/wftmp-step-actor-service'));
        this.allEntityService.set('pimgwtype', () => import('@/service/pimgwtype/pimgwtype-service'));
        this.allEntityService.set('ormpostlib', () => import('@/service/ormpost-lib/ormpost-lib-service'));
        this.allEntityService.set('archivescenter', () => import('@/service/archivescenter/archivescenter-service'));
        this.allEntityService.set('userroledatas', () => import('@/service/user-role-datas/user-role-datas-service'));
        this.allEntityService.set('parjxbzgl', () => import('@/service/parjxbzgl/parjxbzgl-service'));
        this.allEntityService.set('vacusenxjmx', () => import('@/service/vacusenxjmx/vacusenxjmx-service'));
        this.allEntityService.set('vacsynjcx', () => import('@/service/vacsynjcx/vacsynjcx-service'));
        this.allEntityService.set('pcmzpmegl', () => import('@/service/pcmzpmegl/pcmzpmegl-service'));
        this.allEntityService.set('attendancesummarymx', () => import('@/service/attendancesummarymx/attendancesummarymx-service'));
        this.allEntityService.set('trmhmatser', () => import('@/service/trmhmatser/trmhmatser-service'));
        this.allEntityService.set('userroleres', () => import('@/service/user-role-res/user-role-res-service'));
        this.allEntityService.set('userobject', () => import('@/service/user-object/user-object-service'));
        this.allEntityService.set('appcenter', () => import('@/service/app-center/app-center-service'));
        this.allEntityService.set('pcmtxfpsq', () => import('@/service/pcmtxfpsq/pcmtxfpsq-service'));
        this.allEntityService.set('ormzwdqgz', () => import('@/service/ormzwdqgz/ormzwdqgz-service'));
        this.allEntityService.set('msgaccount', () => import('@/service/msg-account/msg-account-service'));
        this.allEntityService.set('pcmyddgmx', () => import('@/service/pcmyddgmx/pcmyddgmx-service'));
        this.allEntityService.set('ormxmbq', () => import('@/service/ormxmbq/ormxmbq-service'));
        this.allEntityService.set('wfsystemuser', () => import('@/service/wfsystem-user/wfsystem-user-service'));
        this.allEntityService.set('attendancerecordtemp', () => import('@/service/attendancerecordtemp/attendancerecordtemp-service'));
        this.allEntityService.set('pcmgxxktemp', () => import('@/service/pcmgxxktemp/pcmgxxktemp-service'));
        this.allEntityService.set('pcmrzgl', () => import('@/service/pcmrzgl/pcmrzgl-service'));
        this.allEntityService.set('trmtrainfillin', () => import('@/service/trmtrainfillin/trmtrainfillin-service'));
        this.allEntityService.set('user', () => import('@/service/user/user-service'));
        this.allEntityService.set('salstdxmgzrate', () => import('@/service/salstdxmgzrate/salstdxmgzrate-service'));
        this.allEntityService.set('vacdayoff', () => import('@/service/vacdayoff/vacdayoff-service'));
        this.allEntityService.set('org', () => import('@/service/org/org-service'));
        this.allEntityService.set('trmstaffnodes', () => import('@/service/trmstaffnodes/trmstaffnodes-service'));
        this.allEntityService.set('wfaction', () => import('@/service/wfaction/wfaction-service'));
        this.allEntityService.set('pcmawardswons', () => import('@/service/pcmawardswons/pcmawardswons-service'));
        this.allEntityService.set('trmcouarrange', () => import('@/service/trmcouarrange/trmcouarrange-service'));
        this.allEntityService.set('pimrewardpunishment', () => import('@/service/pimrewardpunishment/pimrewardpunishment-service'));
        this.allEntityService.set('salstdzj', () => import('@/service/salstdzj/salstdzj-service'));
        this.allEntityService.set('orgtype', () => import('@/service/org-type/org-type-service'));
        this.allEntityService.set('attendancerecord', () => import('@/service/attendancerecord/attendancerecord-service'));
        this.allEntityService.set('pimpatent', () => import('@/service/pimpatent/pimpatent-service'));
        this.allEntityService.set('trmtrainaddress', () => import('@/service/trmtrainaddress/trmtrainaddress-service'));
        this.allEntityService.set('archivesmanage', () => import('@/service/archivesmanage/archivesmanage-service'));
        this.allEntityService.set('pcmprofile', () => import('@/service/pcmprofile/pcmprofile-service'));
        this.allEntityService.set('trmtrainoutapply', () => import('@/service/trmtrainoutapply/trmtrainoutapply-service'));
        this.allEntityService.set('archivalcatalogue', () => import('@/service/archivalcatalogue/archivalcatalogue-service'));
        this.allEntityService.set('orgunitcat', () => import('@/service/org-unit-cat/org-unit-cat-service'));
        this.allEntityService.set('parjxqdsz', () => import('@/service/parjxqdsz/parjxqdsz-service'));
        this.allEntityService.set('vacsituationdetail', () => import('@/service/vacsituationdetail/vacsituationdetail-service'));
        this.allEntityService.set('wfstep', () => import('@/service/wfstep/wfstep-service'));
        this.allEntityService.set('trmtraincourse', () => import('@/service/trmtraincourse/trmtraincourse-service'));
        this.allEntityService.set('dataentity', () => import('@/service/data-entity/data-entity-service'));
        this.allEntityService.set('parkhfa', () => import('@/service/parkhfa/parkhfa-service'));
        this.allEntityService.set('wxaccount', () => import('@/service/wxaccount/wxaccount-service'));
        this.allEntityService.set('attendenceormorgsector', () => import('@/service/attendenceormorgsector/attendenceormorgsector-service'));
        this.allEntityService.set('wfappsetting', () => import('@/service/wfapp-setting/wfapp-setting-service'));
        this.allEntityService.set('trmdutycadres', () => import('@/service/trmdutycadres/trmdutycadres-service'));
        this.allEntityService.set('vacoveralltion', () => import('@/service/vacoveralltion/vacoveralltion-service'));
        this.allEntityService.set('partzgg', () => import('@/service/partzgg/partzgg-service'));
        this.allEntityService.set('pcmydntmx', () => import('@/service/pcmydntmx/pcmydntmx-service'));
        this.allEntityService.set('trmgradecadres', () => import('@/service/trmgradecadres/trmgradecadres-service'));
        this.allEntityService.set('trmlgbdetail', () => import('@/service/trmlgbdetail/trmlgbdetail-service'));
        this.allEntityService.set('ormrelation', () => import('@/service/ormrelation/ormrelation-service'));
        this.allEntityService.set('trmtrainfacies', () => import('@/service/trmtrainfacies/trmtrainfacies-service'));
        this.allEntityService.set('ormsignorg', () => import('@/service/orm-sign-org/orm-sign-org-service'));
        this.allEntityService.set('pcmydgzmx', () => import('@/service/pcmydgzmx/pcmydgzmx-service'));
        this.allEntityService.set('attendancesettings', () => import('@/service/attendancesettings/attendancesettings-service'));
        this.allEntityService.set('salstddszn', () => import('@/service/salstddszn/salstddszn-service'));
        this.allEntityService.set('ormdepestman', () => import('@/service/ormdep-est-man/ormdep-est-man-service'));
        this.allEntityService.set('ormxmsfhz', () => import('@/service/ormxmsfhz/ormxmsfhz-service'));
        this.allEntityService.set('ormduty', () => import('@/service/ormduty/ormduty-service'));
        this.allEntityService.set('pcmmspjxx', () => import('@/service/pcmmspjxx/pcmmspjxx-service'));
        this.allEntityService.set('wfdynamicuser', () => import('@/service/wfdynamic-user/wfdynamic-user-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('daterule', () => import('@/service/date-rule/date-rule-service'));
        this.allEntityService.set('ormqybzwh', () => import('@/service/ormqybzwh/ormqybzwh-service'));
        this.allEntityService.set('vacholidayrules', () => import('@/service/vacholidayrules/vacholidayrules-service'));
        this.allEntityService.set('wxmessage', () => import('@/service/wxmessage/wxmessage-service'));
        this.allEntityService.set('pimworkflowref', () => import('@/service/pimworkflow-ref/pimworkflow-ref-service'));
        this.allEntityService.set('parjxkhxhz', () => import('@/service/parjxkhxhz/parjxkhxhz-service'));
        this.allEntityService.set('pcmxygzzjlmx', () => import('@/service/pcmxygzzjlmx/pcmxygzzjlmx-service'));
        this.allEntityService.set('wfworkflow', () => import('@/service/wfworkflow/wfworkflow-service'));
        this.allEntityService.set('wfqj', () => import('@/service/wfqj/wfqj-service'));
        this.allEntityService.set('pcmjxszzkhjgjl', () => import('@/service/pcmjxszzkhjgjl/pcmjxszzkhjgjl-service'));
        this.allEntityService.set('salsource', () => import('@/service/salsource/salsource-service'));
        this.allEntityService.set('userroledataaction', () => import('@/service/user-role-data-action/user-role-data-action-service'));
        this.allEntityService.set('pimeducation', () => import('@/service/pimeducation/pimeducation-service'));
        this.allEntityService.set('ormqygl', () => import('@/service/ormqygl/ormqygl-service'));
        this.allEntityService.set('pcmjxsygzzsqmx', () => import('@/service/pcmjxsygzzsqmx/pcmjxsygzzsqmx-service'));
        this.allEntityService.set('wfstepactor', () => import('@/service/wfstep-actor/wfstep-actor-service'));
        this.allEntityService.set('pimprovince', () => import('@/service/pimprovince/pimprovince-service'));
        this.allEntityService.set('pcmzsgl', () => import('@/service/pcmzsgl/pcmzsgl-service'));
        this.allEntityService.set('orgsector', () => import('@/service/org-sector/org-sector-service'));
        this.allEntityService.set('wxentapp', () => import('@/service/wxent-app/wxent-app-service'));
        this.allEntityService.set('wfactor', () => import('@/service/wfactor/wfactor-service'));
        this.allEntityService.set('wfiaaction', () => import('@/service/wfiaaction/wfiaaction-service'));
        this.allEntityService.set('ormpost', () => import('@/service/ormpost/ormpost-service'));
        this.allEntityService.set('salplan', () => import('@/service/salplan/salplan-service'));
        this.allEntityService.set('pcmzpmeglmx', () => import('@/service/pcmzpmeglmx/pcmzpmeglmx-service'));
        this.allEntityService.set('parjxbzglmx', () => import('@/service/parjxbzglmx/parjxbzglmx-service'));
        this.allEntityService.set('salstdgwgz', () => import('@/service/salstdgwgz/salstdgwgz-service'));
        this.allEntityService.set('pimpersonabilitydetail', () => import('@/service/pimperson-ability-detail/pimperson-ability-detail-service'));
        this.allEntityService.set('ormxmgl', () => import('@/service/ormxmgl/ormxmgl-service'));
        this.allEntityService.set('attenmembwes', () => import('@/service/attenmembwes/attenmembwes-service'));
        this.allEntityService.set('wfstepdata', () => import('@/service/wfstep-data/wfstep-data-service'));
        this.allEntityService.set('ormerporg', () => import('@/service/ormerporg/ormerporg-service'));
        this.allEntityService.set('loginaccount', () => import('@/service/login-account/login-account-service'));
        this.allEntityService.set('parbmfzjyx', () => import('@/service/parbmfzjyx/parbmfzjyx-service'));
        this.allEntityService.set('orguserlevel', () => import('@/service/org-user-level/org-user-level-service'));
        this.allEntityService.set('pcmddsqd', () => import('@/service/pcmddsqd/pcmddsqd-service'));
        this.allEntityService.set('pcmjxsgz', () => import('@/service/pcmjxsgz/pcmjxsgz-service'));
        this.allEntityService.set('vacsituation', () => import('@/service/vacsituation/vacsituation-service'));
        this.allEntityService.set('pcmbdsqdmx', () => import('@/service/pcmbdsqdmx/pcmbdsqdmx-service'));
        this.allEntityService.set('wxmedia', () => import('@/service/wxmedia/wxmedia-service'));
        this.allEntityService.set('pcmjxsygzzjlmx', () => import('@/service/pcmjxsygzzjlmx/pcmjxsygzzjlmx-service'));
        this.allEntityService.set('vacsystemapplication', () => import('@/service/vacsystemapplication/vacsystemapplication-service'));
        this.allEntityService.set('trmzzobm', () => import('@/service/trmzzobm/trmzzobm-service'));
        this.allEntityService.set('pcmydbxmx', () => import('@/service/pcmydbxmx/pcmydbxmx-service'));
        this.allEntityService.set('pimpaper', () => import('@/service/pimpaper/pimpaper-service'));
        this.allEntityService.set('attendrecorddetail', () => import('@/service/attend-record-detail/attend-record-detail-service'));
        this.allEntityService.set('unires', () => import('@/service/uni-res/uni-res-service'));
        this.allEntityService.set('pcmxygzzjgwh', () => import('@/service/pcmxygzzjgwh/pcmxygzzjgwh-service'));
        this.allEntityService.set('salparam', () => import('@/service/salparam/salparam-service'));
        this.allEntityService.set('parjxlhmb', () => import('@/service/parjxlhmb/parjxlhmb-service'));
        this.allEntityService.set('pcmxygzzsqmx', () => import('@/service/pcmxygzzsqmx/pcmxygzzsqmx-service'));
        this.allEntityService.set('wfversion', () => import('@/service/wfversion/wfversion-service'));
        this.allEntityService.set('pimvocationalcatalog', () => import('@/service/pimvocationalcatalog/pimvocationalcatalog-service'));
        this.allEntityService.set('pcmydtxmx', () => import('@/service/pcmydtxmx/pcmydtxmx-service'));
        this.allEntityService.set('pcmpracticeexperience', () => import('@/service/pcmpracticeexperience/pcmpracticeexperience-service'));
        this.allEntityService.set('msgtemplate', () => import('@/service/msg-template/msg-template-service'));
        this.allEntityService.set('parfzsmx', () => import('@/service/parfzsmx/parfzsmx-service'));
        this.allEntityService.set('pimcity', () => import('@/service/pimcity/pimcity-service'));
        this.allEntityService.set('userroletype', () => import('@/service/user-role-type/user-role-type-service'));
        this.allEntityService.set('pimvocational', () => import('@/service/pimvocational/pimvocational-service'));
        this.allEntityService.set('pimfaminfo', () => import('@/service/pimfaminfo/pimfaminfo-service'));
        this.allEntityService.set('pimenclosure', () => import('@/service/pimenclosure/pimenclosure-service'));
        this.allEntityService.set('trmtrainresment', () => import('@/service/trmtrainresment/trmtrainresment-service'));
    }

    /**
     * 加载实体数据服务
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof EntityServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allEntityService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体数据服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof EntityServiceRegister
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
export const entityServiceRegister: EntityServiceRegister = new EntityServiceRegister();
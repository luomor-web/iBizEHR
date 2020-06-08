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
                this.allUIService.set('sallog', () => import('@/uiservice/sal-log/sal-log-ui-service'));
        this.allUIService.set('trmdepart', () => import('@/uiservice/trm-depart/trm-depart-ui-service'));
        this.allUIService.set('trmtrainplanterm', () => import('@/uiservice/trm-train-planterm/trm-train-planterm-ui-service'));
        this.allUIService.set('salschemeitem', () => import('@/uiservice/sal-scheme-item/sal-scheme-item-ui-service'));
        this.allUIService.set('trmlgbcost', () => import('@/uiservice/trm-lgb-cost/trm-lgb-cost-ui-service'));
        this.allUIService.set('pcmjxsygzzsq', () => import('@/uiservice/pcm-jxsygzzsq/pcm-jxsygzzsq-ui-service'));
        this.allUIService.set('pcmrecruitment', () => import('@/uiservice/pcm-recruitment/pcm-recruitment-ui-service'));
        this.allUIService.set('pimcorrectionapply', () => import('@/uiservice/pim-correction-apply/pim-correction-apply-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('pcmnotice', () => import('@/uiservice/pcm-notice/pcm-notice-ui-service'));
        this.allUIService.set('salstdgwgzrate', () => import('@/uiservice/sal-std-gw-gzrate/sal-std-gw-gzrate-ui-service'));
        this.allUIService.set('pcmydmx', () => import('@/uiservice/pcm-ydmx/pcm-ydmx-ui-service'));
        this.allUIService.set('pimqualtype', () => import('@/uiservice/pim-qual-type/pim-qual-type-ui-service'));
        this.allUIService.set('pimmajorsetype', () => import('@/uiservice/pim-major-setype/pim-major-setype-ui-service'));
        this.allUIService.set('pcmwzd0001', () => import('@/uiservice/pcm-wzd0001/pcm-wzd0001-ui-service'));
        this.allUIService.set('pimtitle', () => import('@/uiservice/pim-title/pim-title-ui-service'));
        this.allUIService.set('parlhmbkhmx', () => import('@/uiservice/par-lhmbkhmx/par-lhmbkhmx-ui-service'));
        this.allUIService.set('attendencesetup', () => import('@/uiservice/att-endence-setup/att-endence-setup-ui-service'));
        this.allUIService.set('pcmddsqdmx', () => import('@/uiservice/pcm-ddsqdmx/pcm-ddsqdmx-ui-service'));
        this.allUIService.set('pcmschooloffice', () => import('@/uiservice/pcm-school-office/pcm-school-office-ui-service'));
        this.allUIService.set('pimtypecontract', () => import('@/uiservice/pim-type-contract/pim-type-contract-ui-service'));
        this.allUIService.set('trmteachercharge', () => import('@/uiservice/trm-teacher-charge/trm-teacher-charge-ui-service'));
        this.allUIService.set('salstdzc', () => import('@/uiservice/sal-stdzc/sal-stdzc-ui-service'));
        this.allUIService.set('pcmxygzzsq', () => import('@/uiservice/pcm-xygzzsq/pcm-xygzzsq-ui-service'));
        this.allUIService.set('vacworkday', () => import('@/uiservice/vac-work-day/vac-work-day-ui-service'));
        this.allUIService.set('attendencetype', () => import('@/uiservice/att-endence-type/att-endence-type-ui-service'));
        this.allUIService.set('pimoutput', () => import('@/uiservice/pim-output/pim-output-ui-service'));
        this.allUIService.set('parjxzgpc', () => import('@/uiservice/par-jxzgpc/par-jxzgpc-ui-service'));
        this.allUIService.set('vacsystemhistory', () => import('@/uiservice/vac-system-history/vac-system-history-ui-service'));
        this.allUIService.set('attendancemreportmx', () => import('@/uiservice/att-endance-mreportmx/att-endance-mreportmx-ui-service'));
        this.allUIService.set('trmteachertrain', () => import('@/uiservice/trm-teacher-train/trm-teacher-train-ui-service'));
        this.allUIService.set('parjxkhjcsz', () => import('@/uiservice/par-jxkhjcsz/par-jxkhjcsz-ui-service'));
        this.allUIService.set('trmtrainperson', () => import('@/uiservice/trm-train-person/trm-train-person-ui-service'));
        this.allUIService.set('pimarchivesloanandreturn', () => import('@/uiservice/pim-archive-sloanandreturn/pim-archive-sloanandreturn-ui-service'));
        this.allUIService.set('pcmzjdyzw', () => import('@/uiservice/pcm-zjdyzw/pcm-zjdyzw-ui-service'));
        this.allUIService.set('pcmrcxl', () => import('@/uiservice/pcm-rcxl/pcm-rcxl-ui-service'));
        this.allUIService.set('pimbyzzjlmx', () => import('@/uiservice/pim-byzzjlmx/pim-byzzjlmx-ui-service'));
        this.allUIService.set('ormbmgwbz', () => import('@/uiservice/orm-bmgwbz/orm-bmgwbz-ui-service'));
        this.allUIService.set('pimcontract', () => import('@/uiservice/pim-contract/pim-contract-ui-service'));
        this.allUIService.set('saltype', () => import('@/uiservice/sal-type/sal-type-ui-service'));
        this.allUIService.set('pcmprofileinitnumber', () => import('@/uiservice/pcm-profile-init-number/pcm-profile-init-number-ui-service'));
        this.allUIService.set('pcmworkresume', () => import('@/uiservice/pcm-work-resume/pcm-work-resume-ui-service'));
        this.allUIService.set('trmtrainactment', () => import('@/uiservice/trm-train-actment/trm-train-actment-ui-service'));
        this.allUIService.set('pimsocialsecurity', () => import('@/uiservice/pim-social-security/pim-social-security-ui-service'));
        this.allUIService.set('pimworkhistory', () => import('@/uiservice/pim-work-history/pim-work-history-ui-service'));
        this.allUIService.set('ormorgdz', () => import('@/uiservice/orm-orgdz/orm-orgdz-ui-service'));
        this.allUIService.set('parlhmbmx', () => import('@/uiservice/par-lhmbmx/par-lhmbmx-ui-service'));
        this.allUIService.set('pimpersonability', () => import('@/uiservice/pim-person-ability/pim-person-ability-ui-service'));
        this.allUIService.set('trminvoice', () => import('@/uiservice/trm-invoice/trm-invoice-ui-service'));
        this.allUIService.set('ormtitle', () => import('@/uiservice/orm-title/orm-title-ui-service'));
        this.allUIService.set('vacleacetype', () => import('@/uiservice/vac-leace-type/vac-leace-type-ui-service'));
        this.allUIService.set('salstdgw', () => import('@/uiservice/sal-stdgw/sal-stdgw-ui-service'));
        this.allUIService.set('pimarchiveschange', () => import('@/uiservice/pim-archives-change/pim-archives-change-ui-service'));
        this.allUIService.set('pcmdetail', () => import('@/uiservice/pcm-detail/pcm-detail-ui-service'));
        this.allUIService.set('pimexpaccount', () => import('@/uiservice/pim-expaccount/pim-expaccount-ui-service'));
        this.allUIService.set('pcmsyqgz', () => import('@/uiservice/pcm-syqgz/pcm-syqgz-ui-service'));
        this.allUIService.set('vacholiday', () => import('@/uiservice/vac-holiday/vac-holiday-ui-service'));
        this.allUIService.set('salsalarydetail', () => import('@/uiservice/sal-salary-detail/sal-salary-detail-ui-service'));
        this.allUIService.set('parjxmtfk', () => import('@/uiservice/par-jxmtfk/par-jxmtfk-ui-service'));
        this.allUIService.set('attendancemreport', () => import('@/uiservice/att-endance-mreport/att-endance-mreport-ui-service'));
        this.allUIService.set('trmtrainactapply', () => import('@/uiservice/trm-train-actapply/trm-train-actapply-ui-service'));
        this.allUIService.set('pcmgxml', () => import('@/uiservice/pcm-gxml/pcm-gxml-ui-service'));
        this.allUIService.set('pcmtxbz', () => import('@/uiservice/pcm-txbz/pcm-txbz-ui-service'));
        this.allUIService.set('ormxmxqhz', () => import('@/uiservice/orm-xmxqhz/orm-xmxqhz-ui-service'));
        this.allUIService.set('pimqualmajor', () => import('@/uiservice/pim-qual-major/pim-qual-major-ui-service'));
        this.allUIService.set('pcmxygzzkhjgjl', () => import('@/uiservice/pcm-xygzzkhjgjl/pcm-xygzzkhjgjl-ui-service'));
        this.allUIService.set('parjxkhmbmx', () => import('@/uiservice/par-jxkhmbmx/par-jxkhmbmx-ui-service'));
        this.allUIService.set('vacleavemanage', () => import('@/uiservice/vac-leave-manage/vac-leave-manage-ui-service'));
        this.allUIService.set('pcmlog', () => import('@/uiservice/pcm-log/pcm-log-ui-service'));
        this.allUIService.set('pimvacation', () => import('@/uiservice/pim-vacation/pim-vacation-ui-service'));
        this.allUIService.set('pimexitandentry', () => import('@/uiservice/pim-exitandentry/pim-exitandentry-ui-service'));
        this.allUIService.set('trmplanformu', () => import('@/uiservice/trm-plan-formu/trm-plan-formu-ui-service'));
        this.allUIService.set('trmtraindemand', () => import('@/uiservice/trm-train-demand/trm-train-demand-ui-service'));
        this.allUIService.set('pimpersonchange', () => import('@/uiservice/pim-person-change/pim-person-change-ui-service'));
        this.allUIService.set('pcmeducationexperience', () => import('@/uiservice/pcm-education-experience/pcm-education-experience-ui-service'));
        this.allUIService.set('trmtrainplan', () => import('@/uiservice/trm-train-plan/trm-train-plan-ui-service'));
        this.allUIService.set('pimachievements', () => import('@/uiservice/pim-achievements/pim-achievements-ui-service'));
        this.allUIService.set('pcmxkml', () => import('@/uiservice/pcm-xkml/pcm-xkml-ui-service'));
        this.allUIService.set('pimlanguageability', () => import('@/uiservice/pim-language-ability/pim-language-ability-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('trmtraffic', () => import('@/uiservice/trm-traffic/trm-traffic-ui-service'));
        this.allUIService.set('pimexaminationresults', () => import('@/uiservice/pim-examination-results/pim-examination-results-ui-service'));
        this.allUIService.set('pimarchives', () => import('@/uiservice/pim-archives/pim-archives-ui-service'));
        this.allUIService.set('vacleavesystemdtail', () => import('@/uiservice/vac-leave-system-dtail/vac-leave-system-dtail-ui-service'));
        this.allUIService.set('parjxzgpcmx', () => import('@/uiservice/par-jxzgpcmx/par-jxzgpcmx-ui-service'));
        this.allUIService.set('ormrank', () => import('@/uiservice/orm-rank/orm-rank-ui-service'));
        this.allUIService.set('vacleavedetail', () => import('@/uiservice/vac-leave-detail/vac-leave-detail-ui-service'));
        this.allUIService.set('trmtraindata', () => import('@/uiservice/trm-train-data/trm-train-data-ui-service'));
        this.allUIService.set('pcmgbhmc', () => import('@/uiservice/pcm-gbhmc/pcm-gbhmc-ui-service'));
        this.allUIService.set('parjgbmpjbz', () => import('@/uiservice/par-jgbmpjbz/par-jgbmpjbz-ui-service'));
        this.allUIService.set('parndlhmbkh', () => import('@/uiservice/par-ndlhmbkh/par-ndlhmbkh-ui-service'));
        this.allUIService.set('pcmydjzmx', () => import('@/uiservice/pcm-ydjzmx/pcm-ydjzmx-ui-service'));
        this.allUIService.set('pcmtestresult', () => import('@/uiservice/pcm-test-result/pcm-test-result-ui-service'));
        this.allUIService.set('ormorginfo', () => import('@/uiservice/orm-org-info/orm-org-info-ui-service'));
        this.allUIService.set('vacinitnxj', () => import('@/uiservice/vac-initnxj/vac-initnxj-ui-service'));
        this.allUIService.set('salstdzx', () => import('@/uiservice/sal-stdzx/sal-stdzx-ui-service'));
        this.allUIService.set('pimworkflow', () => import('@/uiservice/pim-workflow/pim-workflow-ui-service'));
        this.allUIService.set('salitem', () => import('@/uiservice/sal-item/sal-item-ui-service'));
        this.allUIService.set('trmagencyrecord', () => import('@/uiservice/trm-agency-record/trm-agency-record-ui-service'));
        this.allUIService.set('ormbmkqdz', () => import('@/uiservice/orm-bmkqdz/orm-bmkqdz-ui-service'));
        this.allUIService.set('pcmpcmsgqmgr', () => import('@/uiservice/pcm-pcm-sgq-mgr/pcm-pcm-sgq-mgr-ui-service'));
        this.allUIService.set('trmdepartneeds', () => import('@/uiservice/trm-depart-needs/trm-depart-needs-ui-service'));
        this.allUIService.set('salstdxmgz', () => import('@/uiservice/sal-std-xmgz/sal-std-xmgz-ui-service'));
        this.allUIService.set('pcmcsrcmspj', () => import('@/uiservice/pcm-csrcmspj/pcm-csrcmspj-ui-service'));
        this.allUIService.set('parkhzcmx', () => import('@/uiservice/par-khzcmx/par-khzcmx-ui-service'));
        this.allUIService.set('salstdzyzg', () => import('@/uiservice/sal-stdzyzg/sal-stdzyzg-ui-service'));
        this.allUIService.set('pimarchivesrecord', () => import('@/uiservice/pim-archives-record/pim-archives-record-ui-service'));
        this.allUIService.set('pcmreason', () => import('@/uiservice/pcm-reason/pcm-reason-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('trmdemdeftion', () => import('@/uiservice/trm-demdeftion/trm-demdeftion-ui-service'));
        this.allUIService.set('parjxjg', () => import('@/uiservice/par-jxjg/par-jxjg-ui-service'));
        this.allUIService.set('salsubject', () => import('@/uiservice/sal-subject/sal-subject-ui-service'));
        this.allUIService.set('pcmydlzmx', () => import('@/uiservice/pcm-ydlzmx/pcm-ydlzmx-ui-service'));
        this.allUIService.set('pimtitlecatalogue', () => import('@/uiservice/pim-title-catalogue/pim-title-catalogue-ui-service'));
        this.allUIService.set('parxmbpjbz', () => import('@/uiservice/par-xmbpjbz/par-xmbpjbz-ui-service'));
        this.allUIService.set('vacleavesystem', () => import('@/uiservice/vac-leave-system/vac-leave-system-ui-service'));
        this.allUIService.set('pcmypzjkxx', () => import('@/uiservice/pcm-ypzjkxx/pcm-ypzjkxx-ui-service'));
        this.allUIService.set('salstdgl', () => import('@/uiservice/sal-stdgl/sal-stdgl-ui-service'));
        this.allUIService.set('pimarmycadres', () => import('@/uiservice/pim-armycadres/pim-armycadres-ui-service'));
        this.allUIService.set('pimbyygzzsq', () => import('@/uiservice/pim-byygzzsq/pim-byygzzsq-ui-service'));
        this.allUIService.set('trmtrainteacher', () => import('@/uiservice/trm-train-teacher/trm-train-teacher-ui-service'));
        this.allUIService.set('pcmjxsbdjl', () => import('@/uiservice/pcm-jxsbdjl/pcm-jxsbdjl-ui-service'));
        this.allUIService.set('trmtrainbuapply', () => import('@/uiservice/trm-train-buapply/trm-train-buapply-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('trmtrainagency', () => import('@/uiservice/trm-train-agency/trm-train-agency-ui-service'));
        this.allUIService.set('pimresearchfindings', () => import('@/uiservice/pim-research-findings/pim-research-findings-ui-service'));
        this.allUIService.set('salscheme', () => import('@/uiservice/sal-scheme/sal-scheme-ui-service'));
        this.allUIService.set('pimlwgz', () => import('@/uiservice/pim-lwgz/pim-lwgz-ui-service'));
        this.allUIService.set('pimcontracttype', () => import('@/uiservice/pim-contract-type/pim-contract-type-ui-service'));
        this.allUIService.set('salsalary', () => import('@/uiservice/sal-salary/sal-salary-ui-service'));
        this.allUIService.set('pcmnorecyclinglibrary', () => import('@/uiservice/pcm-no-recycling-library/pcm-no-recycling-library-ui-service'));
        this.allUIService.set('attendancedate', () => import('@/uiservice/att-endance-date/att-endance-date-ui-service'));
        this.allUIService.set('pimnationmgr', () => import('@/uiservice/pim-nation-mgr/pim-nation-mgr-ui-service'));
        this.allUIService.set('ormxmrypzxq', () => import('@/uiservice/orm-xmrypzxq/orm-xmrypzxq-ui-service'));
        this.allUIService.set('pcmydjpmx', () => import('@/uiservice/pcm-ydjpmx/pcm-ydjpmx-ui-service'));
        this.allUIService.set('pimdistirbution', () => import('@/uiservice/pim-distirbution/pim-distirbution-ui-service'));
        this.allUIService.set('pimlabourcampany', () => import('@/uiservice/pim-labourcampany/pim-labourcampany-ui-service'));
        this.allUIService.set('pcmydjdmx', () => import('@/uiservice/pcm-ydjdmx/pcm-ydjdmx-ui-service'));
        this.allUIService.set('pcmtdzwxx', () => import('@/uiservice/pcm-tdzwxx/pcm-tdzwxx-ui-service'));
        this.allUIService.set('pimcontractsignorg', () => import('@/uiservice/pim-contract-sign-org/pim-contract-sign-org-ui-service'));
        this.allUIService.set('parjxkhmb', () => import('@/uiservice/par-jxkhmb/par-jxkhmb-ui-service'));
        this.allUIService.set('salpersonstd', () => import('@/uiservice/sal-person-std/sal-person-std-ui-service'));
        this.allUIService.set('trmtraindemandsum', () => import('@/uiservice/trm-train-demand-sum/trm-train-demand-sum-ui-service'));
        this.allUIService.set('salsalarybill', () => import('@/uiservice/sal-salary-bill/sal-salary-bill-ui-service'));
        this.allUIService.set('parznbmmx', () => import('@/uiservice/par-znbmmx/par-znbmmx-ui-service'));
        this.allUIService.set('trmemployeeretion', () => import('@/uiservice/trm-employee-retion/trm-employee-retion-ui-service'));
        this.allUIService.set('parjxndkhjg', () => import('@/uiservice/par-jxndkhjg/par-jxndkhjg-ui-service'));
        this.allUIService.set('trmstaff', () => import('@/uiservice/trm-staff/trm-staff-ui-service'));
        this.allUIService.set('ormxmbmx', () => import('@/uiservice/orm-xmbmx/orm-xmbmx-ui-service'));
        this.allUIService.set('parldkhqz', () => import('@/uiservice/par-ldkhqz/par-ldkhqz-ui-service'));
        this.allUIService.set('pimquestions', () => import('@/uiservice/pim-questions/pim-questions-ui-service'));
        this.allUIService.set('salruledetail', () => import('@/uiservice/sal-rule-detail/sal-rule-detail-ui-service'));
        this.allUIService.set('salpersonstddetail', () => import('@/uiservice/salpersonstddetail/salpersonstddetail-ui-service'));
        this.allUIService.set('trmstay', () => import('@/uiservice/trm-stay/trm-stay-ui-service'));
        this.allUIService.set('trmcoursesystem', () => import('@/uiservice/trm-course-system/trm-course-system-ui-service'));
        this.allUIService.set('attensummary', () => import('@/uiservice/att-ensummary/att-ensummary-ui-service'));
        this.allUIService.set('salrule', () => import('@/uiservice/sal-rule/sal-rule-ui-service'));
        this.allUIService.set('ormxmrlcb', () => import('@/uiservice/orm-xmrlcb/orm-xmrlcb-ui-service'));
        this.allUIService.set('personstatemgr', () => import('@/uiservice/person-state-mgr/person-state-mgr-ui-service'));
        this.allUIService.set('ormpostdetails', () => import('@/uiservice/orm-post-details/orm-post-details-ui-service'));
        this.allUIService.set('pimstafftype', () => import('@/uiservice/pim-stafftype/pim-stafftype-ui-service'));
        this.allUIService.set('pcmsgqmgr', () => import('@/uiservice/pcm-sgq-mgr/pcm-sgq-mgr-ui-service'));
        this.allUIService.set('salitemsub', () => import('@/uiservice/sal-item-sub/sal-item-sub-ui-service'));
        this.allUIService.set('pimgwtype', () => import('@/uiservice/pim-gw-type/pim-gw-type-ui-service'));
        this.allUIService.set('ormpostlib', () => import('@/uiservice/orm-post-lib/orm-post-lib-ui-service'));
        this.allUIService.set('pimarchivescenter', () => import('@/uiservice/pim-archives-center/pim-archives-center-ui-service'));
        this.allUIService.set('parjxbzgl', () => import('@/uiservice/par-jxbzgl/par-jxbzgl-ui-service'));
        this.allUIService.set('vacusenxjmx', () => import('@/uiservice/vac-use-nxjmx/vac-use-nxjmx-ui-service'));
        this.allUIService.set('vacsynjcx', () => import('@/uiservice/vac-synjcx/vac-synjcx-ui-service'));
        this.allUIService.set('pcmzpmegl', () => import('@/uiservice/pcm-zpmegl/pcm-zpmegl-ui-service'));
        this.allUIService.set('attensummarymx', () => import('@/uiservice/att-ensummarymx/att-ensummarymx-ui-service'));
        this.allUIService.set('trmhmatser', () => import('@/uiservice/trm-hmatser/trm-hmatser-ui-service'));
        this.allUIService.set('pcmtxfpsq', () => import('@/uiservice/pcm-txfpsq/pcm-txfpsq-ui-service'));
        this.allUIService.set('ormzwdqgz', () => import('@/uiservice/orm-zwdqgz/orm-zwdqgz-ui-service'));
        this.allUIService.set('pcmyddgmx', () => import('@/uiservice/pcm-yddgmx/pcm-yddgmx-ui-service'));
        this.allUIService.set('ormxmbq', () => import('@/uiservice/orm-xmbq/orm-xmbq-ui-service'));
        this.allUIService.set('attendancerecordtemp', () => import('@/uiservice/att-endance-record-temp/att-endance-record-temp-ui-service'));
        this.allUIService.set('pcmgxxktemp', () => import('@/uiservice/pcmgxxk-temp/pcmgxxk-temp-ui-service'));
        this.allUIService.set('pcmrzgl', () => import('@/uiservice/pcm-rzgl/pcm-rzgl-ui-service'));
        this.allUIService.set('trmtrainfillin', () => import('@/uiservice/trm-train-fillin/trm-train-fillin-ui-service'));
        this.allUIService.set('salstdxmgzrate', () => import('@/uiservice/sal-std-xmgz-rate/sal-std-xmgz-rate-ui-service'));
        this.allUIService.set('vacdayoff', () => import('@/uiservice/vac-day-off/vac-day-off-ui-service'));
        this.allUIService.set('trmstaffnodes', () => import('@/uiservice/trm-staffnodes/trm-staffnodes-ui-service'));
        this.allUIService.set('pcmawardswons', () => import('@/uiservice/pcm-awards-wons/pcm-awards-wons-ui-service'));
        this.allUIService.set('trmcouarrange', () => import('@/uiservice/trm-couarrange/trm-couarrange-ui-service'));
        this.allUIService.set('pimrewardpunishment', () => import('@/uiservice/pim-reward-punishment/pim-reward-punishment-ui-service'));
        this.allUIService.set('salstdzj', () => import('@/uiservice/sal-stdzj/sal-stdzj-ui-service'));
        this.allUIService.set('attendancerecord', () => import('@/uiservice/att-endance-record/att-endance-record-ui-service'));
        this.allUIService.set('pimpatent', () => import('@/uiservice/pim-patent/pim-patent-ui-service'));
        this.allUIService.set('trmtrainaddress', () => import('@/uiservice/trm-train-address/trm-train-address-ui-service'));
        this.allUIService.set('pimarchivesmanage', () => import('@/uiservice/pim-archives-manage/pim-archives-manage-ui-service'));
        this.allUIService.set('pcmprofile', () => import('@/uiservice/pcm-profile/pcm-profile-ui-service'));
        this.allUIService.set('trmtrainoutapply', () => import('@/uiservice/trm-train-out-apply/trm-train-out-apply-ui-service'));
        this.allUIService.set('pimarchivalcatalogue', () => import('@/uiservice/pim-archival-catalogue/pim-archival-catalogue-ui-service'));
        this.allUIService.set('parjxqdsz', () => import('@/uiservice/par-jxqdsz/par-jxqdsz-ui-service'));
        this.allUIService.set('vacsituationdetail', () => import('@/uiservice/vac-situation-detail/vac-situation-detail-ui-service'));
        this.allUIService.set('trmtraincourse', () => import('@/uiservice/trm-train-course/trm-train-course-ui-service'));
        this.allUIService.set('parkhfa', () => import('@/uiservice/par-khfa/par-khfa-ui-service'));
        this.allUIService.set('attendenceormorgscetor', () => import('@/uiservice/att-endence-ormorgscetor/att-endence-ormorgscetor-ui-service'));
        this.allUIService.set('trmdutycadres', () => import('@/uiservice/trm-duty-cadres/trm-duty-cadres-ui-service'));
        this.allUIService.set('vacoveralltion', () => import('@/uiservice/vac-overalltion/vac-overalltion-ui-service'));
        this.allUIService.set('partzgg', () => import('@/uiservice/par-tzgg/par-tzgg-ui-service'));
        this.allUIService.set('pcmydntmx', () => import('@/uiservice/pcm-ydntmx/pcm-ydntmx-ui-service'));
        this.allUIService.set('trmgradecadres', () => import('@/uiservice/trm-gradecadres/trm-gradecadres-ui-service'));
        this.allUIService.set('trmlgbdetail', () => import('@/uiservice/trm-lgb-detail/trm-lgb-detail-ui-service'));
        this.allUIService.set('ormrelation', () => import('@/uiservice/orm-relation/orm-relation-ui-service'));
        this.allUIService.set('trmtrainfacies', () => import('@/uiservice/trm-train-facies/trm-train-facies-ui-service'));
        this.allUIService.set('ormsignorg', () => import('@/uiservice/orm-sign-org/orm-sign-org-ui-service'));
        this.allUIService.set('pcmydgzmx', () => import('@/uiservice/pcm-ydgzmx/pcm-ydgzmx-ui-service'));
        this.allUIService.set('attendancesettings', () => import('@/uiservice/att-endance-settings/att-endance-settings-ui-service'));
        this.allUIService.set('salstddszn', () => import('@/uiservice/sal-stddszn/sal-stddszn-ui-service'));
        this.allUIService.set('ormdepestman', () => import('@/uiservice/orm-dep-est-man/orm-dep-est-man-ui-service'));
        this.allUIService.set('ormxmsfhz', () => import('@/uiservice/orm-xmsfhz/orm-xmsfhz-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/orm-duty/orm-duty-ui-service'));
        this.allUIService.set('pcmmspjxx', () => import('@/uiservice/pcm-mspjxx/pcm-mspjxx-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('pimdaterule', () => import('@/uiservice/pim-date-rule/pim-date-rule-ui-service'));
        this.allUIService.set('ormqybzwh', () => import('@/uiservice/orm-qybzwh/orm-qybzwh-ui-service'));
        this.allUIService.set('vacholidayrules', () => import('@/uiservice/vac-holiday-rules/vac-holiday-rules-ui-service'));
        this.allUIService.set('pimworkflowref', () => import('@/uiservice/pim-workflow-ref/pim-workflow-ref-ui-service'));
        this.allUIService.set('parjxkhxhz', () => import('@/uiservice/par-jxkhxhz/par-jxkhxhz-ui-service'));
        this.allUIService.set('pcmxygzzjlmx', () => import('@/uiservice/pcm-xygzzjlmx/pcm-xygzzjlmx-ui-service'));
        this.allUIService.set('vacwfqj', () => import('@/uiservice/vac-wfqj/vac-wfqj-ui-service'));
        this.allUIService.set('pcmjxszzkhjgjl', () => import('@/uiservice/pcm-jxszzkhjgjl/pcm-jxszzkhjgjl-ui-service'));
        this.allUIService.set('salsource', () => import('@/uiservice/sal-source/sal-source-ui-service'));
        this.allUIService.set('pimeducation', () => import('@/uiservice/pim-education/pim-education-ui-service'));
        this.allUIService.set('ormqygl', () => import('@/uiservice/orm-qygl/orm-qygl-ui-service'));
        this.allUIService.set('pcmjxsygzzsqmx', () => import('@/uiservice/pcm-jxsygzzsqmx/pcm-jxsygzzsqmx-ui-service'));
        this.allUIService.set('pimprovince', () => import('@/uiservice/pim-province/pim-province-ui-service'));
        this.allUIService.set('pcmzsgl', () => import('@/uiservice/pcm-zsgl/pcm-zsgl-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/orm-post/orm-post-ui-service'));
        this.allUIService.set('salplan', () => import('@/uiservice/sal-plan/sal-plan-ui-service'));
        this.allUIService.set('pcmzpmeglmx', () => import('@/uiservice/pcm-zpmeglmx/pcm-zpmeglmx-ui-service'));
        this.allUIService.set('parjxbzglmx', () => import('@/uiservice/par-jxbzglmx/par-jxbzglmx-ui-service'));
        this.allUIService.set('salstdgwgz', () => import('@/uiservice/sal-stdgwgz/sal-stdgwgz-ui-service'));
        this.allUIService.set('pimpersonabilitydetail', () => import('@/uiservice/pim-person-ability-detail/pim-person-ability-detail-ui-service'));
        this.allUIService.set('ormxmgl', () => import('@/uiservice/orm-xmgl/orm-xmgl-ui-service'));
        this.allUIService.set('attenmembwes', () => import('@/uiservice/att-enmembwes/att-enmembwes-ui-service'));
        this.allUIService.set('ormerporg', () => import('@/uiservice/orm-erporg/orm-erporg-ui-service'));
        this.allUIService.set('parbmfzjyx', () => import('@/uiservice/par-bmfzjyx/par-bmfzjyx-ui-service'));
        this.allUIService.set('pcmddsqd', () => import('@/uiservice/pcm-ddsqd/pcm-ddsqd-ui-service'));
        this.allUIService.set('pcmjxsgz', () => import('@/uiservice/pcm-jxsgz/pcm-jxsgz-ui-service'));
        this.allUIService.set('vacsituation', () => import('@/uiservice/vac-situation/vac-situation-ui-service'));
        this.allUIService.set('pcmjxsygzzjlmx', () => import('@/uiservice/pcm-jxsygzzjlmx/pcm-jxsygzzjlmx-ui-service'));
        this.allUIService.set('vacsystemapplication', () => import('@/uiservice/vac-system-application/vac-system-application-ui-service'));
        this.allUIService.set('trmzzobm', () => import('@/uiservice/trm-zzobm/trm-zzobm-ui-service'));
        this.allUIService.set('pcmydbxmx', () => import('@/uiservice/pcm-ydbxmx/pcm-ydbxmx-ui-service'));
        this.allUIService.set('pimpaper', () => import('@/uiservice/pim-paper/pim-paper-ui-service'));
        this.allUIService.set('attendrecorddetail', () => import('@/uiservice/attend-record-detail/attend-record-detail-ui-service'));
        this.allUIService.set('pcmxygzzjgwh', () => import('@/uiservice/pcm-xygzzjgwh/pcm-xygzzjgwh-ui-service'));
        this.allUIService.set('salparam', () => import('@/uiservice/sal-param/sal-param-ui-service'));
        this.allUIService.set('parjxlhmb', () => import('@/uiservice/par-jxlhmb/par-jxlhmb-ui-service'));
        this.allUIService.set('pcmxygzzsqmx', () => import('@/uiservice/pcm-xygzzsqmx/pcm-xygzzsqmx-ui-service'));
        this.allUIService.set('pimvocationalcatalog', () => import('@/uiservice/pim-vocational-catalog/pim-vocational-catalog-ui-service'));
        this.allUIService.set('pcmydtxmx', () => import('@/uiservice/pcm-ydtxmx/pcm-ydtxmx-ui-service'));
        this.allUIService.set('pcmpracticeexperience', () => import('@/uiservice/pcm-practice-experience/pcm-practice-experience-ui-service'));
        this.allUIService.set('parfzsmx', () => import('@/uiservice/par-fzsmx/par-fzsmx-ui-service'));
        this.allUIService.set('pimcity', () => import('@/uiservice/pim-city/pim-city-ui-service'));
        this.allUIService.set('pimvocational', () => import('@/uiservice/pim-vocational/pim-vocational-ui-service'));
        this.allUIService.set('pimfaminfo', () => import('@/uiservice/pim-faminfo/pim-faminfo-ui-service'));
        this.allUIService.set('pimenclosure', () => import('@/uiservice/pim-enclosure/pim-enclosure-ui-service'));
        this.allUIService.set('trmtrainresment', () => import('@/uiservice/trm-train-resment/trm-train-resment-ui-service'));
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
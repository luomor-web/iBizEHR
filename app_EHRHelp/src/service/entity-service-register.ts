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
                this.allEntityService.set('sallog', () => import('@/service/sal-log/sal-log-service'));
        this.allEntityService.set('trmdepart', () => import('@/service/trm-depart/trm-depart-service'));
        this.allEntityService.set('trmtrainplanterm', () => import('@/service/trm-train-planterm/trm-train-planterm-service'));
        this.allEntityService.set('salschemeitem', () => import('@/service/sal-scheme-item/sal-scheme-item-service'));
        this.allEntityService.set('trmlgbcost', () => import('@/service/trm-lgb-cost/trm-lgb-cost-service'));
        this.allEntityService.set('pcmjxsygzzsq', () => import('@/service/pcm-jxsygzzsq/pcm-jxsygzzsq-service'));
        this.allEntityService.set('pcmrecruitment', () => import('@/service/pcm-recruitment/pcm-recruitment-service'));
        this.allEntityService.set('pimcorrectionapply', () => import('@/service/pim-correction-apply/pim-correction-apply-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('pcmnotice', () => import('@/service/pcm-notice/pcm-notice-service'));
        this.allEntityService.set('salstdgwgzrate', () => import('@/service/sal-std-gw-gzrate/sal-std-gw-gzrate-service'));
        this.allEntityService.set('pcmydmx', () => import('@/service/pcm-ydmx/pcm-ydmx-service'));
        this.allEntityService.set('pimqualtype', () => import('@/service/pim-qual-type/pim-qual-type-service'));
        this.allEntityService.set('pimmajorsetype', () => import('@/service/pim-major-setype/pim-major-setype-service'));
        this.allEntityService.set('pcmwzd0001', () => import('@/service/pcm-wzd0001/pcm-wzd0001-service'));
        this.allEntityService.set('pimtitle', () => import('@/service/pim-title/pim-title-service'));
        this.allEntityService.set('parlhmbkhmx', () => import('@/service/par-lhmbkhmx/par-lhmbkhmx-service'));
        this.allEntityService.set('attendencesetup', () => import('@/service/att-endence-setup/att-endence-setup-service'));
        this.allEntityService.set('pcmddsqdmx', () => import('@/service/pcm-ddsqdmx/pcm-ddsqdmx-service'));
        this.allEntityService.set('pcmschooloffice', () => import('@/service/pcm-school-office/pcm-school-office-service'));
        this.allEntityService.set('pimtypecontract', () => import('@/service/pim-type-contract/pim-type-contract-service'));
        this.allEntityService.set('trmteachercharge', () => import('@/service/trm-teacher-charge/trm-teacher-charge-service'));
        this.allEntityService.set('salstdzc', () => import('@/service/sal-stdzc/sal-stdzc-service'));
        this.allEntityService.set('pcmxygzzsq', () => import('@/service/pcm-xygzzsq/pcm-xygzzsq-service'));
        this.allEntityService.set('vacworkday', () => import('@/service/vac-work-day/vac-work-day-service'));
        this.allEntityService.set('attendencetype', () => import('@/service/att-endence-type/att-endence-type-service'));
        this.allEntityService.set('pimoutput', () => import('@/service/pim-output/pim-output-service'));
        this.allEntityService.set('parjxzgpc', () => import('@/service/par-jxzgpc/par-jxzgpc-service'));
        this.allEntityService.set('vacsystemhistory', () => import('@/service/vac-system-history/vac-system-history-service'));
        this.allEntityService.set('attendancemreportmx', () => import('@/service/att-endance-mreportmx/att-endance-mreportmx-service'));
        this.allEntityService.set('trmteachertrain', () => import('@/service/trm-teacher-train/trm-teacher-train-service'));
        this.allEntityService.set('parjxkhjcsz', () => import('@/service/par-jxkhjcsz/par-jxkhjcsz-service'));
        this.allEntityService.set('trmtrainperson', () => import('@/service/trm-train-person/trm-train-person-service'));
        this.allEntityService.set('pimarchivesloanandreturn', () => import('@/service/pim-archive-sloanandreturn/pim-archive-sloanandreturn-service'));
        this.allEntityService.set('pcmzjdyzw', () => import('@/service/pcm-zjdyzw/pcm-zjdyzw-service'));
        this.allEntityService.set('pcmrcxl', () => import('@/service/pcm-rcxl/pcm-rcxl-service'));
        this.allEntityService.set('pimbyzzjlmx', () => import('@/service/pim-byzzjlmx/pim-byzzjlmx-service'));
        this.allEntityService.set('ormbmgwbz', () => import('@/service/orm-bmgwbz/orm-bmgwbz-service'));
        this.allEntityService.set('pimcontract', () => import('@/service/pim-contract/pim-contract-service'));
        this.allEntityService.set('saltype', () => import('@/service/sal-type/sal-type-service'));
        this.allEntityService.set('pcmprofileinitnumber', () => import('@/service/pcm-profile-init-number/pcm-profile-init-number-service'));
        this.allEntityService.set('pcmworkresume', () => import('@/service/pcm-work-resume/pcm-work-resume-service'));
        this.allEntityService.set('trmtrainactment', () => import('@/service/trm-train-actment/trm-train-actment-service'));
        this.allEntityService.set('pimsocialsecurity', () => import('@/service/pim-social-security/pim-social-security-service'));
        this.allEntityService.set('pimworkhistory', () => import('@/service/pim-work-history/pim-work-history-service'));
        this.allEntityService.set('ormorgdz', () => import('@/service/orm-orgdz/orm-orgdz-service'));
        this.allEntityService.set('parlhmbmx', () => import('@/service/par-lhmbmx/par-lhmbmx-service'));
        this.allEntityService.set('pimpersonability', () => import('@/service/pim-person-ability/pim-person-ability-service'));
        this.allEntityService.set('trminvoice', () => import('@/service/trm-invoice/trm-invoice-service'));
        this.allEntityService.set('ormtitle', () => import('@/service/orm-title/orm-title-service'));
        this.allEntityService.set('vacleacetype', () => import('@/service/vac-leace-type/vac-leace-type-service'));
        this.allEntityService.set('salstdgw', () => import('@/service/sal-stdgw/sal-stdgw-service'));
        this.allEntityService.set('pimarchiveschange', () => import('@/service/pim-archives-change/pim-archives-change-service'));
        this.allEntityService.set('pcmdetail', () => import('@/service/pcm-detail/pcm-detail-service'));
        this.allEntityService.set('pimexpaccount', () => import('@/service/pim-expaccount/pim-expaccount-service'));
        this.allEntityService.set('pcmsyqgz', () => import('@/service/pcm-syqgz/pcm-syqgz-service'));
        this.allEntityService.set('vacholiday', () => import('@/service/vac-holiday/vac-holiday-service'));
        this.allEntityService.set('salsalarydetail', () => import('@/service/sal-salary-detail/sal-salary-detail-service'));
        this.allEntityService.set('parjxmtfk', () => import('@/service/par-jxmtfk/par-jxmtfk-service'));
        this.allEntityService.set('attendancemreport', () => import('@/service/att-endance-mreport/att-endance-mreport-service'));
        this.allEntityService.set('trmtrainactapply', () => import('@/service/trm-train-actapply/trm-train-actapply-service'));
        this.allEntityService.set('pcmgxml', () => import('@/service/pcm-gxml/pcm-gxml-service'));
        this.allEntityService.set('pcmtxbz', () => import('@/service/pcm-txbz/pcm-txbz-service'));
        this.allEntityService.set('ormxmxqhz', () => import('@/service/orm-xmxqhz/orm-xmxqhz-service'));
        this.allEntityService.set('pimqualmajor', () => import('@/service/pim-qual-major/pim-qual-major-service'));
        this.allEntityService.set('pcmxygzzkhjgjl', () => import('@/service/pcm-xygzzkhjgjl/pcm-xygzzkhjgjl-service'));
        this.allEntityService.set('parjxkhmbmx', () => import('@/service/par-jxkhmbmx/par-jxkhmbmx-service'));
        this.allEntityService.set('vacleavemanage', () => import('@/service/vac-leave-manage/vac-leave-manage-service'));
        this.allEntityService.set('pcmlog', () => import('@/service/pcm-log/pcm-log-service'));
        this.allEntityService.set('pimvacation', () => import('@/service/pim-vacation/pim-vacation-service'));
        this.allEntityService.set('pimexitandentry', () => import('@/service/pim-exitandentry/pim-exitandentry-service'));
        this.allEntityService.set('trmplanformu', () => import('@/service/trm-plan-formu/trm-plan-formu-service'));
        this.allEntityService.set('trmtraindemand', () => import('@/service/trm-train-demand/trm-train-demand-service'));
        this.allEntityService.set('pimpersonchange', () => import('@/service/pim-person-change/pim-person-change-service'));
        this.allEntityService.set('pcmeducationexperience', () => import('@/service/pcm-education-experience/pcm-education-experience-service'));
        this.allEntityService.set('trmtrainplan', () => import('@/service/trm-train-plan/trm-train-plan-service'));
        this.allEntityService.set('pimachievements', () => import('@/service/pim-achievements/pim-achievements-service'));
        this.allEntityService.set('pcmxkml', () => import('@/service/pcm-xkml/pcm-xkml-service'));
        this.allEntityService.set('pimlanguageability', () => import('@/service/pim-language-ability/pim-language-ability-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('trmtraffic', () => import('@/service/trm-traffic/trm-traffic-service'));
        this.allEntityService.set('pimexaminationresults', () => import('@/service/pim-examination-results/pim-examination-results-service'));
        this.allEntityService.set('pimarchives', () => import('@/service/pim-archives/pim-archives-service'));
        this.allEntityService.set('vacleavesystemdtail', () => import('@/service/vac-leave-system-dtail/vac-leave-system-dtail-service'));
        this.allEntityService.set('parjxzgpcmx', () => import('@/service/par-jxzgpcmx/par-jxzgpcmx-service'));
        this.allEntityService.set('ormrank', () => import('@/service/orm-rank/orm-rank-service'));
        this.allEntityService.set('vacleavedetail', () => import('@/service/vac-leave-detail/vac-leave-detail-service'));
        this.allEntityService.set('trmtraindata', () => import('@/service/trm-train-data/trm-train-data-service'));
        this.allEntityService.set('pcmgbhmc', () => import('@/service/pcm-gbhmc/pcm-gbhmc-service'));
        this.allEntityService.set('parjgbmpjbz', () => import('@/service/par-jgbmpjbz/par-jgbmpjbz-service'));
        this.allEntityService.set('parndlhmbkh', () => import('@/service/par-ndlhmbkh/par-ndlhmbkh-service'));
        this.allEntityService.set('pcmydjzmx', () => import('@/service/pcm-ydjzmx/pcm-ydjzmx-service'));
        this.allEntityService.set('pcmtestresult', () => import('@/service/pcm-test-result/pcm-test-result-service'));
        this.allEntityService.set('ormorginfo', () => import('@/service/orm-org-info/orm-org-info-service'));
        this.allEntityService.set('vacinitnxj', () => import('@/service/vac-initnxj/vac-initnxj-service'));
        this.allEntityService.set('salstdzx', () => import('@/service/sal-stdzx/sal-stdzx-service'));
        this.allEntityService.set('pimworkflow', () => import('@/service/pim-workflow/pim-workflow-service'));
        this.allEntityService.set('salitem', () => import('@/service/sal-item/sal-item-service'));
        this.allEntityService.set('trmagencyrecord', () => import('@/service/trm-agency-record/trm-agency-record-service'));
        this.allEntityService.set('ormbmkqdz', () => import('@/service/orm-bmkqdz/orm-bmkqdz-service'));
        this.allEntityService.set('pcmpcmsgqmgr', () => import('@/service/pcm-pcm-sgq-mgr/pcm-pcm-sgq-mgr-service'));
        this.allEntityService.set('trmdepartneeds', () => import('@/service/trm-depart-needs/trm-depart-needs-service'));
        this.allEntityService.set('salstdxmgz', () => import('@/service/sal-std-xmgz/sal-std-xmgz-service'));
        this.allEntityService.set('pcmcsrcmspj', () => import('@/service/pcm-csrcmspj/pcm-csrcmspj-service'));
        this.allEntityService.set('parkhzcmx', () => import('@/service/par-khzcmx/par-khzcmx-service'));
        this.allEntityService.set('salstdzyzg', () => import('@/service/sal-stdzyzg/sal-stdzyzg-service'));
        this.allEntityService.set('pimarchivesrecord', () => import('@/service/pim-archives-record/pim-archives-record-service'));
        this.allEntityService.set('pcmreason', () => import('@/service/pcm-reason/pcm-reason-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('trmdemdeftion', () => import('@/service/trm-demdeftion/trm-demdeftion-service'));
        this.allEntityService.set('parjxjg', () => import('@/service/par-jxjg/par-jxjg-service'));
        this.allEntityService.set('salsubject', () => import('@/service/sal-subject/sal-subject-service'));
        this.allEntityService.set('pcmydlzmx', () => import('@/service/pcm-ydlzmx/pcm-ydlzmx-service'));
        this.allEntityService.set('pimtitlecatalogue', () => import('@/service/pim-title-catalogue/pim-title-catalogue-service'));
        this.allEntityService.set('parxmbpjbz', () => import('@/service/par-xmbpjbz/par-xmbpjbz-service'));
        this.allEntityService.set('vacleavesystem', () => import('@/service/vac-leave-system/vac-leave-system-service'));
        this.allEntityService.set('pcmypzjkxx', () => import('@/service/pcm-ypzjkxx/pcm-ypzjkxx-service'));
        this.allEntityService.set('salstdgl', () => import('@/service/sal-stdgl/sal-stdgl-service'));
        this.allEntityService.set('pimarmycadres', () => import('@/service/pim-armycadres/pim-armycadres-service'));
        this.allEntityService.set('pimbyygzzsq', () => import('@/service/pim-byygzzsq/pim-byygzzsq-service'));
        this.allEntityService.set('trmtrainteacher', () => import('@/service/trm-train-teacher/trm-train-teacher-service'));
        this.allEntityService.set('pcmjxsbdjl', () => import('@/service/pcm-jxsbdjl/pcm-jxsbdjl-service'));
        this.allEntityService.set('trmtrainbuapply', () => import('@/service/trm-train-buapply/trm-train-buapply-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('trmtrainagency', () => import('@/service/trm-train-agency/trm-train-agency-service'));
        this.allEntityService.set('pimresearchfindings', () => import('@/service/pim-research-findings/pim-research-findings-service'));
        this.allEntityService.set('salscheme', () => import('@/service/sal-scheme/sal-scheme-service'));
        this.allEntityService.set('pimlwgz', () => import('@/service/pim-lwgz/pim-lwgz-service'));
        this.allEntityService.set('pimcontracttype', () => import('@/service/pim-contract-type/pim-contract-type-service'));
        this.allEntityService.set('salsalary', () => import('@/service/sal-salary/sal-salary-service'));
        this.allEntityService.set('pcmnorecyclinglibrary', () => import('@/service/pcm-no-recycling-library/pcm-no-recycling-library-service'));
        this.allEntityService.set('attendancedate', () => import('@/service/att-endance-date/att-endance-date-service'));
        this.allEntityService.set('pimnationmgr', () => import('@/service/pim-nation-mgr/pim-nation-mgr-service'));
        this.allEntityService.set('ormxmrypzxq', () => import('@/service/orm-xmrypzxq/orm-xmrypzxq-service'));
        this.allEntityService.set('pcmydjpmx', () => import('@/service/pcm-ydjpmx/pcm-ydjpmx-service'));
        this.allEntityService.set('pimdistirbution', () => import('@/service/pim-distirbution/pim-distirbution-service'));
        this.allEntityService.set('pimlabourcampany', () => import('@/service/pim-labourcampany/pim-labourcampany-service'));
        this.allEntityService.set('pcmydjdmx', () => import('@/service/pcm-ydjdmx/pcm-ydjdmx-service'));
        this.allEntityService.set('pcmtdzwxx', () => import('@/service/pcm-tdzwxx/pcm-tdzwxx-service'));
        this.allEntityService.set('pimcontractsignorg', () => import('@/service/pim-contract-sign-org/pim-contract-sign-org-service'));
        this.allEntityService.set('parjxkhmb', () => import('@/service/par-jxkhmb/par-jxkhmb-service'));
        this.allEntityService.set('salpersonstd', () => import('@/service/sal-person-std/sal-person-std-service'));
        this.allEntityService.set('trmtraindemandsum', () => import('@/service/trm-train-demand-sum/trm-train-demand-sum-service'));
        this.allEntityService.set('salsalarybill', () => import('@/service/sal-salary-bill/sal-salary-bill-service'));
        this.allEntityService.set('parznbmmx', () => import('@/service/par-znbmmx/par-znbmmx-service'));
        this.allEntityService.set('trmemployeeretion', () => import('@/service/trm-employee-retion/trm-employee-retion-service'));
        this.allEntityService.set('parjxndkhjg', () => import('@/service/par-jxndkhjg/par-jxndkhjg-service'));
        this.allEntityService.set('trmstaff', () => import('@/service/trm-staff/trm-staff-service'));
        this.allEntityService.set('ormxmbmx', () => import('@/service/orm-xmbmx/orm-xmbmx-service'));
        this.allEntityService.set('parldkhqz', () => import('@/service/par-ldkhqz/par-ldkhqz-service'));
        this.allEntityService.set('pimquestions', () => import('@/service/pim-questions/pim-questions-service'));
        this.allEntityService.set('salruledetail', () => import('@/service/sal-rule-detail/sal-rule-detail-service'));
        this.allEntityService.set('salpersonstddetail', () => import('@/service/salpersonstddetail/salpersonstddetail-service'));
        this.allEntityService.set('trmstay', () => import('@/service/trm-stay/trm-stay-service'));
        this.allEntityService.set('trmcoursesystem', () => import('@/service/trm-course-system/trm-course-system-service'));
        this.allEntityService.set('attensummary', () => import('@/service/att-ensummary/att-ensummary-service'));
        this.allEntityService.set('salrule', () => import('@/service/sal-rule/sal-rule-service'));
        this.allEntityService.set('ormxmrlcb', () => import('@/service/orm-xmrlcb/orm-xmrlcb-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('ormpostdetails', () => import('@/service/orm-post-details/orm-post-details-service'));
        this.allEntityService.set('pimstafftype', () => import('@/service/pim-stafftype/pim-stafftype-service'));
        this.allEntityService.set('pcmsgqmgr', () => import('@/service/pcm-sgq-mgr/pcm-sgq-mgr-service'));
        this.allEntityService.set('salitemsub', () => import('@/service/sal-item-sub/sal-item-sub-service'));
        this.allEntityService.set('pimgwtype', () => import('@/service/pim-gw-type/pim-gw-type-service'));
        this.allEntityService.set('ormpostlib', () => import('@/service/orm-post-lib/orm-post-lib-service'));
        this.allEntityService.set('pimarchivescenter', () => import('@/service/pim-archives-center/pim-archives-center-service'));
        this.allEntityService.set('parjxbzgl', () => import('@/service/par-jxbzgl/par-jxbzgl-service'));
        this.allEntityService.set('vacusenxjmx', () => import('@/service/vac-use-nxjmx/vac-use-nxjmx-service'));
        this.allEntityService.set('vacsynjcx', () => import('@/service/vac-synjcx/vac-synjcx-service'));
        this.allEntityService.set('pcmzpmegl', () => import('@/service/pcm-zpmegl/pcm-zpmegl-service'));
        this.allEntityService.set('attensummarymx', () => import('@/service/att-ensummarymx/att-ensummarymx-service'));
        this.allEntityService.set('trmhmatser', () => import('@/service/trm-hmatser/trm-hmatser-service'));
        this.allEntityService.set('pcmtxfpsq', () => import('@/service/pcm-txfpsq/pcm-txfpsq-service'));
        this.allEntityService.set('ormzwdqgz', () => import('@/service/orm-zwdqgz/orm-zwdqgz-service'));
        this.allEntityService.set('pcmyddgmx', () => import('@/service/pcm-yddgmx/pcm-yddgmx-service'));
        this.allEntityService.set('ormxmbq', () => import('@/service/orm-xmbq/orm-xmbq-service'));
        this.allEntityService.set('attendancerecordtemp', () => import('@/service/att-endance-record-temp/att-endance-record-temp-service'));
        this.allEntityService.set('pcmgxxktemp', () => import('@/service/pcmgxxk-temp/pcmgxxk-temp-service'));
        this.allEntityService.set('pcmrzgl', () => import('@/service/pcm-rzgl/pcm-rzgl-service'));
        this.allEntityService.set('trmtrainfillin', () => import('@/service/trm-train-fillin/trm-train-fillin-service'));
        this.allEntityService.set('salstdxmgzrate', () => import('@/service/sal-std-xmgz-rate/sal-std-xmgz-rate-service'));
        this.allEntityService.set('vacdayoff', () => import('@/service/vac-day-off/vac-day-off-service'));
        this.allEntityService.set('trmstaffnodes', () => import('@/service/trm-staffnodes/trm-staffnodes-service'));
        this.allEntityService.set('pcmawardswons', () => import('@/service/pcm-awards-wons/pcm-awards-wons-service'));
        this.allEntityService.set('trmcouarrange', () => import('@/service/trm-couarrange/trm-couarrange-service'));
        this.allEntityService.set('pimrewardpunishment', () => import('@/service/pim-reward-punishment/pim-reward-punishment-service'));
        this.allEntityService.set('salstdzj', () => import('@/service/sal-stdzj/sal-stdzj-service'));
        this.allEntityService.set('attendancerecord', () => import('@/service/att-endance-record/att-endance-record-service'));
        this.allEntityService.set('pimpatent', () => import('@/service/pim-patent/pim-patent-service'));
        this.allEntityService.set('trmtrainaddress', () => import('@/service/trm-train-address/trm-train-address-service'));
        this.allEntityService.set('pimarchivesmanage', () => import('@/service/pim-archives-manage/pim-archives-manage-service'));
        this.allEntityService.set('pcmprofile', () => import('@/service/pcm-profile/pcm-profile-service'));
        this.allEntityService.set('trmtrainoutapply', () => import('@/service/trm-train-out-apply/trm-train-out-apply-service'));
        this.allEntityService.set('pimarchivalcatalogue', () => import('@/service/pim-archival-catalogue/pim-archival-catalogue-service'));
        this.allEntityService.set('parjxqdsz', () => import('@/service/par-jxqdsz/par-jxqdsz-service'));
        this.allEntityService.set('vacsituationdetail', () => import('@/service/vac-situation-detail/vac-situation-detail-service'));
        this.allEntityService.set('trmtraincourse', () => import('@/service/trm-train-course/trm-train-course-service'));
        this.allEntityService.set('parkhfa', () => import('@/service/par-khfa/par-khfa-service'));
        this.allEntityService.set('attendenceormorgscetor', () => import('@/service/att-endence-ormorgscetor/att-endence-ormorgscetor-service'));
        this.allEntityService.set('trmdutycadres', () => import('@/service/trm-duty-cadres/trm-duty-cadres-service'));
        this.allEntityService.set('vacoveralltion', () => import('@/service/vac-overalltion/vac-overalltion-service'));
        this.allEntityService.set('partzgg', () => import('@/service/par-tzgg/par-tzgg-service'));
        this.allEntityService.set('pcmydntmx', () => import('@/service/pcm-ydntmx/pcm-ydntmx-service'));
        this.allEntityService.set('trmgradecadres', () => import('@/service/trm-gradecadres/trm-gradecadres-service'));
        this.allEntityService.set('trmlgbdetail', () => import('@/service/trm-lgb-detail/trm-lgb-detail-service'));
        this.allEntityService.set('ormrelation', () => import('@/service/orm-relation/orm-relation-service'));
        this.allEntityService.set('trmtrainfacies', () => import('@/service/trm-train-facies/trm-train-facies-service'));
        this.allEntityService.set('ormsignorg', () => import('@/service/orm-sign-org/orm-sign-org-service'));
        this.allEntityService.set('pcmydgzmx', () => import('@/service/pcm-ydgzmx/pcm-ydgzmx-service'));
        this.allEntityService.set('attendancesettings', () => import('@/service/att-endance-settings/att-endance-settings-service'));
        this.allEntityService.set('salstddszn', () => import('@/service/sal-stddszn/sal-stddszn-service'));
        this.allEntityService.set('ormdepestman', () => import('@/service/orm-dep-est-man/orm-dep-est-man-service'));
        this.allEntityService.set('ormxmsfhz', () => import('@/service/orm-xmsfhz/orm-xmsfhz-service'));
        this.allEntityService.set('ormduty', () => import('@/service/orm-duty/orm-duty-service'));
        this.allEntityService.set('pcmmspjxx', () => import('@/service/pcm-mspjxx/pcm-mspjxx-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('pimdaterule', () => import('@/service/pim-date-rule/pim-date-rule-service'));
        this.allEntityService.set('ormqybzwh', () => import('@/service/orm-qybzwh/orm-qybzwh-service'));
        this.allEntityService.set('vacholidayrules', () => import('@/service/vac-holiday-rules/vac-holiday-rules-service'));
        this.allEntityService.set('pimworkflowref', () => import('@/service/pim-workflow-ref/pim-workflow-ref-service'));
        this.allEntityService.set('parjxkhxhz', () => import('@/service/par-jxkhxhz/par-jxkhxhz-service'));
        this.allEntityService.set('pcmxygzzjlmx', () => import('@/service/pcm-xygzzjlmx/pcm-xygzzjlmx-service'));
        this.allEntityService.set('vacwfqj', () => import('@/service/vac-wfqj/vac-wfqj-service'));
        this.allEntityService.set('pcmjxszzkhjgjl', () => import('@/service/pcm-jxszzkhjgjl/pcm-jxszzkhjgjl-service'));
        this.allEntityService.set('salsource', () => import('@/service/sal-source/sal-source-service'));
        this.allEntityService.set('pimeducation', () => import('@/service/pim-education/pim-education-service'));
        this.allEntityService.set('ormqygl', () => import('@/service/orm-qygl/orm-qygl-service'));
        this.allEntityService.set('pcmjxsygzzsqmx', () => import('@/service/pcm-jxsygzzsqmx/pcm-jxsygzzsqmx-service'));
        this.allEntityService.set('pimprovince', () => import('@/service/pim-province/pim-province-service'));
        this.allEntityService.set('pcmzsgl', () => import('@/service/pcm-zsgl/pcm-zsgl-service'));
        this.allEntityService.set('ormpost', () => import('@/service/orm-post/orm-post-service'));
        this.allEntityService.set('salplan', () => import('@/service/sal-plan/sal-plan-service'));
        this.allEntityService.set('pcmzpmeglmx', () => import('@/service/pcm-zpmeglmx/pcm-zpmeglmx-service'));
        this.allEntityService.set('parjxbzglmx', () => import('@/service/par-jxbzglmx/par-jxbzglmx-service'));
        this.allEntityService.set('salstdgwgz', () => import('@/service/sal-stdgwgz/sal-stdgwgz-service'));
        this.allEntityService.set('pimpersonabilitydetail', () => import('@/service/pim-person-ability-detail/pim-person-ability-detail-service'));
        this.allEntityService.set('ormxmgl', () => import('@/service/orm-xmgl/orm-xmgl-service'));
        this.allEntityService.set('attenmembwes', () => import('@/service/att-enmembwes/att-enmembwes-service'));
        this.allEntityService.set('ormerporg', () => import('@/service/orm-erporg/orm-erporg-service'));
        this.allEntityService.set('parbmfzjyx', () => import('@/service/par-bmfzjyx/par-bmfzjyx-service'));
        this.allEntityService.set('pcmddsqd', () => import('@/service/pcm-ddsqd/pcm-ddsqd-service'));
        this.allEntityService.set('pcmjxsgz', () => import('@/service/pcm-jxsgz/pcm-jxsgz-service'));
        this.allEntityService.set('vacsituation', () => import('@/service/vac-situation/vac-situation-service'));
        this.allEntityService.set('pcmjxsygzzjlmx', () => import('@/service/pcm-jxsygzzjlmx/pcm-jxsygzzjlmx-service'));
        this.allEntityService.set('vacsystemapplication', () => import('@/service/vac-system-application/vac-system-application-service'));
        this.allEntityService.set('trmzzobm', () => import('@/service/trm-zzobm/trm-zzobm-service'));
        this.allEntityService.set('pcmydbxmx', () => import('@/service/pcm-ydbxmx/pcm-ydbxmx-service'));
        this.allEntityService.set('pimpaper', () => import('@/service/pim-paper/pim-paper-service'));
        this.allEntityService.set('attendrecorddetail', () => import('@/service/attend-record-detail/attend-record-detail-service'));
        this.allEntityService.set('pcmxygzzjgwh', () => import('@/service/pcm-xygzzjgwh/pcm-xygzzjgwh-service'));
        this.allEntityService.set('salparam', () => import('@/service/sal-param/sal-param-service'));
        this.allEntityService.set('parjxlhmb', () => import('@/service/par-jxlhmb/par-jxlhmb-service'));
        this.allEntityService.set('pcmxygzzsqmx', () => import('@/service/pcm-xygzzsqmx/pcm-xygzzsqmx-service'));
        this.allEntityService.set('pimvocationalcatalog', () => import('@/service/pim-vocational-catalog/pim-vocational-catalog-service'));
        this.allEntityService.set('pcmydtxmx', () => import('@/service/pcm-ydtxmx/pcm-ydtxmx-service'));
        this.allEntityService.set('pcmpracticeexperience', () => import('@/service/pcm-practice-experience/pcm-practice-experience-service'));
        this.allEntityService.set('parfzsmx', () => import('@/service/par-fzsmx/par-fzsmx-service'));
        this.allEntityService.set('pimcity', () => import('@/service/pim-city/pim-city-service'));
        this.allEntityService.set('pimvocational', () => import('@/service/pim-vocational/pim-vocational-service'));
        this.allEntityService.set('pimfaminfo', () => import('@/service/pim-faminfo/pim-faminfo-service'));
        this.allEntityService.set('pimenclosure', () => import('@/service/pim-enclosure/pim-enclosure-service'));
        this.allEntityService.set('trmtrainresment', () => import('@/service/trm-train-resment/trm-train-resment-service'));
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
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
                this.allUIService.set('pcmprofilespyy', () => import('@/uiservice/pcm-profile-spyy/pcm-profile-spyy-ui-service'));
        this.allUIService.set('pimtypecontract', () => import('@/uiservice/pim-type-contract/pim-type-contract-ui-service'));
        this.allUIService.set('pcmdetail', () => import('@/uiservice/pcm-detail/pcm-detail-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/orm-post/orm-post-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/orm-duty/orm-duty-ui-service'));
        this.allUIService.set('pimarmycadres', () => import('@/uiservice/pim-armycadres/pim-armycadres-ui-service'));
        this.allUIService.set('pimcontract', () => import('@/uiservice/pim-contract/pim-contract-ui-service'));
        this.allUIService.set('ormsignorg', () => import('@/uiservice/orm-sign-org/orm-sign-org-ui-service'));
        this.allUIService.set('pimexitandentry', () => import('@/uiservice/pim-exitandentry/pim-exitandentry-ui-service'));
        this.allUIService.set('pimnationmgr', () => import('@/uiservice/pim-nation-mgr/pim-nation-mgr-ui-service'));
        this.allUIService.set('trmlgbcost', () => import('@/uiservice/trm-lgb-cost/trm-lgb-cost-ui-service'));
        this.allUIService.set('pimachievements', () => import('@/uiservice/pim-achievements/pim-achievements-ui-service'));
        this.allUIService.set('pimenclosure', () => import('@/uiservice/pim-enclosure/pim-enclosure-ui-service'));
        this.allUIService.set('pimworkhistory', () => import('@/uiservice/pim-work-history/pim-work-history-ui-service'));
        this.allUIService.set('pcmxkml', () => import('@/uiservice/pcm-xkml/pcm-xkml-ui-service'));
        this.allUIService.set('pimexaminationresults', () => import('@/uiservice/pim-examination-results/pim-examination-results-ui-service'));
        this.allUIService.set('pimarchivesrecord', () => import('@/uiservice/pim-archives-record/pim-archives-record-ui-service'));
        this.allUIService.set('attendancemreportmx', () => import('@/uiservice/att-endance-mreportmx/att-endance-mreportmx-ui-service'));
        this.allUIService.set('pimarchivesmanage', () => import('@/uiservice/pim-archives-manage/pim-archives-manage-ui-service'));
        this.allUIService.set('pimarchives', () => import('@/uiservice/pim-archives/pim-archives-ui-service'));
        this.allUIService.set('vacleacetype', () => import('@/uiservice/vac-leace-type/vac-leace-type-ui-service'));
        this.allUIService.set('saltype', () => import('@/uiservice/sal-type/sal-type-ui-service'));
        this.allUIService.set('pimsearchfieldset', () => import('@/uiservice/pim-search-field-set/pim-search-field-set-ui-service'));
        this.allUIService.set('pimresearchfindings', () => import('@/uiservice/pim-research-findings/pim-research-findings-ui-service'));
        this.allUIService.set('pimarchivescenter', () => import('@/uiservice/pim-archives-center/pim-archives-center-ui-service'));
        this.allUIService.set('pimdistirbution', () => import('@/uiservice/pim-distirbution/pim-distirbution-ui-service'));
        this.allUIService.set('dynadashboard', () => import('@/uiservice/dyna-dashboard/dyna-dashboard-ui-service'));
        this.allUIService.set('pimmajorsetype', () => import('@/uiservice/pim-major-setype/pim-major-setype-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('dynachart', () => import('@/uiservice/dyna-chart/dyna-chart-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('pimcontracttype', () => import('@/uiservice/pim-contract-type/pim-contract-type-ui-service'));
        this.allUIService.set('pcmjxsgz', () => import('@/uiservice/pcm-jxsgz/pcm-jxsgz-ui-service'));
        this.allUIService.set('pimpersonability', () => import('@/uiservice/pim-person-ability/pim-person-ability-ui-service'));
        this.allUIService.set('pimvocational', () => import('@/uiservice/pim-vocational/pim-vocational-ui-service'));
        this.allUIService.set('pimpaper', () => import('@/uiservice/pim-paper/pim-paper-ui-service'));
        this.allUIService.set('pimsocialsecurity', () => import('@/uiservice/pim-social-security/pim-social-security-ui-service'));
        this.allUIService.set('pimfilebatvhupload', () => import('@/uiservice/pim-filebatvhupload/pim-filebatvhupload-ui-service'));
        this.allUIService.set('pimoutput', () => import('@/uiservice/pim-output/pim-output-ui-service'));
        this.allUIService.set('pimvacation', () => import('@/uiservice/pim-vacation/pim-vacation-ui-service'));
        this.allUIService.set('pimarchiveschange', () => import('@/uiservice/pim-archives-change/pim-archives-change-ui-service'));
        this.allUIService.set('pimstafftype', () => import('@/uiservice/pim-stafftype/pim-stafftype-ui-service'));
        this.allUIService.set('pimqualtype', () => import('@/uiservice/pim-qual-type/pim-qual-type-ui-service'));
        this.allUIService.set('pimfaminfo', () => import('@/uiservice/pim-faminfo/pim-faminfo-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('pimtitlecatalogue', () => import('@/uiservice/pim-title-catalogue/pim-title-catalogue-ui-service'));
        this.allUIService.set('ormuser', () => import('@/uiservice/orm-user/orm-user-ui-service'));
        this.allUIService.set('pimpatent', () => import('@/uiservice/pim-patent/pim-patent-ui-service'));
        this.allUIService.set('pimlwgz', () => import('@/uiservice/pim-lwgz/pim-lwgz-ui-service'));
        this.allUIService.set('pimeducation', () => import('@/uiservice/pim-education/pim-education-ui-service'));
        this.allUIService.set('pimvocationalcatalog', () => import('@/uiservice/pim-vocational-catalog/pim-vocational-catalog-ui-service'));
        this.allUIService.set('pimcity', () => import('@/uiservice/pim-city/pim-city-ui-service'));
        this.allUIService.set('pcmreason', () => import('@/uiservice/pcm-reason/pcm-reason-ui-service'));
        this.allUIService.set('pimcontractsignorg', () => import('@/uiservice/pim-contract-sign-org/pim-contract-sign-org-ui-service'));
        this.allUIService.set('ormrank', () => import('@/uiservice/orm-rank/orm-rank-ui-service'));
        this.allUIService.set('pimrewardpunishment', () => import('@/uiservice/pim-reward-punishment/pim-reward-punishment-ui-service'));
        this.allUIService.set('pimexpaccount', () => import('@/uiservice/pim-expaccount/pim-expaccount-ui-service'));
        this.allUIService.set('pimprovince', () => import('@/uiservice/pim-province/pim-province-ui-service'));
        this.allUIService.set('pcmrcxl', () => import('@/uiservice/pcm-rcxl/pcm-rcxl-ui-service'));
        this.allUIService.set('pimqualmajor', () => import('@/uiservice/pim-qual-major/pim-qual-major-ui-service'));
        this.allUIService.set('parjxndkhjg', () => import('@/uiservice/par-jxndkhjg/par-jxndkhjg-ui-service'));
        this.allUIService.set('pimcorrectionapply', () => import('@/uiservice/pim-correction-apply/pim-correction-apply-ui-service'));
        this.allUIService.set('pimarchivalcatalogue', () => import('@/uiservice/pim-archival-catalogue/pim-archival-catalogue-ui-service'));
        this.allUIService.set('pimpersonchange', () => import('@/uiservice/pim-person-change/pim-person-change-ui-service'));
        this.allUIService.set('personstatemgr', () => import('@/uiservice/person-state-mgr/person-state-mgr-ui-service'));
        this.allUIService.set('pimarchivesloanandreturn', () => import('@/uiservice/pim-archive-sloanandreturn/pim-archive-sloanandreturn-ui-service'));
        this.allUIService.set('pimgwtype', () => import('@/uiservice/pim-gw-type/pim-gw-type-ui-service'));
        this.allUIService.set('pimsearchmodal', () => import('@/uiservice/pim-search-modal/pim-search-modal-ui-service'));
        this.allUIService.set('pimtitle', () => import('@/uiservice/pim-title/pim-title-ui-service'));
        this.allUIService.set('pimlanguageability', () => import('@/uiservice/pim-language-ability/pim-language-ability-ui-service'));
        this.allUIService.set('pimlabourcampany', () => import('@/uiservice/pim-labourcampany/pim-labourcampany-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('pimpersonabilitydetail', () => import('@/uiservice/pim-person-ability-detail/pim-person-ability-detail-ui-service'));
        this.allUIService.set('trmtrainperson', () => import('@/uiservice/trm-train-person/trm-train-person-ui-service'));
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
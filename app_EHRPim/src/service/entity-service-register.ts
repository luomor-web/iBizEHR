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
                this.allEntityService.set('pcmprofilespyy', () => import('@/service/pcm-profile-spyy/pcm-profile-spyy-service'));
        this.allEntityService.set('pimtypecontract', () => import('@/service/pim-type-contract/pim-type-contract-service'));
        this.allEntityService.set('pcmdetail', () => import('@/service/pcm-detail/pcm-detail-service'));
        this.allEntityService.set('ormpost', () => import('@/service/orm-post/orm-post-service'));
        this.allEntityService.set('ormduty', () => import('@/service/orm-duty/orm-duty-service'));
        this.allEntityService.set('pimarmycadres', () => import('@/service/pim-armycadres/pim-armycadres-service'));
        this.allEntityService.set('pimcontract', () => import('@/service/pim-contract/pim-contract-service'));
        this.allEntityService.set('ormsignorg', () => import('@/service/orm-sign-org/orm-sign-org-service'));
        this.allEntityService.set('pimexitandentry', () => import('@/service/pim-exitandentry/pim-exitandentry-service'));
        this.allEntityService.set('pimnationmgr', () => import('@/service/pim-nation-mgr/pim-nation-mgr-service'));
        this.allEntityService.set('trmlgbcost', () => import('@/service/trm-lgb-cost/trm-lgb-cost-service'));
        this.allEntityService.set('pimachievements', () => import('@/service/pim-achievements/pim-achievements-service'));
        this.allEntityService.set('pimenclosure', () => import('@/service/pim-enclosure/pim-enclosure-service'));
        this.allEntityService.set('pimworkhistory', () => import('@/service/pim-work-history/pim-work-history-service'));
        this.allEntityService.set('pcmxkml', () => import('@/service/pcm-xkml/pcm-xkml-service'));
        this.allEntityService.set('pimexaminationresults', () => import('@/service/pim-examination-results/pim-examination-results-service'));
        this.allEntityService.set('pimarchivesrecord', () => import('@/service/pim-archives-record/pim-archives-record-service'));
        this.allEntityService.set('attendancemreportmx', () => import('@/service/att-endance-mreportmx/att-endance-mreportmx-service'));
        this.allEntityService.set('pimarchivesmanage', () => import('@/service/pim-archives-manage/pim-archives-manage-service'));
        this.allEntityService.set('pimarchives', () => import('@/service/pim-archives/pim-archives-service'));
        this.allEntityService.set('vacleacetype', () => import('@/service/vac-leace-type/vac-leace-type-service'));
        this.allEntityService.set('saltype', () => import('@/service/sal-type/sal-type-service'));
        this.allEntityService.set('pimsearchfieldset', () => import('@/service/pim-search-field-set/pim-search-field-set-service'));
        this.allEntityService.set('pimresearchfindings', () => import('@/service/pim-research-findings/pim-research-findings-service'));
        this.allEntityService.set('pimarchivescenter', () => import('@/service/pim-archives-center/pim-archives-center-service'));
        this.allEntityService.set('pimdistirbution', () => import('@/service/pim-distirbution/pim-distirbution-service'));
        this.allEntityService.set('dynadashboard', () => import('@/service/dyna-dashboard/dyna-dashboard-service'));
        this.allEntityService.set('pimmajorsetype', () => import('@/service/pim-major-setype/pim-major-setype-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('dynachart', () => import('@/service/dyna-chart/dyna-chart-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('pimcontracttype', () => import('@/service/pim-contract-type/pim-contract-type-service'));
        this.allEntityService.set('pcmjxsgz', () => import('@/service/pcm-jxsgz/pcm-jxsgz-service'));
        this.allEntityService.set('pimpersonability', () => import('@/service/pim-person-ability/pim-person-ability-service'));
        this.allEntityService.set('pimvocational', () => import('@/service/pim-vocational/pim-vocational-service'));
        this.allEntityService.set('pimpaper', () => import('@/service/pim-paper/pim-paper-service'));
        this.allEntityService.set('pimsocialsecurity', () => import('@/service/pim-social-security/pim-social-security-service'));
        this.allEntityService.set('pimfilebatvhupload', () => import('@/service/pim-filebatvhupload/pim-filebatvhupload-service'));
        this.allEntityService.set('pimoutput', () => import('@/service/pim-output/pim-output-service'));
        this.allEntityService.set('pimvacation', () => import('@/service/pim-vacation/pim-vacation-service'));
        this.allEntityService.set('pimarchiveschange', () => import('@/service/pim-archives-change/pim-archives-change-service'));
        this.allEntityService.set('pimstafftype', () => import('@/service/pim-stafftype/pim-stafftype-service'));
        this.allEntityService.set('pimqualtype', () => import('@/service/pim-qual-type/pim-qual-type-service'));
        this.allEntityService.set('pimfaminfo', () => import('@/service/pim-faminfo/pim-faminfo-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('pimtitlecatalogue', () => import('@/service/pim-title-catalogue/pim-title-catalogue-service'));
        this.allEntityService.set('ormuser', () => import('@/service/orm-user/orm-user-service'));
        this.allEntityService.set('pimpatent', () => import('@/service/pim-patent/pim-patent-service'));
        this.allEntityService.set('pimlwgz', () => import('@/service/pim-lwgz/pim-lwgz-service'));
        this.allEntityService.set('pimeducation', () => import('@/service/pim-education/pim-education-service'));
        this.allEntityService.set('pimvocationalcatalog', () => import('@/service/pim-vocational-catalog/pim-vocational-catalog-service'));
        this.allEntityService.set('pimcity', () => import('@/service/pim-city/pim-city-service'));
        this.allEntityService.set('pcmreason', () => import('@/service/pcm-reason/pcm-reason-service'));
        this.allEntityService.set('pimcontractsignorg', () => import('@/service/pim-contract-sign-org/pim-contract-sign-org-service'));
        this.allEntityService.set('ormrank', () => import('@/service/orm-rank/orm-rank-service'));
        this.allEntityService.set('pimrewardpunishment', () => import('@/service/pim-reward-punishment/pim-reward-punishment-service'));
        this.allEntityService.set('pimexpaccount', () => import('@/service/pim-expaccount/pim-expaccount-service'));
        this.allEntityService.set('pimprovince', () => import('@/service/pim-province/pim-province-service'));
        this.allEntityService.set('pcmrcxl', () => import('@/service/pcm-rcxl/pcm-rcxl-service'));
        this.allEntityService.set('pimqualmajor', () => import('@/service/pim-qual-major/pim-qual-major-service'));
        this.allEntityService.set('parjxndkhjg', () => import('@/service/par-jxndkhjg/par-jxndkhjg-service'));
        this.allEntityService.set('pimcorrectionapply', () => import('@/service/pim-correction-apply/pim-correction-apply-service'));
        this.allEntityService.set('pimarchivalcatalogue', () => import('@/service/pim-archival-catalogue/pim-archival-catalogue-service'));
        this.allEntityService.set('pimpersonchange', () => import('@/service/pim-person-change/pim-person-change-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('pimarchivesloanandreturn', () => import('@/service/pim-archive-sloanandreturn/pim-archive-sloanandreturn-service'));
        this.allEntityService.set('pimgwtype', () => import('@/service/pim-gw-type/pim-gw-type-service'));
        this.allEntityService.set('pimsearchmodal', () => import('@/service/pim-search-modal/pim-search-modal-service'));
        this.allEntityService.set('pimtitle', () => import('@/service/pim-title/pim-title-service'));
        this.allEntityService.set('pimlanguageability', () => import('@/service/pim-language-ability/pim-language-ability-service'));
        this.allEntityService.set('pimlabourcampany', () => import('@/service/pim-labourcampany/pim-labourcampany-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('pimpersonabilitydetail', () => import('@/service/pim-person-ability-detail/pim-person-ability-detail-service'));
        this.allEntityService.set('trmtrainperson', () => import('@/service/trm-train-person/trm-train-person-service'));
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
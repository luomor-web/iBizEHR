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
                this.allEntityService.set('pcmprofilespyy', () => import('@/service/pcmprofilespyy/pcmprofilespyy-service'));
        this.allEntityService.set('pimtypecontract', () => import('@/service/pimtypecontract/pimtypecontract-service'));
        this.allEntityService.set('pcmdetail', () => import('@/service/pcmdetail/pcmdetail-service'));
        this.allEntityService.set('ormpost', () => import('@/service/ormpost/ormpost-service'));
        this.allEntityService.set('ormduty', () => import('@/service/ormduty/ormduty-service'));
        this.allEntityService.set('pimarmycadres', () => import('@/service/pimarmycadres/pimarmycadres-service'));
        this.allEntityService.set('pimcontract', () => import('@/service/pimcontract/pimcontract-service'));
        this.allEntityService.set('ormsignorg', () => import('@/service/orm-sign-org/orm-sign-org-service'));
        this.allEntityService.set('pimexitandentry', () => import('@/service/pimexitandentry/pimexitandentry-service'));
        this.allEntityService.set('nationmgr', () => import('@/service/nation-mgr/nation-mgr-service'));
        this.allEntityService.set('trmlgbcost', () => import('@/service/trmlgbcost/trmlgbcost-service'));
        this.allEntityService.set('pimachievements', () => import('@/service/pimachievements/pimachievements-service'));
        this.allEntityService.set('pimenclosure', () => import('@/service/pimenclosure/pimenclosure-service'));
        this.allEntityService.set('pimworkhistory', () => import('@/service/pimworkhistory/pimworkhistory-service'));
        this.allEntityService.set('pcmxkml', () => import('@/service/pcmxkml/pcmxkml-service'));
        this.allEntityService.set('pimexaminationresults', () => import('@/service/pimexaminationresults/pimexaminationresults-service'));
        this.allEntityService.set('pimarchivesrecord', () => import('@/service/pimarchivesrecord/pimarchivesrecord-service'));
        this.allEntityService.set('attendancemreportmx', () => import('@/service/attendancemreportmx/attendancemreportmx-service'));
        this.allEntityService.set('archivesmanage', () => import('@/service/archivesmanage/archivesmanage-service'));
        this.allEntityService.set('pimarchives', () => import('@/service/pimarchives/pimarchives-service'));
        this.allEntityService.set('vacleacetype', () => import('@/service/vacleacetype/vacleacetype-service'));
        this.allEntityService.set('saltype', () => import('@/service/saltype/saltype-service'));
        this.allEntityService.set('pimsearchfieldset', () => import('@/service/pim-search-field-set/pim-search-field-set-service'));
        this.allEntityService.set('pimresearchfindings', () => import('@/service/pimresearchfindings/pimresearchfindings-service'));
        this.allEntityService.set('archivescenter', () => import('@/service/archivescenter/archivescenter-service'));
        this.allEntityService.set('pimdistirbution', () => import('@/service/pimdistirbution/pimdistirbution-service'));
        this.allEntityService.set('dynadashboard', () => import('@/service/dyna-dashboard/dyna-dashboard-service'));
        this.allEntityService.set('pimmajorsetype', () => import('@/service/pimmajorsetype/pimmajorsetype-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('dynachart', () => import('@/service/dyna-chart/dyna-chart-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('pimcontracttype', () => import('@/service/pimcontracttype/pimcontracttype-service'));
        this.allEntityService.set('pcmjxsgz', () => import('@/service/pcmjxsgz/pcmjxsgz-service'));
        this.allEntityService.set('pimpersonability', () => import('@/service/pimperson-ability/pimperson-ability-service'));
        this.allEntityService.set('pimvocational', () => import('@/service/pimvocational/pimvocational-service'));
        this.allEntityService.set('pimpaper', () => import('@/service/pimpaper/pimpaper-service'));
        this.allEntityService.set('pimsocialsecurity', () => import('@/service/pimsocialsecurity/pimsocialsecurity-service'));
        this.allEntityService.set('pimfilebatvhupload', () => import('@/service/pimfilebatvhupload/pimfilebatvhupload-service'));
        this.allEntityService.set('pimoutput', () => import('@/service/pimoutput/pimoutput-service'));
        this.allEntityService.set('pimvacation', () => import('@/service/pimvacation/pimvacation-service'));
        this.allEntityService.set('pimarchiveschange', () => import('@/service/pimarchiveschange/pimarchiveschange-service'));
        this.allEntityService.set('pimstafftype', () => import('@/service/pimstafftype/pimstafftype-service'));
        this.allEntityService.set('pimqualtype', () => import('@/service/pimqualtype/pimqualtype-service'));
        this.allEntityService.set('pimfaminfo', () => import('@/service/pimfaminfo/pimfaminfo-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pimperson/pimperson-service'));
        this.allEntityService.set('pimtitlecatalogue', () => import('@/service/pimtitlecatalogue/pimtitlecatalogue-service'));
        this.allEntityService.set('ormuser', () => import('@/service/ormuser/ormuser-service'));
        this.allEntityService.set('pimpatent', () => import('@/service/pimpatent/pimpatent-service'));
        this.allEntityService.set('pimlwgz', () => import('@/service/pimlwgz/pimlwgz-service'));
        this.allEntityService.set('pimeducation', () => import('@/service/pimeducation/pimeducation-service'));
        this.allEntityService.set('pimvocationalcatalog', () => import('@/service/pimvocationalcatalog/pimvocationalcatalog-service'));
        this.allEntityService.set('pimcity', () => import('@/service/pimcity/pimcity-service'));
        this.allEntityService.set('pcmreason', () => import('@/service/pcmreason/pcmreason-service'));
        this.allEntityService.set('contractsignorg', () => import('@/service/contract-sign-org/contract-sign-org-service'));
        this.allEntityService.set('ormrank', () => import('@/service/ormrank/ormrank-service'));
        this.allEntityService.set('pimrewardpunishment', () => import('@/service/pimrewardpunishment/pimrewardpunishment-service'));
        this.allEntityService.set('pimexpaccount', () => import('@/service/pimexpaccount/pimexpaccount-service'));
        this.allEntityService.set('pimprovince', () => import('@/service/pimprovince/pimprovince-service'));
        this.allEntityService.set('pcmrcxl', () => import('@/service/pcmrcxl/pcmrcxl-service'));
        this.allEntityService.set('pimqualmajor', () => import('@/service/pimqualmajor/pimqualmajor-service'));
        this.allEntityService.set('parjxndkhjg', () => import('@/service/parjxndkhjg/parjxndkhjg-service'));
        this.allEntityService.set('pimcorrectionapply', () => import('@/service/pimcorrectionapply/pimcorrectionapply-service'));
        this.allEntityService.set('archivalcatalogue', () => import('@/service/archivalcatalogue/archivalcatalogue-service'));
        this.allEntityService.set('pimpersonchange', () => import('@/service/pimpersonchange/pimpersonchange-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('pimarchivesloanandreturn', () => import('@/service/pimarchivesloanandreturn/pimarchivesloanandreturn-service'));
        this.allEntityService.set('pimgwtype', () => import('@/service/pimgwtype/pimgwtype-service'));
        this.allEntityService.set('pimsearchmodal', () => import('@/service/pim-search-modal/pim-search-modal-service'));
        this.allEntityService.set('pimtitle', () => import('@/service/pimtitle/pimtitle-service'));
        this.allEntityService.set('pimlanguageability', () => import('@/service/pimlanguageability/pimlanguageability-service'));
        this.allEntityService.set('pimlabourcampany', () => import('@/service/pimlabourcampany/pimlabourcampany-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('pimpersonabilitydetail', () => import('@/service/pimperson-ability-detail/pimperson-ability-detail-service'));
        this.allEntityService.set('trmtrianperson', () => import('@/service/trmtrianperson/trmtrianperson-service'));
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
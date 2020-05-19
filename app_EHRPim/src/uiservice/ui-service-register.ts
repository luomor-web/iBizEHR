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
                this.allUIService.set('pcmprofilespyy', () => import('@/uiservice/pcmprofilespyy/pcmprofilespyy-ui-service'));
        this.allUIService.set('pimtypecontract', () => import('@/uiservice/pimtypecontract/pimtypecontract-ui-service'));
        this.allUIService.set('pcmdetail', () => import('@/uiservice/pcmdetail/pcmdetail-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/ormpost/ormpost-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/ormduty/ormduty-ui-service'));
        this.allUIService.set('pimarmycadres', () => import('@/uiservice/pimarmycadres/pimarmycadres-ui-service'));
        this.allUIService.set('pimcontract', () => import('@/uiservice/pimcontract/pimcontract-ui-service'));
        this.allUIService.set('ormsignorg', () => import('@/uiservice/orm-sign-org/orm-sign-org-ui-service'));
        this.allUIService.set('pimexitandentry', () => import('@/uiservice/pimexitandentry/pimexitandentry-ui-service'));
        this.allUIService.set('nationmgr', () => import('@/uiservice/nation-mgr/nation-mgr-ui-service'));
        this.allUIService.set('trmlgbcost', () => import('@/uiservice/trmlgbcost/trmlgbcost-ui-service'));
        this.allUIService.set('pimachievements', () => import('@/uiservice/pimachievements/pimachievements-ui-service'));
        this.allUIService.set('pimenclosure', () => import('@/uiservice/pimenclosure/pimenclosure-ui-service'));
        this.allUIService.set('pimworkhistory', () => import('@/uiservice/pimworkhistory/pimworkhistory-ui-service'));
        this.allUIService.set('pcmxkml', () => import('@/uiservice/pcmxkml/pcmxkml-ui-service'));
        this.allUIService.set('pimexaminationresults', () => import('@/uiservice/pimexaminationresults/pimexaminationresults-ui-service'));
        this.allUIService.set('pimarchivesrecord', () => import('@/uiservice/pimarchivesrecord/pimarchivesrecord-ui-service'));
        this.allUIService.set('attendancemreportmx', () => import('@/uiservice/attendancemreportmx/attendancemreportmx-ui-service'));
        this.allUIService.set('archivesmanage', () => import('@/uiservice/archivesmanage/archivesmanage-ui-service'));
        this.allUIService.set('pimarchives', () => import('@/uiservice/pimarchives/pimarchives-ui-service'));
        this.allUIService.set('vacleacetype', () => import('@/uiservice/vacleacetype/vacleacetype-ui-service'));
        this.allUIService.set('saltype', () => import('@/uiservice/saltype/saltype-ui-service'));
        this.allUIService.set('pimsearchfieldset', () => import('@/uiservice/pim-search-field-set/pim-search-field-set-ui-service'));
        this.allUIService.set('pimresearchfindings', () => import('@/uiservice/pimresearchfindings/pimresearchfindings-ui-service'));
        this.allUIService.set('archivescenter', () => import('@/uiservice/archivescenter/archivescenter-ui-service'));
        this.allUIService.set('pimdistirbution', () => import('@/uiservice/pimdistirbution/pimdistirbution-ui-service'));
        this.allUIService.set('dynadashboard', () => import('@/uiservice/dyna-dashboard/dyna-dashboard-ui-service'));
        this.allUIService.set('pimmajorsetype', () => import('@/uiservice/pimmajorsetype/pimmajorsetype-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/ormorgsector/ormorgsector-ui-service'));
        this.allUIService.set('dynachart', () => import('@/uiservice/dyna-chart/dyna-chart-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/ormorg/ormorg-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('pimcontracttype', () => import('@/uiservice/pimcontracttype/pimcontracttype-ui-service'));
        this.allUIService.set('pcmjxsgz', () => import('@/uiservice/pcmjxsgz/pcmjxsgz-ui-service'));
        this.allUIService.set('pimpersonability', () => import('@/uiservice/pimperson-ability/pimperson-ability-ui-service'));
        this.allUIService.set('pimvocational', () => import('@/uiservice/pimvocational/pimvocational-ui-service'));
        this.allUIService.set('pimpaper', () => import('@/uiservice/pimpaper/pimpaper-ui-service'));
        this.allUIService.set('pimsocialsecurity', () => import('@/uiservice/pimsocialsecurity/pimsocialsecurity-ui-service'));
        this.allUIService.set('pimfilebatvhupload', () => import('@/uiservice/pimfilebatvhupload/pimfilebatvhupload-ui-service'));
        this.allUIService.set('pimoutput', () => import('@/uiservice/pimoutput/pimoutput-ui-service'));
        this.allUIService.set('pimvacation', () => import('@/uiservice/pimvacation/pimvacation-ui-service'));
        this.allUIService.set('pimarchiveschange', () => import('@/uiservice/pimarchiveschange/pimarchiveschange-ui-service'));
        this.allUIService.set('pimstafftype', () => import('@/uiservice/pimstafftype/pimstafftype-ui-service'));
        this.allUIService.set('pimqualtype', () => import('@/uiservice/pimqualtype/pimqualtype-ui-service'));
        this.allUIService.set('pimfaminfo', () => import('@/uiservice/pimfaminfo/pimfaminfo-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pimperson/pimperson-ui-service'));
        this.allUIService.set('pimtitlecatalogue', () => import('@/uiservice/pimtitlecatalogue/pimtitlecatalogue-ui-service'));
        this.allUIService.set('pimpatent', () => import('@/uiservice/pimpatent/pimpatent-ui-service'));
        this.allUIService.set('pimlwgz', () => import('@/uiservice/pimlwgz/pimlwgz-ui-service'));
        this.allUIService.set('pimeducation', () => import('@/uiservice/pimeducation/pimeducation-ui-service'));
        this.allUIService.set('pimvocationalcatalog', () => import('@/uiservice/pimvocationalcatalog/pimvocationalcatalog-ui-service'));
        this.allUIService.set('pimcity', () => import('@/uiservice/pimcity/pimcity-ui-service'));
        this.allUIService.set('pcmreason', () => import('@/uiservice/pcmreason/pcmreason-ui-service'));
        this.allUIService.set('contractsignorg', () => import('@/uiservice/contract-sign-org/contract-sign-org-ui-service'));
        this.allUIService.set('ormrank', () => import('@/uiservice/ormrank/ormrank-ui-service'));
        this.allUIService.set('pimrewardpunishment', () => import('@/uiservice/pimrewardpunishment/pimrewardpunishment-ui-service'));
        this.allUIService.set('pimexpaccount', () => import('@/uiservice/pimexpaccount/pimexpaccount-ui-service'));
        this.allUIService.set('pimprovince', () => import('@/uiservice/pimprovince/pimprovince-ui-service'));
        this.allUIService.set('pcmrcxl', () => import('@/uiservice/pcmrcxl/pcmrcxl-ui-service'));
        this.allUIService.set('pimqualmajor', () => import('@/uiservice/pimqualmajor/pimqualmajor-ui-service'));
        this.allUIService.set('parjxndkhjg', () => import('@/uiservice/parjxndkhjg/parjxndkhjg-ui-service'));
        this.allUIService.set('pimcorrectionapply', () => import('@/uiservice/pimcorrectionapply/pimcorrectionapply-ui-service'));
        this.allUIService.set('archivalcatalogue', () => import('@/uiservice/archivalcatalogue/archivalcatalogue-ui-service'));
        this.allUIService.set('pimpersonchange', () => import('@/uiservice/pimpersonchange/pimpersonchange-ui-service'));
        this.allUIService.set('personstatemgr', () => import('@/uiservice/person-state-mgr/person-state-mgr-ui-service'));
        this.allUIService.set('pimarchivesloanandreturn', () => import('@/uiservice/pimarchivesloanandreturn/pimarchivesloanandreturn-ui-service'));
        this.allUIService.set('pimgwtype', () => import('@/uiservice/pimgwtype/pimgwtype-ui-service'));
        this.allUIService.set('pimsearchmodal', () => import('@/uiservice/pim-search-modal/pim-search-modal-ui-service'));
        this.allUIService.set('pimtitle', () => import('@/uiservice/pimtitle/pimtitle-ui-service'));
        this.allUIService.set('pimlanguageability', () => import('@/uiservice/pimlanguageability/pimlanguageability-ui-service'));
        this.allUIService.set('pimlabourcampany', () => import('@/uiservice/pimlabourcampany/pimlabourcampany-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('pimpersonabilitydetail', () => import('@/uiservice/pimperson-ability-detail/pimperson-ability-detail-ui-service'));
        this.allUIService.set('trmtrianperson', () => import('@/uiservice/trmtrianperson/trmtrianperson-ui-service'));
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
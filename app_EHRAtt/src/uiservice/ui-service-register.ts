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
                this.allUIService.set('attendencetype', () => import('@/uiservice/att-endence-type/att-endence-type-ui-service'));
        this.allUIService.set('vacleavedetail', () => import('@/uiservice/vac-leave-detail/vac-leave-detail-ui-service'));
        this.allUIService.set('personstatemgr', () => import('@/uiservice/person-state-mgr/person-state-mgr-ui-service'));
        this.allUIService.set('vacleavetips', () => import('@/uiservice/vac-leave-tips/vac-leave-tips-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('attendancemreport', () => import('@/uiservice/att-endance-mreport/att-endance-mreport-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('vacholidayrules', () => import('@/uiservice/vac-holiday-rules/vac-holiday-rules-ui-service'));
        this.allUIService.set('attendenceormorgscetor', () => import('@/uiservice/att-endence-ormorgscetor/att-endence-ormorgscetor-ui-service'));
        this.allUIService.set('attensummary', () => import('@/uiservice/att-ensummary/att-ensummary-ui-service'));
        this.allUIService.set('vacsynjcx', () => import('@/uiservice/vac-synjcx/vac-synjcx-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('vacholiday', () => import('@/uiservice/vac-holiday/vac-holiday-ui-service'));
        this.allUIService.set('attendencesetup', () => import('@/uiservice/att-endence-setup/att-endence-setup-ui-service'));
        this.allUIService.set('attendancesettings', () => import('@/uiservice/att-endance-settings/att-endance-settings-ui-service'));
        this.allUIService.set('ormbmkqdz', () => import('@/uiservice/orm-bmkqdz/orm-bmkqdz-ui-service'));
        this.allUIService.set('attendancemreportmx', () => import('@/uiservice/att-endance-mreportmx/att-endance-mreportmx-ui-service'));
        this.allUIService.set('vacleacetype', () => import('@/uiservice/vac-leace-type/vac-leace-type-ui-service'));
        this.allUIService.set('vacleavemanage', () => import('@/uiservice/vac-leave-manage/vac-leave-manage-ui-service'));
        this.allUIService.set('attendancerecord', () => import('@/uiservice/att-endance-record/att-endance-record-ui-service'));
        this.allUIService.set('pcmwzd0001', () => import('@/uiservice/pcm-wzd0001/pcm-wzd0001-ui-service'));
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
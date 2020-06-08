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
                this.allEntityService.set('attendencetype', () => import('@/service/att-endence-type/att-endence-type-service'));
        this.allEntityService.set('vacleavedetail', () => import('@/service/vac-leave-detail/vac-leave-detail-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('vacleavetips', () => import('@/service/vac-leave-tips/vac-leave-tips-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('attendancemreport', () => import('@/service/att-endance-mreport/att-endance-mreport-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('vacholidayrules', () => import('@/service/vac-holiday-rules/vac-holiday-rules-service'));
        this.allEntityService.set('attendenceormorgscetor', () => import('@/service/att-endence-ormorgscetor/att-endence-ormorgscetor-service'));
        this.allEntityService.set('attensummary', () => import('@/service/att-ensummary/att-ensummary-service'));
        this.allEntityService.set('vacsynjcx', () => import('@/service/vac-synjcx/vac-synjcx-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('vacholiday', () => import('@/service/vac-holiday/vac-holiday-service'));
        this.allEntityService.set('attendencesetup', () => import('@/service/att-endence-setup/att-endence-setup-service'));
        this.allEntityService.set('attendancesettings', () => import('@/service/att-endance-settings/att-endance-settings-service'));
        this.allEntityService.set('ormbmkqdz', () => import('@/service/orm-bmkqdz/orm-bmkqdz-service'));
        this.allEntityService.set('attendancemreportmx', () => import('@/service/att-endance-mreportmx/att-endance-mreportmx-service'));
        this.allEntityService.set('vacleacetype', () => import('@/service/vac-leace-type/vac-leace-type-service'));
        this.allEntityService.set('vacleavemanage', () => import('@/service/vac-leave-manage/vac-leave-manage-service'));
        this.allEntityService.set('attendancerecord', () => import('@/service/att-endance-record/att-endance-record-service'));
        this.allEntityService.set('pcmwzd0001', () => import('@/service/pcm-wzd0001/pcm-wzd0001-service'));
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
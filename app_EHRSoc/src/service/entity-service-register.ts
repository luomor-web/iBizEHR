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
                this.allEntityService.set('socarea', () => import('@/service/soc-area/soc-area-service'));
        this.allEntityService.set('socarchives', () => import('@/service/soc-archives/soc-archives-service'));
        this.allEntityService.set('soctype', () => import('@/service/soc-type/soc-type-service'));
        this.allEntityService.set('socrule', () => import('@/service/soc-rule/soc-rule-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('socrecord', () => import('@/service/soc-record/soc-record-service'));
        this.allEntityService.set('socaccount', () => import('@/service/soc-account/soc-account-service'));
        this.allEntityService.set('socarchivesdetail', () => import('@/service/soc-archives-detail/soc-archives-detail-service'));
        this.allEntityService.set('socruledetail', () => import('@/service/soc-rule-detail/soc-rule-detail-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
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
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
                this.allEntityService.set('salscheme', () => import('@/service/sal-scheme/sal-scheme-service'));
        this.allEntityService.set('salruledetail', () => import('@/service/sal-rule-detail/sal-rule-detail-service'));
        this.allEntityService.set('salrule', () => import('@/service/sal-rule/sal-rule-service'));
        this.allEntityService.set('salsource', () => import('@/service/sal-source/sal-source-service'));
        this.allEntityService.set('salparam', () => import('@/service/sal-param/sal-param-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('salsubject', () => import('@/service/sal-subject/sal-subject-service'));
        this.allEntityService.set('saltype', () => import('@/service/sal-type/sal-type-service'));
        this.allEntityService.set('salitem', () => import('@/service/sal-item/sal-item-service'));
        this.allEntityService.set('salschemeitem', () => import('@/service/sal-scheme-item/sal-scheme-item-service'));
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
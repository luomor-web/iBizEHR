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
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('salruledetail', () => import('@/service/sal-rule-detail/sal-rule-detail-service'));
        this.allEntityService.set('sallog', () => import('@/service/sal-log/sal-log-service'));
        this.allEntityService.set('salstdzyzg', () => import('@/service/sal-stdzyzg/sal-stdzyzg-service'));
        this.allEntityService.set('salrule', () => import('@/service/sal-rule/sal-rule-service'));
        this.allEntityService.set('salpersonstddetail', () => import('@/service/salpersonstddetail/salpersonstddetail-service'));
        this.allEntityService.set('salsource', () => import('@/service/sal-source/sal-source-service'));
        this.allEntityService.set('salstdgw', () => import('@/service/sal-stdgw/sal-stdgw-service'));
        this.allEntityService.set('salstdgwgz', () => import('@/service/sal-stdgwgz/sal-stdgwgz-service'));
        this.allEntityService.set('salparam', () => import('@/service/sal-param/sal-param-service'));
        this.allEntityService.set('salstdxmgz', () => import('@/service/sal-std-xmgz/sal-std-xmgz-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('ormpost', () => import('@/service/orm-post/orm-post-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('salsubject', () => import('@/service/sal-subject/sal-subject-service'));
        this.allEntityService.set('salstdzc', () => import('@/service/sal-stdzc/sal-stdzc-service'));
        this.allEntityService.set('salsalarybill', () => import('@/service/sal-salary-bill/sal-salary-bill-service'));
        this.allEntityService.set('saltype', () => import('@/service/sal-type/sal-type-service'));
        this.allEntityService.set('salsalary', () => import('@/service/sal-salary/sal-salary-service'));
        this.allEntityService.set('salitem', () => import('@/service/sal-item/sal-item-service'));
        this.allEntityService.set('ormqygl', () => import('@/service/orm-qygl/orm-qygl-service'));
        this.allEntityService.set('ormduty', () => import('@/service/orm-duty/orm-duty-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('salsalarydetail', () => import('@/service/sal-salary-detail/sal-salary-detail-service'));
        this.allEntityService.set('salschemeitem', () => import('@/service/sal-scheme-item/sal-scheme-item-service'));
        this.allEntityService.set('salplan', () => import('@/service/sal-plan/sal-plan-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('salstdzx', () => import('@/service/sal-stdzx/sal-stdzx-service'));
        this.allEntityService.set('salstddszn', () => import('@/service/sal-stddszn/sal-stddszn-service'));
        this.allEntityService.set('salstdgl', () => import('@/service/sal-stdgl/sal-stdgl-service'));
        this.allEntityService.set('salpersonstd', () => import('@/service/sal-person-std/sal-person-std-service'));
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
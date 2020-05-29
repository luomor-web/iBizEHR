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
                this.allEntityService.set('ormqygl', () => import('@/service/ormqygl/ormqygl-service'));
        this.allEntityService.set('ormpostdetails', () => import('@/service/orm-post-details/orm-post-details-service'));
        this.allEntityService.set('ormsignorg', () => import('@/service/orm-sign-org/orm-sign-org-service'));
        this.allEntityService.set('ormerporg', () => import('@/service/orm-erporg/orm-erporg-service'));
        this.allEntityService.set('ormxmbmx', () => import('@/service/ormxmbmx/ormxmbmx-service'));
        this.allEntityService.set('ormorginfo', () => import('@/service/orm-org-info/orm-org-info-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('ormedition', () => import('@/service/ormedition/ormedition-service'));
        this.allEntityService.set('ormorgdz', () => import('@/service/orm-orgdz/orm-orgdz-service'));
        this.allEntityService.set('contractsignorg', () => import('@/service/contract-sign-org/contract-sign-org-service'));
        this.allEntityService.set('ormpost', () => import('@/service/orm-post/orm-post-service'));
        this.allEntityService.set('ormbmkqdz', () => import('@/service/orm-bmkqdz/orm-bmkqdz-service'));
        this.allEntityService.set('ormbmgwbz', () => import('@/service/ormbmgwbz/ormbmgwbz-service'));
        this.allEntityService.set('ormrelation', () => import('@/service/orm-relation/orm-relation-service'));
        this.allEntityService.set('ormpostlib', () => import('@/service/orm-post-lib/orm-post-lib-service'));
        this.allEntityService.set('ormdepestman', () => import('@/service/ormdep-est-man/ormdep-est-man-service'));
        this.allEntityService.set('unitedperson', () => import('@/service/united-person/united-person-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pimperson/pimperson-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('ormqybzwh', () => import('@/service/ormqybzwh/ormqybzwh-service'));
        this.allEntityService.set('ormduty', () => import('@/service/ormduty/ormduty-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('ormtitle', () => import('@/service/ormtitle/ormtitle-service'));
        this.allEntityService.set('ormxmgl', () => import('@/service/ormxmgl/ormxmgl-service'));
        this.allEntityService.set('ormxmbq', () => import('@/service/ormxmbq/ormxmbq-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
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
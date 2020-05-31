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
                this.allUIService.set('ormqygl', () => import('@/uiservice/orm-qygl/orm-qygl-ui-service'));
        this.allUIService.set('ormpostdetails', () => import('@/uiservice/orm-post-details/orm-post-details-ui-service'));
        this.allUIService.set('ormsignorg', () => import('@/uiservice/orm-sign-org/orm-sign-org-ui-service'));
        this.allUIService.set('ormerporg', () => import('@/uiservice/orm-erporg/orm-erporg-ui-service'));
        this.allUIService.set('ormxmbmx', () => import('@/uiservice/orm-xmbmx/orm-xmbmx-ui-service'));
        this.allUIService.set('ormorginfo', () => import('@/uiservice/orm-org-info/orm-org-info-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('ormedition', () => import('@/uiservice/orm-edition/orm-edition-ui-service'));
        this.allUIService.set('ormorgdz', () => import('@/uiservice/orm-orgdz/orm-orgdz-ui-service'));
        this.allUIService.set('pimcontractsignorg', () => import('@/uiservice/pim-contract-sign-org/pim-contract-sign-org-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/orm-post/orm-post-ui-service'));
        this.allUIService.set('ormbmkqdz', () => import('@/uiservice/orm-bmkqdz/orm-bmkqdz-ui-service'));
        this.allUIService.set('ormbmgwbz', () => import('@/uiservice/orm-bmgwbz/orm-bmgwbz-ui-service'));
        this.allUIService.set('ormrelation', () => import('@/uiservice/orm-relation/orm-relation-ui-service'));
        this.allUIService.set('ormpostlib', () => import('@/uiservice/orm-post-lib/orm-post-lib-ui-service'));
        this.allUIService.set('ormdepestman', () => import('@/uiservice/orm-dep-est-man/orm-dep-est-man-ui-service'));
        this.allUIService.set('ormunitedperson', () => import('@/uiservice/orm-united-person/orm-united-person-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('ormqybzwh', () => import('@/uiservice/orm-qybzwh/orm-qybzwh-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/orm-duty/orm-duty-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('ormtitle', () => import('@/uiservice/orm-title/orm-title-ui-service'));
        this.allUIService.set('ormxmgl', () => import('@/uiservice/orm-xmgl/orm-xmgl-ui-service'));
        this.allUIService.set('ormxmbq', () => import('@/uiservice/orm-xmbq/orm-xmbq-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
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
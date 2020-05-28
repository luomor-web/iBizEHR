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
                this.allUIService.set('ormqygl', () => import('@/uiservice/ormqygl/ormqygl-ui-service'));
        this.allUIService.set('ormpostdetails', () => import('@/uiservice/ormpost-details/ormpost-details-ui-service'));
        this.allUIService.set('ormsignorg', () => import('@/uiservice/orm-sign-org/orm-sign-org-ui-service'));
        this.allUIService.set('ormerporg', () => import('@/uiservice/ormerporg/ormerporg-ui-service'));
        this.allUIService.set('ormxmbmx', () => import('@/uiservice/ormxmbmx/ormxmbmx-ui-service'));
        this.allUIService.set('ormorginfo', () => import('@/uiservice/ormorginfo/ormorginfo-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('ormedition', () => import('@/uiservice/ormedition/ormedition-ui-service'));
        this.allUIService.set('ormorgdz', () => import('@/uiservice/ormorgdz/ormorgdz-ui-service'));
        this.allUIService.set('contractsignorg', () => import('@/uiservice/contract-sign-org/contract-sign-org-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/ormpost/ormpost-ui-service'));
        this.allUIService.set('ormbmkqdz', () => import('@/uiservice/ormbmkqdz/ormbmkqdz-ui-service'));
        this.allUIService.set('ormbmgwbz', () => import('@/uiservice/ormbmgwbz/ormbmgwbz-ui-service'));
        this.allUIService.set('ormrelation', () => import('@/uiservice/ormrelation/ormrelation-ui-service'));
        this.allUIService.set('ormpostlib', () => import('@/uiservice/ormpost-lib/ormpost-lib-ui-service'));
        this.allUIService.set('ormdepestman', () => import('@/uiservice/ormdep-est-man/ormdep-est-man-ui-service'));
        this.allUIService.set('unitedperson', () => import('@/uiservice/united-person/united-person-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pimperson/pimperson-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/ormorg/ormorg-ui-service'));
        this.allUIService.set('ormqybzwh', () => import('@/uiservice/ormqybzwh/ormqybzwh-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/ormduty/ormduty-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('ormtitle', () => import('@/uiservice/ormtitle/ormtitle-ui-service'));
        this.allUIService.set('ormxmgl', () => import('@/uiservice/ormxmgl/ormxmgl-ui-service'));
        this.allUIService.set('ormxmbq', () => import('@/uiservice/ormxmbq/ormxmbq-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/ormorgsector/ormorgsector-ui-service'));
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
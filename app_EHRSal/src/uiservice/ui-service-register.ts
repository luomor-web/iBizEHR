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
                this.allUIService.set('salscheme', () => import('@/uiservice/sal-scheme/sal-scheme-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('salruledetail', () => import('@/uiservice/sal-rule-detail/sal-rule-detail-ui-service'));
        this.allUIService.set('sallog', () => import('@/uiservice/sal-log/sal-log-ui-service'));
        this.allUIService.set('salstdzyzg', () => import('@/uiservice/sal-stdzyzg/sal-stdzyzg-ui-service'));
        this.allUIService.set('salrule', () => import('@/uiservice/sal-rule/sal-rule-ui-service'));
        this.allUIService.set('salpersonstddetail', () => import('@/uiservice/salpersonstddetail/salpersonstddetail-ui-service'));
        this.allUIService.set('salsource', () => import('@/uiservice/sal-source/sal-source-ui-service'));
        this.allUIService.set('salstdgw', () => import('@/uiservice/sal-stdgw/sal-stdgw-ui-service'));
        this.allUIService.set('salstdgwgz', () => import('@/uiservice/sal-stdgwgz/sal-stdgwgz-ui-service'));
        this.allUIService.set('salparam', () => import('@/uiservice/sal-param/sal-param-ui-service'));
        this.allUIService.set('salstdxmgz', () => import('@/uiservice/sal-std-xmgz/sal-std-xmgz-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/orm-post/orm-post-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('salsubject', () => import('@/uiservice/sal-subject/sal-subject-ui-service'));
        this.allUIService.set('salstdzc', () => import('@/uiservice/sal-stdzc/sal-stdzc-ui-service'));
        this.allUIService.set('salsalarybill', () => import('@/uiservice/sal-salary-bill/sal-salary-bill-ui-service'));
        this.allUIService.set('saltype', () => import('@/uiservice/sal-type/sal-type-ui-service'));
        this.allUIService.set('salsalary', () => import('@/uiservice/sal-salary/sal-salary-ui-service'));
        this.allUIService.set('salitem', () => import('@/uiservice/sal-item/sal-item-ui-service'));
        this.allUIService.set('ormqygl', () => import('@/uiservice/orm-qygl/orm-qygl-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/orm-duty/orm-duty-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('salsalarydetail', () => import('@/uiservice/sal-salary-detail/sal-salary-detail-ui-service'));
        this.allUIService.set('salschemeitem', () => import('@/uiservice/sal-scheme-item/sal-scheme-item-ui-service'));
        this.allUIService.set('salplan', () => import('@/uiservice/sal-plan/sal-plan-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('salstdzx', () => import('@/uiservice/sal-stdzx/sal-stdzx-ui-service'));
        this.allUIService.set('salstddszn', () => import('@/uiservice/sal-stddszn/sal-stddszn-ui-service'));
        this.allUIService.set('salstdgl', () => import('@/uiservice/sal-stdgl/sal-stdgl-ui-service'));
        this.allUIService.set('salpersonstd', () => import('@/uiservice/sal-person-std/sal-person-std-ui-service'));
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
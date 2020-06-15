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
                this.allUIService.set('parjxndkhjg', () => import('@/uiservice/par-jxndkhjg/par-jxndkhjg-ui-service'));
        this.allUIService.set('parfzsmx', () => import('@/uiservice/par-fzsmx/par-fzsmx-ui-service'));
        this.allUIService.set('parptryndlhmbmx', () => import('@/uiservice/par-ptryndlhmbmx/par-ptryndlhmbmx-ui-service'));
        this.allUIService.set('dynachart', () => import('@/uiservice/dyna-chart/dyna-chart-ui-service'));
        this.allUIService.set('parjxjg', () => import('@/uiservice/par-jxjg/par-jxjg-ui-service'));
        this.allUIService.set('parznbmndlhmb', () => import('@/uiservice/par-znbmndlhmb/par-znbmndlhmb-ui-service'));
        this.allUIService.set('parlhmbmx', () => import('@/uiservice/par-lhmbmx/par-lhmbmx-ui-service'));
        this.allUIService.set('parldkhqz', () => import('@/uiservice/par-ldkhqz/par-ldkhqz-ui-service'));
        this.allUIService.set('parexamcontent', () => import('@/uiservice/par-exam-content/par-exam-content-ui-service'));
        this.allUIService.set('parlhmbkhmx', () => import('@/uiservice/par-lhmbkhmx/par-lhmbkhmx-ui-service'));
        this.allUIService.set('parintegralrule', () => import('@/uiservice/par-integral-rule/par-integral-rule-ui-service'));
        this.allUIService.set('parznbmndlhmbmx', () => import('@/uiservice/par-znbmndlhmbmx/par-znbmndlhmbmx-ui-service'));
        this.allUIService.set('parkhzcmx', () => import('@/uiservice/par-khzcmx/par-khzcmx-ui-service'));
        this.allUIService.set('parjxkhmb', () => import('@/uiservice/par-jxkhmb/par-jxkhmb-ui-service'));
        this.allUIService.set('parjxzgpcmx', () => import('@/uiservice/par-jxzgpcmx/par-jxzgpcmx-ui-service'));
        this.allUIService.set('parjxlhmb', () => import('@/uiservice/par-jxlhmb/par-jxlhmb-ui-service'));
        this.allUIService.set('parjxqdsz', () => import('@/uiservice/par-jxqdsz/par-jxqdsz-ui-service'));
        this.allUIService.set('parjxkhmbmx', () => import('@/uiservice/par-jxkhmbmx/par-jxkhmbmx-ui-service'));
        this.allUIService.set('parjxmtfk', () => import('@/uiservice/par-jxmtfk/par-jxmtfk-ui-service'));
        this.allUIService.set('parjxzgpc', () => import('@/uiservice/par-jxzgpc/par-jxzgpc-ui-service'));
        this.allUIService.set('parldndlhmbmx', () => import('@/uiservice/par-ldndlhmbmx/par-ldndlhmbmx-ui-service'));
        this.allUIService.set('parydgzjh', () => import('@/uiservice/par-ydgzjh/par-ydgzjh-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('parjxbzglmx', () => import('@/uiservice/par-jxbzglmx/par-jxbzglmx-ui-service'));
        this.allUIService.set('parndlhmbkh', () => import('@/uiservice/par-ndlhmbkh/par-ndlhmbkh-ui-service'));
        this.allUIService.set('partzgg', () => import('@/uiservice/par-tzgg/par-tzgg-ui-service'));
        this.allUIService.set('dynadashboard', () => import('@/uiservice/dyna-dashboard/dyna-dashboard-ui-service'));
        this.allUIService.set('parydgzjhmx', () => import('@/uiservice/par-ydgzjhmx/par-ydgzjhmx-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('parjxbzgl', () => import('@/uiservice/par-jxbzgl/par-jxbzgl-ui-service'));
        this.allUIService.set('parbmfzjyx', () => import('@/uiservice/par-bmfzjyx/par-bmfzjyx-ui-service'));
        this.allUIService.set('parznbmmx', () => import('@/uiservice/par-znbmmx/par-znbmmx-ui-service'));
        this.allUIService.set('parjxkhjcsz', () => import('@/uiservice/par-jxkhjcsz/par-jxkhjcsz-ui-service'));
        this.allUIService.set('parptryndlhmb', () => import('@/uiservice/par-ptryndlhmb/par-ptryndlhmb-ui-service'));
        this.allUIService.set('parldndlhmb', () => import('@/uiservice/par-ldndlhmb/par-ldndlhmb-ui-service'));
        this.allUIService.set('parassesstemplate', () => import('@/uiservice/par-assess-template/par-assess-template-ui-service'));
        this.allUIService.set('parxmbpjbz', () => import('@/uiservice/par-xmbpjbz/par-xmbpjbz-ui-service'));
        this.allUIService.set('pardjbz', () => import('@/uiservice/par-djbz/par-djbz-ui-service'));
        this.allUIService.set('parjgbmpjbz', () => import('@/uiservice/par-jgbmpjbz/par-jgbmpjbz-ui-service'));
        this.allUIService.set('parjxkhxhz', () => import('@/uiservice/par-jxkhxhz/par-jxkhxhz-ui-service'));
        this.allUIService.set('parexamcycle', () => import('@/uiservice/par-exam-cycle/par-exam-cycle-ui-service'));
        this.allUIService.set('parjzszpsjg', () => import('@/uiservice/par-jzszpsjg/par-jzszpsjg-ui-service'));
        this.allUIService.set('pardxkhnrmx', () => import('@/uiservice/par-dxkhnrmx/par-dxkhnrmx-ui-service'));
        this.allUIService.set('parkhfa', () => import('@/uiservice/par-khfa/par-khfa-ui-service'));
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
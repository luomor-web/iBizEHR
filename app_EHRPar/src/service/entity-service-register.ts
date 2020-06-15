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
                this.allEntityService.set('parjxndkhjg', () => import('@/service/par-jxndkhjg/par-jxndkhjg-service'));
        this.allEntityService.set('parfzsmx', () => import('@/service/par-fzsmx/par-fzsmx-service'));
        this.allEntityService.set('parptryndlhmbmx', () => import('@/service/par-ptryndlhmbmx/par-ptryndlhmbmx-service'));
        this.allEntityService.set('dynachart', () => import('@/service/dyna-chart/dyna-chart-service'));
        this.allEntityService.set('parjxjg', () => import('@/service/par-jxjg/par-jxjg-service'));
        this.allEntityService.set('parznbmndlhmb', () => import('@/service/par-znbmndlhmb/par-znbmndlhmb-service'));
        this.allEntityService.set('parlhmbmx', () => import('@/service/par-lhmbmx/par-lhmbmx-service'));
        this.allEntityService.set('parldkhqz', () => import('@/service/par-ldkhqz/par-ldkhqz-service'));
        this.allEntityService.set('parexamcontent', () => import('@/service/par-exam-content/par-exam-content-service'));
        this.allEntityService.set('parlhmbkhmx', () => import('@/service/par-lhmbkhmx/par-lhmbkhmx-service'));
        this.allEntityService.set('parintegralrule', () => import('@/service/par-integral-rule/par-integral-rule-service'));
        this.allEntityService.set('parznbmndlhmbmx', () => import('@/service/par-znbmndlhmbmx/par-znbmndlhmbmx-service'));
        this.allEntityService.set('parkhzcmx', () => import('@/service/par-khzcmx/par-khzcmx-service'));
        this.allEntityService.set('parjxkhmb', () => import('@/service/par-jxkhmb/par-jxkhmb-service'));
        this.allEntityService.set('parjxzgpcmx', () => import('@/service/par-jxzgpcmx/par-jxzgpcmx-service'));
        this.allEntityService.set('parjxlhmb', () => import('@/service/par-jxlhmb/par-jxlhmb-service'));
        this.allEntityService.set('parjxqdsz', () => import('@/service/par-jxqdsz/par-jxqdsz-service'));
        this.allEntityService.set('parjxkhmbmx', () => import('@/service/par-jxkhmbmx/par-jxkhmbmx-service'));
        this.allEntityService.set('parjxmtfk', () => import('@/service/par-jxmtfk/par-jxmtfk-service'));
        this.allEntityService.set('parjxzgpc', () => import('@/service/par-jxzgpc/par-jxzgpc-service'));
        this.allEntityService.set('parldndlhmbmx', () => import('@/service/par-ldndlhmbmx/par-ldndlhmbmx-service'));
        this.allEntityService.set('parydgzjh', () => import('@/service/par-ydgzjh/par-ydgzjh-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('parjxbzglmx', () => import('@/service/par-jxbzglmx/par-jxbzglmx-service'));
        this.allEntityService.set('parndlhmbkh', () => import('@/service/par-ndlhmbkh/par-ndlhmbkh-service'));
        this.allEntityService.set('partzgg', () => import('@/service/par-tzgg/par-tzgg-service'));
        this.allEntityService.set('dynadashboard', () => import('@/service/dyna-dashboard/dyna-dashboard-service'));
        this.allEntityService.set('parydgzjhmx', () => import('@/service/par-ydgzjhmx/par-ydgzjhmx-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('parjxbzgl', () => import('@/service/par-jxbzgl/par-jxbzgl-service'));
        this.allEntityService.set('parbmfzjyx', () => import('@/service/par-bmfzjyx/par-bmfzjyx-service'));
        this.allEntityService.set('parznbmmx', () => import('@/service/par-znbmmx/par-znbmmx-service'));
        this.allEntityService.set('parjxkhjcsz', () => import('@/service/par-jxkhjcsz/par-jxkhjcsz-service'));
        this.allEntityService.set('parptryndlhmb', () => import('@/service/par-ptryndlhmb/par-ptryndlhmb-service'));
        this.allEntityService.set('parldndlhmb', () => import('@/service/par-ldndlhmb/par-ldndlhmb-service'));
        this.allEntityService.set('parassesstemplate', () => import('@/service/par-assess-template/par-assess-template-service'));
        this.allEntityService.set('parxmbpjbz', () => import('@/service/par-xmbpjbz/par-xmbpjbz-service'));
        this.allEntityService.set('pardjbz', () => import('@/service/par-djbz/par-djbz-service'));
        this.allEntityService.set('parjgbmpjbz', () => import('@/service/par-jgbmpjbz/par-jgbmpjbz-service'));
        this.allEntityService.set('parjxkhxhz', () => import('@/service/par-jxkhxhz/par-jxkhxhz-service'));
        this.allEntityService.set('parexamcycle', () => import('@/service/par-exam-cycle/par-exam-cycle-service'));
        this.allEntityService.set('parjzszpsjg', () => import('@/service/par-jzszpsjg/par-jzszpsjg-service'));
        this.allEntityService.set('pardxkhnrmx', () => import('@/service/par-dxkhnrmx/par-dxkhnrmx-service'));
        this.allEntityService.set('parkhfa', () => import('@/service/par-khfa/par-khfa-service'));
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
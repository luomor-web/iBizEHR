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
                this.allEntityService.set('pcmworkresume', () => import('@/service/pcmworkresume/pcmworkresume-service'));
        this.allEntityService.set('pcmprofileapproval', () => import('@/service/pcmprofileapproval/pcmprofileapproval-service'));
        this.allEntityService.set('pcmgxml', () => import('@/service/pcmgxml/pcmgxml-service'));
        this.allEntityService.set('ormorg', () => import('@/service/ormorg/ormorg-service'));
        this.allEntityService.set('pcmpracticeexperience', () => import('@/service/pcmpracticeexperience/pcmpracticeexperience-service'));
        this.allEntityService.set('ormduty', () => import('@/service/ormduty/ormduty-service'));
        this.allEntityService.set('pimcity', () => import('@/service/pimcity/pimcity-service'));
        this.allEntityService.set('pcmprofileinitnumber', () => import('@/service/pcmprofileinitnumber/pcmprofileinitnumber-service'));
        this.allEntityService.set('pimstafftype', () => import('@/service/pimstafftype/pimstafftype-service'));
        this.allEntityService.set('pcmprofileszyjtj', () => import('@/service/pcmprofileszyjtj/pcmprofileszyjtj-service'));
        this.allEntityService.set('pcmxkml', () => import('@/service/pcmxkml/pcmxkml-service'));
        this.allEntityService.set('pcmprofileyjtjtemp', () => import('@/service/pcmprofileyjtjtemp/pcmprofileyjtjtemp-service'));
        this.allEntityService.set('pcmprofilespyy', () => import('@/service/pcmprofilespyy/pcmprofilespyy-service'));
        this.allEntityService.set('ormqygl', () => import('@/service/ormqygl/ormqygl-service'));
        this.allEntityService.set('pcmprofilefj', () => import('@/service/pcmprofilefj/pcmprofilefj-service'));
        this.allEntityService.set('pcmzpmeglmx', () => import('@/service/pcmzpmeglmx/pcmzpmeglmx-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('pcmprofilenumbeprefix', () => import('@/service/pcmprofilenumbeprefix/pcmprofilenumbeprefix-service'));
        this.allEntityService.set('pcmcertofreg', () => import('@/service/pcmcertofreg/pcmcertofreg-service'));
        this.allEntityService.set('tdzwxx', () => import('@/service/tdzwxx/tdzwxx-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/ormorgsector/ormorgsector-service'));
        this.allEntityService.set('pcmschooloffice', () => import('@/service/pcmschooloffice/pcmschooloffice-service'));
        this.allEntityService.set('testresult', () => import('@/service/test-result/test-result-service'));
        this.allEntityService.set('pcmzpmegl', () => import('@/service/pcmzpmegl/pcmzpmegl-service'));
        this.allEntityService.set('pcmprofile', () => import('@/service/pcmprofile/pcmprofile-service'));
        this.allEntityService.set('pcmawardswons', () => import('@/service/pcmawardswons/pcmawardswons-service'));
        this.allEntityService.set('pcmeducationexperience', () => import('@/service/pcmeducation-experience/pcmeducation-experience-service'));
        this.allEntityService.set('ormpost', () => import('@/service/ormpost/ormpost-service'));
        this.allEntityService.set('pimqualmajor', () => import('@/service/pimqualmajor/pimqualmajor-service'));
        this.allEntityService.set('wzd0001', () => import('@/service/wzd0001/wzd0001-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pimperson/pimperson-service'));
        this.allEntityService.set('pcmgxxktemp', () => import('@/service/pcmgxxktemp/pcmgxxktemp-service'));
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
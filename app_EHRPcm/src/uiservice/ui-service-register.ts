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
                this.allUIService.set('pcmworkresume', () => import('@/uiservice/pcmworkresume/pcmworkresume-ui-service'));
        this.allUIService.set('pcmprofileapproval', () => import('@/uiservice/pcmprofileapproval/pcmprofileapproval-ui-service'));
        this.allUIService.set('pcmgxml', () => import('@/uiservice/pcmgxml/pcmgxml-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('pcmpracticeexperience', () => import('@/uiservice/pcmpracticeexperience/pcmpracticeexperience-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/ormduty/ormduty-ui-service'));
        this.allUIService.set('pimcity', () => import('@/uiservice/pimcity/pimcity-ui-service'));
        this.allUIService.set('pcmprofileinitnumber', () => import('@/uiservice/pcmprofileinitnumber/pcmprofileinitnumber-ui-service'));
        this.allUIService.set('pimstafftype', () => import('@/uiservice/pimstafftype/pimstafftype-ui-service'));
        this.allUIService.set('pcmprofileszyjtj', () => import('@/uiservice/pcmprofileszyjtj/pcmprofileszyjtj-ui-service'));
        this.allUIService.set('pcmxkml', () => import('@/uiservice/pcmxkml/pcmxkml-ui-service'));
        this.allUIService.set('pcmprofileyjtjtemp', () => import('@/uiservice/pcmprofileyjtjtemp/pcmprofileyjtjtemp-ui-service'));
        this.allUIService.set('pcmprofilespyy', () => import('@/uiservice/pcmprofilespyy/pcmprofilespyy-ui-service'));
        this.allUIService.set('ormqygl', () => import('@/uiservice/ormqygl/ormqygl-ui-service'));
        this.allUIService.set('pcmprofilefj', () => import('@/uiservice/pcmprofilefj/pcmprofilefj-ui-service'));
        this.allUIService.set('pcmzpmeglmx', () => import('@/uiservice/pcmzpmeglmx/pcmzpmeglmx-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('pcmprofilenumbeprefix', () => import('@/uiservice/pcmprofilenumbeprefix/pcmprofilenumbeprefix-ui-service'));
        this.allUIService.set('pcmcertofreg', () => import('@/uiservice/pcmcertofreg/pcmcertofreg-ui-service'));
        this.allUIService.set('tdzwxx', () => import('@/uiservice/tdzwxx/tdzwxx-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('pcmschooloffice', () => import('@/uiservice/pcmschooloffice/pcmschooloffice-ui-service'));
        this.allUIService.set('testresult', () => import('@/uiservice/test-result/test-result-ui-service'));
        this.allUIService.set('pcmzpmegl', () => import('@/uiservice/pcmzpmegl/pcmzpmegl-ui-service'));
        this.allUIService.set('pcmprofile', () => import('@/uiservice/pcmprofile/pcmprofile-ui-service'));
        this.allUIService.set('pcmawardswons', () => import('@/uiservice/pcmawardswons/pcmawardswons-ui-service'));
        this.allUIService.set('pcmeducationexperience', () => import('@/uiservice/pcmeducation-experience/pcmeducation-experience-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/ormpost/ormpost-ui-service'));
        this.allUIService.set('pimqualmajor', () => import('@/uiservice/pimqualmajor/pimqualmajor-ui-service'));
        this.allUIService.set('wzd0001', () => import('@/uiservice/wzd0001/wzd0001-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pimperson/pimperson-ui-service'));
        this.allUIService.set('pcmgxxktemp', () => import('@/uiservice/pcmgxxktemp/pcmgxxktemp-ui-service'));
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
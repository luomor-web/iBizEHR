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
                this.allUIService.set('pcmworkresume', () => import('@/uiservice/pcm-work-resume/pcm-work-resume-ui-service'));
        this.allUIService.set('pcmprofileapproval', () => import('@/uiservice/pcm-profile-approval/pcm-profile-approval-ui-service'));
        this.allUIService.set('pcmgxml', () => import('@/uiservice/pcm-gxml/pcm-gxml-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('pcmpracticeexperience', () => import('@/uiservice/pcm-practice-experience/pcm-practice-experience-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/orm-duty/orm-duty-ui-service'));
        this.allUIService.set('pimcity', () => import('@/uiservice/pim-city/pim-city-ui-service'));
        this.allUIService.set('pcmprofileinitnumber', () => import('@/uiservice/pcm-profile-init-number/pcm-profile-init-number-ui-service'));
        this.allUIService.set('pimstafftype', () => import('@/uiservice/pim-stafftype/pim-stafftype-ui-service'));
        this.allUIService.set('pcmprofileszyjtj', () => import('@/uiservice/pcm-profile-szyjtj/pcm-profile-szyjtj-ui-service'));
        this.allUIService.set('pcmxkml', () => import('@/uiservice/pcm-xkml/pcm-xkml-ui-service'));
        this.allUIService.set('pcmprofileyjtjtemp', () => import('@/uiservice/pcm-profile-yjtj-temp/pcm-profile-yjtj-temp-ui-service'));
        this.allUIService.set('pcmprofilespyy', () => import('@/uiservice/pcm-profile-spyy/pcm-profile-spyy-ui-service'));
        this.allUIService.set('ormqygl', () => import('@/uiservice/orm-qygl/orm-qygl-ui-service'));
        this.allUIService.set('pcmprofilefj', () => import('@/uiservice/pcm-profile-fj/pcm-profile-fj-ui-service'));
        this.allUIService.set('pcmzpmeglmx', () => import('@/uiservice/pcm-zpmeglmx/pcm-zpmeglmx-ui-service'));
        this.allUIService.set('codeitem', () => import('@/uiservice/code-item/code-item-ui-service'));
        this.allUIService.set('pcmprofilenumbeprefix', () => import('@/uiservice/pcm-profile-num-beprefix/pcm-profile-num-beprefix-ui-service'));
        this.allUIService.set('pcmcertofreg', () => import('@/uiservice/pcm-certofreg/pcm-certofreg-ui-service'));
        this.allUIService.set('pcmtdzwxx', () => import('@/uiservice/pcm-tdzwxx/pcm-tdzwxx-ui-service'));
        this.allUIService.set('codelist1', () => import('@/uiservice/code-list1/code-list1-ui-service'));
        this.allUIService.set('ormorgsector', () => import('@/uiservice/orm-orgsector/orm-orgsector-ui-service'));
        this.allUIService.set('pcmschooloffice', () => import('@/uiservice/pcm-school-office/pcm-school-office-ui-service'));
        this.allUIService.set('pcmtestresult', () => import('@/uiservice/pcm-test-result/pcm-test-result-ui-service'));
        this.allUIService.set('pcmzpmegl', () => import('@/uiservice/pcm-zpmegl/pcm-zpmegl-ui-service'));
        this.allUIService.set('pcmprofile', () => import('@/uiservice/pcm-profile/pcm-profile-ui-service'));
        this.allUIService.set('pcmawardswons', () => import('@/uiservice/pcm-awards-wons/pcm-awards-wons-ui-service'));
        this.allUIService.set('pcmeducationexperience', () => import('@/uiservice/pcm-education-experience/pcm-education-experience-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/orm-post/orm-post-ui-service'));
        this.allUIService.set('pimqualmajor', () => import('@/uiservice/pim-qual-major/pim-qual-major-ui-service'));
        this.allUIService.set('pcmwzd0001', () => import('@/uiservice/pcm-wzd0001/pcm-wzd0001-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
        this.allUIService.set('pcmgxxktemp', () => import('@/uiservice/pcmgxxk-temp/pcmgxxk-temp-ui-service'));
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
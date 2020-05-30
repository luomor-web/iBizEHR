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
                this.allEntityService.set('pcmworkresume', () => import('@/service/pcm-work-resume/pcm-work-resume-service'));
        this.allEntityService.set('pcmprofileapproval', () => import('@/service/pcm-profile-approval/pcm-profile-approval-service'));
        this.allEntityService.set('pcmgxml', () => import('@/service/pcm-gxml/pcm-gxml-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('pcmpracticeexperience', () => import('@/service/pcm-practice-experience/pcm-practice-experience-service'));
        this.allEntityService.set('ormduty', () => import('@/service/orm-duty/orm-duty-service'));
        this.allEntityService.set('pimcity', () => import('@/service/pim-city/pim-city-service'));
        this.allEntityService.set('pcmprofileinitnumber', () => import('@/service/pcm-profile-init-number/pcm-profile-init-number-service'));
        this.allEntityService.set('pimstafftype', () => import('@/service/pim-stafftype/pim-stafftype-service'));
        this.allEntityService.set('pcmprofileszyjtj', () => import('@/service/pcm-profile-szyjtj/pcm-profile-szyjtj-service'));
        this.allEntityService.set('pcmxkml', () => import('@/service/pcm-xkml/pcm-xkml-service'));
        this.allEntityService.set('pcmprofileyjtjtemp', () => import('@/service/pcm-profile-yjtj-temp/pcm-profile-yjtj-temp-service'));
        this.allEntityService.set('pcmprofilespyy', () => import('@/service/pcm-profile-spyy/pcm-profile-spyy-service'));
        this.allEntityService.set('ormqygl', () => import('@/service/orm-qygl/orm-qygl-service'));
        this.allEntityService.set('pcmprofilefj', () => import('@/service/pcm-profile-fj/pcm-profile-fj-service'));
        this.allEntityService.set('pcmzpmeglmx', () => import('@/service/pcm-zpmeglmx/pcm-zpmeglmx-service'));
        this.allEntityService.set('codeitem', () => import('@/service/code-item/code-item-service'));
        this.allEntityService.set('pcmprofilenumbeprefix', () => import('@/service/pcm-profile-num-beprefix/pcm-profile-num-beprefix-service'));
        this.allEntityService.set('pcmcertofreg', () => import('@/service/pcm-certofreg/pcm-certofreg-service'));
        this.allEntityService.set('pcmtdzwxx', () => import('@/service/pcm-tdzwxx/pcm-tdzwxx-service'));
        this.allEntityService.set('codelist1', () => import('@/service/code-list1/code-list1-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
        this.allEntityService.set('pcmschooloffice', () => import('@/service/pcm-school-office/pcm-school-office-service'));
        this.allEntityService.set('pcmtestresult', () => import('@/service/pcm-test-result/pcm-test-result-service'));
        this.allEntityService.set('pcmzpmegl', () => import('@/service/pcm-zpmegl/pcm-zpmegl-service'));
        this.allEntityService.set('pcmprofile', () => import('@/service/pcm-profile/pcm-profile-service'));
        this.allEntityService.set('pcmawardswons', () => import('@/service/pcm-awards-wons/pcm-awards-wons-service'));
        this.allEntityService.set('pcmeducationexperience', () => import('@/service/pcm-education-experience/pcm-education-experience-service'));
        this.allEntityService.set('ormpost', () => import('@/service/orm-post/orm-post-service'));
        this.allEntityService.set('pimqualmajor', () => import('@/service/pim-qual-major/pim-qual-major-service'));
        this.allEntityService.set('pcmwzd0001', () => import('@/service/pcm-wzd0001/pcm-wzd0001-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('pcmgxxktemp', () => import('@/service/pcmgxxk-temp/pcmgxxk-temp-service'));
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
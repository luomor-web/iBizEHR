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
                this.allUIService.set('pcmydjzmx', () => import('@/uiservice/pcm-ydjzmx/pcm-ydjzmx-ui-service'));
        this.allUIService.set('pcmxygzzsq', () => import('@/uiservice/pcm-xygzzsq/pcm-xygzzsq-ui-service'));
        this.allUIService.set('pcmjxsgz', () => import('@/uiservice/pcm-jxsgz/pcm-jxsgz-ui-service'));
        this.allUIService.set('pcmjxsygzzsq', () => import('@/uiservice/pcm-jxsygzzsq/pcm-jxsygzzsq-ui-service'));
        this.allUIService.set('pcmjxsygzzjlmx', () => import('@/uiservice/pcm-jxsygzzjlmx/pcm-jxsygzzjlmx-ui-service'));
        this.allUIService.set('ormpost', () => import('@/uiservice/orm-post/orm-post-ui-service'));
        this.allUIService.set('pcmydtxmx', () => import('@/uiservice/pcm-ydtxmx/pcm-ydtxmx-ui-service'));
        this.allUIService.set('pcmxygzzkhjgjl', () => import('@/uiservice/pcm-xygzzkhjgjl/pcm-xygzzkhjgjl-ui-service'));
        this.allUIService.set('pcmydgzmx', () => import('@/uiservice/pcm-ydgzmx/pcm-ydgzmx-ui-service'));
        this.allUIService.set('ormorg', () => import('@/uiservice/orm-org/orm-org-ui-service'));
        this.allUIService.set('pimdistirbution', () => import('@/uiservice/pim-distirbution/pim-distirbution-ui-service'));
        this.allUIService.set('personstatemgr', () => import('@/uiservice/person-state-mgr/person-state-mgr-ui-service'));
        this.allUIService.set('pcmxygzzsqmx', () => import('@/uiservice/pcm-xygzzsqmx/pcm-xygzzsqmx-ui-service'));
        this.allUIService.set('pcmyddgmx', () => import('@/uiservice/pcm-yddgmx/pcm-yddgmx-ui-service'));
        this.allUIService.set('ormduty', () => import('@/uiservice/orm-duty/orm-duty-ui-service'));
        this.allUIService.set('pcmtxbz', () => import('@/uiservice/pcm-txbz/pcm-txbz-ui-service'));
        this.allUIService.set('pcmydjpmx', () => import('@/uiservice/pcm-ydjpmx/pcm-ydjpmx-ui-service'));
        this.allUIService.set('pcmydjdmx', () => import('@/uiservice/pcm-ydjdmx/pcm-ydjdmx-ui-service'));
        this.allUIService.set('pcmddsqd', () => import('@/uiservice/pcm-ddsqd/pcm-ddsqd-ui-service'));
        this.allUIService.set('pcmydmx', () => import('@/uiservice/pcm-ydmx/pcm-ydmx-ui-service'));
        this.allUIService.set('pcmrecruitment', () => import('@/uiservice/pcm-recruitment/pcm-recruitment-ui-service'));
        this.allUIService.set('pcmtxfpsq', () => import('@/uiservice/pcm-txfpsq/pcm-txfpsq-ui-service'));
        this.allUIService.set('pcmddsqdmx', () => import('@/uiservice/pcm-ddsqdmx/pcm-ddsqdmx-ui-service'));
        this.allUIService.set('pcmreason', () => import('@/uiservice/pcm-reason/pcm-reason-ui-service'));
        this.allUIService.set('pcmydntmx', () => import('@/uiservice/pcm-ydntmx/pcm-ydntmx-ui-service'));
        this.allUIService.set('pcmydlzmx', () => import('@/uiservice/pcm-ydlzmx/pcm-ydlzmx-ui-service'));
        this.allUIService.set('pcmjxszzkhjgjl', () => import('@/uiservice/pcm-jxszzkhjgjl/pcm-jxszzkhjgjl-ui-service'));
        this.allUIService.set('pcmxygzzjlmx', () => import('@/uiservice/pcm-xygzzjlmx/pcm-xygzzjlmx-ui-service'));
        this.allUIService.set('pcmydbxmx', () => import('@/uiservice/pcm-ydbxmx/pcm-ydbxmx-ui-service'));
        this.allUIService.set('pcmnotice', () => import('@/uiservice/pcm-notice/pcm-notice-ui-service'));
        this.allUIService.set('pcmprofile', () => import('@/uiservice/pcm-profile/pcm-profile-ui-service'));
        this.allUIService.set('pimfaminfo', () => import('@/uiservice/pim-faminfo/pim-faminfo-ui-service'));
        this.allUIService.set('pimperson', () => import('@/uiservice/pim-person/pim-person-ui-service'));
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
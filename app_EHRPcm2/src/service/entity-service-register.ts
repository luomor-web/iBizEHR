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
                this.allEntityService.set('pcmydjzmx', () => import('@/service/pcm-ydjzmx/pcm-ydjzmx-service'));
        this.allEntityService.set('pcmxygzzsq', () => import('@/service/pcm-xygzzsq/pcm-xygzzsq-service'));
        this.allEntityService.set('pcmjxsgz', () => import('@/service/pcm-jxsgz/pcm-jxsgz-service'));
        this.allEntityService.set('pcmjxsygzzsq', () => import('@/service/pcm-jxsygzzsq/pcm-jxsygzzsq-service'));
        this.allEntityService.set('pcmjxsygzzjlmx', () => import('@/service/pcm-jxsygzzjlmx/pcm-jxsygzzjlmx-service'));
        this.allEntityService.set('ormpost', () => import('@/service/orm-post/orm-post-service'));
        this.allEntityService.set('pcmydtxmx', () => import('@/service/pcm-ydtxmx/pcm-ydtxmx-service'));
        this.allEntityService.set('pcmxygzzkhjgjl', () => import('@/service/pcm-xygzzkhjgjl/pcm-xygzzkhjgjl-service'));
        this.allEntityService.set('pcmydgzmx', () => import('@/service/pcm-ydgzmx/pcm-ydgzmx-service'));
        this.allEntityService.set('ormorg', () => import('@/service/orm-org/orm-org-service'));
        this.allEntityService.set('pimdistirbution', () => import('@/service/pim-distirbution/pim-distirbution-service'));
        this.allEntityService.set('personstatemgr', () => import('@/service/person-state-mgr/person-state-mgr-service'));
        this.allEntityService.set('pcmxygzzsqmx', () => import('@/service/pcm-xygzzsqmx/pcm-xygzzsqmx-service'));
        this.allEntityService.set('pcmyddgmx', () => import('@/service/pcm-yddgmx/pcm-yddgmx-service'));
        this.allEntityService.set('ormduty', () => import('@/service/orm-duty/orm-duty-service'));
        this.allEntityService.set('pcmtxbz', () => import('@/service/pcm-txbz/pcm-txbz-service'));
        this.allEntityService.set('pcmydjpmx', () => import('@/service/pcm-ydjpmx/pcm-ydjpmx-service'));
        this.allEntityService.set('pcmydjdmx', () => import('@/service/pcm-ydjdmx/pcm-ydjdmx-service'));
        this.allEntityService.set('pcmddsqd', () => import('@/service/pcm-ddsqd/pcm-ddsqd-service'));
        this.allEntityService.set('pcmydmx', () => import('@/service/pcm-ydmx/pcm-ydmx-service'));
        this.allEntityService.set('pcmrecruitment', () => import('@/service/pcm-recruitment/pcm-recruitment-service'));
        this.allEntityService.set('pcmtxfpsq', () => import('@/service/pcm-txfpsq/pcm-txfpsq-service'));
        this.allEntityService.set('pcmddsqdmx', () => import('@/service/pcm-ddsqdmx/pcm-ddsqdmx-service'));
        this.allEntityService.set('pcmreason', () => import('@/service/pcm-reason/pcm-reason-service'));
        this.allEntityService.set('pcmydntmx', () => import('@/service/pcm-ydntmx/pcm-ydntmx-service'));
        this.allEntityService.set('pcmydlzmx', () => import('@/service/pcm-ydlzmx/pcm-ydlzmx-service'));
        this.allEntityService.set('pcmjxszzkhjgjl', () => import('@/service/pcm-jxszzkhjgjl/pcm-jxszzkhjgjl-service'));
        this.allEntityService.set('pcmxygzzjlmx', () => import('@/service/pcm-xygzzjlmx/pcm-xygzzjlmx-service'));
        this.allEntityService.set('pcmydbxmx', () => import('@/service/pcm-ydbxmx/pcm-ydbxmx-service'));
        this.allEntityService.set('pcmnotice', () => import('@/service/pcm-notice/pcm-notice-service'));
        this.allEntityService.set('pcmprofile', () => import('@/service/pcm-profile/pcm-profile-service'));
        this.allEntityService.set('pimfaminfo', () => import('@/service/pim-faminfo/pim-faminfo-service'));
        this.allEntityService.set('pimperson', () => import('@/service/pim-person/pim-person-service'));
        this.allEntityService.set('ormorgsector', () => import('@/service/orm-orgsector/orm-orgsector-service'));
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
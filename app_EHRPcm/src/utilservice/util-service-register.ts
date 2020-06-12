/**
 * 功能服务注册中心
 *
 * @export
 * @class UtilServiceRegister
 */
export class UtilServiceRegister {

    /**
     * 所有功能服务Map
     *
     * @protected
     * @type {*}
     * @memberof UtilServiceRegister
     */
    protected allUtilService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载功能服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof UtilServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of UtilServiceRegister.
     * @memberof UtilServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof UtilServiceRegister
     */
    protected init(): void {
            }

    /**
     * 加载服务实体
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof UtilServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allUtilService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取应用实体服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof UtilServiceRegister
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
export const utilServiceRegister: UtilServiceRegister = new UtilServiceRegister();
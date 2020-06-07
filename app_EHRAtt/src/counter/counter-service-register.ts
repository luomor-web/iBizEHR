/**
 * 计数器服务注册中心
 *
 * @export
 * @class CounterServiceRegister
 */
export class CounterServiceRegister {

    /**
     * 所有计数器服务Map
     *
     * @protected
     * @type {*}
     * @memberof CounterServiceRegister
     */
    protected allCounterService: Map<string, () => Promise<any>> = new Map();

    /**
     * 已加载计数器服务Map缓存
     *
     * @protected
     * @type {Map<string, any>}
     * @memberof CounterServiceRegister
     */
    protected serviceCache: Map<string, any> = new Map();

    /**
     * Creates an instance of CounterServiceRegister.
     * @memberof CounterServiceRegister
     */
    constructor() {
        this.init();
    }

    /**
     * 初始化
     *
     * @protected
     * @memberof CounterServiceRegister
     */
    protected init(): void {
            }

    /**
     * 加载计数器服务
     *
     * @protected
     * @param {string} serviceName
     * @returns {Promise<any>}
     * @memberof CounterServiceRegister
     */
    protected async loadService(serviceName: string): Promise<any> {
        const service = this.allCounterService.get(serviceName);
        if (service) {
            return service();
        }
    }

    /**
     * 获取计数器服务
     *
     * @param {string} name
     * @returns {Promise<any>}
     * @memberof CounterServiceRegister
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
export const counterServiceRegister: CounterServiceRegister = new CounterServiceRegister();
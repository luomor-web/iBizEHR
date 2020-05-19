import { Store } from 'vuex';

/**
 * 计数器服务基类
 *
 * @export
 * @class CounterService
 */
export default class CounterService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof CounterService
     */
    private $store: Store<any> | null = null;

    /**
     * Creates an instance of CounterService.
     * 
     * @param {*} [opts={}]
     * @memberof CounterService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof CounterService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 获取计数器服务
     *
     * @protected
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof CounterService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['counterServiceRegister'].getService(name);
    }

   
}
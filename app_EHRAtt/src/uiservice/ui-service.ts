import { Store } from 'vuex';

/**
 * 界面服务基类
 *
 * @export
 * @class UIService
 */
export default class UIService {

    /**
     * Vue 状态管理器
     *
     * @private
     * @type {(any | null)}
     * @memberof UIService
     */
    private $store: Store<any> | null = null;

    /**
     * Creates an instance of UIService.
     * 
     * @param {*} [opts={}]
     * @memberof UIService
     */
    constructor(opts: any = {}) {
        this.$store = opts.$store;
    }

    /**
     * 获取状态管理器
     *
     * @returns {(any | null)}
     * @memberof UIService
     */
    public getStore(): Store<any> | null {
        return this.$store;
    }

    /**
     * 获取UI实体服务
     *
     * @protected
     * @param {string} name 实体名称
     * @returns {Promise<any>}
     * @memberof UIService
     */
    public getService(name: string): Promise<any> {
        return (window as any)['uiServiceRegister'].getService(name);
    }

   
}
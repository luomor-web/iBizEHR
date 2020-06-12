import mockAdapter1 from 'axios-mock-adapter';
import axios from 'axios';


/**
 * Http net 对象
 * 调用 getInstance() 获取实例
 *
 * @class Http
 */
export class MockAdapter {

    /**
     * Creates an instance of MockAdapter.
     * 
     * @memberof MockAdapter
     */
    private constructor() {
    }

    /**
     * 获取 Http 单例对象
     *
     * @static
     * @returns {Http}
     * @memberof Http
     */
    public static getInstance(): mockAdapter1 {
        if (!MockAdapter.mockAdapter) {
            MockAdapter.mockAdapter = new mockAdapter1(axios,{delayResponse:500});
        }
        return this.mockAdapter;
    }

    /**
     * 模拟请求结果状态
     *
     * @static
     * @param {*} config
     * @returns {number}
     * @memberof MockAdapter
     */
    public static  mockStatus(config: any): number {
        let status = 200;
        const { headers: _headers } = config;
        // status = _headers.Authorization && !Object.is(_headers.Authorization, '') ? 200 : 401;
        return status;
    }

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {Http}
     * @memberof Http
     */
    private static mockAdapter: mockAdapter1;
}
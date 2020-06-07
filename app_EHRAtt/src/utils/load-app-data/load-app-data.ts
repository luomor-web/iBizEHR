import { Http } from '../http/http';
import { Store } from 'vuex';

/**
 * LoadAppData 对象
 * 调用 getInstance() 获取实例
 *
 * @class LoadAppData
 */
export class LoadAppData {

    /**
     * 唯一实例
     *
     * @private
     * @static
     * @type {LoadAppData}
     * @memberof LoadAppData
     */
    private static readonly instance: LoadAppData = new LoadAppData();

    /**
     * Creates an instance of LoadAppData.
     * 私有构造，拒绝通过 new 创建对象
     * @memberof LoadAppData
     */
    private constructor() {
        if (LoadAppData.instance) {
            return LoadAppData.instance;
        }
    }

    /**
     * 获取 LoadAppData 单例对象
     *
     * @static
     * @returns {LoadAppData}
     * @memberof LoadAppData
     */
    public static getInstance(): LoadAppData {
        return this.instance;
    }

    /**
     * 数据加载
     *
     * @returns {Promise<any>}
     * @memberof LoadAppData
     */
    public async load(store: Store<any>): Promise<any> {
        const url = `./assets/json/data-dictionary.json`;
        let response: any = await Http.getInstance().get(url)
        if (response && response.status === 200 && response.data && Array.isArray(response.data)) {
            const datas: any[] = [...response.data];
            datas.forEach((item: any) => {
                if (!item.items) {
                    item.items = [];
                }
            });
            store.commit('addCodeLists', datas);
        }
        return response;
    }

}
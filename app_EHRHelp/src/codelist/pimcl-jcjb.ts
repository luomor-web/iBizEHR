import CodeItemService from '@service/code-item/code-item-service';
/**
 * 代码表--奖惩级别
 *
 * @export
 * @class PIMCL_JCJB
 */
export default class PIMCL_JCJB {

    /**
     * 是否启用缓存
     *
     * @type boolean
     * @memberof PIMCL_JCJB
     */
    public isEnableCache:boolean = true;

    /**
     * 过期时间
     *
     * @type any
     * @memberof PIMCL_JCJB
     */
    public expirationTime:any;

    /**
     * 缓存超长时长
     *
     * @type any
     * @memberof PIMCL_JCJB
     */
    public cacheTimeout:any = -1;

    /**
     * 代码表模型对象
     *
     * @type any
     * @memberof PIMCL_JCJB
     */
    public codelistModel:any = {
        codelistid:"PIMCL_JCJB"
    };

    /**
     * 自定义参数集合
     *
     * @type any
     * @memberof PIMCL_JCJB
     */
    public userParamNames:any ={
        codelistid:"04E890C0-603A-4C45-8D8F-8CBE869AB4AA"
    }

    /**
     * 查询参数集合
     *
     * @type any
     * @memberof PIMCL_JCJB
     */
    public queryParamNames:any ={
    }

    /**
     * 代码项***应用实体服务对象
     *
     * @type {CodeItemService}
     * @memberof PIMCL_JCJB
     */
    public codeitemService: CodeItemService = new CodeItemService();


    /**
     * 获取数据项
     *
     * @param {string} context 
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMCL_JCJB
     */
    public getItems(context:any = {}, data: any={}, isloading?: boolean): Promise<any> {
        return new Promise((resolve, reject) => {
            data = this.handleQueryParam(data);
            const promise: Promise<any> = this.codeitemService.FetchCurCL(context, data, isloading);
            promise.then((response: any) => {
                if (response && response.status === 200) {
                    const data =  response.data;
                    resolve(this.doItems(data));
                } else {
                    resolve([]);
                }
            }).catch((response: any) => {
                console.error(response);
                reject(response);
            });
        });
    }

    /**
     * 处理数据
     *
     * @public
     * @param {any[]} items
     * @returns {any[]}
     * @memberof PIMCL_JCJB
     */
    public doItems(items: any[]): any[] {
        let _items: any[] = [];
        items.forEach((item: any) => {
            let itemdata:any = {};
            Object.assign(itemdata,{id:item.codeitemvalue});
            Object.assign(itemdata,{value:item.codeitemvalue});
            Object.assign(itemdata,{text:item.codeitemname});
            
            _items.push(itemdata);
        });
        return _items;
    }

    /**
     * 处理查询参数
     * @param data 传入data
     * @memberof PIMCL_JCJB
     */
    public handleQueryParam(data:any){
        let tempData:any = data?JSON.parse(JSON.stringify(data)):{};
        if(this.userParamNames && Object.keys(this.userParamNames).length >0){
            Object.keys(this.userParamNames).forEach((name: string) => {
                if (!name) {
                    return;
                }
                let value: string | null = this.userParamNames[name];
                if (value && value.startsWith('%') && value.endsWith('%')) {
                    const key = value.substring(1, value.length - 1);
                    if (this.codelistModel && this.codelistModel.hasOwnProperty(key)) {
                        value = (this.codelistModel[key] !== null && this.codelistModel[key] !== undefined) ? this.codelistModel[key] : null;
                    } else {
                        value = null;
                    }
                }
                Object.assign(tempData, { [name]: value });
            });
        }
        Object.assign(tempData,{page: 0, size: 1000});
        if(this.queryParamNames && Object.keys(this.queryParamNames).length > 0){
            Object.assign(tempData,this.queryParamNames);
        }
        return tempData;
    }
}

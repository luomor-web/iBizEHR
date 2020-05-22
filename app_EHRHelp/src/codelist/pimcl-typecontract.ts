import PIMTYPECONTRACTService from '@service/pimtypecontract/pimtypecontract-service';
/**
 * 代码表--合同类型
 *
 * @export
 * @class PIMCL_TYPECONTRACT
 */
export default class PIMCL_TYPECONTRACT {

    /**
     * 是否启用缓存
     *
     * @type boolean
     * @memberof PIMCL_TYPECONTRACT
     */
    public isEnableCache:boolean = true;

    /**
     * 过期时间
     *
     * @type any
     * @memberof PIMCL_TYPECONTRACT
     */
    public expirationTime:any;

    /**
     * 缓存超长时长
     *
     * @type any
     * @memberof PIMCL_TYPECONTRACT
     */
    public cacheTimeout:any = -1;

    /**
     * 代码表模型对象
     *
     * @type any
     * @memberof PIMCL_TYPECONTRACT
     */
    public codelistModel:any = {
        codelistid:"PIMCL_TYPECONTRACT"
    };

    /**
     * 自定义参数集合
     *
     * @type any
     * @memberof PIMCL_TYPECONTRACT
     */
    public userParamNames:any ={
    }

    /**
     * 查询参数集合
     *
     * @type any
     * @memberof PIMCL_TYPECONTRACT
     */
    public queryParamNames:any ={
        sort: 'typecode,asc'
    }

    /**
     * 合同类型应用实体服务对象
     *
     * @type {PIMTYPECONTRACTService}
     * @memberof PIMCL_TYPECONTRACT
     */
    public pimtypecontractService: PIMTYPECONTRACTService = new PIMTYPECONTRACTService();


    /**
     * 处理数据
     *
     * @public
     * @param {any[]} items
     * @returns {any[]}
     * @memberof PIMCL_TYPECONTRACT
     */
    public doItems(items: any[]): any[] {
        let _items: any[] = [];
        items.forEach((item: any) => {
            let itemdata:any = {};
            Object.assign(itemdata,{id:item.typecode});
            Object.assign(itemdata,{value:item.typecode});
            Object.assign(itemdata,{text:item.pimtypecontractname});
            
            _items.push(itemdata);
        });
        return _items;
    }

    /**
     * 获取数据项
     *
     * @param {*} context
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMCL_TYPECONTRACT
     */
    public getItems(context: any={}, data: any={}, isloading?: boolean): Promise<any> {
        return new Promise((resolve, reject) => {
            data = this.handleQueryParam(data);
            const promise: Promise<any> = this.pimtypecontractService.FetchDefault(context, data, isloading);
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
     * 处理查询参数
     * @param data 传入data
     * @memberof PIMCL_TYPECONTRACT
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

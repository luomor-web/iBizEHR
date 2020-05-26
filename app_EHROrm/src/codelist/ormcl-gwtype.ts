/**
 * 代码表--岗位类型
 *
 * @export
 * @class ORMCL_GWTYPE
 */
export default class ORMCL_GWTYPE {

    /**
     * 是否启用缓存
     *
     * @type boolean
     * @memberof ORMCL_GWTYPE
     */
    public isEnableCache:boolean = true;

    /**
     * 过期时间
     *
     * @type any
     * @memberof ORMCL_GWTYPE
     */
    public expirationTime:any;

    /**
     * 缓存超长时长
     *
     * @type any
     * @memberof ORMCL_GWTYPE
     */
    public cacheTimeout:any = -1;

    /**
     * 代码表模型对象
     *
     * @type any
     * @memberof ORMCL_GWTYPE
     */
    public codelistModel:any = {
        codelistid:"ORMCL_GWTYPE"
    };

    /**
     * 自定义参数集合
     *
     * @type any
     * @memberof ORMCL_GWTYPE
     */
    public userParamNames:any ={
        codelistid:"2CCD80BB-B7B5-4B84-83E6-FF9AB96D3490"
    }

    /**
     * 查询参数集合
     *
     * @type any
     * @memberof ORMCL_GWTYPE
     */
    public queryParamNames:any ={
    }



    /**
     * 获取数据项
     *
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMCL_GWTYPE
     */
    public getItems(data: any={}, isloading?: boolean): Promise<any> {
        return Promise.reject([]);
    }

    /**
     * 处理查询参数
     * @param data 传入data
     * @memberof ORMCL_GWTYPE
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

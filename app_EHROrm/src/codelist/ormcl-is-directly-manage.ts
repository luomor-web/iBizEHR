/**
 * 代码表--是否局直管
 *
 * @export
 * @class ORMCL_IsDirectlyManage
 */
export default class ORMCL_IsDirectlyManage {

    /**
     * 是否启用缓存
     *
     * @type boolean
     * @memberof ORMCL_IsDirectlyManage
     */
    public isEnableCache:boolean = true;

    /**
     * 过期时间
     *
     * @type any
     * @memberof ORMCL_IsDirectlyManage
     */
    public expirationTime:any;

    /**
     * 缓存超长时长
     *
     * @type any
     * @memberof ORMCL_IsDirectlyManage
     */
    public cacheTimeout:any = -1;

    /**
     * 代码表模型对象
     *
     * @type any
     * @memberof ORMCL_IsDirectlyManage
     */
    public codelistModel:any = {
        codelistid:"ORMCL_IsDirectlyManage"
    };

    /**
     * 自定义参数集合
     *
     * @type any
     * @memberof ORMCL_IsDirectlyManage
     */
    public userParamNames:any ={
        codelistid:"CA563B65-A0DD-4F9C-A279-984EF5225D87"
    }

    /**
     * 查询参数集合
     *
     * @type any
     * @memberof ORMCL_IsDirectlyManage
     */
    public queryParamNames:any ={
    }



    /**
     * 获取数据项
     *
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMCL_IsDirectlyManage
     */
    public getItems(data: any={}, isloading?: boolean): Promise<any> {
        return Promise.reject([]);
    }

    /**
     * 处理查询参数
     * @param data 传入data
     * @memberof ORMCL_IsDirectlyManage
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

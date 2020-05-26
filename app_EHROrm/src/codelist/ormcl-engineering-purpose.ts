/**
 * 代码表--工程用途
 *
 * @export
 * @class ORMCL_EngineeringPurpose
 */
export default class ORMCL_EngineeringPurpose {

    /**
     * 是否启用缓存
     *
     * @type boolean
     * @memberof ORMCL_EngineeringPurpose
     */
    public isEnableCache:boolean = true;

    /**
     * 过期时间
     *
     * @type any
     * @memberof ORMCL_EngineeringPurpose
     */
    public expirationTime:any;

    /**
     * 缓存超长时长
     *
     * @type any
     * @memberof ORMCL_EngineeringPurpose
     */
    public cacheTimeout:any = -1;

    /**
     * 代码表模型对象
     *
     * @type any
     * @memberof ORMCL_EngineeringPurpose
     */
    public codelistModel:any = {
        codelistid:"ORMCL_EngineeringPurpose"
    };

    /**
     * 自定义参数集合
     *
     * @type any
     * @memberof ORMCL_EngineeringPurpose
     */
    public userParamNames:any ={
        codelistid:"7273FBF6-657A-47E3-B5C4-76C0771BE8A2"
    }

    /**
     * 查询参数集合
     *
     * @type any
     * @memberof ORMCL_EngineeringPurpose
     */
    public queryParamNames:any ={
    }



    /**
     * 获取数据项
     *
     * @param {*} data
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMCL_EngineeringPurpose
     */
    public getItems(data: any={}, isloading?: boolean): Promise<any> {
        return Promise.reject([]);
    }

    /**
     * 处理查询参数
     * @param data 传入data
     * @memberof ORMCL_EngineeringPurpose
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

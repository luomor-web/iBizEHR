import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 社保缴费记录服务对象基类
 *
 * @export
 * @class SocRecordServiceBase
 * @extends {EntityServie}
 */
export default class SocRecordServiceBase extends EntityService {

    /**
     * Creates an instance of  SocRecordServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SocRecordServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof SocRecordServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='socrecord';
        this.APPDEKEY = 'socrecordid';
        this.APPDENAME = 'socrecords';
        this.APPDETEXT = 'socrecordname';
        this.APPNAME = 'ehrsoc';
        this.SYSTEMNAME = 'ehr';
    }

// 实体接口

    /**
     * Select接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRecordServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/socrecords/${context.socrecord}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof SocRecordServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/socrecords/select`,tempData,isloading);
    }
}
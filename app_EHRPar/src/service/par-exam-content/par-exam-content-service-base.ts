import { Http,Util } from '@/utils';
import EntityService from '../entity-service';



/**
 * 考核内容服务对象基类
 *
 * @export
 * @class ParExamContentServiceBase
 * @extends {EntityServie}
 */
export default class ParExamContentServiceBase extends EntityService {

    /**
     * Creates an instance of  ParExamContentServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ParExamContentServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
    }

    /**
     * 初始化基础数据
     *
     * @memberof ParExamContentServiceBase
     */
    public initBasicData(){
        this.APPLYDEKEY ='parexamcontent';
        this.APPDEKEY = 'parexamcontentid';
        this.APPDENAME = 'parexamcontents';
        this.APPDETEXT = 'parexamcontentname';
        this.APPNAME = 'ehrpar';
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
     * @memberof ParExamContentServiceBase
     */
    public async Select(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
            return Http.getInstance().get(`/parexamcontents/${context.parexamcontent}/select`,isloading);
    }

    /**
     * FetchDefault接口方法
     *
     * @param {*} [context={}]
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ParExamContentServiceBase
     */
    public async FetchDefault(context: any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let tempData:any = JSON.parse(JSON.stringify(data));
        return Http.getInstance().get(`/parexamcontents/select`,tempData,isloading);
    }
}
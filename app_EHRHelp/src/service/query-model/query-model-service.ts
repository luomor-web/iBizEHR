import { Http,Util } from '@/utils';
import QueryModelServiceBase from './query-model-service-base';


/**
 * 实体查询模型服务对象
 *
 * @export
 * @class QueryModelService
 * @extends {QueryModelServiceBase}
 */
export default class QueryModelService extends QueryModelServiceBase {

    /**
     * Creates an instance of  QueryModelService.
     * 
     * @param {*} [opts={}]
     * @memberof  QueryModelService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
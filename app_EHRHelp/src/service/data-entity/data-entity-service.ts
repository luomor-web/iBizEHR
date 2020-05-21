import { Http,Util } from '@/utils';
import DataEntityServiceBase from './data-entity-service-base';


/**
 * 实体服务对象
 *
 * @export
 * @class DataEntityService
 * @extends {DataEntityServiceBase}
 */
export default class DataEntityService extends DataEntityServiceBase {

    /**
     * Creates an instance of  DataEntityService.
     * 
     * @param {*} [opts={}]
     * @memberof  DataEntityService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
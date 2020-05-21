import { Http,Util } from '@/utils';
import ORMRelationServiceBase from './ormrelation-service-base';


/**
 * 组织管理关系表服务对象
 *
 * @export
 * @class ORMRelationService
 * @extends {ORMRelationServiceBase}
 */
export default class ORMRelationService extends ORMRelationServiceBase {

    /**
     * Creates an instance of  ORMRelationService.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMRelationService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
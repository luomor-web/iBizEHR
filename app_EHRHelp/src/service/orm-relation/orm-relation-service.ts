import { Http,Util } from '@/utils';
import OrmRelationServiceBase from './orm-relation-service-base';


/**
 * 组织管理关系表服务对象
 *
 * @export
 * @class OrmRelationService
 * @extends {OrmRelationServiceBase}
 */
export default class OrmRelationService extends OrmRelationServiceBase {

    /**
     * Creates an instance of  OrmRelationService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmRelationService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
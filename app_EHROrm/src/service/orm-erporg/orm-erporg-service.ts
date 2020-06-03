import { Http,Util } from '@/utils';
import OrmErporgServiceBase from './orm-erporg-service-base';


/**
 * ERP组织中间表服务对象
 *
 * @export
 * @class OrmErporgService
 * @extends {OrmErporgServiceBase}
 */
export default class OrmErporgService extends OrmErporgServiceBase {

    /**
     * Creates an instance of  OrmErporgService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmErporgService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
import { Http,Util } from '@/utils';
import ORMERPORGServiceBase from './ormerporg-service-base';


/**
 * ERP组织中间表服务对象
 *
 * @export
 * @class ORMERPORGService
 * @extends {ORMERPORGServiceBase}
 */
export default class ORMERPORGService extends ORMERPORGServiceBase {

    /**
     * Creates an instance of  ORMERPORGService.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMERPORGService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
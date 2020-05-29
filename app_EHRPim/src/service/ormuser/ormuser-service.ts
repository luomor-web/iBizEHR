import { Http,Util } from '@/utils';
import ORMUSERServiceBase from './ormuser-service-base';


/**
 * 用户管理服务对象
 *
 * @export
 * @class ORMUSERService
 * @extends {ORMUSERServiceBase}
 */
export default class ORMUSERService extends ORMUSERServiceBase {

    /**
     * Creates an instance of  ORMUSERService.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMUSERService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
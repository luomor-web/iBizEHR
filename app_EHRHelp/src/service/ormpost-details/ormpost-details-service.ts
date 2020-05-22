import { Http,Util } from '@/utils';
import ORMPostDetailsServiceBase from './ormpost-details-service-base';


/**
 * 岗位明细服务对象
 *
 * @export
 * @class ORMPostDetailsService
 * @extends {ORMPostDetailsServiceBase}
 */
export default class ORMPostDetailsService extends ORMPostDetailsServiceBase {

    /**
     * Creates an instance of  ORMPostDetailsService.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMPostDetailsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
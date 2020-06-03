import { Http,Util } from '@/utils';
import OrmPostDetailsServiceBase from './orm-post-details-service-base';


/**
 * 岗位明细服务对象
 *
 * @export
 * @class OrmPostDetailsService
 * @extends {OrmPostDetailsServiceBase}
 */
export default class OrmPostDetailsService extends OrmPostDetailsServiceBase {

    /**
     * Creates an instance of  OrmPostDetailsService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmPostDetailsService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
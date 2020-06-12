import { Http,Util } from '@/utils';
import OrmOrgsectorServiceBase from './orm-orgsector-service-base';


/**
 * 部门管理服务对象
 *
 * @export
 * @class OrmOrgsectorService
 * @extends {OrmOrgsectorServiceBase}
 */
export default class OrmOrgsectorService extends OrmOrgsectorServiceBase {

    /**
     * Creates an instance of  OrmOrgsectorService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgsectorService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
import { Http,Util } from '@/utils';
import OrmPostServiceBase from './orm-post-service-base';


/**
 * 岗位服务对象
 *
 * @export
 * @class OrmPostService
 * @extends {OrmPostServiceBase}
 */
export default class OrmPostService extends OrmPostServiceBase {

    /**
     * Creates an instance of  OrmPostService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmPostService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
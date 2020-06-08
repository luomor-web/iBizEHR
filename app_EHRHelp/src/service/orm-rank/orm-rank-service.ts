import { Http,Util } from '@/utils';
import OrmRankServiceBase from './orm-rank-service-base';


/**
 * 职级管理服务对象
 *
 * @export
 * @class OrmRankService
 * @extends {OrmRankServiceBase}
 */
export default class OrmRankService extends OrmRankServiceBase {

    /**
     * Creates an instance of  OrmRankService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmRankService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}
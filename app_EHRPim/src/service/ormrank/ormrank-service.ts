import { Http,Util } from '@/utils';
import ORMRANKServiceBase from './ormrank-service-base';


/**
 * 职级管理服务对象
 *
 * @export
 * @class ORMRANKService
 * @extends {ORMRANKServiceBase}
 */
export default class ORMRANKService extends ORMRANKServiceBase {

    /**
     * Creates an instance of  ORMRANKService.
     * 
     * @param {*} [opts={}]
     * @memberof  ORMRANKService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}